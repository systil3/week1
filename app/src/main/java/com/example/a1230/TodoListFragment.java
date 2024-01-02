package com.example.a1230;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import android.database.Cursor;
import android.os.Bundle;

public class TodoListFragment extends Fragment {

    private Integer dept_Id;
    private Button addButton;
    private Button deleteButton;
    private ListView todoListView;
    private Context context;
    private FragmentManager fragmentManager;
    private TodoAdapter todoAdapter;
    private ArrayList<TodoItem> todoItems;
    private TodoItemDB todoItemDB;

    public TodoListFragment(FragmentManager fragmentManager,
                            Context context, Integer dept_Id) {
        this.fragmentManager = fragmentManager;
        this.context = context;
        this.dept_Id = dept_Id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todo_list, container, false);

        // UI 요소 초기화
        addButton = view.findViewById(R.id.addButton);
        todoListView = view.findViewById(R.id.todoListView);

        //현재 부서에 속한 TodoItem 개체들 읽어와서 표시
        todoItemDB = TodoItemDB.getInstance(context);
        todoItems = (ArrayList<TodoItem>) todoItemDB.todoItemDao()
                .selectAllTodoItemsInDept(dept_Id);

        todoItems.sort((t1, t2) -> {
            if(t1.getCompleted() != t2.getCompleted()) {
                return t1.getCompleted() ? 0 : 1;
            } else {
                return t1.getTask().compareTo(t2.getTask());
            }
        });
        todoAdapter = new TodoAdapter(context, todoItems);
        todoAdapter.setNotifyOnChange(true);
        todoListView.setAdapter(todoAdapter);

        // "Add" 버튼 클릭 시 현재 있는 부서를 dept_id 외래키로 가지는 TodoItem 개체를 db에 추가
        // TodoAdapter에서 최근에 수정한 TodoItem 정보를 가져와 해당 개체만 저장하기
        // (실수로 저장 버튼 안누르고 새로 생성했을 때 content 날아가는 일을 방지)

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer currentFocusingPos = todoAdapter.getCurrentFocusingPos();
                //Log.w("Focusing", String.valueOf(currentFocusingPos));
                TodoItem todoItemToUpdate = (currentFocusingPos != -1) ?
                        todoItems.get(currentFocusingPos) : null;
                class InsertRunnable implements Runnable {
                    @Override
                    public void run() {
                        try {
                            if(todoItemToUpdate != null)
                                todoItemDB.todoItemDao().update(todoItemToUpdate);
                            TodoItem newTodoItem = new TodoItem(dept_Id, "",false);
                            todoItemDB.todoItemDao().insertAll(newTodoItem);
                        } catch (Exception e) {
                            Log.w("error in new thread2", e);
                        }
                    }
                } Thread t = new Thread(new InsertRunnable()); t.start();

                //화면 새로고침
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                TodoListFragment refreshedTodoListFragment = new TodoListFragment(
                        fragmentManager, context, dept_Id);
                fragmentTransaction.replace(R.id.fragment_container, refreshedTodoListFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}




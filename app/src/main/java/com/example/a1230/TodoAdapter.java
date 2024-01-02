package com.example.a1230;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.widget.AppCompatImageButton;

import java.util.List;

public class TodoAdapter extends ArrayAdapter<TodoItem> {

    private Integer currentFocusingPos;
    public TodoAdapter(Context context, List<TodoItem> todoItems) {
        super(context, 0, todoItems);
        currentFocusingPos = -1;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // 리스트 아이템 뷰 재사용
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.todo_list_item, parent, false);
        }

        // 현재 위치에 해당하는 TodoItem 가져오기
        final TodoItem todoItem = getItem(position);
        // 뷰 초기화
        EditText todoEditText = convertView.findViewById(R.id.todoEditText);
        ImageButton deleteButton = convertView.findViewById(R.id.deleteButton);
        ImageButton confirmButton = convertView.findViewById(R.id.confirmButton);
        CheckBox todoCompletedCheckBox = convertView.findViewById(R.id.todoCompletedCheckBox);

        class UpdateRunnable implements Runnable {
            @Override
            public void run() {
                try {
                    TodoItemDB todoItemDB = TodoItemDB.getInstance(getContext());
                    todoItemDB.todoItemDao().update(todoItem);
                } catch (Exception e) {
                    Log.w("error in new thread2", e);
                }
            }
        }
        // TodoItem 데이터를 뷰에 설정
        todoEditText.setText(todoItem.getTask());

        //focus 상태 해제되면 자동 저장 후 DB에 입력
        todoEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    currentFocusingPos = position;
                }
                else {
                    String newText = todoEditText.getText().toString();
                    todoItem.setTask(newText);
                    Thread t = new Thread(new UpdateRunnable()); t.start();
                }
            }
        });
        // 삭제 버튼 클릭 이벤트 처리
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 해당 위치의 항목 삭제
                TodoItem todoItemToDelete = getItem(position);
                remove(todoItemToDelete);
                notifyDataSetChanged();

                class InsertRunnable implements Runnable {
                    @Override
                    public void run() {
                        try {
                            TodoItemDB todoItemDB = TodoItemDB.getInstance(getContext());
                            todoItemDB.todoItemDao().delete(todoItemToDelete);
                        } catch (Exception e) {
                            Log.w("error in new thread2", e);
                        }
                    }
                } Thread t = new Thread(new InsertRunnable()); t.start();
            }
        });

        //저장 기능
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set the task in todoItem in view
                String content = todoEditText.getText().toString();
                todoItem.setTask(todoEditText.getText().toString());

                Thread t = new Thread(new UpdateRunnable()); t.start();
            }
        });

        //완료 / 미완료 상태 표시 및 완료 상태로 전환 기능
        todoCompletedCheckBox.setChecked(todoItem.getCompleted());
        todoCompletedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.w("checked", String.valueOf(isChecked));
                if(buttonView.getId() == R.id.todoCompletedCheckBox) {
                    if(isChecked) {
                        todoItem.setAsCompleted();
                    } else {
                        todoItem.setAsUncompleted();
                    } Thread t = new Thread(new UpdateRunnable()); t.start();
                }
            }
        });

        return convertView;
    }
    public Integer getCurrentFocusingPos() {
        return currentFocusingPos;
    }
}
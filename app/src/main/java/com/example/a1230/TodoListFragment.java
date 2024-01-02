package com.example.a1230;

import android.os.Bundle;
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

import java.util.ArrayList;
import android.database.Cursor;
import android.os.Bundle;

public class TodoListFragment extends Fragment {

    private Button addButton;
    private Button backButton;
    private ListView todoListView;

    private TodoAdapter todoAdapter;
    private ArrayList<TodoItem> todoItems;

    public TodoListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todo_list, container, false);

        // UI 요소 초기화
        addButton = view.findViewById(R.id.addButton);
        todoListView = view.findViewById(R.id.todoListView);
        backButton = requireActivity().findViewById(R.id.BackButton);

        todoItems = new ArrayList<>();
        todoAdapter = new TodoAdapter(requireContext(), todoItems);
        todoListView.setAdapter(todoAdapter);


        // 추가 버튼 클릭 시 이벤트 처리
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // "Add" 버튼 클릭 시 빈 Todo 항목 추가
                todoAdapter.add(new TodoItem("",false));

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.popBackStack();
            }
        });


        return view;
    }

}




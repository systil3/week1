package com.example.a1230;

import static androidx.core.content.ContentProviderCompat.requireContext;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.widget.AppCompatImageButton;

import java.util.List;

public class TodoAdapter extends ArrayAdapter<TodoItem> {

    public TodoAdapter(Context context, List<TodoItem> todoItems) {
        super(context, 0, todoItems);
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
        Button deleteButton = convertView.findViewById(R.id.deleteButton);
        Button confirmButton = convertView.findViewById(R.id.confirmButton);

        // TodoItem 데이터를 뷰에 설정
        todoEditText.setText(todoItem.getTask());

        // 삭제 버튼 클릭 이벤트 처리
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 해당 위치의 항목 삭제
                remove(getItem(position));
                notifyDataSetChanged();
            }
        });

        // 확인 버튼 클릭 이벤트 처리
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todoItem.setTask(todoEditText.getText().toString());
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
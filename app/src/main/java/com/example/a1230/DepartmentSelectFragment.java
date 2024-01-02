package com.example.a1230;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DepartmentSelectFragment extends Fragment {

    private Context context;
    private FragmentManager fragmentManager;
    public DepartmentSelectFragment(FragmentManager fragmentManager, Context context) {
        this.fragmentManager = fragmentManager;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_department_select, container, false);
        AppCompatButton management_button = view.findViewById(R.id.management_button);
        AppCompatButton general_affairs_button = view.findViewById(R.id.general_affairs_button);
        AppCompatButton accounting_button = view.findViewById(R.id.accounting_button);
        AppCompatButton machinary_button = view.findViewById(R.id.machinary_button);
        AppCompatButton technical_research_button = view.findViewById(R.id.technical_research_button);
        AppCompatButton human_resources_button = view.findViewById(R.id.human_resources_button);
        AppCompatButton system_management_button = view.findViewById(R.id.system_management_button);
        AppCompatButton facility_management_button = view.findViewById(R.id.facility_management_button);

        management_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, new TodoListFragment(fragmentManager, context,0));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        general_affairs_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, new TodoListFragment(fragmentManager, context,1));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        accounting_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, new TodoListFragment(fragmentManager, context,2));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        machinary_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, new TodoListFragment(fragmentManager, context,3));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        technical_research_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, new TodoListFragment(fragmentManager, context,4));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        human_resources_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, new TodoListFragment(fragmentManager, context,5));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        system_management_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, new TodoListFragment(fragmentManager, context,6));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        facility_management_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, new TodoListFragment(fragmentManager, context,7));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}
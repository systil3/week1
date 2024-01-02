package com.example.a1230;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class DepartmentSelectFragment extends Fragment {

    public DepartmentSelectFragment() {
        // Required empty public constructor
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
        Button backButton = requireActivity().findViewById(R.id.BackButton);

        management_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, new TodoListFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        general_affairs_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, new TodoListFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        accounting_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, new TodoListFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        machinary_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, new TodoListFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        technical_research_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, new TodoListFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        human_resources_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, new TodoListFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        system_management_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, new TodoListFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        facility_management_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, new TodoListFragment());
                transaction.addToBackStack(null);
                transaction.commit();
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
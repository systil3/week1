package com.example.a1230;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
public class ImageGridFragment extends Fragment {

    public ImageGridFragment() {

    }
    private int[] imageIDs = new int[] {
            R.drawable.gallery_image_01,
            R.drawable.gallery_image_02,
            R.drawable.gallery_image_03,
            R.drawable.gallery_image_04,
            R.drawable.gallery_image_05,
            R.drawable.gallery_image_06,
            R.drawable.gallery_image_07,
            R.drawable.gallery_image_08,
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 프래그먼트 클래스에는 해당 프래그먼트의 레이아웃을 가져오기 위한 onCreateView
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_imagegrid, container, false);
        GridView gridView = (GridView) rootview.findViewById(R.id.gridview);
        ImageGridAdapter adapter = new ImageGridAdapter(requireContext(),imageIDs);
        gridView.setAdapter(adapter);
        Button backButton= requireActivity().findViewById(R.id.BackButton);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int selectedImageResource = imageIDs[position];
                ImageFragment imageFragment = new ImageFragment();
                Bundle args = new Bundle();
                args.putInt("imageResource", selectedImageResource);
                imageFragment.setArguments(args);

                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, imageFragment);
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

        return rootview;
    }
}
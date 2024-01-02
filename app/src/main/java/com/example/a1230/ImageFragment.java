package com.example.a1230;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ImageFragment extends Fragment {
    private Context context;
    private FragmentManager fragmentManager;
    public ImageFragment(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_image, container, false);
        Bundle args = getArguments();
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageview);
        String uri = args != null ? args.getString("imageUri", "") : "";

        Glide.with(context)
                .load(uri)
                .into(imageView);
        return rootView;
    }

    //former version using test data(obsolete now)
    /*public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_image, container, false);
        Bundle args = getArguments();
        if (args != null) {
            int imageResource = args.getInt("imageResource", 0);
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageview);
            imageView.setImageResource(imageResource);
        }
        return rootView;
    }*/

}
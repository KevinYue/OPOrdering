package com.example.opordering;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class AddnewsFragment extends Fragment {

    private ImageView addNewsPosterImage;

    public AddnewsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_addnews, container, false);

        addNewsPosterImage = view.findViewById(R.id.addImageButton);

        chooseImage();

        return view;
    }

    private void chooseImage() {

    }
}
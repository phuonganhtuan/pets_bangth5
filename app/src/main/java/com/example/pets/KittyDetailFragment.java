package com.example.pets;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pets.adapter.KittyAdapter;
import com.example.pets.listener.ItemClickListener;
import com.example.pets.listener.PagingnationScrollListener;

import java.util.ArrayList;

public class KittyDetailFragment extends Activity {

//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        inflater.inflate(R.layout.item_kitty_detail, container, false);
//        return super.onCreateView(inflater, container, savedInstanceState);
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_kitty_detail);

    }

}

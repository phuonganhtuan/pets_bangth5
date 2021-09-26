package com.example.pets.listener;

import com.example.pets.model.Kitty;

import java.util.ArrayList;

public interface FectDataCallBack {
    void onFetchSuccess(ArrayList<Kitty> list);
    void onFetchFault(Exception e);
}

package com.example.pets;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.pets.listener.ItemDAO;
import com.example.pets.model.ItemKittyLiked;
import com.example.pets.model.Kitty;

@Database(entities = {ItemKittyLiked.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDAO getItemDAO();
}

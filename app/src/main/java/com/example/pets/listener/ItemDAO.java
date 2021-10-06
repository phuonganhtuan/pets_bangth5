package com.example.pets.listener;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import com.example.pets.model.ItemKittyLiked;
import com.example.pets.model.Kitty;

import android.arch.persistence.room.Query;
import java.util.List;

@Dao
public interface ItemDAO {
    @Insert
    public void insert(ItemKittyLiked... items);
    @Update
    public void update(ItemKittyLiked... items);
    @Delete
    public void delete(ItemKittyLiked item);

    @Query("SELECT * FROM items")
    public List<ItemKittyLiked> getItems();

    @Query("SELECT * FROM items WHERE id = :id")
    public ItemKittyLiked getItemById(String id);
}

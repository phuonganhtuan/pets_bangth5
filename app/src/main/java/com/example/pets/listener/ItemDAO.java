package com.example.pets.listener;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import com.example.pets.Item;
import com.example.pets.model.Kitty;

import android.arch.persistence.room.Query;
import java.util.List;

@Dao
public interface ItemDAO {
    @Insert
    public void insert(Kitty... items);
    @Update
    public void update(Kitty... items);
    @Delete
    public void delete(Kitty item);

    @Query("SELECT * FROM items")
    public List<Kitty> getItems();

    @Query("SELECT * FROM items WHERE id = :id")
    public Item getItemById(String id);
}

package com.example.colifestote.data.dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.colifestote.data.bean.ABook;
import com.example.colifestote.data.bean.ABookItem;
import com.example.colifestote.data.bean.DiarySet;

import java.util.List;

@Dao
public interface ABookDao {

    @Insert(onConflict = REPLACE)
    void insertABook(ABook... aBooks);

    @Insert(onConflict = REPLACE)
    void insertItem(ABookItem... aBookItems);

    @Delete
    void deleteABook(ABook... aBooks);

    @Delete
    void deleteItem(ABookItem... items);

    @Update
    void updateABook(ABook... aBooks);

    @Update
    void updateItem(ABookItem item);

    @Query("SELECT * FROM aBook ORDER BY id DESC")
    LiveData<List<ABook>> getAllABook();

    @Query("SELECT * FROM aBook_item ORDER BY id DESC")
    LiveData<List<ABookItem>> getAllItem();

    @Query("SELECT `date`, COUNT(id) AS count FROM aBook GROUP BY date")
    List<DiarySet> getAbookNumByDate();

}

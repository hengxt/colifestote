package com.example.colifestote.data.dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.colifestote.data.bean.Diary;
import com.example.colifestote.data.bean.DiarySet;

import java.util.List;

@Dao
public interface DiaryDao {

    @Insert(onConflict = REPLACE)
    void insertDiary(Diary... diaries);

    @Delete
    void deleteDiary(Diary... diaries);

    @Update
    void UpdateDiary(Diary... diaries);

    @Query("SELECT * FROM diary ORDER BY id DESC")
    List<Diary> getAllDiaries();

    @Query("SELECT * FROM diary ORDER BY id DESC")
    LiveData<List<Diary>> getAllLiveDiary();

    @Query("SELECT * FROM diary WHERE id=:id ORDER BY id DESC")
    Diary getDiaryById(int id);

    @Query("SELECT `date`, COUNT(id) AS count FROM diary GROUP BY date")
    LiveData<List<DiarySet>> getDiarySet();

    @Query("SELECT `date`, COUNT(id) AS count FROM diary GROUP BY date")
    List<DiarySet> getDiaryNumByDate();

    @Query("SELECT * FROM diary WHERE date LIKE '%' || :date || '%' ORDER BY id DESC")
    LiveData<List<Diary>> getDiaryByDate(String date);

    @Query("SELECT * FROM diary WHERE date LIKE '%' || :date || '%' ORDER BY id DESC")
    List<Diary> getDiariesDate(String date);


}

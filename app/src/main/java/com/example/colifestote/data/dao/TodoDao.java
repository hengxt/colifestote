package com.example.colifestote.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.colifestote.data.bean.DiarySet;
import com.example.colifestote.data.bean.Todo;

import java.util.List;

@Dao
public interface TodoDao {

    @Insert
    void insertTodoItems(Todo... todos);

    @Delete
    void deleteTodoItems(Todo... todos);

    @Query("DELETE FROM todo")
    void deleteAllTodo();

    @Update
    void updateTodoItems(Todo... todos);

    @Query("SELECT * FROM todo ORDER BY id DESC")
    LiveData<List<Todo>> getAllStudent();

    @Query("SELECT * FROM todo WHERE id = :id ORDER BY id DESC")
    Todo getTodoById(int id);

    @Query("SELECT `date`, COUNT(id) AS count FROM todo GROUP BY date")
    List<DiarySet> getTodoNumByDate();


}

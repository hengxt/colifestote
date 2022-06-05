package com.example.colifestote.data.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.colifestote.data.bean.DiarySet;
import com.example.colifestote.data.bean.Todo;
import com.example.colifestote.data.config.MyDatabase;
import com.example.colifestote.data.dao.TodoDao;

import java.util.List;

public class TodoRepository {

    private final TodoDao todoDao;

    public TodoRepository(Context context) {
        MyDatabase instance = MyDatabase.getInstance(context);
        todoDao = instance.getTodoDao();

    }


    public void insertTodo(Todo... todos) {
        new InsertTodoTask(todoDao).execute(todos);
    }

    public void deleteTodo(Todo... todos) {
        new DeleteTodoTask(todoDao).execute(todos);
    }

    public void updateTodo(Todo... todos) {
        new UpdateTodoTask(todoDao).execute(todos);
    }

    public List<DiarySet> getTodoNumByDate() {
        return todoDao.getTodoNumByDate();
    }

    public LiveData<List<Todo>> getTodoLive() {
        return todoDao.getAllStudent();
    }

    private static class InsertTodoTask extends AsyncTask<Todo, Void, Void> {

        private final TodoDao todoDao;

        public InsertTodoTask(TodoDao todoDao) {
            this.todoDao = todoDao;
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            this.todoDao.insertTodoItems(todos);
            return null;
        }
    }

    private static class DeleteTodoTask extends AsyncTask<Todo, Void, Void> {

        private final TodoDao todoDao;

        public DeleteTodoTask(TodoDao todoDao) {
            this.todoDao = todoDao;
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            this.todoDao.deleteTodoItems(todos);
            return null;
        }
    }

    private static class UpdateTodoTask extends AsyncTask<Todo, Void, Void> {

        private final TodoDao todoDao;

        public UpdateTodoTask(TodoDao todoDao) {
            this.todoDao = todoDao;
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            this.todoDao.updateTodoItems(todos);
            return null;
        }
    }
}

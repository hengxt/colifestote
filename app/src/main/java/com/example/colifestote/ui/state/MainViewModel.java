package com.example.colifestote.ui.state;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.colifestote.data.bean.ABook;
import com.example.colifestote.data.bean.DiarySet;
import com.example.colifestote.data.bean.Hole;
import com.example.colifestote.data.bean.Todo;
import com.example.colifestote.data.repository.ABookRepository;
import com.example.colifestote.data.repository.DiaryRepository;
import com.example.colifestote.data.repository.TodoRepository;
import com.example.colifestote.domain.request.HoleRequest;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    public final ObservableBoolean initTabAndPage = new ObservableBoolean(true);
    public final MutableLiveData<List<Todo>> todoList = new MutableLiveData<>();
    public final MutableLiveData<List<ABook>> aBookList = new MutableLiveData<>();
    public final MutableLiveData<List<Hole>> holeList = new MutableLiveData<>();
    public final MutableLiveData<List<DiarySet>> diarySetList = new MutableLiveData<>();
    private final TodoRepository todoRepository;
    private final ABookRepository aBookRepository;
    private final DiaryRepository diaryRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        todoRepository = new TodoRepository(application);
        aBookRepository = new ABookRepository(application);
        diaryRepository = new DiaryRepository(application);
    }

    public LiveData<List<Todo>> getAllTodo() {
        return todoRepository.getTodoLive();
    }

    public LiveData<List<ABook>> getAllABook() {
        return aBookRepository.getAllABook();
    }

    public LiveData<List<DiarySet>> getDiarySet() {
        return diaryRepository.getDiarySet();
    }

    public final HoleRequest holeRequest = new HoleRequest();

    public void updateTodo(Todo... todos) {
        todoRepository.updateTodo(todos);
    }

}

package com.example.colifestote.ui.page.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.colifestote.data.bean.ABook;
import com.example.colifestote.data.bean.ABookItem;
import com.example.colifestote.data.bean.Diary;
import com.example.colifestote.data.bean.DiarySet;
import com.example.colifestote.data.bean.Hole;
import com.example.colifestote.data.bean.Todo;
import com.example.colifestote.data.bean.TodoItem;
import com.example.colifestote.data.beanmodel.ABookViewModel;
import com.example.colifestote.data.beanmodel.TodoItemModel;

public class DiffUtils {

    private static final DiffUtils S_DIFF_UTILS = new DiffUtils();
    private DiffUtil.ItemCallback<Todo> mTodoCallback;
    private DiffUtil.ItemCallback<TodoItem> mTodoItemCallback;
    private DiffUtil.ItemCallback<ABook> mABookCallback;
    private DiffUtil.ItemCallback<ABookItem> mABookItemCallback;
    private DiffUtil.ItemCallback<Hole> mHoleCallback;
    private DiffUtil.ItemCallback<DiarySet> mDiarySetCallback;
    private DiffUtil.ItemCallback<Diary> mDiaryCallback;
    private DiffUtil.ItemCallback<TodoItemModel> addTodoCallBack;
    private DiffUtil.ItemCallback<ABookViewModel> addABookCallBack;

    private DiffUtils() {
    }

    public static DiffUtils getInstance() {
        return S_DIFF_UTILS;
    }

    public DiffUtil.ItemCallback<Todo> getTodoCallback() {
        if (mTodoCallback == null) {
            mTodoCallback = new DiffUtil.ItemCallback<Todo>() {
                @Override
                public boolean areItemsTheSame(@NonNull Todo oldItem, @NonNull Todo newItem) {
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(@NonNull Todo oldItem, @NonNull Todo newItem) {
                    return oldItem.getDate().equals(newItem.getDate());
                }
            };
        }
        return mTodoCallback;
    }

    public DiffUtil.ItemCallback<TodoItem> getTodoItemCallback() {
        if (mTodoItemCallback == null) {
            mTodoItemCallback = new DiffUtil.ItemCallback<TodoItem>() {
                @Override
                public boolean areItemsTheSame(@NonNull TodoItem oldItem, @NonNull TodoItem newItem) {
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(@NonNull TodoItem oldItem, @NonNull TodoItem newItem) {
                    return false;
                }
            };
        }
        return mTodoItemCallback;
    }

    public DiffUtil.ItemCallback<ABook> getABookCallback() {
        if (mABookCallback == null) {
            mABookCallback = new DiffUtil.ItemCallback<ABook>() {
                @Override
                public boolean areItemsTheSame(@NonNull ABook oldItem, @NonNull ABook newItem) {
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(@NonNull ABook oldItem, @NonNull ABook newItem) {
                    return oldItem.getDate().equals(newItem.getDate());
                }
            };
        }
        return mABookCallback;
    }

    public DiffUtil.ItemCallback<ABookItem> getABookItemCallback() {
        if (mABookItemCallback == null) {
            mABookItemCallback = new DiffUtil.ItemCallback<ABookItem>() {
                @Override
                public boolean areItemsTheSame(@NonNull ABookItem oldItem, @NonNull ABookItem newItem) {
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(@NonNull ABookItem oldItem, @NonNull ABookItem newItem) {
                    return true;
                }
            };
        }
        return mABookItemCallback;
    }

    public DiffUtil.ItemCallback<Hole> getHoleCallback() {
        if (mHoleCallback == null) {
            mHoleCallback = new DiffUtil.ItemCallback<Hole>() {
                @Override
                public boolean areItemsTheSame(@NonNull Hole oldItem, @NonNull Hole newItem) {
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(@NonNull Hole oldItem, @NonNull Hole newItem) {
                    return true;
                }
            };
        }
        return mHoleCallback;
    }

    public DiffUtil.ItemCallback<DiarySet> getDiarySetCallback() {
        if (mDiarySetCallback == null) {
            mDiarySetCallback = new DiffUtil.ItemCallback<DiarySet>() {
                @Override
                public boolean areItemsTheSame(@NonNull DiarySet oldItem, @NonNull DiarySet newItem) {
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(@NonNull DiarySet oldItem, @NonNull DiarySet newItem) {
                    return oldItem.getCount().equals(newItem.getCount());
                }
            };
        }
        return mDiarySetCallback;
    }

    public DiffUtil.ItemCallback<Diary> getDiaryCallback() {
        if (mDiaryCallback == null) {
            mDiaryCallback = new DiffUtil.ItemCallback<Diary>() {
                @Override
                public boolean areItemsTheSame(@NonNull Diary oldItem, @NonNull Diary newItem) {
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(@NonNull Diary oldItem, @NonNull Diary newItem) {
                    return true;
                }
            };
        }
        return mDiaryCallback;
    }


    public DiffUtil.ItemCallback<TodoItemModel> getAddTodoCallBack() {
        if (addTodoCallBack == null) {
            addTodoCallBack = new DiffUtil.ItemCallback<TodoItemModel>() {
                @Override
                public boolean areItemsTheSame(@NonNull TodoItemModel oldItem, @NonNull TodoItemModel newItem) {
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(@NonNull TodoItemModel oldItem, @NonNull TodoItemModel newItem) {
                    return true;
                }
            };
        }
        return addTodoCallBack;
    }

    public DiffUtil.ItemCallback<ABookViewModel> getAddABookCallBack() {
        if (addABookCallBack == null) {
            addABookCallBack = new DiffUtil.ItemCallback<ABookViewModel>() {
                @Override
                public boolean areItemsTheSame(@NonNull ABookViewModel oldItem, @NonNull ABookViewModel newItem) {
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(@NonNull ABookViewModel oldItem, @NonNull ABookViewModel newItem) {
                    return false;
                }
            };

        }
        return addABookCallBack;
    }

}

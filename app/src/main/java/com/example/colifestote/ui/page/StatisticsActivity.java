package com.example.colifestote.ui.page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.content.Intent;
import android.os.Bundle;

import com.example.anan.AAChartCore.AAChartCoreLib.AAChartCreator.AAChartModel;
import com.example.anan.AAChartCore.AAChartCoreLib.AAChartCreator.AAChartView;
import com.example.anan.AAChartCore.AAChartCoreLib.AAChartCreator.AASeriesElement;
import com.example.anan.AAChartCore.AAChartCoreLib.AAChartEnum.AAChartType;
import com.example.colifestote.R;
import com.example.colifestote.data.bean.DiarySet;
import com.example.colifestote.data.repository.ABookRepository;
import com.example.colifestote.data.repository.DiaryRepository;
import com.example.colifestote.data.repository.TodoRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsActivity extends AppCompatActivity {

    private AAChartModel aaChartModel;
    private AAChartView aaChartView;
    private Integer[] diary;
    private Integer[] todo;
    private Integer[] aBook;
    private String categories[];
    private final DiaryRepository diaryRepository = new DiaryRepository(this);
    private final TodoRepository todoRepository = new TodoRepository(this);
    private final ABookRepository aBookRepository = new ABookRepository(this);
    private String statistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        statistics = bundle.getString("statistics", "all");
        init();

    }


    private void init() {
        aaChartView = findViewById(R.id.AAChartView);
        switch (statistics) {
            case "all":
                initData();
                initModel();
                break;
            case "todo":
                initTodoData();
                break;
            case "aBook":
                initABookData();
                break;
            case "diary":
                initDiaryData();
                break;
        }
        /*图表视图对象调用图表模型对象,绘制最终图形*/
        aaChartView.aa_drawChartWithChartModel(aaChartModel);
    }

    private void initModel() {
        aaChartModel = new AAChartModel()
                .chartType(AAChartType.Area)
                .title("所有信息统计")
                .subtitle("来自github开源AAChartModel")
//                .backgroundColor("#4b2b7f")
                .categories(categories)
                .dataLabelsEnabled(false)
                .yAxisGridLineWidth(0f)
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .name("日记")
                                .data(diary),
                        new AASeriesElement()
                                .name("账单")
                                .data(aBook),
                        new AASeriesElement()
                                .name("待办")
                                .data(todo)
                });
    }

    private void initData() {

        List<DiarySet> diaryNumByDate = diaryRepository.getDiaryNumByDate();
        List<DiarySet> todoNumByDate = todoRepository.getTodoNumByDate();
        List<DiarySet> aBookNumByDate = aBookRepository.getABookNumByDate();

        if (diaryNumByDate.size() > todoNumByDate.size() && diaryNumByDate.size() > aBookNumByDate.size()) {
            int len = diaryNumByDate.size();
            todo = new Integer[len];
            diary = new Integer[len];
            aBook = new Integer[len];
            categories = new String[len];

            for (int i = 0; i < diaryNumByDate.size(); i++) {
                categories[i] = diaryNumByDate.get(i).getDate();
                diary[i] = diaryNumByDate.get(i).getCount();
            }
            for (int i = 0; i < todoNumByDate.size(); i++) {
                todo[i] = todoNumByDate.get(i).getCount();
            }
            for (int i = 0; i < aBookNumByDate.size(); i++) {
                aBook[i] = aBookNumByDate.get(i).getCount();
            }

        } else if (todoNumByDate.size() > diaryNumByDate.size() && todoNumByDate.size() > aBookNumByDate.size()) {
            int len = todoNumByDate.size();
            todo = new Integer[len];
            diary = new Integer[len];
            aBook = new Integer[len];
            categories = new String[len];

            for (int i = 0; i < todoNumByDate.size(); i++) {
                categories[i] = todoNumByDate.get(i).getDate();
                todo[i] = todoNumByDate.get(i).getCount();
            }
            for (int i = 0; i < diaryNumByDate.size(); i++) {
                diary[i] = diaryNumByDate.get(i).getCount();
            }
            for (int i = 0; i < aBookNumByDate.size(); i++) {
                aBook[i] = aBookNumByDate.get(i).getCount();
            }

        } else {
            int len = aBookNumByDate.size();
            todo = new Integer[len];
            diary = new Integer[len];
            aBook = new Integer[len];
            categories = new String[len];

            for (int i = 0; i < aBookNumByDate.size(); i++) {
                categories[i] = aBookNumByDate.get(i).getDate();
                aBook[i] = aBookNumByDate.get(i).getCount();
            }
            for (int i = 0; i < todoNumByDate.size(); i++) {
                todo[i] = todoNumByDate.get(i).getCount();
            }
            for (int i = 0; i < diaryNumByDate.size(); i++) {
                diary[i] = diaryNumByDate.get(i).getCount();
            }
        }

    }

    private void initTodoData() {
        List<DiarySet> todoNumByDate = todoRepository.getTodoNumByDate();
        int len = todoNumByDate.size();
        todo = new Integer[len];
        categories = new String[len];
        for (int i = 0; i < todoNumByDate.size(); i++) {
            categories[i] = todoNumByDate.get(i).getDate();
            todo[i] = todoNumByDate.get(i).getCount();
        }

        aaChartModel = new AAChartModel()
                .chartType(AAChartType.Area)
                .title("待办信息统计")
                .subtitle("来自github开源AAChartModel")
                .categories(categories)
                .dataLabelsEnabled(false)
                .yAxisGridLineWidth(0f)
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .name("待办")
                                .data(todo)
                });
    }

    private void initABookData() {
        List<DiarySet> aBookNumByDate = aBookRepository.getABookNumByDate();
        int len = aBookNumByDate.size();
        aBook = new Integer[len];
        categories = new String[len];
        for (int i = 0; i < aBookNumByDate.size(); i++) {
            categories[i] = aBookNumByDate.get(i).getDate();
            aBook[i] = aBookNumByDate.get(i).getCount();
        }

        aaChartModel = new AAChartModel()
                .chartType(AAChartType.Area)
                .title("账本信息统计")
                .subtitle("来自github开源AAChartModel")
                .categories(categories)
                .dataLabelsEnabled(false)
                .yAxisGridLineWidth(0f)
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .name("账本")
                                .data(aBook)
                });
    }

    private void initDiaryData() {
        List<DiarySet> diaryNumByDate = diaryRepository.getDiaryNumByDate();
        int len = diaryNumByDate.size();
        diary = new Integer[len];
        categories = new String[len];
        for (int i = 0; i < diaryNumByDate.size(); i++) {
            categories[i] = diaryNumByDate.get(i).getDate();
            diary[i] = diaryNumByDate.get(i).getCount();
        }

        aaChartModel = new AAChartModel()
                .chartType(AAChartType.Area)
                .title("日记信息统计")
                .subtitle("来自github开源AAChartModel")
                .categories(categories)
                .dataLabelsEnabled(false)
                .yAxisGridLineWidth(0f)
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .name("日记")
                                .data(diary)
                });
    }
}
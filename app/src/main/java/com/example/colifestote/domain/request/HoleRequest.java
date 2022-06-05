package com.example.colifestote.domain.request;

import android.util.Log;

import com.example.architecture.domain.request.BaseRequest;
import com.example.architecture.response.DataResult;
import com.example.colifestote.data.bean.Hole;
import com.example.colifestote.data.repository.HoleRepository;
import com.kunminx.architecture.ui.callback.UnPeekLiveData;

import java.util.List;

public class HoleRequest extends BaseRequest {

    private final UnPeekLiveData<DataResult<List<Hole>>> mAllHoleLiveData = new UnPeekLiveData<>();

    public UnPeekLiveData<DataResult<List<Hole>>> getAllHoleLiveData() {
        return mAllHoleLiveData;
    }

    public void requestAllHoles() {
        HoleRepository.getInstance().getAllHoles(mAllHoleLiveData::setValue);
    }

    public void requestInsertHole(Hole hole) {
        HoleRepository.getInstance().insertHole(hole, new DataResult.Result<String>() {
            @Override
            public void onResult(DataResult<String> dataResult) {
                Log.d("发送树洞", "onResult: " + dataResult);
            }
        });
    }

}

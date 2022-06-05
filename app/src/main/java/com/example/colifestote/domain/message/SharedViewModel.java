/*
 * Copyright 2018-present KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.colifestote.domain.message;

import androidx.lifecycle.ViewModel;

import com.example.colifestote.R;
import com.kunminx.architecture.ui.callback.ProtectedUnPeekLiveData;
import com.kunminx.architecture.ui.callback.UnPeekLiveData;

/**
 * TODO tip 1：event-ViewModel 的职责仅限于在 "跨页面通信" 的场景下，承担 "唯一可信源"，
 * 所有跨页面的 "状态同步请求" 都交由该可信源在内部决策和处理，并统一分发给所有订阅者页面。
 * <p>
 * 如果这样说还不理解的话，详见《LiveData 鲜为人知的 身世背景 和 独特使命》中结合实际场合 对"唯一可信源"本质的解析。
 * https://xiaozhuanlan.com/topic/0168753249
 *
 * <p>
 * Create by KunMinX at 19/10/16
 */
public class SharedViewModel extends ViewModel {


    private final UnPeekLiveData<Boolean> toCloseSlidePanelIfExpanded = new UnPeekLiveData<>();

    private final UnPeekLiveData<Boolean> toCloseActivityIfAllowed = new UnPeekLiveData<>();

    private final UnPeekLiveData<Boolean> toOpenOrCloseDrawer = new UnPeekLiveData<>();

    private final UnPeekLiveData<Boolean> toAddSlideListener = new UnPeekLiveData.Builder<Boolean>().setAllowNullValue(false).create();

    private final UnPeekLiveData<Integer> toAddFragment = new UnPeekLiveData<>();
    private final UnPeekLiveData<Integer> currentAddFragment = new UnPeekLiveData<>();

    private final UnPeekLiveData<Boolean> doAddHole = new UnPeekLiveData<>();

    {
        currentAddFragment.setValue(R.id.addBaseFragment);
        doAddHole.setValue(false);
    }


    public SharedViewModel() {
        currentAddFragment.setValue(R.id.addBaseFragment);
    }

    public void requestCurrentAddFragment(Integer currentAddFragment) {
        this.currentAddFragment.setValue(currentAddFragment);
    }

    public Integer getCurrentAddFragment() {
        return this.currentAddFragment.getValue();
    }


    public void requestToAddFragment(Integer to) {
        toAddFragment.setValue(to);
    }

    public ProtectedUnPeekLiveData<Boolean> isDoAddHole() {
        return doAddHole;
    }

    public ProtectedUnPeekLiveData<Integer> isToAddAbookFragment() {
        return toAddFragment;
    }

    public ProtectedUnPeekLiveData<Boolean> isToAddSlideListener() {
        return toAddSlideListener;
    }

    public ProtectedUnPeekLiveData<Boolean> isToCloseSlidePanelIfExpanded() {
        return toCloseSlidePanelIfExpanded;
    }

    public ProtectedUnPeekLiveData<Boolean> isToCloseActivityIfAllowed() {
        return toCloseActivityIfAllowed;
    }

    public ProtectedUnPeekLiveData<Boolean> isToOpenOrCloseDrawer() {
        return toOpenOrCloseDrawer;
    }

    public void requestToCloseActivityIfAllowed(boolean allow) {
        toCloseActivityIfAllowed.setValue(allow);
    }

    public void requestToOpenOrCloseDrawer(boolean open) {
        toOpenOrCloseDrawer.setValue(open);
    }

    public void requestToCloseSlidePanelIfExpanded(boolean close) {
        toCloseSlidePanelIfExpanded.setValue(close);
    }

    public void requestToAddSlideListener(boolean add) {
        toAddSlideListener.setValue(add);
    }

    public void requestDoAddHole(boolean doAdd) {
        doAddHole.setValue(doAdd);
    }

}

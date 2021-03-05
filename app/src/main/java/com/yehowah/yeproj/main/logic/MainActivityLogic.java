package com.yehowah.yeproj.main.logic;

import android.content.res.Resources;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentManager;

import com.yehowah.hiui.tab.bottom.HiTabBottomInfo;
import com.yehowah.hiui.tab.bottom.HiTabBottomLayout;
import com.yehowah.yeproj.common.tab.HiFragmentTabView;
import com.yehowah.yeproj.main.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ye
 * @Date: 2021/03/05/13:40
 * @Description 逻辑辅助类--减少MainActivity内容
 **/
public class MainActivityLogic {


    private HiFragmentTabView fragmentTabView;
    private HiTabBottomLayout hiTabBottomLayout;
    private List<HiTabBottomInfo<?>> infoList;
    private ActivityProvider activityProvider;

    private int currentItemIndex;

    public MainActivityLogic(ActivityProvider activityProvider) {
        this.activityProvider = activityProvider;
    }

    //初始化底部Tab
    private void initTabBottom() {
        hiTabBottomLayout = activityProvider.findViewById(R.id.tab_bottom_layout);
        hiTabBottomLayout.setTabAlpha(0.85f);
        infoList = new ArrayList<>();

        int defaultColor = activityProvider.getResources().getColor(R.color.tabBottomDefaultColor);
        int tintColor = activityProvider.getResources().getColor(R.color.tabBottomTintColor);





    }


    public interface ActivityProvider {
        <T extends View> T findViewById(@IdRes int id);

        Resources getResources();

        FragmentManager getSupportFragmentManager();

        String getString(@StringRes int resId);
    }


    private final static String SAVED_CURRENT_ID = "SAVED_CURRENT_ID";


}

package com.yehowah.yeproj.common.ui.component;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @Author ye
 * @Date: 2021/03/05/9:53
 * @Description
 **/
public abstract class HiBaseFragment extends Fragment {
    protected View layoutView;//Fragment的根布局

    @LayoutRes
    public abstract int getLayoutId();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutView = inflater.inflate(getLayoutId(), container, false);//父类实现模板代码创建

        return layoutView;
    }



















}

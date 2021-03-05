package com.yehowah.yeproj.common.tab;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.yehowah.hiui.tab.bottom.HiTabBottomInfo;

import java.util.List;

/**
 * @Author ye
 * @Date: 2021/03/05/11:04
 * @Description
 **/
public class HiTabViewAdapter {
    private List<HiTabBottomInfo<?>> mInfoList;
    private Fragment mCurFragment;
    private FragmentManager mFragmentManager;


    public HiTabViewAdapter(FragmentManager fragmentManager, List<HiTabBottomInfo<?>> infoList) {
        this.mInfoList = infoList;
        this.mFragmentManager = fragmentManager;
    }


    /**
     * 实例化以及显示指定位置的fragment
     *
     * @param container
     * @param position
     */
    public void instantiateItem(View container, int position) {
        FragmentTransaction mCurTransaction = mFragmentManager.beginTransaction();
        if (mCurFragment != null) {
            mCurTransaction.hide(mCurFragment);//隐藏当前Fragment
        }

        String name = container.getId() + ":" + position;
        Fragment fragment = mFragmentManager.findFragmentByTag(name);
        if (fragment != null) {
            mCurTransaction.show(fragment);
        } else {
            fragment = getItem(position);
            if (!fragment.isAdded()) {
                mCurTransaction.add(container.getId(), fragment, name);
            }
        }

        mCurFragment = fragment;
        //提交修改
        mCurTransaction.commitAllowingStateLoss();
    }

    //创建Fragment
    public Fragment getItem(int position) {
        try {
            mInfoList.get(position).fragment.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //外界获取Fragment
    public Fragment getCurrentFragment() {
        return mCurFragment;
    }

    public int getCount() {
        return mInfoList == null ? 0 : mInfoList.size();
    }

}

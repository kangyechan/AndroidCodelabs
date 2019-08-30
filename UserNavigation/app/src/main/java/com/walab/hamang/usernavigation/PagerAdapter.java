package com.walab.hamang.usernavigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mCount = 0;

    public PagerAdapter(FragmentManager fm, int fragmentCount) {
        // 매번 입력값을 받아 하드코딩 해주기보다 편하게 하기위해서 변수 사용
        super(fm);
        this.mCount = fragmentCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new TabFragment1();
            case 1: return new TabFragment2();
            case 2: return new TabFragment3();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return mCount;
    }
}

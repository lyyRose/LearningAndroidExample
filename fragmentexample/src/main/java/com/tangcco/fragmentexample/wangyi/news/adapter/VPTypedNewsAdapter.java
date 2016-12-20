package com.tangcco.fragmentexample.wangyi.news.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tangcco.fragmentexample.wangyi.news.fragment.TypedNewsFragment;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Leaves on 2016/12/20.
 */

public class VPTypedNewsAdapter extends FragmentStatePagerAdapter {


    private List<TypedNewsFragment> fragments;


    public VPTypedNewsAdapter(FragmentManager fm, List<TypedNewsFragment> fragments) {
        super(fm);
        this.fragments = fragments;


    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    //tablayout 和 viewpager关联之后 每个fragment页面的标题

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }
}

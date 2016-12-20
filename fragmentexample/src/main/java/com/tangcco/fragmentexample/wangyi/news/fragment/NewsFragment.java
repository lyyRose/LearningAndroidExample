package com.tangcco.fragmentexample.wangyi.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tangcco.fragmentexample.R;
import com.tangcco.fragmentexample.wangyi.news.adapter.VPTypedNewsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leaves on 2016/12/15.
 */

public class NewsFragment extends Fragment {


    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news,null);

        tabLayout = (TabLayout) view.findViewById(R.id.tab_news_type_title);
        viewPager = (ViewPager) view.findViewById(R.id.vp_news);
        initViewPager();

        //将tablayou 和 viewpager关联在一起
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private void initViewPager() {

        //测试数据
        List<TypedNewsFragment> fragments = new ArrayList<>();

        for (int i = 0; i < 10;i ++){
            TypedNewsFragment fragment = new TypedNewsFragment();
            fragment.setTitle("标题" + (i + 1));
            fragments.add(fragment);
        }

        VPTypedNewsAdapter adapter = new VPTypedNewsAdapter(getFragmentManager(),fragments);

        viewPager.setAdapter(adapter);

    }
}

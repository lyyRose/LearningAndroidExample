package com.tangcco.fragmentexample.wangyi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.RadioGroup;

import com.tangcco.fragmentexample.R;
import com.tangcco.fragmentexample.wangyi.live.fragment.LiveFragment;
import com.tangcco.fragmentexample.wangyi.news.fragment.NewsFragment;
import com.tangcco.fragmentexample.wangyi.personal.fragment.PersonalFragment;
import com.tangcco.fragmentexample.wangyi.topic.fragment.TopicFragment;

public class NewsMainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RadioGroup rgMenu;

    private Fragment currentShowFragment = null;

    private final String TAG_FRAGMENT_NEWS = "news";
    private final String TAG_FRAGMENT_LIVE = "live";
    private final String TAG_FRAGMENT_TOPIC = "topic";
    private final String TAG_FRAGMENT_PERSONAL = "personal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);


        rgMenu = (RadioGroup) findViewById(R.id.rg_menu);
        rgMenu.setOnCheckedChangeListener(checkedChangeListener);

        //初始化界面
        Fragment initFragment = generateFragmentByTag(TAG_FRAGMENT_NEWS);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_content, initFragment,TAG_FRAGMENT_NEWS)
                .commitAllowingStateLoss();

        currentShowFragment = initFragment;

    }

    private RadioGroup.OnCheckedChangeListener checkedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

            String fragmentTag = "";

            switch (checkedId) {
                case R.id.rb_news:
                    fragmentTag =TAG_FRAGMENT_NEWS;
                    break;
                case R.id.rb_live:
                    fragmentTag =TAG_FRAGMENT_LIVE;
                    break;
                case R.id.rb_topic:
                    fragmentTag =TAG_FRAGMENT_TOPIC;
                    break;
                case R.id.rb_personal:
                    fragmentTag =TAG_FRAGMENT_PERSONAL;
                    break;
            }

            changeMenuContent(fragmentTag);
        }
    };


    private void changeMenuContent(String fragmentTag) {

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag(fragmentTag);

        if (fragment == null) {
            fragment = generateFragmentByTag(fragmentTag);
        }

        FragmentTransaction transaction = fm.beginTransaction();

        if (fragment.isAdded()) { // 先判断是否被add过
            transaction.hide(currentShowFragment).show(fragment).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
        } else {
            transaction.hide(currentShowFragment).add(R.id.fl_content, fragment, fragmentTag).commitAllowingStateLoss(); // 隐藏当前的fragment，add下一个到Activity中
        }
    }


    private Fragment generateFragmentByTag(String tag){
        if (tag.equals(TAG_FRAGMENT_NEWS)){
            return  new NewsFragment();
        }else  if (tag.equals(TAG_FRAGMENT_LIVE)){
            return new LiveFragment();
        }else  if (tag.equals(TAG_FRAGMENT_TOPIC)){
            return new TopicFragment();
        }else{
            return new PersonalFragment();
        }

    }
}

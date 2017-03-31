package com.ma.fragmentproject;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, TabHost.OnTabChangeListener {

    @BindView(R.id.real)
    FrameLayout real;
    @BindView(R.id.fragmenttabhost)
    FragmentTabHost fragmenttabhost;
    @BindView(R.id.leftmenu_framlayout)
    FrameLayout leftmenuFramlayout;
    @BindView(R.id.drawerable)
    DrawerLayout drawerable;

    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initActionBar();
    }

    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();

        /**显示回退键，默认为false*/
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


    private void initTab() {
        TabLayout[] tabs = TabLayout.values();

        final int size = tabs.length;

        for (int i = 0; i < size; i++) {
            // 找到每一个枚举的Fragment对象
            TabLayout mainTab = tabs[i];

            // 1. 创建一个新的选项卡
            TabHost.TabSpec tab = fragmenttabhost.newTabSpec(String.valueOf(mainTab.getResName()));
            //TabHost.TabSpec tab = mTabhost.newTabSpec(getString(mainTab.getResName()));

            View indicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, null);

            TextView title = (TextView) indicator.findViewById(R.id.tab_title);

            Drawable drawable = this.getResources().getDrawable(mainTab.getResIcon());

            //setCompoundDrawablesWithIntrinsicBounds
            title.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null,
                    null);
            title.setText(getString(mainTab.getResName()));
            tab.setIndicator(indicator);
            tab.setContent(new TabHost.TabContentFactory() {

                @Override
                public View createTabContent(String tag) {
                    return new View(MainActivity.this);
                }
            });

            //Bundle传递数据
            Bundle bundle = new Bundle();
            bundle.putString("key", String.valueOf(mainTab.getResName()));
            // bundle.putString("key", getString(mainTab.getResName()));
            // 2. 把新的选项卡添加到TabHost中
            fragmenttabhost.addTab(tab, mainTab.getClz(), bundle);

            fragmenttabhost.getTabWidget().getChildAt(i).setOnTouchListener(this);
        }
    }

    private void initView(){
        /**滑动菜单时回退键动画效果*/
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerable, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        //同步
        mDrawerToggle.syncState();
        drawerable.setDrawerListener(mDrawerToggle);

        //初始化FragmentTabHost
        fragmenttabhost.setup(this, getSupportFragmentManager(), R.id.real);
        if (Build.VERSION.SDK_INT > 10) {
            fragmenttabhost.getTabWidget().setShowDividers(0);
            initTab();
            fragmenttabhost.setCurrentTab(0);
            fragmenttabhost.setOnTabChangedListener(this);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public void onTabChanged(String tabId) {

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerToggle.onOptionsItemSelected(item);
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

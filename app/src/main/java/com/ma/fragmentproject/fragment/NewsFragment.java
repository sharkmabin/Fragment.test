package com.ma.fragmentproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.astuetz.PagerSlidingTabStrip;
import com.ma.fragmentproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by binbin.ma on 2017/3/31.
 */
public class NewsFragment extends Fragment {
    @BindView(R.id.pagertab)
    PagerSlidingTabStrip mPagertab;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;

    // private final String[] title = {"首页", "热点", "财经", "娱乐", "军事", "政治", "生活"};
    private final String[] title = {"军事", "政治", "生活"};
    AFragment af;
    BFragment bf;
    CFragment cf;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.newsfragment_layout, null);
        ButterKnife.bind(this, rootView);

        initView();
        return rootView;
    }


    private void initView() {

        mViewpager.setAdapter(new MyPagerAdapter(getChildFragmentManager(), title));
        mPagertab.setViewPager(mViewpager);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        String[] _title;

        public MyPagerAdapter(FragmentManager fm, String[] title) {
            super(fm);
            _title = title;
        }

        @Override
        public int getCount() {
            return _title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return _title[position];
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if (af == null) {
                        af = new AFragment(_title);
                    }
                    return af;
                case 1:
                    if (bf == null) {
                        bf = new BFragment(_title);
                    }
                    return bf;
                case 2:
                    if (cf == null) {
                        cf = new CFragment(_title);
                    }
                    return cf;

                default:
                    return null;
            }
        }
    }
}

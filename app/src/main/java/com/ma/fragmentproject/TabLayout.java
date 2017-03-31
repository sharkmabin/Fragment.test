package com.ma.fragmentproject;


import com.ma.fragmentproject.fragment.MeFragment;
import com.ma.fragmentproject.fragment.MoveFragment;
import com.ma.fragmentproject.fragment.NewsFragment;
import com.ma.fragmentproject.fragment.QuestionFragment;
import com.ma.fragmentproject.fragment.QuickFragment;

/**
 * Created by binbin.ma on 2017/3/31.
 */
public enum TabLayout {
    NEWS(0, R.string.main_tab_news, R.drawable.selector_main_tab_news,
            NewsFragment.class),

    MOVE(1, R.string.main_tab_move, R.drawable.selector_main_tab_move,
            MoveFragment.class),

    QUICK(2, R.string.main_tab_quick, R.drawable.selector_main_tab_quick,
            QuickFragment.class),

    QUESTION(3, R.string.main_tab_question, R.drawable.selector_main_tab_question,
            QuestionFragment.class),

    ME(4, R.string.main_tab_me, R.drawable.selector_main_tab_me,
            MeFragment.class);

    private int idx;
    private int resName;
    private int resIcon;
    private Class<?> clz;

    private TabLayout(int idx, int resName, int resIcon, Class<?> clz) {
        this.idx = idx;
        this.resName = resName;
        this.resIcon = resIcon;
        this.clz = clz;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getResName() {
        return resName;
    }

    public void setResName(int resName) {
        this.resName = resName;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }
}

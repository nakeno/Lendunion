package com.lendunion;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.lendunion.ui.fragment.PageFragment;
import com.lendunion.ui.fragment.ForRentListFragment;
import com.lendunion.ui.fragment.RaisingListFragment;
import com.lendunion.ui.fragment.dummy.DummyContent;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements PageFragment.OnListFragmentInteractionListener {
    @BindView(R.id.tl_title)
    TabLayout tl_title;
    @BindView(R.id.vp_content)
    ViewPager vp_content;

    private static final int NUM_PAGES = 2;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.tb_main);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        vp_content.setAdapter(mPagerAdapter);
        tl_title.setupWithViewPager(vp_content);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    private class ScreenSlidePagerAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> pageFragments = new ArrayList();
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
            pageFragments.add(RaisingListFragment.newInstance());
            pageFragments.add(ForRentListFragment.newInstance());
        }

        @Override
        public Fragment getItem(int position) {
            return pageFragments.get(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "title" + position;
        }
    }
}

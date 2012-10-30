package com.example.design.concepts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class HomeActivity extends FragmentActivity
{

    private ViewPager mPager;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mPager = (ViewPager) findViewById(R.id.view_pager);
        mPager.setAdapter(new LayoutPager(getSupportFragmentManager()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.activity_home, menu);
        return true;
    }

    private class LayoutPager extends FragmentPagerAdapter
    {

        public LayoutPager(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int arg0)
        {
            return DetailsFragment.newInstance(arg0);
        }

        @Override
        public int getCount()
        {
            return 5;
        }

    }

    public static class DetailsFragment extends Fragment
    {
        /**
         * Create a new instance of DetailsFragment, initialized to
         * show the text at 'index'.
         */
        public static DetailsFragment newInstance(int index)
        {
            DetailsFragment f = new DetailsFragment();

            // Supply index input as an argument.
            Bundle args = new Bundle();
            args.putInt("index", index);
            f.setArguments(args);

            return f;
        }

        public int getShownIndex()
        {
            return getArguments().getInt("index", 0);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState)
        {
            switch (getShownIndex())
            {
                case 0:
                    return inflater
                            .inflate(R.layout.fragment_layout_wrong_pixels, container, false);
                case 1:
                    return inflater.inflate(R.layout.fragment_layout_right_dip, container, false);
                case 2:
                    return inflater.inflate(R.layout.fragment_layout_wrong, container, false);
                case 3:
                    return inflater.inflate(R.layout.fragment_layout_right, container, false);
                case 4:
                    return inflater.inflate(R.layout.fragment_layout_styles, container, false);

                default:
                    return new FrameLayout(getActivity());
            }
        }

        // private static class MyTimers extends Handler
        // {
        //
        // private static final int TIMER_1 = 0;
        // private static final int TIMER_2 = 1;
        //
        // @Override
        // public void handleMessage(Message msg)
        // {
        // switch (msg.what)
        // {
        // case TIMER_1:
        // // Do something etc.
        // sendEmptyMessageDelayed(TIMER_1, 1000);
        // break;
        // case TIMER_2:
        // // Do another time update etc..
        // sendEmptyMessageDelayed(TIMER_2, 1000);
        // default:
        // removeMessages(TIMER_1);
        // removeMessages(TIMER_2);
        // break;
        // }
        // }
        // }
    }
}
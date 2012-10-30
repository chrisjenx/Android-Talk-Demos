package com.jenxsol.actionbar.demo.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.jenxsol.actionbar.demo.R;

public class ExampleFragment extends SherlockFragment
{

    public static final String TAG = ExampleFragment.class.getSimpleName();

    public static final ExampleFragment newInstance()
    {
        return new ExampleFragment();
    }

    public ExampleFragment()
    {
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
        // Important tells the fragment manger that it needs to send menu
        // methods this way

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Just create an empty frame layout with a dark color
        FrameLayout f = new FrameLayout(getActivity());
        f.setLayoutParams(new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        f.setBackgroundColor(getResources().getColor(android.R.color.background_dark));
        final TextView tv = new TextView(getActivity());
        tv.setText("Press back button");
        tv.setGravity(Gravity.CENTER);
        tv.setTextColor(getResources().getColor(android.R.color.white));
        f.addView(tv);
        return f;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        Log.d("ABS Demo", "OnCreateAct");
    }

    @Override
    public void onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu,
            com.actionbarsherlock.view.MenuInflater inflater)
    {
        // Inflate our fragment menu
        menu.clear();
        inflater.inflate(R.menu.fragment_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}

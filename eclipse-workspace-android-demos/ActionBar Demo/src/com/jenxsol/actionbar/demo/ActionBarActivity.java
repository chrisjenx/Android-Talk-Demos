package com.jenxsol.actionbar.demo;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.jenxsol.actionbar.demo.fragment.ExampleFragment;

public class ActionBarActivity extends SherlockFragmentActivity implements OnClickListener
{

    private View mAddButton;
    private View mRemoveButton;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);

        mAddButton = findViewById(R.id.button_add);
        mRemoveButton = findViewById(R.id.button_remove);
        mAddButton.setOnClickListener(this);
        mRemoveButton.setOnClickListener(this);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        invalidateOptionsMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        // If your doing this...
        // menu.add(0, R.id.menu_about, 0, "About");
        // Don't unless you have too!

        // Inflate your menu from your xml!
        getSupportMenuInflater().inflate(R.menu.activity_action_bar, menu);

        return true;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button_add:
            {
                // mAddButton.setVisibility(View.GONE);
                // mRemoveButton.setVisibility(View.VISIBLE);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.add(R.id.container, ExampleFragment.newInstance(), ExampleFragment.TAG);
                ft.addToBackStack(null);
                ft.commit();
                break;
            }
            case R.id.button_remove:
            {
                // mAddButton.setVisibility(View.VISIBLE);
                // mRemoveButton.setVisibility(View.GONE);
                // final Fragment f =
                // getSupportFragmentManager().findFragmentByTag(
                // ExampleFragment.TAG);
                // if (f != null)
                // {
                // getSupportFragmentManager().popBackStack();
                // }
                break;
            }
            default:
                break;
        }
    }
}

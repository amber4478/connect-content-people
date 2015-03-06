package com.stoichiometrysolver.tyler.mylanapp1;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.Toast;

import static android.support.v7.app.ActionBar.DISPLAY_HOME_AS_UP;


public class NotificationActivity extends ActionBarActivity
{
    //Components
    ActionBar _ActionBar;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        InitializeActionBar();
        InitializeComponents();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_notification, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.action_reload)
        {
            Toast.makeText(getBaseContext(), "Notifications Updated...", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.action_clear)
        {
            Toast.makeText(getBaseContext(), "Notifications Cleared...", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void InitializeActionBar()
    {
        _ActionBar = this.getSupportActionBar();
        _ActionBar.setTitle("Notifications");
        _ActionBar.setDisplayShowTitleEnabled(true);
        //_ActionBar.setDisplayShowHomeEnabled(true);

        //Theme-Style
        _ActionBar.setBackgroundDrawable(new ColorDrawable(getResources()
                .getColor(R.color.blue_dark))); //Sets the background color
    }

    private void InitializeComponents()
    {

    }
}

package com.stoichiometrysolver.tyler.mylanapp1;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MessageActivity extends ActionBarActivity
{
    //Components
    private ActionBar _ActionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        InitializeActionBar();

        if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.message_container, new RefreshMessage())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_message, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.action_clear)
        {
            Toast.makeText(getBaseContext(), "Messages Cleared...", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.action_newmessage)
        {
            Toast.makeText(getBaseContext(), "New Message...", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void InitializeActionBar()
    {
        _ActionBar = this.getSupportActionBar();
        _ActionBar.setTitle("Messages");
        _ActionBar.setDisplayShowTitleEnabled(true);
        //_ActionBar.setDisplayShowHomeEnabled(true);

        //Theme-Style
        _ActionBar.setBackgroundDrawable(new ColorDrawable(getResources()
                .getColor(R.color.blue_dark))); //Sets the background color
    }
}

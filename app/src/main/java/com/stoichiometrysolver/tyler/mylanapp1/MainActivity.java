package com.stoichiometrysolver.tyler.mylanapp1;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity
{
    //Components
    private ViewPager _ViewPager;
    private PagerAdapter pAdapter;
    private ActionBar _ActionBar;
    private ActionBar.TabListener tabListener;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitializeComponents(); //Initializes every component in the xml file
        InitializeViewPagerListener(); //Initializes viewpager listener

        _ViewPager.setAdapter(pAdapter);
        _ActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        _ActionBar.setDisplayShowTitleEnabled(false);
        _ActionBar.setDisplayShowHomeEnabled(false);
        _ActionBar.setStackedBackgroundDrawable(new ColorDrawable(getResources()
                .getColor(R.color.tab_highlight))); //Sets the highlighted tab color
        _ActionBar.setBackgroundDrawable(new ColorDrawable(getResources()
                .getColor(R.color.tab_background))); //Sets the background color
        InitializeTabListener(); //Initializes tab listener

        _ActionBar.addTab(_ActionBar.newTab()
                .setIcon(R.drawable.ic_home_white_18)
                        //.setText("Home")
                .setTabListener(tabListener));
        _ActionBar.addTab(_ActionBar.newTab()
                .setIcon(R.drawable.ic_stream_white_18)
                        //.setText("Stream")
                .setTabListener(tabListener));
        _ActionBar.addTab(_ActionBar.newTab()
                .setIcon(R.drawable.ic_search_white_18)
                        //.setText("Search")
                .setTabListener(tabListener));
        _ActionBar.addTab(_ActionBar.newTab()
                .setIcon(R.drawable.ic_content_white_18)
                        //.setText("Content")
                .setTabListener(tabListener));
        _ActionBar.addTab(_ActionBar.newTab()
                .setIcon(R.drawable.ic_profile_white_18)
                        //.setText("Profile")
                .setTabListener(tabListener));
    }

    //Initializes the components
    private void InitializeComponents()
    {
        _ViewPager = (ViewPager)findViewById(R.id.pager);
        _ActionBar = this.getSupportActionBar();
        pAdapter = new PagerAdapter(this.getSupportFragmentManager());
    }

    //Initializes the view pager listener
    private void InitializeViewPagerListener()
    {
        //VIEWPAGER ON PAGE CHANGE LISTENER
        _ViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int i, float v, int i2)
            {

            }

            @Override
            public void onPageSelected(int i)
            {
                _ActionBar.setSelectedNavigationItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i)
            {

            }
        });
    }

    //Initializes the tab listener
    private void InitializeTabListener()
    {
        tabListener = new ActionBar.TabListener()
        {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
            {
                _ViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
            {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
            {

            }
        };
    }


    //
    //ActionBar Stuff
    //
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        //int id = item.getItemId();

        //if (id == R.id.action_settings)
        //{
       //     return true;
        //}

        //return super.onOptionsItemSelected(item);
        return true;
    }
}


class PagerAdapter extends FragmentPagerAdapter
{
    public PagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int i)
    {
        switch (i)
        {
            case 0:
                return new FragmentHome();
            case 1:
                return new FragmentStream();
            case 2:
                return new FragmentSearch();
            case 3:
                return new FragmentContent();
            case 4:
                return new FragmentProfile();
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount()
    {
        return 5;
    }
}

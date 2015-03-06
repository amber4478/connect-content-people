package com.stoichiometrysolver.tyler.mylanapp1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity
{
    //Components
    private ViewPager _ViewPager;
    private PagerAdapter pAdapter;
    private ActionBar _ActionBar;
    private ActionBar.TabListener tabListener;

    //Variables
    private SharedPreferences MySettings;
    public User CurrentUser;

    //Features
    private boolean FirstTime;
    private boolean LoggedIn;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySettings = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        FirstTime = MySettings.getBoolean("FirstTime", true);
        LoggedIn = MySettings.getBoolean("LoggedIn", false);

        InitializeComponents(); //Initializes every component in the xml file
        InitializeViewPagerListener(); //Initializes viewpager listener
        _ViewPager.setAdapter(pAdapter);
        InitializeActionBar(); //Initializes the actionbar

        if (FirstTime == true)
        {
            if (LoggedIn == false)
            {
                ShowLogin();
            }
        }
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

                switch (i)
                {
                    case 0:
                        _ActionBar.setTitle("Home");
                        break;
                    case 1:
                        _ActionBar.setTitle("Your Stream");
                        break;
                    case 2:
                        _ActionBar.setTitle("Search");
                        break;
                    case 3:
                        _ActionBar.setTitle("All Content");
                        break;
                    case 4:
                        _ActionBar.setTitle("Hi, " + CurrentUser.Name);
                        break;
                    default:
                        break;
                }
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

    //Initializes the ActionBar
    private void InitializeActionBar()
    {
        _ActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        _ActionBar.setDisplayShowTitleEnabled(true);
        _ActionBar.setDisplayShowHomeEnabled(false);
        //_ActionBar.setSplitBackgroundDrawable(new ColorDrawable(getResources()
        //        .getColor(R.color.tab_highlight_test)));
        //_ActionBar.setStackedBackgroundDrawable(new ColorDrawable(getResources()
        //        .getColor(R.color.tab_background_test))); //Sets the highlighted tab color
        _ActionBar.setBackgroundDrawable(new ColorDrawable(getResources()
                .getColor(R.color.blue_dark))); //Sets the background color
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

    private void ShowLogin()
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        dialog.setCancelable(false);
        dialog.setView(inflater.inflate(R.layout.dialog_login, null))
                // Add action buttons
                .setPositiveButton("Login", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                        Dialog f = (Dialog)dialog;
                        EditText Username = (EditText)f.findViewById(R.id.TextBox_Username);
                        EditText Password = (EditText)f.findViewById(R.id.TextBox_Password);
                        String uName = Username.getText().toString();
                        String pWord = Password.getText().toString();

                        if (uName.equals("tylersuehr7") && pWord.equals("suehr"))
                        {
                            CurrentUser = new User("Tyler");
                        }
                        else if (uName.equals("admin") && pWord.equals("admin"))
                        {
                            CurrentUser = new User("Administrator");
                        }
                        else
                        {
                            CurrentUser = new User("Mylan User");
                        }

                        _ActionBar.setTitle("Hi, " + CurrentUser.Name);
                        _ViewPager.setCurrentItem(4);

                        CurrentUser.CheckAllUpdates();
                    }
                });

        AlertDialog Dialog = dialog.create();
        Dialog.show();
    }
}

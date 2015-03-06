package com.stoichiometrysolver.tyler.mylanapp1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter
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

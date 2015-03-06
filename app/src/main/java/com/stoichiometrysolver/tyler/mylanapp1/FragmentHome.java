package com.stoichiometrysolver.tyler.mylanapp1;

import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentHome extends Fragment
{
    //Components
    private ListView listView;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView =  inflater.inflate(R.layout.fragment_home, container, false);


        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_profile, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_messages:
                Intent indent = new Intent(getActivity(), MessageActivity.class);
                startActivity(indent);
                break;
            case R.id.action_notifications:
                Intent intent = new Intent(getActivity(), NotificationActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private LinearLayout CreateItem(String Content, String Title)
    {
        final TextView textView_Content = new TextView(getActivity());
        textView_Content.setText(Content);
        textView_Content.setTextSize(16);
        textView_Content.setTypeface(null, Typeface.BOLD);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        params.setMargins(10,5,10,0);
        textView_Content.setLayoutParams(params);


        final TextView textView_Title = new TextView(getActivity());
        textView_Title.setText(Title);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        params.setMargins(10,5,10,5);
        textView_Title.setLayoutParams(params2);

        final FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setBackground(new ColorDrawable(getResources().getColor(R.color.medium)));
        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        params3.setMargins(0,5,0,5);
        frameLayout.setLayoutParams(params3);


        final LinearLayout rL = new LinearLayout(getActivity());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(10,5,10,5);

        rL.setLayoutParams(lp);
        rL.addView(textView_Content);
        rL.addView(textView_Title);
        rL.addView(frameLayout);

        return rL;
    }
}

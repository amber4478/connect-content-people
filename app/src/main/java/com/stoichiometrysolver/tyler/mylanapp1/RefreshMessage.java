package com.stoichiometrysolver.tyler.mylanapp1;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

public class RefreshMessage extends Fragment implements SwipeRefreshLayout.OnRefreshListener
{
            private SwipeRefreshLayout swipeRefreshLayout;
            private ListView colorsList;


            public RefreshMessage()
            {
            }

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
            {
                swipeRefreshLayout = new SwipeRefreshLayout(getActivity());
                return swipeRefreshLayout;
            }

            @Override
            public void onActivityCreated(Bundle savedInstanceState)
            {
                super.onActivityCreated(savedInstanceState);

                colorsList = new ListView(getActivity());
                swipeRefreshLayout.addView(colorsList);
                swipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW);
                swipeRefreshLayout.setOnRefreshListener(this);
            }

            @Override
            public void onRefresh()
            {
                new Thread()
                {
                    public void run()
                    {
                        SystemClock.sleep(4000);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity().getBaseContext(), "Messages Updated...", Toast.LENGTH_SHORT).show();

                                swipeRefreshLayout.setRefreshing(false);
                            }
                        });
                    };
                }.start();
            }
        }

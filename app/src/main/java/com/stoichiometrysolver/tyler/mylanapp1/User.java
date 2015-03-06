package com.stoichiometrysolver.tyler.mylanapp1;

import android.util.Log;
import java.util.List;

public class User
{
    //Variables
    public String Name;
    public String Username;
    public String Password;
    public List<Message> Messages;
    public List<Notification> Notifications;
    public boolean HasMessage, HasNotification;


    public User(String Name)
    {
        this.Name = Name;
    }

    public int getNotificationCount()
    {
        int count = 0;

        for (Notification n : Notifications)
        {
            count++;
        }

        return count;
    }

    public int getMessageCount()
    {
        int count = 0;

        for (Message m : Messages)
        {
            count++;
        }

        return count;
    }

    public void CheckForNotificationUpdates()
    {
        //Enter code to connect to service and check for updates
        //AddFakeNotifications(9);
        Log.d("LOG", "CHECKED FOR NOTIFICATIONS");
        HasNotification = true;
    }

    public void CheckForMessageUpdates()
    {
        //Enter code to connect to service and check for updates
        //AddFakeMessages(3);
        Log.d("LOG", "CHECK FOR NEW MESSAGES");
        HasMessage = true;
    }

    public void CheckAllUpdates()
    {
        CheckForMessageUpdates();
        CheckForNotificationUpdates();
    }

    private void AddFakeNotifications(int value)
    {
        Notification n;

        for (int i = 0; i < value; i++)
        {
            n = new Notification(Notification.NotificationTypes.NewsFeedUpdate, Notification.Importance.Normal);
            Notifications.add(n);
        }
    }

    private void AddFakeMessages(int value)
    {
        Message m;

        for (int i = 0; i < value; i++)
        {
            m = new Message("Work Update", "We would like to add some new tasks", "BOSS");
            Messages.add(m);
        }
    }
}

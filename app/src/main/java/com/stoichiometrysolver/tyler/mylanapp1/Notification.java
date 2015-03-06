package com.stoichiometrysolver.tyler.mylanapp1;

public class Notification
{
    //Variables
    public NotificationTypes NotificationType;
    public Importance Priority;

    //Enums
    public enum NotificationTypes
    {
        Message,
        NewsFeedUpdate,
        SOPUpdate
    }
    public enum Importance
    {
        Important,
        Normal,
        Unimportant
    }

    public Notification(NotificationTypes NotiType, Importance Priority)
    {
        this.NotificationType = NotiType;
        this.Priority = Priority;
    }
}

package com.bumptech.glide.load.resource.bitmap;

import android.app.NotificationChannel;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ NotificationChannel b() {
        return new NotificationChannel("default_channel_id", "Default", 4);
    }

    public static /* synthetic */ NotificationChannel c(int i2) {
        return new NotificationChannel("offline_notification_channel", "AdMob Offline Notifications", i2);
    }

    public static /* synthetic */ NotificationChannel e(String str) {
        return new NotificationChannel("chucker_transactions", str, 2);
    }

    public static /* synthetic */ NotificationChannel z(String str) {
        return new NotificationChannel("com.google.android.gms.availability", str, 4);
    }
}

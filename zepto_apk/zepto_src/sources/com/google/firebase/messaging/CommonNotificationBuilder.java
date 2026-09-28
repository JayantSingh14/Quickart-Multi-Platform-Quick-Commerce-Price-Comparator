package com.google.firebase.messaging;

import android.content.res.Resources;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class CommonNotificationBuilder {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f44684a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    public static class DisplayNotificationInfo {

        /* renamed from: a, reason: collision with root package name */
        public final NotificationCompat.Builder f44685a;

        /* renamed from: b, reason: collision with root package name */
        public final String f44686b;

        public DisplayNotificationInfo(NotificationCompat.Builder builder, String str) {
            this.f44685a = builder;
            this.f44686b = str;
        }
    }

    public static boolean a(Resources resources, int i2) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!com.google.android.material.appbar.a.C(resources.getDrawable(i2, null))) {
                return true;
            }
            Log.e("FirebaseMessaging", "Adaptive icons cannot be used in notifications. Ignoring icon id: " + i2);
            return false;
        } catch (Resources.NotFoundException unused) {
            Log.e("FirebaseMessaging", "Couldn't find resource " + i2 + ", treating it as an invalid icon");
            return false;
        }
    }
}

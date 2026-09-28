package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* loaded from: classes.dex */
final class SharedPreferencesQueue {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f44757a;

    /* renamed from: e, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f44761e;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f44760d = new ArrayDeque();

    /* renamed from: b, reason: collision with root package name */
    public final String f44758b = "topic_operation_queue";

    /* renamed from: c, reason: collision with root package name */
    public final String f44759c = ",";

    public SharedPreferencesQueue(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f44757a = sharedPreferences;
        this.f44761e = scheduledThreadPoolExecutor;
    }

    public static SharedPreferencesQueue a(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        SharedPreferencesQueue sharedPreferencesQueue = new SharedPreferencesQueue(sharedPreferences, scheduledThreadPoolExecutor);
        synchronized (sharedPreferencesQueue.f44760d) {
            try {
                sharedPreferencesQueue.f44760d.clear();
                String string = sharedPreferencesQueue.f44757a.getString(sharedPreferencesQueue.f44758b, "");
                if (!TextUtils.isEmpty(string) && string.contains(sharedPreferencesQueue.f44759c)) {
                    String[] strArrSplit = string.split(sharedPreferencesQueue.f44759c, -1);
                    if (strArrSplit.length == 0) {
                        Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                    }
                    for (String str : strArrSplit) {
                        if (!TextUtils.isEmpty(str)) {
                            sharedPreferencesQueue.f44760d.add(str);
                        }
                    }
                    return sharedPreferencesQueue;
                }
                return sharedPreferencesQueue;
            } finally {
            }
        }
    }
}

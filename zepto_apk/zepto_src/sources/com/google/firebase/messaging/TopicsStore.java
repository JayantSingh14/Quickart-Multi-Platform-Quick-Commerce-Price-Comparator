package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
final class TopicsStore {

    /* renamed from: c, reason: collision with root package name */
    public static WeakReference f44777c;

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferencesQueue f44778a;

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f44779b;

    public TopicsStore(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f44779b = scheduledThreadPoolExecutor;
    }

    public final synchronized TopicOperation a() {
        String str;
        TopicOperation topicOperation;
        SharedPreferencesQueue sharedPreferencesQueue = this.f44778a;
        synchronized (sharedPreferencesQueue.f44760d) {
            str = (String) sharedPreferencesQueue.f44760d.peek();
        }
        Pattern pattern = TopicOperation.f44773d;
        topicOperation = null;
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("!", -1);
            if (strArrSplit.length == 2) {
                topicOperation = new TopicOperation(strArrSplit[0], strArrSplit[1]);
            }
        }
        return topicOperation;
    }
}

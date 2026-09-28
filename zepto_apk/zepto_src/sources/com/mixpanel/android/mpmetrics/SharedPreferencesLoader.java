package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Message;
import com.mixpanel.android.mpmetrics.AnalyticsMessages;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
class SharedPreferencesLoader {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f46081a = Executors.newSingleThreadExecutor();

    public static class LoadSharedPreferences implements Callable<SharedPreferences> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f46082a;

        /* renamed from: b, reason: collision with root package name */
        public final String f46083b;

        /* renamed from: c, reason: collision with root package name */
        public final MixpanelAPI.AnonymousClass3 f46084c;

        public LoadSharedPreferences(Context context, String str, MixpanelAPI.AnonymousClass3 anonymousClass3) {
            this.f46082a = context;
            this.f46083b = str;
            this.f46084c = anonymousClass3;
        }

        @Override // java.util.concurrent.Callable
        public final SharedPreferences call() {
            String string;
            SharedPreferences sharedPreferences = this.f46082a.getSharedPreferences(this.f46083b, 0);
            MixpanelAPI.AnonymousClass3 anonymousClass3 = this.f46084c;
            if (anonymousClass3 != null && (string = sharedPreferences.getString("people_distinct_id", null)) != null) {
                MixpanelAPI mixpanelAPI = MixpanelAPI.this;
                AnalyticsMessages.PushAnonymousPeopleDescription pushAnonymousPeopleDescription = new AnalyticsMessages.PushAnonymousPeopleDescription(string, mixpanelAPI.f46035d);
                AnalyticsMessages analyticsMessages = mixpanelAPI.f46033b;
                analyticsMessages.getClass();
                Message messageObtain = Message.obtain();
                messageObtain.what = 4;
                messageObtain.obj = pushAnonymousPeopleDescription;
                analyticsMessages.f45962a.b(messageObtain);
            }
            return sharedPreferences;
        }
    }

    public interface OnPrefsLoadedListener {
    }

    public final FutureTask a(Context context, String str, MixpanelAPI.AnonymousClass3 anonymousClass3) {
        FutureTask futureTask = new FutureTask(new LoadSharedPreferences(context, str, anonymousClass3));
        this.f46081a.execute(futureTask);
        return futureTask;
    }
}

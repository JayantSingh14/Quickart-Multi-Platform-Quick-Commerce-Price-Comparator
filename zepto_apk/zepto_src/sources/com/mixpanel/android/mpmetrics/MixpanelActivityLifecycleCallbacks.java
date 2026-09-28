package com.mixpanel.android.mpmetrics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
/* loaded from: classes.dex */
class MixpanelActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    /* renamed from: g, reason: collision with root package name */
    public static Double f46054g;

    /* renamed from: b, reason: collision with root package name */
    public Runnable f46056b;

    /* renamed from: e, reason: collision with root package name */
    public final MixpanelAPI f46059e;

    /* renamed from: f, reason: collision with root package name */
    public final MPConfig f46060f;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f46055a = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public boolean f46057c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f46058d = true;

    public MixpanelActivityLifecycleCallbacks(MixpanelAPI mixpanelAPI, MPConfig mPConfig) {
        this.f46059e = mixpanelAPI;
        this.f46060f = mPConfig;
        if (f46054g == null) {
            f46054g = Double.valueOf(System.currentTimeMillis());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.f46058d = true;
        Runnable runnable = this.f46056b;
        Handler handler = this.f46055a;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.mixpanel.android.mpmetrics.MixpanelActivityLifecycleCallbacks.1
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                MixpanelActivityLifecycleCallbacks mixpanelActivityLifecycleCallbacks = MixpanelActivityLifecycleCallbacks.this;
                MixpanelAPI mixpanelAPI = mixpanelActivityLifecycleCallbacks.f46059e;
                if (mixpanelActivityLifecycleCallbacks.f46057c && mixpanelActivityLifecycleCallbacks.f46058d) {
                    mixpanelActivityLifecycleCallbacks.f46057c = false;
                    try {
                        double dCurrentTimeMillis = System.currentTimeMillis() - MixpanelActivityLifecycleCallbacks.f46054g.doubleValue();
                        MPConfig mPConfig = mixpanelActivityLifecycleCallbacks.f46060f;
                        if (dCurrentTimeMillis >= mPConfig.f46010m && dCurrentTimeMillis < mPConfig.n) {
                            double dRound = Math.round((dCurrentTimeMillis / 1000.0d) * 10.0d) / 10.0d;
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("$ae_session_length", dRound);
                            MixpanelAPI.PeopleImpl peopleImpl = mixpanelAPI.f46036e;
                            if (!MixpanelAPI.this.n()) {
                                HashMap map = new HashMap();
                                map.put("$ae_total_app_sessions", Double.valueOf(1.0d));
                                peopleImpl.f(map);
                            }
                            MixpanelAPI.PeopleImpl peopleImpl2 = mixpanelAPI.f46036e;
                            if (!MixpanelAPI.this.n()) {
                                HashMap map2 = new HashMap();
                                map2.put("$ae_total_app_session_length", Double.valueOf(dRound));
                                peopleImpl2.f(map2);
                            }
                            mixpanelAPI.z("$ae_session", jSONObject, true);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    if (mixpanelAPI.f46034c.f46000c) {
                        mixpanelAPI.h();
                    }
                }
            }
        };
        this.f46056b = runnable2;
        handler.postDelayed(runnable2, 500L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        new WeakReference(activity);
        this.f46058d = false;
        boolean z = this.f46057c;
        this.f46057c = true;
        Runnable runnable = this.f46056b;
        if (runnable != null) {
            this.f46055a.removeCallbacks(runnable);
        }
        if (z) {
            return;
        }
        f46054g = Double.valueOf(System.currentTimeMillis());
        this.f46059e.f46042k.b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}

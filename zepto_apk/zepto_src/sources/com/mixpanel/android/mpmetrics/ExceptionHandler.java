package com.mixpanel.android.mpmetrics;

import android.os.Process;
import com.mixpanel.android.mpmetrics.AnalyticsMessages;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import java.lang.Thread;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: b, reason: collision with root package name */
    public static ExceptionHandler f45995b;

    /* renamed from: a, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f45996a = Thread.getDefaultUncaughtExceptionHandler();

    public ExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, final Throwable th) throws InterruptedException {
        MixpanelAPI.e(new MixpanelAPI.InstanceProcessor() { // from class: com.mixpanel.android.mpmetrics.ExceptionHandler.1
            @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.InstanceProcessor
            public final void a(MixpanelAPI mixpanelAPI) throws JSONException {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("$ae_crashed_reason", th.toString());
                    mixpanelAPI.z("$ae_crashed", jSONObject, true);
                } catch (JSONException unused) {
                }
            }
        });
        MixpanelAPI.e(new MixpanelAPI.InstanceProcessor() { // from class: com.mixpanel.android.mpmetrics.ExceptionHandler.2
            @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.InstanceProcessor
            public final void a(MixpanelAPI mixpanelAPI) {
                if (mixpanelAPI.n()) {
                    return;
                }
                mixpanelAPI.f46033b.c(new AnalyticsMessages.FlushDescription(mixpanelAPI.f46035d, false));
            }
        });
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f45996a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        try {
            Thread.sleep(400L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        Process.killProcess(Process.myPid());
        System.exit(10);
    }
}

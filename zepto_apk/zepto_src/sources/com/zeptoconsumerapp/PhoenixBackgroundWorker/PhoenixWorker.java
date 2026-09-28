package com.zeptoconsumerapp.PhoenixBackgroundWorker;

import android.content.Context;
import androidx.work.Data;
import androidx.work.PeriodicWorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.CancelWorkRunnable;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.zeptoconsumerapp.BuildConfig;
import com.zeptoconsumerapp.Utils;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PhoenixWorker extends Worker {

    /* renamed from: f, reason: collision with root package name */
    public static MixpanelAPI f47539f;

    public PhoenixWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public static void a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        try {
            jSONObject.put(str, obj);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(Context context) throws JSONException {
        d(context);
        JSONObject jSONObject = new JSONObject();
        if (!WorkerUtils.e(context)) {
            a(jSONObject, "is_enabled", Boolean.FALSE);
            f(context, "INIT_BACKGROUND_UPDATE", jSONObject);
            return;
        }
        String strA = WorkerUtils.a(context);
        Long lValueOf = null;
        if (strA != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(strA);
                if (jSONObject2.has("initialPeriodicity")) {
                    lValueOf = Long.valueOf(jSONObject2.optLong("initialPeriodicity", 24L));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        a(jSONObject, "is_enabled", Boolean.TRUE);
        a(jSONObject, "periodicity", lValueOf);
        f(context, "INIT_BACKGROUND_UPDATE", jSONObject);
        if (lValueOf == null) {
            return;
        }
        if (WorkerUtils.b(context)) {
            lValueOf = Long.valueOf(WorkerUtils.d(context, lValueOf.longValue()));
        }
        long jLongValue = lValueOf.longValue();
        TimeUnit timeUnit = TimeUnit.HOURS;
        c(context, jLongValue, System.currentTimeMillis());
    }

    public static void c(Context context, long j2, long j3) throws JSONException {
        TimeUnit timeUnit = TimeUnit.HOURS;
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "periodicity", Long.valueOf(j2));
        a(jSONObject, "last_app_open_time", Long.valueOf(j3));
        a(jSONObject, "time_unit", timeUnit.toString());
        f(context, "SCHEDULE_PERIODIC_WORK", jSONObject);
        PeriodicWorkRequest.Builder builder = new PeriodicWorkRequest.Builder(PhoenixWorker.class, j2, timeUnit);
        Data.Builder builder2 = new Data.Builder();
        builder2.f12511a.put("start_time", Long.valueOf(j3));
        WorkManagerImpl.f(context).e("phoenix_periodic_worker", (PeriodicWorkRequest) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) builder.g(builder2.a())).f(j2, timeUnit)).a("phoenix_background_worker")).b());
    }

    public static void d(Context context) {
        try {
            WorkManagerImpl workManagerImplF = WorkManagerImpl.f(context);
            workManagerImplF.getClass();
            workManagerImplF.f12656d.c(CancelWorkRunnable.d(workManagerImplF, "phoenix_background_worker"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void f(Context context, String str, JSONObject jSONObject) {
        String str2 = Utils.f47559a;
        if (f47539f == null) {
            f47539f = MixpanelAPI.l(context, BuildConfig.MIXPANEL_KEY, null, false);
        }
        f47539f.y("PHOENIX_WORKER_".concat(str), jSONObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00d5 A[Catch: Exception -> 0x011c, TryCatch #2 {Exception -> 0x011c, blocks: (B:44:0x00ce, B:46:0x00d5, B:48:0x00ff, B:50:0x0104, B:52:0x0111), top: B:74:0x00ce }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00c6 -> B:74:0x00ce). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x00ce -> B:74:0x00ce). Please report as a decompilation issue!!! */
    @Override // androidx.work.Worker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.work.ListenableWorker.Result doWork() throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.PhoenixBackgroundWorker.PhoenixWorker.doWork():androidx.work.ListenableWorker$Result");
    }
}

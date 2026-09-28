package com.google.android.gms.internal.appset;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzl implements AppSetIdClient {

    /* renamed from: d, reason: collision with root package name */
    public static zzl f36013d;

    /* renamed from: a, reason: collision with root package name */
    public final Context f36014a;

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f36015b;

    /* renamed from: c, reason: collision with root package name */
    public final ExecutorService f36016c;

    public zzl(Context context) {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f36015b = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        this.f36016c = Executors.newSingleThreadExecutor();
        this.f36014a = context;
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleAtFixedRate(new zzj(this), 0L, 86400L, TimeUnit.SECONDS);
    }

    public static final SharedPreferences b(Context context) {
        return context.getSharedPreferences("app_set_id_storage", 0);
    }

    public static final void c(Context context) throws zzk {
        if (b(context).edit().putLong("app_set_id_last_used_time", DefaultClock.getInstance().currentTimeMillis()).commit()) {
            return;
        }
        String strValueOf = String.valueOf(context.getPackageName());
        Log.e("AppSet", strValueOf.length() != 0 ? "Failed to store app set ID last used time for App ".concat(strValueOf) : new String("Failed to store app set ID last used time for App "));
        throw new zzk("Failed to store the app set ID last used time.");
    }

    @Override // com.google.android.gms.appset.AppSetIdClient
    public final Task a() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f36016c.execute(new Runnable() { // from class: com.google.android.gms.internal.appset.zzh
            @Override // java.lang.Runnable
            public final void run() throws zzk {
                zzl zzlVar = this.f36010a;
                Context context = zzlVar.f36014a;
                String string = zzl.b(context).getString("app_set_id", null);
                long j2 = zzl.b(zzlVar.f36014a).getLong("app_set_id_last_used_time", -1L);
                long j3 = j2 != -1 ? 33696000000L + j2 : -1L;
                TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                if (string == null || DefaultClock.getInstance().currentTimeMillis() > j3) {
                    string = UUID.randomUUID().toString();
                    try {
                        if (!context.getSharedPreferences("app_set_id_storage", 0).edit().putString("app_set_id", string).commit()) {
                            String strValueOf = String.valueOf(context.getPackageName());
                            Log.e("AppSet", strValueOf.length() != 0 ? "Failed to store app set ID generated for App ".concat(strValueOf) : new String("Failed to store app set ID generated for App "));
                            throw new zzk("Failed to store the app set ID.");
                        }
                        zzl.c(context);
                        if (!context.getSharedPreferences("app_set_id_storage", 0).edit().putLong("app_set_id_creation_time", DefaultClock.getInstance().currentTimeMillis()).commit()) {
                            String strValueOf2 = String.valueOf(context.getPackageName());
                            Log.e("AppSet", strValueOf2.length() != 0 ? "Failed to store app set ID creation time for App ".concat(strValueOf2) : new String("Failed to store app set ID creation time for App "));
                            throw new zzk("Failed to store the app set ID creation time.");
                        }
                    } catch (zzk e2) {
                        taskCompletionSource2.a(e2);
                        return;
                    }
                } else {
                    try {
                        zzl.c(context);
                    } catch (zzk e3) {
                        taskCompletionSource2.a(e3);
                        return;
                    }
                }
                taskCompletionSource2.b(new AppSetIdInfo(string, 1));
            }
        });
        return taskCompletionSource.f39750a;
    }
}

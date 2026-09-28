package com.google.android.gms.internal.appset;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.util.DefaultClock;

/* loaded from: classes4.dex */
final class zzj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzl f36012a;

    @Override // java.lang.Runnable
    public final void run() {
        zzl zzlVar = this.f36012a;
        long j2 = zzl.b(zzlVar.f36014a).getLong("app_set_id_last_used_time", -1L);
        long j3 = j2 != -1 ? j2 + 33696000000L : -1L;
        if (j3 == -1 || DefaultClock.getInstance().currentTimeMillis() <= j3) {
            return;
        }
        Context context = zzlVar.f36014a;
        if (!zzl.b(context).edit().remove("app_set_id").commit()) {
            String strValueOf = String.valueOf(context.getPackageName());
            Log.e("AppSet", strValueOf.length() != 0 ? "Failed to clear app set ID generated for App ".concat(strValueOf) : new String("Failed to clear app set ID generated for App "));
        }
        if (context.getSharedPreferences("app_set_id_storage", 0).edit().remove("app_set_id_last_used_time").commit()) {
            return;
        }
        String strValueOf2 = String.valueOf(context.getPackageName());
        Log.e("AppSet", strValueOf2.length() != 0 ? "Failed to clear app set ID last used time for App ".concat(strValueOf2) : new String("Failed to clear app set ID last used time for App "));
    }
}

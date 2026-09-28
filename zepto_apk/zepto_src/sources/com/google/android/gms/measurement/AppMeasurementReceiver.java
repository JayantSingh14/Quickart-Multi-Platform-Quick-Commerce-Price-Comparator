package com.google.android.gms.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.SparseArray;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzgr;
import com.google.android.gms.measurement.internal.zzgt;
import com.google.android.gms.measurement.internal.zzhk;
import com.google.android.gms.measurement.internal.zzib;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes4.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzhk.zza {

    /* renamed from: c, reason: collision with root package name */
    public zzhk f38650c;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f38650c == null) {
            this.f38650c = new zzhk(this);
        }
        zzhk zzhkVar = this.f38650c;
        zzhkVar.getClass();
        zzgt zzgtVar = zzib.r(context, null, null).f39089f;
        zzib.l(zzgtVar);
        zzgr zzgrVar = zzgtVar.f38961i;
        if (intent == null) {
            zzgrVar.a("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zzgr zzgrVar2 = zzgtVar.n;
        zzgrVar2.b(action, "Local receiver got");
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                zzgrVar.a("Install Referrer Broadcasts are deprecated");
                return;
            }
            return;
        }
        Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        zzgrVar2.a("Starting wakeful intent.");
        zzhkVar.f39038a.getClass();
        SparseArray sparseArray = WakefulBroadcastReceiver.f4759a;
        synchronized (sparseArray) {
            try {
                int i2 = WakefulBroadcastReceiver.f4760b;
                int i3 = i2 + 1;
                WakefulBroadcastReceiver.f4760b = i3;
                if (i3 <= 0) {
                    WakefulBroadcastReceiver.f4760b = 1;
                }
                className.putExtra("androidx.contentpager.content.wakelockid", i2);
                ComponentName componentNameStartService = context.startService(className);
                if (componentNameStartService == null) {
                    return;
                }
                PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + componentNameStartService.flattenToShortString());
                wakeLockNewWakeLock.setReferenceCounted(false);
                wakeLockNewWakeLock.acquire(DateUtils.MILLIS_PER_MINUTE);
                sparseArray.put(i2, wakeLockNewWakeLock);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzeuc implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30337a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f30338b;

    public zzeuc(Context context, zzgyw zzgywVar) {
        this.f30337a = zzgywVar;
        this.f30338b = context;
    }

    public final Intent a() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.fc)).booleanValue();
        Context context = this.f30338b;
        return (!zBooleanValue || Build.VERSION.SDK_INT < 33) ? context.registerReceiver(null, intentFilter) : context.registerReceiver(null, intentFilter, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30337a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzeub
            @Override // java.util.concurrent.Callable
            public final Object call() {
                int intExtra;
                boolean zIsCharging;
                int intExtra2;
                zzeuc zzeucVar = this.f30336a;
                zzeucVar.getClass();
                boolean z = true;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.fd)).booleanValue()) {
                    BatteryManager batteryManager = (BatteryManager) zzeucVar.f30338b.getSystemService("batterymanager");
                    intExtra = batteryManager != null ? batteryManager.getIntProperty(4) / 100.0d : -1.0d;
                    if (batteryManager != null) {
                        zIsCharging = batteryManager.isCharging();
                        return new zzeud(intExtra, zIsCharging);
                    }
                    Intent intentA = zzeucVar.a();
                    if (intentA == null || ((intExtra2 = intentA.getIntExtra(CLConstants.OTP_STATUS, -1)) != 2 && intExtra2 != 5)) {
                        z = false;
                    }
                } else {
                    Intent intentA2 = zzeucVar.a();
                    if (intentA2 == null || ((intExtra = intentA2.getIntExtra(CLConstants.OTP_STATUS, -1)) != 2 && intExtra != 5)) {
                        z = false;
                    }
                    if (intentA2 != null) {
                        intExtra = intentA2.getIntExtra("level", -1) / intentA2.getIntExtra("scale", -1);
                    }
                }
                zIsCharging = z;
                return new zzeud(intExtra, zIsCharging);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 14;
    }
}

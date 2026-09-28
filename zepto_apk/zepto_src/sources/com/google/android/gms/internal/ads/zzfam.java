package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzfam implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30757a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f30758b;

    public zzfam(Context context, zzgyw zzgywVar) {
        this.f30757a = zzgywVar;
        this.f30758b = context;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30757a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzfal
            @Override // java.util.concurrent.Callable
            public final Object call() {
                boolean zIsActiveNetworkMetered;
                int i2;
                Context context = this.f30756a.f30758b;
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                String networkOperator = telephonyManager.getNetworkOperator();
                int phoneType = telephonyManager.getPhoneType();
                com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
                com.google.android.gms.ads.internal.util.zzs zzsVar = zztVar.f21679c;
                int i3 = -1;
                if (com.google.android.gms.ads.internal.util.zzs.d(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        int type = activeNetworkInfo.getType();
                        int iOrdinal = activeNetworkInfo.getDetailedState().ordinal();
                        i2 = type;
                        i3 = iOrdinal;
                    } else {
                        i2 = -1;
                    }
                    zIsActiveNetworkMetered = connectivityManager.isActiveNetworkMetered();
                } else {
                    zIsActiveNetworkMetered = false;
                    i2 = -2;
                }
                return new zzfak(networkOperator, i2, zztVar.f21682f.g(context), phoneType, zIsActiveNetworkMetered, i3);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 39;
    }
}

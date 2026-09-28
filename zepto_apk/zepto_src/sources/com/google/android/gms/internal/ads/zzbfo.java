package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzbfo {

    /* renamed from: a, reason: collision with root package name */
    public zzbcg f24899a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f24900b;

    /* renamed from: c, reason: collision with root package name */
    public final ExecutorService f24901c;

    public zzbfo() {
        this.f24901c = com.google.android.gms.ads.internal.util.client.zzb.f21408b;
    }

    public zzbfo(final Context context) {
        ExecutorService executorService = com.google.android.gms.ads.internal.util.client.zzb.f21408b;
        this.f24901c = executorService;
        executorService.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbfk
            @Override // java.lang.Runnable
            public final void run() {
                boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.P5)).booleanValue();
                Context context2 = context;
                zzbfo zzbfoVar = this.f24892a;
                if (zBooleanValue) {
                    try {
                        zzbfoVar.f24899a = (zzbcg) com.google.android.gms.ads.internal.util.client.zzs.a(context2, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzbfl.f24894a);
                        zzbfoVar.f24899a.g1(new ObjectWrapper(context2));
                        zzbfoVar.f24900b = true;
                    } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException unused) {
                        com.google.android.gms.ads.internal.util.client.zzo.a("Cannot dynamite load clearcut");
                    }
                }
            }
        });
    }
}

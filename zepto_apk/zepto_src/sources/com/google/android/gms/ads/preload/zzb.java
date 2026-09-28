package com.google.android.gms.ads.preload;

import android.os.RemoteException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzck;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.internal.ads.zzbsv;

/* loaded from: classes4.dex */
public class zzb {

    /* renamed from: a, reason: collision with root package name */
    public final zzck f21970a;

    /* renamed from: b, reason: collision with root package name */
    public final AdFormat f21971b;

    public zzb(ReactApplicationContext reactApplicationContext, AdFormat adFormat) {
        if (com.google.android.gms.ads.zzb.f21986a == null) {
            synchronized (com.google.android.gms.ads.zzb.class) {
                try {
                    if (com.google.android.gms.ads.zzb.f21986a == null) {
                        com.google.android.gms.ads.zzb.f21986a = zzbb.f21141g.f21143b.d(reactApplicationContext, new zzbsv());
                    }
                } finally {
                }
            }
        }
        this.f21970a = com.google.android.gms.ads.zzb.f21986a;
        reactApplicationContext.getApplicationContext();
        this.f21971b = adFormat;
    }

    public final void a() {
        try {
            this.f21970a.i0(this.f21971b.f20992a);
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
        }
    }
}

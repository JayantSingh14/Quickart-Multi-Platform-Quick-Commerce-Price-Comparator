package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzbqi extends AdManagerInterstitialAd {

    /* renamed from: a, reason: collision with root package name */
    public final Context f25424a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzq f25425b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzbx f25426c;

    /* renamed from: d, reason: collision with root package name */
    public final long f25427d;

    public zzbqi(Context context, String str) {
        zzbsv zzbsvVar = new zzbsv();
        this.f25427d = System.currentTimeMillis();
        new AtomicLong();
        this.f25424a = context;
        new AtomicReference(str);
        this.f25425b = com.google.android.gms.ads.internal.client.zzq.f21280a;
        this.f25426c = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21143b.b(context, new com.google.android.gms.ads.internal.client.zzr(), str, zzbsvVar);
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final ResponseInfo a() {
        com.google.android.gms.ads.internal.client.zzea zzeaVarF = null;
        try {
            com.google.android.gms.ads.internal.client.zzbx zzbxVar = this.f25426c;
            if (zzbxVar != null) {
                zzeaVarF = zzbxVar.f();
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
        return new ResponseInfo(zzeaVarF);
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final void c(FullScreenContentCallback fullScreenContentCallback) {
        try {
            com.google.android.gms.ads.internal.client.zzbx zzbxVar = this.f25426c;
            if (zzbxVar != null) {
                zzbxVar.t5(new com.google.android.gms.ads.internal.client.zzbe(fullScreenContentCallback));
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final void d(boolean z) {
        try {
            com.google.android.gms.ads.internal.client.zzbx zzbxVar = this.f25426c;
            if (zzbxVar != null) {
                zzbxVar.B7(z);
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final void e(Activity activity) {
        if (activity == null) {
            com.google.android.gms.ads.internal.util.client.zzo.f("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            com.google.android.gms.ads.internal.client.zzbx zzbxVar = this.f25426c;
            if (zzbxVar != null) {
                zzbxVar.k6(new ObjectWrapper(activity));
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    public final void f(com.google.android.gms.ads.internal.client.zzek zzekVar, AdLoadCallback adLoadCallback) {
        try {
            com.google.android.gms.ads.internal.client.zzbx zzbxVar = this.f25426c;
            if (zzbxVar != null) {
                zzekVar.n = this.f25427d;
                com.google.android.gms.ads.internal.client.zzq zzqVar = this.f25425b;
                Context context = this.f25424a;
                zzqVar.getClass();
                zzbxVar.Ga(com.google.android.gms.ads.internal.client.zzq.a(context, zzekVar), new com.google.android.gms.ads.internal.client.zzh(adLoadCallback, this));
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
            adLoadCallback.a(new LoadAdError(0, "Internal Error.", "com.google.android.gms.ads", null, null));
        }
    }
}

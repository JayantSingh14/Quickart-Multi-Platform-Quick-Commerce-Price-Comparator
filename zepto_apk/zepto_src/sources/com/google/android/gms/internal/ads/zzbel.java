package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* loaded from: classes4.dex */
public final class zzbel {

    /* renamed from: a, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zzbx f24835a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f24836b;

    /* renamed from: c, reason: collision with root package name */
    public final String f24837c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzek f24838d;

    /* renamed from: e, reason: collision with root package name */
    public final AppOpenAd.AppOpenAdLoadCallback f24839e;

    /* renamed from: f, reason: collision with root package name */
    public final zzbsv f24840f = new zzbsv();

    /* renamed from: g, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzq f24841g = com.google.android.gms.ads.internal.client.zzq.f21280a;

    public zzbel(Context context, String str, com.google.android.gms.ads.internal.client.zzek zzekVar, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.f24836b = context;
        this.f24837c = str;
        this.f24838d = zzekVar;
        this.f24839e = appOpenAdLoadCallback;
    }

    public final void a() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.google.android.gms.ads.internal.client.zzr zzrVarR = com.google.android.gms.ads.internal.client.zzr.r();
            com.google.android.gms.ads.internal.client.zzaz zzazVar = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21143b;
            Context context = this.f24836b;
            String str = this.f24837c;
            com.google.android.gms.ads.internal.client.zzbx zzbxVarA = zzazVar.a(context, zzrVarR, str, this.f24840f);
            this.f24835a = zzbxVarA;
            if (zzbxVarA != null) {
                com.google.android.gms.ads.internal.client.zzek zzekVar = this.f24838d;
                zzekVar.n = jCurrentTimeMillis;
                zzbxVarA.z2(new zzbdy(this.f24839e, str));
                com.google.android.gms.ads.internal.client.zzbx zzbxVar = this.f24835a;
                this.f24841g.getClass();
                zzbxVar.U0(com.google.android.gms.ads.internal.client.zzq.a(context, zzekVar));
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }
}

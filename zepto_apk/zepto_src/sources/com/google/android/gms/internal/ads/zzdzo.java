package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzdzo implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdzp f28844a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbpt f28845b;

    public /* synthetic */ zzdzo(zzdzp zzdzpVar, zzbpt zzbptVar) {
        this.f28844a = zzdzpVar;
        this.f28845b = zzbptVar;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        try {
            this.f28845b.r5(this.f28844a.b());
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
        }
    }
}

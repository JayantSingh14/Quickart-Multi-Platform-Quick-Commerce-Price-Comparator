package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzerb implements zzdan {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzeqp f30150a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbqh f30151b;

    public /* synthetic */ zzerb(zzeqp zzeqpVar, zzbqh zzbqhVar) {
        this.f30150a = zzeqpVar;
        this.f30151b = zzbqhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final /* synthetic */ void m0(com.google.android.gms.ads.internal.client.zze zzeVar) {
        this.f30150a.m0(zzeVar);
        zzbqh zzbqhVar = this.f30151b;
        if (zzbqhVar != null) {
            try {
                zzbqhVar.a(zzeVar);
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
            }
        }
        if (zzbqhVar != null) {
            try {
                zzbqhVar.zzf(zzeVar.f21161a);
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
            }
        }
    }
}

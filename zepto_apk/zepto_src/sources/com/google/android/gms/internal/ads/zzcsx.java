package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzcsx extends zzbec {

    /* renamed from: a, reason: collision with root package name */
    public final zzcsw f27076a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzbx f27077b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfdr f27078c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f27079d = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.c1)).booleanValue();

    /* renamed from: e, reason: collision with root package name */
    public final zzdxe f27080e;

    public zzcsx(zzcsw zzcswVar, com.google.android.gms.ads.internal.client.zzbx zzbxVar, zzfdr zzfdrVar, zzdxe zzdxeVar) {
        this.f27076a = zzcswVar;
        this.f27077b = zzbxVar;
        this.f27078c = zzfdrVar;
        this.f27080e = zzdxeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbed
    public final void K5(IObjectWrapper iObjectWrapper, zzbek zzbekVar) {
        try {
            this.f27078c.f30898d.set(zzbekVar);
            this.f27076a.c((Activity) ObjectWrapper.z0(iObjectWrapper), this.f27079d);
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbed
    public final com.google.android.gms.ads.internal.client.zzea zzg() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.s7)).booleanValue()) {
            return this.f27076a.f27232f;
        }
        return null;
    }
}

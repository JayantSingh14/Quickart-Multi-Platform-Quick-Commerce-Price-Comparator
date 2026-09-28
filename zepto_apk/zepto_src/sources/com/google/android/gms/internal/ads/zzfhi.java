package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzfhi extends zzcae {

    /* renamed from: b, reason: collision with root package name */
    public final zzfhe f31115b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfgv f31116c;

    /* renamed from: d, reason: collision with root package name */
    public final String f31117d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfid f31118e;

    /* renamed from: f, reason: collision with root package name */
    public final Context f31119f;

    /* renamed from: g, reason: collision with root package name */
    public final VersionInfoParcel f31120g;

    /* renamed from: h, reason: collision with root package name */
    public final zzayq f31121h;

    /* renamed from: i, reason: collision with root package name */
    public final zzdxe f31122i;

    /* renamed from: j, reason: collision with root package name */
    public zzdte f31123j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f31124k = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Z0)).booleanValue();

    public zzfhi(String str, zzfhe zzfheVar, Context context, zzfgv zzfgvVar, zzfid zzfidVar, VersionInfoParcel versionInfoParcel, zzayq zzayqVar, zzdxe zzdxeVar) {
        this.f31117d = str;
        this.f31115b = zzfheVar;
        this.f31116c = zzfgvVar;
        this.f31118e = zzfidVar;
        this.f31119f = context;
        this.f31120g = versionInfoParcel;
        this.f31121h = zzayqVar;
        this.f31122i = zzdxeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final synchronized void I5(com.google.android.gms.ads.internal.client.zzm zzmVar, zzcam zzcamVar) {
        Xb(zzmVar, zzcamVar, 2);
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final synchronized void N(IObjectWrapper iObjectWrapper) {
        V6(iObjectWrapper, this.f31124k);
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void O3(zzcan zzcanVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.f31116c.f31081f.set(zzcanVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void Ta(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        try {
            if (!zzdtVar.zzf()) {
                this.f31122i.b();
            }
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.b("Error in making CSI ping for reporting paid event callback", e2);
        }
        this.f31116c.f31083h.set(zzdtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final synchronized void V6(IObjectWrapper iObjectWrapper, boolean z) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.f31123j == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Rewarded can not be shown before loaded");
            this.f31116c.c(zzfjm.d(9, null, null));
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.q3)).booleanValue()) {
                this.f31121h.f24512b.h(new Throwable().getStackTrace());
            }
            this.f31123j.c((Activity) ObjectWrapper.z0(iObjectWrapper), z);
        }
    }

    public final synchronized void Xb(com.google.android.gms.ads.internal.client.zzm zzmVar, zzcam zzcamVar, int i2) {
        try {
            if (!zzmVar.r()) {
                boolean z = false;
                if (((Boolean) zzbii.f25165k.c()).booleanValue()) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.oc)).booleanValue()) {
                        z = true;
                    }
                }
                if (this.f31120g.f21402c < ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.pc)).intValue() || !z) {
                    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
                }
            }
            zzfgv zzfgvVar = this.f31116c;
            zzfgvVar.f31078c.set(zzcamVar);
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
            if (com.google.android.gms.ads.internal.util.zzs.h(this.f31119f) && zzmVar.s == null) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.c("Failed to load the ad because app ID is missing.");
                zzfgvVar.m0(zzfjm.d(4, null, null));
                return;
            }
            if (this.f31123j != null) {
                return;
            }
            zzfgx zzfgxVar = new zzfgx();
            zzfhe zzfheVar = this.f31115b;
            zzfheVar.f31104h.o.f31183a = i2;
            zzfheVar.a(zzmVar, this.f31117d, zzfgxVar, new zzfhh(this));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final synchronized void a5(com.google.android.gms.ads.internal.client.zzm zzmVar, zzcam zzcamVar) {
        Xb(zzmVar, zzcamVar, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void b9(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        zzfgv zzfgvVar = this.f31116c;
        if (zzdqVar == null) {
            zzfgvVar.f31077b.set(null);
        } else {
            zzfgvVar.f31077b.set(new zzfhg(this, zzdqVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final synchronized void f0(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.f31124k = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final synchronized void fa(long j2) {
        zzcze zzczeVar;
        zzdte zzdteVar = this.f31123j;
        if (zzdteVar == null || (zzczeVar = zzdteVar.f27236j) == null) {
            return;
        }
        zzczeVar.a(j2);
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void q5(zzcai zzcaiVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.f31116c.f31079d.set(zzcaiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final synchronized void v6(zzcat zzcatVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzfid zzfidVar = this.f31118e;
        zzfidVar.f31195a = zzcatVar.f25795a;
        zzfidVar.f31196b = zzcatVar.f25796b;
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final Bundle zzg() {
        Bundle bundle;
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdte zzdteVar = this.f31123j;
        if (zzdteVar == null) {
            return new Bundle();
        }
        zzdce zzdceVar = zzdteVar.q;
        synchronized (zzdceVar) {
            bundle = new Bundle(zzdceVar.f27604b);
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final boolean zzi() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdte zzdteVar = this.f31123j;
        return (zzdteVar == null || zzdteVar.w) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final synchronized String zzj() {
        zzdad zzdadVar;
        zzdte zzdteVar = this.f31123j;
        if (zzdteVar == null || (zzdadVar = zzdteVar.f27232f) == null) {
            return null;
        }
        return zzdadVar.f27543a;
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final zzcac zzl() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdte zzdteVar = this.f31123j;
        if (zzdteVar != null) {
            return zzdteVar.s;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final com.google.android.gms.ads.internal.client.zzea zzm() {
        zzdte zzdteVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.s7)).booleanValue() && (zzdteVar = this.f31123j) != null) {
            return zzdteVar.f27232f;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final String zzn() {
        return this.f31117d;
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final synchronized long zzq() {
        zzcze zzczeVar;
        zzdte zzdteVar = this.f31123j;
        if (zzdteVar == null || (zzczeVar = zzdteVar.f27236j) == null) {
            return 0L;
        }
        return zzczeVar.f27458a.get();
    }
}

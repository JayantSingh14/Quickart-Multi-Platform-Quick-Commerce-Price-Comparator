package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes4.dex */
public final class zzber {

    /* renamed from: a, reason: collision with root package name */
    public ScheduledFuture f24846a = null;

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f24847b = new zzben(this);

    /* renamed from: c, reason: collision with root package name */
    public final Object f24848c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public zzbeu f24849d;

    /* renamed from: e, reason: collision with root package name */
    public Context f24850e;

    /* renamed from: f, reason: collision with root package name */
    public zzbex f24851f;

    public final void a(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.f24848c) {
            try {
                if (this.f24850e != null) {
                    return;
                }
                this.f24850e = context.getApplicationContext();
                zzbgb zzbgbVar = zzbgk.U4;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                    d();
                } else {
                    if (((Boolean) zzbdVar.f21153c.a(zzbgk.T4)).booleanValue()) {
                        com.google.android.gms.ads.internal.zzt.C.f21683g.b(new zzbeo(this));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzbes b(zzbev zzbevVar) {
        synchronized (this.f24848c) {
            if (this.f24851f == null) {
                return new zzbes();
            }
            try {
                if (this.f24849d.c()) {
                    zzbex zzbexVar = this.f24851f;
                    Parcel parcelG = zzbexVar.g();
                    zzbcd.c(parcelG, zzbevVar);
                    Parcel parcelZ0 = zzbexVar.z0(2, parcelG);
                    zzbes zzbesVar = (zzbes) zzbcd.b(parcelZ0, zzbes.CREATOR);
                    parcelZ0.recycle();
                    return zzbesVar;
                }
                zzbex zzbexVar2 = this.f24851f;
                Parcel parcelG2 = zzbexVar2.g();
                zzbcd.c(parcelG2, zzbevVar);
                Parcel parcelZ02 = zzbexVar2.z0(1, parcelG2);
                zzbes zzbesVar2 = (zzbes) zzbcd.b(parcelZ02, zzbes.CREATOR);
                parcelZ02.recycle();
                return zzbesVar2;
            } catch (RemoteException e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Unable to call into cache service.", e2);
                return new zzbes();
            }
        }
    }

    public final /* synthetic */ void c() {
        synchronized (this.f24848c) {
            try {
                zzbeu zzbeuVar = this.f24849d;
                if (zzbeuVar == null) {
                    return;
                }
                if (zzbeuVar.isConnected() || this.f24849d.isConnecting()) {
                    this.f24849d.disconnect();
                }
                this.f24849d = null;
                this.f24851f = null;
                Binder.flushPendingCommands();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        zzbeu zzbeuVar;
        synchronized (this.f24848c) {
            if (this.f24850e != null && this.f24849d == null) {
                zzbep zzbepVar = new zzbep(this);
                zzbeq zzbeqVar = new zzbeq(this);
                synchronized (this) {
                    zzbeuVar = new zzbeu(this.f24850e, com.google.android.gms.ads.internal.zzt.C.t.a(), zzbepVar, zzbeqVar);
                }
                this.f24849d = zzbeuVar;
                zzbeuVar.checkAvailabilityAndConnect();
            }
        }
    }
}

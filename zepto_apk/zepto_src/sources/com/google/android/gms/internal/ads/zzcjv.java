package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzcjv implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcjx f26436a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f26437b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f26438c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f26439d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f26440e;

    public /* synthetic */ zzcjv(zzcjx zzcjxVar, int i2, int i3, boolean z, boolean z2) {
        this.f26436a = zzcjxVar;
        this.f26437b = i2;
        this.f26438c = i3;
        this.f26439d = z;
        this.f26440e = z2;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        int i2;
        boolean z;
        boolean z2;
        com.google.android.gms.ads.internal.client.zzeg zzegVar;
        com.google.android.gms.ads.internal.client.zzeg zzegVar2;
        com.google.android.gms.ads.internal.client.zzeg zzegVar3;
        zzcjx zzcjxVar = this.f26436a;
        int i3 = this.f26437b;
        int i4 = this.f26438c;
        boolean z3 = this.f26439d;
        boolean z4 = this.f26440e;
        synchronized (zzcjxVar.f26444b) {
            try {
                boolean z5 = zzcjxVar.f26449g;
                if (z5 || i4 != 1) {
                    i2 = i4;
                    z = false;
                } else {
                    i4 = 1;
                    i2 = 1;
                    z = true;
                }
                boolean z6 = i3 != i4;
                if (z6 && i2 == 1) {
                    z2 = true;
                    i2 = 1;
                } else {
                    z2 = false;
                }
                boolean z7 = z6 && i2 == 2;
                boolean z8 = z6 && i2 == 3;
                zzcjxVar.f26449g = z5 || z;
                if (z) {
                    try {
                        com.google.android.gms.ads.internal.client.zzeg zzegVar4 = zzcjxVar.f26448f;
                        if (zzegVar4 != null) {
                            zzegVar4.zze();
                        }
                    } catch (RemoteException e2) {
                        com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
                    }
                }
                if (z2 && (zzegVar3 = zzcjxVar.f26448f) != null) {
                    zzegVar3.zzf();
                }
                if (z7 && (zzegVar2 = zzcjxVar.f26448f) != null) {
                    zzegVar2.zzg();
                }
                if (z8) {
                    com.google.android.gms.ads.internal.client.zzeg zzegVar5 = zzcjxVar.f26448f;
                    if (zzegVar5 != null) {
                        zzegVar5.zzh();
                    }
                    zzcjxVar.f26443a.m0();
                }
                if (z3 != z4 && (zzegVar = zzcjxVar.f26448f) != null) {
                    zzegVar.P4(z4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

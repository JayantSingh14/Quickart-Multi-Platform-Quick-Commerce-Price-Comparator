package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzbdc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbdd f24759a;

    public zzbdc(zzbdd zzbddVar) {
        this.f24759a = zzbddVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbdd zzbddVar = this.f24759a;
        synchronized (zzbddVar.f24762c) {
            if (zzbddVar.f24763d.get() && zzbddVar.f24764e) {
                zzbddVar.f24763d.set(false);
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.a("App went background");
                Iterator it = zzbddVar.f24765f.iterator();
                while (it.hasNext()) {
                    try {
                        ((zzbde) it.next()).j1(false);
                    } catch (Exception e2) {
                        com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
                    }
                }
            } else {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.a("App is still foreground");
            }
        }
    }
}

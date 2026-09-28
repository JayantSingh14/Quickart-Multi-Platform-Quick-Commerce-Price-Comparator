package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes4.dex */
final class zzfqr implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.ads.internal.client.zze f31659a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfqy f31660b;

    public zzfqr(zzfqy zzfqyVar, com.google.android.gms.ads.internal.client.zze zzeVar) {
        this.f31659a = zzeVar;
        this.f31660b = zzfqyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfqy zzfqyVar = this.f31660b;
        com.google.android.gms.ads.internal.client.zze zzeVar = this.f31659a;
        synchronized (zzfqyVar) {
            com.google.android.gms.ads.internal.client.zzch zzchVar = zzfqyVar.f31675i;
            if (zzchVar != null) {
                try {
                    zzchVar.W8(zzfqyVar.f31678l, zzeVar);
                } catch (RemoteException unused) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("Failed to call onAdFailedToPreload");
                }
            }
        }
    }
}

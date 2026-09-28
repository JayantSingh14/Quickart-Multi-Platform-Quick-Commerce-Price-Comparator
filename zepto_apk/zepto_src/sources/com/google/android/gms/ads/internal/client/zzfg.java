package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfh f21230a;

    public zzfg(zzfh zzfhVar) {
        Objects.requireNonNull(zzfhVar);
        this.f21230a = zzfhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbk zzbkVar = this.f21230a.f21231a.f21232a;
        if (zzbkVar != null) {
            try {
                zzbkVar.l(1);
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.client.zzo.g("Could not notify onAdFailedToLoad event.", e2);
            }
        }
    }
}

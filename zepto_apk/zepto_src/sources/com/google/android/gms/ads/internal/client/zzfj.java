package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfk f21233a;

    public zzfj(zzfk zzfkVar) {
        Objects.requireNonNull(zzfkVar);
        this.f21233a = zzfkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbk zzbkVar = this.f21233a.f21234a;
        if (zzbkVar != null) {
            try {
                zzbkVar.l(1);
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.client.zzo.g("Could not notify onAdFailedToLoad event.", e2);
            }
        }
    }
}

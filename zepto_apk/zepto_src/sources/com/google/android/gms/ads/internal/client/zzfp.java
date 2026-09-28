package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcam;

/* loaded from: classes4.dex */
final /* synthetic */ class zzfp implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcam f21237a;

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        zzcam zzcamVar = this.f21237a;
        if (zzcamVar != null) {
            try {
                zzcamVar.zzf(1);
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
            }
        }
    }
}

package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbep implements BaseGmsClient.BaseConnectionCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzber f24844a;

    public zzbep(zzber zzberVar) {
        Objects.requireNonNull(zzberVar);
        this.f24844a = zzberVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzbeu zzbeuVar;
        zzber zzberVar = this.f24844a;
        synchronized (zzberVar.f24848c) {
            try {
                zzbeuVar = zzberVar.f24849d;
            } catch (DeadObjectException e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Unable to obtain a cache service instance.", e2);
                this.f24844a.c();
            }
            if (zzbeuVar != null) {
                zzberVar.f24851f = (zzbex) zzbeuVar.getService();
                this.f24844a.f24848c.notifyAll();
            } else {
                this.f24844a.f24848c.notifyAll();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i2) {
        zzber zzberVar = this.f24844a;
        synchronized (zzberVar.f24848c) {
            zzberVar.f24851f = null;
            zzberVar.f24848c.notifyAll();
        }
    }
}

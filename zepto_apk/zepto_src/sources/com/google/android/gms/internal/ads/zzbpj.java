package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbpj implements BaseGmsClient.BaseConnectionCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcdt f25406a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbpl f25407b;

    public zzbpj(zzbpl zzbplVar, zzcdt zzcdtVar) {
        this.f25406a = zzcdtVar;
        Objects.requireNonNull(zzbplVar);
        this.f25407b = zzbplVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        try {
            this.f25406a.b((zzbpf) this.f25407b.f25409a.getService());
        } catch (DeadObjectException e2) {
            this.f25406a.c(e2);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i2) {
        this.f25406a.c(new RuntimeException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i2).length() + 23), i2, "onConnectionSuspended: ")));
    }
}

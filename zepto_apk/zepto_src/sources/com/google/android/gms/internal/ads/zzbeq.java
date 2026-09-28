package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbeq implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzber f24845a;

    public zzbeq(zzber zzberVar) {
        Objects.requireNonNull(zzberVar);
        this.f24845a = zzberVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzber zzberVar = this.f24845a;
        synchronized (zzberVar.f24848c) {
            zzberVar.f24851f = null;
            if (zzberVar.f24849d != null) {
                zzberVar.f24849d = null;
            }
            zzberVar.f24848c.notifyAll();
        }
    }
}

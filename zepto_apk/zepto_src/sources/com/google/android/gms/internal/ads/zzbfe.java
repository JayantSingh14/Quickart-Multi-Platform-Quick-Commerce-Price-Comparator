package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* loaded from: classes4.dex */
final class zzbfe implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcdt f24879a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbff f24880b;

    public zzbfe(zzbff zzbffVar, zzcdt zzcdtVar) {
        this.f24879a = zzcdtVar;
        this.f24880b = zzbffVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.f24880b.f24883c) {
            this.f24879a.c(new RuntimeException("Connection failed."));
        }
    }
}

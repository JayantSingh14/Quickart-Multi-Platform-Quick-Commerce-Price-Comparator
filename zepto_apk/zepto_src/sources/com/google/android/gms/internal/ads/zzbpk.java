package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbpk implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcdt f25408a;

    public zzbpk(zzbpl zzbplVar, zzcdt zzcdtVar) {
        this.f25408a = zzcdtVar;
        Objects.requireNonNull(zzbplVar);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f25408a.c(new RuntimeException("Connection failed."));
    }
}

package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfps extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfpu f31588a;

    public zzfps(zzfpu zzfpuVar) {
        Objects.requireNonNull(zzfpuVar);
        this.f31588a = zzfpuVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        this.f31588a.a(true);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        this.f31588a.a(false);
    }
}

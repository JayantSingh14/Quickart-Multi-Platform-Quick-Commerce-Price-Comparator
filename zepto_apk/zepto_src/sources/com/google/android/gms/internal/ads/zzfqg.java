package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfqg extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfqh f31626a;

    public zzfqg(zzfqh zzfqhVar) {
        Objects.requireNonNull(zzfqhVar);
        this.f31626a = zzfqhVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        this.f31626a.b(true);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        this.f31626a.b(false);
    }
}

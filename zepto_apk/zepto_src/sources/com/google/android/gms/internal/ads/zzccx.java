package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzccx extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcda f25918a;

    public zzccx(zzcda zzcdaVar) {
        Objects.requireNonNull(zzcdaVar);
        this.f25918a = zzcdaVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        this.f25918a.p.set(true);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        this.f25918a.p.set(false);
    }
}

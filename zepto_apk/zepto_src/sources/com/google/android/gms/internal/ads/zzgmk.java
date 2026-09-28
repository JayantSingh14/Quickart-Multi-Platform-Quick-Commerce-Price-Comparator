package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzgmk extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgmm f32919a;

    public zzgmk(zzgmm zzgmmVar) {
        Objects.requireNonNull(zzgmmVar);
        this.f32919a = zzgmmVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        zzgmm zzgmmVar = this.f32919a;
        synchronized (zzgmmVar) {
            zzgmmVar.f32923c = networkCapabilities;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        zzgmm zzgmmVar = this.f32919a;
        synchronized (zzgmmVar) {
            zzgmmVar.f32923c = null;
        }
    }
}

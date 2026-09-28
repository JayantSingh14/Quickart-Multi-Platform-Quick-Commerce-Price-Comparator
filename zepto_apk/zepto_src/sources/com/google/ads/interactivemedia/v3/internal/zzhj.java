package com.google.ads.interactivemedia.v3.internal;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* loaded from: classes3.dex */
final class zzhj extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzhk zza;

    public zzhj(zzhk zzhkVar) {
        this.zza = zzhkVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        synchronized (zzhk.class) {
            this.zza.zza = networkCapabilities;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        synchronized (zzhk.class) {
            this.zza.zza = null;
        }
    }
}

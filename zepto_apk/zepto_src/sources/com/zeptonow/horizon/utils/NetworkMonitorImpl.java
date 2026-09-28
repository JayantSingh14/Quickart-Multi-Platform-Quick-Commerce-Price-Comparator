package com.zeptonow.horizon.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata
@SuppressLint({"MissingPermission"})
/* loaded from: classes.dex */
public final class NetworkMonitorImpl implements NetworkMonitor {

    /* renamed from: a, reason: collision with root package name */
    public final MutableStateFlow f48269a;

    /* renamed from: b, reason: collision with root package name */
    public final StateFlow f48270b;

    public NetworkMonitorImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MutableStateFlow mutableStateFlowA = StateFlowKt.a(Boolean.FALSE);
        this.f48269a = mutableStateFlowA;
        this.f48270b = mutableStateFlowA;
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.zeptonow.horizon.utils.NetworkMonitorImpl$networkCallback$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                this.f48271a.f48269a.setValue(Boolean.TRUE);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                this.f48271a.f48269a.setValue(Boolean.FALSE);
            }
        };
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).build();
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        connectivityManager.registerNetworkCallback(networkRequestBuild, networkCallback);
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        boolean z = false;
        if (networkCapabilities != null && networkCapabilities.hasCapability(12)) {
            z = true;
        }
        mutableStateFlowA.setValue(Boolean.valueOf(z));
    }

    @Override // com.zeptonow.horizon.utils.NetworkMonitor
    public final StateFlow isConnected() {
        return this.f48270b;
    }
}

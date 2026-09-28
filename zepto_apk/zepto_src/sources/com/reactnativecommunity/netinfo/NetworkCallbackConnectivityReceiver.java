package com.reactnativecommunity.netinfo;

import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.a;
import com.facebook.react.bridge.ReactApplicationContext;
import com.reactnativecommunity.netinfo.types.CellularGeneration;
import com.reactnativecommunity.netinfo.types.ConnectionType;
import org.xbill.DNS.Type;

@TargetApi(24)
/* loaded from: classes.dex */
public class NetworkCallbackConnectivityReceiver extends ConnectivityReceiver {

    /* renamed from: j, reason: collision with root package name */
    public final ConnectivityNetworkCallback f46189j;

    /* renamed from: k, reason: collision with root package name */
    public Network f46190k;

    /* renamed from: l, reason: collision with root package name */
    public NetworkCapabilities f46191l;

    public class ConnectivityNetworkCallback extends ConnectivityManager.NetworkCallback {
        public ConnectivityNetworkCallback() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network network) {
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            networkCallbackConnectivityReceiver.f46190k = network;
            networkCallbackConnectivityReceiver.f(Type.TSIG);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            networkCallbackConnectivityReceiver.f46190k = network;
            networkCallbackConnectivityReceiver.f46191l = networkCapabilities;
            networkCallbackConnectivityReceiver.g();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            if (networkCallbackConnectivityReceiver.f46190k != null) {
                networkCallbackConnectivityReceiver.f46190k = network;
            }
            networkCallbackConnectivityReceiver.f(Type.TSIG);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLosing(Network network, int i2) {
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            networkCallbackConnectivityReceiver.f46190k = network;
            networkCallbackConnectivityReceiver.g();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network network) {
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            networkCallbackConnectivityReceiver.f46190k = null;
            networkCallbackConnectivityReceiver.f46191l = null;
            networkCallbackConnectivityReceiver.g();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onUnavailable() {
            NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = NetworkCallbackConnectivityReceiver.this;
            networkCallbackConnectivityReceiver.f46190k = null;
            networkCallbackConnectivityReceiver.f46191l = null;
            networkCallbackConnectivityReceiver.g();
        }
    }

    public NetworkCallbackConnectivityReceiver(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.f46190k = null;
        this.f46191l = null;
        this.f46189j = new ConnectivityNetworkCallback();
    }

    @Override // com.reactnativecommunity.netinfo.ConnectivityReceiver
    public final void c() {
        ConnectivityManager connectivityManager = this.f46180a;
        try {
            this.f46190k = connectivityManager.getActiveNetwork();
            f(0);
            connectivityManager.registerDefaultNetworkCallback(this.f46189j);
        } catch (SecurityException unused) {
        }
    }

    @Override // com.reactnativecommunity.netinfo.ConnectivityReceiver
    public final void d() {
        try {
            this.f46180a.unregisterNetworkCallback(this.f46189j);
        } catch (IllegalArgumentException | SecurityException unused) {
        }
    }

    public final void f(int i2) {
        new Handler(Looper.getMainLooper()).postDelayed(new a(this, 6), i2);
    }

    public final void g() {
        ConnectionType connectionType = ConnectionType.UNKNOWN;
        Network network = this.f46190k;
        NetworkCapabilities networkCapabilities = this.f46191l;
        CellularGeneration cellularGenerationA = null;
        boolean z = false;
        if (networkCapabilities != null) {
            boolean zHasTransport = networkCapabilities.hasTransport(4);
            ConnectionType connectionType2 = ConnectionType.CELLULAR;
            if (zHasTransport) {
                connectionType = ConnectionType.VPN;
            } else if (networkCapabilities.hasTransport(2)) {
                connectionType = ConnectionType.BLUETOOTH;
            } else if (networkCapabilities.hasTransport(0)) {
                connectionType = connectionType2;
            } else if (networkCapabilities.hasTransport(3)) {
                connectionType = ConnectionType.ETHERNET;
            } else if (networkCapabilities.hasTransport(1)) {
                connectionType = ConnectionType.WIFI;
            }
            NetworkInfo networkInfo = network != null ? this.f46180a.getNetworkInfo(network) : null;
            boolean z2 = networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16) && !(Build.VERSION.SDK_INT >= 28 ? networkCapabilities.hasCapability(21) ^ true : network != null && networkInfo != null && !networkInfo.getDetailedState().equals(NetworkInfo.DetailedState.CONNECTED));
            if (!networkCapabilities.hasTransport(4)) {
                z = z2;
            } else if (z2 && networkCapabilities.getLinkDownstreamBandwidthKbps() != 0) {
                z = true;
            }
            if (network != null && connectionType == connectionType2 && z) {
                cellularGenerationA = CellularGeneration.a(networkInfo);
            }
        } else {
            connectionType = ConnectionType.NONE;
        }
        e(connectionType, cellularGenerationA, z);
    }
}

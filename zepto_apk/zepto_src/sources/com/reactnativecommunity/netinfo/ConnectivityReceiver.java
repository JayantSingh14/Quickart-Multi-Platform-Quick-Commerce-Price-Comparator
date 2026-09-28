package com.reactnativecommunity.netinfo;

import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import androidx.fragment.app.e;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.reactnativecommunity.netinfo.types.CellularGeneration;
import com.reactnativecommunity.netinfo.types.ConnectionType;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Iterator;
import java.util.Locale;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public abstract class ConnectivityReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final ConnectivityManager f46180a;

    /* renamed from: b, reason: collision with root package name */
    public final WifiManager f46181b;

    /* renamed from: c, reason: collision with root package name */
    public final TelephonyManager f46182c;

    /* renamed from: d, reason: collision with root package name */
    public final ReactApplicationContext f46183d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f46184e = false;

    /* renamed from: f, reason: collision with root package name */
    public ConnectionType f46185f = ConnectionType.UNKNOWN;

    /* renamed from: g, reason: collision with root package name */
    public CellularGeneration f46186g = null;

    /* renamed from: h, reason: collision with root package name */
    public boolean f46187h = false;

    /* renamed from: i, reason: collision with root package name */
    public Boolean f46188i;

    public ConnectivityReceiver(ReactApplicationContext reactApplicationContext) {
        this.f46183d = reactApplicationContext;
        this.f46180a = (ConnectivityManager) reactApplicationContext.getSystemService("connectivity");
        this.f46181b = (WifiManager) reactApplicationContext.getApplicationContext().getSystemService("wifi");
        this.f46182c = (TelephonyManager) reactApplicationContext.getSystemService("phone");
    }

    public static String b(InetAddress inetAddress) {
        short networkPrefixLength;
        Iterator<InterfaceAddress> it = NetworkInterface.getByInetAddress(inetAddress).getInterfaceAddresses().iterator();
        while (true) {
            if (!it.hasNext()) {
                networkPrefixLength = 0;
                break;
            }
            InterfaceAddress next = it.next();
            if (next.getAddress().getAddress().length == 4) {
                networkPrefixLength = next.getNetworkPrefixLength();
                break;
            }
        }
        int i2 = (-1) << (32 - networkPrefixLength);
        Locale locale = Locale.US;
        StringBuilder sb = new StringBuilder();
        sb.append((i2 >> 24) & 255);
        sb.append(CLConstants.DOT_SALT_DELIMETER);
        sb.append((i2 >> 16) & 255);
        sb.append(CLConstants.DOT_SALT_DELIMETER);
        sb.append((i2 >> 8) & 255);
        return e.r(sb, i2 & 255, CLConstants.DOT_SALT_DELIMETER);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.facebook.react.bridge.WritableMap a(java.lang.String r13) throws java.net.SocketException {
        /*
            Method dump skipped, instructions count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.netinfo.ConnectivityReceiver.a(java.lang.String):com.facebook.react.bridge.WritableMap");
    }

    public abstract void c();

    public abstract void d();

    public final void e(ConnectionType connectionType, CellularGeneration cellularGeneration, boolean z) {
        Boolean bool = this.f46188i;
        if (bool != null) {
            z = bool.booleanValue();
        }
        boolean z2 = connectionType != this.f46185f;
        boolean z3 = cellularGeneration != this.f46186g;
        boolean z4 = z != this.f46187h;
        if (z2 || z3 || z4) {
            this.f46185f = connectionType;
            this.f46186g = cellularGeneration;
            this.f46187h = z;
            if (this.f46184e) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.f46183d.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("netInfo.networkStatusDidChange", a(null));
            }
        }
    }
}

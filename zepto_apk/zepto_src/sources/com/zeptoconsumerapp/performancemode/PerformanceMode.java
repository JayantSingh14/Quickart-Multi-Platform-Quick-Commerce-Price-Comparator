package com.zeptoconsumerapp.performancemode;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import com.zeptoconsumerapp.performancemode.performanceClasses.BandwidthAverages;
import com.zeptoconsumerapp.performancemode.performanceClasses.BatteryPerformanceClass;
import com.zeptoconsumerapp.performancemode.performanceClasses.BatteryPerformanceResult;
import com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator;
import com.zeptoconsumerapp.performancemode.performanceClasses.NetworkConnectionType;
import com.zeptoconsumerapp.performancemode.performanceClasses.NetworkPerformanceClass;
import com.zeptoconsumerapp.performancemode.performanceClasses.NetworkPerformanceResult;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import timber.log.Timber;

@Metadata
/* loaded from: classes4.dex */
public final class PerformanceMode {

    @Metadata
    public static final class Companion {
        public static void a(Context context) {
            NetworkPerformanceResult networkPerformanceResult;
            NetworkCapabilities networkCapabilities;
            NetworkCapabilities networkCapabilities2;
            NetworkConnectionType networkConnectionType;
            if (context == null) {
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Lazy lazy = PerformanceModeResults.f47736a;
            BatteryPerformanceClass batteryPerformanceClass = new BatteryPerformanceClass(context);
            Timber.d("PSP").d("Measuring battery", new Object[0]);
            Context context2 = batteryPerformanceClass.f47753a;
            Object systemService = context2.getSystemService("batterymanager");
            Intrinsics.d(systemService, "null cannot be cast to non-null type android.os.BatteryManager");
            BatteryManager batteryManager = (BatteryManager) systemService;
            Object systemService2 = context2.getSystemService("power");
            Intrinsics.d(systemService2, "null cannot be cast to non-null type android.os.PowerManager");
            PowerManager powerManager = (PowerManager) systemService2;
            Intent intentRegisterReceiver = context2.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            boolean z = (intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(CLConstants.OTP_STATUS, -1) : -1) == 2;
            int intProperty = batteryManager.getIntProperty(4);
            boolean zIsPowerSaveMode = powerManager.isPowerSaveMode();
            Timber.d("PSP").d("Battery: charging=" + z + ", percentage=" + intProperty + "%, powerSaver=" + zIsPowerSaveMode, new Object[0]);
            PerformanceModeResults.f47740e = new BatteryPerformanceResult(intProperty, z, zIsPowerSaveMode);
            NetworkPerformanceClass networkPerformanceClass = new NetworkPerformanceClass(context);
            int i2 = Build.VERSION.SDK_INT;
            Context context3 = networkPerformanceClass.f47784a;
            Object systemService3 = context3.getApplicationContext().getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService3 instanceof ConnectivityManager ? (ConnectivityManager) systemService3 : null;
            if (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null || (!networkCapabilities.hasTransport(1) && !networkCapabilities.hasTransport(0))) {
                Timber.d("PSP").i("No internet", new Object[0]);
                networkPerformanceResult = new NetworkPerformanceResult(90000, 90000, 90000, 90000, NetworkConnectionType.f47780h, true);
            } else {
                BandwidthAverages bandwidthAveragesC = NetworkBandwidthAggregator.f47757a.c();
                int i3 = (int) bandwidthAveragesC.f47749a;
                int i4 = (int) bandwidthAveragesC.f47750b;
                int i5 = (int) bandwidthAveragesC.f47751c;
                int i6 = (int) bandwidthAveragesC.f47752d;
                if (i2 <= 24) {
                    networkConnectionType = NetworkConnectionType.f47780h;
                } else {
                    Object systemService4 = context3.getApplicationContext().getSystemService("connectivity");
                    ConnectivityManager connectivityManager2 = systemService4 instanceof ConnectivityManager ? (ConnectivityManager) systemService4 : null;
                    if (connectivityManager2 == null || (networkCapabilities2 = connectivityManager2.getNetworkCapabilities(connectivityManager2.getActiveNetwork())) == null) {
                        networkConnectionType = NetworkConnectionType.f47780h;
                    } else if (networkCapabilities2.hasTransport(1)) {
                        Timber.d("PSP").d("Network type: WiFi", new Object[0]);
                        networkConnectionType = NetworkConnectionType.f47774b;
                    } else if (networkCapabilities2.hasTransport(0)) {
                        Object systemService5 = context3.getSystemService("phone");
                        TelephonyManager telephonyManager = systemService5 instanceof TelephonyManager ? (TelephonyManager) systemService5 : null;
                        if (telephonyManager == null) {
                            networkConnectionType = NetworkConnectionType.f47779g;
                        } else {
                            int dataNetworkType = telephonyManager.getDataNetworkType();
                            if (dataNetworkType != 20) {
                                switch (dataNetworkType) {
                                    case 1:
                                    case 2:
                                    case 4:
                                    case 7:
                                    case 11:
                                        Timber.d("PSP").d("Network type: 2G", new Object[0]);
                                        networkConnectionType = NetworkConnectionType.f47775c;
                                        break;
                                    case 3:
                                    case 5:
                                    case 6:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 12:
                                    case 14:
                                    case 15:
                                        Timber.d("PSP").d("Network type: 3G", new Object[0]);
                                        networkConnectionType = NetworkConnectionType.f47776d;
                                        break;
                                    case 13:
                                        Timber.d("PSP").d("Network type: 4G LTE", new Object[0]);
                                        networkConnectionType = NetworkConnectionType.f47777e;
                                        break;
                                    default:
                                        Timber.d("PSP").d("Network type: Cellular (unknown generation)", new Object[0]);
                                        networkConnectionType = NetworkConnectionType.f47779g;
                                        break;
                                }
                            } else {
                                Timber.d("PSP").d("Network type: 5G", new Object[0]);
                                networkConnectionType = NetworkConnectionType.f47778f;
                            }
                        }
                    } else {
                        networkConnectionType = NetworkConnectionType.f47780h;
                    }
                }
                networkPerformanceResult = new NetworkPerformanceResult(i3, i4, i5, i6, networkConnectionType, false);
            }
            PerformanceModeResults.f47739d = networkPerformanceResult;
        }
    }
}

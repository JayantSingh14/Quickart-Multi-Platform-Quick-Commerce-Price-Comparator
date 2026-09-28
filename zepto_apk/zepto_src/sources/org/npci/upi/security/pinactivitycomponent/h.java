package org.npci.upi.security.pinactivitycomponent;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import in.juspay.hyper.constants.LogSubCategory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    Context f57534a;

    public h(Context context) {
        this.f57534a = context;
    }

    private long A() {
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Exception unused) {
            return -1L;
        }
    }

    private String b() throws JSONException {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f57534a).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Snapshot.WIDTH, displayMetrics.widthPixels);
            jSONObject.put(Snapshot.HEIGHT, displayMetrics.heightPixels);
        } catch (Exception e2) {
            q.a("", e2);
        }
        return jSONObject.toString();
    }

    private Locale c() {
        return this.f57534a.getResources().getConfiguration().locale;
    }

    private String d() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            String hostAddress = "";
            while (it.hasNext()) {
                try {
                    for (InetAddress inetAddress : Collections.list(((NetworkInterface) it.next()).getInetAddresses())) {
                        if (!inetAddress.isLoopbackAddress()) {
                            hostAddress = inetAddress.getHostAddress();
                            if (hostAddress.indexOf(58) < 0) {
                                return hostAddress;
                            }
                        }
                    }
                } catch (Exception unused) {
                    return hostAddress;
                }
            }
            return "";
        } catch (Exception unused2) {
            return "";
        }
    }

    private JSONObject e() throws JSONException {
        Location lastKnownLocation;
        Context context = this.f57534a;
        if (context == null) {
            return null;
        }
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        List<String> allProviders = locationManager.getAllProviders();
        PackageManager packageManager = this.f57534a.getPackageManager();
        String packageName = this.f57534a.getPackageName();
        int iCheckPermission = packageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", packageName);
        int iCheckPermission2 = packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", packageName);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Latitude", "");
            jSONObject.put("Longitude", "");
            jSONObject.put("Provider", "");
        } catch (JSONException e2) {
            q.a("DeviceDetailsLocationJson", e2);
        }
        if (iCheckPermission != 0 && iCheckPermission2 != 0) {
            return jSONObject;
        }
        try {
            for (int size = allProviders.size() - 1; size >= 0; size--) {
                if (allProviders.get(size).equals("network") && (lastKnownLocation = locationManager.getLastKnownLocation(allProviders.get(size))) != null) {
                    return a(lastKnownLocation, allProviders.get(size));
                }
            }
            return jSONObject;
        } catch (Exception unused) {
            return jSONObject;
        }
    }

    private String f() {
        try {
            Context context = this.f57534a;
            if (context != null) {
                return Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "android_id");
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private String g() {
        try {
            Context context = this.f57534a;
            if (context != null) {
                return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private String h() {
        try {
            Context context = this.f57534a;
            if (context != null) {
                return ((TelephonyManager) context.getSystemService("phone")).getNetworkCountryIso();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private String i() {
        try {
            Context context = this.f57534a;
            if (context != null) {
                return ((TelephonyManager) context.getSystemService("phone")).getSimCountryIso();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private String j() {
        try {
            Context context = this.f57534a;
            if (context != null) {
                return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private String k() {
        try {
            Context context = this.f57534a;
            if (context != null) {
                return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private Integer l() {
        try {
            Context context = this.f57534a;
            return Integer.valueOf(context != null ? ((TelephonyManager) context.getSystemService("phone")).getNetworkType() : 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    private Integer m() {
        try {
            return Integer.valueOf(((TelephonyManager) this.f57534a.getSystemService("phone")).getPhoneCount());
        } catch (Exception unused) {
            return 1;
        }
    }

    private String n() {
        try {
            Context context = this.f57534a;
            int phoneType = (context != null ? (TelephonyManager) context.getSystemService("phone") : null).getPhoneType();
            return phoneType != 0 ? phoneType != 1 ? phoneType != 2 ? phoneType != 3 ? "" : "SIP" : "CDMA" : "GSM" : "NONE";
        } catch (Exception unused) {
            return "";
        }
    }

    private String o() {
        try {
            Context context = this.f57534a;
            if (context != null) {
                return ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private String p() {
        try {
            Context context = this.f57534a;
            if (context != null) {
                return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private String q() {
        try {
            Context context = this.f57534a;
            if (context != null) {
                return ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private String r() {
        try {
            Context context = this.f57534a;
            if (context != null) {
                return String.valueOf(((TelephonyManager) context.getSystemService("phone")).getSimState());
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private Boolean s() {
        Boolean bool = Boolean.FALSE;
        try {
            Context context = this.f57534a;
            return context != null ? Boolean.valueOf(((TelephonyManager) context.getSystemService("phone")).isNetworkRoaming()) : bool;
        } catch (Exception unused) {
            return bool;
        }
    }

    private Boolean t() {
        Boolean bool = Boolean.FALSE;
        try {
            Context context = this.f57534a;
            return context != null ? Boolean.valueOf(((TelephonyManager) context.getSystemService("phone")).isSmsCapable()) : bool;
        } catch (Exception unused) {
            return bool;
        }
    }

    private String u() {
        try {
            return ((WifiManager) this.f57534a.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Exception unused) {
            return null;
        }
    }

    private String v() {
        try {
            return ((WifiManager) this.f57534a.getSystemService("wifi")).getConnectionInfo().getBSSID();
        } catch (Exception unused) {
            return null;
        }
    }

    private String w() {
        try {
            return ((WifiManager) this.f57534a.getSystemService("wifi")).getConnectionInfo().getSSID();
        } catch (Exception unused) {
            return null;
        }
    }

    private String x() throws JSONException {
        JSONArray jSONArray;
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            JSONObject jSONObject = null;
            if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
                jSONArray = null;
            } else {
                Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
                jSONArray = new JSONArray();
                if (bondedDevices.size() > 0) {
                    for (BluetoothDevice bluetoothDevice : bondedDevices) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("bluetoothName", bluetoothDevice.getName());
                        jSONObject2.put("bluetoothMacAddress", bluetoothDevice.getAddress());
                        jSONArray.put(jSONObject2);
                        jSONObject = jSONObject2;
                    }
                }
            }
            return jSONObject == null ? "" : jSONArray.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private Boolean y() {
        Boolean bool = Boolean.FALSE;
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            return defaultAdapter != null ? Boolean.valueOf(defaultAdapter.isEnabled()) : bool;
        } catch (Exception unused) {
            return bool;
        }
    }

    private Boolean z() {
        Boolean bool = Boolean.FALSE;
        try {
            boolean z = true;
            if (Settings.Secure.getInt(this.f57534a.getContentResolver(), "data_roaming") != 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception unused) {
            return bool;
        }
    }

    public String a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "ANDROID");
            jSONObject.put("deviceModel", Build.MODEL);
            String str = Build.VERSION.RELEASE;
            jSONObject.put("os", str);
            jSONObject.put("osName", Build.VERSION.SDK_INT);
            jSONObject.put("locale", c());
            jSONObject.put("timeZone", TimeZone.getDefault().getID());
            jSONObject.put("advertisingId", "");
            jSONObject.put("screenResolution", b());
            jSONObject.put("deviceName", Settings.System.getString(this.f57534a.getContentResolver(), "device_name"));
            jSONObject.put("ipAddress", d());
            jSONObject.put("latitude", e().get("Latitude"));
            jSONObject.put("longitude", e().get("Longitude"));
            jSONObject.put(CLConstants.SALT_FIELD_DEVICE_ID, f());
            jSONObject.put("subscriberId", g());
            jSONObject.put("imie", g());
            jSONObject.put("networkCountryISO", h());
            jSONObject.put("networkOperator", j());
            jSONObject.put("networkOperatorName", k());
            jSONObject.put("networkType", l());
            jSONObject.put("phoneCount", m());
            jSONObject.put("phoneType", n());
            jSONObject.put("simCountryISO", i());
            jSONObject.put("simOperator", o());
            jSONObject.put("simOperatorName", p());
            jSONObject.put("simSerialNumber", q());
            jSONObject.put("simState", r());
            jSONObject.put("isNetworkRoaming", s());
            jSONObject.put("isSmsCapable", t());
            jSONObject.put("wifiMacAddress", u());
            jSONObject.put("bssid", v());
            jSONObject.put("ssid", w());
            jSONObject.put("bondedDevice", x());
            jSONObject.put("bluetoothIsEnabled", y());
            jSONObject.put("fingerprint", Build.FINGERPRINT);
            jSONObject.put("hardware", Build.HARDWARE);
            jSONObject.put(CLConstants.SHARED_PREFERENCE_ITEM_ID, Build.ID);
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put("product", Build.PRODUCT);
            jSONObject.put("radio", Build.RADIO);
            jSONObject.put("serial", Build.SERIAL);
            jSONObject.put(LogSubCategory.Action.USER, Build.USER);
            jSONObject.put("version", str);
            jSONObject.put("securityPatch", Build.VERSION.SECURITY_PATCH);
            jSONObject.put("androidID", Settings.Secure.getString(this.f57534a.getContentResolver(), "android_id"));
            jSONObject.put("isDataRoaming", z());
            jSONObject.put("autoTime", Settings.Global.getString(this.f57534a.getContentResolver(), "auto_time") == "1");
            jSONObject.put("autoTimeZone", Settings.Global.getString(this.f57534a.getContentResolver(), "auto_time_zone") == "1");
            jSONObject.put("developmentSettingsEnabled", Settings.Secure.getString(this.f57534a.getContentResolver(), "development_settings_enabled") == "1");
            jSONObject.put("httpProxy", Settings.System.getString(this.f57534a.getContentResolver(), "http_proxy"));
            jSONObject.put("networkPreference", Settings.System.getString(this.f57534a.getContentResolver(), "network_preference"));
            jSONObject.put("usbMassStorageEnabled", Settings.Secure.getString(this.f57534a.getContentResolver(), "usb_mass_storage_enabled") == "1");
            jSONObject.put("is24HoursFormat", DateFormat.is24HourFormat(this.f57534a));
            jSONObject.put("isSafeMode", this.f57534a.getPackageManager().isSafeMode());
            jSONObject.put("systemAvailableFeature", this.f57534a.getPackageManager().getSystemAvailableFeatures());
            jSONObject.put("totalBytes", A());
        } catch (JSONException e2) {
            q.a("commonLibrary", e2);
        }
        return String.valueOf(jSONObject);
    }

    private JSONObject a(Location location, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                jSONObject.put("Latitude", location.getLatitude());
                jSONObject.put("Longitude", location.getLongitude());
                jSONObject.put("Provider", str);
                return jSONObject;
            } catch (Exception unused) {
                jSONObject.put("Latitude", "");
                jSONObject.put("Longitude", "");
                jSONObject.put("Provider", "");
                return jSONObject;
            }
        } catch (JSONException unused2) {
            return jSONObject;
        }
    }
}

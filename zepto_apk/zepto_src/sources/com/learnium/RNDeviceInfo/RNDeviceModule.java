package com.learnium.RNDeviceInfo;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageInfo;
import android.hardware.camera2.CameraManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaCodecList;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.webkit.WebSettings;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import com.google.android.gms.common.GoogleApiAvailability;
import com.learnium.RNDeviceInfo.resolver.DeviceIdResolver;
import com.learnium.RNDeviceInfo.resolver.DeviceTypeResolver;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Nonnull;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ReactModule(name = RNDeviceModule.NAME)
/* loaded from: classes.dex */
public class RNDeviceModule extends ReactContextBaseJavaModule {
    private static String BATTERY_LEVEL = "batteryLevel";
    private static String BATTERY_STATE = "batteryState";
    private static String LOW_POWER_MODE = "lowPowerMode";
    public static final String NAME = "RNDeviceInfo";
    private final DeviceIdResolver deviceIdResolver;
    private final DeviceTypeResolver deviceTypeResolver;
    private BroadcastReceiver headphoneConnectionReceiver;
    private double mLastBatteryLevel;
    private String mLastBatteryState;
    private boolean mLastPowerSaveState;
    private BroadcastReceiver receiver;

    public RNDeviceModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mLastBatteryLevel = -1.0d;
        this.mLastBatteryState = "";
        this.mLastPowerSaveState = false;
        this.deviceTypeResolver = new DeviceTypeResolver(reactApplicationContext);
        this.deviceIdResolver = new DeviceIdResolver(reactApplicationContext);
    }

    private long getBlockSize(StatFs statFs, Boolean bool) {
        return bool.booleanValue() ? statFs.getBlockSizeLong() : statFs.getBlockSize();
    }

    private BigInteger getDirTotalCapacity(StatFs statFs) {
        return BigInteger.valueOf(statFs.getBlockCountLong()).multiply(BigInteger.valueOf(statFs.getBlockSizeLong()));
    }

    private PackageInfo getPackageInfo() throws Exception {
        return getReactApplicationContext().getPackageManager().getPackageInfo(getReactApplicationContext().getPackageName(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WritableMap getPowerStateFromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        int intExtra = intent.getIntExtra("level", -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        int intExtra3 = intent.getIntExtra("plugged", -1);
        int intExtra4 = intent.getIntExtra(CLConstants.OTP_STATUS, -1);
        float f2 = intExtra / intExtra2;
        String str = intExtra3 == 0 ? "unplugged" : intExtra4 == 2 ? "charging" : intExtra4 == 5 ? "full" : zzck.UNKNOWN_CONTENT_TYPE;
        boolean zIsPowerSaveMode = ((PowerManager) getReactApplicationContext().getSystemService("power")).isPowerSaveMode();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(BATTERY_STATE, str);
        writableMapCreateMap.putDouble(BATTERY_LEVEL, f2);
        writableMapCreateMap.putBoolean(LOW_POWER_MODE, zIsPowerSaveMode);
        return writableMapCreateMap;
    }

    public static SharedPreferences getRNDISharedPreferences(Context context) {
        return context.getSharedPreferences("react-native-device-info", 0);
    }

    private long getTotalAvailableBlocks(StatFs statFs, Boolean bool) {
        return bool.booleanValue() ? statFs.getAvailableBlocksLong() : statFs.getAvailableBlocks();
    }

    @SuppressLint({"MissingPermission"})
    private WifiInfo getWifiInfo() {
        WifiManager wifiManager = (WifiManager) getReactApplicationContext().getApplicationContext().getSystemService("wifi");
        if (wifiManager != null) {
            return wifiManager.getConnectionInfo();
        }
        return null;
    }

    private void initializeHeadphoneConnectionReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
        this.headphoneConnectionReceiver = new BroadcastReceiver() { // from class: com.learnium.RNDeviceInfo.RNDeviceModule.2
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                RNDeviceModule rNDeviceModule = RNDeviceModule.this;
                rNDeviceModule.sendEvent(rNDeviceModule.getReactApplicationContext(), "RNDeviceInfo_headphoneConnectionDidChange", Boolean.valueOf(rNDeviceModule.isHeadphonesConnectedSync()));
            }
        };
        getReactApplicationContext().registerReceiver(this.headphoneConnectionReceiver, intentFilter);
    }

    @Nonnull
    private Boolean isLowRamDevice() {
        return Boolean.valueOf(((ActivityManager) getReactApplicationContext().getSystemService("activity")).isLowRamDevice());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(ReactContext reactContext, String str, @Nullable Object obj) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, obj);
    }

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void getAndroidId(Promise promise) {
        promise.resolve(getAndroidIdSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    @SuppressLint({"HardwareIds"})
    public String getAndroidIdSync() {
        return getUniqueIdSync();
    }

    @ReactMethod
    public void getApiLevel(Promise promise) {
        promise.resolve(Integer.valueOf(getApiLevelSync()));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public int getApiLevelSync() {
        return Build.VERSION.SDK_INT;
    }

    @ReactMethod
    public void getAvailableLocationProviders(Promise promise) {
        promise.resolve(getAvailableLocationProvidersSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public WritableMap getAvailableLocationProvidersSync() {
        LocationManager locationManager = (LocationManager) getReactApplicationContext().getSystemService("location");
        WritableMap writableMapCreateMap = Arguments.createMap();
        try {
            for (String str : locationManager.getProviders(false)) {
                writableMapCreateMap.putBoolean(str, locationManager.isProviderEnabled(str));
            }
        } catch (Exception unused) {
            System.err.println("Unable to get location providers. LocationManager was null");
        }
        return writableMapCreateMap;
    }

    @ReactMethod
    public void getBaseOs(Promise promise) {
        promise.resolve(getBaseOsSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getBaseOsSync() {
        return Build.VERSION.BASE_OS;
    }

    @ReactMethod
    public void getBatteryLevel(Promise promise) {
        promise.resolve(Double.valueOf(getBatteryLevelSync()));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public double getBatteryLevelSync() {
        WritableMap powerStateFromIntent = getPowerStateFromIntent(getReactApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")));
        if (powerStateFromIntent == null) {
            return 0.0d;
        }
        return powerStateFromIntent.getDouble(BATTERY_LEVEL);
    }

    @ReactMethod
    public void getBootloader(Promise promise) {
        promise.resolve(getBootloaderSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getBootloaderSync() {
        return Build.BOOTLOADER;
    }

    @ReactMethod
    public void getBuildId(Promise promise) {
        promise.resolve(getBuildIdSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getBuildIdSync() {
        return Build.ID;
    }

    @ReactMethod
    public void getCarrier(Promise promise) {
        promise.resolve(getCarrierSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getCarrierSync() {
        TelephonyManager telephonyManager = (TelephonyManager) getReactApplicationContext().getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperatorName();
        }
        System.err.println("Unable to get network operator name. TelephonyManager was null");
        return zzck.UNKNOWN_CONTENT_TYPE;
    }

    @ReactMethod
    public void getCodename(Promise promise) {
        promise.resolve(getCodenameSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getCodenameSync() {
        return Build.VERSION.CODENAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        String str;
        String string;
        String string2;
        try {
            str = getPackageInfo().versionName;
            string = Integer.toString(getPackageInfo().versionCode);
            string2 = getReactApplicationContext().getApplicationInfo().loadLabel(getReactApplicationContext().getPackageManager()).toString();
        } catch (Exception unused) {
            str = zzck.UNKNOWN_CONTENT_TYPE;
            string = zzck.UNKNOWN_CONTENT_TYPE;
            string2 = string;
        }
        HashMap map = new HashMap();
        map.put(CLConstants.SALT_FIELD_DEVICE_ID, Build.BOARD);
        map.put("bundleId", getReactApplicationContext().getPackageName());
        map.put("systemName", "Android");
        map.put("systemVersion", Build.VERSION.RELEASE);
        map.put("appVersion", str);
        map.put("buildNumber", string);
        map.put("isTablet", Boolean.valueOf(this.deviceTypeResolver.a() == DeviceType.TABLET));
        map.put("isLowRamDevice", isLowRamDevice());
        map.put("appName", string2);
        map.put("brand", Build.BRAND);
        map.put("model", Build.MODEL);
        map.put("deviceType", this.deviceTypeResolver.a().f45956a);
        return map;
    }

    @ReactMethod
    public void getDevice(Promise promise) {
        promise.resolve(getDeviceSync());
    }

    @ReactMethod
    public void getDeviceName(Promise promise) {
        promise.resolve(getDeviceNameSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getDeviceNameSync() {
        String string;
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 <= 31 && (string = Settings.Secure.getString(getReactApplicationContext().getContentResolver(), "bluetooth_name")) != null) {
                return string;
            }
            if (i2 < 25) {
                return zzck.UNKNOWN_CONTENT_TYPE;
            }
            String string2 = Settings.Global.getString(getReactApplicationContext().getContentResolver(), "device_name");
            return string2 != null ? string2 : zzck.UNKNOWN_CONTENT_TYPE;
        } catch (Exception unused) {
            return zzck.UNKNOWN_CONTENT_TYPE;
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getDeviceSync() {
        return Build.DEVICE;
    }

    @ReactMethod
    public void getDisplay(Promise promise) {
        promise.resolve(getDisplaySync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getDisplaySync() {
        return Build.DISPLAY;
    }

    @ReactMethod
    public void getFingerprint(Promise promise) {
        promise.resolve(getFingerprintSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getFingerprintSync() {
        return Build.FINGERPRINT;
    }

    @ReactMethod
    public void getFirstInstallTime(Promise promise) {
        promise.resolve(Double.valueOf(getFirstInstallTimeSync()));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public double getFirstInstallTimeSync() {
        try {
            return getPackageInfo().firstInstallTime;
        } catch (Exception unused) {
            return -1.0d;
        }
    }

    @ReactMethod
    public void getFontScale(Promise promise) {
        promise.resolve(Float.valueOf(getFontScaleSync()));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public float getFontScaleSync() {
        return getReactApplicationContext().getResources().getConfiguration().fontScale;
    }

    @ReactMethod
    public void getFreeDiskStorage(Promise promise) {
        promise.resolve(Double.valueOf(getFreeDiskStorageSync()));
    }

    @ReactMethod
    public void getFreeDiskStorageOld(Promise promise) {
        promise.resolve(Double.valueOf(getFreeDiskStorageOldSync()));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public double getFreeDiskStorageOldSync() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            return BigInteger.valueOf(statFs.getAvailableBlocksLong()).multiply(BigInteger.valueOf(statFs.getBlockSizeLong())).doubleValue();
        } catch (Exception unused) {
            return -1.0d;
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public double getFreeDiskStorageSync() {
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getDataDirectory().getAbsolutePath());
            return BigInteger.valueOf(getTotalAvailableBlocks(statFs, true)).multiply(BigInteger.valueOf(getBlockSize(statFs, true))).doubleValue() + BigInteger.valueOf(getTotalAvailableBlocks(statFs2, true)).multiply(BigInteger.valueOf(getBlockSize(statFs2, true))).doubleValue();
        } catch (Exception unused) {
            return -1.0d;
        }
    }

    @ReactMethod
    public void getHardware(Promise promise) {
        promise.resolve(getHardwareSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getHardwareSync() {
        return Build.HARDWARE;
    }

    @ReactMethod
    public void getHost(Promise promise) {
        promise.resolve(getHostSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getHostSync() {
        return Build.HOST;
    }

    @ReactMethod
    public void getIncremental(Promise promise) {
        promise.resolve(getIncrementalSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getIncrementalSync() {
        return Build.VERSION.INCREMENTAL;
    }

    @ReactMethod
    public void getInstallerPackageName(Promise promise) {
        promise.resolve(getInstallerPackageNameSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getInstallerPackageNameSync() {
        String installerPackageName = getReactApplicationContext().getPackageManager().getInstallerPackageName(getReactApplicationContext().getPackageName());
        return installerPackageName == null ? zzck.UNKNOWN_CONTENT_TYPE : installerPackageName;
    }

    @ReactMethod
    public void getInstanceId(Promise promise) {
        promise.resolve(getInstanceIdSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getInstanceIdSync() {
        DeviceIdResolver deviceIdResolver = this.deviceIdResolver;
        String string = getRNDISharedPreferences(deviceIdResolver.f45959a).getString("instanceId", zzck.UNKNOWN_CONTENT_TYPE);
        if (string != zzck.UNKNOWN_CONTENT_TYPE) {
            return string;
        }
        try {
            String strA = DeviceIdResolver.a();
            deviceIdResolver.c(strA);
            return strA;
        } catch (ClassNotFoundException unused) {
            try {
                String strB = deviceIdResolver.b();
                deviceIdResolver.c(strB);
                return strB;
            } catch (ClassNotFoundException unused2) {
                String string2 = UUID.randomUUID().toString();
                deviceIdResolver.c(string2);
                return string2;
            } catch (IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException unused3) {
                System.err.println("N/A: Unsupported version of com.google.android.gms.iid in your project.");
                String string22 = UUID.randomUUID().toString();
                deviceIdResolver.c(string22);
                return string22;
            }
        } catch (IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException unused4) {
            System.err.println("N/A: Unsupported version of com.google.firebase:firebase-iid in your project.");
            String strB2 = deviceIdResolver.b();
            deviceIdResolver.c(strB2);
            return strB2;
        }
    }

    @ReactMethod
    public void getIpAddress(Promise promise) {
        promise.resolve(getIpAddressSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getIpAddressSync() {
        try {
            return InetAddress.getByAddress(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(getWifiInfo().getIpAddress()).array()).getHostAddress();
        } catch (Exception unused) {
            return zzck.UNKNOWN_CONTENT_TYPE;
        }
    }

    @ReactMethod
    public void getLastUpdateTime(Promise promise) {
        promise.resolve(Double.valueOf(getLastUpdateTimeSync()));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public double getLastUpdateTimeSync() {
        try {
            return getPackageInfo().lastUpdateTime;
        } catch (Exception unused) {
            return -1.0d;
        }
    }

    @ReactMethod
    public void getMacAddress(Promise promise) {
        promise.resolve(getMacAddressSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    @SuppressLint({"HardwareIds"})
    public String getMacAddressSync() throws SocketException {
        WifiInfo wifiInfo = getWifiInfo();
        String macAddress = wifiInfo != null ? wifiInfo.getMacAddress() : "";
        if (getReactApplicationContext().checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
            try {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (hardwareAddress == null) {
                            macAddress = "";
                        } else {
                            StringBuilder sb = new StringBuilder();
                            for (byte b2 : hardwareAddress) {
                                sb.append(String.format("%02X:", Byte.valueOf(b2)));
                            }
                            if (sb.length() > 0) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            macAddress = sb.toString();
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return macAddress;
    }

    @ReactMethod
    public void getMaxMemory(Promise promise) {
        promise.resolve(Double.valueOf(getMaxMemorySync()));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public double getMaxMemorySync() {
        return Runtime.getRuntime().maxMemory();
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void getPhoneNumber(Promise promise) {
        promise.resolve(getPhoneNumberSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    @SuppressLint({"HardwareIds", "MissingPermission"})
    public String getPhoneNumberSync() {
        if (getReactApplicationContext() == null) {
            return zzck.UNKNOWN_CONTENT_TYPE;
        }
        if (getReactApplicationContext().checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            int i2 = Build.VERSION.SDK_INT;
            if (getReactApplicationContext().checkCallingOrSelfPermission("android.permission.READ_SMS") != 0 && (i2 < 26 || getReactApplicationContext().checkCallingOrSelfPermission("android.permission.READ_PHONE_NUMBERS") != 0)) {
                return zzck.UNKNOWN_CONTENT_TYPE;
            }
        }
        TelephonyManager telephonyManager = (TelephonyManager) getReactApplicationContext().getSystemService("phone");
        if (telephonyManager == null) {
            System.err.println("Unable to getPhoneNumber. TelephonyManager was null");
            return zzck.UNKNOWN_CONTENT_TYPE;
        }
        try {
            return telephonyManager.getLine1Number();
        } catch (SecurityException e2) {
            System.err.println("getLine1Number called with permission, but threw anyway: " + e2.getMessage());
            return zzck.UNKNOWN_CONTENT_TYPE;
        }
    }

    @ReactMethod
    public void getPowerState(Promise promise) {
        promise.resolve(getPowerStateSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public WritableMap getPowerStateSync() {
        return getPowerStateFromIntent(getReactApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")));
    }

    @ReactMethod
    public void getPreviewSdkInt(Promise promise) {
        promise.resolve(getPreviewSdkIntSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getPreviewSdkIntSync() {
        return Integer.toString(Build.VERSION.PREVIEW_SDK_INT);
    }

    @ReactMethod
    public void getProduct(Promise promise) {
        promise.resolve(getProductSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getProductSync() {
        return Build.PRODUCT;
    }

    @ReactMethod
    public void getSecurityPatch(Promise promise) {
        promise.resolve(getSecurityPatchSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getSecurityPatchSync() {
        return Build.VERSION.SECURITY_PATCH;
    }

    @ReactMethod
    public void getSerialNumber(Promise promise) {
        promise.resolve(getSerialNumberSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    @SuppressLint({"HardwareIds", "MissingPermission"})
    public String getSerialNumberSync() {
        try {
            return Build.VERSION.SDK_INT >= 26 ? Build.getSerial() : Build.SERIAL;
        } catch (Exception e2) {
            System.err.println("getSerialNumber failed, it probably should not be used: " + e2.getMessage());
            return zzck.UNKNOWN_CONTENT_TYPE;
        }
    }

    @ReactMethod
    public void getSupported32BitAbis(Promise promise) {
        promise.resolve(getSupported32BitAbisSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public WritableArray getSupported32BitAbisSync() {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (String str : Build.SUPPORTED_32_BIT_ABIS) {
            writableNativeArray.pushString(str);
        }
        return writableNativeArray;
    }

    @ReactMethod
    public void getSupported64BitAbis(Promise promise) {
        promise.resolve(getSupported64BitAbisSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public WritableArray getSupported64BitAbisSync() {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (String str : Build.SUPPORTED_64_BIT_ABIS) {
            writableNativeArray.pushString(str);
        }
        return writableNativeArray;
    }

    @ReactMethod
    public void getSupportedAbis(Promise promise) {
        promise.resolve(getSupportedAbisSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public WritableArray getSupportedAbisSync() {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (String str : Build.SUPPORTED_ABIS) {
            writableNativeArray.pushString(str);
        }
        return writableNativeArray;
    }

    @ReactMethod
    public void getSupportedMediaTypeList(Promise promise) {
        promise.resolve(getSupportedMediaTypeListSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public WritableArray getSupportedMediaTypeListSync() {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (int i2 = 0; i2 < MediaCodecList.getCodecCount(); i2++) {
            for (String str : MediaCodecList.getCodecInfoAt(i2).getSupportedTypes()) {
                writableNativeArray.pushString(str);
            }
        }
        return writableNativeArray;
    }

    @ReactMethod
    public void getSystemAvailableFeatures(Promise promise) {
        promise.resolve(getSystemAvailableFeaturesSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public WritableArray getSystemAvailableFeaturesSync() {
        FeatureInfo[] systemAvailableFeatures = getReactApplicationContext().getPackageManager().getSystemAvailableFeatures();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (FeatureInfo featureInfo : systemAvailableFeatures) {
            String str = featureInfo.name;
            if (str != null) {
                writableArrayCreateArray.pushString(str);
            }
        }
        return writableArrayCreateArray;
    }

    @ReactMethod
    public void getSystemManufacturer(Promise promise) {
        promise.resolve(getSystemManufacturerSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getSystemManufacturerSync() {
        return Build.MANUFACTURER;
    }

    @ReactMethod
    public void getTags(Promise promise) {
        promise.resolve(getTagsSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getTagsSync() {
        return Build.TAGS;
    }

    @ReactMethod
    public void getTotalDiskCapacity(Promise promise) {
        promise.resolve(Double.valueOf(getTotalDiskCapacitySync()));
    }

    @ReactMethod
    public void getTotalDiskCapacityOld(Promise promise) {
        promise.resolve(Double.valueOf(getTotalDiskCapacityOldSync()));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    @Deprecated
    public double getTotalDiskCapacityOldSync() {
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            return BigInteger.valueOf(statFs.getBlockCount()).multiply(BigInteger.valueOf(statFs.getBlockSize())).doubleValue();
        } catch (Exception unused) {
            return -1.0d;
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public double getTotalDiskCapacitySync() {
        try {
            return getDirTotalCapacity(new StatFs(Environment.getRootDirectory().getAbsolutePath())).add(getDirTotalCapacity(new StatFs(Environment.getDataDirectory().getAbsolutePath()))).doubleValue();
        } catch (Exception unused) {
            return -1.0d;
        }
    }

    @ReactMethod
    public void getTotalMemory(Promise promise) {
        promise.resolve(Double.valueOf(getTotalMemorySync()));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public double getTotalMemorySync() {
        ActivityManager activityManager = (ActivityManager) getReactApplicationContext().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        System.err.println("Unable to getMemoryInfo. ActivityManager was null");
        return -1.0d;
    }

    @ReactMethod
    public void getType(Promise promise) {
        promise.resolve(getTypeSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getTypeSync() {
        return Build.TYPE;
    }

    @ReactMethod
    public void getUniqueId(Promise promise) {
        promise.resolve(getUniqueIdSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    @SuppressLint({"HardwareIds"})
    public String getUniqueIdSync() {
        return Settings.Secure.getString(getReactApplicationContext().getContentResolver(), "android_id");
    }

    @ReactMethod
    public void getUsedMemory(Promise promise) {
        promise.resolve(Double.valueOf(getUsedMemorySync()));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public double getUsedMemorySync() {
        ActivityManager activityManager = (ActivityManager) getReactApplicationContext().getSystemService("activity");
        if (activityManager == null) {
            System.err.println("Unable to getProcessMemoryInfo. ActivityManager was null");
            return -1.0d;
        }
        if (activityManager.getProcessMemoryInfo(new int[]{Process.myPid()}).length == 1) {
            return r0[0].getTotalPss() * 1024.0d;
        }
        System.err.println("Unable to getProcessMemoryInfo. getProcessMemoryInfo did not return any info for the PID");
        return -1.0d;
    }

    @ReactMethod
    public void getUserAgent(Promise promise) {
        promise.resolve(getUserAgentSync());
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public String getUserAgentSync() {
        try {
            return WebSettings.getDefaultUserAgent(getReactApplicationContext());
        } catch (RuntimeException unused) {
            return System.getProperty("http.agent");
        }
    }

    @ReactMethod
    public void hasGms(Promise promise) {
        promise.resolve(Boolean.valueOf(hasGmsSync()));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public boolean hasGmsSync() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            int i2 = GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE;
            Object objInvoke = GoogleApiAvailability.class.getMethod("getInstance", null).invoke(null, null);
            return ((Integer) objInvoke.getClass().getMethod("isGooglePlayServicesAvailable", Context.class).invoke(objInvoke, getReactApplicationContext())).intValue() == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    @ReactMethod
    public void hasHms(Promise promise) {
        promise.resolve(Boolean.valueOf(hasHmsSync()));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public boolean hasHmsSync() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = Class.forName("com.huawei.hms.api.HuaweiApiAvailability").getMethod("getInstance", null).invoke(null, null);
            return ((Integer) objInvoke.getClass().getMethod("isHuaweiMobileServicesAvailable", Context.class).invoke(objInvoke, getReactApplicationContext())).intValue() == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    @ReactMethod
    public void hasSystemFeature(String str, Promise promise) {
        promise.resolve(Boolean.valueOf(hasSystemFeatureSync(str)));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public boolean hasSystemFeatureSync(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return getReactApplicationContext().getPackageManager().hasSystemFeature(str);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
        this.receiver = new BroadcastReceiver() { // from class: com.learnium.RNDeviceInfo.RNDeviceModule.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                RNDeviceModule rNDeviceModule = RNDeviceModule.this;
                WritableMap powerStateFromIntent = rNDeviceModule.getPowerStateFromIntent(intent);
                if (powerStateFromIntent == null) {
                    return;
                }
                String string = powerStateFromIntent.getString(RNDeviceModule.BATTERY_STATE);
                double d2 = powerStateFromIntent.getDouble(RNDeviceModule.BATTERY_LEVEL);
                Double dValueOf = Double.valueOf(d2);
                boolean z = powerStateFromIntent.getBoolean(RNDeviceModule.LOW_POWER_MODE);
                if (!rNDeviceModule.mLastBatteryState.equalsIgnoreCase(string) || rNDeviceModule.mLastPowerSaveState != z) {
                    rNDeviceModule.sendEvent(rNDeviceModule.getReactApplicationContext(), "RNDeviceInfo_powerStateDidChange", string);
                    rNDeviceModule.mLastBatteryState = string;
                    rNDeviceModule.mLastPowerSaveState = z;
                }
                if (rNDeviceModule.mLastBatteryLevel != d2) {
                    rNDeviceModule.sendEvent(rNDeviceModule.getReactApplicationContext(), "RNDeviceInfo_batteryLevelDidChange", dValueOf);
                    if (d2 <= 0.15d) {
                        rNDeviceModule.sendEvent(rNDeviceModule.getReactApplicationContext(), "RNDeviceInfo_batteryLevelIsLow", dValueOf);
                    }
                    rNDeviceModule.mLastBatteryLevel = d2;
                }
            }
        };
        getReactApplicationContext().registerReceiver(this.receiver, intentFilter);
        initializeHeadphoneConnectionReceiver();
    }

    @ReactMethod
    public void isAirplaneMode(Promise promise) {
        promise.resolve(Boolean.valueOf(isAirplaneModeSync()));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public boolean isAirplaneModeSync() {
        return Settings.Global.getInt(getReactApplicationContext().getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    @ReactMethod
    public void isBatteryCharging(Promise promise) {
        promise.resolve(Boolean.valueOf(isBatteryChargingSync()));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public boolean isBatteryChargingSync() {
        Intent intentRegisterReceiver = getReactApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return (intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(CLConstants.OTP_STATUS, -1) : 0) == 2;
    }

    @ReactMethod
    public void isCameraPresent(Promise promise) {
        promise.resolve(Boolean.valueOf(isCameraPresentSync()));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public boolean isCameraPresentSync() {
        return ((CameraManager) getReactApplicationContext().getSystemService("camera")).getCameraIdList().length > 0;
    }

    @ReactMethod
    public void isEmulator(Promise promise) {
        promise.resolve(Boolean.valueOf(isEmulatorSync()));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    @SuppressLint({"HardwareIds"})
    public boolean isEmulatorSync() {
        String str = Build.FINGERPRINT;
        if (str.startsWith("generic") || str.startsWith(zzck.UNKNOWN_CONTENT_TYPE)) {
            return true;
        }
        String str2 = Build.MODEL;
        if (str2.contains("google_sdk")) {
            return true;
        }
        Locale locale = Locale.ROOT;
        if (str2.toLowerCase(locale).contains("droid4x") || str2.contains("Emulator") || str2.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion")) {
            return true;
        }
        String str3 = Build.HARDWARE;
        if (str3.contains("goldfish") || str3.contains("ranchu") || str3.contains("vbox86")) {
            return true;
        }
        String str4 = Build.PRODUCT;
        if (str4.contains("sdk") || str4.contains("google_sdk") || str4.contains("sdk_google") || str4.contains("sdk_x86") || str4.contains("vbox86p") || str4.contains("emulator") || str4.contains("simulator") || Build.BOARD.toLowerCase(locale).contains("nox") || Build.BOOTLOADER.toLowerCase(locale).contains("nox") || str3.toLowerCase(locale).contains("nox") || str4.toLowerCase(locale).contains("nox") || Build.SERIAL.toLowerCase(locale).contains("nox")) {
            return true;
        }
        return Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic");
    }

    @ReactMethod
    public void isHeadphonesConnected(Promise promise) {
        promise.resolve(Boolean.valueOf(isHeadphonesConnectedSync()));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public boolean isHeadphonesConnectedSync() {
        AudioManager audioManager = (AudioManager) getReactApplicationContext().getSystemService("audio");
        return audioManager.isWiredHeadsetOn() || audioManager.isBluetoothA2dpOn();
    }

    @ReactMethod
    public void isLocationEnabled(Promise promise) {
        promise.resolve(Boolean.valueOf(isLocationEnabledSync()));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public boolean isLocationEnabledSync() {
        if (Build.VERSION.SDK_INT < 28) {
            return Settings.Secure.getInt(getReactApplicationContext().getContentResolver(), "location_mode", 0) != 0;
        }
        try {
            return ((LocationManager) getReactApplicationContext().getSystemService("location")).isLocationEnabled();
        } catch (Exception unused) {
            System.err.println("Unable to determine if location enabled. LocationManager was null");
            return false;
        }
    }

    @ReactMethod
    public void isPinOrFingerprintSet(Promise promise) {
        promise.resolve(Boolean.valueOf(isPinOrFingerprintSetSync()));
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public boolean isPinOrFingerprintSetSync() {
        KeyguardManager keyguardManager = (KeyguardManager) getReactApplicationContext().getSystemService("keyguard");
        if (keyguardManager != null) {
            return keyguardManager.isKeyguardSecure();
        }
        System.err.println("Unable to determine keyguard status. KeyguardManager was null");
        return false;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        getReactApplicationContext().unregisterReceiver(this.receiver);
        getReactApplicationContext().unregisterReceiver(this.headphoneConnectionReceiver);
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }
}

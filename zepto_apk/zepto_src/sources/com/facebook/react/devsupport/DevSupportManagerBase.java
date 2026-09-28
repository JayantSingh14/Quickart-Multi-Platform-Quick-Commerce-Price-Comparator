package com.facebook.react.devsupport;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.common.logging.FLog;
import com.facebook.react.R;
import com.facebook.react.bridge.DefaultJSExceptionHandler;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.common.JavascriptException;
import com.facebook.react.common.ShakeDetector;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.devsupport.BundleDownloader;
import com.facebook.react.devsupport.DebugOverlayController.AnonymousClass1;
import com.facebook.react.devsupport.DevServerHelper;
import com.facebook.react.devsupport.DevServerHelper.AnonymousClass3;
import com.facebook.react.devsupport.DevServerHelper.AnonymousClass4;
import com.facebook.react.devsupport.DevSupportManagerBase;
import com.facebook.react.devsupport.StackTraceHelper;
import com.facebook.react.devsupport.interfaces.BundleLoadCallback;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevLoadingViewManager;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.ErrorType;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.FileIoHandler;
import com.facebook.react.packagerconnection.JSPackagerClient;
import com.facebook.react.packagerconnection.NotificationOnlyHandler;
import com.facebook.react.packagerconnection.PackagerConnectionSettings;
import com.facebook.react.packagerconnection.ReconnectingWebSocket;
import com.facebook.react.runtime.ReactHostImpl;
import com.facebook.react.runtime.ReactHostImplDevHelper;
import com.facebook.react.runtime.ReactSurfaceImpl;
import com.facebook.react.runtime.ReactSurfaceView;
import com.facebook.react.util.RNLog;
import in.juspay.airborne.ota.Constants;
import in.juspay.hyper.constants.LogSubCategory;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.WebSocket;
import okhttp3.internal.connection.RealCall;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public abstract class DevSupportManagerBase implements DevSupportManager {

    /* renamed from: a, reason: collision with root package name */
    public final Context f18818a;

    /* renamed from: b, reason: collision with root package name */
    public final ShakeDetector f18819b;

    /* renamed from: c, reason: collision with root package name */
    public final BroadcastReceiver f18820c;

    /* renamed from: d, reason: collision with root package name */
    public final DevServerHelper f18821d;

    /* renamed from: f, reason: collision with root package name */
    public final ReactHostImplDevHelper f18823f;

    /* renamed from: g, reason: collision with root package name */
    public final String f18824g;

    /* renamed from: h, reason: collision with root package name */
    public final File f18825h;

    /* renamed from: i, reason: collision with root package name */
    public final DefaultJSExceptionHandler f18826i;

    /* renamed from: j, reason: collision with root package name */
    public final DevLoadingViewManager f18827j;

    /* renamed from: k, reason: collision with root package name */
    public final PausedInDebuggerOverlayManager f18828k;

    /* renamed from: l, reason: collision with root package name */
    public SurfaceDelegate f18829l;

    /* renamed from: m, reason: collision with root package name */
    public AlertDialog f18830m;
    public DebugOverlayController n;
    public ReactApplicationContext p;
    public final DevInternalSettings q;
    public String u;
    public StackFrame[] v;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f18822e = new LinkedHashMap();
    public boolean o = false;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;

    /* renamed from: com.facebook.react.devsupport.DevSupportManagerBase$6, reason: invalid class name */
    class AnonymousClass6 implements DevBundleDownloadListener {
    }

    /* renamed from: com.facebook.react.devsupport.DevSupportManagerBase$7, reason: invalid class name */
    class AnonymousClass7 implements DevBundleDownloadListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BundleDownloader.BundleInfo f18837a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BundleLoadCallback f18838b;

        public AnonymousClass7(BundleDownloader.BundleInfo bundleInfo, BundleLoadCallback bundleLoadCallback) {
            this.f18837a = bundleInfo;
            this.f18838b = bundleLoadCallback;
        }

        public final void a(DebugServerException debugServerException) {
            DevSupportManagerBase devSupportManagerBase = DevSupportManagerBase.this;
            devSupportManagerBase.f18827j.c();
            devSupportManagerBase.o = false;
            FLog.h("ReactNative", "Unable to download JS bundle", debugServerException);
            UiThreadUtil.runOnUiThread(new androidx.constraintlayout.motion.widget.a(21, devSupportManagerBase, debugServerException));
            this.f18838b.b(debugServerException);
        }

        public final void b(String str, Integer num, Integer num2) {
            DevSupportManagerBase.this.f18827j.b(str, num, num2);
        }
    }

    /* renamed from: com.facebook.react.devsupport.DevSupportManagerBase$8, reason: invalid class name */
    class AnonymousClass8 implements DevServerHelper.PackagerCommandListener {
        public AnonymousClass8() {
        }
    }

    public interface CallbackWithBundleLoader {
    }

    public DevSupportManagerBase(Context context, ReactHostImplDevHelper reactHostImplDevHelper, String str) {
        this.f18823f = reactHostImplDevHelper;
        this.f18818a = context;
        this.f18824g = str;
        DevInternalSettings devInternalSettings = new DevInternalSettings(context, new c(this));
        this.q = devInternalSettings;
        this.f18821d = new DevServerHelper(devInternalSettings, context, devInternalSettings.f18796c);
        this.f18819b = new ShakeDetector(new c(this));
        this.f18820c = new BroadcastReceiver() { // from class: com.facebook.react.devsupport.DevSupportManagerBase.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context2, Intent intent) {
                if ((context2.getPackageName() + ".RELOAD_APP_ACTION").equals(intent.getAction())) {
                    boolean booleanExtra = intent.getBooleanExtra("jsproxy", false);
                    DevSupportManagerBase devSupportManagerBase = DevSupportManagerBase.this;
                    DevInternalSettings devInternalSettings2 = devSupportManagerBase.q;
                    if (booleanExtra) {
                        devInternalSettings2.c(true);
                        devSupportManagerBase.f18821d.d();
                    } else {
                        devInternalSettings2.c(false);
                    }
                    ((BridgelessDevSupportManager) devSupportManagerBase).w();
                }
            }
        };
        this.f18825h = new File(context.getFilesDir(), "BridgelessReactNativeDevBundle.js");
        context.getDir("Bridgeless".toLowerCase(Locale.ROOT) + "_dev_js_split_bundles", 0);
        this.f18826i = new DefaultJSExceptionHandler();
        l(true);
        this.f18827j = new DefaultDevLoadingViewImplementation(reactHostImplDevHelper);
        this.f18828k = new PausedInDebuggerOverlayDialogManager(new c(this));
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void A() {
        if (this.f18830m == null && this.t && !ActivityManager.isUserAMonkey()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            final HashSet hashSet = new HashSet();
            int i2 = R.string.catalyst_reload;
            Context context = this.f18818a;
            linkedHashMap.put(context.getString(i2), new DevOptionHandler() { // from class: com.facebook.react.devsupport.DevSupportManagerBase.2
                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public final void a() {
                    DevSupportManagerBase devSupportManagerBase = DevSupportManagerBase.this;
                    if (!devSupportManagerBase.q.d()) {
                        DevInternalSettings devInternalSettings = devSupportManagerBase.q;
                        if (devInternalSettings.f18795b.getBoolean("hot_module_replacement", true)) {
                            int i3 = R.string.catalyst_hot_reloading_auto_disable;
                            Context context2 = devSupportManagerBase.f18818a;
                            Toast.makeText(context2, context2.getString(i3), 1).show();
                            devInternalSettings.f18795b.edit().putBoolean("hot_module_replacement", false).apply();
                        }
                    }
                    devSupportManagerBase.w();
                }
            });
            DevInternalSettings devInternalSettings = this.q;
            if (devInternalSettings.a()) {
                devInternalSettings.c(false);
                w();
            }
            devInternalSettings.getClass();
            final int i3 = 0;
            linkedHashMap.put(context.getString(R.string.catalyst_change_bundle_location), new DevOptionHandler(this) { // from class: com.facebook.react.devsupport.e

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ DevSupportManagerBase f18931b;

                {
                    this.f18931b = this;
                }

                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public final void a() {
                    switch (i3) {
                        case 0:
                            final DevSupportManagerBase devSupportManagerBase = this.f18931b;
                            Activity activityA = devSupportManagerBase.f18823f.a();
                            if (activityA != null && !activityA.isFinishing()) {
                                final EditText editText = new EditText(activityA);
                                editText.setHint("localhost:8081");
                                new AlertDialog.Builder(activityA).setTitle(devSupportManagerBase.f18818a.getString(R.string.catalyst_change_bundle_location)).setView(editText).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.facebook.react.devsupport.DevSupportManagerBase.3
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i4) {
                                        String host = editText.getText().toString();
                                        DevSupportManagerBase devSupportManagerBase2 = DevSupportManagerBase.this;
                                        PackagerConnectionSettings packagerConnectionSettings = devSupportManagerBase2.q.f18796c;
                                        packagerConnectionSettings.getClass();
                                        Intrinsics.checkNotNullParameter(host, "host");
                                        packagerConnectionSettings.f19209b.edit().putString("debug_http_host", host).apply();
                                        devSupportManagerBase2.w();
                                    }
                                }).create().show();
                                break;
                            } else {
                                FLog.g("ReactNative", "Unable to launch change bundle location because react activity is not available");
                                break;
                            }
                        case 1:
                            DevSupportManagerBase devSupportManagerBase2 = this.f18931b;
                            DevInternalSettings devInternalSettings2 = devSupportManagerBase2.q;
                            boolean z = devInternalSettings2.f18795b.getBoolean("hot_module_replacement", true);
                            SharedPreferences sharedPreferences = devInternalSettings2.f18795b;
                            sharedPreferences.edit().putBoolean("hot_module_replacement", !z).apply();
                            ReactApplicationContext reactApplicationContext = devSupportManagerBase2.p;
                            if (reactApplicationContext != null) {
                                if (z) {
                                    ((HMRClient) reactApplicationContext.getJSModule(HMRClient.class)).disable();
                                } else {
                                    ((HMRClient) reactApplicationContext.getJSModule(HMRClient.class)).enable();
                                }
                            }
                            if (!z && !devInternalSettings2.d()) {
                                int i4 = R.string.catalyst_hot_reloading_auto_enable;
                                Context context2 = devSupportManagerBase2.f18818a;
                                Toast.makeText(context2, context2.getString(i4), 1).show();
                                sharedPreferences.edit().putBoolean("js_dev_mode_debug", true).apply();
                                devSupportManagerBase2.w();
                                break;
                            }
                            break;
                        case 2:
                            DevSupportManagerBase devSupportManagerBase3 = this.f18931b;
                            DevInternalSettings devInternalSettings3 = devSupportManagerBase3.q;
                            if (!devInternalSettings3.b()) {
                                Activity activityA2 = devSupportManagerBase3.f18823f.a();
                                if (activityA2 == null) {
                                    FLog.g("ReactNative", "Unable to get reference to react activity");
                                } else if (!Settings.canDrawOverlays(activityA2)) {
                                    Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + activityA2.getPackageName()));
                                    intent.setFlags(268435456);
                                    FLog.q("ReactNative", "Overlay permissions needs to be granted in order for react native apps to run in dev mode");
                                    if (intent.resolveActivity(activityA2.getPackageManager()) != null) {
                                        activityA2.startActivity(intent);
                                    }
                                }
                            }
                            devInternalSettings3.f18795b.edit().putBoolean("fps_debug", !devInternalSettings3.b()).apply();
                            break;
                        default:
                            DevSupportManagerBase devSupportManagerBase4 = this.f18931b;
                            devSupportManagerBase4.getClass();
                            Context context3 = devSupportManagerBase4.f18818a;
                            Intent intent2 = new Intent(context3, (Class<?>) DevSettingsActivity.class);
                            intent2.setFlags(268435456);
                            context3.startActivity(intent2);
                            break;
                    }
                }
            });
            linkedHashMap.put(context.getString(R.string.catalyst_inspector_toggle), new DevOptionHandler() { // from class: com.facebook.react.devsupport.DevSupportManagerBase.4
                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public final void a() {
                    DevSupportManagerBase devSupportManagerBase = DevSupportManagerBase.this;
                    devSupportManagerBase.q.f18795b.edit().putBoolean("inspector_debug", !r1.f18795b.getBoolean("inspector_debug", false)).apply();
                    devSupportManagerBase.f18823f.b();
                }
            });
            final int i4 = 1;
            linkedHashMap.put(devInternalSettings.f18795b.getBoolean("hot_module_replacement", true) ? context.getString(R.string.catalyst_hot_reloading_stop) : context.getString(R.string.catalyst_hot_reloading), new DevOptionHandler(this) { // from class: com.facebook.react.devsupport.e

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ DevSupportManagerBase f18931b;

                {
                    this.f18931b = this;
                }

                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public final void a() {
                    switch (i4) {
                        case 0:
                            final DevSupportManagerBase devSupportManagerBase = this.f18931b;
                            Activity activityA = devSupportManagerBase.f18823f.a();
                            if (activityA != null && !activityA.isFinishing()) {
                                final EditText editText = new EditText(activityA);
                                editText.setHint("localhost:8081");
                                new AlertDialog.Builder(activityA).setTitle(devSupportManagerBase.f18818a.getString(R.string.catalyst_change_bundle_location)).setView(editText).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.facebook.react.devsupport.DevSupportManagerBase.3
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i42) {
                                        String host = editText.getText().toString();
                                        DevSupportManagerBase devSupportManagerBase2 = DevSupportManagerBase.this;
                                        PackagerConnectionSettings packagerConnectionSettings = devSupportManagerBase2.q.f18796c;
                                        packagerConnectionSettings.getClass();
                                        Intrinsics.checkNotNullParameter(host, "host");
                                        packagerConnectionSettings.f19209b.edit().putString("debug_http_host", host).apply();
                                        devSupportManagerBase2.w();
                                    }
                                }).create().show();
                                break;
                            } else {
                                FLog.g("ReactNative", "Unable to launch change bundle location because react activity is not available");
                                break;
                            }
                        case 1:
                            DevSupportManagerBase devSupportManagerBase2 = this.f18931b;
                            DevInternalSettings devInternalSettings2 = devSupportManagerBase2.q;
                            boolean z = devInternalSettings2.f18795b.getBoolean("hot_module_replacement", true);
                            SharedPreferences sharedPreferences = devInternalSettings2.f18795b;
                            sharedPreferences.edit().putBoolean("hot_module_replacement", !z).apply();
                            ReactApplicationContext reactApplicationContext = devSupportManagerBase2.p;
                            if (reactApplicationContext != null) {
                                if (z) {
                                    ((HMRClient) reactApplicationContext.getJSModule(HMRClient.class)).disable();
                                } else {
                                    ((HMRClient) reactApplicationContext.getJSModule(HMRClient.class)).enable();
                                }
                            }
                            if (!z && !devInternalSettings2.d()) {
                                int i42 = R.string.catalyst_hot_reloading_auto_enable;
                                Context context2 = devSupportManagerBase2.f18818a;
                                Toast.makeText(context2, context2.getString(i42), 1).show();
                                sharedPreferences.edit().putBoolean("js_dev_mode_debug", true).apply();
                                devSupportManagerBase2.w();
                                break;
                            }
                            break;
                        case 2:
                            DevSupportManagerBase devSupportManagerBase3 = this.f18931b;
                            DevInternalSettings devInternalSettings3 = devSupportManagerBase3.q;
                            if (!devInternalSettings3.b()) {
                                Activity activityA2 = devSupportManagerBase3.f18823f.a();
                                if (activityA2 == null) {
                                    FLog.g("ReactNative", "Unable to get reference to react activity");
                                } else if (!Settings.canDrawOverlays(activityA2)) {
                                    Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + activityA2.getPackageName()));
                                    intent.setFlags(268435456);
                                    FLog.q("ReactNative", "Overlay permissions needs to be granted in order for react native apps to run in dev mode");
                                    if (intent.resolveActivity(activityA2.getPackageManager()) != null) {
                                        activityA2.startActivity(intent);
                                    }
                                }
                            }
                            devInternalSettings3.f18795b.edit().putBoolean("fps_debug", !devInternalSettings3.b()).apply();
                            break;
                        default:
                            DevSupportManagerBase devSupportManagerBase4 = this.f18931b;
                            devSupportManagerBase4.getClass();
                            Context context3 = devSupportManagerBase4.f18818a;
                            Intent intent2 = new Intent(context3, (Class<?>) DevSettingsActivity.class);
                            intent2.setFlags(268435456);
                            context3.startActivity(intent2);
                            break;
                    }
                }
            });
            final int i5 = 2;
            linkedHashMap.put(devInternalSettings.b() ? context.getString(R.string.catalyst_perf_monitor_stop) : context.getString(R.string.catalyst_perf_monitor), new DevOptionHandler(this) { // from class: com.facebook.react.devsupport.e

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ DevSupportManagerBase f18931b;

                {
                    this.f18931b = this;
                }

                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public final void a() {
                    switch (i5) {
                        case 0:
                            final DevSupportManagerBase devSupportManagerBase = this.f18931b;
                            Activity activityA = devSupportManagerBase.f18823f.a();
                            if (activityA != null && !activityA.isFinishing()) {
                                final EditText editText = new EditText(activityA);
                                editText.setHint("localhost:8081");
                                new AlertDialog.Builder(activityA).setTitle(devSupportManagerBase.f18818a.getString(R.string.catalyst_change_bundle_location)).setView(editText).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.facebook.react.devsupport.DevSupportManagerBase.3
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i42) {
                                        String host = editText.getText().toString();
                                        DevSupportManagerBase devSupportManagerBase2 = DevSupportManagerBase.this;
                                        PackagerConnectionSettings packagerConnectionSettings = devSupportManagerBase2.q.f18796c;
                                        packagerConnectionSettings.getClass();
                                        Intrinsics.checkNotNullParameter(host, "host");
                                        packagerConnectionSettings.f19209b.edit().putString("debug_http_host", host).apply();
                                        devSupportManagerBase2.w();
                                    }
                                }).create().show();
                                break;
                            } else {
                                FLog.g("ReactNative", "Unable to launch change bundle location because react activity is not available");
                                break;
                            }
                        case 1:
                            DevSupportManagerBase devSupportManagerBase2 = this.f18931b;
                            DevInternalSettings devInternalSettings2 = devSupportManagerBase2.q;
                            boolean z = devInternalSettings2.f18795b.getBoolean("hot_module_replacement", true);
                            SharedPreferences sharedPreferences = devInternalSettings2.f18795b;
                            sharedPreferences.edit().putBoolean("hot_module_replacement", !z).apply();
                            ReactApplicationContext reactApplicationContext = devSupportManagerBase2.p;
                            if (reactApplicationContext != null) {
                                if (z) {
                                    ((HMRClient) reactApplicationContext.getJSModule(HMRClient.class)).disable();
                                } else {
                                    ((HMRClient) reactApplicationContext.getJSModule(HMRClient.class)).enable();
                                }
                            }
                            if (!z && !devInternalSettings2.d()) {
                                int i42 = R.string.catalyst_hot_reloading_auto_enable;
                                Context context2 = devSupportManagerBase2.f18818a;
                                Toast.makeText(context2, context2.getString(i42), 1).show();
                                sharedPreferences.edit().putBoolean("js_dev_mode_debug", true).apply();
                                devSupportManagerBase2.w();
                                break;
                            }
                            break;
                        case 2:
                            DevSupportManagerBase devSupportManagerBase3 = this.f18931b;
                            DevInternalSettings devInternalSettings3 = devSupportManagerBase3.q;
                            if (!devInternalSettings3.b()) {
                                Activity activityA2 = devSupportManagerBase3.f18823f.a();
                                if (activityA2 == null) {
                                    FLog.g("ReactNative", "Unable to get reference to react activity");
                                } else if (!Settings.canDrawOverlays(activityA2)) {
                                    Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + activityA2.getPackageName()));
                                    intent.setFlags(268435456);
                                    FLog.q("ReactNative", "Overlay permissions needs to be granted in order for react native apps to run in dev mode");
                                    if (intent.resolveActivity(activityA2.getPackageManager()) != null) {
                                        activityA2.startActivity(intent);
                                    }
                                }
                            }
                            devInternalSettings3.f18795b.edit().putBoolean("fps_debug", !devInternalSettings3.b()).apply();
                            break;
                        default:
                            DevSupportManagerBase devSupportManagerBase4 = this.f18931b;
                            devSupportManagerBase4.getClass();
                            Context context3 = devSupportManagerBase4.f18818a;
                            Intent intent2 = new Intent(context3, (Class<?>) DevSettingsActivity.class);
                            intent2.setFlags(268435456);
                            context3.startActivity(intent2);
                            break;
                    }
                }
            });
            final int i6 = 3;
            linkedHashMap.put(context.getString(R.string.catalyst_settings), new DevOptionHandler(this) { // from class: com.facebook.react.devsupport.e

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ DevSupportManagerBase f18931b;

                {
                    this.f18931b = this;
                }

                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public final void a() {
                    switch (i6) {
                        case 0:
                            final DevSupportManagerBase devSupportManagerBase = this.f18931b;
                            Activity activityA = devSupportManagerBase.f18823f.a();
                            if (activityA != null && !activityA.isFinishing()) {
                                final EditText editText = new EditText(activityA);
                                editText.setHint("localhost:8081");
                                new AlertDialog.Builder(activityA).setTitle(devSupportManagerBase.f18818a.getString(R.string.catalyst_change_bundle_location)).setView(editText).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.facebook.react.devsupport.DevSupportManagerBase.3
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i42) {
                                        String host = editText.getText().toString();
                                        DevSupportManagerBase devSupportManagerBase2 = DevSupportManagerBase.this;
                                        PackagerConnectionSettings packagerConnectionSettings = devSupportManagerBase2.q.f18796c;
                                        packagerConnectionSettings.getClass();
                                        Intrinsics.checkNotNullParameter(host, "host");
                                        packagerConnectionSettings.f19209b.edit().putString("debug_http_host", host).apply();
                                        devSupportManagerBase2.w();
                                    }
                                }).create().show();
                                break;
                            } else {
                                FLog.g("ReactNative", "Unable to launch change bundle location because react activity is not available");
                                break;
                            }
                        case 1:
                            DevSupportManagerBase devSupportManagerBase2 = this.f18931b;
                            DevInternalSettings devInternalSettings2 = devSupportManagerBase2.q;
                            boolean z = devInternalSettings2.f18795b.getBoolean("hot_module_replacement", true);
                            SharedPreferences sharedPreferences = devInternalSettings2.f18795b;
                            sharedPreferences.edit().putBoolean("hot_module_replacement", !z).apply();
                            ReactApplicationContext reactApplicationContext = devSupportManagerBase2.p;
                            if (reactApplicationContext != null) {
                                if (z) {
                                    ((HMRClient) reactApplicationContext.getJSModule(HMRClient.class)).disable();
                                } else {
                                    ((HMRClient) reactApplicationContext.getJSModule(HMRClient.class)).enable();
                                }
                            }
                            if (!z && !devInternalSettings2.d()) {
                                int i42 = R.string.catalyst_hot_reloading_auto_enable;
                                Context context2 = devSupportManagerBase2.f18818a;
                                Toast.makeText(context2, context2.getString(i42), 1).show();
                                sharedPreferences.edit().putBoolean("js_dev_mode_debug", true).apply();
                                devSupportManagerBase2.w();
                                break;
                            }
                            break;
                        case 2:
                            DevSupportManagerBase devSupportManagerBase3 = this.f18931b;
                            DevInternalSettings devInternalSettings3 = devSupportManagerBase3.q;
                            if (!devInternalSettings3.b()) {
                                Activity activityA2 = devSupportManagerBase3.f18823f.a();
                                if (activityA2 == null) {
                                    FLog.g("ReactNative", "Unable to get reference to react activity");
                                } else if (!Settings.canDrawOverlays(activityA2)) {
                                    Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + activityA2.getPackageName()));
                                    intent.setFlags(268435456);
                                    FLog.q("ReactNative", "Overlay permissions needs to be granted in order for react native apps to run in dev mode");
                                    if (intent.resolveActivity(activityA2.getPackageManager()) != null) {
                                        activityA2.startActivity(intent);
                                    }
                                }
                            }
                            devInternalSettings3.f18795b.edit().putBoolean("fps_debug", !devInternalSettings3.b()).apply();
                            break;
                        default:
                            DevSupportManagerBase devSupportManagerBase4 = this.f18931b;
                            devSupportManagerBase4.getClass();
                            Context context3 = devSupportManagerBase4.f18818a;
                            Intent intent2 = new Intent(context3, (Class<?>) DevSettingsActivity.class);
                            intent2.setFlags(268435456);
                            context3.startActivity(intent2);
                            break;
                    }
                }
            });
            LinkedHashMap linkedHashMap2 = this.f18822e;
            if (linkedHashMap2.size() > 0) {
                linkedHashMap.putAll(linkedHashMap2);
            }
            final DevOptionHandler[] devOptionHandlerArr = (DevOptionHandler[]) linkedHashMap.values().toArray(new DevOptionHandler[0]);
            Activity activityA = this.f18823f.a();
            if (activityA == null || activityA.isFinishing()) {
                FLog.g("ReactNative", "Unable to launch dev options menu because react activity isn't available");
                return;
            }
            LinearLayout linearLayout = new LinearLayout(activityA);
            linearLayout.setOrientation(1);
            TextView textView = new TextView(activityA);
            textView.setText(activityA.getString(R.string.catalyst_dev_menu_header, G()));
            textView.setPadding(0, 50, 0, 0);
            textView.setGravity(17);
            textView.setTextSize(16.0f);
            textView.setTypeface(textView.getTypeface(), 1);
            linearLayout.addView(textView);
            try {
                throw new IllegalStateException("Not implemented for bridgeless mode");
            } catch (IllegalStateException unused) {
                AlertDialog alertDialogCreate = new AlertDialog.Builder(activityA).setCustomTitle(linearLayout).setAdapter(new ArrayAdapter<String>(activityA, (String[]) linkedHashMap.keySet().toArray(new String[0])) { // from class: com.facebook.react.devsupport.DevSupportManagerBase.5
                    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
                    public final boolean areAllItemsEnabled() {
                        return false;
                    }

                    @Override // android.widget.ArrayAdapter, android.widget.Adapter
                    public final View getView(int i7, View view, ViewGroup viewGroup) {
                        View view2 = super.getView(i7, view, viewGroup);
                        view2.setEnabled(isEnabled(i7));
                        return view2;
                    }

                    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
                    public final boolean isEnabled(int i7) {
                        return !hashSet.contains(getItem(i7));
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.facebook.react.devsupport.f
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i7) {
                        DevSupportManagerBase devSupportManagerBase = this.f18932a;
                        devSupportManagerBase.getClass();
                        devOptionHandlerArr[i7].a();
                        devSupportManagerBase.f18830m = null;
                    }
                }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.facebook.react.devsupport.g
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        this.f18934a.f18830m = null;
                    }
                }).create();
                this.f18830m = alertDialogCreate;
                alertDialogCreate.show();
                ReactApplicationContext reactApplicationContext = this.p;
                if (reactApplicationContext != null) {
                    ((RCTNativeAppEventEmitter) reactApplicationContext.getJSModule(RCTNativeAppEventEmitter.class)).emit("RCTDevMenuShown", null);
                }
            }
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void B(ReactApplicationContext reactApplicationContext) {
        K(reactApplicationContext);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void C(ReactContext reactContext) {
        if (reactContext == this.p) {
            K(null);
        }
        System.gc();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void D() {
        final ReactApplicationContext reactApplicationContext = this.p;
        final String string = this.f18818a.getString(R.string.catalyst_open_debugger_error);
        DevServerHelper devServerHelper = this.f18821d;
        devServerHelper.getClass();
        Locale locale = Locale.US;
        String strP = androidx.fragment.app.e.p("http://", devServerHelper.f18798b.a(), "/open-debugger?device=", Uri.encode(devServerHelper.c()));
        Request.Builder builder = new Request.Builder();
        builder.i(strP);
        builder.f("POST", RequestBody.create((MediaType) null, ""));
        devServerHelper.f18799c.a(builder.b()).l0(new Callback() { // from class: com.facebook.react.devsupport.DevServerHelper.6

            /* renamed from: b */
            public final /* synthetic */ String f18816b;

            public AnonymousClass6(final String string2) {
                str = string2;
            }

            @Override // okhttp3.Callback
            public final void onFailure(Call call, IOException iOException) {
                RNLog.c(reactApplicationContext, str);
            }

            @Override // okhttp3.Callback
            public final void onResponse(Call call, Response response) {
            }
        });
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void E(final PackagerStatusCallback packagerStatusCallback) {
        DevServerHelper devServerHelper = this.f18821d;
        String strA = devServerHelper.f18798b.a();
        PackagerStatusCheck packagerStatusCheck = devServerHelper.f18801e;
        packagerStatusCheck.getClass();
        Locale locale = Locale.US;
        String strD = android.support.v4.media.b.D("http://", strA, "/status");
        Request.Builder builder = new Request.Builder();
        builder.i(strD);
        packagerStatusCheck.f18862a.a(builder.b()).l0(new Callback() { // from class: com.facebook.react.devsupport.PackagerStatusCheck.1
            public AnonymousClass1() {
            }

            @Override // okhttp3.Callback
            public final void onFailure(Call call, IOException iOException) {
                FLog.q("ReactNative", "The packager does not seem to be running as we got an IOException requesting its status: " + iOException.getMessage());
                packagerStatusCallback.a(false);
            }

            @Override // okhttp3.Callback
            public final void onResponse(Call call, Response response) throws IOException {
                boolean zC = response.c();
                PackagerStatusCallback packagerStatusCallback2 = packagerStatusCallback;
                if (!zC) {
                    FLog.g("ReactNative", "Got non-success http code from packager when requesting status: " + response.f56353d);
                    packagerStatusCallback2.a(false);
                    return;
                }
                ResponseBody responseBody = response.f56356g;
                if (responseBody == null) {
                    FLog.g("ReactNative", "Got null body response from packager when requesting status");
                    packagerStatusCallback2.a(false);
                    return;
                }
                String strR = responseBody.r();
                if ("packager-status:running".equals(strR)) {
                    packagerStatusCallback2.a(true);
                } else {
                    FLog.g("ReactNative", "Got unexpected response from packager when requesting status: ".concat(strR));
                    packagerStatusCallback2.a(false);
                }
            }
        });
    }

    public final DevLoadingViewManager F() {
        return this.f18827j;
    }

    public abstract String G();

    public final void H() {
        UiThreadUtil.assertOnUiThread();
        boolean z = this.t;
        BroadcastReceiver broadcastReceiver = this.f18820c;
        final DevServerHelper devServerHelper = this.f18821d;
        DevLoadingViewManager devLoadingViewManager = this.f18827j;
        ShakeDetector shakeDetector = this.f18819b;
        Context context = this.f18818a;
        if (!z) {
            DebugOverlayController debugOverlayController = this.n;
            if (debugOverlayController != null) {
                UiThreadUtil.runOnUiThread(debugOverlayController.new AnonymousClass1(false));
            }
            if (this.s) {
                SensorManager sensorManager = shakeDetector.f18702e;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(shakeDetector);
                }
                shakeDetector.f18702e = null;
                this.s = false;
            }
            if (this.r) {
                context.unregisterReceiver(broadcastReceiver);
                this.r = false;
            }
            j();
            AlertDialog alertDialog = this.f18830m;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f18830m = null;
            }
            devLoadingViewManager.c();
            devServerHelper.getClass();
            new AsyncTask<Void, Void, Void>() { // from class: com.facebook.react.devsupport.DevServerHelper.2
                public AnonymousClass2() {
                }

                @Override // android.os.AsyncTask
                public final Void doInBackground(Void[] voidArr) {
                    DevServerHelper devServerHelper2 = DevServerHelper.this;
                    JSPackagerClient jSPackagerClient = devServerHelper2.f18804h;
                    if (jSPackagerClient != null) {
                        ReconnectingWebSocket reconnectingWebSocket = jSPackagerClient.f19204a;
                        reconnectingWebSocket.f19215d = true;
                        WebSocket webSocket = reconnectingWebSocket.f19217f;
                        if (webSocket != null) {
                            try {
                                webSocket.c(1000, "End of session");
                            } catch (Exception unused) {
                            }
                            reconnectingWebSocket.f19217f = null;
                        }
                        reconnectingWebSocket.f19218g = null;
                        ReconnectingWebSocket.ConnectionCallback connectionCallback = reconnectingWebSocket.f19219h;
                        if (connectionCallback != null) {
                            ((AnonymousClass1.AnonymousClass3) connectionCallback).D();
                        }
                        devServerHelper2.f18804h = null;
                    }
                    return null;
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        DebugOverlayController debugOverlayController2 = this.n;
        if (debugOverlayController2 != null) {
            UiThreadUtil.runOnUiThread(debugOverlayController2.new AnonymousClass1(this.q.b()));
        }
        if (!this.s) {
            SensorManager manager = (SensorManager) context.getSystemService("sensor");
            shakeDetector.getClass();
            Intrinsics.checkNotNullParameter(manager, "manager");
            Sensor defaultSensor = manager.getDefaultSensor(1);
            if (defaultSensor != null) {
                shakeDetector.f18702e = manager;
                shakeDetector.f18703f = -1L;
                manager.registerListener(shakeDetector, defaultSensor, 2);
                shakeDetector.f18705h = 0L;
                shakeDetector.f18704g = 0;
                shakeDetector.f18699b = 0.0f;
                shakeDetector.f18700c = 0.0f;
                shakeDetector.f18701d = 0.0f;
            }
            this.s = true;
        }
        if (!this.r) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(context.getPackageName() + ".RELOAD_APP_ACTION");
            if (Build.VERSION.SDK_INT < 34 || context.getApplicationInfo().targetSdkVersion < 34) {
                context.registerReceiver(broadcastReceiver, intentFilter);
            } else {
                context.registerReceiver(broadcastReceiver, intentFilter, 2);
            }
            this.r = true;
        }
        if (this.o) {
            devLoadingViewManager.a("Reloading...");
        }
        final String simpleName = getClass().getSimpleName();
        final AnonymousClass8 anonymousClass8 = new AnonymousClass8();
        if (devServerHelper.f18804h != null) {
            FLog.q("ReactNative", "Packager connection already open, nooping.");
        } else {
            new AsyncTask<Void, Void, Void>() { // from class: com.facebook.react.devsupport.DevServerHelper.1

                /* renamed from: a */
                public final /* synthetic */ PackagerCommandListener f18806a;

                /* renamed from: b */
                public final /* synthetic */ String f18807b;

                /* renamed from: com.facebook.react.devsupport.DevServerHelper$1$1 */
                class C00221 extends NotificationOnlyHandler {
                    public C00221() {
                    }

                    @Override // com.facebook.react.packagerconnection.RequestHandler
                    public final void a() {
                        CxxInspectorPackagerConnection cxxInspectorPackagerConnection;
                        DevSupportManagerBase.AnonymousClass8 anonymousClass8 = (DevSupportManagerBase.AnonymousClass8) packagerCommandListener;
                        if (!InspectorFlags.getFuseboxEnabled() && (cxxInspectorPackagerConnection = DevSupportManagerBase.this.f18821d.f18805i) != null) {
                            cxxInspectorPackagerConnection.sendEventToAllConnections("{ \"id\":1,\"method\":\"Debugger.disable\" }");
                        }
                        UiThreadUtil.runOnUiThread(new h(anonymousClass8, 1));
                    }
                }

                /* renamed from: com.facebook.react.devsupport.DevServerHelper$1$2 */
                class AnonymousClass2 extends NotificationOnlyHandler {
                    public AnonymousClass2() {
                    }

                    @Override // com.facebook.react.packagerconnection.RequestHandler
                    public final void a() {
                        UiThreadUtil.runOnUiThread(new h((DevSupportManagerBase.AnonymousClass8) packagerCommandListener, 0));
                    }
                }

                /* renamed from: com.facebook.react.devsupport.DevServerHelper$1$3 */
                class AnonymousClass3 implements ReconnectingWebSocket.ConnectionCallback {
                    public AnonymousClass3() {
                    }

                    @Override // com.facebook.react.packagerconnection.ReconnectingWebSocket.ConnectionCallback
                    public final void D() {
                        DevSupportManagerBase.this.getClass();
                    }

                    @Override // com.facebook.react.packagerconnection.ReconnectingWebSocket.ConnectionCallback
                    public final void a() {
                        DevSupportManagerBase.this.getClass();
                    }
                }

                public AnonymousClass1(final PackagerCommandListener anonymousClass82, final String simpleName2) {
                    packagerCommandListener = anonymousClass82;
                    str = simpleName2;
                }

                @Override // android.os.AsyncTask
                public final Void doInBackground(Void[] voidArr) {
                    HashMap map = new HashMap();
                    map.put("reload", new NotificationOnlyHandler() { // from class: com.facebook.react.devsupport.DevServerHelper.1.1
                        public C00221() {
                        }

                        @Override // com.facebook.react.packagerconnection.RequestHandler
                        public final void a() {
                            CxxInspectorPackagerConnection cxxInspectorPackagerConnection;
                            DevSupportManagerBase.AnonymousClass8 anonymousClass82 = (DevSupportManagerBase.AnonymousClass8) packagerCommandListener;
                            if (!InspectorFlags.getFuseboxEnabled() && (cxxInspectorPackagerConnection = DevSupportManagerBase.this.f18821d.f18805i) != null) {
                                cxxInspectorPackagerConnection.sendEventToAllConnections("{ \"id\":1,\"method\":\"Debugger.disable\" }");
                            }
                            UiThreadUtil.runOnUiThread(new h(anonymousClass82, 1));
                        }
                    });
                    map.put("devMenu", new NotificationOnlyHandler() { // from class: com.facebook.react.devsupport.DevServerHelper.1.2
                        public AnonymousClass2() {
                        }

                        @Override // com.facebook.react.packagerconnection.RequestHandler
                        public final void a() {
                            UiThreadUtil.runOnUiThread(new h((DevSupportManagerBase.AnonymousClass8) packagerCommandListener, 0));
                        }
                    });
                    DevSupportManagerBase.this.getClass();
                    map.putAll(new FileIoHandler().f19198d);
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3();
                    DevServerHelper devServerHelper2 = DevServerHelper.this;
                    PackagerConnectionSettings packagerConnectionSettings = devServerHelper2.f18798b;
                    JSPackagerClient jSPackagerClient = new JSPackagerClient();
                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme("ws").encodedAuthority(packagerConnectionSettings.a()).appendPath(APayConstants.Error.MESSAGE).appendQueryParameter(LogSubCategory.Context.DEVICE, AndroidInfoHelpers.a()).appendQueryParameter(Constants.APP_DIR, packagerConnectionSettings.f19210c).appendQueryParameter("clientid", str);
                    ReconnectingWebSocket reconnectingWebSocket = new ReconnectingWebSocket(builder.build().toString(), jSPackagerClient, anonymousClass3);
                    jSPackagerClient.f19204a = reconnectingWebSocket;
                    jSPackagerClient.f19205b = map;
                    devServerHelper2.f18804h = jSPackagerClient;
                    reconnectingWebSocket.h();
                    return null;
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public final void I(String str, BundleLoadCallback bundleLoadCallback) {
        ReactMarker.logMarker(ReactMarkerConstants.DOWNLOAD_START);
        Context context = this.f18818a;
        if (context != null) {
            try {
                URL url = new URL(str);
                int port = url.getPort() != -1 ? url.getPort() : url.getDefaultPort();
                this.f18827j.a(context.getString(R.string.catalyst_loading_from_url, url.getHost() + ":" + port));
                this.o = true;
            } catch (MalformedURLException e2) {
                FLog.g("ReactNative", "Bundle url format is invalid. \n\n" + e2.toString());
            }
        }
        final BundleDownloader.BundleInfo bundleInfo = new BundleDownloader.BundleInfo();
        final AnonymousClass7 anonymousClass7 = new AnonymousClass7(bundleInfo, bundleLoadCallback);
        final File file = this.f18825h;
        final BundleDownloader bundleDownloader = this.f18821d.f18800d;
        bundleDownloader.getClass();
        Request.Builder builder = new Request.Builder();
        builder.i(str);
        builder.a("Accept", "multipart/mixed");
        RealCall realCallA = bundleDownloader.f18761a.a(builder.b());
        bundleDownloader.f18762b = realCallA;
        realCallA.l0(new Callback() { // from class: com.facebook.react.devsupport.BundleDownloader.1
            @Override // okhttp3.Callback
            public final void onFailure(Call call, IOException iOException) {
                BundleDownloader bundleDownloader2 = BundleDownloader.this;
                RealCall realCall = bundleDownloader2.f18762b;
                if (realCall == null || realCall.p) {
                    bundleDownloader2.f18762b = null;
                    return;
                }
                bundleDownloader2.f18762b = null;
                String str2 = call.r().f56331a.f56267i;
                String strC = android.support.v4.media.b.C("URL: ", str2);
                int i2 = DebugServerException.f18690a;
                ((DevSupportManagerBase.AnonymousClass7) anonymousClass7).a(DebugServerException.Companion.a(str2, "Could not connect to development server.", strC, iOException));
            }

            @Override // okhttp3.Callback
            public final void onResponse(Call call, Response response) throws Throwable {
                Throwable th;
                BundleDownloader bundleDownloader2 = BundleDownloader.this;
                try {
                    RealCall realCall = bundleDownloader2.f18762b;
                    if (realCall != null && !realCall.p) {
                        bundleDownloader2.f18762b = null;
                        String str2 = response.f56350a.f56331a.f56267i;
                        Intrinsics.checkNotNullParameter("content-type", CLConstants.FIELD_PAY_INFO_NAME);
                        Matcher matcher = Pattern.compile("multipart/mixed;.*boundary=\"([^\"]+)\"").matcher(response.b("content-type", null));
                        if (matcher.find()) {
                            try {
                                BundleDownloader.b(BundleDownloader.this, str2, response, matcher.group(1), file, bundleInfo, anonymousClass7);
                                response = response;
                            } catch (Throwable th2) {
                                th = th2;
                                response = response;
                                th = th;
                                try {
                                    response.close();
                                    throw th;
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                    throw th;
                                }
                            }
                        } else {
                            ResponseBody responseBody = response.f56356g;
                            try {
                                BundleDownloader.a(BundleDownloader.this, str2, response.f56353d, response.f56355f, responseBody.source(), file, bundleInfo, anonymousClass7);
                                responseBody.close();
                            } finally {
                            }
                        }
                        response.close();
                        return;
                    }
                    bundleDownloader2.f18762b = null;
                    response.close();
                } catch (Throwable th4) {
                    th = th4;
                    th = th;
                    response.close();
                    throw th;
                }
            }
        });
    }

    public final void J() {
        if (UiThreadUtil.isOnUiThread()) {
            H();
        } else {
            UiThreadUtil.runOnUiThread(new b(this, 1));
        }
    }

    public final void K(ReactApplicationContext reactApplicationContext) {
        if (this.p == reactApplicationContext) {
            return;
        }
        this.p = reactApplicationContext;
        DebugOverlayController debugOverlayController = this.n;
        if (debugOverlayController != null) {
            UiThreadUtil.runOnUiThread(debugOverlayController.new AnonymousClass1(false));
        }
        if (reactApplicationContext != null) {
            this.n = new DebugOverlayController(reactApplicationContext);
        }
        if (this.p != null) {
            try {
                URL url = new URL(m());
                ((HMRClient) this.p.getJSModule(HMRClient.class)).setup(LogSubCategory.LifeCycle.ANDROID, url.getPath().substring(1), url.getHost(), url.getPort() != -1 ? url.getPort() : url.getDefaultPort(), this.q.f18795b.getBoolean("hot_module_replacement", true), url.getProtocol());
            } catch (MalformedURLException e2) {
                L(e2.getMessage(), e2);
            }
        }
        J();
    }

    public final void L(String str, Exception exc) {
        FLog.h("ReactNative", "Exception in native call", exc);
        int i2 = StackTraceHelper.f18896a;
        StackTraceElement[] stackTrace = exc.getStackTrace();
        StackFrame[] stackFrameArr = new StackFrame[stackTrace.length];
        for (int i3 = 0; i3 < stackTrace.length; i3++) {
            stackFrameArr[i3] = new StackTraceHelper.StackFrameImpl(stackTrace[i3].getClassName(), stackTrace[i3].getFileName(), stackTrace[i3].getMethodName(), stackTrace[i3].getLineNumber());
        }
        UiThreadUtil.runOnUiThread(new d(this, str, stackFrameArr, ErrorType.f18940c));
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void a(String str, DevSupportManager.PausedInDebuggerOverlayCommandListener pausedInDebuggerOverlayCommandListener) {
        this.f18828k.a(str, pausedInDebuggerOverlayCommandListener);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void b() {
        this.f18828k.b();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void c(boolean z) {
        if (this.t && this.q.a() != z) {
            UiThreadUtil.runOnUiThread(new a(this, z, 2));
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final String d() {
        return this.f18825h.getAbsolutePath();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final String e() {
        return this.u;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void f() {
        DevServerHelper devServerHelper = this.f18821d;
        devServerHelper.getClass();
        devServerHelper.new AnonymousClass4().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final boolean g() {
        return this.t;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void h(boolean z) {
        if (this.t) {
            UiThreadUtil.runOnUiThread(new a(this, z, 1));
        }
    }

    @Override // com.facebook.react.bridge.JSExceptionHandler
    public final void handleException(Exception exc) {
        if (!this.t) {
            this.f18826i.handleException(exc);
            return;
        }
        StringBuilder sb = new StringBuilder(exc.getMessage() == null ? "Exception in native call from JS" : exc.getMessage());
        for (Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
            sb.append("\n\n");
            sb.append(cause.getMessage());
        }
        if (!(exc instanceof JavascriptException)) {
            L(sb.toString(), exc);
        } else {
            FLog.h("ReactNative", "Exception in native call from JS", exc);
            UiThreadUtil.runOnUiThread(new d(this, exc.getMessage().toString(), new StackFrame[0], ErrorType.f18939b));
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final SurfaceDelegate i(String str) {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void j() {
        SurfaceDelegate surfaceDelegate = this.f18829l;
        if (surfaceDelegate == null) {
            return;
        }
        surfaceDelegate.c();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final Pair k(Pair pair) {
        return pair;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void l(boolean z) {
        this.t = z;
        J();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final String m() {
        String str = this.f18824g;
        if (str == null) {
            return "";
        }
        DevServerHelper devServerHelper = this.f18821d;
        return devServerHelper.a(str, devServerHelper.f18798b.a(), false, true);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void n(String str, DevOptionHandler devOptionHandler) {
        this.f18822e.put(str, devOptionHandler);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void o(View rootView) {
        this.f18823f.getClass();
        Intrinsics.checkNotNullParameter(rootView, "rootView");
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final View p() {
        ReactHostImplDevHelper reactHostImplDevHelper = this.f18823f;
        reactHostImplDevHelper.getClass();
        Intrinsics.checkNotNullParameter("LogBox", "appKey");
        Activity activityA = reactHostImplDevHelper.a();
        if (activityA == null) {
            return null;
        }
        ReactHostImpl reactHostImpl = reactHostImplDevHelper.f19260a;
        synchronized (reactHostImpl.f19245g) {
            try {
                Iterator it = reactHostImpl.f19245g.iterator();
                while (it.hasNext()) {
                    if (((ReactSurfaceImpl) it.next()).f19280c.getModuleName().equals("LogBox")) {
                        return null;
                    }
                }
                ReactSurfaceImpl reactSurfaceImpl = new ReactSurfaceImpl(activityA, "LogBox", new Bundle());
                ReactSurfaceView reactSurfaceView = new ReactSurfaceView(activityA, reactSurfaceImpl);
                AtomicReference atomicReference = reactSurfaceImpl.f19278a;
                while (!atomicReference.compareAndSet(null, reactSurfaceView)) {
                    if (atomicReference.get() != null) {
                        throw new IllegalStateException("Trying to call ReactSurface.attachView(), but the view is already attached.");
                    }
                }
                reactSurfaceImpl.f19281d = reactSurfaceView.getContext();
                Intrinsics.checkNotNullExpressionValue(reactSurfaceImpl, "createWithView(...)");
                reactSurfaceImpl.a(reactHostImplDevHelper.f19260a);
                reactSurfaceImpl.start();
                return reactSurfaceImpl.getView();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void q() {
        if (this.t) {
            UiThreadUtil.runOnUiThread(new b(this, 0));
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final RedBoxHandler r() {
        return null;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void s() {
        if (this.t) {
            DevServerHelper devServerHelper = this.f18821d;
            if (devServerHelper.f18805i != null) {
                FLog.q("ReactNative", "Inspector connection already open, nooping.");
            } else {
                devServerHelper.new AnonymousClass3().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final StackFrame[] t() {
        return this.v;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final ReactContext u() {
        return this.p;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final Activity v() {
        return this.f18823f.a();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final void x(boolean z) {
        if (this.t) {
            UiThreadUtil.runOnUiThread(new a(this, z, 0));
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final DeveloperSettings y() {
        return this.q;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public final boolean z() throws PackageManager.NameNotFoundException {
        Context context = this.f18818a;
        if (this.t) {
            File file = this.f18825h;
            if (file.exists()) {
                try {
                    String packageName = context.getPackageName();
                    if (file.lastModified() > context.getPackageManager().getPackageInfo(packageName, 0).lastUpdateTime) {
                        Locale locale = Locale.US;
                        File file2 = new File("/data/local/tmp/exopackage/" + packageName + "//secondary-dex");
                        if (!file2.exists()) {
                            return true;
                        }
                        if (file.lastModified() > file2.lastModified()) {
                            return true;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    FLog.g("ReactNative", "DevSupport is unable to get current app info");
                }
            }
        }
        return false;
    }
}

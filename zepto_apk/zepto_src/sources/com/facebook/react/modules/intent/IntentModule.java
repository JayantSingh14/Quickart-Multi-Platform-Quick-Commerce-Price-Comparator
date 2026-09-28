package com.facebook.react.modules.intent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.facebook.fbreact.specs.NativeIntentAndroidSpec;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.module.annotations.ReactModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ReactModule(name = "IntentAndroid")
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class IntentModule extends NativeIntentAndroidSpec {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final String EXTRA_MAP_KEY_FOR_VALUE = "value";

    @NotNull
    public static final String NAME = "IntentAndroid";

    @Nullable
    private LifecycleEventListener initialURLListener;

    @NotNull
    private final List<Promise> pendingOpenURLPromises;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19126a;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.String.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Number.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadableType.Boolean.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f19126a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntentModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.pendingOpenURLPromises = new ArrayList();
    }

    private final void sendOSIntent(Intent intent, boolean z) {
        String packageName;
        Activity currentActivity = getCurrentActivity();
        String packageName2 = getReactApplicationContext().getPackageName();
        PackageManager packageManager = getReactApplicationContext().getPackageManager();
        ComponentName component = packageManager == null ? intent.getComponent() : intent.resolveActivity(packageManager);
        if (component == null || (packageName = component.getPackageName()) == null) {
            packageName = "";
        }
        if (z || currentActivity == null || !Intrinsics.b(packageName2, packageName)) {
            intent.addFlags(268435456);
        }
        if (currentActivity != null) {
            currentActivity.startActivity(intent);
        } else {
            getReactApplicationContext().startActivity(intent);
        }
    }

    private final synchronized void waitForActivityAndGetInitialURL(Promise promise) {
        this.pendingOpenURLPromises.add(promise);
        if (this.initialURLListener != null) {
            return;
        }
        this.initialURLListener = new LifecycleEventListener() { // from class: com.facebook.react.modules.intent.IntentModule.waitForActivityAndGetInitialURL.1
            @Override // com.facebook.react.bridge.LifecycleEventListener
            public final void onHostDestroy() {
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public final void onHostPause() {
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public final void onHostResume() {
                IntentModule.this.getReactApplicationContext().removeLifecycleEventListener(this);
                IntentModule intentModule = IntentModule.this;
                synchronized (intentModule) {
                    try {
                        Iterator it = intentModule.pendingOpenURLPromises.iterator();
                        while (it.hasNext()) {
                            intentModule.getInitialURL((Promise) it.next());
                        }
                        intentModule.initialURLListener = null;
                        intentModule.pendingOpenURLPromises.clear();
                        Unit unit = Unit.f53572a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        getReactApplicationContext().addLifecycleEventListener(this.initialURLListener);
    }

    @Override // com.facebook.fbreact.specs.NativeIntentAndroidSpec
    public void canOpenURL(@Nullable String str, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (str == null || str.length() == 0) {
            promise.reject(new JSApplicationIllegalArgumentException(b.C("Invalid URL: ", str)));
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            PackageManager packageManager = getReactApplicationContext().getPackageManager();
            promise.resolve(Boolean.valueOf((packageManager == null || intent.resolveActivity(packageManager) == null) ? false : true));
        } catch (Exception e2) {
            promise.reject(new JSApplicationIllegalArgumentException(e.p("Could not check if URL '", str, "' can be opened: ", e2.getMessage())));
        }
    }

    @Override // com.facebook.fbreact.specs.NativeIntentAndroidSpec
    public void getInitialURL(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Activity currentActivity = getCurrentActivity();
            if (currentActivity == null) {
                waitForActivityAndGetInitialURL(promise);
                return;
            }
            Intent intent = currentActivity.getIntent();
            String action = intent.getAction();
            Uri data = intent.getData();
            promise.resolve((data == null || !("android.intent.action.VIEW".equals(action) || "android.nfc.action.NDEF_DISCOVERED".equals(action))) ? null : data.toString());
        } catch (Exception e2) {
            promise.reject(new JSApplicationIllegalArgumentException(b.C("Could not get the initial URL : ", e2.getMessage())));
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        synchronized (this) {
            try {
                this.pendingOpenURLPromises.clear();
                LifecycleEventListener lifecycleEventListener = this.initialURLListener;
                if (lifecycleEventListener != null) {
                    getReactApplicationContext().removeLifecycleEventListener(lifecycleEventListener);
                    Unit unit = Unit.f53572a;
                }
                this.initialURLListener = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        super.invalidate();
    }

    @Override // com.facebook.fbreact.specs.NativeIntentAndroidSpec
    public void openSettings(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Intent intent = new Intent();
            Activity currentActivity = getCurrentActivity();
            if (currentActivity == null) {
                throw new IllegalStateException("Required value was null.");
            }
            String packageName = getReactApplicationContext().getPackageName();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("package:" + packageName));
            intent.addFlags(268435456);
            intent.addFlags(1073741824);
            intent.addFlags(8388608);
            currentActivity.startActivity(intent);
            promise.resolve(Boolean.TRUE);
        } catch (Exception e2) {
            promise.reject(new JSApplicationIllegalArgumentException(b.C("Could not open the Settings: ", e2.getMessage())));
        }
    }

    @Override // com.facebook.fbreact.specs.NativeIntentAndroidSpec
    public void openURL(@Nullable String str, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (str == null || str.length() == 0) {
            promise.reject(new JSApplicationIllegalArgumentException(b.C("Invalid URL: ", str)));
            return;
        }
        try {
            sendOSIntent(new Intent("android.intent.action.VIEW", Uri.parse(str).normalizeScheme()), false);
            promise.resolve(Boolean.TRUE);
        } catch (Exception e2) {
            promise.reject(new JSApplicationIllegalArgumentException(e.p("Could not open URL '", str, "': ", e2.getMessage())));
        }
    }

    @Override // com.facebook.fbreact.specs.NativeIntentAndroidSpec
    public void sendIntent(@Nullable String str, @Nullable ReadableArray readableArray, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (str == null || str.length() == 0) {
            promise.reject(new JSApplicationIllegalArgumentException(b.D("Invalid Action: ", str, CLConstants.DOT_SALT_DELIMETER)));
            return;
        }
        Intent intent = new Intent(str);
        PackageManager packageManager = getReactApplicationContext().getPackageManager();
        if (packageManager == null || intent.resolveActivity(packageManager) == null) {
            promise.reject(new JSApplicationIllegalArgumentException(b.D("Could not launch Intent with action ", str, CLConstants.DOT_SALT_DELIMETER)));
            return;
        }
        if (readableArray != null) {
            int size = readableArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                ReadableMap map = readableArray.getMap(i2);
                if (map != null) {
                    String string = map.getString("key");
                    int i3 = WhenMappings.f19126a[map.getType("value").ordinal()];
                    if (i3 == 1) {
                        intent.putExtra(string, map.getString("value"));
                    } else if (i3 == 2) {
                        intent.putExtra(string, map.getDouble("value"));
                    } else {
                        if (i3 != 3) {
                            promise.reject(new JSApplicationIllegalArgumentException(b.D("Extra type for ", string, " not supported.")));
                            return;
                        }
                        intent.putExtra(string, map.getBoolean("value"));
                    }
                }
            }
        }
        sendOSIntent(intent, true);
    }
}

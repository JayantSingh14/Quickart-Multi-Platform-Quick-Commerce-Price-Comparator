package com.zeptoconsumerapp.AppShortcuts;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.view.inputmethod.a;
import bridges.CommsModule;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.zeptoconsumerapp.Utils;
import java.io.File;
import java.util.ArrayList;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import timber.log.Timber;

@ReactModule(name = AppShortcutsModule.REACT_NAME)
/* loaded from: classes.dex */
class AppShortcutsModule extends ReactContextBaseJavaModule {
    static final String REACT_NAME = "ReactAppShortcuts";
    private static final String SHORTCUT_ITEM = "SHORTCUT_ITEM";

    public AppShortcutsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(new ActivityEventListener() { // from class: com.zeptoconsumerapp.AppShortcuts.AppShortcutsModule.1
            @Override // com.facebook.react.bridge.ActivityEventListener
            public final void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
            }

            @Override // com.facebook.react.bridge.ActivityEventListener
            public final void onNewIntent(Intent intent) {
                AppShortcutsModule.this.sendJSEvent(intent);
            }
        });
    }

    public static Boolean checkIfFileExists(String str) {
        try {
            return !new File(str).exists() ? Boolean.FALSE : Boolean.TRUE;
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    public static ArrayList<ShortcutItem> convertReableArrayToArrayList(ReadableArray readableArray) {
        ArrayList<ShortcutItem> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            try {
                ReadableMap map = readableArray.getMap(i2);
                arrayList.add(new ShortcutItem(map.getString("localPath"), map.getString("type"), map.getString("title"), map.getString("icon"), new UserInfo(map.getMap("userInfo").getString("url"))));
            } catch (Exception e2) {
                Utils.i(e2);
                return arrayList;
            }
        }
        return arrayList;
    }

    private boolean isShortcutSupported() {
        return Build.VERSION.SDK_INT >= 25;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendJSEvent(Intent intent) {
        if (intent != null) {
            try {
                if (isShortcutSupported() && intent.hasExtra(SHORTCUT_ITEM)) {
                    PersistableBundle persistableBundle = (PersistableBundle) intent.getExtras().getParcelable(SHORTCUT_ITEM);
                    ShortcutItem shortcutItemA = persistableBundle != null ? ShortcutItem.a(persistableBundle) : null;
                    if (shortcutItemA != null) {
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("quickActionShortcut", shortcutItemA.d());
                    }
                }
            } catch (Exception e2) {
                Utils.i(e2);
            }
        }
    }

    @ReactMethod
    @TargetApi(25)
    public void clearShortcutItems() {
        if (isShortcutSupported()) {
            a.h(getReactApplicationContext().getSystemService(a.i())).removeAllDynamicShortcuts();
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_NAME;
    }

    @ReactMethod
    public void isSupported(Callback callback) {
        if (callback != null) {
            callback.invoke(null, Boolean.valueOf(isShortcutSupported()));
        }
    }

    @ReactMethod
    @TargetApi(25)
    public void popInitialAction(Promise promise) {
        Intent intent;
        PersistableBundle persistableBundle;
        try {
            Activity currentActivity = getCurrentActivity();
            promise.resolve((currentActivity == null || (intent = currentActivity.getIntent()) == null || !intent.hasExtra(SHORTCUT_ITEM) || (persistableBundle = (PersistableBundle) intent.getExtras().getParcelable(SHORTCUT_ITEM)) == null) ? null : ShortcutItem.a(persistableBundle).d());
        } catch (Exception e2) {
            promise.reject(new JSApplicationIllegalArgumentException("AppShortcuts.popInitialAction error. " + e2.getMessage()));
        }
    }

    @ReactMethod
    @TargetApi(25)
    public void setShortcutItems(ReadableArray readableArray, Promise promise) {
        UserInfo userInfo;
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        ArrayList<ShortcutItem> arrayListConvertReableArrayToArrayList = convertReableArrayToArrayList(readableArray);
        if (!isShortcutSupported() || arrayListConvertReableArrayToArrayList == null || arrayListConvertReableArrayToArrayList.isEmpty()) {
            return;
        }
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        SharedPreferences sharedPreferences = reactApplicationContext.getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0);
        ArrayList arrayList = new ArrayList(arrayListConvertReableArrayToArrayList.size());
        for (int i2 = 0; i2 < arrayListConvertReableArrayToArrayList.size(); i2++) {
            ShortcutItem shortcutItem = arrayListConvertReableArrayToArrayList.get(i2);
            ShortcutItem shortcutItemB = ShortcutItem.b(shortcutItem);
            if (checkIfFileExists(shortcutItem.localPath).booleanValue() && (userInfo = shortcutItemB.userInfo) != null && userInfo.c() != null) {
                Bitmap bitmapB = Utils.b(shortcutItem.localPath);
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(shortcutItemB.userInfo.c()));
                    intent.setPackage(currentActivity.getPackageName());
                    intent.putExtra(SHORTCUT_ITEM, shortcutItemB.c());
                    a.l();
                    arrayList.add(a.e(reactApplicationContext, CLConstants.SHARED_PREFERENCE_ITEM_ID + i2).setShortLabel(shortcutItemB.title).setLongLabel(shortcutItemB.title).setIcon(IconCompat.b(bitmapB).i()).setIntent(intent).build());
                } catch (Exception e2) {
                    Timber.d("Error").d(e2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        try {
            a.h(getReactApplicationContext().getSystemService(a.i())).setDynamicShortcuts(arrayList);
            sharedPreferences.edit().putString("shouldUpdateShortcutsOnAppIconUpdate", "false").commit();
        } catch (Exception e3) {
            Utils.i(e3);
        }
    }
}

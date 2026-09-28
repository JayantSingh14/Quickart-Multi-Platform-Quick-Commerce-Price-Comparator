package com.facebook.react.modules.permissions;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.fbreact.specs.NativePermissionsAndroidSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = "PermissionsAndroid")
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class PermissionsModule extends NativePermissionsAndroidSpec implements PermissionListener {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final String ERROR_INVALID_ACTIVITY = "E_INVALID_ACTIVITY";

    @NotNull
    public static final String NAME = "PermissionsAndroid";

    @NotNull
    private final String DENIED;

    @NotNull
    private final String GRANTED;

    @NotNull
    private final String NEVER_ASK_AGAIN;

    @NotNull
    private final SparseArray<Callback> callbacks;
    private int requestCode;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    public PermissionsModule(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.callbacks = new SparseArray<>();
        this.GRANTED = "granted";
        this.DENIED = "denied";
        this.NEVER_ASK_AGAIN = "never_ask_again";
    }

    private final PermissionAwareActivity getPermissionAwareActivity() {
        ComponentCallbacks2 currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
        }
        if (currentActivity instanceof PermissionAwareActivity) {
            return (PermissionAwareActivity) currentActivity;
        }
        throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
    }

    @Override // com.facebook.fbreact.specs.NativePermissionsAndroidSpec
    public void checkPermission(@NotNull String permission, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Boolean.valueOf(getReactApplicationContext().getBaseContext().checkSelfPermission(permission) == 0));
    }

    @Override // com.facebook.react.modules.core.PermissionListener
    public boolean onRequestPermissionsResult(int i2, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        try {
            Callback callback = this.callbacks.get(i2);
            if (callback != null) {
                callback.invoke(grantResults, getPermissionAwareActivity());
                this.callbacks.remove(i2);
            } else {
                FLog.s("PermissionsModule", "Unable to find callback with requestCode %d", Integer.valueOf(i2));
            }
            return this.callbacks.size() == 0;
        } catch (IllegalStateException e2) {
            if (!FLog.f17086a.a(6)) {
                return false;
            }
            FLogDefaultLoggingDelegate.c(6, "PermissionsModule", "Unexpected invocation of `onRequestPermissionsResult` with invalid current activity", e2);
            return false;
        }
    }

    @Override // com.facebook.fbreact.specs.NativePermissionsAndroidSpec
    public void requestMultiplePermissions(@NotNull ReadableArray permissions, @NotNull final Promise promise) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(promise, "promise");
        final WritableNativeMap writableNativeMap = new WritableNativeMap();
        final ArrayList arrayList = new ArrayList();
        Context baseContext = getReactApplicationContext().getBaseContext();
        int size = permissions.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            String string = permissions.getString(i3);
            if (string != null) {
                if (baseContext.checkSelfPermission(string) == 0) {
                    writableNativeMap.putString(string, this.GRANTED);
                    i2++;
                } else {
                    arrayList.add(string);
                }
            }
        }
        if (permissions.size() == i2) {
            promise.resolve(writableNativeMap);
            return;
        }
        try {
            PermissionAwareActivity permissionAwareActivity = getPermissionAwareActivity();
            this.callbacks.put(this.requestCode, new Callback() { // from class: com.facebook.react.modules.permissions.PermissionsModule.requestMultiplePermissions.1
                @Override // com.facebook.react.bridge.Callback
                public final void invoke(Object... args) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    int i4 = 0;
                    Object obj = args[0];
                    Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.IntArray");
                    int[] iArr = (int[]) obj;
                    Object obj2 = args[1];
                    Intrinsics.d(obj2, "null cannot be cast to non-null type com.facebook.react.modules.core.PermissionAwareActivity");
                    PermissionAwareActivity permissionAwareActivity2 = (PermissionAwareActivity) obj2;
                    ArrayList arrayList2 = arrayList;
                    int size2 = arrayList2.size();
                    while (true) {
                        WritableNativeMap writableNativeMap2 = writableNativeMap;
                        if (i4 >= size2) {
                            promise.resolve(writableNativeMap2);
                            return;
                        }
                        Object obj3 = arrayList2.get(i4);
                        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
                        String str = (String) obj3;
                        int length = iArr.length;
                        PermissionsModule permissionsModule = this;
                        if (length > i4 && iArr[i4] == 0) {
                            writableNativeMap2.putString(str, permissionsModule.GRANTED);
                        } else if (permissionAwareActivity2.shouldShowRequestPermissionRationale(str)) {
                            writableNativeMap2.putString(str, permissionsModule.DENIED);
                        } else {
                            writableNativeMap2.putString(str, permissionsModule.NEVER_ASK_AGAIN);
                        }
                        i4++;
                    }
                }
            });
            permissionAwareActivity.d((String[]) arrayList.toArray(new String[0]), this.requestCode, this);
            this.requestCode++;
        } catch (IllegalStateException e2) {
            promise.reject(ERROR_INVALID_ACTIVITY, e2);
        }
    }

    @Override // com.facebook.fbreact.specs.NativePermissionsAndroidSpec
    public void requestPermission(@NotNull final String permission, @NotNull final Promise promise) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (getReactApplicationContext().getBaseContext().checkSelfPermission(permission) == 0) {
            promise.resolve(this.GRANTED);
            return;
        }
        try {
            PermissionAwareActivity permissionAwareActivity = getPermissionAwareActivity();
            this.callbacks.put(this.requestCode, new Callback() { // from class: com.facebook.react.modules.permissions.PermissionsModule.requestPermission.1
                @Override // com.facebook.react.bridge.Callback
                public final void invoke(Object... args) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Object obj = args[0];
                    Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.IntArray");
                    int[] iArr = (int[]) obj;
                    int length = iArr.length;
                    PermissionsModule permissionsModule = this;
                    Promise promise2 = promise;
                    if (length > 0 && iArr[0] == 0) {
                        promise2.resolve(permissionsModule.GRANTED);
                        return;
                    }
                    Object obj2 = args[1];
                    Intrinsics.d(obj2, "null cannot be cast to non-null type com.facebook.react.modules.core.PermissionAwareActivity");
                    if (((PermissionAwareActivity) obj2).shouldShowRequestPermissionRationale(permission)) {
                        promise2.resolve(permissionsModule.DENIED);
                    } else {
                        promise2.resolve(permissionsModule.NEVER_ASK_AGAIN);
                    }
                }
            });
            permissionAwareActivity.d(new String[]{permission}, this.requestCode, this);
            this.requestCode++;
        } catch (IllegalStateException e2) {
            promise.reject(ERROR_INVALID_ACTIVITY, e2);
        }
    }

    @Override // com.facebook.fbreact.specs.NativePermissionsAndroidSpec
    public void shouldShowRequestPermissionRationale(@NotNull String permission, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Boolean.valueOf(getPermissionAwareActivity().shouldShowRequestPermissionRationale(permission)));
        } catch (IllegalStateException e2) {
            promise.reject(ERROR_INVALID_ACTIVITY, e2);
        }
    }
}

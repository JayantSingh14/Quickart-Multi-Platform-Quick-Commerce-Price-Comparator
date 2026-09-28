package io.invertase.firebase.common;

import android.app.Activity;
import android.content.Context;
import android.support.v4.media.b;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import io.invertase.firebase.interfaces.ContextProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class ReactNativeFirebaseModule extends ReactContextBaseJavaModule implements ContextProvider {
    private final TaskExecutorService executorService;
    private String moduleName;

    public ReactNativeFirebaseModule(ReactApplicationContext reactApplicationContext, String str) {
        super(reactApplicationContext);
        this.moduleName = str;
        this.executorService = new TaskExecutorService(getName());
    }

    public static void rejectPromiseWithCodeAndMessage(Promise promise, String str, String str2, ReadableMap readableMap) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("code", str);
        writableMapCreateMap.putString(APayConstants.Error.MESSAGE, str2);
        if (readableMap != null) {
            writableMapCreateMap.putMap("resolver", readableMap);
        }
        promise.reject(str, str2, writableMapCreateMap);
    }

    public static void rejectPromiseWithExceptionMap(Promise promise, Exception exc) {
        promise.reject(exc, SharedUtils.a(exc));
    }

    public Activity getActivity() {
        return getCurrentActivity();
    }

    public Context getApplicationContext() {
        return getReactApplicationContext().getApplicationContext();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @NonNull
    public Map<String, Object> getConstants() {
        return new HashMap();
    }

    public ReactContext getContext() {
        return getReactApplicationContext();
    }

    public final ExecutorService getExecutor() {
        TaskExecutorService taskExecutorService = this.executorService;
        return taskExecutorService.a("", taskExecutorService.f49244b <= 1);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return b.r(new StringBuilder("RNFB"), this.moduleName, "Module");
    }

    public final ExecutorService getTransactionalExecutor() {
        return this.executorService.a("", true);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    @CallSuper
    public void initialize() {
        super.initialize();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    @CallSuper
    public void invalidate() {
        TaskExecutorService taskExecutorService = this.executorService;
        taskExecutorService.getClass();
        HashMap map = TaskExecutorService.f49242e;
        synchronized (map) {
            try {
                Iterator it = new ArrayList(map.keySet()).iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (str.startsWith(taskExecutorService.f49243a)) {
                        TaskExecutorService.c(str);
                    } else {
                        TaskExecutorService.f49242e.remove(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Deprecated
    public void onCatalystInstanceDestroy() {
        invalidate();
    }

    public final void removeEventListeningExecutor(String str) {
        String strB = this.executorService.b(str, true);
        this.executorService.getClass();
        TaskExecutorService.c(strB);
    }

    public final ExecutorService getTransactionalExecutor(String str) {
        TaskExecutorService taskExecutorService = this.executorService;
        if (taskExecutorService.f49244b == 0) {
            str = "";
        }
        return taskExecutorService.a(str, true);
    }

    public static void rejectPromiseWithCodeAndMessage(Promise promise, String str, String str2) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("code", str);
        writableMapCreateMap.putString(APayConstants.Error.MESSAGE, str2);
        promise.reject(str, str2, writableMapCreateMap);
    }

    public static void rejectPromiseWithCodeAndMessage(Promise promise, String str, String str2, String str3) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("code", str);
        writableMapCreateMap.putString(APayConstants.Error.MESSAGE, str2);
        writableMapCreateMap.putString("nativeErrorMessage", str3);
        promise.reject(str, str2, writableMapCreateMap);
    }
}

package io.invertase.firebase.analytics;

import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class ReactNativeFirebaseAnalyticsModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "Analytics";
    private final UniversalFirebaseAnalyticsModule module;

    public ReactNativeFirebaseAnalyticsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
        this.module = new UniversalFirebaseAnalyticsModule(reactApplicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getAppInstanceId$3(Promise promise, Task task) {
        if (task.p()) {
            promise.resolve(task.l());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getSessionId$4(Promise promise, Task task) {
        if (!task.p()) {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        } else {
            Long l2 = (Long) task.l();
            promise.resolve(l2 != null ? Double.valueOf(l2.doubleValue()) : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$logEvent$0(Promise promise, Task task) {
        if (task.p()) {
            promise.resolve(task.l());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$resetAnalyticsData$8(Promise promise, Task task) {
        if (task.p()) {
            promise.resolve(task.l());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setAnalyticsCollectionEnabled$1(Promise promise, Task task) {
        if (task.p()) {
            promise.resolve(task.l());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setConsent$10(Promise promise, Task task) {
        if (task.p()) {
            promise.resolve(task.l());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setDefaultEventParameters$9(Promise promise, Task task) {
        if (task.p()) {
            promise.resolve(task.l());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setSessionTimeoutDuration$2(Promise promise, Task task) {
        if (task.p()) {
            promise.resolve(task.l());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setUserId$5(Promise promise, Task task) {
        if (task.p()) {
            promise.resolve(task.l());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setUserProperties$7(Promise promise, Task task) {
        if (task.p()) {
            promise.resolve(task.l());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setUserProperty$6(Promise promise, Task task) {
        if (task.p()) {
            promise.resolve(task.l());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        }
    }

    private Bundle toBundle(ReadableMap readableMap) {
        Bundle bundle = Arguments.toBundle(readableMap);
        if (bundle == null) {
            return null;
        }
        ArrayList arrayList = (ArrayList) bundle.getSerializable("items");
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof Bundle) {
                Bundle bundle2 = (Bundle) next;
                if (bundle2.containsKey("quantity")) {
                    bundle2.putInt("quantity", (int) bundle2.getDouble("quantity"));
                }
            }
        }
        if (bundle.containsKey("extend_session")) {
            bundle.putLong("extend_session", (long) bundle.getDouble("extend_session"));
        }
        return bundle;
    }

    @ReactMethod
    public void getAppInstanceId(Promise promise) {
        FirebaseAnalytics.getInstance(this.module.f49247a).a().addOnCompleteListener(new com.sudoplz.rninappupdates.b(2, promise));
    }

    @ReactMethod
    public void getSessionId(Promise promise) {
        FirebaseAnalytics.getInstance(this.module.f49247a).b().addOnCompleteListener(new com.sudoplz.rninappupdates.b(5, promise));
    }

    @ReactMethod
    public void logEvent(final String str, @Nullable ReadableMap readableMap, Promise promise) {
        final UniversalFirebaseAnalyticsModule universalFirebaseAnalyticsModule = this.module;
        final Bundle bundle = toBundle(readableMap);
        universalFirebaseAnalyticsModule.getClass();
        Tasks.c(new Callable() { // from class: io.invertase.firebase.analytics.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                FirebaseAnalytics.getInstance(universalFirebaseAnalyticsModule.f49247a).f43527a.l(bundle, null, str, false);
                return null;
            }
        }, TaskExecutors.f39751a).addOnCompleteListener(new com.sudoplz.rninappupdates.a(3, promise));
    }

    @ReactMethod
    public void resetAnalyticsData(Promise promise) {
        UniversalFirebaseAnalyticsModule universalFirebaseAnalyticsModule = this.module;
        universalFirebaseAnalyticsModule.getClass();
        Tasks.c(new androidx.webkit.internal.c(universalFirebaseAnalyticsModule, 4), TaskExecutors.f39751a).addOnCompleteListener(new com.sudoplz.rninappupdates.b(6, promise));
    }

    @ReactMethod
    public void setAnalyticsCollectionEnabled(final Boolean bool, Promise promise) {
        final UniversalFirebaseAnalyticsModule universalFirebaseAnalyticsModule = this.module;
        universalFirebaseAnalyticsModule.getClass();
        Tasks.c(new Callable() { // from class: io.invertase.firebase.analytics.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(universalFirebaseAnalyticsModule.f49247a);
                Boolean bool2 = bool;
                bool2.getClass();
                firebaseAnalytics.f43527a.v(bool2);
                return null;
            }
        }, TaskExecutors.f39751a).addOnCompleteListener(new com.sudoplz.rninappupdates.a(2, promise));
    }

    @ReactMethod
    public void setConsent(ReadableMap readableMap, Promise promise) {
        UniversalFirebaseAnalyticsModule universalFirebaseAnalyticsModule = this.module;
        Bundle bundle = Arguments.toBundle(readableMap);
        universalFirebaseAnalyticsModule.getClass();
        Tasks.c(new a(universalFirebaseAnalyticsModule, bundle, 1), TaskExecutors.f39751a).addOnCompleteListener(new com.sudoplz.rninappupdates.b(4, promise));
    }

    @ReactMethod
    public void setDefaultEventParameters(@Nullable ReadableMap readableMap, Promise promise) {
        UniversalFirebaseAnalyticsModule universalFirebaseAnalyticsModule = this.module;
        Bundle bundle = toBundle(readableMap);
        universalFirebaseAnalyticsModule.getClass();
        Tasks.c(new a(universalFirebaseAnalyticsModule, bundle, 2), TaskExecutors.f39751a).addOnCompleteListener(new com.sudoplz.rninappupdates.b(7, promise));
    }

    @ReactMethod
    public void setSessionTimeoutDuration(double d2, Promise promise) {
        final UniversalFirebaseAnalyticsModule universalFirebaseAnalyticsModule = this.module;
        final long j2 = (long) d2;
        universalFirebaseAnalyticsModule.getClass();
        Tasks.c(new Callable() { // from class: io.invertase.firebase.analytics.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                FirebaseAnalytics.getInstance(universalFirebaseAnalyticsModule.f49247a).f43527a.y(j2);
                return null;
            }
        }, TaskExecutors.f39751a).addOnCompleteListener(new com.sudoplz.rninappupdates.b(9, promise));
    }

    @ReactMethod
    public void setUserId(String str, Promise promise) {
        UniversalFirebaseAnalyticsModule universalFirebaseAnalyticsModule = this.module;
        universalFirebaseAnalyticsModule.getClass();
        Tasks.c(new androidx.media3.datasource.b(7, universalFirebaseAnalyticsModule, str), TaskExecutors.f39751a).addOnCompleteListener(new com.sudoplz.rninappupdates.b(10, promise));
    }

    @ReactMethod
    public void setUserProperties(ReadableMap readableMap, Promise promise) {
        UniversalFirebaseAnalyticsModule universalFirebaseAnalyticsModule = this.module;
        Bundle bundle = Arguments.toBundle(readableMap);
        universalFirebaseAnalyticsModule.getClass();
        Tasks.c(new a(universalFirebaseAnalyticsModule, bundle, 0), TaskExecutors.f39751a).addOnCompleteListener(new com.sudoplz.rninappupdates.b(8, promise));
    }

    @ReactMethod
    public void setUserProperty(String str, String str2, Promise promise) {
        UniversalFirebaseAnalyticsModule universalFirebaseAnalyticsModule = this.module;
        universalFirebaseAnalyticsModule.getClass();
        Tasks.c(new androidx.work.impl.a(universalFirebaseAnalyticsModule, str, str2), TaskExecutors.f39751a).addOnCompleteListener(new com.sudoplz.rninappupdates.b(3, promise));
    }
}

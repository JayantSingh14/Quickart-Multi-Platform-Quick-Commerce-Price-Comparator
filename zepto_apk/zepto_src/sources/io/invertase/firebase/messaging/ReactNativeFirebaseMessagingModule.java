package io.invertase.firebase.messaging;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationManagerCompat;
import androidx.webkit.internal.c;
import coil3.decode.d;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.MessagingAnalytics;
import com.google.firebase.messaging.RemoteMessage;
import com.google.firebase.messaging.f;
import com.google.firebase.messaging.j;
import com.google.firebase.messaging.k;
import com.google.firebase.messaging.o;
import com.sudoplz.rninappupdates.b;
import in.juspay.airborne.ota.Constants;
import in.juspay.airborne.ota.h;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* loaded from: classes.dex */
public class ReactNativeFirebaseMessagingModule extends ReactNativeFirebaseModule implements ActivityEventListener {
    private static final String TAG = "Messaging";
    ReadableMap initialNotification;
    private HashMap<String, Boolean> initialNotificationMap;

    public ReactNativeFirebaseMessagingModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, TAG);
        this.initialNotification = null;
        this.initialNotificationMap = new HashMap<>();
        reactApplicationContext.addActivityEventListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object lambda$deleteToken$8(FirebaseMessaging firebaseMessaging) throws Exception {
        Task taskE;
        if (firebaseMessaging.f44701b != null) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            firebaseMessaging.f44706g.execute(new k(firebaseMessaging, taskCompletionSource, 0));
            taskE = taskCompletionSource.f39750a;
        } else if (firebaseMessaging.f() == null) {
            taskE = Tasks.e(null);
        } else {
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            Executors.newSingleThreadExecutor(new NamedThreadFactory("Firebase-Messaging-Network-Io")).execute(new k(firebaseMessaging, taskCompletionSource2, 1));
            taskE = taskCompletionSource2.f39750a;
        }
        Tasks.a(taskE);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$deleteToken$9(Promise promise, Task task) {
        if (task.p()) {
            promise.resolve(task.l());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String lambda$getToken$6(FirebaseMessaging firebaseMessaging) throws Exception {
        Task taskD;
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = firebaseMessaging.f44701b;
        if (firebaseInstanceIdInternal != null) {
            taskD = firebaseInstanceIdInternal.d();
        } else {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            firebaseMessaging.f44706g.execute(new f(1, firebaseMessaging, taskCompletionSource));
            taskD = taskCompletionSource.f39750a;
        }
        return (String) Tasks.a(taskD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getToken$7(Promise promise, Task task) {
        if (task.p()) {
            promise.resolve(task.l());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$hasPermission$10() throws Exception {
        return Boolean.valueOf(NotificationManagerCompat.c(getReactApplicationContext()).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$hasPermission$11(Promise promise, Task task) {
        if (task.p()) {
            promise.resolve(Integer.valueOf(((Boolean) task.l()).booleanValue() ? 1 : 0));
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$isNotificationDelegationEnabled$2() throws Exception {
        FirebaseMessaging.c().i();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$isNotificationDelegationEnabled$3(Promise promise, Task task) {
        if (task.p()) {
            promise.resolve(task.l());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object lambda$sendMessage$12(ReadableMap readableMap) throws Exception {
        FirebaseMessaging firebaseMessagingC = FirebaseMessaging.c();
        RemoteMessage remoteMessageA = ReactNativeFirebaseMessagingSerializer.a(readableMap);
        firebaseMessagingC.getClass();
        if (TextUtils.isEmpty(remoteMessageA.A())) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        Intent intent2 = new Intent();
        intent2.setPackage("com.google.example.invalidpackage");
        Context context = firebaseMessagingC.f44702c;
        intent.putExtra(Constants.APP_DIR, PendingIntent.getBroadcast(context, 0, intent2, 67108864));
        intent.setPackage("com.google.android.gms");
        remoteMessageA.N(intent);
        context.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendMessage$13(Promise promise, Task task) {
        if (task.p()) {
            promise.resolve(task.l());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$setAutoInitEnabled$0(Boolean bool) throws Exception {
        FirebaseMessaging.c().j(bool.booleanValue());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setAutoInitEnabled$1(Promise promise, Task task) {
        if (task.p()) {
            promise.resolve(Boolean.valueOf(FirebaseMessaging.c().h()));
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$setDeliveryMetricsExportToBigQuery$16(Boolean bool) throws Exception {
        FirebaseMessaging.c().k(bool.booleanValue());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$setDeliveryMetricsExportToBigQuery$17(Promise promise, Task task) {
        if (!task.p()) {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        } else {
            FirebaseMessaging.c().getClass();
            promise.resolve(Boolean.valueOf(MessagingAnalytics.a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object lambda$setNotificationDelegationEnabled$4(Boolean bool) throws Exception {
        Task taskE;
        FirebaseMessaging firebaseMessagingC = FirebaseMessaging.c();
        boolean zBooleanValue = bool.booleanValue();
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = firebaseMessagingC.f44706g;
        if (PlatformVersion.isAtLeastQ()) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            scheduledThreadPoolExecutor.execute(new o(firebaseMessagingC.f44702c, zBooleanValue, taskCompletionSource));
            taskE = taskCompletionSource.f39750a;
        } else {
            taskE = Tasks.e(null);
        }
        taskE.f(new com.google.firebase.messaging.a(0), new j(firebaseMessagingC, 0));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setNotificationDelegationEnabled$5(Promise promise, Task task) {
        if (task.p()) {
            promise.resolve(Boolean.valueOf(FirebaseMessaging.c().i()));
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$subscribeToTopic$14(Promise promise, Task task) {
        if (task.p()) {
            promise.resolve(task.l());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$unsubscribeFromTopic$15(Promise promise, Task task) {
        if (task.p()) {
            promise.resolve(task.l());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.k());
        }
    }

    private WritableMap popRemoteMessageMapFromMessagingStore(String str) {
        ReactNativeFirebaseMessagingStoreImpl reactNativeFirebaseMessagingStoreImplB = ReactNativeFirebaseMessagingStoreHelper.a().b();
        WritableMap writableMapB = reactNativeFirebaseMessagingStoreImplB.b(str);
        reactNativeFirebaseMessagingStoreImplB.a(str);
        return writableMapB;
    }

    @ReactMethod
    public void deleteToken(String str, String str2, Promise promise) {
        FirebaseMessaging firebaseMessaging = (FirebaseMessaging) FirebaseApp.e(str).b(FirebaseMessaging.class);
        Tasks.c(new c(firebaseMessaging, 5), getExecutor()).addOnCompleteListener(new b(15, promise));
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseModule, com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("isAutoInitEnabled", Boolean.valueOf(FirebaseMessaging.c().h()));
        FirebaseMessaging.c().getClass();
        map.put("isDeliveryMetricsExportToBigQueryEnabled", Boolean.valueOf(MessagingAnalytics.a()));
        map.put("isNotificationDelegationEnabled", Boolean.valueOf(FirebaseMessaging.c().i()));
        return map;
    }

    @ReactMethod
    public void getInitialNotification(Promise promise) {
        ReadableMap readableMap = this.initialNotification;
        if (readableMap != null) {
            promise.resolve(readableMap);
            this.initialNotification = null;
            return;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            Intent intent = currentActivity.getIntent();
            if (intent != null && intent.getExtras() != null) {
                String string = intent.getExtras().getString("google.message_id");
                if (string == null) {
                    string = intent.getExtras().getString("message_id");
                }
                if (string != null && this.initialNotificationMap.get(string) == null) {
                    RemoteMessage remoteMessage = (RemoteMessage) ReactNativeFirebaseMessagingReceiver.f49252a.get(string);
                    WritableMap writableMapPopRemoteMessageMapFromMessagingStore = remoteMessage == null ? popRemoteMessageMapFromMessagingStore(string) : ReactNativeFirebaseMessagingSerializer.c(remoteMessage);
                    if (writableMapPopRemoteMessageMapFromMessagingStore != null) {
                        promise.resolve(writableMapPopRemoteMessageMapFromMessagingStore);
                        this.initialNotificationMap.put(string, Boolean.TRUE);
                        return;
                    }
                }
            }
        } else {
            Log.w(TAG, "Attempt to call getInitialNotification failed. The current activity is not ready, try calling the method later in the React lifecycle.");
        }
        promise.resolve(null);
    }

    @ReactMethod
    public void getToken(String str, String str2, Promise promise) {
        FirebaseMessaging firebaseMessaging = (FirebaseMessaging) FirebaseApp.e(str).b(FirebaseMessaging.class);
        Tasks.c(new d(firebaseMessaging, 1), getExecutor()).addOnCompleteListener(new com.sudoplz.rninappupdates.a(4, promise));
    }

    @ReactMethod
    public void hasPermission(Promise promise) {
        Tasks.c(new c(this, 6), getExecutor()).addOnCompleteListener(new b(18, promise));
    }

    @ReactMethod
    public void isNotificationDelegationEnabled(Promise promise) {
        Tasks.c(new h(1), getExecutor()).addOnCompleteListener(new b(17, promise));
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
        if (intent == null || intent.getExtras() == null) {
            return;
        }
        String string = intent.getExtras().getString("google.message_id");
        if (string == null) {
            string = intent.getExtras().getString("message_id");
        }
        if (string != null) {
            HashMap map = ReactNativeFirebaseMessagingReceiver.f49252a;
            RemoteMessage remoteMessage = (RemoteMessage) map.get(string);
            WritableMap writableMapPopRemoteMessageMapFromMessagingStore = remoteMessage == null ? popRemoteMessageMapFromMessagingStore(string) : ReactNativeFirebaseMessagingSerializer.c(remoteMessage);
            if (writableMapPopRemoteMessageMapFromMessagingStore != null) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.merge(writableMapPopRemoteMessageMapFromMessagingStore);
                this.initialNotification = writableNativeMap;
                map.remove(string);
                ReactNativeFirebaseEventEmitter.f49230g.b(ReactNativeFirebaseMessagingSerializer.b(writableMapPopRemoteMessageMapFromMessagingStore));
            }
        }
    }

    @ReactMethod
    public void sendMessage(ReadableMap readableMap, Promise promise) {
        Tasks.c(new c(readableMap, 7), getExecutor()).addOnCompleteListener(new b(19, promise));
    }

    @ReactMethod
    public void setAutoInitEnabled(Boolean bool, Promise promise) {
        Tasks.c(new a(1, bool), getExecutor()).addOnCompleteListener(new b(16, promise));
    }

    @ReactMethod
    public void setDeliveryMetricsExportToBigQuery(Boolean bool, Promise promise) {
        Tasks.c(new a(2, bool), getExecutor()).addOnCompleteListener(new b(12, promise));
    }

    @ReactMethod
    public void setNotificationDelegationEnabled(Boolean bool, Promise promise) {
        Tasks.c(new a(0, bool), getExecutor()).addOnCompleteListener(new b(13, promise));
    }

    @ReactMethod
    public void subscribeToTopic(String str, Promise promise) {
        FirebaseMessaging.c().f44708i.q(new com.google.firebase.messaging.h(str, 1)).addOnCompleteListener(new b(14, promise));
    }

    @ReactMethod
    public void unsubscribeFromTopic(String str, Promise promise) {
        FirebaseMessaging.c().f44708i.q(new com.google.firebase.messaging.h(str, 0)).addOnCompleteListener(new b(20, promise));
    }
}

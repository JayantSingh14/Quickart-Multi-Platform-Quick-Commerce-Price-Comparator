package com.sudoplz.rninappupdates;

import com.facebook.react.bridge.Promise;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule;
import io.invertase.firebase.crashlytics.ReactNativeFirebaseCrashlyticsModule;
import io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements OnFailureListener, OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46711a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Promise f46712b;

    public /* synthetic */ b(int i2, Promise promise) {
        this.f46711a = i2;
        this.f46712b = promise;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        switch (this.f46711a) {
            case 2:
                ReactNativeFirebaseAnalyticsModule.lambda$getAppInstanceId$3(this.f46712b, task);
                break;
            case 3:
                ReactNativeFirebaseAnalyticsModule.lambda$setUserProperty$6(this.f46712b, task);
                break;
            case 4:
                ReactNativeFirebaseAnalyticsModule.lambda$setConsent$10(this.f46712b, task);
                break;
            case 5:
                ReactNativeFirebaseAnalyticsModule.lambda$getSessionId$4(this.f46712b, task);
                break;
            case 6:
                ReactNativeFirebaseAnalyticsModule.lambda$resetAnalyticsData$8(this.f46712b, task);
                break;
            case 7:
                ReactNativeFirebaseAnalyticsModule.lambda$setDefaultEventParameters$9(this.f46712b, task);
                break;
            case 8:
                ReactNativeFirebaseAnalyticsModule.lambda$setUserProperties$7(this.f46712b, task);
                break;
            case 9:
                ReactNativeFirebaseAnalyticsModule.lambda$setSessionTimeoutDuration$2(this.f46712b, task);
                break;
            case 10:
                ReactNativeFirebaseAnalyticsModule.lambda$setUserId$5(this.f46712b, task);
                break;
            case 11:
                ReactNativeFirebaseCrashlyticsModule.lambda$checkForUnsentReports$0(this.f46712b, task);
                break;
            case 12:
                ReactNativeFirebaseMessagingModule.lambda$setDeliveryMetricsExportToBigQuery$17(this.f46712b, task);
                break;
            case 13:
                ReactNativeFirebaseMessagingModule.lambda$setNotificationDelegationEnabled$5(this.f46712b, task);
                break;
            case 14:
                ReactNativeFirebaseMessagingModule.lambda$subscribeToTopic$14(this.f46712b, task);
                break;
            case 15:
                ReactNativeFirebaseMessagingModule.lambda$deleteToken$9(this.f46712b, task);
                break;
            case 16:
                ReactNativeFirebaseMessagingModule.lambda$setAutoInitEnabled$1(this.f46712b, task);
                break;
            case 17:
                ReactNativeFirebaseMessagingModule.lambda$isNotificationDelegationEnabled$3(this.f46712b, task);
                break;
            case 18:
                ReactNativeFirebaseMessagingModule.lambda$hasPermission$11(this.f46712b, task);
                break;
            case 19:
                ReactNativeFirebaseMessagingModule.lambda$sendMessage$13(this.f46712b, task);
                break;
            default:
                ReactNativeFirebaseMessagingModule.lambda$unsubscribeFromTopic$15(this.f46712b, task);
                break;
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception e2) {
        switch (this.f46711a) {
            case 0:
                SpReactNativeInAppUpdatesModule.lambda$startUpdate$2(this.f46712b, e2);
                break;
            default:
                Intrinsics.checkNotNullParameter(e2, "e");
                this.f46712b.reject(e2);
                break;
        }
    }
}

package com.sudoplz.rninappupdates;

import com.facebook.react.bridge.Promise;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsModule;
import io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements OnFailureListener, OnSuccessListener, OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46709a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Promise f46710b;

    public /* synthetic */ a(int i2, Promise promise) {
        this.f46709a = i2;
        this.f46710b = promise;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        switch (this.f46709a) {
            case 2:
                ReactNativeFirebaseAnalyticsModule.lambda$setAnalyticsCollectionEnabled$1(this.f46710b, task);
                break;
            case 3:
                ReactNativeFirebaseAnalyticsModule.lambda$logEvent$0(this.f46710b, task);
                break;
            default:
                ReactNativeFirebaseMessagingModule.lambda$getToken$7(this.f46710b, task);
                break;
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        SpReactNativeInAppUpdatesModule.lambda$checkNeedsUpdate$0(this.f46710b, exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        SpReactNativeInAppUpdatesModule.lambda$checkNeedsUpdate$1(this.f46710b, (AppUpdateInfo) obj);
    }
}

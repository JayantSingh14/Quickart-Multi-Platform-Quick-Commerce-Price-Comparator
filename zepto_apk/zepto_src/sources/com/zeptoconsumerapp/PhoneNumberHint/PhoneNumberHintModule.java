package com.zeptoconsumerapp.PhoneNumberHint;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import androidx.media3.exoplayer.analytics.l;
import com.brentvatne.react.a;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.common.api.ApiException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = PhoneNumberHintModule.NAME)
@Metadata
/* loaded from: classes.dex */
public final class PhoneNumberHintModule extends ReactContextBaseJavaModule implements ActivityEventListener {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String NAME = "PhoneNumberHint";
    private static final int RESOLVE_HINT_REQUEST_CODE = 10021;

    @NotNull
    private final ReactApplicationContext reactContext;

    @Nullable
    private Promise requestHintPromise;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneNumberHintModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        reactContext.addActivityEventListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestHint$lambda$0(Activity activity, PhoneNumberHintModule phoneNumberHintModule, PendingIntent pendingIntent) throws IntentSender.SendIntentException {
        try {
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), RESOLVE_HINT_REQUEST_CODE, null, 0, 0, 0);
        } catch (Exception e2) {
            Promise promise = phoneNumberHintModule.requestHintPromise;
            if (promise != null) {
                promise.reject("Launching the PendingIntent failed", e2);
            }
        }
        return Unit.f53572a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestHint$lambda$2(PhoneNumberHintModule phoneNumberHintModule, Exception e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        Promise promise = phoneNumberHintModule.requestHintPromise;
        if (promise != null) {
            promise.reject("Phone Number Hint failed", e2);
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        try {
            Promise promise = this.requestHintPromise;
            if (promise != null) {
                promise.reject("Cancelled", "Phone number hint request cancelled due to module invalidation");
            }
            this.requestHintPromise = null;
            this.reactContext.removeActivityEventListener(this);
        } catch (Exception unused) {
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(@Nullable Activity activity, int i2, int i3, @Nullable Intent intent) {
        if (i2 != RESOLVE_HINT_REQUEST_CODE) {
            return;
        }
        Promise promise = this.requestHintPromise;
        String strB = null;
        this.requestHintPromise = null;
        if (promise == null) {
            return;
        }
        if (i3 != -1) {
            if (i3 == 0) {
                promise.reject("User dismissed phone hint bottom sheet");
                return;
            }
            promise.reject("Api Exception", "Unexpected result code: " + i3);
            return;
        }
        if (activity != null) {
            try {
                strB = Identity.a(activity).b(intent);
            } catch (ApiException e2) {
                promise.reject("Api Exception", "Failed to extract phone number: " + e2.getMessage());
                return;
            }
        }
        promise.resolve(strB);
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(@Nullable Intent intent) {
    }

    @ReactMethod
    public final void requestHint(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (this.requestHintPromise != null) {
            promise.reject("Already Processing", "Currently Processing Previous Request");
            return;
        }
        this.requestHintPromise = promise;
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject("No Activity Found", "Current Activity Null.");
            return;
        }
        try {
            GetPhoneNumberHintIntentRequest.b();
            GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequestA = GetPhoneNumberHintIntentRequest.Builder.a();
            Intrinsics.checkNotNullExpressionValue(getPhoneNumberHintIntentRequestA, "build(...)");
            Identity.a(currentActivity).c(getPhoneNumberHintIntentRequestA).e(new l(new a(4, currentActivity, this), 23)).c(new l(this, 24));
        } catch (Exception e2) {
            Promise promise2 = this.requestHintPromise;
            if (promise2 != null) {
                promise2.reject(e2);
            }
        }
    }
}

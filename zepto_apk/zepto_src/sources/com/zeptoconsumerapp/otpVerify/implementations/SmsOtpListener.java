package com.zeptoconsumerapp.otpVerify.implementations;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Build;
import androidx.media3.exoplayer.analytics.l;
import com.brentvatne.react.b;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactContext;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.internal.p001authapiphone.zzak;
import com.google.android.gms.tasks.Task;
import com.zeptoconsumerapp.otpVerify.a;
import com.zeptoconsumerapp.otpVerify.constants.OtpListenerType;
import com.zeptoconsumerapp.otpVerify.interfaces.OtpListener;
import com.zeptoconsumerapp.otpVerify.utils.SmsOtpBroadcastReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class SmsOtpListener extends OtpListener {

    /* renamed from: d, reason: collision with root package name */
    public final SmsOtpBroadcastReceiver f47712d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f47713e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsOtpListener(ReactContext reactContext, OtpListenerType otpListenerType, a onSuccess, a onError) {
        super(reactContext, otpListenerType, onSuccess, onError);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(otpListenerType, "otpListenerType");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.f47712d = new SmsOtpBroadcastReceiver(onSuccess, onError);
        e();
    }

    @Override // com.zeptoconsumerapp.otpVerify.interfaces.OtpListener
    public final void b() {
        e();
    }

    @Override // com.zeptoconsumerapp.otpVerify.interfaces.OtpListener
    public final void c(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Api.ApiOptions.NoOptions noOptions = Api.ApiOptions.NO_OPTIONS;
        GoogleApi.Settings settings = GoogleApi.Settings.DEFAULT_SETTINGS;
        zzak zzakVar = new zzak(this.f47714a, SmsRetrieverClient.f22138a, noOptions, settings);
        Intrinsics.checkNotNullExpressionValue(zzakVar, "getClient(...)");
        Task taskB = zzakVar.b();
        Intrinsics.checkNotNullExpressionValue(taskB, "startSmsRetriever(...)");
        taskB.e(new l(new b(1, promise), 25));
        taskB.c(new com.sudoplz.rninappupdates.b(1, promise));
    }

    @Override // com.zeptoconsumerapp.otpVerify.interfaces.OtpListener
    public final void d() {
        Activity currentActivity = this.f47714a.getCurrentActivity();
        SmsOtpBroadcastReceiver smsOtpBroadcastReceiver = this.f47712d;
        if (!this.f47713e || currentActivity == null || smsOtpBroadcastReceiver == null) {
            return;
        }
        try {
            currentActivity.unregisterReceiver(smsOtpBroadcastReceiver);
            this.f47713e = false;
        } catch (Exception e2) {
            this.f47716c.invoke(android.support.v4.media.b.C("SMS Broadcast receiver unregister failure :: ", e2.getMessage()));
        }
    }

    public final void e() {
        SmsOtpBroadcastReceiver smsOtpBroadcastReceiver;
        Activity currentActivity = this.f47714a.getCurrentActivity();
        a aVar = this.f47716c;
        if (currentActivity == null || (smsOtpBroadcastReceiver = this.f47712d) == null) {
            aVar.invoke("Activity or receiver is null while registering receiver : " + this.f47715b.name());
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                currentActivity.registerReceiver(smsOtpBroadcastReceiver, new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED"), "com.google.android.gms.auth.api.phone.permission.SEND", null, 2);
            } else {
                currentActivity.registerReceiver(smsOtpBroadcastReceiver, new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED"));
            }
            this.f47713e = true;
        } catch (Exception e2) {
            aVar.invoke("Sms Broadcast receiver register failure: " + e2.getMessage());
        }
    }
}

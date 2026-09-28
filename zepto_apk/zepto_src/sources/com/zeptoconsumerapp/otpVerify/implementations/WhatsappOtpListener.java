package com.zeptoconsumerapp.otpVerify.implementations;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactContext;
import com.whatsapp.otp.android.sdk.WhatsAppOtpHandler;
import com.whatsapp.otp.android.sdk.enums.WhatsAppClientType;
import com.zeptoconsumerapp.otpVerify.a;
import com.zeptoconsumerapp.otpVerify.constants.OtpListenerType;
import com.zeptoconsumerapp.otpVerify.interfaces.OtpListener;
import com.zeptoconsumerapp.otpVerify.utils.WhatsAppOtpBroadcastReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class WhatsappOtpListener extends OtpListener {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WhatsappOtpListener(ReactContext reactContext, OtpListenerType otpListenerType, a onSuccess, a onError) {
        super(reactContext, otpListenerType, onSuccess, onError);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(otpListenerType, "otpListenerType");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        a aVar = WhatsAppOtpBroadcastReceiver.f47723a;
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        WhatsAppOtpBroadcastReceiver.f47723a = onSuccess;
        WhatsAppOtpBroadcastReceiver.f47724b = onError;
    }

    @Override // com.zeptoconsumerapp.otpVerify.interfaces.OtpListener
    public final void b() {
    }

    @Override // com.zeptoconsumerapp.otpVerify.interfaces.OtpListener
    public final void c(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            WhatsAppOtpHandler whatsAppOtpHandler = new WhatsAppOtpHandler();
            ReactContext reactContext = this.f47714a;
            if (reactContext == null) {
                throw new NullPointerException("Context cannot be null");
            }
            whatsAppOtpHandler.a(reactContext, WhatsAppClientType.CONSUMER);
            whatsAppOtpHandler.a(reactContext, WhatsAppClientType.BUSINESS);
            promise.resolve(Boolean.TRUE);
        } catch (Exception e2) {
            promise.reject("start otp retriever failure", e2);
        }
    }

    @Override // com.zeptoconsumerapp.otpVerify.interfaces.OtpListener
    public final void d() {
    }
}

package com.zeptoconsumerapp.otpVerify.interfaces;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactContext;
import com.zeptoconsumerapp.otpVerify.a;
import com.zeptoconsumerapp.otpVerify.constants.OtpListenerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public abstract class OtpListener {

    /* renamed from: a, reason: collision with root package name */
    public final ReactContext f47714a;

    /* renamed from: b, reason: collision with root package name */
    public final OtpListenerType f47715b;

    /* renamed from: c, reason: collision with root package name */
    public final a f47716c;

    public OtpListener(ReactContext reactContext, OtpListenerType listenerType, a onSuccess, a onError) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(listenerType, "listenerType");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.f47714a = reactContext;
        this.f47715b = listenerType;
        this.f47716c = onError;
    }

    public final OtpListenerType a() {
        return this.f47715b;
    }

    public abstract void b();

    public abstract void c(Promise promise);

    public abstract void d();
}

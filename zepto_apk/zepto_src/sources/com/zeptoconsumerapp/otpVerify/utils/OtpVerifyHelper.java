package com.zeptoconsumerapp.otpVerify.utils;

import android.support.v4.media.b;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.zeptoconsumerapp.otpVerify.constants.OtpListenerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class OtpVerifyHelper {
    public static WritableMap a(OtpDataPayload data) {
        Intrinsics.checkNotNullParameter(data, "data");
        boolean z = data.f47718a;
        WritableMap writableMapCreateMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
        writableMapCreateMap.putBoolean("isSuccess", z);
        writableMapCreateMap.putString(APayConstants.Error.MESSAGE, data.f47719b);
        writableMapCreateMap.putString("listenerType", data.f47720c.name());
        return writableMapCreateMap;
    }

    public static String b(OtpListenerType otpListenerType) {
        Intrinsics.checkNotNullParameter(otpListenerType, "otpListenerType");
        return b.C("OTP_VERIFY_EVENT::", otpListenerType.name());
    }
}

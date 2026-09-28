package com.truecaller.android.sdk.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes4.dex */
public interface VerificationCallback {
    public static final int TYPE_IM_OTP_INITIATED = 9;
    public static final int TYPE_IM_OTP_RECEIVED = 10;
    public static final int TYPE_MISSED_CALL_INITIATED = 3;
    public static final int TYPE_MISSED_CALL_RECEIVED = 4;
    public static final int TYPE_OTP_INITIATED = 1;
    public static final int TYPE_OTP_RECEIVED = 2;
    public static final int TYPE_PROFILE_VERIFIED_BEFORE = 6;
    public static final int TYPE_VERIFICATION_COMPLETE = 5;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface CallbackType {
    }

    void onRequestFailure(int i2, @NonNull TrueException trueException);

    void onRequestSuccess(int i2, @Nullable VerificationDataBundle verificationDataBundle);
}

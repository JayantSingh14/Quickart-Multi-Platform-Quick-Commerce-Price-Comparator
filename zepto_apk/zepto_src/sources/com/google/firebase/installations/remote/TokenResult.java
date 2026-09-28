package com.google.firebase.installations.remote;

import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.google.auto.value.AutoValue;
import com.google.firebase.installations.remote.AutoValue_TokenResult;

@AutoValue
/* loaded from: classes.dex */
public abstract class TokenResult {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract TokenResult a();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ResponseCode {

        /* renamed from: a, reason: collision with root package name */
        public static final ResponseCode f44651a;

        /* renamed from: b, reason: collision with root package name */
        public static final ResponseCode f44652b;

        /* renamed from: c, reason: collision with root package name */
        public static final ResponseCode f44653c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ ResponseCode[] f44654d;

        static {
            ResponseCode responseCode = new ResponseCode("OK", 0);
            f44651a = responseCode;
            ResponseCode responseCode2 = new ResponseCode("BAD_CONFIG", 1);
            f44652b = responseCode2;
            ResponseCode responseCode3 = new ResponseCode(MerchantConstants.AUTH_ERROR, 2);
            f44653c = responseCode3;
            f44654d = new ResponseCode[]{responseCode, responseCode2, responseCode3};
        }

        public static ResponseCode valueOf(String str) {
            return (ResponseCode) Enum.valueOf(ResponseCode.class, str);
        }

        public static ResponseCode[] values() {
            return (ResponseCode[]) f44654d.clone();
        }
    }

    public static Builder a() {
        AutoValue_TokenResult.Builder builder = new AutoValue_TokenResult.Builder();
        builder.f44636b = 0L;
        return builder;
    }

    public abstract ResponseCode b();

    public abstract String c();

    public abstract long d();
}

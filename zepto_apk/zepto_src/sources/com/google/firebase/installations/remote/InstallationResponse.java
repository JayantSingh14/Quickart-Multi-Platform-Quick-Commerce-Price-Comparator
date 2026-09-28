package com.google.firebase.installations.remote;

import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class InstallationResponse {

    @AutoValue.Builder
    public static abstract class Builder {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ResponseCode {

        /* renamed from: a, reason: collision with root package name */
        public static final ResponseCode f44643a;

        /* renamed from: b, reason: collision with root package name */
        public static final ResponseCode f44644b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ ResponseCode[] f44645c;

        static {
            ResponseCode responseCode = new ResponseCode("OK", 0);
            f44643a = responseCode;
            ResponseCode responseCode2 = new ResponseCode("BAD_CONFIG", 1);
            f44644b = responseCode2;
            f44645c = new ResponseCode[]{responseCode, responseCode2};
        }

        public static ResponseCode valueOf(String str) {
            return (ResponseCode) Enum.valueOf(ResponseCode.class, str);
        }

        public static ResponseCode[] values() {
            return (ResponseCode[]) f44645c.clone();
        }
    }

    public abstract TokenResult a();

    public abstract String b();

    public abstract String c();

    public abstract ResponseCode d();

    public abstract String e();
}

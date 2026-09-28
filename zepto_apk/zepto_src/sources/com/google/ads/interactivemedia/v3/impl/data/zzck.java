package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.zzoo;

@zzoo(zza = zzam.class)
/* loaded from: classes3.dex */
public abstract class zzck {
    public static final String UNKNOWN_CONTENT_TYPE = "unknown";

    private static zzck create(String str, String str2, String str3, int i2) {
        return new zzam(str, str2, str3, i2);
    }

    public static zzck forError(String str, int i2) {
        return create(str, "", UNKNOWN_CONTENT_TYPE, i2);
    }

    public static zzck forResponse(String str, String str2) {
        return forResponse(str, str2, UNKNOWN_CONTENT_TYPE);
    }

    public abstract String content();

    public abstract String contentType();

    public abstract int errorCode();

    public abstract String id();

    public static zzck forResponse(String str, String str2, String str3) {
        return create(str, str2, str3, 0);
    }
}

package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public class zzat extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f24290a;

    /* renamed from: b, reason: collision with root package name */
    public final int f24291b;

    public zzat(String str, RuntimeException runtimeException, boolean z, int i2) {
        super(str, runtimeException);
        this.f24290a = z;
        this.f24291b = i2;
    }

    public static zzat a(RuntimeException runtimeException, String str) {
        return new zzat(str, runtimeException, true, 1);
    }

    public static zzat b(String str) {
        return new zzat(str, null, false, 1);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        String strConcat = message != null ? message.concat(StringUtils.SPACE) : "";
        int length = strConcat.length();
        boolean z = this.f24290a;
        int length2 = String.valueOf(z).length() + length + 20;
        int i2 = this.f24291b;
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + length2 + 11 + 1);
        sb.append(strConcat);
        sb.append("{contentIsMalformed=");
        sb.append(z);
        sb.append(", dataType=");
        return android.support.v4.media.b.o(sb, i2, "}");
    }
}

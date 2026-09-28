package com.google.android.gms.internal.auth;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes4.dex */
public final class zzfa {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f36355a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f36356b;

    static {
        Charset.forName("US-ASCII");
        f36355a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f36356b = bArr;
        ByteBuffer.wrap(bArr);
        zzeh zzehVar = new zzeh();
        try {
            int i2 = zzehVar.f36338a;
            if (i2 > 0) {
                zzehVar.f36338a = i2;
            } else {
                zzehVar.f36338a = 0;
            }
        } catch (zzfb e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}

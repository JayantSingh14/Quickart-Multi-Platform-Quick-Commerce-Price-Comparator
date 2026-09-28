package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class zzmo {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f37112a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f37113b;

    static {
        Charset.forName("US-ASCII");
        f37112a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f37113b = bArr;
        ByteBuffer.wrap(bArr);
        zzlh zzlhVar = new zzlh();
        try {
            int i2 = zzlhVar.f37075a;
            if (i2 > 0) {
                zzlhVar.f37075a = i2;
            } else {
                zzlhVar.f37075a = 0;
            }
        } catch (zzmq e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}

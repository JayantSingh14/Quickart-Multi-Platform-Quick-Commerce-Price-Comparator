package com.google.android.gms.internal.atv_ads_framework;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes4.dex */
public final class zzdp {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f36125a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f36126b;

    static {
        Charset.forName("US-ASCII");
        f36125a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f36126b = bArr;
        ByteBuffer.wrap(bArr);
        zzcp zzcpVar = new zzcp();
        try {
            int i2 = zzcpVar.f36097a;
            if (i2 > 0) {
                zzcpVar.f36097a = i2;
            } else {
                zzcpVar.f36097a = 0;
            }
        } catch (zzdr e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}

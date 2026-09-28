package com.google.android.gms.internal.pal;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes4.dex */
public final class zzadg {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f37410a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f37411b;

    static {
        Charset.forName("US-ASCII");
        f37410a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f37411b = bArr;
        ByteBuffer.wrap(bArr);
        try {
            new zzaca(bArr, 0).b(0);
        } catch (zzadi e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int a(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static zzaef b(Object obj, Object obj2) {
        zzacv zzacvVarE = ((zzaef) obj).e();
        zzaef zzaefVar = (zzaef) obj2;
        if (!zzacvVarE.f37404a.getClass().isInstance(zzaefVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        zzacvVarE.getClass();
        zzacvVarE.d((zzacz) ((zzabi) zzaefVar));
        return zzacvVarE.j();
    }
}

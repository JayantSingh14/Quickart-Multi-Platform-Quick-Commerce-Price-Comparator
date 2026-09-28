package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes4.dex */
public final class zzgzw implements zzhaj {

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f33405b = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final ByteArrayInputStream f33406a;

    public zzgzw(ByteArrayInputStream byteArrayInputStream) {
        this.f33406a = byteArrayInputStream;
    }

    public static int b(zzhxj zzhxjVar) throws NumberFormatException, IOException {
        if (!(zzhxjVar instanceof zzhxn)) {
            throw new IOException("invalid key id: not a JSON primitive");
        }
        if (!(zzhxjVar.f().f34471a instanceof Number)) {
            throw new IOException("invalid key id: not a JSON number");
        }
        Number numberG = zzhxjVar.f().g();
        try {
            if (!(numberG instanceof zzhhx)) {
                throw new IllegalArgumentException("does not contain a parsed number.");
            }
            long j2 = Long.parseLong(((zzhhx) numberG).f33840a);
            if (j2 > 4294967295L || j2 < -2147483648L) {
                throw new IOException("invalid key id");
            }
            return (int) j2;
        } catch (NumberFormatException e2) {
            throw new IOException(e2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:121:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzhpj a() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 748
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgzw.a():com.google.android.gms.internal.ads.zzhpj");
    }
}

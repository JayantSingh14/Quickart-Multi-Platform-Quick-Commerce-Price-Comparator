package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class zzgzr implements zzhaj {

    /* renamed from: a, reason: collision with root package name */
    public final ByteArrayInputStream f33404a;

    public zzgzr(ByteArrayInputStream byteArrayInputStream) {
        this.f33404a = byteArrayInputStream;
    }

    public final zzhpj a() throws IOException {
        ByteArrayInputStream byteArrayInputStream = this.f33404a;
        try {
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            return zzhpj.H(byteArrayInputStream, zziab.f34621c);
        } finally {
            byteArrayInputStream.close();
        }
    }
}

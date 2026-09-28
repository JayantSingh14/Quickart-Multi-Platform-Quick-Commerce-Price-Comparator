package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: classes4.dex */
public final class zzhks {

    /* renamed from: a, reason: collision with root package name */
    public Integer f33947a = null;

    /* renamed from: b, reason: collision with root package name */
    public Integer f33948b = null;

    /* renamed from: c, reason: collision with root package name */
    public zzhkt f33949c = zzhkt.f33953e;

    public final void a(int i2) throws InvalidAlgorithmParameterException {
        if (i2 != 16 && i2 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i2 * 8)));
        }
        this.f33947a = Integer.valueOf(i2);
    }

    public final void b(int i2) throws GeneralSecurityException {
        if (i2 < 10 || i2 > 16) {
            throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i2).length() + 40), i2, "Invalid tag size for AesCmacParameters: "));
        }
        this.f33948b = Integer.valueOf(i2);
    }

    public final zzhku c() throws GeneralSecurityException {
        Integer num = this.f33947a;
        if (num == null) {
            throw new GeneralSecurityException("key size not set");
        }
        if (this.f33948b != null) {
            return new zzhku(num.intValue(), this.f33948b.intValue(), this.f33949c);
        }
        throw new GeneralSecurityException("tag size not set");
    }
}

package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: classes4.dex */
public final class zzhci {

    /* renamed from: a, reason: collision with root package name */
    public Integer f33528a = null;

    /* renamed from: b, reason: collision with root package name */
    public Integer f33529b = null;

    /* renamed from: c, reason: collision with root package name */
    public Integer f33530c = null;

    /* renamed from: d, reason: collision with root package name */
    public zzhcj f33531d = zzhcj.f33534d;

    public final void a(int i2) throws InvalidAlgorithmParameterException {
        if (i2 != 16 && i2 != 24 && i2 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i2)));
        }
        this.f33528a = Integer.valueOf(i2);
    }

    public final void b() {
        this.f33529b = 12;
    }

    public final void c() {
        this.f33530c = 16;
    }

    public final zzhck d() throws GeneralSecurityException {
        Integer num = this.f33528a;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (this.f33529b == null) {
            throw new GeneralSecurityException("IV size is not set");
        }
        if (this.f33530c == null) {
            throw new GeneralSecurityException("Tag size is not set");
        }
        int iIntValue = num.intValue();
        this.f33529b.getClass();
        this.f33530c.getClass();
        return new zzhck(iIntValue, this.f33531d);
    }
}

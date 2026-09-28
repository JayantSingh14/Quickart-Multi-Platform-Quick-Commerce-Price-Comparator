package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: classes4.dex */
public final class zzhbz {

    /* renamed from: a, reason: collision with root package name */
    public Integer f33501a = null;

    /* renamed from: b, reason: collision with root package name */
    public Integer f33502b = null;

    /* renamed from: c, reason: collision with root package name */
    public Integer f33503c = null;

    /* renamed from: d, reason: collision with root package name */
    public zzhca f33504d = zzhca.f33508d;

    public final void a(int i2) throws InvalidAlgorithmParameterException {
        if (i2 != 16 && i2 != 24 && i2 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i2)));
        }
        this.f33501a = Integer.valueOf(i2);
    }

    public final void b(int i2) throws GeneralSecurityException {
        if (i2 != 12 && i2 != 16) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", Integer.valueOf(i2)));
        }
        this.f33502b = Integer.valueOf(i2);
    }

    public final void c() {
        this.f33503c = 16;
    }

    public final zzhcb d() throws GeneralSecurityException {
        Integer num = this.f33501a;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (this.f33502b == null) {
            throw new GeneralSecurityException("IV size is not set");
        }
        if (this.f33503c == null) {
            throw new GeneralSecurityException("Tag size is not set");
        }
        int iIntValue = num.intValue();
        int iIntValue2 = this.f33502b.intValue();
        this.f33503c.getClass();
        return new zzhcb(iIntValue, iIntValue2, this.f33504d);
    }
}

package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: classes4.dex */
public final class zzhbq {

    /* renamed from: a, reason: collision with root package name */
    public Integer f33467a = null;

    /* renamed from: b, reason: collision with root package name */
    public Integer f33468b = null;

    /* renamed from: c, reason: collision with root package name */
    public Integer f33469c = null;

    /* renamed from: d, reason: collision with root package name */
    public Integer f33470d = null;

    /* renamed from: e, reason: collision with root package name */
    public zzhbr f33471e = null;

    /* renamed from: f, reason: collision with root package name */
    public zzhbs f33472f = zzhbs.f33481d;

    public final void a(int i2) throws InvalidAlgorithmParameterException {
        if (i2 != 16 && i2 != 24 && i2 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i2)));
        }
        this.f33467a = Integer.valueOf(i2);
    }

    public final void b(int i2) throws InvalidAlgorithmParameterException {
        if (i2 < 16) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; HMAC key must be at least 16 bytes", Integer.valueOf(i2)));
        }
        this.f33468b = Integer.valueOf(i2);
    }

    public final void c(int i2) throws GeneralSecurityException {
        if (i2 < 12 || i2 > 16) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; IV size must be between 12 and 16 bytes", Integer.valueOf(i2)));
        }
        this.f33469c = Integer.valueOf(i2);
    }

    public final void d(int i2) throws GeneralSecurityException {
        if (i2 < 10) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", Integer.valueOf(i2)));
        }
        this.f33470d = Integer.valueOf(i2);
    }

    public final zzhbt e() throws GeneralSecurityException {
        if (this.f33467a == null) {
            throw new GeneralSecurityException("AES key size is not set");
        }
        if (this.f33468b == null) {
            throw new GeneralSecurityException("HMAC key size is not set");
        }
        if (this.f33469c == null) {
            throw new GeneralSecurityException("iv size is not set");
        }
        Integer num = this.f33470d;
        if (num == null) {
            throw new GeneralSecurityException("tag size is not set");
        }
        if (this.f33471e == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        int iIntValue = num.intValue();
        zzhbr zzhbrVar = this.f33471e;
        if (zzhbrVar == zzhbr.f33473b) {
            if (iIntValue > 20) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num));
            }
        } else if (zzhbrVar == zzhbr.f33474c) {
            if (iIntValue > 28) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num));
            }
        } else if (zzhbrVar == zzhbr.f33475d) {
            if (iIntValue > 32) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num));
            }
        } else if (zzhbrVar == zzhbr.f33476e) {
            if (iIntValue > 48) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num));
            }
        } else {
            if (zzhbrVar != zzhbr.f33477f) {
                throw new GeneralSecurityException("unknown hash type; must be SHA1, SHA224, SHA256, SHA384 or SHA512");
            }
            if (iIntValue > 64) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num));
            }
        }
        return new zzhbt(this.f33467a.intValue(), this.f33468b.intValue(), this.f33469c.intValue(), this.f33470d.intValue(), this.f33472f, this.f33471e);
    }
}

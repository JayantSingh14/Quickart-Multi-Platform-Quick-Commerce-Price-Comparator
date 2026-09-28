package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: classes4.dex */
public final class zzhlf {

    /* renamed from: a, reason: collision with root package name */
    public Integer f33977a = null;

    /* renamed from: b, reason: collision with root package name */
    public Integer f33978b = null;

    /* renamed from: c, reason: collision with root package name */
    public zzhlg f33979c = null;

    /* renamed from: d, reason: collision with root package name */
    public zzhlh f33980d = zzhlh.f33990e;

    public final void a(int i2) {
        this.f33977a = Integer.valueOf(i2);
    }

    public final void b(int i2) {
        this.f33978b = Integer.valueOf(i2);
    }

    public final zzhli c() throws GeneralSecurityException {
        Integer num = this.f33977a;
        if (num == null) {
            throw new GeneralSecurityException("key size is not set");
        }
        if (this.f33978b == null) {
            throw new GeneralSecurityException("tag size is not set");
        }
        if (this.f33979c == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        if (num.intValue() < 16) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", this.f33977a));
        }
        Integer num2 = this.f33978b;
        int iIntValue = num2.intValue();
        zzhlg zzhlgVar = this.f33979c;
        if (iIntValue < 10) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", num2));
        }
        if (zzhlgVar == zzhlg.f33981b) {
            if (iIntValue > 20) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num2));
            }
        } else if (zzhlgVar == zzhlg.f33982c) {
            if (iIntValue > 28) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num2));
            }
        } else if (zzhlgVar == zzhlg.f33983d) {
            if (iIntValue > 32) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num2));
            }
        } else if (zzhlgVar == zzhlg.f33984e) {
            if (iIntValue > 48) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num2));
            }
        } else {
            if (zzhlgVar != zzhlg.f33985f) {
                throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
            }
            if (iIntValue > 64) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num2));
            }
        }
        return new zzhli(this.f33977a.intValue(), this.f33978b.intValue(), this.f33980d, this.f33979c);
    }
}

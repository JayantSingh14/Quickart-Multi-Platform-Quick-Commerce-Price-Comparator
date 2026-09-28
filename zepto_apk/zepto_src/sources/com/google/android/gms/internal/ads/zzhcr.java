package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: classes4.dex */
public final class zzhcr {

    /* renamed from: a, reason: collision with root package name */
    public Integer f33552a = null;

    /* renamed from: b, reason: collision with root package name */
    public zzhcs f33553b = zzhcs.f33556d;

    public final void a(int i2) throws InvalidAlgorithmParameterException {
        if (i2 != 16 && i2 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(i2)));
        }
        this.f33552a = Integer.valueOf(i2);
    }

    public final zzhct b() throws GeneralSecurityException {
        Integer num = this.f33552a;
        if (num != null) {
            return new zzhct(num.intValue(), this.f33553b);
        }
        throw new GeneralSecurityException("Key size is not set");
    }
}

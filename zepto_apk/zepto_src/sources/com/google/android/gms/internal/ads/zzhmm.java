package com.google.android.gms.internal.ads;

import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzhmm extends zzhmp {

    /* renamed from: a, reason: collision with root package name */
    public final int f34036a;

    public zzhmm(int i2) {
        this.f34036a = i2;
    }

    public static zzhmm b(int i2) throws InvalidAlgorithmParameterException {
        if (i2 == 16 || i2 == 32) {
            return new zzhmm(i2);
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit are supported", Integer.valueOf(i2 * 8)));
    }

    @Override // com.google.android.gms.internal.ads.zzhan
    public final boolean a() {
        return false;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzhmm) && ((zzhmm) obj).f34036a == this.f34036a;
    }

    public final int hashCode() {
        return Objects.hash(zzhmm.class, Integer.valueOf(this.f34036a));
    }

    public final String toString() {
        int i2 = this.f34036a;
        return androidx.fragment.app.e.u(new StringBuilder(String.valueOf(i2).length() + 34), "AesCmac PRF Parameters (", i2, "-byte key)");
    }
}

package com.google.android.gms.internal.pal;

import java.math.BigDecimal;

/* loaded from: classes4.dex */
public final class zzzj extends Number {

    /* renamed from: a, reason: collision with root package name */
    public final String f38169a;

    public zzzj(String str) {
        this.f38169a = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f38169a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzzj)) {
            return false;
        }
        Object obj2 = ((zzzj) obj).f38169a;
        String str = this.f38169a;
        return str == obj2 || str.equals(obj2);
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f38169a);
    }

    public final int hashCode() {
        return this.f38169a.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        String str = this.f38169a;
        try {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(str);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(str).intValue();
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        String str = this.f38169a;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return new BigDecimal(str).longValue();
        }
    }

    public final String toString() {
        return this.f38169a;
    }
}

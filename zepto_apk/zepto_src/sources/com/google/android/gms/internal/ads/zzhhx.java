package com.google.android.gms.internal.ads;

import java.math.BigDecimal;

/* loaded from: classes4.dex */
final class zzhhx extends Number {

    /* renamed from: a, reason: collision with root package name */
    public final String f33840a;

    public zzhhx(String str) {
        this.f33840a = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f33840a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzhhx) {
            return this.f33840a.equals(((zzhhx) obj).f33840a);
        }
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f33840a);
    }

    public final int hashCode() {
        return this.f33840a.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        String str = this.f33840a;
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
        String str = this.f33840a;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return new BigDecimal(str).longValue();
        }
    }

    public final String toString() {
        return this.f33840a;
    }
}

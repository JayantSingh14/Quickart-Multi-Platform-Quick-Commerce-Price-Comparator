package com.google.gson.internal;

/* loaded from: classes.dex */
public final class LazilyParsedNumber extends Number {

    /* renamed from: a, reason: collision with root package name */
    public final String f45307a;

    public LazilyParsedNumber(String str) {
        this.f45307a = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f45307a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LazilyParsedNumber) {
            return this.f45307a.equals(((LazilyParsedNumber) obj).f45307a);
        }
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f45307a);
    }

    public final int hashCode() {
        return this.f45307a.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        String str = this.f45307a;
        try {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(str);
            }
        } catch (NumberFormatException unused2) {
            return NumberLimits.b(str).intValue();
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        String str = this.f45307a;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return NumberLimits.b(str).longValue();
        }
    }

    public final String toString() {
        return this.f45307a;
    }
}

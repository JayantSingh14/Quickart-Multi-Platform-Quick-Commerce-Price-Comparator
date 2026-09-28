package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhxs extends Number {

    /* renamed from: a, reason: collision with root package name */
    public final String f34476a;

    public zzhxs(String str) {
        this.f34476a = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f34476a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzhxs) {
            return this.f34476a.equals(((zzhxs) obj).f34476a);
        }
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f34476a);
    }

    public final int hashCode() {
        return this.f34476a.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        String str = this.f34476a;
        try {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(str);
            }
        } catch (NumberFormatException unused2) {
            return zzhyb.a(str).intValue();
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        String str = this.f34476a;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return zzhyb.a(str).longValue();
        }
    }

    public final String toString() {
        return this.f34476a;
    }
}

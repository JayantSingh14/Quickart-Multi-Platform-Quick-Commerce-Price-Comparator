package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzhyc implements CharSequence {

    /* renamed from: a, reason: collision with root package name */
    public char[] f34504a;

    /* renamed from: b, reason: collision with root package name */
    public String f34505b;

    @Override // java.lang.CharSequence
    public final char charAt(int i2) {
        return this.f34504a[i2];
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f34504a.length;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i2, int i3) {
        return new String(this.f34504a, i2, i3 - i2);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        if (this.f34505b == null) {
            this.f34505b = new String(this.f34504a);
        }
        return this.f34505b;
    }
}

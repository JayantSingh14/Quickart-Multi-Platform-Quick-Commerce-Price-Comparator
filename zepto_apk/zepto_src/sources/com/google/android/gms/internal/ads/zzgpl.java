package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzgpl extends zzgpk {

    /* renamed from: a, reason: collision with root package name */
    public final char f33054a;

    public zzgpl(char c2) {
        this.f33054a = c2;
    }

    @Override // com.google.android.gms.internal.ads.zzgpo
    public final boolean a(char c2) {
        return c2 == this.f33054a;
    }

    public final String toString() {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        int i2 = this.f33054a;
        for (int i3 = 0; i3 < 4; i3++) {
            cArr[5 - i3] = "0123456789ABCDEF".charAt(i2 & 15);
            i2 >>= 4;
        }
        String strCopyValueOf = String.copyValueOf(cArr);
        return android.support.v4.media.b.s(new StringBuilder(String.valueOf(strCopyValueOf).length() + 18), "CharMatcher.is('", strCopyValueOf, "')");
    }
}

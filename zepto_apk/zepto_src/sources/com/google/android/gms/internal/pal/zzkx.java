package com.google.android.gms.internal.pal;

import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzkx implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f37905a;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzkx zzkxVar = (zzkx) obj;
        byte[] bArr = this.f37905a;
        int length = bArr.length;
        int length2 = zzkxVar.f37905a.length;
        if (length != length2) {
            return length - length2;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            byte b3 = zzkxVar.f37905a[i2];
            if (b2 != b3) {
                return b2 - b3;
            }
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzkx) {
            return Arrays.equals(this.f37905a, ((zzkx) obj).f37905a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f37905a);
    }

    public final String toString() {
        return zzyj.a(this.f37905a);
    }
}

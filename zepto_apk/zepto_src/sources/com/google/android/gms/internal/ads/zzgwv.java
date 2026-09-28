package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* loaded from: classes4.dex */
public final class zzgwv implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final zzgwv f33297c = new zzgwv(new int[0], 0);

    /* renamed from: a, reason: collision with root package name */
    public final int[] f33298a;

    /* renamed from: b, reason: collision with root package name */
    public final int f33299b;

    public zzgwv(int[] iArr, int i2) {
        this.f33298a = iArr;
        this.f33299b = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgwv) {
            zzgwv zzgwvVar = (zzgwv) obj;
            int i2 = zzgwvVar.f33299b;
            int i3 = this.f33299b;
            if (i3 == i2) {
                for (int i4 = 0; i4 < i3; i4++) {
                    zzgqa.i(i4, i3);
                    int i5 = this.f33298a[i4];
                    zzgqa.i(i4, zzgwvVar.f33299b);
                    if (i5 == zzgwvVar.f33298a[i4]) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 1;
        for (int i2 = 0; i2 < this.f33299b; i2++) {
            iHashCode = (iHashCode * 31) + Integer.hashCode(this.f33298a[i2]);
        }
        return iHashCode;
    }

    public final String toString() {
        int i2 = this.f33299b;
        if (i2 == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(i2 * 5);
        sb.append('[');
        int[] iArr = this.f33298a;
        sb.append(iArr[0]);
        for (int i3 = 1; i3 < i2; i3++) {
            sb.append(", ");
            sb.append(iArr[i3]);
        }
        sb.append(']');
        return sb.toString();
    }
}

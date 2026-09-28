package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzakz implements zzafv {

    /* renamed from: a, reason: collision with root package name */
    public final int f23449a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgwv f23450b;

    public zzakz(int i2, int[] iArr) {
        zzgwv zzgwvVar;
        this.f23449a = i2;
        if (iArr != null) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            zzgwvVar = new zzgwv(iArrCopyOf, iArrCopyOf.length);
        } else {
            zzgwvVar = zzgwv.f33297c;
        }
        this.f23450b = zzgwvVar;
    }

    public final String toString() {
        zzgwv zzgwvVar = this.f23450b;
        ArrayList arrayList = new ArrayList(zzgwvVar.f33299b);
        int i2 = 0;
        while (true) {
            int i3 = zzgwvVar.f33299b;
            if (i2 >= i3) {
                String strX = zzfj.x(this.f23449a);
                String string = arrayList.toString();
                StringBuilder sb = new StringBuilder(androidx.fragment.app.e.C(strX.length() + 37, 1, string));
                sb.append("UnsupportedBrands{major=");
                sb.append(strX);
                sb.append(", compatible=");
                sb.append(string);
                sb.append("}");
                return sb.toString();
            }
            zzgqa.i(i2, i3);
            arrayList.add(zzfj.x(zzgwvVar.f33298a[i2]));
            i2++;
        }
    }
}

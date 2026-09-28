package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Random;

/* loaded from: classes4.dex */
public final class zzxz {

    /* renamed from: a, reason: collision with root package name */
    public final Random f35884a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f35885b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f35886c;

    public zzxz() {
        this(new Random());
    }

    public final zzxz a(int i2) {
        Random random;
        int[] iArr;
        int[] iArr2 = new int[i2];
        int[] iArr3 = new int[i2];
        int i3 = 0;
        while (true) {
            random = this.f35884a;
            iArr = this.f35885b;
            if (i3 >= i2) {
                break;
            }
            iArr2[i3] = random.nextInt(iArr.length + 1);
            int i4 = i3 + 1;
            int iNextInt = random.nextInt(i4);
            iArr3[i3] = iArr3[iNextInt];
            iArr3[iNextInt] = i3;
            i3 = i4;
        }
        Arrays.sort(iArr2);
        int[] iArr4 = new int[iArr.length + i2];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < iArr.length + i2; i7++) {
            if (i5 >= i2 || i6 != iArr2[i5]) {
                int i8 = i6 + 1;
                int i9 = iArr[i6];
                iArr4[i7] = i9;
                if (i9 >= 0) {
                    iArr4[i7] = i9 + i2;
                }
                i6 = i8;
            } else {
                iArr4[i7] = iArr3[i5];
                i5++;
            }
        }
        return new zzxz(iArr4, new Random(random.nextLong()));
    }

    public zzxz(Random random) {
        this(new int[0], random);
    }

    public zzxz(int[] iArr, Random random) {
        this.f35885b = iArr;
        this.f35884a = random;
        this.f35886c = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.f35886c[iArr[i2]] = i2;
        }
    }
}

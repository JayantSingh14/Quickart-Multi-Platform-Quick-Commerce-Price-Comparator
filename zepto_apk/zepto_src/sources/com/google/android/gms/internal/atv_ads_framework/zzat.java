package com.google.android.gms.internal.atv_ads_framework;

import android.os.Build;

/* loaded from: classes4.dex */
abstract class zzat extends zzae {

    /* renamed from: c, reason: collision with root package name */
    public int f36035c;

    /* renamed from: d, reason: collision with root package name */
    public int f36036d;

    @Override // com.google.android.gms.internal.atv_ads_framework.zzae
    public final String a() {
        int iB;
        int i2 = this.f36035c;
        while (true) {
            int i3 = this.f36035c;
            if (i3 == -1) {
                this.f36033b = 3;
                return null;
            }
            int iC = c(i3);
            String str = Build.FINGERPRINT;
            if (iC == -1) {
                iC = str.length();
                this.f36035c = -1;
                iB = -1;
            } else {
                iB = b(iC);
                this.f36035c = iB;
            }
            if (iB != i2) {
                if (i2 < iC) {
                    str.charAt(i2);
                }
                if (i2 < iC) {
                    str.charAt(iC - 1);
                }
                int i4 = this.f36036d;
                if (i4 == 1) {
                    iC = str.length();
                    this.f36035c = -1;
                    if (iC > i2) {
                        str.charAt(iC - 1);
                    }
                } else {
                    this.f36036d = i4 - 1;
                }
                return str.subSequence(i2, iC).toString();
            }
            int i5 = iB + 1;
            this.f36035c = i5;
            if (i5 > str.length()) {
                this.f36035c = -1;
            }
        }
    }

    public abstract int b(int i2);

    public abstract int c(int i2);
}

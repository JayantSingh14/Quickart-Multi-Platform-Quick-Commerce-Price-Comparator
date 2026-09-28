package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;

/* loaded from: classes4.dex */
abstract class zzgqn extends zzgpi {

    /* renamed from: c, reason: collision with root package name */
    public final CharSequence f33078c;

    /* renamed from: d, reason: collision with root package name */
    public int f33079d;

    /* renamed from: e, reason: collision with root package name */
    public int f33080e;

    public zzgqn(CharSequence charSequence) {
        this.f33053b = 2;
        this.f33079d = 0;
        this.f33080e = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f33078c = charSequence;
    }

    @Override // com.google.android.gms.internal.ads.zzgpi
    public final String a() {
        int iC;
        int i2 = this.f33079d;
        while (true) {
            int i3 = this.f33079d;
            if (i3 == -1) {
                this.f33053b = 3;
                return null;
            }
            int iB = b(i3);
            CharSequence charSequence = this.f33078c;
            if (iB == -1) {
                iB = charSequence.length();
                this.f33079d = -1;
                iC = -1;
            } else {
                iC = c(iB);
                this.f33079d = iC;
            }
            if (iC != i2) {
                if (i2 < iB) {
                    charSequence.charAt(i2);
                }
                if (i2 < iB) {
                    charSequence.charAt(iB - 1);
                }
                int i4 = this.f33080e;
                if (i4 == 1) {
                    iB = charSequence.length();
                    this.f33079d = -1;
                    if (iB > i2) {
                        charSequence.charAt(iB - 1);
                    }
                } else {
                    this.f33080e = i4 - 1;
                }
                return charSequence.subSequence(i2, iB).toString();
            }
            int i5 = iC + 1;
            this.f33079d = i5;
            if (i5 > charSequence.length()) {
                this.f33079d = -1;
            }
        }
    }

    public abstract int b(int i2);

    public abstract int c(int i2);
}

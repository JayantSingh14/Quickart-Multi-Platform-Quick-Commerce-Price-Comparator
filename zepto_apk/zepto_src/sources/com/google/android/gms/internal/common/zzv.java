package com.google.android.gms.internal.common;

import com.google.android.gms.common.api.Api;

/* loaded from: classes4.dex */
abstract class zzv extends zzk {

    /* renamed from: c, reason: collision with root package name */
    public final String f36504c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f36505d;

    /* renamed from: e, reason: collision with root package name */
    public int f36506e;

    /* renamed from: f, reason: collision with root package name */
    public int f36507f;

    public zzv(zzw zzwVar, String str) {
        this.f36497b = 2;
        this.f36506e = 0;
        zzwVar.getClass();
        this.f36505d = zzwVar.f36508a;
        this.f36507f = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f36504c = str;
    }

    @Override // com.google.android.gms.internal.common.zzk
    public final String a() {
        int iB;
        String str;
        int iC;
        int i2 = this.f36506e;
        while (true) {
            int i3 = this.f36506e;
            if (i3 == -1) {
                this.f36497b = 3;
                return null;
            }
            iB = b(i3);
            str = this.f36504c;
            if (iB == -1) {
                iB = str.length();
                this.f36506e = -1;
                iC = -1;
            } else {
                iC = c(iB);
                this.f36506e = iC;
            }
            if (iC == i2) {
                int i4 = iC + 1;
                this.f36506e = i4;
                if (i4 > str.length()) {
                    this.f36506e = -1;
                }
            } else {
                if (i2 < iB) {
                    str.charAt(i2);
                }
                if (i2 < iB) {
                    str.charAt(iB - 1);
                }
                if (!this.f36505d || i2 != iB) {
                    break;
                }
                i2 = this.f36506e;
            }
        }
        int i5 = this.f36507f;
        if (i5 == 1) {
            iB = str.length();
            this.f36506e = -1;
            if (iB > i2) {
                str.charAt(iB - 1);
            }
        } else {
            this.f36507f = i5 - 1;
        }
        return str.subSequence(i2, iB).toString();
    }

    public abstract int b(int i2);

    public abstract int c(int i2);
}

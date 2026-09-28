package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes4.dex */
final class zzar {

    /* renamed from: a, reason: collision with root package name */
    public final int f24193a;

    public zzar(int i2) {
        this.f24193a = i2;
    }

    public final int a() {
        int i2 = this.f24193a;
        if (i2 == 2) {
            return 10;
        }
        if (i2 == 5) {
            return 11;
        }
        if (i2 == 29) {
            return 12;
        }
        if (i2 == 42) {
            return 16;
        }
        if (i2 != 22) {
            return i2 != 23 ? 0 : 15;
        }
        return 1073741824;
    }
}

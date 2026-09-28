package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzidq extends IllegalArgumentException {
    public zzidq(int i2, int i3) {
        super(androidx.fragment.app.e.n(i2, i3, "Unpaired surrogate at index ", " of ", new StringBuilder(String.valueOf(i2).length() + 32 + String.valueOf(i3).length())));
    }
}

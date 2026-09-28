package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public interface zzmk {
    static boolean a(int i2, boolean z) {
        int i3 = i2 & 7;
        if (i3 != 4) {
            return z && i3 == 3;
        }
        return true;
    }

    int b(zzv zzvVar);

    int c();

    String d();

    default void j() {
    }

    default void q(zzmj zzmjVar) {
    }

    int zza();
}

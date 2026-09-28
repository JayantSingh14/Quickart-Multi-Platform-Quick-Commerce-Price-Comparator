package com.google.android.gms.internal.pal;

import sun.misc.Unsafe;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class b {
    public static /* synthetic */ boolean a(Unsafe unsafe, zzjn zzjnVar, long j2, Object obj, Object obj2) {
        while (!unsafe.compareAndSwapObject(zzjnVar, j2, obj, obj2)) {
            if (unsafe.getObject(zzjnVar, j2) != obj) {
                return false;
            }
        }
        return true;
    }
}

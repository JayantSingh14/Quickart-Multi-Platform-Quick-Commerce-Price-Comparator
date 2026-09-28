package com.google.android.gms.internal.pal;

import sun.misc.Unsafe;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzjp {
    public static /* synthetic */ boolean a(Unsafe unsafe, zzjn zzjnVar, long j2, Object obj, Object obj2) {
        while (!b.a(unsafe, zzjnVar, j2, obj, obj2)) {
            if (unsafe.getObject(zzjnVar, j2) != obj) {
                return false;
            }
        }
        return true;
    }
}

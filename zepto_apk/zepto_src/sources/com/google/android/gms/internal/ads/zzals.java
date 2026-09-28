package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzals {
    public static void a(zzalt zzaltVar, zzdr zzdrVar) {
        for (int i2 = 0; i2 < zzaltVar.zza(); i2++) {
            long jZzb = zzaltVar.zzb(i2);
            ArrayList arrayListB = zzaltVar.b(jZzb);
            if (!arrayListB.isEmpty()) {
                if (i2 == zzaltVar.zza() - 1) {
                    throw new IllegalStateException();
                }
                long jZzb2 = zzaltVar.zzb(i2 + 1) - zzaltVar.zzb(i2);
                if (jZzb2 > 0) {
                    ((zzama) zzdrVar).zza(new zzalq(arrayListB, jZzb, jZzb2));
                }
            }
        }
    }
}

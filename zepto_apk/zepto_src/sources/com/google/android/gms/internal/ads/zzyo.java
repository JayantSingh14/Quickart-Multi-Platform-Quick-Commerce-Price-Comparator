package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzyo extends zzyq {
    public static void a(ArrayList arrayList, long[] jArr) {
        long j2 = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            j2 += jArr[i2];
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            zzgta zzgtaVar = (zzgta) arrayList.get(i3);
            if (zzgtaVar != null) {
                zzgtaVar.c(new zzym(j2, jArr[i3]));
            }
        }
    }
}

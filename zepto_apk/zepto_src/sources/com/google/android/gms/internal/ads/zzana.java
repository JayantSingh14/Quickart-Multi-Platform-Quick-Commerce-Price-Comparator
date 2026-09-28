package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes4.dex */
final class zzana {
    public static zzanb a(zzanb zzanbVar, String[] strArr, Map map) {
        int length;
        int i2 = 0;
        if (zzanbVar == null) {
            if (strArr == null) {
                return null;
            }
            int length2 = strArr.length;
            if (length2 == 1) {
                return (zzanb) map.get(strArr[0]);
            }
            if (length2 > 1) {
                zzanb zzanbVar2 = new zzanb();
                while (i2 < length2) {
                    zzanbVar2.c((zzanb) map.get(strArr[i2]));
                    i2++;
                }
                return zzanbVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                zzanbVar.c((zzanb) map.get(strArr[0]));
                return zzanbVar;
            }
            if (strArr != null && (length = strArr.length) > 1) {
                while (i2 < length) {
                    zzanbVar.c((zzanb) map.get(strArr[i2]));
                    i2++;
                }
            }
        }
        return zzanbVar;
    }
}

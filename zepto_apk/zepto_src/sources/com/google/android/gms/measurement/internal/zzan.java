package com.google.android.gms.measurement.internal;

import java.util.EnumMap;

/* loaded from: classes4.dex */
final class zzan {

    /* renamed from: a, reason: collision with root package name */
    public final EnumMap f38703a;

    public zzan() {
        this.f38703a = new EnumMap(zzjj.class);
    }

    public static zzan d(String str) {
        zzam zzamVar;
        EnumMap enumMap = new EnumMap(zzjj.class);
        if (str.length() < zzjj.values().length || str.charAt(0) != '1') {
            return new zzan();
        }
        zzjj[] zzjjVarArrValues = zzjj.values();
        int length = zzjjVarArrValues.length;
        int i2 = 1;
        int i3 = 0;
        while (i3 < length) {
            zzjj zzjjVar = zzjjVarArrValues[i3];
            int i4 = i2 + 1;
            char cCharAt = str.charAt(i2);
            zzam[] zzamVarArrValues = zzam.values();
            int length2 = zzamVarArrValues.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length2) {
                    zzamVar = zzam.UNSET;
                    break;
                }
                zzamVar = zzamVarArrValues[i5];
                if (zzamVar.f38702a == cCharAt) {
                    break;
                }
                i5++;
            }
            enumMap.put((EnumMap) zzjjVar, (zzjj) zzamVar);
            i3++;
            i2 = i4;
        }
        return new zzan(enumMap);
    }

    public final zzam a() {
        zzam zzamVar = (zzam) this.f38703a.get(zzjj.AD_PERSONALIZATION);
        return zzamVar == null ? zzam.UNSET : zzamVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(com.google.android.gms.measurement.internal.zzjj r3, int r4) {
        /*
            r2 = this;
            com.google.android.gms.measurement.internal.zzam r0 = com.google.android.gms.measurement.internal.zzam.UNSET
            r1 = -30
            if (r4 == r1) goto L1e
            r1 = -20
            if (r4 == r1) goto L1b
            r1 = -10
            if (r4 == r1) goto L18
            if (r4 == 0) goto L1b
            r1 = 30
            if (r4 == r1) goto L15
            goto L20
        L15:
            com.google.android.gms.measurement.internal.zzam r0 = com.google.android.gms.measurement.internal.zzam.INITIALIZATION
            goto L20
        L18:
            com.google.android.gms.measurement.internal.zzam r0 = com.google.android.gms.measurement.internal.zzam.MANIFEST
            goto L20
        L1b:
            com.google.android.gms.measurement.internal.zzam r0 = com.google.android.gms.measurement.internal.zzam.API
            goto L20
        L1e:
            com.google.android.gms.measurement.internal.zzam r0 = com.google.android.gms.measurement.internal.zzam.TCF
        L20:
            java.util.EnumMap r4 = r2.f38703a
            r4.put(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.b(com.google.android.gms.measurement.internal.zzjj, int):void");
    }

    public final void c(zzjj zzjjVar, zzam zzamVar) {
        this.f38703a.put((EnumMap) zzjjVar, (zzjj) zzamVar);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("1");
        for (zzjj zzjjVar : zzjj.values()) {
            zzam zzamVar = (zzam) this.f38703a.get(zzjjVar);
            if (zzamVar == null) {
                zzamVar = zzam.UNSET;
            }
            sb.append(zzamVar.f38702a);
        }
        return sb.toString();
    }

    public zzan(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(zzjj.class);
        this.f38703a = enumMap2;
        enumMap2.putAll(enumMap);
    }
}

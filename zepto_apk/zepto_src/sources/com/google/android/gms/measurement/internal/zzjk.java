package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;
import org.apache.commons.codec.language.Soundex;

/* loaded from: classes.dex */
public final class zzjk {

    /* renamed from: c, reason: collision with root package name */
    public static final zzjk f39198c = new zzjk(100);

    /* renamed from: a, reason: collision with root package name */
    public final EnumMap f39199a;

    /* renamed from: b, reason: collision with root package name */
    public final int f39200b;

    public zzjk(int i2) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        this.f39199a = enumMap;
        zzjj zzjjVar = zzjj.AD_STORAGE;
        zzjh zzjhVar = zzjh.UNINITIALIZED;
        enumMap.put((EnumMap) zzjjVar, (zzjj) zzjhVar);
        enumMap.put((EnumMap) zzjj.ANALYTICS_STORAGE, (zzjj) zzjhVar);
        this.f39200b = i2;
    }

    public static String a(int i2) {
        return i2 != -30 ? i2 != -20 ? i2 != -10 ? i2 != 0 ? i2 != 30 ? i2 != 90 ? i2 != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public static zzjk b(int i2, Bundle bundle) {
        if (bundle == null) {
            return new zzjk(i2);
        }
        EnumMap enumMap = new EnumMap(zzjj.class);
        for (zzjj zzjjVar : zzji.STORAGE.f39191a) {
            enumMap.put((EnumMap) zzjjVar, (zzjj) d(bundle.getString(zzjjVar.f39197a)));
        }
        return new zzjk(enumMap, i2);
    }

    public static zzjk c(int i2, String str) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        zzji zzjiVar = zzji.STORAGE;
        int i3 = 0;
        while (true) {
            zzjj[] zzjjVarArr = zzjiVar.f39191a;
            if (i3 >= zzjjVarArr.length) {
                return new zzjk(enumMap, i2);
            }
            String str2 = str == null ? "" : str;
            zzjj zzjjVar = zzjjVarArr[i3];
            int i4 = i3 + 2;
            if (i4 < str2.length()) {
                enumMap.put((EnumMap) zzjjVar, (zzjj) e(str2.charAt(i4)));
            } else {
                enumMap.put((EnumMap) zzjjVar, (zzjj) zzjh.UNINITIALIZED);
            }
            i3++;
        }
    }

    public static zzjh d(String str) {
        zzjh zzjhVar = zzjh.UNINITIALIZED;
        return str == null ? zzjhVar : str.equals("granted") ? zzjh.GRANTED : str.equals("denied") ? zzjh.DENIED : zzjhVar;
    }

    public static zzjh e(char c2) {
        return c2 != '+' ? c2 != '0' ? c2 != '1' ? zzjh.UNINITIALIZED : zzjh.GRANTED : zzjh.DENIED : zzjh.POLICY;
    }

    public static char h(zzjh zzjhVar) {
        if (zzjhVar == null) {
            return Soundex.SILENT_MARKER;
        }
        int iOrdinal = zzjhVar.ordinal();
        if (iOrdinal == 1) {
            return '+';
        }
        if (iOrdinal == 2) {
            return '0';
        }
        if (iOrdinal != 3) {
            return Soundex.SILENT_MARKER;
        }
        return '1';
    }

    public static boolean l(int i2, int i3) {
        int i4 = -30;
        if (i2 == -20) {
            if (i3 == -30) {
                return true;
            }
            i2 = -20;
        }
        if (i2 != -30) {
            i4 = i2;
        } else if (i3 == -20) {
            return true;
        }
        return i4 == i3 || i2 < i3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjk)) {
            return false;
        }
        zzjk zzjkVar = (zzjk) obj;
        for (zzjj zzjjVar : zzji.STORAGE.f39191a) {
            if (this.f39199a.get(zzjjVar) != zzjkVar.f39199a.get(zzjjVar)) {
                return false;
            }
        }
        return this.f39200b == zzjkVar.f39200b;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String f() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "G1"
            r0.<init>(r1)
            com.google.android.gms.measurement.internal.zzji r1 = com.google.android.gms.measurement.internal.zzji.STORAGE
            com.google.android.gms.measurement.internal.zzjj[] r1 = r1.f39191a
            int r2 = r1.length
            r3 = 0
        Ld:
            if (r3 >= r2) goto L38
            r4 = r1[r3]
            java.util.EnumMap r5 = r7.f39199a
            java.lang.Object r4 = r5.get(r4)
            com.google.android.gms.measurement.internal.zzjh r4 = (com.google.android.gms.measurement.internal.zzjh) r4
            r5 = 45
            if (r4 == 0) goto L32
            int r4 = r4.ordinal()
            if (r4 == 0) goto L32
            r6 = 1
            if (r4 == r6) goto L30
            r6 = 2
            if (r4 == r6) goto L2d
            r6 = 3
            if (r4 == r6) goto L30
            goto L32
        L2d:
            r5 = 48
            goto L32
        L30:
            r5 = 49
        L32:
            r0.append(r5)
            int r3 = r3 + 1
            goto Ld
        L38:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjk.f():java.lang.String");
    }

    public final String g() {
        StringBuilder sb = new StringBuilder("G1");
        for (zzjj zzjjVar : zzji.STORAGE.f39191a) {
            sb.append(h((zzjh) this.f39199a.get(zzjjVar)));
        }
        return sb.toString();
    }

    public final int hashCode() {
        Iterator it = this.f39199a.values().iterator();
        int iHashCode = this.f39200b * 17;
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + ((zzjh) it.next()).hashCode();
        }
        return iHashCode;
    }

    public final boolean i(zzjj zzjjVar) {
        return ((zzjh) this.f39199a.get(zzjjVar)) != zzjh.DENIED;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzjk j(com.google.android.gms.measurement.internal.zzjk r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<com.google.android.gms.measurement.internal.zzjj> r1 = com.google.android.gms.measurement.internal.zzjj.class
            r0.<init>(r1)
            com.google.android.gms.measurement.internal.zzji r1 = com.google.android.gms.measurement.internal.zzji.STORAGE
            com.google.android.gms.measurement.internal.zzjj[] r1 = r1.f39191a
            int r2 = r1.length
            r3 = 0
        Ld:
            if (r3 >= r2) goto L48
            r4 = r1[r3]
            java.util.EnumMap r5 = r8.f39199a
            java.lang.Object r5 = r5.get(r4)
            com.google.android.gms.measurement.internal.zzjh r5 = (com.google.android.gms.measurement.internal.zzjh) r5
            java.util.EnumMap r6 = r9.f39199a
            java.lang.Object r6 = r6.get(r4)
            com.google.android.gms.measurement.internal.zzjh r6 = (com.google.android.gms.measurement.internal.zzjh) r6
            if (r5 != 0) goto L24
            goto L31
        L24:
            if (r6 == 0) goto L40
            com.google.android.gms.measurement.internal.zzjh r7 = com.google.android.gms.measurement.internal.zzjh.UNINITIALIZED
            if (r5 != r7) goto L2b
            goto L31
        L2b:
            if (r6 == r7) goto L40
            com.google.android.gms.measurement.internal.zzjh r7 = com.google.android.gms.measurement.internal.zzjh.POLICY
            if (r5 != r7) goto L33
        L31:
            r5 = r6
            goto L40
        L33:
            if (r6 == r7) goto L40
            com.google.android.gms.measurement.internal.zzjh r7 = com.google.android.gms.measurement.internal.zzjh.DENIED
            if (r5 == r7) goto L3f
            if (r6 != r7) goto L3c
            goto L3f
        L3c:
            com.google.android.gms.measurement.internal.zzjh r5 = com.google.android.gms.measurement.internal.zzjh.GRANTED
            goto L40
        L3f:
            r5 = r7
        L40:
            if (r5 == 0) goto L45
            r0.put(r4, r5)
        L45:
            int r3 = r3 + 1
            goto Ld
        L48:
            com.google.android.gms.measurement.internal.zzjk r9 = new com.google.android.gms.measurement.internal.zzjk
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjk.j(com.google.android.gms.measurement.internal.zzjk):com.google.android.gms.measurement.internal.zzjk");
    }

    public final zzjk k(zzjk zzjkVar) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        for (zzjj zzjjVar : zzji.STORAGE.f39191a) {
            zzjh zzjhVar = (zzjh) this.f39199a.get(zzjjVar);
            if (zzjhVar == zzjh.UNINITIALIZED) {
                zzjhVar = (zzjh) zzjkVar.f39199a.get(zzjjVar);
            }
            if (zzjhVar != null) {
                enumMap.put((EnumMap) zzjjVar, (zzjj) zzjhVar);
            }
        }
        return new zzjk(enumMap, this.f39200b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(a(this.f39200b));
        for (zzjj zzjjVar : zzji.STORAGE.f39191a) {
            sb.append(",");
            sb.append(zzjjVar.f39197a);
            sb.append("=");
            zzjh zzjhVar = (zzjh) this.f39199a.get(zzjjVar);
            if (zzjhVar == null) {
                zzjhVar = zzjh.UNINITIALIZED;
            }
            sb.append(zzjhVar);
        }
        return sb.toString();
    }

    public zzjk(EnumMap enumMap, int i2) {
        EnumMap enumMap2 = new EnumMap(zzjj.class);
        this.f39199a = enumMap2;
        enumMap2.putAll(enumMap);
        this.f39200b = i2;
    }
}

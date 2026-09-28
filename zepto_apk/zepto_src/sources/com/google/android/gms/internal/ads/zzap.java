package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzap {

    /* renamed from: a, reason: collision with root package name */
    public final zzao[] f24032a;

    public zzap(zzao... zzaoVarArr) {
        this.f24032a = zzaoVarArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzgtd a(java.lang.Class r7, com.google.android.gms.internal.ads.zzgqb r8) {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzgvs r0 = com.google.android.gms.internal.ads.zzgtd.f33183b
            com.google.android.gms.internal.ads.zzgta r0 = new com.google.android.gms.internal.ads.zzgta
            r0.<init>()
            com.google.android.gms.internal.ads.zzao[] r1 = r6.f24032a
            int r2 = r1.length
            r3 = 0
        Lb:
            if (r3 >= r2) goto L2f
            r4 = r1[r3]
            java.lang.Class r5 = r4.getClass()
            boolean r5 = r7.isAssignableFrom(r5)
            if (r5 == 0) goto L26
            java.lang.Object r4 = r7.cast(r4)
            com.google.android.gms.internal.ads.zzao r4 = (com.google.android.gms.internal.ads.zzao) r4
            boolean r5 = r8.zza(r4)
            if (r5 == 0) goto L26
            goto L27
        L26:
            r4 = 0
        L27:
            if (r4 == 0) goto L2c
            r0.c(r4)
        L2c:
            int r3 = r3 + 1
            goto Lb
        L2f:
            com.google.android.gms.internal.ads.zzgtd r7 = r0.f()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzap.a(java.lang.Class, com.google.android.gms.internal.ads.zzgqb):com.google.android.gms.internal.ads.zzgtd");
    }

    public final zzap b(zzap zzapVar) {
        return zzapVar == null ? this : c(zzapVar.f24032a);
    }

    public final zzap c(zzao... zzaoVarArr) {
        int length = zzaoVarArr.length;
        if (length == 0) {
            return this;
        }
        String str = zzfj.f31254a;
        zzao[] zzaoVarArr2 = this.f24032a;
        int length2 = zzaoVarArr2.length;
        Object[] objArrCopyOf = Arrays.copyOf(zzaoVarArr2, length2 + length);
        System.arraycopy(zzaoVarArr, 0, objArrCopyOf, length2, length);
        return new zzap((zzao[]) objArrCopyOf);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && zzap.class == obj.getClass() && Arrays.equals(this.f24032a, ((zzap) obj).f24032a);
    }

    public final int hashCode() {
        return Long.hashCode(-9223372036854775807L) + (Arrays.hashCode(this.f24032a) * 31);
    }

    public final String toString() {
        String string = Arrays.toString(this.f24032a);
        return android.support.v4.media.b.s(new StringBuilder(String.valueOf(string).length() + 8), "entries=", string, "");
    }

    public zzap(List list) {
        this.f24032a = (zzao[]) list.toArray(new zzao[0]);
    }
}

package com.google.android.gms.internal.measurement;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzs extends zzai {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f37316c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f37317d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzt f37318e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(zzt zztVar, boolean z, boolean z2) {
        super("log");
        Objects.requireNonNull(zztVar);
        this.f37318e = zztVar;
        this.f37316c = z;
        this.f37317d = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007e  */
    @Override // com.google.android.gms.internal.measurement.zzai
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.zzao a(com.google.android.gms.internal.measurement.zzg r14, java.util.List r15) {
        /*
            r13 = this;
            java.lang.String r0 = "log"
            r1 = 1
            com.google.android.gms.internal.measurement.zzh.b(r0, r15, r1)
            int r0 = r15.size()
            r2 = 0
            com.google.android.gms.internal.measurement.zzat r3 = com.google.android.gms.internal.measurement.zzao.o0
            com.google.android.gms.internal.measurement.zzt r4 = r13.f37318e
            if (r0 != r1) goto L2e
            java.lang.Object r15 = r15.get(r2)
            com.google.android.gms.internal.measurement.zzao r15 = (com.google.android.gms.internal.measurement.zzao) r15
            com.google.android.gms.internal.measurement.zzaw r0 = r14.f36956b
            com.google.android.gms.internal.measurement.zzao r14 = r0.b(r14, r15)
            java.lang.String r7 = r14.zzc()
            java.util.List r8 = java.util.Collections.EMPTY_LIST
            com.google.android.gms.internal.measurement.zzr r5 = r4.f37319c
            boolean r9 = r13.f37316c
            boolean r10 = r13.f37317d
            r6 = 3
            r5.a(r6, r7, r8, r9, r10)
            return r3
        L2e:
            java.lang.Object r0 = r15.get(r2)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzaw r2 = r14.f36956b
            com.google.android.gms.internal.measurement.zzao r0 = r2.b(r14, r0)
            java.lang.Double r0 = r0.zzd()
            double r5 = r0.doubleValue()
            int r0 = com.google.android.gms.internal.measurement.zzh.g(r5)
            r2 = 5
            r5 = 2
            if (r0 == r5) goto L5a
            r6 = 3
            if (r0 == r6) goto L58
            if (r0 == r2) goto L56
            r7 = 6
            if (r0 == r7) goto L54
        L52:
            r8 = r6
            goto L5c
        L54:
            r8 = r5
            goto L5c
        L56:
            r8 = r2
            goto L5c
        L58:
            r8 = r1
            goto L5c
        L5a:
            r6 = 4
            goto L52
        L5c:
            java.lang.Object r0 = r15.get(r1)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzaw r1 = r14.f36956b
            com.google.android.gms.internal.measurement.zzao r0 = r1.b(r14, r0)
            java.lang.String r9 = r0.zzc()
            int r0 = r15.size()
            if (r0 != r5) goto L7e
            java.util.List r10 = java.util.Collections.EMPTY_LIST
            com.google.android.gms.internal.measurement.zzr r7 = r4.f37319c
            boolean r11 = r13.f37316c
            boolean r12 = r13.f37317d
            r7.a(r8, r9, r10, r11, r12)
            return r3
        L7e:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
        L83:
            int r0 = r15.size()
            int r0 = java.lang.Math.min(r0, r2)
            if (r5 >= r0) goto La1
            java.lang.Object r0 = r15.get(r5)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r1.b(r14, r0)
            java.lang.String r0 = r0.zzc()
            r10.add(r0)
            int r5 = r5 + 1
            goto L83
        La1:
            com.google.android.gms.internal.measurement.zzr r7 = r4.f37319c
            boolean r11 = r13.f37316c
            boolean r12 = r13.f37317d
            r7.a(r8, r9, r10, r11, r12)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzs.a(com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzao");
    }
}

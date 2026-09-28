package com.google.android.gms.measurement.internal;

import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzpb {

    /* renamed from: a, reason: collision with root package name */
    public com.google.android.gms.internal.measurement.zzid f39583a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f39584b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f39585c;

    /* renamed from: d, reason: collision with root package name */
    public long f39586d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzpf f39587e;

    public /* synthetic */ zzpb(zzpf zzpfVar) {
        Objects.requireNonNull(zzpfVar);
        this.f39587e = zzpfVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(long r11, com.google.android.gms.internal.measurement.zzhs r13) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            java.util.ArrayList r0 = r10.f39585c
            if (r0 != 0) goto Le
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r10.f39585c = r0
        Le:
            java.util.ArrayList r0 = r10.f39584b
            if (r0 != 0) goto L19
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r10.f39584b = r0
        L19:
            java.util.ArrayList r0 = r10.f39585c
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 != 0) goto L40
            java.util.ArrayList r0 = r10.f39585c
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzhs r0 = (com.google.android.gms.internal.measurement.zzhs) r0
            long r2 = r0.x()
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            r6 = 60
            long r2 = r2 / r6
            long r2 = r2 / r6
            long r8 = r13.x()
            long r8 = r8 / r4
            long r8 = r8 / r6
            long r8 = r8 / r6
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 != 0) goto Lbd
        L40:
            long r2 = r10.f39586d
            int r0 = r13.a()
            long r4 = (long) r0
            long r2 = r2 + r4
            com.google.android.gms.measurement.internal.zzpf r0 = r10.f39587e
            com.google.android.gms.measurement.internal.zzal r4 = r0.d0()
            com.google.android.gms.measurement.internal.zzfw r5 = com.google.android.gms.measurement.internal.zzfx.e1
            r6 = 0
            boolean r4 = r4.q(r6, r5)
            if (r4 == 0) goto L78
            java.util.ArrayList r4 = r10.f39585c
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L91
            r0.d0()
            com.google.android.gms.measurement.internal.zzfw r4 = com.google.android.gms.measurement.internal.zzfx.f38911j
            java.lang.Object r4 = r4.a(r6)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            int r4 = java.lang.Math.max(r1, r4)
            long r4 = (long) r4
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 >= 0) goto Lbd
            goto L91
        L78:
            r0.d0()
            com.google.android.gms.measurement.internal.zzfw r4 = com.google.android.gms.measurement.internal.zzfx.f38911j
            java.lang.Object r4 = r4.a(r6)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            int r4 = java.lang.Math.max(r1, r4)
            long r4 = (long) r4
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 < 0) goto L91
            goto Lbd
        L91:
            r10.f39586d = r2
            java.util.ArrayList r2 = r10.f39585c
            r2.add(r13)
            java.util.ArrayList r13 = r10.f39584b
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            r13.add(r11)
            java.util.ArrayList r11 = r10.f39585c
            int r11 = r11.size()
            r0.d0()
            com.google.android.gms.measurement.internal.zzfw r12 = com.google.android.gms.measurement.internal.zzfx.f38912k
            java.lang.Object r12 = r12.a(r6)
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            r13 = 1
            int r12 = java.lang.Math.max(r13, r12)
            if (r11 < r12) goto Lbe
        Lbd:
            return r1
        Lbe:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpb.a(long, com.google.android.gms.internal.measurement.zzhs):boolean");
    }
}

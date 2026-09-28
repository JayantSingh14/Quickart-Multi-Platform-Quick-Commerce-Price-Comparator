package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzxh implements zzxw {

    /* renamed from: a, reason: collision with root package name */
    public final int f35823a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzxk f35824b;

    public zzxh(zzxk zzxkVar, int i2) {
        Objects.requireNonNull(zzxkVar);
        this.f35824b = zzxkVar;
        this.f35823a = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x005c  */
    @Override // com.google.android.gms.internal.ads.zzxw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(long r14) {
        /*
            r13 = this;
            com.google.android.gms.internal.ads.zzxk r0 = r13.f35824b
            int r1 = r13.f35823a
            boolean r2 = r0.o()
            r3 = 0
            if (r2 == 0) goto Lc
            return r3
        Lc:
            r0.m(r1)
            com.google.android.gms.internal.ads.zzxv[] r2 = r0.r
            r4 = r2[r1]
            boolean r2 = r0.L
            monitor-enter(r4)
            int r5 = r4.r     // Catch: java.lang.Throwable -> L4c
            r6 = r5
            int r5 = r4.j(r6)     // Catch: java.lang.Throwable -> L4c
            int r7 = r4.r     // Catch: java.lang.Throwable -> L4c
            int r8 = r4.o     // Catch: java.lang.Throwable -> L4c
            r10 = 1
            if (r7 == r8) goto L26
            r7 = r10
            goto L27
        L26:
            r7 = r3
        L27:
            if (r7 == 0) goto L4f
            long[] r7 = r4.f35883m     // Catch: java.lang.Throwable -> L4c
            r11 = r7[r5]     // Catch: java.lang.Throwable -> L4c
            int r7 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r7 >= 0) goto L32
            goto L4f
        L32:
            long r11 = r4.u     // Catch: java.lang.Throwable -> L4c
            int r7 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r7 <= 0) goto L3e
            if (r2 != 0) goto L3b
            goto L3e
        L3b:
            int r8 = r8 - r6
            monitor-exit(r4)
            goto L51
        L3e:
            int r6 = r8 - r6
            r9 = 1
            r7 = r14
            int r8 = r4.h(r5, r6, r7, r9)     // Catch: java.lang.Throwable -> L4c
            r14 = -1
            monitor-exit(r4)
            if (r8 != r14) goto L51
        L4a:
            r8 = r3
            goto L51
        L4c:
            r0 = move-exception
            r14 = r0
            goto L73
        L4f:
            monitor-exit(r4)
            goto L4a
        L51:
            monitor-enter(r4)
            if (r8 < 0) goto L5c
            int r14 = r4.r     // Catch: java.lang.Throwable -> L5e
            int r14 = r14 + r8
            int r15 = r4.o     // Catch: java.lang.Throwable -> L5e
            if (r14 > r15) goto L5c
            goto L61
        L5c:
            r10 = r3
            goto L61
        L5e:
            r0 = move-exception
            r14 = r0
            goto L71
        L61:
            com.google.android.gms.internal.ads.zzgqa.a(r10)     // Catch: java.lang.Throwable -> L5e
            int r14 = r4.r     // Catch: java.lang.Throwable -> L5e
            int r14 = r14 + r8
            r4.r = r14     // Catch: java.lang.Throwable -> L5e
            monitor-exit(r4)
            if (r8 != 0) goto L70
            r0.n(r1)
            return r3
        L70:
            return r8
        L71:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L5e
            throw r14
        L73:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L4c
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxh.a(long):int");
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final int b(zzle zzleVar, zzih zzihVar, int i2) {
        int i3;
        boolean z;
        int i4;
        zzxk zzxkVar = this.f35824b;
        int i5 = this.f35823a;
        if (zzxkVar.o()) {
            return -3;
        }
        zzxkVar.m(i5);
        zzxv zzxvVar = zzxkVar.r[i5];
        boolean z2 = zzxkVar.L;
        zzxvVar.getClass();
        boolean z3 = (i2 & 2) != 0;
        zzxr zzxrVar = zzxvVar.f35872b;
        synchronized (zzxvVar) {
            try {
                zzihVar.f34830e = false;
                int i6 = zzxvVar.r;
                i3 = -4;
                if (i6 != zzxvVar.o) {
                    zzv zzvVar = ((zzxt) zzxvVar.f35873c.a(zzxvVar.p + i6)).f35869a;
                    if (!z3 && zzvVar == zzxvVar.f35876f) {
                        int iJ = zzxvVar.j(zzxvVar.r);
                        if (zzxvVar.f35877g != null) {
                            int i7 = zzxvVar.f35882l[iJ];
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            int i8 = zzxvVar.f35882l[iJ];
                            zzihVar.f34703a = i8;
                            if (zzxvVar.r == zzxvVar.o - 1 && (z2 || zzxvVar.v)) {
                                zzihVar.f34703a = 536870912 | i8;
                            }
                            zzihVar.f34831f = zzxvVar.f35883m[iJ];
                            zzxrVar.f35865a = zzxvVar.f35881k[iJ];
                            zzxrVar.f35866b = zzxvVar.f35880j[iJ];
                            zzxrVar.f35867c = zzxvVar.n[iJ];
                            i4 = -4;
                        } else {
                            zzihVar.f34830e = true;
                            i4 = -3;
                        }
                    }
                    zzxvVar.g(zzvVar, zzleVar);
                    i4 = -5;
                } else {
                    if (!z2 && !zzxvVar.v) {
                        zzv zzvVar2 = zzxvVar.y;
                        if (zzvVar2 == null || (!z3 && zzvVar2 == zzxvVar.f35876f)) {
                            i4 = -3;
                        }
                        zzxvVar.g(zzvVar2, zzleVar);
                        i4 = -5;
                    }
                    zzihVar.f34703a = 4;
                    zzihVar.f34831f = Long.MIN_VALUE;
                    i4 = -4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i4 != -4) {
            i3 = i4;
        } else if (!zzihVar.b(4)) {
            int i9 = i2 & 1;
            if ((i2 & 4) == 0) {
                if (i9 != 0) {
                    zzxq zzxqVar = zzxvVar.f35871a;
                    zzxq.c(zzxqVar.f35862d, zzihVar, zzxrVar, zzxqVar.f35860b);
                } else {
                    zzxq zzxqVar2 = zzxvVar.f35871a;
                    zzxqVar2.f35862d = zzxq.c(zzxqVar2.f35862d, zzihVar, zzxrVar, zzxqVar2.f35860b);
                    zzxvVar.r++;
                }
            } else if (i9 == 0) {
                zzxvVar.r++;
            }
        }
        if (i3 == -3) {
            zzxkVar.n(i5);
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final boolean zzb() {
        zzxk zzxkVar = this.f35824b;
        return !zzxkVar.o() && zzxkVar.r[this.f35823a].l(zzxkVar.L);
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void zzc() throws IOException {
        IOException iOException;
        zzxk zzxkVar = this.f35824b;
        zztd zztdVar = zzxkVar.r[this.f35823a].f35877g;
        if (zztdVar != null) {
            throw zztdVar.zza();
        }
        int i2 = zzxkVar.B == 7 ? 6 : 3;
        zzaaz zzaazVar = zzxkVar.f35840j;
        IOException iOException2 = zzaazVar.f22626c;
        if (iOException2 != null) {
            throw iOException2;
        }
        zzaau zzaauVar = zzaazVar.f22625b;
        if (zzaauVar != null && (iOException = zzaauVar.f22615c) != null && zzaauVar.f22616d > i2) {
            throw iOException;
        }
    }
}

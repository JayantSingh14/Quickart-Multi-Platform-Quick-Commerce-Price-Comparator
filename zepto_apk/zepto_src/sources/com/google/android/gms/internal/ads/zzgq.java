package com.google.android.gms.internal.ads;

import androidx.annotation.RestrictTo;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

@RestrictTo
/* loaded from: classes4.dex */
public final class zzgq {

    /* renamed from: a, reason: collision with root package name */
    public final zzgp f33062a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f33063b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayDeque f33064c = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    public final PriorityQueue f33065d = new PriorityQueue();

    /* renamed from: e, reason: collision with root package name */
    public int f33066e = -1;

    /* renamed from: f, reason: collision with root package name */
    public zzgo f33067f;

    public zzgq(zzgp zzgpVar) {
        this.f33062a = zzgpVar;
    }

    public final void a(int i2) {
        zzgqa.f(i2 >= 0);
        this.f33066e = i2;
        c(i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (r8 < r0.f33007b) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(long r8, com.google.android.gms.internal.ads.zzer r10) {
        /*
            r7 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 == 0) goto L92
            int r0 = r7.f33066e
            if (r0 == 0) goto L93
            java.util.PriorityQueue r1 = r7.f33065d
            r2 = -1
            if (r0 == r2) goto L29
            int r0 = r1.size()
            int r3 = r7.f33066e
            if (r0 < r3) goto L29
            java.lang.Object r0 = r1.peek()
            com.google.android.gms.internal.ads.zzgo r0 = (com.google.android.gms.internal.ads.zzgo) r0
            java.lang.String r3 = com.google.android.gms.internal.ads.zzfj.f31254a
            long r3 = r0.f33007b
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 >= 0) goto L29
            goto L93
        L29:
            java.util.ArrayDeque r0 = r7.f33063b
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L37
            com.google.android.gms.internal.ads.zzer r0 = new com.google.android.gms.internal.ads.zzer
            r0.<init>()
            goto L3d
        L37:
            java.lang.Object r0 = r0.pop()
            com.google.android.gms.internal.ads.zzer r0 = (com.google.android.gms.internal.ads.zzer) r0
        L3d:
            int r3 = r10.B()
            r0.y(r3)
            byte[] r3 = r10.f30144a
            int r10 = r10.f30145b
            byte[] r4 = r0.f30144a
            r5 = 0
            int r6 = r0.B()
            java.lang.System.arraycopy(r3, r10, r4, r5, r6)
            com.google.android.gms.internal.ads.zzgo r10 = r7.f33067f
            if (r10 == 0) goto L63
            long r3 = r10.f33007b
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 == 0) goto L5d
            goto L63
        L5d:
            java.util.ArrayList r8 = r10.f33006a
            r8.add(r0)
            return
        L63:
            java.util.ArrayDeque r10 = r7.f33064c
            boolean r3 = r10.isEmpty()
            if (r3 == 0) goto L71
            com.google.android.gms.internal.ads.zzgo r10 = new com.google.android.gms.internal.ads.zzgo
            r10.<init>()
            goto L77
        L71:
            java.lang.Object r10 = r10.pop()
            com.google.android.gms.internal.ads.zzgo r10 = (com.google.android.gms.internal.ads.zzgo) r10
        L77:
            java.util.ArrayList r3 = r10.f33006a
            boolean r4 = r3.isEmpty()
            com.google.android.gms.internal.ads.zzgqa.f(r4)
            r10.f33007b = r8
            r3.add(r0)
            r1.add(r10)
            r7.f33067f = r10
            int r8 = r7.f33066e
            if (r8 == r2) goto L91
            r7.c(r8)
        L91:
            return
        L92:
            r8 = r0
        L93:
            com.google.android.gms.internal.ads.zzgp r0 = r7.f33062a
            r0.a(r8, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgq.b(long, com.google.android.gms.internal.ads.zzer):void");
    }

    public final void c(int i2) {
        ArrayList arrayList;
        while (true) {
            PriorityQueue priorityQueue = this.f33065d;
            if (priorityQueue.size() <= i2) {
                return;
            }
            zzgo zzgoVar = (zzgo) priorityQueue.poll();
            String str = zzfj.f31254a;
            int i3 = 0;
            while (true) {
                arrayList = zzgoVar.f33006a;
                if (i3 >= arrayList.size()) {
                    break;
                }
                this.f33062a.a(zzgoVar.f33007b, (zzer) arrayList.get(i3));
                this.f33063b.push((zzer) arrayList.get(i3));
                i3++;
            }
            arrayList.clear();
            zzgo zzgoVar2 = this.f33067f;
            if (zzgoVar2 != null && zzgoVar2.f33007b == zzgoVar.f33007b) {
                this.f33067f = null;
            }
            this.f33064c.push(zzgoVar);
        }
    }
}

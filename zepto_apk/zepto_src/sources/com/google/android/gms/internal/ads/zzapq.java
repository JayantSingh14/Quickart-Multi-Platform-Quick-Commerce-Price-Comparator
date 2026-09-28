package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzapq implements zzaeo {

    /* renamed from: a, reason: collision with root package name */
    public final int f24090a;

    /* renamed from: b, reason: collision with root package name */
    public final List f24091b;

    /* renamed from: c, reason: collision with root package name */
    public final zzer f24092c;

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f24093d;

    /* renamed from: e, reason: collision with root package name */
    public final zzaod f24094e;

    /* renamed from: f, reason: collision with root package name */
    public final zzalw f24095f;

    /* renamed from: g, reason: collision with root package name */
    public final SparseArray f24096g;

    /* renamed from: h, reason: collision with root package name */
    public final SparseBooleanArray f24097h;

    /* renamed from: i, reason: collision with root package name */
    public final SparseBooleanArray f24098i;

    /* renamed from: j, reason: collision with root package name */
    public final zzapm f24099j;

    /* renamed from: k, reason: collision with root package name */
    public zzapl f24100k;

    /* renamed from: l, reason: collision with root package name */
    public zzaer f24101l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f24102m;
    public boolean n;
    public boolean o;
    public int p;

    @Deprecated
    public zzapq() {
        this(1, zzalw.f23510a, new zzfg(), new zzaod(0));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
    @Override // com.google.android.gms.internal.ads.zzaeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(long r10, long r12) {
        /*
            r9 = this;
            java.util.List r10 = r9.f24091b
            int r11 = r10.size()
            r0 = 0
            r1 = r0
        L8:
            r2 = 0
            if (r1 >= r11) goto L38
            java.lang.Object r4 = r10.get(r1)
            com.google.android.gms.internal.ads.zzfg r4 = (com.google.android.gms.internal.ads.zzfg) r4
            monitor-enter(r4)
            long r5 = r4.f31048b     // Catch: java.lang.Throwable -> L35
            monitor-exit(r4)
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 == 0) goto L2f
            long r5 = r4.a()
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 == 0) goto L32
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 == 0) goto L32
            int r2 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r2 == 0) goto L32
        L2f:
            r4.b(r12)
        L32:
            int r1 = r1 + 1
            goto L8
        L35:
            r10 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L35
            throw r10
        L38:
            int r10 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r10 == 0) goto L43
            com.google.android.gms.internal.ads.zzapl r10 = r9.f24100k
            if (r10 == 0) goto L43
            r10.a(r12)
        L43:
            com.google.android.gms.internal.ads.zzer r10 = r9.f24092c
            r10.y(r0)
            android.util.SparseIntArray r10 = r9.f24093d
            r10.clear()
        L4d:
            android.util.SparseArray r10 = r9.f24096g
            int r11 = r10.size()
            if (r0 >= r11) goto L61
            java.lang.Object r10 = r10.valueAt(r0)
            com.google.android.gms.internal.ads.zzapv r10 = (com.google.android.gms.internal.ads.zzapv) r10
            r10.zzb()
            int r0 = r0 + 1
            goto L4d
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapq.a(long, long):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void b(zzaer zzaerVar) {
        if (this.f24090a == 0) {
            zzaerVar = new zzalz(zzaerVar, this.f24095f);
        }
        this.f24101l = zzaerVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        r2 = r2 + 1;
     */
    @Override // com.google.android.gms.internal.ads.zzaeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(com.google.android.gms.internal.ads.zzaep r7) throws java.io.EOFException, java.io.InterruptedIOException {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzer r0 = r6.f24092c
            byte[] r0 = r0.f30144a
            com.google.android.gms.internal.ads.zzaef r7 = (com.google.android.gms.internal.ads.zzaef) r7
            r1 = 0
            r2 = 940(0x3ac, float:1.317E-42)
            r7.t(r0, r1, r2, r1)
            r2 = r1
        Ld:
            r3 = 188(0xbc, float:2.63E-43)
            if (r2 >= r3) goto L29
            r3 = r1
        L12:
            r4 = 5
            if (r3 >= r4) goto L24
            int r4 = r3 * 188
            int r4 = r4 + r2
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L21
            int r2 = r2 + 1
            goto Ld
        L21:
            int r3 = r3 + 1
            goto L12
        L24:
            r7.d(r2, r1)
            r7 = 1
            return r7
        L29:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapq.c(com.google.android.gms.internal.ads.zzaep):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0282  */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v3 */
    @Override // com.google.android.gms.internal.ads.zzaeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(com.google.android.gms.internal.ads.zzaep r24, com.google.android.gms.internal.ads.zzafo r25) throws java.io.EOFException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instructions count: 656
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapq.d(com.google.android.gms.internal.ads.zzaep, com.google.android.gms.internal.ads.zzafo):int");
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void zzf() {
    }

    public zzapq(int i2, zzalw zzalwVar, zzfg zzfgVar, zzaod zzaodVar) {
        this.f24094e = zzaodVar;
        this.f24090a = i2;
        this.f24095f = zzalwVar;
        this.f24091b = Collections.singletonList(zzfgVar);
        this.f24092c = new zzer(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.f24097h = sparseBooleanArray;
        this.f24098i = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.f24096g = sparseArray;
        this.f24093d = new SparseIntArray();
        this.f24099j = new zzapm();
        this.f24101l = zzaer.n0;
        this.p = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArray2 = new SparseArray();
        int size = sparseArray2.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f24096g.put(sparseArray2.keyAt(i3), (zzapv) sparseArray2.valueAt(i3));
        }
        this.f24096g.put(0, new zzaph(new zzapn(this)));
    }
}

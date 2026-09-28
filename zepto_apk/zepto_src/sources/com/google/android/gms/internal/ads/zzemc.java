package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
final class zzemc {

    /* renamed from: c, reason: collision with root package name */
    public final zzgzf f29709c;

    /* renamed from: f, reason: collision with root package name */
    public zzems f29712f;

    /* renamed from: h, reason: collision with root package name */
    public final String f29714h;

    /* renamed from: i, reason: collision with root package name */
    public final int f29715i;

    /* renamed from: j, reason: collision with root package name */
    public final zzemr f29716j;

    /* renamed from: k, reason: collision with root package name */
    public zzfhr f29717k;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f29707a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f29708b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f29710d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f29711e = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    public int f29713g = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: l, reason: collision with root package name */
    public boolean f29718l = false;

    public zzemc(zzfic zzficVar, zzemr zzemrVar, zzgzf zzgzfVar) {
        int i2 = 0;
        this.f29715i = zzficVar.f31194b.f31190b.r;
        this.f29716j = zzemrVar;
        this.f29709c = zzgzfVar;
        this.f29714h = zzemy.a(zzficVar);
        zzfib zzfibVar = zzficVar.f31194b;
        while (true) {
            List list = zzfibVar.f31189a;
            if (i2 >= list.size()) {
                this.f29708b.addAll(list);
                return;
            } else {
                this.f29707a.put((zzfhr) list.get(i2), Integer.valueOf(i2));
                i2++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r2.v0 == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        r6.f29718l = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        r4.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        r6.f29710d.add(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
    
        return (com.google.android.gms.internal.ads.zzfhr) r1.remove(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized com.google.android.gms.internal.ads.zzfhr a() {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.d()     // Catch: java.lang.Throwable -> L2b
            if (r0 == 0) goto L43
            r0 = 0
        L8:
            java.util.ArrayList r1 = r6.f29708b     // Catch: java.lang.Throwable -> L2b
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L2b
            if (r0 >= r2) goto L43
            java.lang.Object r2 = r1.get(r0)     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.internal.ads.zzfhr r2 = (com.google.android.gms.internal.ads.zzfhr) r2     // Catch: java.lang.Throwable -> L2b
            java.lang.String r3 = r2.t0     // Catch: java.lang.Throwable -> L2b
            java.util.HashSet r4 = r6.f29711e     // Catch: java.lang.Throwable -> L2b
            boolean r5 = r4.contains(r3)     // Catch: java.lang.Throwable -> L2b
            if (r5 == 0) goto L23
            int r0 = r0 + 1
            goto L8
        L23:
            boolean r5 = r2.v0     // Catch: java.lang.Throwable -> L2b
            if (r5 == 0) goto L2d
            r5 = 1
            r6.f29718l = r5     // Catch: java.lang.Throwable -> L2b
            goto L2d
        L2b:
            r0 = move-exception
            goto L46
        L2d:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L2b
            if (r5 != 0) goto L36
            r4.add(r3)     // Catch: java.lang.Throwable -> L2b
        L36:
            java.util.ArrayList r3 = r6.f29710d     // Catch: java.lang.Throwable -> L2b
            r3.add(r2)     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r0 = r1.remove(r0)     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.internal.ads.zzfhr r0 = (com.google.android.gms.internal.ads.zzfhr) r0     // Catch: java.lang.Throwable -> L2b
            monitor-exit(r6)
            return r0
        L43:
            monitor-exit(r6)
            r0 = 0
            return r0
        L46:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L2b
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemc.a():com.google.android.gms.internal.ads.zzfhr");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x005b A[Catch: all -> 0x0018, DONT_GENERATE, TryCatch #1 {, blocks: (B:4:0x0002, B:5:0x0009, B:7:0x0010, B:9:0x0013, B:14:0x001a, B:16:0x0024, B:18:0x002c, B:20:0x0030, B:23:0x0037, B:25:0x003b, B:26:0x0042, B:27:0x0048, B:34:0x0057, B:41:0x005f, B:38:0x005b, B:47:0x0067, B:50:0x006a, B:6:0x000a, B:29:0x004a, B:31:0x0050), top: B:55:0x0002, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void b(com.google.android.gms.internal.ads.zzems r5, com.google.android.gms.internal.ads.zzfhr r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            r4.f29718l = r0     // Catch: java.lang.Throwable -> L18
            java.util.ArrayList r1 = r4.f29710d     // Catch: java.lang.Throwable -> L18
            r1.remove(r6)     // Catch: java.lang.Throwable -> L18
            monitor-enter(r4)     // Catch: java.lang.Throwable -> L18
            com.google.android.gms.internal.ads.zzgzf r1 = r4.f29709c     // Catch: java.lang.Throwable -> L68
            boolean r1 = r1.isDone()     // Catch: java.lang.Throwable -> L68
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L18
            if (r1 == 0) goto L1a
            r5.zzm()     // Catch: java.lang.Throwable -> L18
            monitor-exit(r4)
            return
        L18:
            r5 = move-exception
            goto L6b
        L1a:
            java.util.HashMap r1 = r4.f29707a     // Catch: java.lang.Throwable -> L18
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L18
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L18
            if (r1 == 0) goto L29
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L18
            goto L2c
        L29:
            r1 = 2147483647(0x7fffffff, float:NaN)
        L2c:
            int r2 = r4.f29713g     // Catch: java.lang.Throwable -> L18
            if (r1 <= r2) goto L37
            com.google.android.gms.internal.ads.zzemr r5 = r4.f29716j     // Catch: java.lang.Throwable -> L18
            r5.c(r6)     // Catch: java.lang.Throwable -> L18
            monitor-exit(r4)
            return
        L37:
            com.google.android.gms.internal.ads.zzems r2 = r4.f29712f     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L42
            com.google.android.gms.internal.ads.zzemr r2 = r4.f29716j     // Catch: java.lang.Throwable -> L18
            com.google.android.gms.internal.ads.zzfhr r3 = r4.f29717k     // Catch: java.lang.Throwable -> L18
            r2.c(r3)     // Catch: java.lang.Throwable -> L18
        L42:
            r4.f29713g = r1     // Catch: java.lang.Throwable -> L18
            r4.f29712f = r5     // Catch: java.lang.Throwable -> L18
            r4.f29717k = r6     // Catch: java.lang.Throwable -> L18
            monitor-enter(r4)     // Catch: java.lang.Throwable -> L18
            r5 = 1
            boolean r6 = r4.e(r5)     // Catch: java.lang.Throwable -> L59
            if (r6 != 0) goto L5b
            boolean r6 = r4.f()     // Catch: java.lang.Throwable -> L59
            if (r6 == 0) goto L57
            goto L5b
        L57:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L18
            goto L5d
        L59:
            r5 = move-exception
            goto L66
        L5b:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L18
            r0 = r5
        L5d:
            if (r0 != 0) goto L64
            r4.g()     // Catch: java.lang.Throwable -> L18
            monitor-exit(r4)
            return
        L64:
            monitor-exit(r4)
            return
        L66:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L59
            throw r5     // Catch: java.lang.Throwable -> L18
        L68:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L68
            throw r5     // Catch: java.lang.Throwable -> L18
        L6b:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L18
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemc.b(com.google.android.gms.internal.ads.zzems, com.google.android.gms.internal.ads.zzfhr):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002d A[Catch: all -> 0x0036, DONT_GENERATE, TryCatch #0 {, blocks: (B:4:0x0002, B:5:0x0010, B:7:0x0017, B:9:0x001a, B:16:0x0029, B:23:0x0031, B:20:0x002d, B:29:0x0039, B:34:0x003e, B:11:0x001c, B:13:0x0022, B:6:0x0011), top: B:37:0x0002, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void c(com.google.android.gms.internal.ads.zzfhr r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 0
            r2.f29718l = r0     // Catch: java.lang.Throwable -> L36
            java.util.ArrayList r1 = r2.f29710d     // Catch: java.lang.Throwable -> L36
            r1.remove(r3)     // Catch: java.lang.Throwable -> L36
            java.util.HashSet r1 = r2.f29711e     // Catch: java.lang.Throwable -> L36
            java.lang.String r3 = r3.t0     // Catch: java.lang.Throwable -> L36
            r1.remove(r3)     // Catch: java.lang.Throwable -> L36
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzgzf r3 = r2.f29709c     // Catch: java.lang.Throwable -> L3c
            boolean r3 = r3.isDone()     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L36
            if (r3 != 0) goto L3a
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L36
            r3 = 1
            boolean r1 = r2.e(r3)     // Catch: java.lang.Throwable -> L2b
            if (r1 != 0) goto L2d
            boolean r1 = r2.f()     // Catch: java.lang.Throwable -> L2b
            if (r1 == 0) goto L29
            goto L2d
        L29:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L36
            goto L2f
        L2b:
            r3 = move-exception
            goto L38
        L2d:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L36
            r0 = r3
        L2f:
            if (r0 != 0) goto L3a
            r2.g()     // Catch: java.lang.Throwable -> L36
            monitor-exit(r2)
            return
        L36:
            r3 = move-exception
            goto L3f
        L38:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2b
            throw r3     // Catch: java.lang.Throwable -> L36
        L3a:
            monitor-exit(r2)
            return
        L3c:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            throw r3     // Catch: java.lang.Throwable -> L36
        L3f:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L36
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemc.c(com.google.android.gms.internal.ads.zzfhr):void");
    }

    public final synchronized boolean d() {
        if (this.f29718l) {
            return false;
        }
        ArrayList arrayList = this.f29708b;
        if (!arrayList.isEmpty() && ((zzfhr) arrayList.get(0)).v0 && !this.f29710d.isEmpty()) {
            return false;
        }
        synchronized (this) {
            if (!this.f29709c.isDone()) {
                ArrayList arrayList2 = this.f29710d;
                if (arrayList2.size() < this.f29715i && e(false)) {
                    return true;
                }
            }
            return false;
        }
    }

    public final synchronized boolean e(boolean z) {
        try {
            Iterator it = this.f29708b.iterator();
            while (it.hasNext()) {
                zzfhr zzfhrVar = (zzfhr) it.next();
                Integer num = (Integer) this.f29707a.get(zzfhrVar);
                int iIntValue = num != null ? num.intValue() : Api.BaseClientBuilder.API_PRIORITY_OTHER;
                if (z || !this.f29711e.contains(zzfhrVar.t0)) {
                    int i2 = this.f29713g;
                    if (iIntValue < i2) {
                        return true;
                    }
                    if (iIntValue > i2) {
                        break;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean f() {
        try {
            Iterator it = this.f29710d.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) this.f29707a.get((zzfhr) it.next());
                if ((num != null ? num.intValue() : Api.BaseClientBuilder.API_PRIORITY_OTHER) < this.f29713g) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void g() {
        zzemr zzemrVar = this.f29716j;
        zzfhr zzfhrVar = this.f29717k;
        synchronized (zzemrVar) {
            try {
                zzemrVar.f29808h = zzemrVar.f29801a.elapsedRealtime() - zzemrVar.f29809i;
                if (zzfhrVar != null) {
                    zzemrVar.f29806f.a(zzfhrVar);
                }
                zzemrVar.f29807g = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        zzems zzemsVar = this.f29712f;
        if (zzemsVar != null) {
            this.f29709c.c(zzemsVar);
        } else {
            this.f29709c.d(new zzemv(3, this.f29714h));
        }
    }
}

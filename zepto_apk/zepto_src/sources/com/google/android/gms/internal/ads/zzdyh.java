package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class zzdyh {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f28791a = new ConcurrentHashMap();

    /* JADX WARN: Removed duplicated region for block: B:24:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a3 A[Catch: all -> 0x004c, TryCatch #0 {all -> 0x004c, blocks: (B:3:0x0001, B:8:0x0019, B:10:0x0038, B:12:0x003e, B:14:0x0047, B:18:0x004f, B:25:0x0075, B:29:0x00a3, B:31:0x00ad, B:32:0x00b5, B:33:0x00bc, B:35:0x00c2, B:36:0x00c6, B:38:0x00db, B:39:0x00e4, B:41:0x00ea, B:43:0x00f8, B:45:0x00fe, B:46:0x0110, B:48:0x0116, B:50:0x0128, B:52:0x0130, B:56:0x0141, B:58:0x0149, B:60:0x014f, B:62:0x0158, B:63:0x0161, B:26:0x0084, B:27:0x0093), top: B:70:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void a(long r8, long r10, int r12) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdyh.a(long, long, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            r9 = this;
            com.google.android.gms.ads.internal.zzt r0 = com.google.android.gms.ads.internal.zzt.C
            com.google.android.gms.common.util.Clock r0 = r0.f21687k
            long r0 = r0.currentTimeMillis()
            java.util.concurrent.ConcurrentHashMap r2 = r9.f28791a
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L12:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto La4
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.ads.zzdyk r4 = (com.google.android.gms.internal.ads.zzdyk) r4
            java.lang.Object r3 = r3.getValue()
            java.util.ArrayDeque r3 = (java.util.ArrayDeque) r3
            int r4 = r4.b()
            r5 = 0
            if (r4 == 0) goto L3b
            r7 = 1
            if (r4 == r7) goto L5f
            r7 = 2
            if (r4 == r7) goto L4e
            r7 = 3
            if (r4 == r7) goto L3d
        L3b:
            r7 = r5
            goto L6f
        L3d:
            com.google.android.gms.internal.ads.zzbgb r4 = com.google.android.gms.internal.ads.zzbgk.G8
            com.google.android.gms.ads.internal.client.zzbd r7 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r7 = r7.f21153c
            java.lang.Object r4 = r7.a(r4)
            java.lang.Long r4 = (java.lang.Long) r4
            long r7 = r4.longValue()
            goto L6f
        L4e:
            com.google.android.gms.internal.ads.zzbgb r4 = com.google.android.gms.internal.ads.zzbgk.F8
            com.google.android.gms.ads.internal.client.zzbd r7 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r7 = r7.f21153c
            java.lang.Object r4 = r7.a(r4)
            java.lang.Long r4 = (java.lang.Long) r4
            long r7 = r4.longValue()
            goto L6f
        L5f:
            com.google.android.gms.internal.ads.zzbgb r4 = com.google.android.gms.internal.ads.zzbgk.E8
            com.google.android.gms.ads.internal.client.zzbd r7 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r7 = r7.f21153c
            java.lang.Object r4 = r7.a(r4)
            java.lang.Long r4 = (java.lang.Long) r4
            long r7 = r4.longValue()
        L6f:
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 != 0) goto L77
            r2.remove()
            r7 = r5
        L77:
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 <= 0) goto L12
            java.util.Iterator r4 = r3.iterator()
        L7f:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L99
            java.lang.Object r5 = r4.next()
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = r0 - r5
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L99
            r4.remove()
            goto L7f
        L99:
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L12
            r2.remove()
            goto L12
        La4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdyh.b():void");
    }
}

package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Random;

/* loaded from: classes4.dex */
public final class zzpc implements zzpl {

    /* renamed from: h, reason: collision with root package name */
    public static final zzgqs f35290h = null;

    /* renamed from: i, reason: collision with root package name */
    public static final Random f35291i = new Random();

    /* renamed from: a, reason: collision with root package name */
    public final zzbe f35292a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbd f35293b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f35294c;

    /* renamed from: d, reason: collision with root package name */
    public zzpj f35295d;

    /* renamed from: e, reason: collision with root package name */
    public zzbf f35296e;

    /* renamed from: f, reason: collision with root package name */
    public String f35297f;

    /* renamed from: g, reason: collision with root package name */
    public long f35298g;

    public zzpc() {
        throw null;
    }

    public final synchronized String a(zzbf zzbfVar, zzwg zzwgVar) {
        return e(zzbfVar.o(zzwgVar.f35758a, this.f35293b).f24739c, zzwgVar).f35283a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0028 A[Catch: all -> 0x004c, TryCatch #0 {all -> 0x004c, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x0021, B:16:0x002d, B:18:0x0033, B:20:0x003f, B:22:0x0045, B:15:0x0028, B:27:0x004f, B:29:0x0059, B:32:0x0060, B:34:0x0066, B:36:0x0079, B:37:0x0097, B:39:0x009b, B:40:0x009d, B:42:0x00a7, B:44:0x00ab, B:46:0x00b8, B:49:0x00bf, B:55:0x00dc), top: B:58:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004f A[Catch: all -> 0x004c, TryCatch #0 {all -> 0x004c, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x0021, B:16:0x002d, B:18:0x0033, B:20:0x003f, B:22:0x0045, B:15:0x0028, B:27:0x004f, B:29:0x0059, B:32:0x0060, B:34:0x0066, B:36:0x0079, B:37:0x0097, B:39:0x009b, B:40:0x009d, B:42:0x00a7, B:44:0x00ab, B:46:0x00b8, B:49:0x00bf, B:55:0x00dc), top: B:58:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void b(com.google.android.gms.internal.ads.zzmv r10) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpc.b(com.google.android.gms.internal.ads.zzmv):void");
    }

    public final void c(zzmv zzmvVar) {
        zzwg zzwgVar;
        boolean zG = zzmvVar.f35233b.g();
        HashMap map = this.f35294c;
        if (zG) {
            String str = this.f35297f;
            if (str != null) {
                zzpb zzpbVar = (zzpb) map.get(str);
                zzpbVar.getClass();
                d(zzpbVar);
                return;
            }
            return;
        }
        zzpb zzpbVar2 = (zzpb) map.get(this.f35297f);
        int i2 = zzmvVar.f35234c;
        zzwg zzwgVar2 = zzmvVar.f35235d;
        this.f35297f = e(i2, zzwgVar2).f35283a;
        b(zzmvVar);
        if (zzwgVar2 == null || !zzwgVar2.b()) {
            return;
        }
        long j2 = zzwgVar2.f35761d;
        if (zzpbVar2 != null && zzpbVar2.f35285c == j2 && (zzwgVar = zzpbVar2.f35286d) != null) {
            if (zzwgVar.f35759b == zzwgVar2.f35759b) {
                if (zzwgVar.f35760c == zzwgVar2.f35760c) {
                    return;
                }
            }
        }
        e(i2, new zzwg(j2, zzwgVar2.f35758a));
    }

    public final void d(zzpb zzpbVar) {
        long j2 = zzpbVar.f35285c;
        if (j2 != -1) {
            this.f35298g = j2;
        }
        this.f35297f = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0099 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzpb e(int r18, com.google.android.gms.internal.ads.zzwg r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            java.util.HashMap r3 = r0.f35294c
            java.util.Collection r4 = r3.values()
            java.util.Iterator r4 = r4.iterator()
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r7 = 0
        L16:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L9d
            java.lang.Object r8 = r4.next()
            com.google.android.gms.internal.ads.zzpb r8 = (com.google.android.gms.internal.ads.zzpb) r8
            long r9 = r8.f35285c
            r11 = -1
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 != 0) goto L52
            int r9 = r8.f35284b
            if (r1 != r9) goto L52
            if (r2 == 0) goto L52
            com.google.android.gms.internal.ads.zzpc r9 = r8.f35289g
            java.util.HashMap r10 = r9.f35294c
            java.lang.String r13 = r9.f35297f
            java.lang.Object r10 = r10.get(r13)
            com.google.android.gms.internal.ads.zzpb r10 = (com.google.android.gms.internal.ads.zzpb) r10
            if (r10 == 0) goto L45
            long r13 = r10.f35285c
            int r10 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r10 == 0) goto L45
            goto L4a
        L45:
            long r9 = r9.f35298g
            r13 = 1
            long r13 = r13 + r9
        L4a:
            long r9 = r2.f35761d
            int r13 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r13 < 0) goto L52
            r8.f35285c = r9
        L52:
            com.google.android.gms.internal.ads.zzwg r9 = r8.f35286d
            if (r2 != 0) goto L5c
            int r10 = r8.f35284b
            if (r1 != r10) goto L16
            r15 = r11
            goto L81
        L5c:
            long r13 = r2.f35761d
            if (r9 != 0) goto L6e
            boolean r10 = r2.b()
            if (r10 != 0) goto L16
            r15 = r11
            long r11 = r8.f35285c
            int r10 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r10 != 0) goto L16
            goto L81
        L6e:
            r15 = r11
            long r10 = r9.f35761d
            int r10 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r10 != 0) goto L16
            int r10 = r2.f35759b
            int r11 = r9.f35759b
            if (r10 != r11) goto L16
            int r10 = r2.f35760c
            int r11 = r9.f35760c
            if (r10 != r11) goto L16
        L81:
            long r10 = r8.f35285c
            int r12 = (r10 > r15 ? 1 : (r10 == r15 ? 0 : -1))
            if (r12 == 0) goto L99
            int r12 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r12 >= 0) goto L8c
            goto L99
        L8c:
            if (r12 != 0) goto L16
            java.lang.String r10 = com.google.android.gms.internal.ads.zzfj.f31254a
            com.google.android.gms.internal.ads.zzwg r10 = r7.f35286d
            if (r10 == 0) goto L16
            if (r9 == 0) goto L16
            r7 = r8
            goto L16
        L99:
            r7 = r8
            r5 = r10
            goto L16
        L9d:
            if (r7 != 0) goto Lb7
            r4 = 12
            byte[] r4 = new byte[r4]
            java.util.Random r5 = com.google.android.gms.internal.ads.zzpc.f35291i
            r5.nextBytes(r4)
            r5 = 10
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r5)
            com.google.android.gms.internal.ads.zzpb r5 = new com.google.android.gms.internal.ads.zzpb
            r5.<init>(r0, r4, r1, r2)
            r3.put(r4, r5)
            return r5
        Lb7:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpc.e(int, com.google.android.gms.internal.ads.zzwg):com.google.android.gms.internal.ads.zzpb");
    }

    public zzpc(int i2) {
        this.f35292a = new zzbe();
        this.f35293b = new zzbd();
        this.f35294c = new HashMap();
        this.f35296e = zzbf.f24868a;
        this.f35298g = -1L;
    }
}

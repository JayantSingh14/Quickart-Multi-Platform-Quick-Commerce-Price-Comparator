package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* loaded from: classes4.dex */
public final class zzauo implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f24401a;

    public zzauo(boolean z) {
        this.f24401a = z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009f A[RETURN] */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int compare(java.lang.Object r13, java.lang.Object r14) {
        /*
            r12 = this;
            r0 = 496612959(0x1d99b65f, float:4.068733E-21)
            r1 = 9
            int[] r1 = new int[r1]
            r1 = {x00ca: FILL_ARRAY_DATA , data: [446703183, 1862618146, 1081639777, -1087935358, -803036955, 1104011716, 5522510, 2017461929, 496612959} // fill-array
            r2 = 0
            r3 = r1[r2]
            r4 = 1
            r5 = r1[r4]
            r6 = 2
            r6 = r1[r6]
            r7 = 3
            r7 = r1[r7]
            r8 = 4
            r8 = r1[r8]
            r9 = 5
            r9 = r1[r9]
            r10 = 6
            r10 = r1[r10]
            r11 = 7
            r1 = r1[r11]
            int r11 = ~r3
            r5 = r5 & r11
            r5 = r5 | r6
            r3 = r3 & r7
            r3 = r3 | r8
            int r3 = android.support.v4.media.a.A(r5, r3, r9, r10)
            int r1 = r1 % r0
            com.google.android.gms.internal.ads.zzaus r13 = (com.google.android.gms.internal.ads.zzaus) r13
            com.google.android.gms.internal.ads.zzaus r14 = (com.google.android.gms.internal.ads.zzaus) r14
            int r0 = r13.f24409g
            int r5 = r14.f24409g
            if (r0 != r5) goto Lb4
            r1 = r1 ^ r3
            if (r0 == 0) goto La6
            int r0 = r0 + r1
            boolean r1 = r12.f24401a
            switch(r0) {
                case 1: goto L92;
                case 2: goto L85;
                case 3: goto L74;
                case 4: goto L62;
                case 5: goto L4f;
                case 6: goto L40;
                default: goto L3f;
            }
        L3f:
            goto L9f
        L40:
            double r0 = r13.q()     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            double r13 = r14.q()     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            int r13 = java.lang.Double.compare(r0, r13)     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            return r13
        L4d:
            r13 = move-exception
            goto La8
        L4f:
            if (r1 == 0) goto L5c
            com.google.android.gms.internal.ads.zzauk r13 = r13.p()     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            com.google.android.gms.internal.ads.zzauk r14 = r14.p()     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            if (r13 == r14) goto L9f
            goto L9e
        L5c:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            r13.<init>()     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            throw r13     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
        L62:
            java.util.List r13 = r13.o()     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            java.util.List r14 = r14.o()     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            com.google.android.gms.internal.ads.zzgtx r0 = new com.google.android.gms.internal.ads.zzgtx     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            r0.<init>(r12)     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            int r13 = r0.compare(r13, r14)     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            return r13
        L74:
            java.util.Comparator r0 = com.google.android.gms.internal.ads.zzatw.f24366c     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            com.google.android.gms.internal.ads.zzatw r13 = r13.n()     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            com.google.android.gms.internal.ads.zzatw r14 = r14.n()     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            com.google.android.gms.internal.ads.zzatv r0 = (com.google.android.gms.internal.ads.zzatv) r0     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            int r13 = r0.compare(r13, r14)     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            return r13
        L85:
            long r0 = r13.m()     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            long r13 = r14.m()     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            int r13 = java.lang.Long.compare(r0, r13)     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            return r13
        L92:
            if (r1 == 0) goto La0
            java.lang.Object r13 = r13.l()     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            java.lang.Object r14 = r14.l()     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            if (r13 == r14) goto L9f
        L9e:
            return r4
        L9f:
            return r2
        La0:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            r13.<init>()     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
            throw r13     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
        La6:
            r13 = 0
            throw r13     // Catch: com.google.android.gms.internal.ads.zzaup -> L4d
        La8:
            java.lang.AssertionError r14 = new java.lang.AssertionError
            java.lang.String r0 = "CEiv6BFfPnitUE+D"
            java.lang.String r0 = com.google.android.gms.internal.ads.zzatu.a(r0)
            r14.<init>(r0, r13)
            throw r14
        Lb4:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            r13.<init>()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauo.compare(java.lang.Object, java.lang.Object):int");
    }
}

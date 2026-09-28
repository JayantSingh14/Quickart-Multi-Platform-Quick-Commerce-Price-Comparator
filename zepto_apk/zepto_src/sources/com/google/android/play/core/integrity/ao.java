package com.google.android.play.core.integrity;

/* loaded from: classes4.dex */
final class ao extends IntegrityTokenRequest {

    /* renamed from: a, reason: collision with root package name */
    public final String f41786a;

    /* renamed from: b, reason: collision with root package name */
    public final Long f41787b;

    public /* synthetic */ ao(String str, Long l2) {
        this.f41786a = str;
        this.f41787b = l2;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest
    public final Long a() {
        return this.f41787b;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest
    public final String b() {
        return this.f41786a;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L4
            return r0
        L4:
            boolean r1 = r6 instanceof com.google.android.play.core.integrity.IntegrityTokenRequest
            r2 = 0
            if (r1 == 0) goto L24
            r1 = r6
            com.google.android.play.core.integrity.IntegrityTokenRequest r1 = (com.google.android.play.core.integrity.IntegrityTokenRequest) r1
            java.lang.String r3 = r1.b()
            java.lang.String r4 = r5.f41786a
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L24
            java.lang.Long r3 = r5.f41787b
            if (r3 != 0) goto L26
            java.lang.Long r1 = r1.a()
            if (r1 != 0) goto L24
        L22:
            r1 = r0
            goto L31
        L24:
            r1 = r2
            goto L31
        L26:
            java.lang.Long r1 = r1.a()
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L24
            goto L22
        L31:
            boolean r3 = r6 instanceof com.google.android.play.core.integrity.ao
            if (r3 == 0) goto L3e
            com.google.android.play.core.integrity.ao r6 = (com.google.android.play.core.integrity.ao) r6
            if (r1 == 0) goto L3d
            r6.getClass()
            return r0
        L3d:
            return r2
        L3e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.integrity.ao.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int iHashCode = this.f41786a.hashCode() ^ 1000003;
        Long l2 = this.f41787b;
        return ((iHashCode * 1000003) ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
    }

    public final String toString() {
        return ("IntegrityTokenRequest{nonce=" + this.f41786a + ", cloudProjectNumber=" + this.f41787b).concat(", network=null").concat("}");
    }
}

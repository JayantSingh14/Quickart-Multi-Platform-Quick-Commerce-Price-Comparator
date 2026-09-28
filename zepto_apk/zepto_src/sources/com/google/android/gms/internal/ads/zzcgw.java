package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcgw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f26210a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f26211b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f26212c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f26213d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzcgx f26214e;

    public zzcgw(zzcgx zzcgxVar, String str, String str2, String str3, String str4) {
        this.f26210a = str;
        this.f26211b = str2;
        this.f26212c = str3;
        this.f26213d = str4;
        Objects.requireNonNull(zzcgxVar);
        this.f26214e = zzcgxVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a9  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r4 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "event"
            java.lang.String r2 = "precacheCanceled"
            r0.put(r1, r2)
            java.lang.String r1 = "src"
            java.lang.String r2 = r4.f26210a
            r0.put(r1, r2)
            java.lang.String r1 = r4.f26211b
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L20
            java.lang.String r2 = "cachedSrc"
            r0.put(r2, r1)
        L20:
            java.lang.String r1 = r4.f26212c
            int r2 = r1.hashCode()
            switch(r2) {
                case -1947652542: goto L9f;
                case -1396664534: goto L94;
                case -1347010958: goto L8a;
                case -918817863: goto L7f;
                case -659376217: goto L75;
                case -642208130: goto L6b;
                case -354048396: goto L60;
                case -32082395: goto L55;
                case 3387234: goto L4b;
                case 96784904: goto L41;
                case 580119100: goto L36;
                case 725497484: goto L2b;
                default: goto L29;
            }
        L29:
            goto La9
        L2b:
            java.lang.String r2 = "noCacheDir"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto La9
            r2 = 7
            goto Laa
        L36:
            java.lang.String r2 = "expireFailed"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto La9
            r2 = 6
            goto Laa
        L41:
            java.lang.String r2 = "error"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto La9
            r2 = 1
            goto Laa
        L4b:
            java.lang.String r2 = "noop"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto La9
            r2 = 4
            goto Laa
        L55:
            java.lang.String r2 = "externalAbort"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto La9
            r2 = 10
            goto Laa
        L60:
            java.lang.String r2 = "sizeExceeded"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto La9
            r2 = 11
            goto Laa
        L6b:
            java.lang.String r2 = "playerFailed"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto La9
            r2 = 5
            goto Laa
        L75:
            java.lang.String r2 = "contentLengthMissing"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto La9
            r2 = 0
            goto Laa
        L7f:
            java.lang.String r2 = "downloadTimeout"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto La9
            r2 = 9
            goto Laa
        L8a:
            java.lang.String r2 = "inProgress"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto La9
            r2 = 2
            goto Laa
        L94:
            java.lang.String r2 = "badUrl"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto La9
            r2 = 8
            goto Laa
        L9f:
            java.lang.String r2 = "interrupted"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto La9
            r2 = 3
            goto Laa
        La9:
            r2 = -1
        Laa:
            switch(r2) {
                case 6: goto Lb6;
                case 7: goto Lb6;
                case 8: goto Lb3;
                case 9: goto Lb3;
                case 10: goto Lb0;
                case 11: goto Lb0;
                default: goto Lad;
            }
        Lad:
            java.lang.String r2 = "internal"
            goto Lb8
        Lb0:
            java.lang.String r2 = "policy"
            goto Lb8
        Lb3:
            java.lang.String r2 = "network"
            goto Lb8
        Lb6:
            java.lang.String r2 = "io"
        Lb8:
            java.lang.String r3 = "type"
            r0.put(r3, r2)
            java.lang.String r2 = "reason"
            r0.put(r2, r1)
            java.lang.String r1 = r4.f26213d
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto Lcf
            java.lang.String r2 = "message"
            r0.put(r2, r1)
        Lcf:
            com.google.android.gms.internal.ads.zzcgx r1 = r4.f26214e
            r1.r(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcgw.run():void");
    }
}

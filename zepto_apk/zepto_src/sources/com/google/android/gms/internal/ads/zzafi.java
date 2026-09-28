package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzafi {

    /* renamed from: a, reason: collision with root package name */
    public final zzer f22936a = new zzer(10);

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
    
        r7 = 6;
        r10.G(6);
        r8 = r10.g();
        r14 = r8 + 10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0050, code lost:
    
        if (r6 != null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
    
        r6 = new byte[r14];
        java.lang.System.arraycopy(r10.f30144a, r12, r6, 0, r2);
        r18.t(r6, r2, r8, false);
        new com.google.android.gms.internal.ads.zzahp();
        r8 = com.google.android.gms.internal.ads.zzaif.f23183a;
        r8 = new java.util.ArrayList();
        r10 = new com.google.android.gms.internal.ads.zzer(r6, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0075, code lost:
    
        if (r10.B() >= r2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0077, code lost:
    
        com.google.android.gms.internal.ads.zzee.c("Id3Decoder", "Data too short to be an ID3 tag");
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007c, code lost:
    
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007f, code lost:
    
        r6 = r10.O();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0083, code lost:
    
        if (r6 == 4801587) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0085, code lost:
    
        com.google.android.gms.internal.ads.zzee.c("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x".concat(java.lang.String.format("%06X", java.lang.Integer.valueOf(r6))));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009d, code lost:
    
        r6 = r10.K();
        r10.G(1);
        r13 = r10.K();
        r16 = r10.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ac, code lost:
    
        if (r6 != 2) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b0, code lost:
    
        if ((r13 & 64) == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b2, code lost:
    
        com.google.android.gms.internal.ads.zzee.c("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b8, code lost:
    
        if (r6 != 3) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bc, code lost:
    
        if ((r13 & 64) == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00be, code lost:
    
        r11 = r10.b();
        r10.G(r11);
        r16 = r16 - (r11 + 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c8, code lost:
    
        r2 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cb, code lost:
    
        if (r6 != 4) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cf, code lost:
    
        if ((r13 & 64) == 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d1, code lost:
    
        r11 = r10.g();
        r10.G(r11 - 4);
        r16 = r16 - r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00de, code lost:
    
        if ((r13 & 16) == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e0, code lost:
    
        r16 = r16 - 10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e3, code lost:
    
        if (r6 >= 4) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e7, code lost:
    
        if ((r13 & 128) == 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e9, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00eb, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ec, code lost:
    
        r13 = new com.google.android.gms.internal.ads.zzaie(r6, r2, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f2, code lost:
    
        com.google.android.gms.internal.ads.b.d(new java.lang.StringBuilder(java.lang.String.valueOf(r6).length() + 46), "Skipped ID3 tag with unsupported majorVersion=", r6, "Id3Decoder");
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0108, code lost:
    
        if (r13 != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x010a, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x010e, code lost:
    
        r2 = r10.f30145b;
        r6 = r13.f23180a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0112, code lost:
    
        if (r6 != 2) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0115, code lost:
    
        r7 = 10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0117, code lost:
    
        r11 = r13.f23181b;
        r12 = r13.f23182c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x011b, code lost:
    
        if (r11 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x011d, code lost:
    
        r12 = com.google.android.gms.internal.ads.zzaif.d(r12, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0121, code lost:
    
        r10.C(r2 + r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0129, code lost:
    
        if (com.google.android.gms.internal.ads.zzaif.a(r10, r6, r7, false) != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x012b, code lost:
    
        if (r6 != 4) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0131, code lost:
    
        if (com.google.android.gms.internal.ads.zzaif.a(r10, 4, r7, true) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0133, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0135, code lost:
    
        com.google.android.gms.internal.ads.b.d(new java.lang.StringBuilder(java.lang.String.valueOf(r6).length() + 45), "Failed to validate ID3 tag with majorVersion=", r6, "Id3Decoder");
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x014a, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x014f, code lost:
    
        if (r10.B() < r7) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0151, code lost:
    
        r11 = com.google.android.gms.internal.ads.zzaif.b(r6, r10, r2, r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0157, code lost:
    
        if (r11 == null) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0159, code lost:
    
        r8.add(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x015d, code lost:
    
        r6 = new com.google.android.gms.internal.ads.zzap(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0166, code lost:
    
        r18.f(r8, false);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzap a(com.google.android.gms.internal.ads.zzaef r18, com.google.android.gms.internal.ads.zzaic r19, int r20) {
        /*
            Method dump skipped, instructions count: 447
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafi.a(com.google.android.gms.internal.ads.zzaef, com.google.android.gms.internal.ads.zzaic, int):com.google.android.gms.internal.ads.zzap");
    }
}

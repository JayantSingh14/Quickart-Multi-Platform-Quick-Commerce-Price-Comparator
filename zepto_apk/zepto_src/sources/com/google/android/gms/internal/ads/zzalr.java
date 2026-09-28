package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzalr implements zzalw {
    @Override // com.google.android.gms.internal.ads.zzalw
    public final boolean a(zzv zzvVar) {
        String str = zzvVar.f35691m;
        return Objects.equals(str, "text/x-ssa") || Objects.equals(str, "text/vtt") || Objects.equals(str, "application/x-mp4-vtt") || Objects.equals(str, "application/x-subrip") || Objects.equals(str, "application/x-quicktime-tx3g") || Objects.equals(str, "application/pgs") || Objects.equals(str, "application/vobsub") || Objects.equals(str, "application/dvbsubs") || Objects.equals(str, "application/ttml+xml");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    @Override // com.google.android.gms.internal.ads.zzalw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(com.google.android.gms.internal.ads.zzv r4) {
        /*
            r3 = this;
            java.lang.String r4 = r4.f35691m
            if (r4 == 0) goto L73
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 2
            switch(r0) {
                case -1351681404: goto L5f;
                case -1248334819: goto L55;
                case -1026075066: goto L4b;
                case -1004728940: goto L41;
                case 691401887: goto L37;
                case 822864842: goto L2d;
                case 1157994102: goto L23;
                case 1668750253: goto L19;
                case 1693976202: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L69
        Le:
            java.lang.String r0 = "application/ttml+xml"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L69
            r0 = 8
            goto L6a
        L19:
            java.lang.String r0 = "application/x-subrip"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L69
            r0 = 3
            goto L6a
        L23:
            java.lang.String r0 = "application/vobsub"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L69
            r0 = 6
            goto L6a
        L2d:
            java.lang.String r0 = "text/x-ssa"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L69
            r0 = 0
            goto L6a
        L37:
            java.lang.String r0 = "application/x-quicktime-tx3g"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L69
            r0 = 4
            goto L6a
        L41:
            java.lang.String r0 = "text/vtt"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L69
            r0 = r1
            goto L6a
        L4b:
            java.lang.String r0 = "application/x-mp4-vtt"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L69
            r0 = r2
            goto L6a
        L55:
            java.lang.String r0 = "application/pgs"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L69
            r0 = 5
            goto L6a
        L5f:
            java.lang.String r0 = "application/dvbsubs"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L69
            r0 = 7
            goto L6a
        L69:
            r0 = -1
        L6a:
            switch(r0) {
                case 0: goto L72;
                case 1: goto L72;
                case 2: goto L71;
                case 3: goto L70;
                case 4: goto L6f;
                case 5: goto L6f;
                case 6: goto L6f;
                case 7: goto L6f;
                case 8: goto L6e;
                default: goto L6d;
            }
        L6d:
            goto L73
        L6e:
            return r1
        L6f:
            return r2
        L70:
            return r1
        L71:
            return r2
        L72:
            return r1
        L73:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r1 = "Unsupported MIME type: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalr.b(com.google.android.gms.internal.ads.zzv):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    @Override // com.google.android.gms.internal.ads.zzalw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzaly c(com.google.android.gms.internal.ads.zzv r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.f35691m
            if (r0 == 0) goto La4
            int r1 = r0.hashCode()
            switch(r1) {
                case -1351681404: goto L5d;
                case -1248334819: goto L53;
                case -1026075066: goto L49;
                case -1004728940: goto L3f;
                case 691401887: goto L35;
                case 822864842: goto L2b;
                case 1157994102: goto L21;
                case 1668750253: goto L17;
                case 1693976202: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L67
        Lc:
            java.lang.String r1 = "application/ttml+xml"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L67
            r1 = 8
            goto L68
        L17:
            java.lang.String r1 = "application/x-subrip"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L67
            r1 = 3
            goto L68
        L21:
            java.lang.String r1 = "application/vobsub"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L67
            r1 = 6
            goto L68
        L2b:
            java.lang.String r1 = "text/x-ssa"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L67
            r1 = 0
            goto L68
        L35:
            java.lang.String r1 = "application/x-quicktime-tx3g"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L67
            r1 = 4
            goto L68
        L3f:
            java.lang.String r1 = "text/vtt"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L67
            r1 = 1
            goto L68
        L49:
            java.lang.String r1 = "application/x-mp4-vtt"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L67
            r1 = 2
            goto L68
        L53:
            java.lang.String r1 = "application/pgs"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L67
            r1 = 5
            goto L68
        L5d:
            java.lang.String r1 = "application/dvbsubs"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L67
            r1 = 7
            goto L68
        L67:
            r1 = -1
        L68:
            java.util.List r3 = r3.p
            switch(r1) {
                case 0: goto L9e;
                case 1: goto L98;
                case 2: goto L92;
                case 3: goto L8c;
                case 4: goto L86;
                case 5: goto L80;
                case 6: goto L7a;
                case 7: goto L74;
                case 8: goto L6e;
                default: goto L6d;
            }
        L6d:
            goto La4
        L6e:
            com.google.android.gms.internal.ads.zzamy r3 = new com.google.android.gms.internal.ads.zzamy
            r3.<init>()
            return r3
        L74:
            com.google.android.gms.internal.ads.zzamk r0 = new com.google.android.gms.internal.ads.zzamk
            r0.<init>(r3)
            return r0
        L7a:
            com.google.android.gms.internal.ads.zzanf r0 = new com.google.android.gms.internal.ads.zzanf
            r0.<init>(r3)
            return r0
        L80:
            com.google.android.gms.internal.ads.zzamm r3 = new com.google.android.gms.internal.ads.zzamm
            r3.<init>()
            return r3
        L86:
            com.google.android.gms.internal.ads.zzand r0 = new com.google.android.gms.internal.ads.zzand
            r0.<init>(r3)
            return r0
        L8c:
            com.google.android.gms.internal.ads.zzams r3 = new com.google.android.gms.internal.ads.zzams
            r3.<init>()
            return r3
        L92:
            com.google.android.gms.internal.ads.zzang r3 = new com.google.android.gms.internal.ads.zzang
            r3.<init>()
            return r3
        L98:
            com.google.android.gms.internal.ads.zzanq r3 = new com.google.android.gms.internal.ads.zzanq
            r3.<init>()
            return r3
        L9e:
            com.google.android.gms.internal.ads.zzamo r0 = new com.google.android.gms.internal.ads.zzamo
            r0.<init>(r3)
            return r0
        La4:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Unsupported MIME type: "
            java.lang.String r0 = r1.concat(r0)
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalr.c(com.google.android.gms.internal.ads.zzv):com.google.android.gms.internal.ads.zzaly");
    }
}

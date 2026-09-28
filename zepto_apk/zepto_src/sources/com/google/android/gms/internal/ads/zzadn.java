package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzadn {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f22803a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f22804b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d5, code lost:
    
        if (r11 != 3) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzadm a(com.google.android.gms.internal.ads.zzeq r11, boolean r12) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadn.a(com.google.android.gms.internal.ads.zzeq, boolean):com.google.android.gms.internal.ads.zzadm");
    }

    public static int b(zzeq zzeqVar) throws zzat {
        int iH = zzeqVar.h(4);
        if (iH == 15) {
            if (zzeqVar.b() >= 24) {
                return zzeqVar.h(24);
            }
            throw zzat.a(null, "AAC header insufficient data");
        }
        if (iH < 13) {
            return f22803a[iH];
        }
        throw zzat.a(null, "AAC header wrong Sampling Frequency Index");
    }
}

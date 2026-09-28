package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import java.util.HashMap;
import java.util.Objects;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes4.dex */
public final class zzuj {

    /* renamed from: a, reason: collision with root package name */
    public final String f35645a;

    /* renamed from: b, reason: collision with root package name */
    public final String f35646b;

    /* renamed from: c, reason: collision with root package name */
    public final String f35647c;

    /* renamed from: d, reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f35648d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f35649e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f35650f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f35651g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f35652h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f35653i;

    /* renamed from: j, reason: collision with root package name */
    public int f35654j;

    /* renamed from: k, reason: collision with root package name */
    public int f35655k;

    /* renamed from: l, reason: collision with root package name */
    public float f35656l;

    public zzuj(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4) {
        str.getClass();
        this.f35645a = str;
        this.f35646b = str2;
        this.f35647c = str3;
        this.f35648d = codecCapabilities;
        this.f35651g = z;
        this.f35649e = z2;
        this.f35650f = z3;
        this.f35652h = z4;
        this.f35653i = zzas.b(str2);
        this.f35656l = -3.4028235E38f;
        this.f35654j = -1;
        this.f35655k = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzuj a(java.lang.String r9, java.lang.String r10, java.lang.String r11, android.media.MediaCodecInfo.CodecCapabilities r12, boolean r13, boolean r14) {
        /*
            com.google.android.gms.internal.ads.zzuj r0 = new com.google.android.gms.internal.ads.zzuj
            r1 = 1
            r2 = 0
            if (r12 == 0) goto L10
            java.lang.String r3 = "adaptive-playback"
            boolean r3 = r12.isFeatureSupported(r3)
            if (r3 == 0) goto L10
            r6 = r1
            goto L11
        L10:
            r6 = r2
        L11:
            if (r12 == 0) goto L18
            java.lang.String r3 = "tunneled-playback"
            r12.isFeatureSupported(r3)
        L18:
            if (r14 != 0) goto L24
            if (r12 == 0) goto L26
            java.lang.String r14 = "secure-playback"
            boolean r14 = r12.isFeatureSupported(r14)
            if (r14 == 0) goto L26
        L24:
            r7 = r1
            goto L27
        L26:
            r7 = r2
        L27:
            int r14 = android.os.Build.VERSION.SDK_INT
            r3 = 35
            if (r14 < r3) goto L61
            if (r12 == 0) goto L61
            java.lang.String r14 = "detached-surface"
            boolean r14 = r12.isFeatureSupported(r14)
            if (r14 == 0) goto L61
            java.lang.String r14 = android.os.Build.MANUFACTURER
            java.lang.String r3 = "Xiaomi"
            boolean r3 = r14.equals(r3)
            if (r3 != 0) goto L61
            java.lang.String r3 = "OPPO"
            boolean r3 = r14.equals(r3)
            if (r3 != 0) goto L61
            java.lang.String r3 = "realme"
            boolean r3 = r14.equals(r3)
            if (r3 != 0) goto L61
            java.lang.String r3 = "motorola"
            boolean r3 = r14.equals(r3)
            if (r3 != 0) goto L61
            java.lang.String r3 = "LENOVO"
            boolean r14 = r14.equals(r3)
            if (r14 == 0) goto L68
        L61:
            r1 = r9
            r3 = r11
            r4 = r12
            r5 = r13
            r8 = r2
            r2 = r10
            goto L6e
        L68:
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r8 = r1
            r1 = r9
        L6e:
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuj.a(java.lang.String, java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean):com.google.android.gms.internal.ads.zzuj");
    }

    public static boolean i(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        Point pointJ = j(videoCapabilities, i2, i3);
        int i4 = pointJ.x;
        int i5 = pointJ.y;
        if (d2 == -1.0d || d2 < 1.0d) {
            return videoCapabilities.isSizeSupported(i4, i5);
        }
        double dFloor = Math.floor(d2);
        if (!videoCapabilities.areSizeAndRateSupported(i4, i5, dFloor)) {
            return false;
        }
        Range<Double> achievableFrameRatesFor = videoCapabilities.getAchievableFrameRatesFor(i4, i5);
        return achievableFrameRatesFor == null || dFloor <= ((Double) achievableFrameRatesFor.getUpper()).doubleValue();
    }

    public static Point j(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        String str = zzfj.f31254a;
        return new Point((((i2 + widthAlignment) - 1) / widthAlignment) * widthAlignment, (((i3 + heightAlignment) - 1) / heightAlignment) * heightAlignment);
    }

    public final boolean b(zzv zzvVar) {
        int i2;
        String str = zzvVar.f35691m;
        String str2 = this.f35646b;
        if (!(str2.equals(str) || str2.equals(zzvc.c(zzvVar))) || !f(zzvVar, true) || !g(zzvVar)) {
            return false;
        }
        if (this.f35653i) {
            int i3 = zzvVar.t;
            if (i3 > 0 && (i2 = zzvVar.u) > 0) {
                return e(i3, i2, zzvVar.x);
            }
        } else {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.f35648d;
            int i4 = zzvVar.F;
            if (i4 != -1) {
                if (codecCapabilities == null) {
                    h("sampleRate.caps");
                    return false;
                }
                MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
                if (audioCapabilities == null) {
                    h("sampleRate.aCaps");
                    return false;
                }
                if (!audioCapabilities.isSampleRateSupported(i4)) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 20);
                    sb.append("sampleRate.support, ");
                    sb.append(i4);
                    h(sb.toString());
                    return false;
                }
            }
            int i5 = zzvVar.E;
            if (i5 != -1) {
                if (codecCapabilities == null) {
                    h("channelCount.caps");
                    return false;
                }
                MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities.getAudioCapabilities();
                if (audioCapabilities2 == null) {
                    h("channelCount.aCaps");
                    return false;
                }
                int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                if (maxInputChannelCount <= 1 && ((Build.VERSION.SDK_INT < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2))) {
                    int i6 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
                    String str3 = this.f35645a;
                    StringBuilder sb2 = new StringBuilder(androidx.fragment.app.e.C(String.valueOf(maxInputChannelCount).length() + str3.length() + 32 + 4, 1, String.valueOf(i6)));
                    sb2.append("AssumedMaxChannelAdjustment: ");
                    sb2.append(str3);
                    sb2.append(", [");
                    sb2.append(maxInputChannelCount);
                    sb2.append(" to ");
                    sb2.append(i6);
                    sb2.append("]");
                    zzee.c("MediaCodecInfo", sb2.toString());
                    maxInputChannelCount = i6;
                }
                if (maxInputChannelCount < i5) {
                    StringBuilder sb3 = new StringBuilder(String.valueOf(i5).length() + 22);
                    sb3.append("channelCount.support, ");
                    sb3.append(i5);
                    h(sb3.toString());
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean c(zzv zzvVar) {
        if (this.f35653i) {
            return this.f35649e;
        }
        HashMap map = zzvc.f35693a;
        Pair pairB = zzdo.b(zzvVar);
        return pairB != null && ((Integer) pairB.first).intValue() == 42;
    }

    public final zzil d(zzv zzvVar, zzv zzvVar2) {
        zzv zzvVar3;
        zzv zzvVar4;
        int i2;
        String str = zzvVar.f35691m;
        String str2 = zzvVar2.f35691m;
        int i3 = true != Objects.equals(str, str2) ? 8 : 0;
        if (this.f35653i) {
            if (zzvVar.y != zzvVar2.y) {
                i3 |= 1024;
            }
            boolean z = (zzvVar.t == zzvVar2.t && zzvVar.u == zzvVar2.u) ? false : true;
            if (!this.f35649e && z) {
                i3 |= 512;
            }
            zzi zziVar = zzvVar.C;
            boolean zA = zzi.a(zziVar);
            zzi zziVar2 = zzvVar2.C;
            if ((!zA || !zzi.a(zziVar2)) && !Objects.equals(zziVar, zziVar2)) {
                i3 |= 2048;
            }
            boolean zStartsWith = Build.MODEL.startsWith("SM-T230");
            String str3 = this.f35645a;
            if (zStartsWith && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str3) && !zzvVar.b(zzvVar2)) {
                i3 |= 2;
            }
            int i4 = zzvVar.v;
            if (i4 != -1 && (i2 = zzvVar.w) != -1 && i4 == zzvVar2.v && i2 == zzvVar2.w && z) {
                i3 |= 2;
            }
            if (i3 == 0 && Objects.equals(str2, "video/dolby-vision")) {
                Pair pairB = zzdo.b(zzvVar);
                Pair pairB2 = zzdo.b(zzvVar2);
                if (pairB == null || pairB2 == null || !((Integer) pairB.first).equals(pairB2.first)) {
                    i3 = 2;
                }
            }
            if (i3 == 0) {
                return new zzil(str3, zzvVar, zzvVar2, true == zzvVar.b(zzvVar2) ? 3 : 2, 0);
            }
            zzvVar3 = zzvVar;
            zzvVar4 = zzvVar2;
        } else {
            zzvVar3 = zzvVar;
            zzvVar4 = zzvVar2;
            if (zzvVar3.E != zzvVar4.E) {
                i3 |= 4096;
            }
            if (zzvVar3.F != zzvVar4.F) {
                i3 |= KEYRecord.Flags.FLAG2;
            }
            if (zzvVar3.G != zzvVar4.G) {
                i3 |= 16384;
            }
            String str4 = this.f35646b;
            if (i3 == 0 && (str4.equals("audio/mp4a-latm") || str4.equals("audio/ac4"))) {
                HashMap map = zzvc.f35693a;
                Pair pairB3 = zzdo.b(zzvVar3);
                Pair pairB4 = zzdo.b(zzvVar4);
                if (pairB3 != null && pairB4 != null) {
                    int iIntValue = ((Integer) pairB3.first).intValue();
                    int iIntValue2 = ((Integer) pairB4.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new zzil(this.f35645a, zzvVar3, zzvVar4, 3, 0);
                    }
                    if (str4.equals("audio/ac4") && pairB3.equals(pairB4)) {
                        return new zzil(this.f35645a, zzvVar3, zzvVar4, 3, 0);
                    }
                }
            }
            if (i3 == 0 && (str4.equals("audio/eac3-joc") || str4.equals("audio/eac3"))) {
                return new zzil(this.f35645a, zzvVar3, zzvVar4, 3, 0);
            }
            if (!zzvVar3.b(zzvVar4)) {
                i3 |= 32;
            }
            if ("audio/opus".equals(str4)) {
                i3 |= 2;
            }
            if (i3 == 0) {
                return new zzil(this.f35645a, zzvVar3, zzvVar4, 1, 0);
            }
        }
        return new zzil(this.f35645a, zzvVar3, zzvVar4, 0, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(int r12, int r13, double r14) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuj.e(int, int, double):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:0x00c7, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(com.google.android.gms.internal.ads.zzv r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuj.f(com.google.android.gms.internal.ads.zzv, boolean):boolean");
    }

    public final boolean g(zzv zzvVar) {
        return (Objects.equals(zzvVar.f35691m, "audio/flac") && zzvVar.G == 22 && Build.VERSION.SDK_INT < 34 && this.f35645a.equals("c2.android.flac.decoder")) ? false : true;
    }

    public final void h(String str) {
        String str2 = zzfj.f31254a;
        String str3 = this.f35646b;
        int length = String.valueOf(str3).length();
        int length2 = String.valueOf(str2).length();
        int length3 = str.length() + 14;
        String str4 = this.f35645a;
        StringBuilder sb = new StringBuilder(str4.length() + length3 + 2 + length + 3 + length2 + 1);
        android.support.v4.media.b.B(sb, "NoSupport [", str, "] [", str4);
        android.support.v4.media.b.B(sb, ", ", str3, "] [", str2);
        sb.append("]");
        zzee.a("MediaCodecInfo", sb.toString());
    }

    public final String toString() {
        return this.f35645a;
    }
}

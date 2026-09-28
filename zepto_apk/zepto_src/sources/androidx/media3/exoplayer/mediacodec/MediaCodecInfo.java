package androidx.media3.exoplayer.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.mediacodec.MediaCodecPerformancePointCoverageProvider;
import org.xbill.DNS.KEYRecord;

@UnstableApi
/* loaded from: classes3.dex */
public final class MediaCodecInfo {

    /* renamed from: a, reason: collision with root package name */
    public final String f7320a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7321b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7322c;

    /* renamed from: d, reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f7323d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f7324e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f7325f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f7326g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f7327h;

    public MediaCodecInfo(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3) {
        str.getClass();
        this.f7320a = str;
        this.f7321b = str2;
        this.f7322c = str3;
        this.f7323d = codecCapabilities;
        this.f7326g = z;
        this.f7324e = z2;
        this.f7325f = z3;
        this.f7327h = MimeTypes.o(str2);
    }

    public static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        Point point = new Point(Util.g(i2, widthAlignment) * widthAlignment, Util.g(i3, heightAlignment) * heightAlignment);
        int i4 = point.x;
        int i5 = point.y;
        return (d2 == -1.0d || d2 < 1.0d) ? videoCapabilities.isSizeSupported(i4, i5) : videoCapabilities.areSizeAndRateSupported(i4, i5, Math.floor(d2));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.exoplayer.mediacodec.MediaCodecInfo h(java.lang.String r8, java.lang.String r9, java.lang.String r10, android.media.MediaCodecInfo.CodecCapabilities r11, boolean r12, boolean r13) {
        /*
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r0 = new androidx.media3.exoplayer.mediacodec.MediaCodecInfo
            r1 = 0
            r2 = 1
            if (r11 == 0) goto L39
            java.lang.String r3 = "adaptive-playback"
            boolean r3 = r11.isFeatureSupported(r3)
            if (r3 == 0) goto L39
            int r3 = androidx.media3.common.util.Util.f5744a
            r4 = 22
            if (r3 > r4) goto L37
            java.lang.String r3 = androidx.media3.common.util.Util.f5747d
            java.lang.String r4 = "ODROID-XU3"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L26
            java.lang.String r4 = "Nexus 10"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L37
        L26:
            java.lang.String r3 = "OMX.Exynos.AVC.Decoder"
            boolean r3 = r3.equals(r8)
            if (r3 != 0) goto L39
            java.lang.String r3 = "OMX.Exynos.AVC.Decoder.secure"
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L37
            goto L39
        L37:
            r6 = r2
            goto L3a
        L39:
            r6 = r1
        L3a:
            r3 = 21
            if (r11 == 0) goto L48
            int r4 = androidx.media3.common.util.Util.f5744a
            if (r4 < r3) goto L48
            java.lang.String r4 = "tunneled-playback"
            boolean r4 = r11.isFeatureSupported(r4)
        L48:
            if (r13 != 0) goto L60
            if (r11 == 0) goto L59
            int r13 = androidx.media3.common.util.Util.f5744a
            if (r13 < r3) goto L59
            java.lang.String r13 = "secure-playback"
            boolean r13 = r11.isFeatureSupported(r13)
            if (r13 == 0) goto L59
            goto L60
        L59:
            r7 = r1
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r1 = r8
            goto L66
        L60:
            r7 = r2
            r1 = r8
            r3 = r10
            r4 = r11
            r5 = r12
            r2 = r9
        L66:
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecInfo.h(java.lang.String, java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean):androidx.media3.exoplayer.mediacodec.MediaCodecInfo");
    }

    public final DecoderReuseEvaluation b(Format format, Format format2) {
        Format format3;
        Format format4;
        int i2 = !Util.a(format.f5225m, format2.f5225m) ? 8 : 0;
        if (this.f7327h) {
            if (format.v != format2.v) {
                i2 |= 1024;
            }
            if (!this.f7324e && (format.s != format2.s || format.t != format2.t)) {
                i2 |= 512;
            }
            ColorInfo colorInfo = format.z;
            boolean zE = ColorInfo.e(colorInfo);
            ColorInfo colorInfo2 = format2.z;
            if ((!zE || !ColorInfo.e(colorInfo2)) && !Util.a(colorInfo, colorInfo2)) {
                i2 |= 2048;
            }
            if (Util.f5747d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(this.f7320a) && !format.b(format2)) {
                i2 |= 2;
            }
            if (i2 == 0) {
                return new DecoderReuseEvaluation(this.f7320a, format, format2, format.b(format2) ? 3 : 2, 0);
            }
            format3 = format;
            format4 = format2;
        } else {
            format3 = format;
            format4 = format2;
            if (format3.A != format4.A) {
                i2 |= 4096;
            }
            if (format3.B != format4.B) {
                i2 |= KEYRecord.Flags.FLAG2;
            }
            if (format3.C != format4.C) {
                i2 |= 16384;
            }
            String str = this.f7321b;
            if (i2 == 0 && "audio/mp4a-latm".equals(str)) {
                Pair pairD = MediaCodecUtil.d(format3);
                Pair pairD2 = MediaCodecUtil.d(format4);
                if (pairD != null && pairD2 != null) {
                    int iIntValue = ((Integer) pairD.first).intValue();
                    int iIntValue2 = ((Integer) pairD2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new DecoderReuseEvaluation(this.f7320a, format3, format4, 3, 0);
                    }
                }
            }
            if (!format3.b(format4)) {
                i2 |= 32;
            }
            if ("audio/opus".equals(str)) {
                i2 |= 2;
            }
            if (i2 == 0) {
                return new DecoderReuseEvaluation(this.f7320a, format3, format4, 1, 0);
            }
        }
        return new DecoderReuseEvaluation(this.f7320a, format3, format4, 0, i2);
    }

    public final boolean c(Format format, boolean z) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        Pair pairD = MediaCodecUtil.d(format);
        if (pairD != null) {
            int iIntValue = ((Integer) pairD.first).intValue();
            int iIntValue2 = ((Integer) pairD.second).intValue();
            boolean zEquals = "video/dolby-vision".equals(format.f5225m);
            int i2 = 8;
            String str = this.f7321b;
            if (zEquals) {
                if ("video/avc".equals(str)) {
                    iIntValue2 = 0;
                    iIntValue = 8;
                } else if ("video/hevc".equals(str)) {
                    iIntValue2 = 0;
                    iIntValue = 2;
                }
            }
            if (this.f7327h || iIntValue == 42) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = this.f7323d;
                if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                    codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
                }
                if (Util.f5744a <= 23 && "video/x-vnd.on2.vp9".equals(str) && codecProfileLevelArr.length == 0) {
                    int iIntValue3 = (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) ? 0 : ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
                    if (iIntValue3 >= 180000000) {
                        i2 = 1024;
                    } else if (iIntValue3 >= 120000000) {
                        i2 = 512;
                    } else if (iIntValue3 >= 60000000) {
                        i2 = 256;
                    } else if (iIntValue3 >= 30000000) {
                        i2 = 128;
                    } else if (iIntValue3 >= 18000000) {
                        i2 = 64;
                    } else if (iIntValue3 >= 12000000) {
                        i2 = 32;
                    } else if (iIntValue3 >= 7200000) {
                        i2 = 16;
                    } else if (iIntValue3 < 3600000) {
                        i2 = iIntValue3 >= 1800000 ? 4 : iIntValue3 >= 800000 ? 2 : 1;
                    }
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
                    codecProfileLevel.profile = 1;
                    codecProfileLevel.level = i2;
                    codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
                }
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : codecProfileLevelArr) {
                    if (codecProfileLevel2.profile == iIntValue && (codecProfileLevel2.level >= iIntValue2 || !z)) {
                        if ("video/hevc".equals(str) && 2 == iIntValue) {
                            String str2 = Util.f5745b;
                            if ("sailfish".equals(str2) || "marlin".equals(str2)) {
                            }
                        }
                    }
                }
                g("codec.profileLevel, " + format.f5222j + ", " + this.f7322c);
                return false;
            }
        }
        return true;
    }

    public final boolean d(Format format) {
        int i2;
        String str = format.f5225m;
        String str2 = this.f7321b;
        if (!(str2.equals(str) || str2.equals(MediaCodecUtil.b(format))) || !c(format, true)) {
            return false;
        }
        if (this.f7327h) {
            int i3 = format.s;
            if (i3 > 0 && (i2 = format.t) > 0) {
                if (Util.f5744a >= 21) {
                    return f(i3, i2, format.u);
                }
                boolean z = i3 * i2 <= MediaCodecUtil.k();
                if (!z) {
                    g("legacyFrameSize, " + i3 + "x" + i2);
                }
                return z;
            }
        } else {
            int i4 = Util.f5744a;
            if (i4 >= 21) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = this.f7323d;
                int i5 = format.B;
                if (i5 != -1) {
                    if (codecCapabilities == null) {
                        g("sampleRate.caps");
                        return false;
                    }
                    MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
                    if (audioCapabilities == null) {
                        g("sampleRate.aCaps");
                        return false;
                    }
                    if (!audioCapabilities.isSampleRateSupported(i5)) {
                        g("sampleRate.support, " + i5);
                        return false;
                    }
                }
                int i6 = format.A;
                if (i6 != -1) {
                    if (codecCapabilities == null) {
                        g("channelCount.caps");
                        return false;
                    }
                    MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities.getAudioCapabilities();
                    if (audioCapabilities2 == null) {
                        g("channelCount.aCaps");
                        return false;
                    }
                    int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                    if (maxInputChannelCount <= 1 && ((i4 < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2))) {
                        int i7 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
                        Log.h("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + this.f7320a + ", [" + maxInputChannelCount + " to " + i7 + "]");
                        maxInputChannelCount = i7;
                    }
                    if (maxInputChannelCount < i6) {
                        g("channelCount.support, " + i6);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final boolean e(Format format) {
        if (this.f7327h) {
            return this.f7324e;
        }
        Pair pairD = MediaCodecUtil.d(format);
        return pairD != null && ((Integer) pairD.first).intValue() == 42;
    }

    public final boolean f(int i2, int i3, double d2) {
        Boolean bool;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f7323d;
        if (codecCapabilities == null) {
            g("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            g("sizeAndRate.vCaps");
            return false;
        }
        int i4 = Util.f5744a;
        if (i4 >= 29) {
            int iA = (i4 < 29 || ((bool = MediaCodecPerformancePointCoverageProvider.f7328a) != null && bool.booleanValue())) ? 0 : MediaCodecPerformancePointCoverageProvider.Api29.a(videoCapabilities, i2, i3, d2);
            if (iA == 2) {
                return true;
            }
            if (iA == 1) {
                StringBuilder sbT = android.support.v4.media.b.t(i2, i3, "sizeAndRate.cover, ", "x", "@");
                sbT.append(d2);
                g(sbT.toString());
                return false;
            }
        }
        if (!a(videoCapabilities, i2, i3, d2)) {
            if (i2 < i3) {
                String str = this.f7320a;
                if ((!"OMX.MTK.VIDEO.DECODER.HEVC".equals(str) || !"mcv5a".equals(Util.f5745b)) && a(videoCapabilities, i3, i2, d2)) {
                    StringBuilder sbT2 = android.support.v4.media.b.t(i2, i3, "sizeAndRate.rotated, ", "x", "@");
                    sbT2.append(d2);
                    StringBuilder sbV = androidx.fragment.app.e.v("AssumedSupport [", sbT2.toString(), "] [", str, ", ");
                    sbV.append(this.f7321b);
                    sbV.append("] [");
                    sbV.append(Util.f5748e);
                    sbV.append("]");
                    Log.b("MediaCodecInfo", sbV.toString());
                }
            }
            StringBuilder sbT3 = android.support.v4.media.b.t(i2, i3, "sizeAndRate.support, ", "x", "@");
            sbT3.append(d2);
            g(sbT3.toString());
            return false;
        }
        return true;
    }

    public final void g(String str) {
        StringBuilder sbY = android.support.v4.media.b.y("NoSupport [", str, "] [");
        sbY.append(this.f7320a);
        sbY.append(", ");
        sbY.append(this.f7321b);
        sbY.append("] [");
        sbY.append(Util.f5748e);
        sbY.append("]");
        Log.b("MediaCodecInfo", sbY.toString());
    }

    public final String toString() {
        return this.f7320a;
    }
}

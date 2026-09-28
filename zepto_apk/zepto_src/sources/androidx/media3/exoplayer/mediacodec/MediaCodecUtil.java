package androidx.media3.exoplayer.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import org.xbill.DNS.KEYRecord;

@SuppressLint({"InlinedApi"})
@UnstableApi
/* loaded from: classes3.dex */
public final class MediaCodecUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f7340a = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f7341b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static int f7342c = -1;

    public static final class CodecKey {

        /* renamed from: a, reason: collision with root package name */
        public final String f7343a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f7344b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f7345c;

        public CodecKey(String str, boolean z, boolean z2) {
            this.f7343a = str;
            this.f7344b = z;
            this.f7345c = z2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == CodecKey.class) {
                CodecKey codecKey = (CodecKey) obj;
                if (TextUtils.equals(this.f7343a, codecKey.f7343a) && this.f7344b == codecKey.f7344b && this.f7345c == codecKey.f7345c) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return ((androidx.fragment.app.e.e(31, 31, this.f7343a) + (this.f7344b ? 1231 : 1237)) * 31) + (this.f7345c ? 1231 : 1237);
        }
    }

    public static class DecoderQueryException extends Exception {
    }

    public interface MediaCodecListCompat {
        android.media.MediaCodecInfo a(int i2);

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean c(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int d();

        boolean e();
    }

    public static final class MediaCodecListCompatV16 implements MediaCodecListCompat {
        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public final android.media.MediaCodecInfo a(int i2) {
            return MediaCodecList.getCodecInfoAt(i2);
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public final boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && "video/avc".equals(str2);
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public final boolean c(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public final int d() {
            return MediaCodecList.getCodecCount();
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public final boolean e() {
            return false;
        }
    }

    @RequiresApi
    public static final class MediaCodecListCompatV21 implements MediaCodecListCompat {

        /* renamed from: a, reason: collision with root package name */
        public final int f7346a;

        /* renamed from: b, reason: collision with root package name */
        public android.media.MediaCodecInfo[] f7347b;

        public MediaCodecListCompatV21(boolean z, boolean z2) {
            this.f7346a = (z || z2) ? 1 : 0;
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public final android.media.MediaCodecInfo a(int i2) {
            if (this.f7347b == null) {
                this.f7347b = new MediaCodecList(this.f7346a).getCodecInfos();
            }
            return this.f7347b[i2];
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public final boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public final boolean c(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public final int d() {
            if (this.f7347b == null) {
                this.f7347b = new MediaCodecList(this.f7346a).getCodecInfos();
            }
            return this.f7347b.length;
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public final boolean e() {
            return true;
        }
    }

    public interface ScoreProvider<T> {
        int a(Object obj);
    }

    public static void a(String str, ArrayList arrayList) {
        if ("audio/raw".equals(str)) {
            if (Util.f5744a < 26 && Util.f5745b.equals("R9") && arrayList.size() == 1 && ((MediaCodecInfo) arrayList.get(0)).f7320a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                arrayList.add(MediaCodecInfo.h("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, false));
            }
            Collections.sort(arrayList, new f(new d(0)));
        }
        int i2 = Util.f5744a;
        if (i2 < 21 && arrayList.size() > 1) {
            String str2 = ((MediaCodecInfo) arrayList.get(0)).f7320a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                Collections.sort(arrayList, new f(new d(1)));
            }
        }
        if (i2 >= 32 || arrayList.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(((MediaCodecInfo) arrayList.get(0)).f7320a)) {
            return;
        }
        arrayList.add((MediaCodecInfo) arrayList.remove(0));
    }

    public static String b(Format format) {
        Pair pairD;
        if ("audio/eac3-joc".equals(format.f5225m)) {
            return "audio/eac3";
        }
        if (!"video/dolby-vision".equals(format.f5225m) || (pairD = d(format)) == null) {
            return null;
        }
        int iIntValue = ((Integer) pairD.first).intValue();
        if (iIntValue == 16 || iIntValue == 256) {
            return "video/hevc";
        }
        if (iIntValue == 512) {
            return "video/avc";
        }
        if (iIntValue == 1024) {
            return "video/av01";
        }
        return null;
    }

    public static String c(android.media.MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        if (str2.equals("audio/ac3") && "OMX.lge.ac3.decoder".equals(str)) {
            return "audio/lg-ac3";
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair d(androidx.media3.common.Format r33) {
        /*
            Method dump skipped, instructions count: 2402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.d(androidx.media3.common.Format):android.util.Pair");
    }

    public static MediaCodecInfo e(String str) {
        List listF = f(str, false, false);
        if (listF.isEmpty()) {
            return null;
        }
        return (MediaCodecInfo) listF.get(0);
    }

    public static synchronized List f(String str, boolean z, boolean z2) {
        try {
            CodecKey codecKey = new CodecKey(str, z, z2);
            HashMap map = f7341b;
            List list = (List) map.get(codecKey);
            if (list != null) {
                return list;
            }
            int i2 = Util.f5744a;
            ArrayList arrayListG = g(codecKey, i2 >= 21 ? new MediaCodecListCompatV21(z, z2) : new MediaCodecListCompatV16());
            if (z && arrayListG.isEmpty() && 21 <= i2 && i2 <= 23) {
                arrayListG = g(codecKey, new MediaCodecListCompatV16());
                if (!arrayListG.isEmpty()) {
                    Log.h("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((MediaCodecInfo) arrayListG.get(0)).f7320a);
                }
            }
            a(str, arrayListG);
            ImmutableList immutableListO = ImmutableList.o(arrayListG);
            map.put(codecKey, immutableListO);
            return immutableListO;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static ArrayList g(CodecKey codecKey, MediaCodecListCompat mediaCodecListCompat) throws Exception {
        String strC;
        String str;
        String str2;
        MediaCodecListCompat mediaCodecListCompat2 = mediaCodecListCompat;
        try {
            ArrayList arrayList = new ArrayList();
            String str3 = codecKey.f7343a;
            int iD = mediaCodecListCompat2.d();
            boolean zE = mediaCodecListCompat2.e();
            int i2 = 0;
            while (i2 < iD) {
                android.media.MediaCodecInfo mediaCodecInfoA = mediaCodecListCompat2.a(i2);
                int i3 = Util.f5744a;
                if (i3 < 29 || !mediaCodecInfoA.isAlias()) {
                    String name = mediaCodecInfoA.getName();
                    if (i(mediaCodecInfoA, name, zE, str3) && (strC = c(mediaCodecInfoA, name, str3)) != null) {
                        try {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfoA.getCapabilitiesForType(strC);
                            boolean zB = mediaCodecListCompat2.b("tunneled-playback", strC, capabilitiesForType);
                            boolean zC = mediaCodecListCompat2.c("tunneled-playback", capabilitiesForType);
                            boolean z = codecKey.f7345c;
                            if ((z || !zC) && (!z || zB)) {
                                boolean zB2 = mediaCodecListCompat2.b("secure-playback", strC, capabilitiesForType);
                                boolean zC2 = mediaCodecListCompat2.c("secure-playback", capabilitiesForType);
                                boolean z2 = codecKey.f7344b;
                                if ((z2 || !zC2) && (!z2 || zB2)) {
                                    boolean zIsHardwareAccelerated = i3 >= 29 ? mediaCodecInfoA.isHardwareAccelerated() : !j(mediaCodecInfoA, str3);
                                    j(mediaCodecInfoA, str3);
                                    if (i3 >= 29) {
                                        mediaCodecInfoA.isVendor();
                                    } else {
                                        String strB = Ascii.b(mediaCodecInfoA.getName());
                                        if (!strB.startsWith("omx.google.") && !strB.startsWith("c2.android.")) {
                                            strB.startsWith("c2.google.");
                                        }
                                    }
                                    if (!(zE && z2 == zB2) && (zE || z2)) {
                                        str2 = name;
                                        boolean z3 = zIsHardwareAccelerated;
                                        if (!zE && zB2) {
                                            str = strC;
                                            try {
                                                arrayList.add(MediaCodecInfo.h(str2 + ".secure", str3, str, capabilitiesForType, z3, true));
                                                break;
                                            } catch (Exception e2) {
                                                e = e2;
                                                if (Util.f5744a <= 23 || arrayList.isEmpty()) {
                                                    Log.d("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                                    throw e;
                                                }
                                                Log.d("MediaCodecUtil", "Skipping codec " + str2 + " (failed to query capabilities)");
                                                i2++;
                                                mediaCodecListCompat2 = mediaCodecListCompat;
                                            }
                                        }
                                    } else {
                                        str = strC;
                                        try {
                                            str2 = name;
                                        } catch (Exception e3) {
                                            e = e3;
                                            str2 = name;
                                        }
                                        try {
                                            arrayList.add(MediaCodecInfo.h(name, str3, str, capabilitiesForType, zIsHardwareAccelerated, false));
                                        } catch (Exception e4) {
                                            e = e4;
                                            str = str;
                                            if (Util.f5744a <= 23) {
                                            }
                                            Log.d("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                            throw e;
                                        }
                                    }
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                            str = strC;
                            str2 = name;
                        }
                    }
                }
                i2++;
                mediaCodecListCompat2 = mediaCodecListCompat;
            }
            return arrayList;
        } catch (Exception e6) {
            throw new DecoderQueryException("Failed to query underlying media codecs", e6);
        }
    }

    public static List h(d dVar, Format format, boolean z, boolean z2) {
        String str = format.f5225m;
        dVar.getClass();
        List listF = f(str, z, z2);
        String strB = b(format);
        List listR = strB == null ? ImmutableList.r() : f(strB, z, z2);
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        builder.f(listF);
        builder.f(listR);
        return builder.j();
    }

    public static boolean i(android.media.MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder()) {
            return false;
        }
        if (!z && str.endsWith(".secure")) {
            return false;
        }
        int i2 = Util.f5744a;
        if (i2 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i2 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(Util.f5746c))) {
            String str3 = Util.f5745b;
            if (str3.startsWith("zeroflte") || str3.startsWith("zerolte") || str3.startsWith("zenlte") || "SC-05G".equals(str3) || "marinelteatt".equals(str3) || "404SC".equals(str3) || "SC-04G".equals(str3) || "SCV31".equals(str3)) {
                return false;
            }
        }
        if (i2 == 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(Util.f5746c)) {
            String str4 = Util.f5745b;
            if (str4.startsWith("d2") || str4.startsWith("serrano") || str4.startsWith("jflte") || str4.startsWith("santos") || str4.startsWith("t0")) {
                return false;
            }
        }
        if (i2 == 19 && Util.f5745b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return (i2 <= 23 && "audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    public static boolean j(android.media.MediaCodecInfo mediaCodecInfo, String str) {
        if (Util.f5744a >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (MimeTypes.l(str)) {
            return true;
        }
        String strB = Ascii.b(mediaCodecInfo.getName());
        if (strB.startsWith("arc.")) {
            return false;
        }
        if (strB.startsWith("omx.google.") || strB.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((strB.startsWith("omx.sec.") && strB.contains(".sw.")) || strB.equals("omx.qcom.video.decoder.hevcswvdec") || strB.startsWith("c2.android.") || strB.startsWith("c2.google.")) {
            return true;
        }
        return (strB.startsWith("omx.") || strB.startsWith("c2.")) ? false : true;
    }

    public static int k() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        int i2;
        if (f7342c == -1) {
            MediaCodecInfo mediaCodecInfoE = e("video/avc");
            int iMax = 0;
            if (mediaCodecInfoE != null) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = mediaCodecInfoE.f7323d;
                if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                    codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
                }
                int length = codecProfileLevelArr.length;
                int iMax2 = 0;
                while (iMax < length) {
                    int i3 = codecProfileLevelArr[iMax].level;
                    if (i3 != 1 && i3 != 2) {
                        switch (i3) {
                            case 8:
                            case 16:
                            case 32:
                                i2 = 101376;
                                break;
                            case 64:
                                i2 = 202752;
                                break;
                            case 128:
                            case 256:
                                i2 = 414720;
                                break;
                            case 512:
                                i2 = 921600;
                                break;
                            case 1024:
                                i2 = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i2 = 2097152;
                                break;
                            case KEYRecord.Flags.FLAG2 /* 8192 */:
                                i2 = 2228224;
                                break;
                            case 16384:
                                i2 = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i2 = 9437184;
                                break;
                            case 131072:
                            case 262144:
                            case 524288:
                                i2 = 35651584;
                                break;
                            default:
                                i2 = -1;
                                break;
                        }
                    } else {
                        i2 = 25344;
                    }
                    iMax2 = Math.max(i2, iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, Util.f5744a >= 21 ? 345600 : 172800);
            }
            f7342c = iMax;
        }
        return f7342c;
    }
}

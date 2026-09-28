package androidx.media3.common;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.util.Util;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
public final class MimeTypes {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f5407a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f5408b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    public static final class CustomMimeType {
    }

    @VisibleForTesting
    public static final class Mp4aObjectType {

        /* renamed from: a, reason: collision with root package name */
        public final int f5409a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5410b;

        public Mp4aObjectType(int i2, int i3) {
            this.f5409a = i2;
            this.f5410b = i3;
        }

        public final int a() {
            int i2 = this.f5410b;
            if (i2 == 2) {
                return 10;
            }
            if (i2 == 5) {
                return 11;
            }
            if (i2 == 29) {
                return 12;
            }
            if (i2 == 42) {
                return 16;
            }
            if (i2 != 22) {
                return i2 != 23 ? 0 : 15;
            }
            return 1073741824;
        }
    }

    public static boolean a(String str, String str2) {
        Mp4aObjectType mp4aObjectTypeG;
        int iA;
        if (str == null) {
            return false;
        }
        switch (str) {
            case "audio/mp4a-latm":
                if (str2 != null && (mp4aObjectTypeG = g(str2)) != null && (iA = mp4aObjectTypeG.a()) != 0 && iA != 16) {
                }
                break;
        }
        return false;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : Util.f0(str)) {
            String strE = e(str2);
            if (strE != null && l(strE)) {
                return strE;
            }
        }
        return null;
    }

    public static String c(String str, String str2) {
        if (str != null && str2 != null) {
            String[] strArrF0 = Util.f0(str);
            StringBuilder sb = new StringBuilder();
            for (String str3 : strArrF0) {
                if (str2.equals(e(str3))) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(str3);
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }

    public static int d(String str, String str2) {
        Mp4aObjectType mp4aObjectTypeG;
        str.getClass();
        switch (str) {
            case "audio/eac3-joc":
                return 18;
            case "audio/vnd.dts.hd;profile=lbr":
                return 8;
            case "audio/vnd.dts":
                return 7;
            case "audio/mp4a-latm":
                if (str2 == null || (mp4aObjectTypeG = g(str2)) == null) {
                    return 0;
                }
                return mp4aObjectTypeG.a();
            case "audio/ac3":
                return 5;
            case "audio/ac4":
                return 17;
            case "audio/vnd.dts.uhd;profile=p2":
                return 30;
            case "audio/eac3":
                return 6;
            case "audio/mpeg":
                return 9;
            case "audio/opus":
                return 20;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    public static String e(String str) {
        Mp4aObjectType mp4aObjectTypeG;
        String strF = null;
        if (str == null) {
            return null;
        }
        String strB = Ascii.b(str.trim());
        if (strB.startsWith("avc1") || strB.startsWith("avc3")) {
            return "video/avc";
        }
        if (strB.startsWith("hev1") || strB.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (strB.startsWith("dvav") || strB.startsWith("dva1") || strB.startsWith("dvhe") || strB.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (strB.startsWith("av01")) {
            return "video/av01";
        }
        if (strB.startsWith("vp9") || strB.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (strB.startsWith("vp8") || strB.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (strB.startsWith("mp4a")) {
            if (strB.startsWith("mp4a.") && (mp4aObjectTypeG = g(strB)) != null) {
                strF = f(mp4aObjectTypeG.f5409a);
            }
            return strF == null ? "audio/mp4a-latm" : strF;
        }
        if (strB.startsWith("mha1")) {
            return "audio/mha1";
        }
        if (strB.startsWith("mhm1")) {
            return "audio/mhm1";
        }
        if (strB.startsWith("ac-3") || strB.startsWith("dac3")) {
            return "audio/ac3";
        }
        if (strB.startsWith("ec-3") || strB.startsWith("dec3")) {
            return "audio/eac3";
        }
        if (strB.startsWith("ec+3")) {
            return "audio/eac3-joc";
        }
        if (strB.startsWith("ac-4") || strB.startsWith("dac4")) {
            return "audio/ac4";
        }
        if (strB.startsWith("dtsc")) {
            return "audio/vnd.dts";
        }
        if (strB.startsWith("dtse")) {
            return "audio/vnd.dts.hd;profile=lbr";
        }
        if (strB.startsWith("dtsh") || strB.startsWith("dtsl")) {
            return "audio/vnd.dts.hd";
        }
        if (strB.startsWith("dtsx")) {
            return "audio/vnd.dts.uhd;profile=p2";
        }
        if (strB.startsWith("opus")) {
            return "audio/opus";
        }
        if (strB.startsWith("vorbis")) {
            return "audio/vorbis";
        }
        if (strB.startsWith("flac")) {
            return "audio/flac";
        }
        if (strB.startsWith("stpp")) {
            return "application/ttml+xml";
        }
        if (strB.startsWith("wvtt")) {
            return "text/vtt";
        }
        if (strB.contains("cea708")) {
            return "application/cea-708";
        }
        if (strB.contains("eia608") || strB.contains("cea608")) {
            return "application/cea-608";
        }
        ArrayList arrayList = f5407a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((CustomMimeType) arrayList.get(i2)).getClass();
            if (strB.startsWith(null)) {
                break;
            }
        }
        return null;
    }

    public static String f(int i2) {
        if (i2 == 32) {
            return "video/mp4v-es";
        }
        if (i2 == 33) {
            return "video/avc";
        }
        if (i2 == 35) {
            return "video/hevc";
        }
        if (i2 == 64) {
            return "audio/mp4a-latm";
        }
        if (i2 == 163) {
            return "video/wvc1";
        }
        if (i2 == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i2 == 221) {
            return "audio/vorbis";
        }
        if (i2 == 165) {
            return "audio/ac3";
        }
        if (i2 == 166) {
            return "audio/eac3";
        }
        switch (i2) {
            case 96:
            case WKSRecord.Service.SWIFT_RVF /* 97 */:
            case WKSRecord.Service.TACNEWS /* 98 */:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case Type.L64 /* 106 */:
                return "video/mpeg";
            case Type.EUI48 /* 108 */:
                return "image/jpeg";
            default:
                switch (i2) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    public static Mp4aObjectType g(String str) {
        Matcher matcher = f5408b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(1);
        strGroup.getClass();
        String strGroup2 = matcher.group(2);
        try {
            return new Mp4aObjectType(Integer.parseInt(strGroup, 16), strGroup2 != null ? Integer.parseInt(strGroup2) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String h(String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }

    public static int i(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (l(str)) {
            return 1;
        }
        if (o(str)) {
            return 2;
        }
        if (n(str)) {
            return 3;
        }
        if (m(str)) {
            return 4;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        ArrayList arrayList = f5407a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((CustomMimeType) arrayList.get(i2)).getClass();
            if (str.equals(null)) {
                return 0;
            }
        }
        return -1;
    }

    public static int j(String str) {
        return i(e(str));
    }

    public static String k(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : Util.f0(str)) {
            String strE = e(str2);
            if (strE != null && o(strE)) {
                return strE;
            }
        }
        return null;
    }

    public static boolean l(String str) {
        return "audio".equals(h(str));
    }

    public static boolean m(String str) {
        return "image".equals(h(str)) || "application/x-image-uri".equals(str);
    }

    public static boolean n(String str) {
        return "text".equals(h(str)) || "application/x-media3-cues".equals(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    public static boolean o(String str) {
        return "video".equals(h(str));
    }

    public static String p(String str) {
        String strB;
        if (str == null) {
            return null;
        }
        strB = Ascii.b(str);
        strB.getClass();
        switch (strB) {
            case "audio/x-flac":
                return "audio/flac";
            case "application/x-mpegurl":
                return "application/x-mpegURL";
            case "audio/x-wav":
                return "audio/wav";
            case "audio/mpeg-l1":
                return "audio/mpeg-L1";
            case "audio/mpeg-l2":
                return "audio/mpeg-L2";
            case "audio/mp3":
                return "audio/mpeg";
            default:
                return strB;
        }
    }
}

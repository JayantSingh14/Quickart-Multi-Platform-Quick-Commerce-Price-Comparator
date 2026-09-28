package androidx.media3.common.util;

import android.app.Notification;
import android.app.Service;
import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.media.AudioFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.Player;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.math.DoubleMath;
import com.google.common.math.LongMath;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import in.juspay.hypersdk.analytics.LogConstants;
import in.juspay.hypersdk.core.PaymentConstants;
import j$.util.DesugarTimeZone;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.TimeZones;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes.dex */
public final class Util {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5744a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f5745b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f5746c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f5747d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f5748e;

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f5749f;

    /* renamed from: g, reason: collision with root package name */
    public static final long[] f5750g;

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f5751h;

    /* renamed from: i, reason: collision with root package name */
    public static final Pattern f5752i;

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f5753j;

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f5754k;

    /* renamed from: l, reason: collision with root package name */
    public static HashMap f5755l;

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f5756m;
    public static final String[] n;
    public static final int[] o;
    public static final int[] p;
    public static final int[] q;

    @RequiresApi
    /* loaded from: classes3.dex */
    public static final class Api21 {
        @DoNotInline
        public static Drawable a(Context context, Resources resources, @DrawableRes int i2) {
            return resources.getDrawable(i2, context.getTheme());
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api29 {
        @DoNotInline
        public static void a(Service service, int i2, Notification notification, int i3, String str) {
            try {
                service.startForeground(i2, notification, i3);
            } catch (RuntimeException e2) {
                Log.d("Util", "The service must be declared with a foregroundServiceType that includes " + str);
                throw e2;
            }
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        f5744a = i2;
        String str = Build.DEVICE;
        f5745b = str;
        String str2 = Build.MANUFACTURER;
        f5746c = str2;
        String str3 = Build.MODEL;
        f5747d = str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(str2);
        f5748e = androidx.fragment.app.e.r(sb, i2, ", ");
        f5749f = new byte[0];
        f5750g = new long[0];
        f5751h = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        f5752i = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        f5753j = Pattern.compile("%([A-Fa-f0-9]{2})");
        f5754k = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        f5756m = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", CLConstants.SHARED_PREFERENCE_ITEM_ID, "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", PaymentConstants.WIDGET_NETBANKING, "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        n = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        o = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        p = new int[]{0, 4129, 8258, 12387, 16516, 20645, 24774, 28903, 33032, 37161, 41290, 45419, 49548, 53677, 57806, 61935};
        q = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, WKSRecord.Service.NNTP, 126, WKSRecord.Service.ERPC, Type.EUI48, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, Type.IXFR, 242, WKSRecord.Service.LINK, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, WKSRecord.Service.EMFIS_DATA, WKSRecord.Service.NETBIOS_SSN, WKSRecord.Service.CISCO_FNA, WKSRecord.Service.STATSRV, 168, 175, 166, 161, 180, 179, 186, 189, 199, 192, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, WKSRecord.Service.PROFILE, WKSRecord.Service.PWDGEN, WKSRecord.Service.INGRES_NET, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, WKSRecord.Service.SUNRPC, 104, 97, 102, WKSRecord.Service.SFTP, 116, WKSRecord.Service.LOCUS_MAP, 122, WKSRecord.Service.NETBIOS_NS, WKSRecord.Service.BL_IDM, WKSRecord.Service.LOC_SRV, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, Type.TKEY, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, WKSRecord.Service.UUCP_PATH, 114, WKSRecord.Service.NTP, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, WKSRecord.Service.AUTH, 120, WKSRecord.Service.LOCUS_CON, Type.L64, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, ModuleDescriptor.MODULE_VERSION, 159, WKSRecord.Service.NETBIOS_DGM, WKSRecord.Service.EMFIS_CNTL, WKSRecord.Service.CISCO_SYS, WKSRecord.Service.CISCO_TNA, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, Type.TSIG, 253, 244, WKSRecord.Service.SUR_MEAS};
    }

    public static long A(long j2) {
        return j2 == -9223372036854775807L ? System.currentTimeMillis() : android.os.SystemClock.elapsedRealtime() + j2;
    }

    public static int B(int i2) {
        if (i2 == 8) {
            return 3;
        }
        if (i2 == 16) {
            return 2;
        }
        if (i2 != 24) {
            return i2 != 32 ? 0 : 22;
        }
        return 21;
    }

    public static int C(int i2, int i3) {
        if (i2 != 2) {
            if (i2 == 3) {
                return i3;
            }
            if (i2 != 4) {
                if (i2 != 21) {
                    if (i2 != 22) {
                        if (i2 != 268435456) {
                            if (i2 != 1342177280) {
                                if (i2 != 1610612736) {
                                    throw new IllegalArgumentException();
                                }
                            }
                        }
                    }
                }
                return i3 * 3;
            }
            return i3 * 4;
        }
        return i3 * 2;
    }

    public static long D(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(j2 / f2);
    }

    public static String E(StringBuilder sb, Formatter formatter, long j2) {
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        String str = j2 < 0 ? "-" : "";
        long jAbs = (Math.abs(j2) + 500) / 1000;
        long j3 = jAbs % 60;
        long j4 = (jAbs / 60) % 60;
        long j5 = jAbs / 3600;
        sb.setLength(0);
        return j5 > 0 ? formatter.format("%s%d:%02d:%02d", str, Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3)).toString() : formatter.format("%s%02d:%02d", str, Long.valueOf(j4), Long.valueOf(j3)).toString();
    }

    public static String[] F() {
        String[] strArrSplit;
        Configuration configuration = Resources.getSystem().getConfiguration();
        int i2 = f5744a;
        if (i2 >= 24) {
            strArrSplit = configuration.getLocales().toLanguageTags().split(",", -1);
        } else {
            Locale locale = configuration.locale;
            strArrSplit = new String[]{i2 >= 21 ? locale.toLanguageTag() : locale.toString()};
        }
        for (int i3 = 0; i3 < strArrSplit.length; i3++) {
            strArrSplit[i3] = U(strArrSplit[i3]);
        }
        return strArrSplit;
    }

    public static String G(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e2) {
            Log.e("Util", "Failed to read system property ".concat(str), e2);
            return null;
        }
    }

    public static String H(int i2) {
        switch (i2) {
            case CompanionAdSlot.FLUID_SIZE /* -2 */:
                return "none";
            case -1:
                return zzck.UNKNOWN_CONTENT_TYPE;
            case 0:
                return LogConstants.DEFAULT_CHANNEL;
            case 1:
                return "audio";
            case 2:
                return "video";
            case 3:
                return "text";
            case 4:
                return "image";
            case 5:
                return "metadata";
            case 6:
                return "camera motion";
            default:
                return i2 >= 10000 ? android.support.v4.media.b.g(i2, "custom (", ")") : "?";
        }
    }

    public static boolean I(Player player) {
        if (player == null || !player.D1(1)) {
            return false;
        }
        player.pause();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean J(androidx.media3.common.Player r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            int r1 = r4.u()
            r2 = 1
            if (r1 != r2) goto L17
            r3 = 2
            boolean r3 = r4.D1(r3)
            if (r3 == 0) goto L17
            r4.p()
        L15:
            r0 = r2
            goto L24
        L17:
            r3 = 4
            if (r1 != r3) goto L24
            boolean r1 = r4.D1(r3)
            if (r1 == 0) goto L24
            r4.k0()
            goto L15
        L24:
            boolean r1 = r4.D1(r2)
            if (r1 == 0) goto L2e
            r4.E()
            return r2
        L2e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.Util.J(androidx.media3.common.Player):boolean");
    }

    public static void K(Player player, boolean z) {
        if (e0(player, z)) {
            J(player);
        } else {
            I(player);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int L(android.net.Uri r8) {
        /*
            r0 = 1
            r1 = 2
            r2 = 0
            r3 = 3
            java.lang.String r4 = r8.getScheme()
            if (r4 == 0) goto L13
            java.lang.String r5 = "rtsp"
            boolean r4 = com.google.common.base.Ascii.a(r5, r4)
            if (r4 == 0) goto L13
            return r3
        L13:
            java.lang.String r4 = r8.getLastPathSegment()
            r5 = 4
            if (r4 != 0) goto L1c
            goto L9c
        L1c:
            r6 = 46
            int r6 = r4.lastIndexOf(r6)
            if (r6 < 0) goto L70
            int r6 = r6 + r0
            java.lang.String r4 = r4.substring(r6)
            java.lang.String r4 = com.google.common.base.Ascii.b(r4)
            r4.getClass()
            r6 = -1
            int r7 = r4.hashCode()
            switch(r7) {
                case 104579: goto L59;
                case 108321: goto L4e;
                case 3242057: goto L43;
                case 3299913: goto L3a;
                default: goto L38;
            }
        L38:
            r3 = r6
            goto L63
        L3a:
            java.lang.String r7 = "m3u8"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L63
            goto L38
        L43:
            java.lang.String r3 = "isml"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L4c
            goto L38
        L4c:
            r3 = r1
            goto L63
        L4e:
            java.lang.String r3 = "mpd"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L57
            goto L38
        L57:
            r3 = r0
            goto L63
        L59:
            java.lang.String r3 = "ism"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L62
            goto L38
        L62:
            r3 = r2
        L63:
            switch(r3) {
                case 0: goto L6c;
                case 1: goto L6a;
                case 2: goto L6c;
                case 3: goto L68;
                default: goto L66;
            }
        L66:
            r3 = r5
            goto L6d
        L68:
            r3 = r1
            goto L6d
        L6a:
            r3 = r2
            goto L6d
        L6c:
            r3 = r0
        L6d:
            if (r3 == r5) goto L70
            return r3
        L70:
            java.lang.String r8 = r8.getPath()
            androidx.media3.common.util.Assertions.d(r8)
            java.util.regex.Pattern r3 = androidx.media3.common.util.Util.f5754k
            java.util.regex.Matcher r8 = r3.matcher(r8)
            boolean r3 = r8.matches()
            if (r3 == 0) goto L9c
            java.lang.String r8 = r8.group(r1)
            if (r8 == 0) goto L9b
            java.lang.String r3 = "format=mpd-time-csf"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L92
            return r2
        L92:
            java.lang.String r2 = "format=m3u8-aapl"
            boolean r8 = r8.contains(r2)
            if (r8 == 0) goto L9b
            return r1
        L9b:
            return r0
        L9c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.Util.L(android.net.Uri):int");
    }

    public static int M(Uri uri, String str) {
        if (str == null) {
            return L(uri);
        }
        switch (str) {
            case "application/x-mpegURL":
                return 2;
            case "application/vnd.ms-sstr+xml":
                return 1;
            case "application/dash+xml":
                return 0;
            case "application/x-rtsp":
                return 3;
            default:
                return 4;
        }
    }

    public static boolean N(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, Inflater inflater) {
        if (parsableByteArray.a() <= 0) {
            return false;
        }
        if (parsableByteArray2.b() < parsableByteArray.a()) {
            parsableByteArray2.c(parsableByteArray.a() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(parsableByteArray.d(), parsableByteArray.e(), parsableByteArray.a());
        int iInflate = 0;
        while (true) {
            try {
                iInflate += inflater.inflate(parsableByteArray2.d(), iInflate, parsableByteArray2.b() - iInflate);
                if (!inflater.finished()) {
                    if (inflater.needsDictionary() || inflater.needsInput()) {
                        break;
                    }
                    if (iInflate == parsableByteArray2.b()) {
                        parsableByteArray2.c(parsableByteArray2.b() * 2);
                    }
                } else {
                    parsableByteArray2.I(iInflate);
                    inflater.reset();
                    return true;
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    public static boolean O(int i2) {
        return i2 == 3 || i2 == 2 || i2 == 268435456 || i2 == 21 || i2 == 1342177280 || i2 == 22 || i2 == 1610612736 || i2 == 4;
    }

    public static boolean P(Context context) {
        int i2 = f5744a;
        if (i2 < 29 || context.getApplicationInfo().targetSdkVersion < 29) {
            return true;
        }
        if (i2 != 30) {
            return false;
        }
        String str = f5747d;
        return Ascii.a(str, "moto g(20)") || Ascii.a(str, "rmx3231");
    }

    public static boolean Q(int i2) {
        return i2 == 10 || i2 == 13;
    }

    public static boolean R(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static void S(ArrayList arrayList, int i2, int i3, int i4) {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (int i5 = (i3 - i2) - 1; i5 >= 0; i5--) {
            arrayDeque.addFirst(arrayList.remove(i2 + i5));
        }
        arrayList.addAll(Math.min(i4, arrayList.size()), arrayDeque);
    }

    public static long T(long j2) {
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 * 1000;
    }

    public static String U(String str) throws MissingResourceException {
        if (str == null) {
            return null;
        }
        String strReplace = str.replace('_', Soundex.SILENT_MARKER);
        if (!strReplace.isEmpty() && !strReplace.equals("und")) {
            str = strReplace;
        }
        String strB = Ascii.b(str);
        int i2 = 0;
        String str2 = strB.split("-", 2)[0];
        if (f5755l == null) {
            String[] iSOLanguages = Locale.getISOLanguages();
            int length = iSOLanguages.length;
            String[] strArr = f5756m;
            HashMap map = new HashMap(length + strArr.length);
            for (String str3 : iSOLanguages) {
                try {
                    String iSO3Language = new Locale(str3).getISO3Language();
                    if (!TextUtils.isEmpty(iSO3Language)) {
                        map.put(iSO3Language, str3);
                    }
                } catch (MissingResourceException unused) {
                }
            }
            for (int i3 = 0; i3 < strArr.length; i3 += 2) {
                map.put(strArr[i3], strArr[i3 + 1]);
            }
            f5755l = map;
        }
        String str4 = (String) f5755l.get(str2);
        if (str4 != null) {
            StringBuilder sbW = android.support.v4.media.b.w(str4);
            sbW.append(strB.substring(str2.length()));
            strB = sbW.toString();
            str2 = str4;
        }
        if (!"no".equals(str2) && !"i".equals(str2) && !"zh".equals(str2)) {
            return strB;
        }
        while (true) {
            String[] strArr2 = n;
            if (i2 >= strArr2.length) {
                return strB;
            }
            if (strB.startsWith(strArr2[i2])) {
                return strArr2[i2 + 1] + strB.substring(strArr2[i2].length());
            }
            i2 += 2;
        }
    }

    public static Object[] V(int i2, Object[] objArr) {
        Assertions.a(i2 <= objArr.length);
        return Arrays.copyOf(objArr, i2);
    }

    public static long W(String str) throws ParserException {
        Matcher matcher = f5751h.matcher(str);
        if (!matcher.matches()) {
            throw ParserException.a(null, "Invalid date/time format: " + str);
        }
        int i2 = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
            i2 = Integer.parseInt(matcher.group(13)) + (Integer.parseInt(matcher.group(12)) * 60);
            if ("-".equals(matcher.group(11))) {
                i2 *= -1;
            }
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(DesugarTimeZone.getTimeZone(TimeZones.GMT_ID));
        gregorianCalendar.clear();
        gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8))) {
            gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return i2 != 0 ? timeInMillis - (i2 * DateUtils.MILLIS_PER_MINUTE) : timeInMillis;
    }

    public static void X(Handler handler, Runnable runnable) {
        if (handler.getLooper().getThread().isAlive()) {
            if (handler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }
    }

    public static void Y(int i2, int i3, List list) {
        if (i2 < 0 || i3 > list.size() || i2 > i3) {
            throw new IllegalArgumentException();
        }
        if (i2 != i3) {
            list.subList(i2, i3).clear();
        }
    }

    public static long Z(int i2, long j2) {
        return b0(j2, 1000000L, i2, RoundingMode.FLOOR);
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void a0(long[] jArr, long j2) {
        long j3;
        RoundingMode roundingMode = RoundingMode.FLOOR;
        int i2 = 0;
        if (j2 >= 1000000 && j2 % 1000000 == 0) {
            long jB = LongMath.b(j2, 1000000L, RoundingMode.UNNECESSARY);
            while (i2 < jArr.length) {
                jArr[i2] = LongMath.b(jArr[i2], jB, roundingMode);
                i2++;
            }
            return;
        }
        if (j2 < 1000000 && 1000000 % j2 == 0) {
            long jB2 = LongMath.b(1000000L, j2, RoundingMode.UNNECESSARY);
            while (i2 < jArr.length) {
                jArr[i2] = LongMath.d(jArr[i2], jB2);
                i2++;
            }
            return;
        }
        int i3 = 0;
        while (i3 < jArr.length) {
            long j4 = jArr[i3];
            if (j4 != 0) {
                if (j2 >= j4 && j2 % j4 == 0) {
                    jArr[i3] = LongMath.b(1000000L, LongMath.b(j2, j4, RoundingMode.UNNECESSARY), roundingMode);
                } else if (j2 >= j4 || j4 % j2 != 0) {
                    j3 = j2;
                    jArr[i3] = c0(j4, 1000000L, j3, roundingMode);
                } else {
                    jArr[i3] = LongMath.d(1000000L, LongMath.b(j4, j2, RoundingMode.UNNECESSARY));
                }
                j3 = j2;
            } else {
                j3 = j2;
            }
            i3++;
            j2 = j3;
        }
    }

    public static int b(long[] jArr, long j2, boolean z) {
        int i2;
        int iBinarySearch = Arrays.binarySearch(jArr, j2);
        if (iBinarySearch < 0) {
            return ~iBinarySearch;
        }
        while (true) {
            i2 = iBinarySearch + 1;
            if (i2 >= jArr.length || jArr[i2] != j2) {
                break;
            }
            iBinarySearch = i2;
        }
        return z ? iBinarySearch : i2;
    }

    public static long b0(long j2, long j3, long j4, RoundingMode roundingMode) {
        if (j2 == 0 || j3 == 0) {
            return 0L;
        }
        return (j4 < j3 || j4 % j3 != 0) ? (j4 >= j3 || j3 % j4 != 0) ? (j4 < j2 || j4 % j2 != 0) ? (j4 >= j2 || j2 % j4 != 0) ? c0(j2, j3, j4, roundingMode) : LongMath.d(j3, LongMath.b(j2, j4, RoundingMode.UNNECESSARY)) : LongMath.b(j3, LongMath.b(j4, j2, RoundingMode.UNNECESSARY), roundingMode) : LongMath.d(j2, LongMath.b(j3, j4, RoundingMode.UNNECESSARY)) : LongMath.b(j2, LongMath.b(j4, j3, RoundingMode.UNNECESSARY), roundingMode);
    }

    public static int c(LongArray longArray, long j2) {
        int iC = longArray.c() - 1;
        int i2 = 0;
        while (i2 <= iC) {
            int i3 = (i2 + iC) >>> 1;
            if (longArray.b(i3) < j2) {
                i2 = i3 + 1;
            } else {
                iC = i3 - 1;
            }
        }
        int i4 = iC + 1;
        if (i4 < longArray.c() && longArray.b(i4) == j2) {
            return i4;
        }
        if (iC == -1) {
            return 0;
        }
        return iC;
    }

    public static long c0(long j2, long j3, long j4, RoundingMode roundingMode) {
        long jD = LongMath.d(j2, j3);
        if (jD != Long.MAX_VALUE && jD != Long.MIN_VALUE) {
            return LongMath.b(jD, j4, roundingMode);
        }
        long jC = LongMath.c(Math.abs(j3), Math.abs(j4));
        RoundingMode roundingMode2 = RoundingMode.UNNECESSARY;
        long jB = LongMath.b(j3, jC, roundingMode2);
        long jB2 = LongMath.b(j4, jC, roundingMode2);
        long jC2 = LongMath.c(Math.abs(j2), Math.abs(jB2));
        long jB3 = LongMath.b(j2, jC2, roundingMode2);
        long jB4 = LongMath.b(jB2, jC2, roundingMode2);
        long jD2 = LongMath.d(jB3, jB);
        if (jD2 != Long.MAX_VALUE && jD2 != Long.MIN_VALUE) {
            return LongMath.b(jD2, jB4, roundingMode);
        }
        double d2 = jB3 * (jB / jB4);
        if (d2 > 9.223372036854776E18d) {
            return Long.MAX_VALUE;
        }
        if (d2 < -9.223372036854776E18d) {
            return Long.MIN_VALUE;
        }
        return DoubleMath.b(d2, roundingMode);
    }

    public static int d(ImmutableList immutableList, Comparable comparable, boolean z, boolean z2) {
        int i2;
        int i3;
        int iBinarySearch = Collections.binarySearch(immutableList, comparable);
        if (iBinarySearch < 0) {
            i3 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i2 = iBinarySearch - 1;
                if (i2 < 0 || ((Comparable) immutableList.get(i2)).compareTo(comparable) != 0) {
                    break;
                }
                iBinarySearch = i2;
            }
            i3 = z ? iBinarySearch : i2;
        }
        return z2 ? Math.max(0, i3) : i3;
    }

    public static void d0(Service service, int i2, Notification notification) {
        if (f5744a >= 29) {
            Api29.a(service, i2, notification, 2, "mediaPlayback");
        } else {
            service.startForeground(i2, notification);
        }
    }

    public static int e(int[] iArr, int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        int iBinarySearch = Arrays.binarySearch(iArr, i2);
        if (iBinarySearch < 0) {
            i4 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i3 = iBinarySearch - 1;
                if (i3 < 0 || iArr[i3] != i2) {
                    break;
                }
                iBinarySearch = i3;
            }
            i4 = z ? iBinarySearch : i3;
        }
        return z2 ? Math.max(0, i4) : i4;
    }

    public static boolean e0(Player player, boolean z) {
        return player == null || !player.O0() || player.u() == 1 || player.u() == 4 || (z && player.E0() != 0);
    }

    public static int f(long[] jArr, long j2, boolean z) {
        int i2;
        int iBinarySearch = Arrays.binarySearch(jArr, j2);
        if (iBinarySearch < 0) {
            i2 = -(iBinarySearch + 2);
        } else {
            while (true) {
                int i3 = iBinarySearch - 1;
                if (i3 < 0 || jArr[i3] != j2) {
                    break;
                }
                iBinarySearch = i3;
            }
            i2 = iBinarySearch;
        }
        return z ? Math.max(0, i2) : i2;
    }

    public static String[] f0(String str) {
        return TextUtils.isEmpty(str) ? new String[0] : str.trim().split("(\\s*,\\s*)", -1);
    }

    public static int g(int i2, int i3) {
        return ((i2 + i3) - 1) / i3;
    }

    public static boolean g0(SQLiteDatabase sQLiteDatabase, String str) {
        return DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{str}) > 0;
    }

    public static void h(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String h0(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(Character.forDigit((bArr[i2] >> 4) & 15, 16));
            sb.append(Character.forDigit(bArr[i2] & 15, 16));
        }
        return sb.toString();
    }

    public static int i(long j2, long j3) {
        if (j2 < j3) {
            return -1;
        }
        return j2 == j3 ? 0 : 1;
    }

    public static SettableFuture i0(ListenableFuture listenableFuture, AsyncFunction asyncFunction) {
        SettableFuture settableFutureR = SettableFuture.r();
        settableFutureR.q(new androidx.constraintlayout.motion.widget.a(3, settableFutureR, listenableFuture), MoreExecutors.a());
        listenableFuture.q(new e(listenableFuture, settableFutureR, asyncFunction, 0), MoreExecutors.a());
        return settableFutureR;
    }

    public static float j(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f2, f4));
    }

    public static long j0(long j2) {
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 / 1000;
    }

    public static int k(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i2, i4));
    }

    public static long l(long j2, long j3, long j4) {
        return Math.max(j3, Math.min(j2, j4));
    }

    public static boolean m(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (a(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static int n(int i2, int i3, byte[] bArr, int i4) {
        while (i2 < i3) {
            i4 = o[((i4 >>> 24) ^ (bArr[i2] & 255)) & 255] ^ (i4 << 8);
            i2++;
        }
        return i4;
    }

    public static Handler o(Handler.Callback callback) {
        Looper looperMyLooper = Looper.myLooper();
        Assertions.h(looperMyLooper);
        return new Handler(looperMyLooper, callback);
    }

    public static String p(byte[] bArr) {
        return new String(bArr, Charsets.f42260c);
    }

    public static int q(int i2) {
        if (i2 == 20) {
            return 30;
        }
        if (i2 == 22) {
            return 31;
        }
        if (i2 == 30) {
            return 34;
        }
        switch (i2) {
            case 2:
            case 3:
                return 3;
            case 4:
            case 5:
            case 6:
                return 21;
            case 7:
            case 8:
                return 23;
            case 9:
            case 10:
            case 11:
            case 12:
                return 28;
            default:
                switch (i2) {
                    case 14:
                        return 25;
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        return 28;
                    default:
                        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
                }
        }
    }

    public static AudioFormat r(int i2, int i3, int i4) {
        return new AudioFormat.Builder().setSampleRate(i2).setChannelMask(i3).setEncoding(i4).build();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0015 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int s(int r2) {
        /*
            r0 = 6396(0x18fc, float:8.963E-42)
            switch(r2) {
                case 1: goto L28;
                case 2: goto L25;
                case 3: goto L22;
                case 4: goto L1f;
                case 5: goto L1c;
                case 6: goto L19;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L5;
                case 10: goto Lb;
                case 11: goto L5;
                case 12: goto L7;
                default: goto L5;
            }
        L5:
            r2 = 0
            return r2
        L7:
            r2 = 743676(0xb58fc, float:1.042112E-39)
            return r2
        Lb:
            int r2 = androidx.media3.common.util.Util.f5744a
            r1 = 32
            if (r2 < r1) goto L15
            r2 = 737532(0xb40fc, float:1.033502E-39)
            return r2
        L15:
            return r0
        L16:
            r2 = 1276(0x4fc, float:1.788E-42)
            return r2
        L19:
            r2 = 252(0xfc, float:3.53E-43)
            return r2
        L1c:
            r2 = 220(0xdc, float:3.08E-43)
            return r2
        L1f:
            r2 = 204(0xcc, float:2.86E-43)
            return r2
        L22:
            r2 = 28
            return r2
        L25:
            r2 = 12
            return r2
        L28:
            r2 = 4
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.Util.s(int):int");
    }

    public static int t(int i2, String str) {
        int i3 = 0;
        for (String str2 : f0(str)) {
            if (i2 == MimeTypes.j(str2)) {
                i3++;
            }
        }
        return i3;
    }

    public static String u(int i2, String str) {
        String[] strArrF0 = f0(str);
        if (strArrF0.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrF0) {
            if (i2 == MimeTypes.j(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static Drawable v(Context context, Resources resources, int i2) {
        return f5744a >= 21 ? Api21.a(context, resources, i2) : resources.getDrawable(i2);
    }

    public static int w(int i2) {
        if (i2 == 2 || i2 == 4) {
            return 6005;
        }
        if (i2 == 10) {
            return 6004;
        }
        if (i2 == 7) {
            return 6005;
        }
        if (i2 == 8) {
            return 6003;
        }
        switch (i2) {
            case 15:
                return 6003;
            case 16:
            case 18:
                return 6005;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i2) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return 6002;
                    default:
                        return 6006;
                }
        }
    }

    public static int x(String str) throws NumberFormatException {
        String[] strArrSplit;
        int length;
        int i2 = 0;
        if (str != null && (length = (strArrSplit = str.split(Attributes.PREDEFINED_ATTRIBUTE_PREFIX, -1)).length) >= 2) {
            String str2 = strArrSplit[length - 1];
            boolean z = length >= 3 && "neg".equals(strArrSplit[length - 2]);
            try {
                Assertions.d(str2);
                i2 = Integer.parseInt(str2);
                if (z) {
                    return -i2;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return i2;
    }

    public static String y(int i2) {
        if (i2 == 0) {
            return "NO";
        }
        if (i2 == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i2 == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i2 == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i2 == 4) {
            return "YES";
        }
        throw new IllegalStateException();
    }

    public static long z(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(j2 * f2);
    }
}

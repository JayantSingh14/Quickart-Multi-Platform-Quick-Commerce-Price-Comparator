package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import in.juspay.hypersdk.core.PaymentConstants;
import java.math.RoundingMode;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.regex.Pattern;
import org.apache.commons.codec.language.Soundex;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public final class zzfj {

    /* renamed from: a, reason: collision with root package name */
    public static final String f31254a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f31255b;

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f31256c;

    /* renamed from: d, reason: collision with root package name */
    public static HashMap f31257d;

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f31258e;

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f31259f;

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f31260g;

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f31261h;

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f31262i;

    static {
        String str = Build.DEVICE;
        String str2 = Build.MODEL;
        String str3 = Build.MANUFACTURER;
        int i2 = Build.VERSION.SDK_INT;
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 2 + String.valueOf(str2).length() + 2 + String.valueOf(str3).length() + 2 + String.valueOf(i2).length());
        android.support.v4.media.b.B(sb, str, ", ", str2, ", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(i2);
        f31254a = sb.toString();
        f31255b = new byte[0];
        f31256c = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        f31258e = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", CLConstants.SHARED_PREFERENCE_ITEM_ID, "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", PaymentConstants.WIDGET_NETBANKING, "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        f31259f = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        f31260g = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        f31261h = new int[]{0, 4129, 8258, 12387, 16516, 20645, 24774, 28903, 33032, 37161, 41290, 45419, 49548, 53677, 57806, 61935};
        f31262i = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, WKSRecord.Service.NNTP, 126, WKSRecord.Service.ERPC, Type.EUI48, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, Type.IXFR, 242, WKSRecord.Service.LINK, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, WKSRecord.Service.EMFIS_DATA, WKSRecord.Service.NETBIOS_SSN, WKSRecord.Service.CISCO_FNA, WKSRecord.Service.STATSRV, 168, 175, 166, 161, 180, 179, 186, 189, 199, 192, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, WKSRecord.Service.PROFILE, WKSRecord.Service.PWDGEN, WKSRecord.Service.INGRES_NET, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, WKSRecord.Service.SUNRPC, 104, 97, 102, WKSRecord.Service.SFTP, 116, WKSRecord.Service.LOCUS_MAP, 122, WKSRecord.Service.NETBIOS_NS, WKSRecord.Service.BL_IDM, WKSRecord.Service.LOC_SRV, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, Type.TKEY, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, WKSRecord.Service.UUCP_PATH, 114, WKSRecord.Service.NTP, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, WKSRecord.Service.AUTH, 120, WKSRecord.Service.LOCUS_CON, Type.L64, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, ModuleDescriptor.MODULE_VERSION, 159, WKSRecord.Service.NETBIOS_DGM, WKSRecord.Service.EMFIS_CNTL, WKSRecord.Service.CISCO_SYS, WKSRecord.Service.CISCO_TNA, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, Type.TSIG, 253, 244, WKSRecord.Service.SUR_MEAS};
    }

    public static boolean a(int i2) {
        return i2 == 3 || i2 == 2 || i2 == 268435456 || i2 == 21 || i2 == 1342177280 || i2 == 22 || i2 == 1610612736 || i2 == 4;
    }

    public static int b(int i2) {
        int i3;
        int i4 = 6396;
        if (i2 != 10) {
            if (i2 == 16) {
                i3 = 205215996;
            } else if (i2 != 24) {
                switch (i2) {
                    case 1:
                        return 4;
                    case 2:
                        return 12;
                    case 3:
                        return 28;
                    case 4:
                        return 204;
                    case 5:
                        return 220;
                    case 6:
                        return 252;
                    case 7:
                        return 1276;
                    case 8:
                        return 6396;
                    default:
                        switch (i2) {
                            case 12:
                                return 743676;
                            case 13:
                                i3 = 30136348;
                                break;
                            case 14:
                                i3 = 202070268;
                                break;
                            default:
                                return 0;
                        }
                }
            } else {
                i3 = 67108860;
            }
            i4 = 0;
        } else {
            i3 = 737532;
        }
        return Build.VERSION.SDK_INT >= 32 ? i3 : i4;
    }

    public static int c(int i2) {
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
                        switch (i2) {
                            case 20:
                                return 30;
                            case 21:
                            case 22:
                                return 31;
                            default:
                                return Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        }
                }
        }
    }

    public static int d(int i2) {
        if (i2 != 2) {
            if (i2 == 3) {
                return 1;
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
                return 3;
            }
            return 4;
        }
        return 2;
    }

    public static int e(int i2) {
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

    public static int f(int i2, int i3, byte[] bArr, int i4) {
        while (i2 < i3) {
            i4 = f31260g[(i4 >>> 24) ^ (bArr[i2] & 255)] ^ (i4 << 8);
            i2++;
        }
        return i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
    
        r5.C(r4);
        r4 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean g(com.google.android.gms.internal.ads.zzer r4, com.google.android.gms.internal.ads.zzer r5, java.util.zip.Inflater r6) {
        /*
            int r0 = r4.B()
            r1 = 0
            if (r0 <= 0) goto L75
            int r0 = r4.I()
            r2 = 120(0x78, float:1.68E-43)
            if (r0 != r2) goto L75
            int r0 = r4.B()
            r2 = 1
            if (r0 != 0) goto L18
            r4 = r1
            goto L72
        L18:
            byte[] r0 = r5.f30144a
            int r0 = r0.length
            int r3 = r4.B()
            if (r0 >= r3) goto L29
            int r0 = r4.B()
            int r0 = r0 + r0
            r5.A(r0)
        L29:
            if (r6 != 0) goto L30
            java.util.zip.Inflater r6 = new java.util.zip.Inflater
            r6.<init>()
        L30:
            byte[] r0 = r4.f30144a
            int r3 = r4.f30145b
            int r4 = r4.B()
            r6.setInput(r0, r3, r4)
            r4 = r1
        L3c:
            byte[] r0 = r5.f30144a     // Catch: java.lang.Throwable -> L50 java.util.zip.DataFormatException -> L5e
            int r3 = r0.length     // Catch: java.lang.Throwable -> L50 java.util.zip.DataFormatException -> L5e
            int r3 = r3 - r4
            int r0 = r6.inflate(r0, r4, r3)     // Catch: java.lang.Throwable -> L50 java.util.zip.DataFormatException -> L5e
            int r4 = r4 + r0
            boolean r0 = r6.finished()     // Catch: java.lang.Throwable -> L50 java.util.zip.DataFormatException -> L5e
            if (r0 == 0) goto L52
            r5.C(r4)     // Catch: java.lang.Throwable -> L50 java.util.zip.DataFormatException -> L5e
            r4 = r2
            goto L6f
        L50:
            r4 = move-exception
            goto L6b
        L52:
            boolean r0 = r6.needsDictionary()     // Catch: java.lang.Throwable -> L50 java.util.zip.DataFormatException -> L5e
            if (r0 != 0) goto L5e
            boolean r0 = r6.needsInput()     // Catch: java.lang.Throwable -> L50 java.util.zip.DataFormatException -> L5e
            if (r0 == 0) goto L60
        L5e:
            r4 = r1
            goto L6f
        L60:
            byte[] r0 = r5.f30144a     // Catch: java.lang.Throwable -> L50 java.util.zip.DataFormatException -> L5e
            int r3 = r0.length     // Catch: java.lang.Throwable -> L50 java.util.zip.DataFormatException -> L5e
            if (r4 != r3) goto L3c
            int r0 = r0.length     // Catch: java.lang.Throwable -> L50 java.util.zip.DataFormatException -> L5e
            int r0 = r0 + r0
            r5.A(r0)     // Catch: java.lang.Throwable -> L50 java.util.zip.DataFormatException -> L5e
            goto L3c
        L6b:
            r6.reset()
            throw r4
        L6f:
            r6.reset()
        L72:
            if (r4 == 0) goto L75
            return r2
        L75:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfj.g(com.google.android.gms.internal.ads.zzer, com.google.android.gms.internal.ads.zzer, java.util.zip.Inflater):boolean");
    }

    public static boolean h(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static int i(String str) throws NumberFormatException {
        String[] strArrSplit;
        int length;
        if (str == null || (length = (strArrSplit = str.split(Attributes.PREDEFINED_ATTRIBUTE_PREFIX, -1)).length) < 2) {
            return 0;
        }
        String str2 = strArrSplit[length - 1];
        boolean z = length >= 3 && "neg".equals(strArrSplit[length + (-2)]);
        try {
            if (str2 == null) {
                throw null;
            }
            int i2 = Integer.parseInt(str2);
            return z ? -i2 : i2;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static boolean j(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 29 || context.getApplicationInfo().targetSdkVersion < 29) {
            return true;
        }
        if (i2 == 30) {
            String str = Build.MODEL;
            if (zzgpj.d("moto g(20)", str) || zzgpj.d("rmx3231", str)) {
                return true;
            }
        }
        return i2 == 34 && zzgpj.d("sm-x200", Build.MODEL);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long k(long r9, long r11, long r13, java.math.RoundingMode r15) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfj.k(long, long, long, java.math.RoundingMode):long");
    }

    public static String l(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e2) {
            zzee.f("Util", "Failed to read system property ".concat(str), e2);
            return null;
        }
    }

    public static Object[] m(Object[] objArr, int i2) {
        zzgqa.a(i2 <= objArr.length);
        return Arrays.copyOf(objArr, i2);
    }

    public static Handler n() {
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        return new Handler(looperMyLooper, null);
    }

    public static String o(String str) throws MissingResourceException {
        if (str == null) {
            return null;
        }
        String strReplace = str.replace('_', Soundex.SILENT_MARKER);
        if (!strReplace.isEmpty() && !strReplace.equals("und")) {
            str = strReplace;
        }
        String strA = zzgpj.a(str);
        int i2 = 0;
        String str2 = strA.split("-", 2)[0];
        if (f31257d == null) {
            String[] iSOLanguages = Locale.getISOLanguages();
            int length = iSOLanguages.length;
            String[] strArr = f31258e;
            int length2 = strArr.length;
            HashMap map = new HashMap(length + 88);
            for (String str3 : iSOLanguages) {
                try {
                    String iSO3Language = new Locale(str3).getISO3Language();
                    if (!TextUtils.isEmpty(iSO3Language)) {
                        map.put(iSO3Language, str3);
                    }
                } catch (MissingResourceException unused) {
                }
            }
            for (int i3 = 0; i3 < 88; i3 += 2) {
                map.put(strArr[i3], strArr[i3 + 1]);
            }
            f31257d = map;
        }
        String str4 = (String) f31257d.get(str2);
        if (str4 != null) {
            strA = str4.concat(String.valueOf(strA.substring(str2.length())));
            str2 = str4;
        }
        if (!"no".equals(str2) && !"i".equals(str2) && !"zh".equals(str2)) {
            return strA;
        }
        while (true) {
            String[] strArr2 = f31259f;
            int length3 = strArr2.length;
            if (i2 >= 18) {
                return strA;
            }
            if (strA.startsWith(strArr2[i2])) {
                return String.valueOf(strArr2[i2 + 1]).concat(String.valueOf(strA.substring(strArr2[i2].length())));
            }
            i2 += 2;
        }
    }

    public static int p(int[] iArr, int i2, boolean z, boolean z2) {
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

    public static int q(long[] jArr, long j2, boolean z) {
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

    public static long r(long j2) {
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 / 1000;
    }

    public static long s(long j2) {
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 * 1000;
    }

    public static long t(int i2, long j2) {
        return u(j2, 1000000L, i2, RoundingMode.DOWN);
    }

    public static long u(long j2, long j3, long j4, RoundingMode roundingMode) {
        if (j2 == 0 || j3 == 0) {
            return 0L;
        }
        return (j4 < j3 || j4 % j3 != 0) ? (j4 >= j3 || j3 % j4 != 0) ? (j4 < j2 || j4 % j2 != 0) ? (j4 >= j2 || j2 % j4 != 0) ? k(j2, j3, j4, roundingMode) : zzgws.c(j3, zzgws.a(j2, j4, RoundingMode.UNNECESSARY)) : zzgws.a(j3, zzgws.a(j4, j2, RoundingMode.UNNECESSARY), roundingMode) : zzgws.c(j2, zzgws.a(j3, j4, RoundingMode.UNNECESSARY)) : zzgws.a(j2, zzgws.a(j4, j3, RoundingMode.UNNECESSARY), roundingMode);
    }

    public static void v(long[] jArr, long j2) {
        long j3;
        RoundingMode roundingMode = RoundingMode.DOWN;
        int i2 = 0;
        if (j2 >= 1000000 && j2 % 1000000 == 0) {
            long jA = zzgws.a(j2, 1000000L, RoundingMode.UNNECESSARY);
            while (i2 < jArr.length) {
                jArr[i2] = zzgws.a(jArr[i2], jA, roundingMode);
                i2++;
            }
            return;
        }
        if (j2 < 1000000 && 1000000 % j2 == 0) {
            long jA2 = zzgws.a(1000000L, j2, RoundingMode.UNNECESSARY);
            while (i2 < jArr.length) {
                jArr[i2] = zzgws.c(jArr[i2], jA2);
                i2++;
            }
            return;
        }
        int i3 = 0;
        while (i3 < jArr.length) {
            long j4 = jArr[i3];
            if (j4 != 0) {
                if (j2 >= j4 && j2 % j4 == 0) {
                    jArr[i3] = zzgws.a(1000000L, zzgws.a(j2, j4, RoundingMode.UNNECESSARY), roundingMode);
                } else if (j2 >= j4 || j4 % j2 != 0) {
                    j3 = j2;
                    jArr[i3] = k(j4, 1000000L, j3, roundingMode);
                } else {
                    jArr[i3] = zzgws.c(1000000L, zzgws.a(j4, j2, RoundingMode.UNNECESSARY));
                }
                j3 = j2;
            } else {
                j3 = j2;
            }
            i3++;
            j2 = j3;
        }
    }

    public static long w(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(j2 * f2);
    }

    public static String x(int i2) {
        return new String(new byte[]{(byte) (i2 >> 24), (byte) (i2 >> 16), (byte) (i2 >> 8), (byte) i2}, StandardCharsets.US_ASCII);
    }

    public static int y(int i2, ByteOrder byteOrder) {
        if (i2 == 8) {
            return 3;
        }
        if (i2 == 16) {
            return byteOrder.equals(ByteOrder.LITTLE_ENDIAN) ? 2 : 268435456;
        }
        if (i2 == 24) {
            return byteOrder.equals(ByteOrder.LITTLE_ENDIAN) ? 21 : 1342177280;
        }
        if (i2 != 32) {
            return 0;
        }
        return byteOrder.equals(ByteOrder.LITTLE_ENDIAN) ? 22 : 1610612736;
    }
}

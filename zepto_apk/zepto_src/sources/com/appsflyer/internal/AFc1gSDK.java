package com.appsflyer.internal;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.appsflyer.AFLogger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class AFc1gSDK extends HashMap<String, Object> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long AFAdRevenueData = 0;
    private static int areAllFieldsValid = 1;
    private static int[] getCurrencyIso4217Code;
    private static int getMonetizationNetwork;
    private final Map<String, Object> getMediationNetwork;
    private final Context getRevenue;

    @VisibleForTesting
    public static class AFa1vSDK {
        public static byte[] getMediationNetwork(@NonNull byte[] bArr) throws Exception {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr[i2] = (byte) (bArr[i2] ^ ((i2 % 2) + 42));
            }
            return bArr;
        }

        @NonNull
        public static byte[] getMonetizationNetwork(@NonNull String str) throws Exception {
            return str.getBytes(Charset.defaultCharset());
        }
    }

    static {
        getMediationNetwork();
        TextUtils.indexOf("", "");
        KeyEvent.getModifierMetaStateMask();
        ViewConfiguration.getScrollDefaultDelay();
        SystemClock.currentThreadTimeMillis();
        KeyEvent.getDeadChar(0, 0);
        ViewConfiguration.getTapTimeout();
        ExpandableListView.getPackedPositionForGroup(0);
        int i2 = getMonetizationNetwork + 5;
        areAllFieldsValid = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    @WorkerThread
    public AFc1gSDK(Map<String, Object> map, Context context) {
        this.getMediationNetwork = map;
        this.getRevenue = context;
        put(getMonetizationNetwork(), getCurrencyIso4217Code());
    }

    private static void a(String str, int i2, Object[] objArr) {
        int i3 = $10 + 21;
        $11 = i3 % 128;
        char[] charArray = str;
        if (i3 % 2 == 0) {
            throw null;
        }
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = charArray;
        AFk1pSDK aFk1pSDK = new AFk1pSDK();
        aFk1pSDK.getMediationNetwork = i2;
        int length = cArr.length;
        long[] jArr = new long[length];
        aFk1pSDK.getRevenue = 0;
        while (true) {
            int i4 = aFk1pSDK.getRevenue;
            if (i4 >= cArr.length) {
                break;
            }
            jArr[i4] = (cArr[i4] ^ (i4 * aFk1pSDK.getMediationNetwork)) ^ (AFAdRevenueData ^ 199061409475100049L);
            aFk1pSDK.getRevenue = i4 + 1;
        }
        char[] cArr2 = new char[length];
        aFk1pSDK.getRevenue = 0;
        while (true) {
            int i5 = aFk1pSDK.getRevenue;
            if (i5 >= cArr.length) {
                objArr[0] = new String(cArr2);
                return;
            }
            int i6 = $11 + 97;
            int i7 = i6 % 128;
            $10 = i7;
            if (i6 % 2 != 0) {
                cArr2[i5] = (char) jArr[i5];
            } else {
                cArr2[i5] = (char) jArr[i5];
                i5++;
            }
            aFk1pSDK.getRevenue = i5;
            $11 = (i7 + 95) % 128;
        }
    }

    private static void b(int[] iArr, int i2, Object[] objArr) {
        AFk1kSDK aFk1kSDK = new AFk1kSDK();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = getCurrencyIso4217Code;
        if (iArr2 != null) {
            $11 = ($10 + 61) % 128;
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i3 = 0; i3 < length; i3++) {
                iArr3[i3] = (int) (iArr2[i3] ^ 3670241895213185600L);
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = getCurrencyIso4217Code;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i4 = 0;
            while (i4 < length3) {
                int i5 = $11 + 57;
                $10 = i5 % 128;
                if (i5 % 2 != 0) {
                    iArr6[i4] = (int) (iArr5[i4] / 3670241895213185600L);
                    i4 >>= 1;
                } else {
                    iArr6[i4] = (int) (iArr5[i4] ^ 3670241895213185600L);
                    i4++;
                }
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        aFk1kSDK.getCurrencyIso4217Code = 0;
        while (true) {
            int i6 = aFk1kSDK.getCurrencyIso4217Code;
            if (i6 >= iArr.length) {
                objArr[0] = new String(cArr2, 0, i2);
                return;
            }
            int i7 = iArr[i6];
            char c2 = (char) (i7 >> 16);
            cArr[0] = c2;
            char c3 = (char) i7;
            cArr[1] = c3;
            char c4 = (char) (iArr[i6 + 1] >> 16);
            cArr[2] = c4;
            char c5 = (char) iArr[i6 + 1];
            cArr[3] = c5;
            aFk1kSDK.AFAdRevenueData = (c2 << 16) + c3;
            aFk1kSDK.getMonetizationNetwork = (c4 << 16) + c5;
            AFk1kSDK.getMediationNetwork(iArr4);
            for (int i8 = 0; i8 < 16; i8++) {
                int i9 = aFk1kSDK.AFAdRevenueData ^ iArr4[i8];
                aFk1kSDK.AFAdRevenueData = i9;
                int iAFAdRevenueData = AFk1kSDK.AFAdRevenueData(i9) ^ aFk1kSDK.getMonetizationNetwork;
                int i10 = aFk1kSDK.AFAdRevenueData;
                aFk1kSDK.AFAdRevenueData = iAFAdRevenueData;
                aFk1kSDK.getMonetizationNetwork = i10;
            }
            int i11 = aFk1kSDK.AFAdRevenueData;
            int i12 = aFk1kSDK.getMonetizationNetwork;
            aFk1kSDK.AFAdRevenueData = i12;
            aFk1kSDK.getMonetizationNetwork = i11;
            int i13 = i11 ^ iArr4[16];
            aFk1kSDK.getMonetizationNetwork = i13;
            int i14 = i12 ^ iArr4[17];
            aFk1kSDK.AFAdRevenueData = i14;
            cArr[0] = (char) (i14 >>> 16);
            cArr[1] = (char) i14;
            cArr[2] = (char) (i13 >>> 16);
            cArr[3] = (char) i13;
            AFk1kSDK.getMediationNetwork(iArr4);
            int i15 = aFk1kSDK.getCurrencyIso4217Code;
            cArr2[i15 * 2] = cArr[0];
            cArr2[(i15 * 2) + 1] = cArr[1];
            cArr2[(i15 * 2) + 2] = cArr[2];
            cArr2[(i15 * 2) + 3] = cArr[3];
            aFk1kSDK.getCurrencyIso4217Code = i15 + 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x01a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String getCurrencyIso4217Code() {
        /*
            Method dump skipped, instructions count: 1052
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1gSDK.getCurrencyIso4217Code():java.lang.String");
    }

    @VisibleForTesting
    private static StringBuilder getMediationNetwork(@NonNull String... strArr) throws Exception {
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        for (int i2 = 0; i2 < 3; i2++) {
            arrayList.add(Integer.valueOf(strArr[i2].length()));
        }
        Collections.sort(arrayList);
        int iIntValue = ((Integer) arrayList.get(0)).intValue();
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < iIntValue; i3++) {
            getMonetizationNetwork = (areAllFieldsValid + 47) % 128;
            Integer numValueOf = null;
            for (int i4 = 0; i4 < 3; i4++) {
                int iCharAt = strArr[i4].charAt(i3);
                if (numValueOf != null) {
                    iCharAt ^= numValueOf.intValue();
                }
                numValueOf = Integer.valueOf(iCharAt);
            }
            sb.append(Integer.toHexString(numValueOf.intValue()));
        }
        return sb;
    }

    @NonNull
    private String getMonetizationNetwork() {
        getMonetizationNetwork = (areAllFieldsValid + 3) % 128;
        try {
            String string = Integer.toString(Build.VERSION.SDK_INT);
            Map<String, Object> map = this.getMediationNetwork;
            Object[] objArr = new Object[1];
            a("ٓ䛅蝏쟵П䒊蔱얶ˎ䍊菵쁹", 16530 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), objArr);
            String string2 = map.get(((String) objArr[0]).intern()).toString();
            Map<String, Object> map2 = this.getMediationNetwork;
            Object[] objArr2 = new Object[1];
            a("ِ彗둽ങ戊", View.getDefaultSize(0, 0) + 22807, objArr2);
            String string3 = map2.get(((String) objArr2[0]).intern()).toString();
            if (string3 == null) {
                areAllFieldsValid = (getMonetizationNetwork + 29) % 128;
                Object[] objArr3 = new Object[1];
                a("ټ\u0cd4ጿᦋⳄ㌾㦊䳩", 2729 - View.MeasureSpec.getSize(0), objArr3);
                string3 = ((String) objArr3[0]).intern();
            }
            StringBuilder sb = new StringBuilder(string2);
            sb.reverse();
            StringBuilder mediationNetwork = getMediationNetwork(string, string3, sb.toString());
            int length = mediationNetwork.length();
            if (length > 4) {
                mediationNetwork.delete(4, length);
            } else {
                while (length < 4) {
                    length++;
                    mediationNetwork.append('1');
                }
            }
            Object[] objArr4 = new Object[1];
            b(new int[]{-269708407, 691550562}, Color.green(0) + 3, objArr4);
            mediationNetwork.insert(0, ((String) objArr4[0]).intern());
            return mediationNetwork.toString();
        } catch (Exception e2) {
            Object[] objArr5 = new Object[1];
            b(new int[]{854565745, 306981016, 2092009709, 1211146027, -1997348285, -2069302082, -1014555636, -1115818356, 1491143540, 297822326, -891867092, 74755836, -538226225, -689317204, -1794805564, -1830683349, -1867036264, 1235626699, 1541426602, 1401202182}, 40 - Color.argb(0, 0, 0, 0), objArr5);
            AFLogger.afErrorLogForExcManagerOnly(((String) objArr5[0]).intern(), e2);
            StringBuilder sb2 = new StringBuilder();
            Object[] objArr6 = new Object[1];
            b(new int[]{-1080009004, 844403482, -683446169, 2011701581, 1233271862, -317730360, 474044529, -1279916753, -2006198622, 428775418, 1632684225, -344979390, -1051640727, -1500483547, 1921909678, 1197372451, 1709650531, 1369506269, 1275252993, 1437497808, 761424572, -1240279331}, 42 - (KeyEvent.getMaxKeyCode() >> 16), objArr6);
            sb2.append(((String) objArr6[0]).intern());
            sb2.append(e2);
            AFLogger.afRDLog(sb2.toString());
            Object[] objArr7 = new Object[1];
            b(new int[]{-2132896634, 840027810, -513331929, 1353535124}, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 8, objArr7);
            return ((String) objArr7[0]).intern();
        }
    }

    public static void getMediationNetwork() {
        AFAdRevenueData = -8351283963653293149L;
        getCurrencyIso4217Code = new int[]{442543737, -1490671600, 624544975, 963078580, -38548639, -1507093695, -433807488, 2027768116, 1333435861, -1679971940, -735591064, 871109200, 1542131051, 1882103064, 1923897460, -2041115963, 1803608463, -148454374};
    }
}

package com.appsflyer.internal;

import android.os.Build;
import android.widget.ExpandableListView;
import androidx.annotation.WorkerThread;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFd1vSDK;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes.dex */
public final class AFd1uSDK implements AFd1vSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int AFLogger = 1;
    private static int copydefault;

    @NotNull
    private final Lazy AFAdRevenueData;

    @NotNull
    private final Lazy areAllFieldsValid;

    @NotNull
    private final String component1;

    @Nullable
    private AFd1vSDK.AFa1ySDK component2;

    @NotNull
    private final Lazy component3;

    @NotNull
    private final Lazy component4;

    @NotNull
    private final Lazy getCurrencyIso4217Code;

    @NotNull
    private AFc1dSDK getMediationNetwork;

    @NotNull
    private final Lazy getMonetizationNetwork;

    @NotNull
    private final Lazy getRevenue;
    private static char[] hashCode = {8636, 8652, 8639, 8648, 8626};
    private static int equals = -771284898;
    private static boolean toString = true;
    private static boolean copy = true;

    public AFd1uSDK(@NotNull AFc1dSDK aFc1dSDK) {
        Intrinsics.checkNotNullParameter(aFc1dSDK, "");
        this.getMediationNetwork = aFc1dSDK;
        this.AFAdRevenueData = LazyKt.b(new Function0<AFf1oSDK>() { // from class: com.appsflyer.internal.AFd1uSDK.5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            /* renamed from: getCurrencyIso4217Code, reason: merged with bridge method [inline-methods] */
            public final AFf1oSDK invoke() {
                AFf1oSDK aFf1oSDKComponent1 = AFd1uSDK.getCurrencyIso4217Code(AFd1uSDK.this).component1();
                Intrinsics.checkNotNullExpressionValue(aFf1oSDKComponent1, "");
                return aFf1oSDKComponent1;
            }
        });
        this.getMonetizationNetwork = LazyKt.b(new Function0<AFc1pSDK>() { // from class: com.appsflyer.internal.AFd1uSDK.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            /* renamed from: getCurrencyIso4217Code, reason: merged with bridge method [inline-methods] */
            public final AFc1pSDK invoke() {
                AFc1pSDK revenue = AFd1uSDK.getCurrencyIso4217Code(AFd1uSDK.this).getRevenue();
                Intrinsics.checkNotNullExpressionValue(revenue, "");
                return revenue;
            }
        });
        this.getRevenue = LazyKt.b(new Function0<AFc1qSDK>() { // from class: com.appsflyer.internal.AFd1uSDK.4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            /* renamed from: AFAdRevenueData, reason: merged with bridge method [inline-methods] */
            public final AFc1qSDK invoke() {
                AFc1qSDK aFc1qSDKComponent2 = AFd1uSDK.getCurrencyIso4217Code(AFd1uSDK.this).component2();
                Intrinsics.checkNotNullExpressionValue(aFc1qSDKComponent2, "");
                return aFc1qSDKComponent2;
            }
        });
        this.getCurrencyIso4217Code = LazyKt.b(new Function0<AFf1gSDK>() { // from class: com.appsflyer.internal.AFd1uSDK.10
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            /* renamed from: getRevenue, reason: merged with bridge method [inline-methods] */
            public final AFf1gSDK invoke() {
                AFf1gSDK aFf1gSDKRegisterClient = AFd1uSDK.getCurrencyIso4217Code(AFd1uSDK.this).registerClient();
                Intrinsics.checkNotNullExpressionValue(aFf1gSDKRegisterClient, "");
                return aFf1gSDKRegisterClient;
            }
        });
        this.areAllFieldsValid = LazyKt.b(new Function0<ExecutorService>() { // from class: com.appsflyer.internal.AFd1uSDK.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            /* renamed from: AFAdRevenueData, reason: merged with bridge method [inline-methods] */
            public final ExecutorService invoke() {
                ExecutorService monetizationNetwork = AFd1uSDK.getCurrencyIso4217Code(AFd1uSDK.this).getMonetizationNetwork();
                Intrinsics.checkNotNullExpressionValue(monetizationNetwork, "");
                return monetizationNetwork;
            }
        });
        this.component1 = "6.17.0";
        this.component4 = LazyKt.b(new Function0<AFc1bSDK>() { // from class: com.appsflyer.internal.AFd1uSDK.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            /* renamed from: getRevenue, reason: merged with bridge method [inline-methods] */
            public final AFc1bSDK invoke() {
                AFc1iSDK aFc1iSDKAFInAppEventType = AFd1uSDK.getCurrencyIso4217Code(AFd1uSDK.this).AFInAppEventType();
                Intrinsics.checkNotNullExpressionValue(aFc1iSDKAFInAppEventType, "");
                return new AFc1bSDK(aFc1iSDKAFInAppEventType);
            }
        });
        this.component3 = LazyKt.b(new Function0<AFd1ySDK>() { // from class: com.appsflyer.internal.AFd1uSDK.6
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            /* renamed from: AFAdRevenueData, reason: merged with bridge method [inline-methods] */
            public final AFd1ySDK invoke() {
                return new AFd1ySDK(AFd1uSDK.this.getRevenue());
            }
        });
    }

    private final ExecutorService areAllFieldsValid() {
        AFLogger = (copydefault + 47) % 128;
        ExecutorService executorService = (ExecutorService) this.areAllFieldsValid.getValue();
        AFLogger = (copydefault + 37) % 128;
        return executorService;
    }

    private final AFh1dSDK component1() {
        return (AFh1dSDK) getMediationNetwork(new Object[]{this}, 855295870, -855295867, System.identityHashCode(this));
    }

    private final AFc1qSDK component2() {
        int i2 = copydefault + 19;
        AFLogger = i2 % 128;
        if (i2 % 2 != 0) {
            return (AFc1qSDK) this.getRevenue.getValue();
        }
        throw null;
    }

    @NotNull
    private AFd1xSDK component3() {
        return (AFd1xSDK) getMediationNetwork(new Object[]{this}, -704520981, 704520985, System.identityHashCode(this));
    }

    private final AFf1gSDK component4() {
        int i2 = AFLogger + 17;
        copydefault = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
        AFf1gSDK aFf1gSDK = (AFf1gSDK) this.getCurrencyIso4217Code.getValue();
        AFLogger = (copydefault + WKSRecord.Service.UUCP_PATH) % 128;
        return aFf1gSDK;
    }

    private final synchronized void copy() {
        boolean monetizationNetwork;
        try {
            AFh1dSDK aFh1dSDK = (AFh1dSDK) getMediationNetwork(new Object[]{this}, 855295870, -855295867, System.identityHashCode(this));
            if (aFh1dSDK != null) {
                int i2 = copydefault + 57;
                AFLogger = i2 % 128;
                if (i2 % 2 == 0) {
                    throw null;
                }
                if (aFh1dSDK.AFAdRevenueData == -1) {
                    component2().getMonetizationNetwork("af_send_exc_to_server_window");
                } else if (component2().getCurrencyIso4217Code("af_send_exc_to_server_window", -1L) == -1) {
                    AFLogger = (copydefault + WKSRecord.Service.NNTP) % 128;
                    getRevenue(aFh1dSDK);
                }
                monetizationNetwork = getMonetizationNetwork(aFh1dSDK);
            } else {
                monetizationNetwork = false;
            }
            AFd1vSDK.AFa1ySDK aFa1ySDK = this.component2;
            if (aFa1ySDK == null) {
                copydefault = (AFLogger + 107) % 128;
            } else {
                copydefault = (AFLogger + 73) % 128;
                aFa1ySDK.onConfigurationChanged(monetizationNetwork);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b8 A[Catch: all -> 0x001a, PHI: r0
      0x00b8: PHI (r0v26 java.lang.String) = (r0v25 java.lang.String), (r0v39 java.lang.String) binds: [B:35:0x00b6, B:30:0x00af] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {all -> 0x001a, blocks: (B:3:0x0001, B:5:0x0017, B:9:0x001f, B:11:0x002e, B:13:0x0039, B:16:0x0057, B:19:0x0075, B:21:0x0086, B:23:0x008d, B:25:0x009f, B:27:0x00aa, B:36:0x00b8, B:38:0x00ca, B:40:0x00d4, B:42:0x00da, B:44:0x00e8, B:46:0x00ee, B:48:0x00fc, B:50:0x010a, B:52:0x0118, B:54:0x0126, B:56:0x0134, B:58:0x013a, B:60:0x0140, B:62:0x0156, B:64:0x0159, B:66:0x015f, B:68:0x016f, B:70:0x0173, B:72:0x0179, B:74:0x0189, B:76:0x018d, B:82:0x019c, B:89:0x01ff, B:91:0x0203, B:93:0x0213, B:94:0x021f, B:84:0x01ac, B:86:0x01c6, B:87:0x01de, B:79:0x0194, B:61:0x014d, B:33:0x00b3, B:34:0x00b4, B:88:0x01ef, B:29:0x00ae), top: B:103:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fc A[Catch: all -> 0x001a, TryCatch #1 {all -> 0x001a, blocks: (B:3:0x0001, B:5:0x0017, B:9:0x001f, B:11:0x002e, B:13:0x0039, B:16:0x0057, B:19:0x0075, B:21:0x0086, B:23:0x008d, B:25:0x009f, B:27:0x00aa, B:36:0x00b8, B:38:0x00ca, B:40:0x00d4, B:42:0x00da, B:44:0x00e8, B:46:0x00ee, B:48:0x00fc, B:50:0x010a, B:52:0x0118, B:54:0x0126, B:56:0x0134, B:58:0x013a, B:60:0x0140, B:62:0x0156, B:64:0x0159, B:66:0x015f, B:68:0x016f, B:70:0x0173, B:72:0x0179, B:74:0x0189, B:76:0x018d, B:82:0x019c, B:89:0x01ff, B:91:0x0203, B:93:0x0213, B:94:0x021f, B:84:0x01ac, B:86:0x01c6, B:87:0x01de, B:79:0x0194, B:61:0x014d, B:33:0x00b3, B:34:0x00b4, B:88:0x01ef, B:29:0x00ae), top: B:103:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final synchronized void copydefault() {
        /*
            Method dump skipped, instructions count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1uSDK.copydefault():void");
    }

    private final void equals() {
        AFh1dSDK aFh1dSDK;
        int i2 = copydefault + WKSRecord.Service.NNTP;
        AFLogger = i2 % 128;
        if (i2 % 2 == 0) {
            aFh1dSDK = (AFh1dSDK) getMediationNetwork(new Object[]{this}, 855295870, -855295867, System.identityHashCode(this));
            int i3 = 59 / 0;
            if (aFh1dSDK == null) {
                return;
            }
        } else {
            aFh1dSDK = (AFh1dSDK) getMediationNetwork(new Object[]{this}, 855295870, -855295867, System.identityHashCode(this));
            if (aFh1dSDK == null) {
                return;
            }
        }
        if (!getCurrencyIso4217Code(aFh1dSDK)) {
            AFg1gSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.EXCEPTION_MANAGER, "skipping", false, 4, null);
            return;
        }
        int i4 = AFLogger + 33;
        copydefault = i4 % 128;
        if (i4 % 2 != 0) {
            component4().getMediationNetwork();
            throw null;
        }
        String mediationNetwork = component4().getMediationNetwork();
        if (mediationNetwork != null) {
            String string = new JSONObject((Map) getMediationNetwork(new Object[]{AFAdRevenueData(aFh1dSDK), getRevenue().getMediationNetwork()}, -1072478634, 1072478634, (int) System.currentTimeMillis())).toString();
            Intrinsics.checkNotNullExpressionValue(string, "");
            Intrinsics.checkNotNullExpressionValue(mediationNetwork, "");
            getCurrencyIso4217Code(string, mediationNetwork);
        }
    }

    public static final /* synthetic */ AFc1dSDK getCurrencyIso4217Code(AFd1uSDK aFd1uSDK) {
        int i2 = AFLogger + WKSRecord.Service.UUCP_PATH;
        int i3 = i2 % 128;
        copydefault = i3;
        int i4 = i2 % 2;
        AFc1dSDK aFc1dSDK = aFd1uSDK.getMediationNetwork;
        if (i4 != 0) {
            throw null;
        }
        AFLogger = (i3 + 47) % 128;
        return aFc1dSDK;
    }

    public static Object getMediationNetwork(Object[] objArr, int i2, int i3, int i4) {
        int i5 = (i3 * (-344)) + (i2 * (-344));
        int i6 = ~i2;
        int i7 = ~i3;
        int i8 = i6 | i7;
        int i9 = ((~(i8 | i4)) * 345) + (((~(i2 | i7)) | (~(i6 | (~i4)))) * 345) + (((~i8) | (~(i6 | i4))) * 345) + i5;
        if (i9 == 1) {
            return getCurrencyIso4217Code(objArr);
        }
        if (i9 == 2) {
            return AFAdRevenueData(objArr);
        }
        if (i9 == 3) {
            return getRevenue(objArr);
        }
        if (i9 == 4) {
            AFd1uSDK aFd1uSDK = (AFd1uSDK) objArr[0];
            copydefault = (AFLogger + 59) % 128;
            AFd1xSDK aFd1xSDK = (AFd1xSDK) aFd1uSDK.component3.getValue();
            AFLogger = (copydefault + 5) % 128;
            return aFd1xSDK;
        }
        Map map = (Map) objArr[0];
        List list = (List) objArr[1];
        int i10 = AFLogger + 43;
        copydefault = i10 % 128;
        if (i10 % 2 == 0) {
            return MapsKt.h(new Pair("deviceInfo", map), new Pair("excs", AFd1tSDK.getCurrencyIso4217Code(list)));
        }
        Pair[] pairArr = new Pair[2];
        pairArr[0] = new Pair("deviceInfo", map);
        pairArr[0] = new Pair("excs", AFd1tSDK.getCurrencyIso4217Code(list));
        return MapsKt.h(pairArr);
    }

    private final AFf1oSDK getMonetizationNetwork() {
        AFLogger = (copydefault + 99) % 128;
        AFf1oSDK aFf1oSDK = (AFf1oSDK) this.AFAdRevenueData.getValue();
        copydefault = (AFLogger + 11) % 128;
        return aFf1oSDK;
    }

    private static /* synthetic */ Object getRevenue(Object[] objArr) {
        AFd1uSDK aFd1uSDK = (AFd1uSDK) objArr[0];
        AFLogger = (copydefault + 29) % 128;
        AFi1wSDK aFi1wSDK = aFd1uSDK.getMonetizationNetwork().getMediationNetwork.getCurrencyIso4217Code;
        if (aFi1wSDK != null) {
            int i2 = AFLogger + 37;
            copydefault = i2 % 128;
            if (i2 % 2 != 0) {
                AFh1cSDK aFh1cSDK = aFi1wSDK.getMonetizationNetwork;
                throw null;
            }
            AFh1cSDK aFh1cSDK2 = aFi1wSDK.getMonetizationNetwork;
            if (aFh1cSDK2 != null) {
                return aFh1cSDK2.getRevenue;
            }
        }
        return null;
    }

    @Override // com.appsflyer.internal.AFd1vSDK
    public final void AFAdRevenueData(@Nullable AFd1vSDK.AFa1ySDK aFa1ySDK) {
        int i2 = AFLogger + 21;
        copydefault = i2 % 128;
        if (i2 % 2 == 0) {
            this.component2 = aFa1ySDK;
            areAllFieldsValid().execute(new i(this, 1));
        } else {
            this.component2 = aFa1ySDK;
            areAllFieldsValid().execute(new i(this, 1));
            throw null;
        }
    }

    private static void a(String str, int[] iArr, String str2, int i2, Object[] objArr) throws UnsupportedEncodingException {
        int length;
        char[] cArr;
        int i3;
        char[] charArray = str2;
        if (str2 != null) {
            $10 = ($11 + 39) % 128;
            charArray = str2.toCharArray();
        }
        char[] cArr2 = charArray;
        byte[] bytes = str;
        if (str != null) {
            bytes = str.getBytes("ISO-8859-1");
        }
        byte[] bArr = bytes;
        AFk1nSDK aFk1nSDK = new AFk1nSDK();
        char[] cArr3 = hashCode;
        if (cArr3 != null) {
            int i4 = $11 + 61;
            $10 = i4 % 128;
            if (i4 % 2 != 0) {
                length = cArr3.length;
                cArr = new char[length];
                i3 = 1;
            } else {
                length = cArr3.length;
                cArr = new char[length];
                i3 = 0;
            }
            while (i3 < length) {
                $10 = ($11 + 97) % 128;
                cArr[i3] = (char) (cArr3[i3] ^ (-5879130172463570806L));
                i3++;
            }
            cArr3 = cArr;
        }
        int i5 = (int) ((-5879130172463570806L) ^ equals);
        if (copy) {
            int length2 = bArr.length;
            aFk1nSDK.getMonetizationNetwork = length2;
            char[] cArr4 = new char[length2];
            aFk1nSDK.AFAdRevenueData = 0;
            while (true) {
                int i6 = aFk1nSDK.AFAdRevenueData;
                int i7 = aFk1nSDK.getMonetizationNetwork;
                if (i6 >= i7) {
                    objArr[0] = new String(cArr4);
                    return;
                } else {
                    $11 = ($10 + 19) % 128;
                    cArr4[i6] = (char) (cArr3[bArr[(i7 - 1) - i6] + i2] - i5);
                    aFk1nSDK.AFAdRevenueData = i6 + 1;
                }
            }
        } else {
            if (toString) {
                int length3 = cArr2.length;
                aFk1nSDK.getMonetizationNetwork = length3;
                char[] cArr5 = new char[length3];
                aFk1nSDK.AFAdRevenueData = 0;
                while (true) {
                    int i8 = aFk1nSDK.AFAdRevenueData;
                    int i9 = aFk1nSDK.getMonetizationNetwork;
                    if (i8 >= i9) {
                        break;
                    }
                    cArr5[i8] = (char) (cArr3[cArr2[(i9 - 1) - i8] - i2] - i5);
                    aFk1nSDK.AFAdRevenueData = i8 + 1;
                }
                String str3 = new String(cArr5);
                int i10 = $11 + 27;
                $10 = i10 % 128;
                if (i10 % 2 == 0) {
                    objArr[0] = str3;
                    return;
                } else {
                    int i11 = 15 / 0;
                    objArr[0] = str3;
                    return;
                }
            }
            int length4 = iArr.length;
            aFk1nSDK.getMonetizationNetwork = length4;
            char[] cArr6 = new char[length4];
            aFk1nSDK.AFAdRevenueData = 0;
            while (true) {
                int i12 = aFk1nSDK.AFAdRevenueData;
                int i13 = aFk1nSDK.getMonetizationNetwork;
                if (i12 >= i13) {
                    objArr[0] = new String(cArr6);
                    return;
                } else {
                    cArr6[i12] = (char) (cArr3[iArr[(i13 - 1) - i12] - i2] - i5);
                    aFk1nSDK.AFAdRevenueData = i12 + 1;
                }
            }
        }
    }

    private static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr) {
        AFd1uSDK aFd1uSDK = (AFd1uSDK) objArr[0];
        copydefault = (AFLogger + 43) % 128;
        Intrinsics.checkNotNullParameter(aFd1uSDK, "");
        aFd1uSDK.equals();
        int i2 = copydefault + 69;
        AFLogger = i2 % 128;
        if (i2 % 2 == 0) {
            int i3 = 22 / 0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMonetizationNetwork(AFd1uSDK aFd1uSDK) {
        AFLogger = (copydefault + 9) % 128;
        Intrinsics.checkNotNullParameter(aFd1uSDK, "");
        aFd1uSDK.copy();
        AFLogger = (copydefault + 51) % 128;
    }

    @WorkerThread
    private final void getCurrencyIso4217Code(String str, String str2) {
        AFLogger = (copydefault + 53) % 128;
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        ((AFd1xSDK) getMediationNetwork(new Object[]{this}, -704520981, 704520985, System.identityHashCode(this))).getMediationNetwork(bytes, MapsKt.g(new Pair("Authorization", AFj1cSDK.getRevenue(str, str2))), 2000);
        int i2 = copydefault + 95;
        AFLogger = i2 % 128;
        if (i2 % 2 == 0) {
            int i3 = 81 / 0;
        }
    }

    private final boolean getMonetizationNetwork(AFh1dSDK aFh1dSDK) {
        copydefault = (AFLogger + 67) % 128;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long currencyIso4217Code = component2().getCurrencyIso4217Code("af_send_exc_to_server_window", -1L);
        if (aFh1dSDK.getMediationNetwork < TimeUnit.MILLISECONDS.toSeconds(jCurrentTimeMillis)) {
            copydefault = (AFLogger + 25) % 128;
            return false;
        }
        if (currencyIso4217Code == -1 || currencyIso4217Code < jCurrentTimeMillis) {
            return false;
        }
        return getMediationNetwork(aFh1dSDK);
    }

    @Override // com.appsflyer.internal.AFd1vSDK
    public final void AFAdRevenueData() {
        int i2 = copydefault + 61;
        AFLogger = i2 % 128;
        if (i2 % 2 != 0) {
            areAllFieldsValid().execute(new i(this, 0));
            copydefault = (AFLogger + 81) % 128;
        } else {
            areAllFieldsValid().execute(new i(this, 0));
            throw null;
        }
    }

    @NotNull
    public final AFc1aSDK getRevenue() {
        int i2 = copydefault + 41;
        AFLogger = i2 % 128;
        if (i2 % 2 != 0) {
            return (AFc1aSDK) this.component4.getValue();
        }
        throw null;
    }

    private final void getRevenue(AFh1dSDK aFh1dSDK) {
        int i2;
        AFc1qSDK aFc1qSDKComponent2;
        int i3 = copydefault + WKSRecord.Service.SFTP;
        AFLogger = i3 % 128;
        if (i3 % 2 == 0) {
            i2 = aFh1dSDK.getCurrencyIso4217Code;
            long jCurrentTimeMillis = System.currentTimeMillis() ^ TimeUnit.DAYS.toMillis(aFh1dSDK.AFAdRevenueData);
            aFc1qSDKComponent2 = component2();
            aFc1qSDKComponent2.getMonetizationNetwork("af_send_exc_to_server_window", jCurrentTimeMillis);
        } else {
            i2 = aFh1dSDK.getCurrencyIso4217Code;
            long millis = TimeUnit.DAYS.toMillis(aFh1dSDK.AFAdRevenueData) + System.currentTimeMillis();
            aFc1qSDKComponent2 = component2();
            aFc1qSDKComponent2.getMonetizationNetwork("af_send_exc_to_server_window", millis);
        }
        aFc1qSDKComponent2.getMediationNetwork("af_send_exc_min", i2);
    }

    private static /* synthetic */ Object AFAdRevenueData(Object[] objArr) {
        AFd1uSDK aFd1uSDK = (AFd1uSDK) objArr[0];
        int i2 = AFLogger + 79;
        copydefault = i2 % 128;
        if (i2 % 2 != 0) {
            aFd1uSDK.areAllFieldsValid().execute(new i(aFd1uSDK, 2));
            int i3 = 76 / 0;
        } else {
            aFd1uSDK.areAllFieldsValid().execute(new i(aFd1uSDK, 2));
        }
        int i4 = copydefault + 21;
        AFLogger = i4 % 128;
        if (i4 % 2 == 0) {
            int i5 = 93 / 0;
        }
        return null;
    }

    private final boolean getCurrencyIso4217Code(AFh1dSDK aFh1dSDK) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long currencyIso4217Code = component2().getCurrencyIso4217Code("af_send_exc_to_server_window", -1L);
        if (aFh1dSDK.getMediationNetwork < TimeUnit.MILLISECONDS.toSeconds(jCurrentTimeMillis)) {
            return false;
        }
        if (currencyIso4217Code != -1) {
            copydefault = (AFLogger + 27) % 128;
            if (currencyIso4217Code >= jCurrentTimeMillis) {
                int iAFAdRevenueData = component2().AFAdRevenueData("af_send_exc_min", -1);
                if (iAFAdRevenueData == -1 || getRevenue().getCurrencyIso4217Code() < iAFAdRevenueData) {
                    return false;
                }
                return getMediationNetwork(aFh1dSDK);
            }
        }
        copydefault = (AFLogger + 13) % 128;
        return false;
    }

    private final AFc1pSDK getMediationNetwork() {
        copydefault = (AFLogger + 87) % 128;
        AFc1pSDK aFc1pSDK = (AFc1pSDK) this.getMonetizationNetwork.getValue();
        AFLogger = (copydefault + 59) % 128;
        return aFc1pSDK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMediationNetwork(AFd1uSDK aFd1uSDK, Throwable th, String str) {
        AFh1dSDK aFh1dSDK;
        int i2 = copydefault + 101;
        AFLogger = i2 % 128;
        if (i2 % 2 == 0) {
            Intrinsics.checkNotNullParameter(aFd1uSDK, "");
            Intrinsics.checkNotNullParameter(th, "");
            Intrinsics.checkNotNullParameter(str, "");
            aFh1dSDK = (AFh1dSDK) getMediationNetwork(new Object[]{aFd1uSDK}, 855295870, -855295867, System.identityHashCode(aFd1uSDK));
            int i3 = 90 / 0;
            if (aFh1dSDK == null) {
                return;
            }
        } else {
            Intrinsics.checkNotNullParameter(aFd1uSDK, "");
            Intrinsics.checkNotNullParameter(th, "");
            Intrinsics.checkNotNullParameter(str, "");
            aFh1dSDK = (AFh1dSDK) getMediationNetwork(new Object[]{aFd1uSDK}, 855295870, -855295867, System.identityHashCode(aFd1uSDK));
            if (aFh1dSDK == null) {
                return;
            }
        }
        if (aFd1uSDK.getMonetizationNetwork(aFh1dSDK)) {
            aFd1uSDK.getRevenue().AFAdRevenueData(th, str);
            AFLogger = (copydefault + 91) % 128;
        }
    }

    private final Map<String, String> AFAdRevenueData(AFh1dSDK aFh1dSDK) throws UnsupportedEncodingException {
        Object[] objArr = new Object[1];
        a("\u0085\u0084\u0083\u0082\u0081", null, null, ExpandableListView.getPackedPositionType(0L) + WKSRecord.Service.LOCUS_CON, objArr);
        Map<String, String> mapH = MapsKt.h(new Pair(((String) objArr[0]).intern(), Build.BRAND), new Pair("model", Build.MODEL), new Pair("app_id", getMediationNetwork().getRevenue.getMonetizationNetwork.getPackageName()), new Pair("p_ex", new AFa1vSDK().getMonetizationNetwork()), new Pair("api", String.valueOf(Build.VERSION.SDK_INT)), new Pair("sdk", this.component1), new Pair("uid", AFb1iSDK.getRevenue(getMediationNetwork().getMonetizationNetwork)), new Pair("exc_config", aFh1dSDK.getMonetizationNetwork()));
        int i2 = copydefault + WKSRecord.Service.LOCUS_MAP;
        AFLogger = i2 % 128;
        if (i2 % 2 != 0) {
            return mapH;
        }
        throw null;
    }

    @Override // com.appsflyer.internal.AFd1vSDK
    public final void getMediationNetwork(@NotNull Throwable th, @NotNull String str) {
        copydefault = (AFLogger + 75) % 128;
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(str, "");
        areAllFieldsValid().execute(new androidx.media3.common.util.e(this, th, str, 10));
        AFLogger = (copydefault + 53) % 128;
    }

    @Override // com.appsflyer.internal.AFd1vSDK
    public final void getCurrencyIso4217Code() {
        getMediationNetwork(new Object[]{this}, 58037992, -58037990, System.identityHashCode(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMediationNetwork(AFd1uSDK aFd1uSDK) {
        copydefault = (AFLogger + 83) % 128;
        Intrinsics.checkNotNullParameter(aFd1uSDK, "");
        aFd1uSDK.copydefault();
        AFLogger = (copydefault + 105) % 128;
    }

    private final boolean getMediationNetwork(AFh1dSDK aFh1dSDK) {
        new AFd1sSDK();
        String str = this.component1;
        String str2 = aFh1dSDK.getRevenue;
        Intrinsics.checkNotNullExpressionValue(str2, "");
        boolean mediationNetwork = AFd1sSDK.getMediationNetwork(str, str2);
        AFLogger = (copydefault + 79) % 128;
        return mediationNetwork;
    }

    private static Map<String, Object> getMediationNetwork(Map<String, ? extends Object> map, List<AFc1cSDK> list) {
        return (Map) getMediationNetwork(new Object[]{map, list}, -1072478634, 1072478634, (int) System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AFAdRevenueData(AFd1uSDK aFd1uSDK) {
        getMediationNetwork(new Object[]{aFd1uSDK}, 801406437, -801406436, (int) System.currentTimeMillis());
    }
}

package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes.dex */
public final class AFe1zSDK {

    @Nullable
    private static AFe1vSDK component3;

    @NotNull
    public final Lazy AFAdRevenueData;

    @NotNull
    private final Lazy areAllFieldsValid;

    @NotNull
    private final AFc1pSDK getCurrencyIso4217Code;

    @NotNull
    private final AFc1qSDK getMonetizationNetwork;

    @NotNull
    public static final AFa1ySDK AFa1ySDK = new AFa1ySDK(null);

    @NotNull
    public static String getMediationNetwork = "https://%scdn-%ssettings.%s/android/v1/%s/settings";

    @NotNull
    public static String getRevenue = "https://%scdn-%stestsettings.%s/android/v1/%s/settings";

    @NotNull
    private static final List<String> component1 = CollectionsKt.I("googleplay", "playstore", "googleplaystore");

    public /* synthetic */ class AFa1uSDK {
        public static final /* synthetic */ int[] getCurrencyIso4217Code;

        static {
            int[] iArr = new int[AFe1wSDK.values().length];
            try {
                iArr[AFe1wSDK.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AFe1wSDK.API.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AFe1wSDK.RC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            getCurrencyIso4217Code = iArr;
        }
    }

    @Metadata
    public static final class AFa1ySDK {
        private AFa1ySDK() {
        }

        @JvmName
        public static void getMediationNetwork(@Nullable AFe1vSDK aFe1vSDK) {
            AFe1zSDK.component3 = aFe1vSDK;
        }

        @JvmName
        @NotNull
        public static List<String> getRevenue() {
            return AFe1zSDK.component1;
        }

        public /* synthetic */ AFa1ySDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AFe1zSDK(@NotNull AFc1pSDK aFc1pSDK, @NotNull AFc1qSDK aFc1qSDK) {
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFc1qSDK, "");
        this.getCurrencyIso4217Code = aFc1pSDK;
        this.getMonetizationNetwork = aFc1qSDK;
        this.areAllFieldsValid = LazyKt.b(new Function0<String>() { // from class: com.appsflyer.internal.AFe1zSDK.5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            /* renamed from: AFAdRevenueData, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                String monetizationNetwork = AFa1tSDK.getMonetizationNetwork(AFe1zSDK.this.getMonetizationNetwork, AFe1zSDK.this.getCurrencyIso4217Code.component2());
                if (monetizationNetwork != null && !StringsKt.z(monetizationNetwork)) {
                    String string = StringsKt.b0(monetizationNetwork).toString();
                    List<String> revenue = AFa1ySDK.getRevenue();
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "");
                    String lowerCase = string.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                    if (revenue.contains(lowerCase)) {
                        String str = String.format("AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix.", Arrays.copyOf(new Object[]{string}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "");
                        AFLogger.afWarnLog(str);
                        monetizationNetwork = "";
                    } else {
                        monetizationNetwork = "-".concat(string);
                    }
                }
                return StringsKt.b0(monetizationNetwork != null ? monetizationNetwork : "").toString();
            }
        });
        this.AFAdRevenueData = LazyKt.b(new Function0<String>() { // from class: com.appsflyer.internal.AFe1zSDK.4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            /* renamed from: getMediationNetwork, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                String packageName = AFe1zSDK.this.getCurrencyIso4217Code.getRevenue.getMonetizationNetwork.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "");
                return AFe1zSDK.getMonetizationNetwork(packageName, AFe1zSDK.getCurrencyIso4217Code(AFe1zSDK.this));
            }
        });
    }

    @JvmName
    public static boolean AFAdRevenueData() {
        return component3 == null;
    }

    public static final /* synthetic */ String getMonetizationNetwork(String str, String str2) throws NoSuchAlgorithmException {
        String str3 = str + str2;
        Intrinsics.checkNotNullParameter(str3, "");
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        byte[] bytes = str3.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        byte[] bArrDigest = messageDigest.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "");
        String strEncodeToString = Base64.encodeToString(bArrDigest, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "");
        String lowerCase = strEncodeToString.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        String strSubstring = new Regex("[^\\w]+").replace(lowerCase, "").substring(0, 6);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "");
        return strSubstring + CLConstants.DOT_SALT_DELIMETER;
    }

    @JvmName
    @NotNull
    public final String getCurrencyIso4217Code() {
        int i2 = AFa1uSDK.getCurrencyIso4217Code[(AFAdRevenueData() ? AFe1wSDK.DEFAULT : AFe1wSDK.API).ordinal()];
        if (i2 == 1) {
            return (String) this.AFAdRevenueData.getValue();
        }
        if (i2 != 2) {
            if (i2 == 3) {
                return "";
            }
            throw new NoWhenBranchMatchedException();
        }
        AFe1vSDK aFe1vSDK = component3;
        String str = aFe1vSDK != null ? aFe1vSDK.AFAdRevenueData : null;
        return str == null ? "" : str;
    }

    @JvmName
    @NotNull
    public final String getMediationNetwork() {
        int i2 = AFa1uSDK.getCurrencyIso4217Code[(AFAdRevenueData() ? AFe1wSDK.DEFAULT : AFe1wSDK.API).ordinal()];
        if (i2 == 1) {
            return "appsflyersdk.com";
        }
        if (i2 != 2) {
            if (i2 == 3) {
                return "";
            }
            throw new NoWhenBranchMatchedException();
        }
        AFe1vSDK aFe1vSDK = component3;
        String str = aFe1vSDK != null ? aFe1vSDK.getMediationNetwork : null;
        return str == null ? "" : str;
    }

    public static final /* synthetic */ String getCurrencyIso4217Code(AFe1zSDK aFe1zSDK) {
        return (String) aFe1zSDK.areAllFieldsValid.getValue();
    }

    public static final void getMediationNetwork(@Nullable AFe1vSDK aFe1vSDK) {
        AFa1ySDK.getMediationNetwork(aFe1vSDK);
    }
}

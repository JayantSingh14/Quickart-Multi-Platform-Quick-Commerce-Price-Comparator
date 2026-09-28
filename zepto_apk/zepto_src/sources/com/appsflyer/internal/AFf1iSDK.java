package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class AFf1iSDK {

    @NotNull
    public static final AFa1tSDK AFa1tSDK = new AFa1tSDK(null);
    private static final long getMonetizationNetwork = TimeUnit.HOURS.toSeconds(24);

    @NotNull
    private final AFf1lSDK AFAdRevenueData;

    @NotNull
    private final Lazy getCurrencyIso4217Code;

    @NotNull
    private final AFc1pSDK getMediationNetwork;

    @NotNull
    private final Lazy getRevenue;

    @Metadata
    public static final class AFa1tSDK {
        private AFa1tSDK() {
        }

        public /* synthetic */ AFa1tSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AFf1iSDK(@NotNull AFc1pSDK aFc1pSDK, @NotNull AFf1lSDK aFf1lSDK) {
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFf1lSDK, "");
        this.getMediationNetwork = aFc1pSDK;
        this.AFAdRevenueData = aFf1lSDK;
        this.getRevenue = LazyKt.b(new Function0<Boolean>() { // from class: com.appsflyer.internal.AFf1iSDK.4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            /* renamed from: getCurrencyIso4217Code, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                return Boolean.valueOf(Boolean.parseBoolean(AFf1iSDK.this.getMediationNetwork.getCurrencyIso4217Code("com.appsflyer.rc.sandbox")));
            }
        });
        this.getCurrencyIso4217Code = LazyKt.b(new Function0<Boolean>() { // from class: com.appsflyer.internal.AFf1iSDK.5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            /* renamed from: getMonetizationNetwork, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                return Boolean.valueOf(Boolean.parseBoolean(AFf1iSDK.this.getMediationNetwork.getCurrencyIso4217Code("com.appsflyer.rc.staging")));
            }
        });
    }

    public final long AFAdRevenueData() {
        Object objA;
        String currencyIso4217Code = this.getMediationNetwork.getCurrencyIso4217Code("com.appsflyer.rc.cache.max-age-fallback");
        if (currencyIso4217Code == null) {
            return getMonetizationNetwork;
        }
        try {
            Result.Companion companion = Result.f53538b;
            objA = Long.valueOf(Long.parseLong(currencyIso4217Code));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f53538b;
            objA = ResultKt.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AFLogger.afErrorLog("Can't read maxAgeFallback from Manifest: " + thA.getMessage(), thA);
            objA = Long.valueOf(getMonetizationNetwork);
        }
        return ((Number) objA).longValue();
    }

    public final boolean getMediationNetwork() {
        AFi1xSDK aFi1xSDK;
        AFi1wSDK aFi1wSDK = this.AFAdRevenueData.getCurrencyIso4217Code;
        if (aFi1wSDK == null) {
            AFg1gSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.REMOTE_CONTROL, "active config is missing - fetching from CDN", false, 4, null);
            return true;
        }
        AFh1cSDK aFh1cSDK = aFi1wSDK.getMonetizationNetwork;
        boolean currencyIso4217Code = (aFh1cSDK == null || (aFi1xSDK = aFh1cSDK.AFAdRevenueData) == null) ? false : aFi1xSDK.getCurrencyIso4217Code();
        long jCurrentTimeMillis = System.currentTimeMillis();
        AFf1lSDK aFf1lSDK = this.AFAdRevenueData;
        return currencyIso4217Code || jCurrentTimeMillis - aFf1lSDK.getMediationNetwork > TimeUnit.SECONDS.toMillis(aFf1lSDK.getRevenue);
    }

    @JvmName
    public final boolean getMonetizationNetwork() {
        return ((Boolean) this.getRevenue.getValue()).booleanValue();
    }

    @JvmName
    public final boolean getRevenue() {
        return ((Boolean) this.getCurrencyIso4217Code.getValue()).booleanValue();
    }
}

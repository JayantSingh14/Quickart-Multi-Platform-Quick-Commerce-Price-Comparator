package com.appsflyer.internal;

import android.content.SharedPreferences;
import com.appsflyer.AFLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes.dex */
public final class AFc1jSDK implements AFc1qSDK {

    @NotNull
    private final AFc1hSDK<SharedPreferences> getMediationNetwork;

    @NotNull
    private final Lazy getMonetizationNetwork;

    public AFc1jSDK(@NotNull AFc1hSDK<SharedPreferences> aFc1hSDK) {
        Intrinsics.checkNotNullParameter(aFc1hSDK, "");
        this.getMediationNetwork = aFc1hSDK;
        this.getMonetizationNetwork = LazyKt.b(new Function0<SharedPreferences>() { // from class: com.appsflyer.internal.AFc1jSDK.5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            /* renamed from: l_, reason: merged with bridge method [inline-methods] */
            public final SharedPreferences invoke() {
                return (SharedPreferences) AFc1jSDK.this.getMediationNetwork.getMonetizationNetwork.invoke();
            }
        });
    }

    @Override // com.appsflyer.internal.AFc1qSDK
    public final void getCurrencyIso4217Code(@Nullable String str, boolean z) {
        ((SharedPreferences) this.getMonetizationNetwork.getValue()).edit().putBoolean(str, z).apply();
    }

    @Override // com.appsflyer.internal.AFc1qSDK
    public final void getMediationNetwork(@Nullable String str, @Nullable String str2) {
        ((SharedPreferences) this.getMonetizationNetwork.getValue()).edit().putString(str, str2).apply();
    }

    @Override // com.appsflyer.internal.AFc1qSDK
    public final void getMonetizationNetwork(@Nullable String str, long j2) {
        ((SharedPreferences) this.getMonetizationNetwork.getValue()).edit().putLong(str, j2).apply();
    }

    @Override // com.appsflyer.internal.AFc1qSDK
    @Nullable
    public final String AFAdRevenueData(@Nullable String str, @Nullable String str2) {
        try {
            return ((SharedPreferences) this.getMonetizationNetwork.getValue()).getString(str, str2);
        } catch (ClassCastException e2) {
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.PREFERENCES, android.support.v4.media.b.C("Unexpected data type found for key ", str), e2, false, false, false, false, 120, null);
            return str2;
        }
    }

    @Override // com.appsflyer.internal.AFc1qSDK
    public final long getCurrencyIso4217Code(@Nullable String str, long j2) {
        try {
            return ((SharedPreferences) this.getMonetizationNetwork.getValue()).getLong(str, j2);
        } catch (ClassCastException e2) {
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.PREFERENCES, android.support.v4.media.b.C("Unexpected data type found for key ", str), e2, false, false, false, false, 120, null);
            return j2;
        }
    }

    @Override // com.appsflyer.internal.AFc1qSDK
    public final boolean getMediationNetwork(@Nullable String str, boolean z) {
        try {
            return ((SharedPreferences) this.getMonetizationNetwork.getValue()).getBoolean(str, z);
        } catch (ClassCastException e2) {
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.PREFERENCES, android.support.v4.media.b.C("Unexpected data type found for key ", str), e2, false, false, false, false, 120, null);
            return z;
        }
    }

    @Override // com.appsflyer.internal.AFc1qSDK
    public final void getMonetizationNetwork(@Nullable String str) {
        ((SharedPreferences) this.getMonetizationNetwork.getValue()).edit().remove(str).apply();
    }

    @Override // com.appsflyer.internal.AFc1qSDK
    public final int AFAdRevenueData(@Nullable String str, int i2) {
        try {
            return ((SharedPreferences) this.getMonetizationNetwork.getValue()).getInt(str, i2);
        } catch (ClassCastException e2) {
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.PREFERENCES, android.support.v4.media.b.C("Unexpected data type found for key ", str), e2, false, false, false, false, 120, null);
            return i2;
        }
    }

    @Override // com.appsflyer.internal.AFc1qSDK
    public final void getMediationNetwork(@Nullable String str, int i2) {
        ((SharedPreferences) this.getMonetizationNetwork.getValue()).edit().putInt(str, i2).apply();
    }

    @Override // com.appsflyer.internal.AFc1qSDK
    public final boolean getMediationNetwork(@Nullable String str) {
        return ((SharedPreferences) this.getMonetizationNetwork.getValue()).contains(str);
    }
}

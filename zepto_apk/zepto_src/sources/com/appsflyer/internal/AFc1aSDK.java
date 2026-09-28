package com.appsflyer.internal;

import androidx.annotation.WorkerThread;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes.dex */
public interface AFc1aSDK {
    @WorkerThread
    @Nullable
    String AFAdRevenueData(@NotNull Throwable th, @NotNull String str);

    @WorkerThread
    void AFAdRevenueData(int i2, int i3);

    @WorkerThread
    int getCurrencyIso4217Code();

    @WorkerThread
    @NotNull
    List<AFc1cSDK> getMediationNetwork();

    @WorkerThread
    boolean getMonetizationNetwork();

    @WorkerThread
    boolean getRevenue(@NotNull String... strArr);
}

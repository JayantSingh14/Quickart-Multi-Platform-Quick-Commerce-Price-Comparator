package com.appsflyer.internal;

import com.android.billingclient.BuildConfig;
import java.lang.reflect.Field;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes3.dex */
public final class AFj1gSDK implements AFj1hSDK {
    @Override // com.appsflyer.internal.AFj1hSDK
    @NotNull
    public final String getRevenue() {
        Object objA;
        try {
            Result.Companion companion = Result.f53538b;
            Field declaredField = BuildConfig.class.getDeclaredField("VERSION_NAME");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Intrinsics.d(obj, "");
            objA = (String) obj;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f53538b;
            objA = ResultKt.a(th);
        }
        return (String) (objA instanceof Result.Failure ? "" : objA);
    }
}

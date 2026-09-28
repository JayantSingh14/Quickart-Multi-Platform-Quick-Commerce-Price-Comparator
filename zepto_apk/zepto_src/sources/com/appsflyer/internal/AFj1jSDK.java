package com.appsflyer.internal;

import android.content.Intent;
import android.os.Parcelable;
import com.appsflyer.AFLogger;
import java.util.ConcurrentModificationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension
/* loaded from: classes.dex */
public final class AFj1jSDK {

    @NotNull
    final Intent getCurrencyIso4217Code;

    public AFj1jSDK(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "");
        this.getCurrencyIso4217Code = intent;
    }

    @Nullable
    public final <T extends Parcelable> T H_(@NotNull final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return (T) getMonetizationNetwork(new Function0<T>() { // from class: com.appsflyer.internal.AFj1jSDK.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            /* renamed from: J_, reason: merged with bridge method [inline-methods] */
            public final Parcelable invoke() {
                return AFj1jSDK.this.getCurrencyIso4217Code.getParcelableExtra(str);
            }
        }, android.support.v4.media.b.D("Error while trying to read ", str, " extra from intent"), null, true);
    }

    @Nullable
    public final Intent I_(@NotNull final String str, final long j2) {
        Intrinsics.checkNotNullParameter(str, "");
        return (Intent) getMonetizationNetwork(new Function0<Intent>() { // from class: com.appsflyer.internal.AFj1jSDK.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            /* renamed from: K_, reason: merged with bridge method [inline-methods] */
            public final Intent invoke() {
                return AFj1jSDK.this.getCurrencyIso4217Code.putExtra(str, j2);
            }
        }, android.support.v4.media.b.D("Error while trying to write ", str, " extra to intent"), null, true);
    }

    public final boolean getMonetizationNetwork(@NotNull final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        Boolean bool = (Boolean) getMonetizationNetwork(new Function0<Boolean>() { // from class: com.appsflyer.internal.AFj1jSDK.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            /* renamed from: getCurrencyIso4217Code, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                return Boolean.valueOf(AFj1jSDK.this.getCurrencyIso4217Code.hasExtra(str));
            }
        }, android.support.v4.media.b.D("Error while trying to check presence of ", str, " extra from intent"), Boolean.TRUE, true);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    @Nullable
    public final String getRevenue(@NotNull final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return (String) getMonetizationNetwork(new Function0<String>() { // from class: com.appsflyer.internal.AFj1jSDK.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            /* renamed from: getMediationNetwork, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return AFj1jSDK.this.getCurrencyIso4217Code.getStringExtra(str);
            }
        }, android.support.v4.media.b.D("Error while trying to read ", str, " extra from intent"), null, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.Result$Failure] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v3, types: [kotlin.Result$Failure] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    private final <T> T getMonetizationNetwork(Function0<? extends T> function0, String str, T t, boolean z) {
        T tA;
        ?? A;
        synchronized (this.getCurrencyIso4217Code) {
            try {
                Result.Companion companion = Result.f53538b;
                tA = function0.invoke();
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f53538b;
                tA = ResultKt.a(th);
            }
            KClass[] kClassArr = {Reflection.a(ConcurrentModificationException.class), Reflection.a(ArrayIndexOutOfBoundsException.class)};
            Throwable thA = Result.a(tA);
            T t2 = tA;
            if (thA != null) {
                try {
                } catch (Throwable th2) {
                    Result.Companion companion3 = Result.f53538b;
                    A = ResultKt.a(th2);
                }
                if (!ArraysKt.h(kClassArr, Reflection.a(thA.getClass()))) {
                    throw thA;
                }
                if (z) {
                    A = getMonetizationNetwork(function0, str, t, false);
                } else {
                    AFLogger.afErrorLog(str, thA, false, false);
                    A = t;
                }
                t2 = A;
            }
            Throwable thA2 = Result.a(t2);
            if (thA2 == null) {
                t = t2;
            } else {
                AFLogger.afErrorLog(str, thA2, false, false);
            }
        }
        return t;
    }
}

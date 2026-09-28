package com.appsflyer;

import com.appsflyer.internal.AFg1cSDK;
import com.appsflyer.internal.AFg1gSDK;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class AFLogger extends AFg1gSDK {

    @NotNull
    public static final AFLogger INSTANCE = new AFLogger();

    @NotNull
    private static final Lazy getMediationNetwork = LazyKt.b(new Function0<Set<AFg1gSDK>>() { // from class: com.appsflyer.AFLogger.8
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: AFAdRevenueData, reason: merged with bridge method [inline-methods] */
        public final Set<AFg1gSDK> invoke() {
            return Collections.synchronizedSet(new LinkedHashSet());
        }
    });

    @NotNull
    private static final Lazy getRevenue = LazyKt.b(new Function0<ExecutorService>() { // from class: com.appsflyer.AFLogger.3
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: getMonetizationNetwork, reason: merged with bridge method [inline-methods] */
        public final ExecutorService invoke() {
            return Executors.newSingleThreadExecutor();
        }
    });

    @Metadata
    public enum LogLevel {
        NONE(0),
        ERROR(1),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);

        private final int level;

        LogLevel(int i2) {
            this.level = i2;
        }

        @JvmName
        public final int getLevel() {
            return this.level;
        }
    }

    private AFLogger() {
    }

    @Deprecated
    @JvmStatic
    public static final void afDebugLog(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        INSTANCE.d(AFg1cSDK.OTHER, str, z);
    }

    @Deprecated
    @JvmStatic
    public static final void afErrorLog(@NotNull String str, @NotNull Throwable th, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(th, "");
        AFg1gSDK.e$default(INSTANCE, AFg1cSDK.OTHER, str, th, z, z2, z3, false, 64, null);
    }

    @Deprecated
    @JvmStatic
    public static final void afErrorLogForExcManagerOnly(@Nullable String str, @Nullable Throwable th) {
        AFLogger aFLogger = INSTANCE;
        AFg1cSDK aFg1cSDK = AFg1cSDK.OTHER;
        if (str == null || StringsKt.z(str)) {
            str = "null";
        }
        String str2 = str;
        if (th == null) {
            th = new NullPointerException("Invoked with null Throwable");
        }
        AFg1gSDK.e$default(aFLogger, aFg1cSDK, str2, th, false, false, true, false, 64, null);
    }

    @Deprecated
    @JvmStatic
    public static final void afInfoLog(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        INSTANCE.i(AFg1cSDK.OTHER, str, z);
    }

    @Deprecated
    @JvmStatic
    public static final void afLogForce(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "");
        INSTANCE.force(AFg1cSDK.OTHER, str);
    }

    @Deprecated
    @JvmStatic
    public static final void afRDLog(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "");
        INSTANCE.v(AFg1cSDK.OTHER, str, true);
    }

    @Deprecated
    @JvmStatic
    public static final void afVerboseLog(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "");
        INSTANCE.v(AFg1cSDK.OTHER, str, false);
    }

    @Deprecated
    @JvmStatic
    public static final void afWarnLog(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        INSTANCE.w(AFg1cSDK.OTHER, str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCurrencyIso4217Code(AFg1gSDK[] aFg1gSDKArr) {
        Intrinsics.checkNotNullParameter(aFg1gSDKArr, "");
        Lazy lazy = getMediationNetwork;
        Object value = lazy.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        synchronized (((Set) value)) {
            Object value2 = lazy.getValue();
            Intrinsics.checkNotNullExpressionValue(value2, "");
            ((Set) value2).removeAll(ArraysKt.H(aFg1gSDKArr));
            Unit unit = Unit.f53572a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMediationNetwork(AFg1gSDK[] aFg1gSDKArr) {
        Intrinsics.checkNotNullParameter(aFg1gSDKArr, "");
        Lazy lazy = getMediationNetwork;
        Object value = lazy.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        synchronized (((Set) value)) {
            Object value2 = lazy.getValue();
            Intrinsics.checkNotNullExpressionValue(value2, "");
            CollectionsKt.j((Set) value2, aFg1gSDKArr);
            Unit unit = Unit.f53572a;
        }
    }

    @Override // com.appsflyer.internal.AFg1gSDK
    public final void d(@NotNull final AFg1cSDK aFg1cSDK, @NotNull final String str, final boolean z) {
        Intrinsics.checkNotNullParameter(aFg1cSDK, "");
        Intrinsics.checkNotNullParameter(str, "");
        ((ExecutorService) getRevenue.getValue()).execute(new androidx.lifecycle.a(new Function1<AFg1gSDK, Unit>() { // from class: com.appsflyer.AFLogger.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void getRevenue(@NotNull AFg1gSDK aFg1gSDK) {
                Intrinsics.checkNotNullParameter(aFg1gSDK, "");
                aFg1gSDK.d(aFg1cSDK, str, z);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Object invoke(Object obj) {
                getRevenue((AFg1gSDK) obj);
                return Unit.f53572a;
            }
        }, 1));
    }

    @Override // com.appsflyer.internal.AFg1gSDK
    public final void e(@NotNull final AFg1cSDK aFg1cSDK, @NotNull final String str, @NotNull final Throwable th, final boolean z, final boolean z2, final boolean z3, final boolean z4) {
        Intrinsics.checkNotNullParameter(aFg1cSDK, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(th, "");
        ((ExecutorService) getRevenue.getValue()).execute(new androidx.lifecycle.a(new Function1<AFg1gSDK, Unit>() { // from class: com.appsflyer.AFLogger.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void getRevenue(@NotNull AFg1gSDK aFg1gSDK) {
                Intrinsics.checkNotNullParameter(aFg1gSDK, "");
                aFg1gSDK.e(aFg1cSDK, str, th, z, z2, z3, z4);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Object invoke(Object obj) {
                getRevenue((AFg1gSDK) obj);
                return Unit.f53572a;
            }
        }, 1));
    }

    @Override // com.appsflyer.internal.AFg1gSDK
    public final void force(@NotNull final AFg1cSDK aFg1cSDK, @NotNull final String str) {
        Intrinsics.checkNotNullParameter(aFg1cSDK, "");
        Intrinsics.checkNotNullParameter(str, "");
        ((ExecutorService) getRevenue.getValue()).execute(new androidx.lifecycle.a(new Function1<AFg1gSDK, Unit>() { // from class: com.appsflyer.AFLogger.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void getMediationNetwork(@NotNull AFg1gSDK aFg1gSDK) {
                Intrinsics.checkNotNullParameter(aFg1gSDK, "");
                aFg1gSDK.force(aFg1cSDK, str);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Object invoke(Object obj) {
                getMediationNetwork((AFg1gSDK) obj);
                return Unit.f53572a;
            }
        }, 1));
    }

    @Override // com.appsflyer.internal.AFg1gSDK
    public final void i(@NotNull final AFg1cSDK aFg1cSDK, @NotNull final String str, final boolean z) {
        Intrinsics.checkNotNullParameter(aFg1cSDK, "");
        Intrinsics.checkNotNullParameter(str, "");
        ((ExecutorService) getRevenue.getValue()).execute(new androidx.lifecycle.a(new Function1<AFg1gSDK, Unit>() { // from class: com.appsflyer.AFLogger.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void AFAdRevenueData(@NotNull AFg1gSDK aFg1gSDK) {
                Intrinsics.checkNotNullParameter(aFg1gSDK, "");
                aFg1gSDK.i(aFg1cSDK, str, z);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Object invoke(Object obj) {
                AFAdRevenueData((AFg1gSDK) obj);
                return Unit.f53572a;
            }
        }, 1));
    }

    public final void registerClient(@NotNull AFg1gSDK... aFg1gSDKArr) {
        Intrinsics.checkNotNullParameter(aFg1gSDKArr, "");
        ((ExecutorService) getRevenue.getValue()).execute(new a(aFg1gSDKArr, 0));
    }

    public final void unregisterClient(@NotNull AFg1gSDK... aFg1gSDKArr) {
        Intrinsics.checkNotNullParameter(aFg1gSDKArr, "");
        ((ExecutorService) getRevenue.getValue()).execute(new a(aFg1gSDKArr, 1));
    }

    @Override // com.appsflyer.internal.AFg1gSDK
    public final void v(@NotNull final AFg1cSDK aFg1cSDK, @NotNull final String str, final boolean z) {
        Intrinsics.checkNotNullParameter(aFg1cSDK, "");
        Intrinsics.checkNotNullParameter(str, "");
        ((ExecutorService) getRevenue.getValue()).execute(new androidx.lifecycle.a(new Function1<AFg1gSDK, Unit>() { // from class: com.appsflyer.AFLogger.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void getMonetizationNetwork(@NotNull AFg1gSDK aFg1gSDK) {
                Intrinsics.checkNotNullParameter(aFg1gSDK, "");
                aFg1gSDK.v(aFg1cSDK, str, z);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Object invoke(Object obj) {
                getMonetizationNetwork((AFg1gSDK) obj);
                return Unit.f53572a;
            }
        }, 1));
    }

    @Override // com.appsflyer.internal.AFg1gSDK
    public final void w(@NotNull final AFg1cSDK aFg1cSDK, @NotNull final String str, final boolean z) {
        Intrinsics.checkNotNullParameter(aFg1cSDK, "");
        Intrinsics.checkNotNullParameter(str, "");
        ((ExecutorService) getRevenue.getValue()).execute(new androidx.lifecycle.a(new Function1<AFg1gSDK, Unit>() { // from class: com.appsflyer.AFLogger.9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void getCurrencyIso4217Code(@NotNull AFg1gSDK aFg1gSDK) {
                Intrinsics.checkNotNullParameter(aFg1gSDK, "");
                aFg1gSDK.w(aFg1cSDK, str, z);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Object invoke(Object obj) {
                getCurrencyIso4217Code((AFg1gSDK) obj);
                return Unit.f53572a;
            }
        }, 1));
    }

    @Deprecated
    @JvmStatic
    public static final void afDebugLog(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "");
        INSTANCE.d(AFg1cSDK.OTHER, str, true);
    }

    @Deprecated
    @JvmStatic
    public static final void afInfoLog(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "");
        INSTANCE.i(AFg1cSDK.OTHER, str, true);
    }

    @Deprecated
    @JvmStatic
    public static final void afWarnLog(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "");
        AFg1gSDK.w$default(INSTANCE, AFg1cSDK.OTHER, str, false, 4, null);
    }

    @Deprecated
    @JvmStatic
    public static final void afErrorLog(@Nullable String str, @Nullable Throwable th) {
        AFLogger aFLogger = INSTANCE;
        AFg1cSDK aFg1cSDK = AFg1cSDK.OTHER;
        if (str == null || StringsKt.z(str)) {
            str = "null";
        }
        String str2 = str;
        if (th == null) {
            th = new NullPointerException("Invoked with null Throwable");
        }
        AFg1gSDK.e$default(aFLogger, aFg1cSDK, str2, th, false, false, false, false, 120, null);
    }

    @Deprecated
    @JvmStatic
    public static final void afErrorLogForExcManagerOnly(@Nullable String str, @Nullable Throwable th, boolean z) {
        AFLogger aFLogger = INSTANCE;
        AFg1cSDK aFg1cSDK = AFg1cSDK.OTHER;
        if (str == null || StringsKt.z(str)) {
            str = "null";
        }
        String str2 = str;
        if (th == null) {
            th = new NullPointerException("Invoked with null Throwable");
        }
        AFg1gSDK.e$default(aFLogger, aFg1cSDK, str2, th, false, false, !z, false, 64, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMediationNetwork(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        Lazy lazy = getMediationNetwork;
        Object value = lazy.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        synchronized (((Set) value)) {
            try {
                Object value2 = lazy.getValue();
                Intrinsics.checkNotNullExpressionValue(value2, "");
                Iterator it = ((Set) value2).iterator();
                while (it.hasNext()) {
                    function1.invoke((AFg1gSDK) it.next());
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    @JvmStatic
    public static final void afErrorLog(@Nullable String str, @Nullable Throwable th, boolean z) {
        AFLogger aFLogger = INSTANCE;
        AFg1cSDK aFg1cSDK = AFg1cSDK.OTHER;
        if (str == null || StringsKt.z(str)) {
            str = "null";
        }
        String str2 = str;
        if (th == null) {
            th = new NullPointerException("Invoked with null Throwable");
        }
        AFg1gSDK.e$default(aFLogger, aFg1cSDK, str2, th, false, z, false, false, 104, null);
    }

    @Deprecated
    @JvmStatic
    public static final void afErrorLog(@Nullable String str, @Nullable Throwable th, boolean z, boolean z2) {
        AFLogger aFLogger = INSTANCE;
        AFg1cSDK aFg1cSDK = AFg1cSDK.OTHER;
        if (str == null || StringsKt.z(str)) {
            str = "null";
        }
        String str2 = str;
        if (th == null) {
            th = new NullPointerException("Invoked with null Throwable");
        }
        AFg1gSDK.e$default(aFLogger, aFg1cSDK, str2, th, false, z, z2, false, 72, null);
    }
}

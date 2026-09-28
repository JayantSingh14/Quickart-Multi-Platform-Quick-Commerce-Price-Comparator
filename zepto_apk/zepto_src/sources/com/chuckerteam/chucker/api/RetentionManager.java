package com.chuckerteam.chucker.api;

import android.content.Context;
import coil3.decode.a;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class RetentionManager {

    /* renamed from: e, reason: collision with root package name */
    public static long f16631e;

    /* renamed from: a, reason: collision with root package name */
    public final long f16632a;

    /* renamed from: b, reason: collision with root package name */
    public final long f16633b;

    /* renamed from: c, reason: collision with root package name */
    public final Lazy f16634c;

    /* renamed from: d, reason: collision with root package name */
    public final MutexImpl f16635d;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class Period {

        /* renamed from: a, reason: collision with root package name */
        public static final Period f16636a;

        /* renamed from: b, reason: collision with root package name */
        public static final Period f16637b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Period[] f16638c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f16639d;

        static {
            Period period = new Period("ONE_HOUR", 0);
            f16636a = period;
            Period period2 = new Period("ONE_DAY", 1);
            Period period3 = new Period("ONE_WEEK", 2);
            f16637b = period3;
            Period[] periodArr = {period, period2, period3, new Period("FOREVER", 3)};
            f16638c = periodArr;
            f16639d = EnumEntriesKt.a(periodArr);
        }

        public static Period valueOf(String str) {
            return (Period) Enum.valueOf(Period.class, str);
        }

        public static Period[] values() {
            return (Period[]) f16638c.clone();
        }
    }

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[Period.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Period period = Period.f16636a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Period period2 = Period.f16636a;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Period period3 = Period.f16636a;
                iArr[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public RetentionManager(Context context, Period retentionPeriod) {
        long millis;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(retentionPeriod, "retentionPeriod");
        int iOrdinal = retentionPeriod.ordinal();
        if (iOrdinal == 0) {
            millis = TimeUnit.HOURS.toMillis(1L);
        } else if (iOrdinal == 1) {
            millis = TimeUnit.DAYS.toMillis(1L);
        } else if (iOrdinal == 2) {
            millis = TimeUnit.DAYS.toMillis(7L);
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            millis = 0;
        }
        this.f16632a = millis;
        this.f16634c = LazyKt.b(new a(context, 5));
        this.f16635d = MutexKt.a();
        this.f16633b = retentionPeriod == Period.f16636a ? TimeUnit.MINUTES.toMillis(30L) : TimeUnit.HOURS.toMillis(2L);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(kotlin.coroutines.jvm.internal.ContinuationImpl r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuckerteam.chucker.api.RetentionManager.a(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}

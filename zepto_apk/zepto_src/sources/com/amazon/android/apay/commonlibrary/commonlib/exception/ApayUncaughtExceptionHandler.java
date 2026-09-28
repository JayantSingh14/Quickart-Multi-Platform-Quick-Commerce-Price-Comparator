package com.amazon.android.apay.commonlibrary.commonlib.exception;

import android.app.Activity;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import java.lang.Thread;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class ApayUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public Activity f14865a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public String f14866b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Thread.UncaughtExceptionHandler f14867c;

    /* JADX WARN: Multi-variable type inference failed */
    public ApayUncaughtExceptionHandler() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Nullable
    public final Activity getContext() {
        return this.f14865a;
    }

    @Nullable
    public final Thread.UncaughtExceptionHandler getPrevDefaultExceptionHandler() {
        return this.f14867c;
    }

    @Nullable
    public final String getStitchingId() {
        return this.f14866b;
    }

    public final void setContext(@Nullable Activity activity) {
        this.f14865a = activity;
    }

    public final void setStitchingId(@Nullable String str) {
        this.f14866b = str;
    }

    public final void tearDown() {
        this.f14865a = null;
        this.f14867c = null;
        this.f14866b = null;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@NotNull Thread thread, @NotNull Throwable throwable) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        try {
            if (StringsKt.n(throwable.toString(), "com.amazon.android.apay.commonlibrary", false)) {
                InstrumentUtil.addMetricEvent("CrashOccurred", "BusinessMetrics", this.f14866b);
                InstrumentUtil.INSTANCE.logCrashEvents(throwable, this.f14866b);
            }
            Activity activity = this.f14865a;
            if (activity != null) {
                activity.finish();
            }
            Thread.setDefaultUncaughtExceptionHandler(this.f14867c);
            uncaughtExceptionHandler = this.f14867c;
            if (uncaughtExceptionHandler == null) {
                return;
            }
        } catch (Exception unused) {
            Thread.setDefaultUncaughtExceptionHandler(this.f14867c);
            uncaughtExceptionHandler = this.f14867c;
            if (uncaughtExceptionHandler == null) {
                return;
            }
        } catch (Throwable th) {
            Thread.setDefaultUncaughtExceptionHandler(this.f14867c);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f14867c;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, throwable);
            }
            throw th;
        }
        uncaughtExceptionHandler.uncaughtException(thread, throwable);
    }

    public ApayUncaughtExceptionHandler(@Nullable Activity activity, @Nullable String str) {
        this.f14865a = activity;
        this.f14866b = str;
        this.f14867c = Thread.getDefaultUncaughtExceptionHandler();
    }

    public /* synthetic */ ApayUncaughtExceptionHandler(Activity activity, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : activity, (i2 & 2) != 0 ? null : str);
    }
}

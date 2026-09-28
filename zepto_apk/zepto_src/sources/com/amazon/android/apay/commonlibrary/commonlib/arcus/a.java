package com.amazon.android.apay.commonlibrary.commonlib.arcus;

import android.content.Context;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.CancelWorkRunnable;
import com.amazonaws.mobileconnectors.remoteconfiguration.Configuration;
import com.amazonaws.mobileconnectors.remoteconfiguration.ConfigurationSyncCallback;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

@Metadata
/* loaded from: classes3.dex */
public final class a implements ConfigurationSyncCallback {

    /* renamed from: a, reason: collision with root package name */
    public final b f14863a;

    public a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f14863a = new b(context);
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.ConfigurationSyncCallback
    public final void onConfigurationModified(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        JSONObject asJsonObject = configuration.getAsJsonObject();
        Long lValueOf = asJsonObject != null ? Long.valueOf(asJsonObject.optLong("syncInterval", 900000L)) : null;
        long jLongValue = lValueOf != null ? lValueOf.longValue() : 900000L;
        b bVar = this.f14863a;
        bVar.getClass();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        PeriodicWorkRequest.Builder builder = new PeriodicWorkRequest.Builder(AppConfigWorker.class, jLongValue, timeUnit);
        Constraints.Builder builder2 = new Constraints.Builder();
        NetworkType networkType = NetworkType.f12536a;
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        builder2.f12495a = networkType;
        PeriodicWorkRequest.Builder builder3 = (PeriodicWorkRequest.Builder) builder.e(builder2.a());
        BackoffPolicy backoffPolicy = BackoffPolicy.f12472b;
        Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        builder3.f12578a = true;
        WorkSpec workSpec = builder3.f12580c;
        workSpec.f12916l = backoffPolicy;
        long millis = timeUnit.toMillis(10000L);
        String str = WorkSpec.x;
        if (millis > 18000000) {
            Logger.e().h(str, "Backoff delay duration exceeds maximum value");
        }
        if (millis < 10000) {
            Logger.e().h(str, "Backoff delay duration less than minimum value");
        }
        workSpec.f12917m = RangesKt.c(millis, 10000L, 18000000L);
        Intrinsics.checkNotNullExpressionValue(builder3, "Builder(workerClass, syn…ILLISECONDS\n            )");
        WorkRequest workRequestB = builder3.b();
        Intrinsics.checkNotNullExpressionValue(workRequestB, "createPeriodicWorkReques…IntervalInMillis).build()");
        Intrinsics.checkNotNullExpressionValue(bVar.f14864a.e("AppConfigWorker", (PeriodicWorkRequest) workRequestB), "workManager.enqueueUniqu…odicWorkRequest\n        )");
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.ConfigurationSyncCallback
    public final void onConfigurationUnmodified(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.ConfigurationSyncCallback
    public final void onFailure(Exception exc) {
        exc.getMessage();
        WorkManagerImpl workManagerImpl = this.f14863a.f14864a;
        workManagerImpl.getClass();
        CancelWorkRunnable cancelWorkRunnableC = CancelWorkRunnable.c(workManagerImpl);
        workManagerImpl.f12656d.c(cancelWorkRunnableC);
        Intrinsics.checkNotNullExpressionValue(cancelWorkRunnableC.f12958a, "workManager.cancelUnique…(ARCUS_CONFIG_WORKER_TAG)");
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.ConfigurationSyncCallback
    public final void onThrottle(long j2) {
        if (j2 > 900000) {
            WorkManagerImpl workManagerImpl = this.f14863a.f14864a;
            workManagerImpl.getClass();
            CancelWorkRunnable cancelWorkRunnableC = CancelWorkRunnable.c(workManagerImpl);
            workManagerImpl.f12656d.c(cancelWorkRunnableC);
            Intrinsics.checkNotNullExpressionValue(cancelWorkRunnableC.f12958a, "workManager.cancelUnique…(ARCUS_CONFIG_WORKER_TAG)");
        }
    }
}

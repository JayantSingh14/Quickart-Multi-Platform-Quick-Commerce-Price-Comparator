package com.zeptoconsumerapp.DynamicFeatures;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class DynamicFeaturesWorker extends Worker {

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicFeaturesWorker(@NotNull Context context, @NotNull WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        a aVar = DynamicFeatures.f47403a;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        DynamicFeatures.b(applicationContext);
        ListenableWorker.Result.Success successB = ListenableWorker.Result.b();
        Intrinsics.checkNotNullExpressionValue(successB, "success(...)");
        return successB;
    }
}

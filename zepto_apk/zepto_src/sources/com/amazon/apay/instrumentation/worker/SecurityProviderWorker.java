package com.amazon.apay.instrumentation.worker;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class SecurityProviderWorker extends Worker {

    /* renamed from: f, reason: collision with root package name */
    public final Context f15064f;

    static {
        Reflection.a(SecurityProviderWorker.class).i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SecurityProviderWorker(@NotNull Context context, @NotNull WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.f15064f = context;
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        try {
            ProviderInstaller.a(this.f15064f);
        } catch (GooglePlayServicesNotAvailableException unused) {
            ListenableWorker.Result.Failure failure = new ListenableWorker.Result.Failure();
            Intrinsics.checkNotNullExpressionValue(failure, "failure()");
            return failure;
        } catch (GooglePlayServicesRepairableException unused2) {
        }
        ListenableWorker.Result.Success success = new ListenableWorker.Result.Success();
        Intrinsics.checkNotNullExpressionValue(success, "success()");
        return success;
    }
}

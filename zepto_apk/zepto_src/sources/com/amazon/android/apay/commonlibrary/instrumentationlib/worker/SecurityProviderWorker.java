package com.amazon.android.apay.commonlibrary.instrumentationlib.worker;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import java.security.Provider;
import java.security.Security;
import javax.net.ssl.SSLContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class SecurityProviderWorker extends Worker {

    /* renamed from: f, reason: collision with root package name */
    public final Context f14930f;

    static {
        Reflection.a(SecurityProviderWorker.class).i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SecurityProviderWorker(@NotNull Context context, @NotNull WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.f14930f = context;
    }

    public static void a() {
        Provider provider = Security.getProvider("GmsCore_OpenSSL");
        try {
            Security.removeProvider("GmsCore_OpenSSL");
            Security.insertProviderAt(provider, Security.getProviders().length);
        } catch (Exception e2) {
            e2.getMessage();
        }
        SSLContext.getInstance("TLS").getProvider().getName();
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        if (Security.getProvider("GmsCore_OpenSSL") != null) {
            ListenableWorker.Result.Success success = new ListenableWorker.Result.Success();
            Intrinsics.checkNotNullExpressionValue(success, "success()");
            return success;
        }
        try {
            ProviderInstaller.a(this.f14930f);
            a();
        } catch (GooglePlayServicesNotAvailableException unused) {
            ListenableWorker.Result.Failure failure = new ListenableWorker.Result.Failure();
            Intrinsics.checkNotNullExpressionValue(failure, "failure()");
            return failure;
        } catch (GooglePlayServicesRepairableException unused2) {
        }
        ListenableWorker.Result.Success success2 = new ListenableWorker.Result.Success();
        Intrinsics.checkNotNullExpressionValue(success2, "success()");
        return success2;
    }
}

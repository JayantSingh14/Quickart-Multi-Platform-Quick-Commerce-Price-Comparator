package com.chuckerteam.chucker.api;

import android.content.Context;
import com.chuckerteam.chucker.api.RetentionManager;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.data.repository.RepositoryProvider;
import com.chuckerteam.chucker.internal.support.NotificationHelper;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata
/* loaded from: classes3.dex */
public final class ChuckerCollector {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f16596a;

    /* renamed from: b, reason: collision with root package name */
    public final RetentionManager f16597b;

    /* renamed from: c, reason: collision with root package name */
    public final NotificationHelper f16598c;

    /* renamed from: d, reason: collision with root package name */
    public final ContextScope f16599d;

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[ExportFormat.values().length];
            try {
                ExportFormat[] exportFormatArr = ExportFormat.f16629a;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ExportFormat[] exportFormatArr2 = ExportFormat.f16629a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ChuckerCollector(Context context, RetentionManager.Period retentionPeriod) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(retentionPeriod, "retentionPeriod");
        this.f16596a = true;
        this.f16597b = new RetentionManager(context, retentionPeriod);
        this.f16598c = new NotificationHelper(context);
        Job jobB = SupervisorKt.b();
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        this.f16599d = new ContextScope(CoroutineContext.Element.DefaultImpls.c((JobSupport) jobB, MainDispatcherLoader.f55099a));
        RepositoryProvider.a(context);
    }

    public final void a(HttpTransaction transaction) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        BuildersKt.c(this.f16599d, null, new ChuckerCollector$onResponseReceived$1(this, transaction, null), 3);
    }
}

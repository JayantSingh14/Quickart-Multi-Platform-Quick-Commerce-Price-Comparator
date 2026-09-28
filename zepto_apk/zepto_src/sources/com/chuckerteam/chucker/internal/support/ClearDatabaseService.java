package com.chuckerteam.chucker.internal.support;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.JobIntentService;
import com.chuckerteam.chucker.internal.data.repository.RepositoryProvider;
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
public final class ClearDatabaseService extends JobIntentService {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f16750i = 0;

    /* renamed from: h, reason: collision with root package name */
    public final ContextScope f16751h;

    @Metadata
    public static final class Companion {
    }

    public ClearDatabaseService() {
        Job jobB = SupervisorKt.b();
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        this.f16751h = new ContextScope(CoroutineContext.Element.DefaultImpls.c((JobSupport) jobB, MainDispatcherLoader.f55099a));
    }

    @Override // androidx.core.app.JobIntentService
    public final void d(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        RepositoryProvider.a(applicationContext);
        BuildersKt.c(this.f16751h, null, new ClearDatabaseService$onHandleWork$1(this, null), 3);
    }
}

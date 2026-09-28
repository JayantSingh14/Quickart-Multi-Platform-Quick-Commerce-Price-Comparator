package com.amazon.android.apay.commonlibrary.instrumentationlib.publisher;

import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkManagerImpl;
import com.amazon.android.apay.commonlibrary.instrumentationlib.worker.EventsPublisherWorker;
import com.amazon.android.apay.commonlibrary.interfaces.model.ClientSdkData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final WorkManagerImpl f14915a;

    /* renamed from: b, reason: collision with root package name */
    public final ClientSdkData f14916b;

    public a(ClientSdkData clientSdkData) {
        Intrinsics.checkNotNullParameter(clientSdkData, "clientSdkData");
        this.f14916b = clientSdkData;
        WorkManagerImpl workManagerImplF = WorkManagerImpl.f(clientSdkData.getContext());
        Intrinsics.checkNotNullExpressionValue(workManagerImplF, "getInstance(clientSdkData.context)");
        this.f14915a = workManagerImplF;
    }

    public final OneTimeWorkRequest.Builder a(String str) {
        Intrinsics.checkNotNullParameter(EventsPublisherWorker.class, "workerClass");
        OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(EventsPublisherWorker.class);
        Constraints.Builder builder2 = new Constraints.Builder();
        NetworkType networkType = NetworkType.f12537b;
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        builder2.f12495a = networkType;
        OneTimeWorkRequest.Builder builder3 = (OneTimeWorkRequest.Builder) builder.e(builder2.a());
        Data.Builder builder4 = new Data.Builder();
        builder4.c("event", str);
        ClientSdkData clientSdkData = this.f14916b;
        builder4.c("clientId", clientSdkData.getClientId());
        builder4.c("clientSdkName", clientSdkData.getAppName());
        builder4.c("clientSdkVersion", clientSdkData.getAppVersion());
        builder4.c("clientAdditionalMetadata", clientSdkData.getAppMetadata());
        WorkRequest.Builder builderG = builder3.g(builder4.a());
        Intrinsics.checkNotNullExpressionValue(builderG, "Builder(workerClass)\n   …   .build()\n            )");
        return (OneTimeWorkRequest.Builder) builderG;
    }
}

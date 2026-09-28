package com.amazon.android.apay.commonlibrary.instrumentationlib.utils;

import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkManagerImpl;
import com.amazon.android.apay.commonlibrary.instrumentationlib.worker.SecurityProviderWorker;
import com.amazon.android.apay.commonlibrary.interfaces.model.ClientSdkData;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final C0012a f14919b = new C0012a();

    /* renamed from: a, reason: collision with root package name */
    public final String f14920a;

    @Metadata
    /* renamed from: com.amazon.android.apay.commonlibrary.instrumentationlib.utils.a$a, reason: collision with other inner class name */
    public static final class C0012a extends SingletonHolder<a, ClientSdkData> {

        @Metadata
        /* renamed from: com.amazon.android.apay.commonlibrary.instrumentationlib.utils.a$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0013a extends FunctionReferenceImpl implements Function1<ClientSdkData, a> {

            /* renamed from: b, reason: collision with root package name */
            public static final C0013a f14921b = new C0013a();

            public C0013a() {
                super(1, a.class, "<init>", "<init>(Lcom/amazon/android/apay/commonlibrary/interfaces/model/ClientSdkData;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                ClientSdkData p0 = (ClientSdkData) obj;
                Intrinsics.checkNotNullParameter(p0, "p0");
                return new a(p0);
            }
        }

        public C0012a() {
            super(C0013a.f14921b);
        }
    }

    public a(ClientSdkData clientSdkData) {
        Intrinsics.checkNotNullParameter(clientSdkData, "clientSdkData");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        this.f14920a = string;
        WorkManagerImpl workManagerImplF = WorkManagerImpl.f(clientSdkData.getContext());
        Intrinsics.checkNotNullExpressionValue(workManagerImplF, "getInstance(clientSdkData.context)");
        Intrinsics.checkNotNullParameter(SecurityProviderWorker.class, "workerClass");
        WorkRequest workRequestB = new OneTimeWorkRequest.Builder(SecurityProviderWorker.class).b();
        Intrinsics.checkNotNullExpressionValue(workRequestB, "Builder(workerClass)\n            .build()");
        workManagerImplF.c("GooglePlayServicesSecurityProviderWorker", ExistingWorkPolicy.f12516a, (OneTimeWorkRequest) workRequestB);
    }
}

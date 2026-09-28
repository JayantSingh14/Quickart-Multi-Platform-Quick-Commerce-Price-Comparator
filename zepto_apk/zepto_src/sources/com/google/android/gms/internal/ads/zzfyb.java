package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.datastore.DataStoreFile;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.FileStorage;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* loaded from: classes4.dex */
public final class zzfyb implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzcln f31998a;

    public zzfyb(zzcln zzclnVar) {
        this.f31998a = zzclnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        final Context context = this.f31998a.f26518a.f26510b;
        zzijo.a(context);
        Intrinsics.checkNotNullParameter(context, "context");
        zzfxz serializer = zzfxz.f31992a;
        Function0 produceFile = new Function0() { // from class: com.google.android.gms.internal.ads.zzfya
            @Override // kotlin.jvm.functions.Function0
            public final /* synthetic */ Object invoke() {
                return DataStoreFile.a(context, "ad_quality_data.pb");
            }
        };
        EmptyList migrations = EmptyList.f53609a;
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        ContextScope scope = CoroutineScopeKt.a(DefaultIoScheduler.f55150b.plus(SupervisorKt.b()));
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(produceFile, "produceFile");
        return DataStoreFactory.a(new FileStorage(produceFile), null, migrations, scope);
    }
}

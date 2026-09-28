package com.phoenix;

import com.phoenix.PhoenixSharedPreference;
import com.phoenix.PhoenixUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "com.phoenix.PhoenixUpdateManager$Companion$getJSBundlePath$1", f = "PhoenixUpdateManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
final class PhoenixUpdateManager$Companion$getJSBundlePath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CacheManifest f46126a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f46127b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f46128c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoenixUpdateManager$Companion$getJSBundlePath$1(CacheManifest cacheManifest, int i2, int i3, Continuation continuation) {
        super(2, continuation);
        this.f46126a = cacheManifest;
        this.f46127b = i2;
        this.f46128c = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PhoenixUpdateManager$Companion$getJSBundlePath$1(this.f46126a, this.f46127b, this.f46128c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((PhoenixUpdateManager$Companion$getJSBundlePath$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        PhoenixUtils.Companion companion = PhoenixUtils.f46133a;
        CacheManifest userData = this.f46126a;
        Intrinsics.checkNotNullParameter(userData, "userData");
        PhoenixSharedPreference.Companion.c("cache_manifest_data", null);
        companion.d(this.f46127b, this.f46128c, userData.f(), "roll_back", userData.a());
        return Unit.f53572a;
    }
}

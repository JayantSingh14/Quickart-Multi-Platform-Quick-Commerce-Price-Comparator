package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
final class zzfyn extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f32028a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfxs f32029b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfyn(zzfxs zzfxsVar, Continuation continuation) {
        super(2, continuation);
        this.f32029b = zzfxsVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzfyn zzfynVar = new zzfyn(this.f32029b, continuation);
        zzfynVar.f32028a = obj;
        return zzfynVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfyn) create((zzfxw) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        zzfxu builder = (zzfxu) ((zzfxw) this.f32028a).v();
        Intrinsics.checkNotNullParameter(builder, "builder");
        Map mapUnmodifiableMap = Collections.unmodifiableMap(((zzfxw) builder.f34638b).D());
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "getQueryIdToAdQualityDataMapMap(...)");
        zzidv zzidvVar = new zzidv(mapUnmodifiableMap);
        zzfxs value = this.f32029b;
        String key = value.F();
        Intrinsics.checkNotNullExpressionValue(key, "getGwsQueryId(...)");
        Intrinsics.checkNotNullParameter(zzidvVar, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        key.getClass();
        builder.j();
        ((zzfxw) builder.f34638b).G().put(key, value);
        zziar zziarVarL = builder.l();
        Intrinsics.checkNotNullExpressionValue(zziarVarL, "build(...)");
        return (zzfxw) zziarVarL;
    }
}

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
final class zzfyg extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f32005a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f32006b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfyg(String str, Continuation continuation) {
        super(2, continuation);
        this.f32006b = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzfyg zzfygVar = new zzfyg(this.f32006b, continuation);
        zzfygVar.f32005a = obj;
        return zzfygVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfyg) create((zzfxw) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        zzfxu builder = (zzfxu) ((zzfxw) this.f32005a).v();
        Intrinsics.checkNotNullParameter(builder, "builder");
        Map mapUnmodifiableMap = Collections.unmodifiableMap(((zzfxw) builder.f34638b).D());
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "getQueryIdToAdQualityDataMapMap(...)");
        Intrinsics.checkNotNullParameter(new zzidv(mapUnmodifiableMap), "<this>");
        String key = this.f32006b;
        Intrinsics.checkNotNullParameter(key, "key");
        key.getClass();
        builder.j();
        ((zzfxw) builder.f34638b).G().remove(key);
        zziar zziarVarL = builder.l();
        Intrinsics.checkNotNullExpressionValue(zziarVarL, "build(...)");
        return (zzfxw) zziarVarL;
    }
}

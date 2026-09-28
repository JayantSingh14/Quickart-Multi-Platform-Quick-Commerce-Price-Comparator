package com.google.android.gms.internal.ads;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes4.dex */
final class zzfyl extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f32021a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfza f32022b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfyl(zzfza zzfzaVar, Continuation continuation) {
        super(2, continuation);
        this.f32022b = zzfzaVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzfyl(this.f32022b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfyl) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f32021a;
        ResultKt.b(obj);
        if (i2 == 0) {
            this.f32021a = 1;
            if (this.f32022b.c(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.f53572a;
    }
}

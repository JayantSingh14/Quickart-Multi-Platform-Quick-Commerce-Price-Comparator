package com.google.android.gms.internal.ads;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes4.dex */
final class zzfyx extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f32064a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfza f32065b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfyx(zzfza zzfzaVar, Continuation continuation) {
        super(2, continuation);
        this.f32065b = zzfzaVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzfyx(this.f32065b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfyx) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f32064a;
        ResultKt.b(obj);
        if (i2 == 0) {
            this.f32064a = 1;
            if (this.f32065b.f(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.f53572a;
    }
}

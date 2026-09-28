package com.chuckerteam.chucker.internal.support;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import okio.Buffer;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.internal.support.OkioUtilsKt$isProbablyPlainText$1", f = "OkioUtils.kt", l = {21}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class OkioUtilsKt$isProbablyPlainText$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public int f16785b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f16786c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Buffer f16787d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioUtilsKt$isProbablyPlainText$1(Buffer buffer, Continuation continuation) {
        super(2, continuation);
        this.f16787d = buffer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        OkioUtilsKt$isProbablyPlainText$1 okioUtilsKt$isProbablyPlainText$1 = new OkioUtilsKt$isProbablyPlainText$1(this.f16787d, continuation);
        okioUtilsKt$isProbablyPlainText$1.f16786c = obj;
        return okioUtilsKt$isProbablyPlainText$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((OkioUtilsKt$isProbablyPlainText$1) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f16785b;
        if (i2 == 0) {
            ResultKt.b(obj);
            sequenceScope = (SequenceScope) this.f16786c;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sequenceScope = (SequenceScope) this.f16786c;
            ResultKt.b(obj);
        }
        Buffer buffer = this.f16787d;
        if (buffer.l()) {
            return Unit.f53572a;
        }
        Integer num = new Integer(buffer.c1());
        this.f16786c = sequenceScope;
        this.f16785b = 1;
        sequenceScope.a(num, this);
        return coroutineSingletons;
    }
}

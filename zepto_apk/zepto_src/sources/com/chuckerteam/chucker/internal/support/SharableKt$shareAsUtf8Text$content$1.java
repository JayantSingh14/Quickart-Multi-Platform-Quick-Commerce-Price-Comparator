package com.chuckerteam.chucker.internal.support;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.internal.support.SharableKt$shareAsUtf8Text$content$1", f = "Sharable.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class SharableKt$shareAsUtf8Text$content$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Sharable f16812a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f16813b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharableKt$shareAsUtf8Text$content$1(Sharable sharable, Activity activity, Continuation continuation) {
        super(2, continuation);
        this.f16812a = sharable;
        this.f16813b = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SharableKt$shareAsUtf8Text$content$1(this.f16812a, this.f16813b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((SharableKt$shareAsUtf8Text$content$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        return SharableKt.c(this.f16812a, this.f16813b);
    }
}

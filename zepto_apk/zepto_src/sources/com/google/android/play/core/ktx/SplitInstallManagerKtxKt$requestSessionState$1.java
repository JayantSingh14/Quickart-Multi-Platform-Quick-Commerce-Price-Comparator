package com.google.android.play.core.ktx;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@DebugMetadata(c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt", f = "SplitInstallManagerKtx.kt", l = {120}, m = "requestSessionState")
/* loaded from: classes4.dex */
final class SplitInstallManagerKtxKt$requestSessionState$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f41850a;

    /* renamed from: b, reason: collision with root package name */
    public int f41851b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f41850a = obj;
        int i2 = (this.f41851b | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f41851b = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 == 0) {
            ResultKt.b(obj);
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Intrinsics.checkNotNullExpressionValue(obj, "runTask(getSessionState(sessionId))");
        return obj;
    }
}

package com.google.android.play.core.ktx;

import com.google.android.play.core.splitinstall.SplitInstallRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@DebugMetadata(c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt", f = "SplitInstallManagerKtx.kt", l = {46}, m = "requestInstall")
/* loaded from: classes4.dex */
final class SplitInstallManagerKtxKt$requestInstall$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f41848a;

    /* renamed from: b, reason: collision with root package name */
    public int f41849b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f41848a = obj;
        int i2 = (this.f41849b | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f41849b = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 == 0) {
            ResultKt.b(obj);
            new SplitInstallRequest.Builder();
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Intrinsics.checkNotNullExpressionValue(obj, "runTask(startInstall(bui…est(modules, languages)))");
        return obj;
    }
}

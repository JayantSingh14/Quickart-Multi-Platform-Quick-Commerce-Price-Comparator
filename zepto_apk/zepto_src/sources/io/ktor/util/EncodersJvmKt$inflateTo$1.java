package io.ktor.util;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.util.EncodersJvmKt", f = "EncodersJvm.kt", l = {157}, m = "inflateTo")
/* loaded from: classes3.dex */
final class EncodersJvmKt$inflateTo$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f50480a;

    /* renamed from: b, reason: collision with root package name */
    public int f50481b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        EncodersJvmKt$inflateTo$1 encodersJvmKt$inflateTo$1;
        this.f50480a = obj;
        int i2 = this.f50481b | Integer.MIN_VALUE;
        this.f50481b = i2;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f50481b = i2 - Integer.MIN_VALUE;
            encodersJvmKt$inflateTo$1 = this;
        } else {
            encodersJvmKt$inflateTo$1 = new EncodersJvmKt$inflateTo$1(this);
        }
        Object obj2 = encodersJvmKt$inflateTo$1.f50480a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = encodersJvmKt$inflateTo$1.f50481b;
        if (i3 == 0) {
            ResultKt.b(obj2);
            throw null;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj2);
        return new Integer(0);
    }
}

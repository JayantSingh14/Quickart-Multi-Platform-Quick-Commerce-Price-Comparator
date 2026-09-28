package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelJVMKt", f = "ByteReadChannelJVM.kt", l = {267}, m = "joinToImplSuspend")
/* loaded from: classes3.dex */
final class ByteReadChannelJVMKt$joinToImplSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f51087a;

    /* renamed from: b, reason: collision with root package name */
    public int f51088b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51087a = obj;
        int i2 = (this.f51088b | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f51088b = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            throw null;
        }
        ResultKt.b(obj);
        this.f51088b = 1;
        if (ByteReadChannelJVMKt.a(null, null, Long.MAX_VALUE, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        throw null;
    }
}

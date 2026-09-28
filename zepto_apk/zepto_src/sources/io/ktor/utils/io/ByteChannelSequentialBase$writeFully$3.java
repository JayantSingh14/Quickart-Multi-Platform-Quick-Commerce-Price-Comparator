package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {218}, m = "writeFully-JT6ljtQ$suspendImpl")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$writeFully$3 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f51022a;

    /* renamed from: b, reason: collision with root package name */
    public int f51023b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51022a = obj;
        int i2 = this.f51023b | Integer.MIN_VALUE;
        this.f51023b = i2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = ByteChannelSequentialBase.f50886b;
        int i3 = i2 - Integer.MIN_VALUE;
        this.f51023b = i3;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i3 == 0) {
            ResultKt.b(obj);
            return Unit.f53572a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        throw null;
    }
}

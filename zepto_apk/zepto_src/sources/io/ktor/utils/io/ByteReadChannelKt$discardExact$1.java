package io.ktor.utils.io;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelKt", f = "ByteReadChannel.kt", l = {232}, m = "discardExact")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ByteReadChannelKt$discardExact$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f51091a;

    /* renamed from: b, reason: collision with root package name */
    public int f51092b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws EOFException {
        this.f51091a = obj;
        int i2 = (this.f51092b | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f51092b = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 == 0) {
            ResultKt.b(obj);
            this.f51092b = 1;
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (((Number) obj).longValue() == 0) {
            return Unit.f53572a;
        }
        throw new EOFException("Unable to discard 0 bytes");
    }
}

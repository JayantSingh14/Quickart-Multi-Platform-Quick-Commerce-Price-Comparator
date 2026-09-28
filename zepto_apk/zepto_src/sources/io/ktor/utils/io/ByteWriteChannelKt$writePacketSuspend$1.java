package io.ktor.utils.io;

import io.ktor.utils.io.core.BytePacketBuilder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteWriteChannelKt", f = "ByteWriteChannel.kt", l = {202, 202}, m = "writePacketSuspend")
/* loaded from: classes3.dex */
final class ByteWriteChannelKt$writePacketSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public BytePacketBuilder f51093a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f51094b;

    /* renamed from: c, reason: collision with root package name */
    public int f51095c;

    /* JADX WARN: Type inference failed for: r0v2, types: [int, io.ktor.utils.io.core.Output] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51094b = obj;
        ?? r0 = (this.f51095c | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f51095c = r0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        try {
            if (r0 == 0) {
                ResultKt.b(obj);
                this.f51093a = new BytePacketBuilder(0);
                this.f51095c = 1;
                throw null;
            }
            if (r0 != 1) {
                if (r0 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.f53572a;
            }
            BytePacketBuilder bytePacketBuilder = this.f51093a;
            ResultKt.b(obj);
            bytePacketBuilder.V();
            this.f51093a = null;
            this.f51095c = 2;
            throw null;
        } catch (Throwable th) {
            r0.close();
            throw th;
        }
    }
}

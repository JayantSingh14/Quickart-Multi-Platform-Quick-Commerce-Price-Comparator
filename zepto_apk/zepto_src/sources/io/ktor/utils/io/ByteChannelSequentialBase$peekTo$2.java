package io.ktor.utils.io;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase$peekTo$2", f = "ByteChannelSequential.kt", l = {823}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$peekTo$2 extends SuspendLambda implements Function2<SuspendableReadSession, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f50914a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50915b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f50916c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f50917d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f50918e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f50919f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f50920g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$peekTo$2(long j2, Ref.LongRef longRef, long j3, ByteBuffer byteBuffer, long j4, Continuation continuation) {
        super(2, continuation);
        this.f50916c = j2;
        this.f50917d = longRef;
        this.f50918e = j3;
        this.f50919f = byteBuffer;
        this.f50920g = j4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ByteChannelSequentialBase$peekTo$2 byteChannelSequentialBase$peekTo$2 = new ByteChannelSequentialBase$peekTo$2(this.f50916c, this.f50917d, this.f50918e, this.f50919f, this.f50920g, continuation);
        byteChannelSequentialBase$peekTo$2.f50915b = obj;
        return byteChannelSequentialBase$peekTo$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ByteChannelSequentialBase$peekTo$2) create((SuspendableReadSession) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SuspendableReadSession suspendableReadSession;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f50914a;
        if (i2 == 0) {
            ResultKt.b(obj);
            SuspendableReadSession suspendableReadSession2 = (SuspendableReadSession) this.f50915b;
            long j2 = this.f50916c;
            if (j2 > 4088) {
                j2 = 4088;
            }
            this.f50915b = suspendableReadSession2;
            this.f50914a = 1;
            if (suspendableReadSession2.c((int) j2, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            suspendableReadSession = suspendableReadSession2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            suspendableReadSession = (SuspendableReadSession) this.f50915b;
            ResultKt.b(obj);
        }
        ChunkBuffer chunkBufferB = suspendableReadSession.b(1);
        if (chunkBufferB == null) {
            chunkBufferB = ChunkBuffer.f51216l;
        }
        long j3 = chunkBufferB.f51182c - chunkBufferB.f51181b;
        if (j3 > 0) {
            long jMin = Math.min(j3, Math.min(this.f50918e, this.f50919f.limit() - this.f50920g));
            this.f50917d.f53800a = jMin;
            Memory.a(0L, jMin, this.f50920g, chunkBufferB.f51180a, this.f50919f);
        }
        return Unit.f53572a;
    }
}

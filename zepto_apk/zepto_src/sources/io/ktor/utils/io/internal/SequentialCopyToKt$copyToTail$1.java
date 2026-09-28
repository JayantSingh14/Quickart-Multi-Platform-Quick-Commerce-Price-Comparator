package io.ktor.utils.io.internal;

import io.ktor.utils.io.ByteChannelSequentialBase;
import io.ktor.utils.io.core.BufferFactoryKt;
import io.ktor.utils.io.core.DefaultBufferPool;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", l = {60, WKSRecord.Protocol.RVD}, m = "copyToTail")
/* loaded from: classes3.dex */
final class SequentialCopyToKt$copyToTail$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f51279a;

    /* renamed from: b, reason: collision with root package name */
    public ChunkBuffer f51280b;

    /* renamed from: c, reason: collision with root package name */
    public int f51281c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f51282d;

    /* renamed from: e, reason: collision with root package name */
    public int f51283e;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SequentialCopyToKt$copyToTail$1 sequentialCopyToKt$copyToTail$1;
        Throwable th;
        ChunkBuffer chunkBuffer;
        this.f51282d = obj;
        int i2 = this.f51283e | Integer.MIN_VALUE;
        this.f51283e = i2;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f51283e = i2 - Integer.MIN_VALUE;
            sequentialCopyToKt$copyToTail$1 = this;
        } else {
            sequentialCopyToKt$copyToTail$1 = new SequentialCopyToKt$copyToTail$1(this);
        }
        Object obj2 = sequentialCopyToKt$copyToTail$1.f51282d;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = sequentialCopyToKt$copyToTail$1.f51283e;
        if (i3 == 0) {
            ResultKt.b(obj2);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ChunkBuffer.f51213i;
            ChunkBuffer chunkBuffer2 = (ChunkBuffer) BufferFactoryKt.f51186a.S0();
            try {
                long j2 = chunkBuffer2.f51185f;
                chunkBuffer2.f((int) (0 > j2 ? j2 : 0L));
                sequentialCopyToKt$copyToTail$1.f51279a = null;
                sequentialCopyToKt$copyToTail$1.f51280b = chunkBuffer2;
                sequentialCopyToKt$copyToTail$1.f51283e = 1;
                throw null;
            } catch (Throwable th2) {
                th = th2;
                chunkBuffer = chunkBuffer2;
            }
        } else if (i3 == 1) {
            ChunkBuffer chunkBuffer3 = sequentialCopyToKt$copyToTail$1.f51280b;
            ByteChannelSequentialBase byteChannelSequentialBase = (ByteChannelSequentialBase) sequentialCopyToKt$copyToTail$1.f51279a;
            try {
                ResultKt.b(obj2);
                int iIntValue = ((Number) obj2).intValue();
                if (iIntValue != -1) {
                    sequentialCopyToKt$copyToTail$1.f51279a = chunkBuffer3;
                    sequentialCopyToKt$copyToTail$1.f51280b = null;
                    sequentialCopyToKt$copyToTail$1.f51281c = iIntValue;
                    sequentialCopyToKt$copyToTail$1.f51283e = 2;
                    byteChannelSequentialBase.s(chunkBuffer3, sequentialCopyToKt$copyToTail$1);
                    return coroutineSingletons;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = ChunkBuffer.f51213i;
                DefaultBufferPool defaultBufferPool = BufferFactoryKt.f51186a;
                chunkBuffer3.k(defaultBufferPool);
                try {
                    Long l2 = new Long(0L);
                    chunkBuffer3.k(defaultBufferPool);
                    return l2;
                } catch (Throwable th3) {
                    th = th3;
                    chunkBuffer = chunkBuffer3;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = ChunkBuffer.f51213i;
                    chunkBuffer.k(BufferFactoryKt.f51186a);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } else {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = sequentialCopyToKt$copyToTail$1.f51281c;
            chunkBuffer = (ChunkBuffer) sequentialCopyToKt$copyToTail$1.f51279a;
            try {
                ResultKt.b(obj2);
                Long l3 = new Long(i4);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4 = ChunkBuffer.f51213i;
                chunkBuffer.k(BufferFactoryKt.f51186a);
                return l3;
            } catch (Throwable th5) {
                th = th5;
            }
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater32 = ChunkBuffer.f51213i;
        chunkBuffer.k(BufferFactoryKt.f51186a);
        throw th;
    }
}

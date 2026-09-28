package io.ktor.utils.io;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {776, 777}, m = "writeAvailableSuspend")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$writeAvailableSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f50993a;

    /* renamed from: b, reason: collision with root package name */
    public ChunkBuffer f50994b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50995c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50996d;

    /* renamed from: e, reason: collision with root package name */
    public int f50997e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$writeAvailableSuspend$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        super(continuation);
        this.f50996d = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50995c = obj;
        this.f50997e |= Integer.MIN_VALUE;
        AtomicLongFieldUpdater atomicLongFieldUpdater = ByteChannelSequentialBase.f50886b;
        return this.f50996d.b0(null, this);
    }
}

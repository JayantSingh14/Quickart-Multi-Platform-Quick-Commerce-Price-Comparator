package io.ktor.utils.io;

import io.ktor.utils.io.core.Buffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1123, 1125}, m = "writeFullySuspend")
/* loaded from: classes3.dex */
final class ByteBufferChannel$writeFullySuspend$3 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50815a;

    /* renamed from: b, reason: collision with root package name */
    public Buffer f50816b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50817c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50818d;

    /* renamed from: e, reason: collision with root package name */
    public int f50819e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeFullySuspend$3(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50818d = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50817c = obj;
        this.f50819e |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.f50605l;
        return this.f50818d.W0(null, this);
    }
}

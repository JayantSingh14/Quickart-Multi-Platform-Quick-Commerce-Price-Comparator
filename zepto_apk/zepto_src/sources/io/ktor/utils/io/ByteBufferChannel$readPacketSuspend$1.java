package io.ktor.utils.io;

import io.ktor.utils.io.core.BytePacketBuilder;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {800}, m = "readPacketSuspend")
/* loaded from: classes3.dex */
final class ByteBufferChannel$readPacketSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50730a;

    /* renamed from: b, reason: collision with root package name */
    public BytePacketBuilder f50731b;

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer f50732c;

    /* renamed from: d, reason: collision with root package name */
    public int f50733d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f50734e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50735f;

    /* renamed from: g, reason: collision with root package name */
    public int f50736g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readPacketSuspend$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50735f = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50734e = obj;
        this.f50736g |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.f50605l;
        return this.f50735f.r0(0, null, null, this);
    }
}

package io.ktor.utils.io;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {745, 749}, m = "readAvailableSuspend")
/* loaded from: classes3.dex */
final class ByteBufferChannel$readAvailableSuspend$3 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50676a;

    /* renamed from: b, reason: collision with root package name */
    public ChunkBuffer f50677b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50678c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50679d;

    /* renamed from: e, reason: collision with root package name */
    public int f50680e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readAvailableSuspend$3(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50679d = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50678c = obj;
        this.f50680e |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.f50605l;
        return this.f50679d.j0(null, this);
    }
}

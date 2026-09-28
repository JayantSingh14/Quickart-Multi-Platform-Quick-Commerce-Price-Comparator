package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1710, 1718}, m = "readBlockSuspend")
/* loaded from: classes3.dex */
final class ByteBufferChannel$readBlockSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50681a;

    /* renamed from: b, reason: collision with root package name */
    public Function1 f50682b;

    /* renamed from: c, reason: collision with root package name */
    public int f50683c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f50684d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50685e;

    /* renamed from: f, reason: collision with root package name */
    public int f50686f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readBlockSuspend$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50685e = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50684d = obj;
        this.f50686f |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.f50605l;
        return this.f50685e.m0(0, null, this);
    }
}

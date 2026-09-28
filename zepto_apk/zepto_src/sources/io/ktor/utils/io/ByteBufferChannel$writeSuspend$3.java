package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {2412}, m = "writeSuspend")
/* loaded from: classes3.dex */
final class ByteBufferChannel$writeSuspend$3 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50863a;

    /* renamed from: b, reason: collision with root package name */
    public int f50864b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50865c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50866d;

    /* renamed from: e, reason: collision with root package name */
    public int f50867e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeSuspend$3(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50866d = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50865c = obj;
        this.f50867e |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.f50605l;
        return this.f50866d.d1(0, this);
    }
}

package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1512, 1513}, m = "awaitFreeSpaceOrDelegate")
/* loaded from: classes3.dex */
final class ByteBufferChannel$awaitFreeSpaceOrDelegate$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50622a;

    /* renamed from: b, reason: collision with root package name */
    public Function1 f50623b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50624c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50625d;

    /* renamed from: e, reason: collision with root package name */
    public int f50626e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$awaitFreeSpaceOrDelegate$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50625d = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50624c = obj;
        this.f50626e |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.f50605l;
        return this.f50625d.R(0, null, this);
    }
}

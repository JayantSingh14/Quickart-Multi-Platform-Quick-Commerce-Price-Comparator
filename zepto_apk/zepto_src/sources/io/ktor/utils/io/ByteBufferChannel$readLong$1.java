package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {2437}, m = "readLong")
/* loaded from: classes3.dex */
final class ByteBufferChannel$readLong$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50725a;

    /* renamed from: b, reason: collision with root package name */
    public int f50726b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50727c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50728d;

    /* renamed from: e, reason: collision with root package name */
    public int f50729e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readLong$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50728d = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50727c = obj;
        this.f50729e |= Integer.MIN_VALUE;
        return this.f50728d.o(this);
    }
}

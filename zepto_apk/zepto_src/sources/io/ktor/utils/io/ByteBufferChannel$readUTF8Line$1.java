package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {2055}, m = "readUTF8Line$suspendImpl")
/* loaded from: classes3.dex */
final class ByteBufferChannel$readUTF8Line$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public StringBuilder f50759a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50760b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50761c;

    /* renamed from: d, reason: collision with root package name */
    public int f50762d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readUTF8Line$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50761c = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50760b = obj;
        this.f50762d |= Integer.MIN_VALUE;
        return ByteBufferChannel.w0(this.f50761c, 0, this);
    }
}

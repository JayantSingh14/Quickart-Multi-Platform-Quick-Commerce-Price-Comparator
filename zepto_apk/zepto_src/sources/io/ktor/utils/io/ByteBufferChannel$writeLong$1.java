package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {948, 948, 948, 2426, 2481, 948, 948, 2508}, m = "writeLong$suspendImpl")
/* loaded from: classes3.dex */
final class ByteBufferChannel$writeLong$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public long f50835a;

    /* renamed from: b, reason: collision with root package name */
    public Object f50836b;

    /* renamed from: c, reason: collision with root package name */
    public ByteBufferChannel f50837c;

    /* renamed from: d, reason: collision with root package name */
    public ByteBuffer f50838d;

    /* renamed from: e, reason: collision with root package name */
    public int f50839e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f50840f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50841g;

    /* renamed from: h, reason: collision with root package name */
    public int f50842h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeLong$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50841g = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50840f = obj;
        this.f50842h |= Integer.MIN_VALUE;
        return ByteBufferChannel.a1(this.f50841g, 0L, this);
    }
}

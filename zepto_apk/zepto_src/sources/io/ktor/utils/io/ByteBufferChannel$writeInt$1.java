package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {944, 944, 944, 2426, 2481, 944, 944, 2508}, m = "writeInt$suspendImpl")
/* loaded from: classes3.dex */
final class ByteBufferChannel$writeInt$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f50827a;

    /* renamed from: b, reason: collision with root package name */
    public int f50828b;

    /* renamed from: c, reason: collision with root package name */
    public Object f50829c;

    /* renamed from: d, reason: collision with root package name */
    public ByteBufferChannel f50830d;

    /* renamed from: e, reason: collision with root package name */
    public ByteBuffer f50831e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f50832f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50833g;

    /* renamed from: h, reason: collision with root package name */
    public int f50834h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeInt$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50833g = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50832f = obj;
        this.f50834h |= Integer.MIN_VALUE;
        return ByteBufferChannel.Z0(this.f50833g, 0, this);
    }
}

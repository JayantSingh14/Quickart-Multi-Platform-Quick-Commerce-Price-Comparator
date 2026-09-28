package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {936, 936, 936, 2426, 2481, 936, 936, 2508}, m = "writeByte$suspendImpl")
/* loaded from: classes3.dex */
final class ByteBufferChannel$writeByte$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public byte f50802a;

    /* renamed from: b, reason: collision with root package name */
    public Object f50803b;

    /* renamed from: c, reason: collision with root package name */
    public ByteBufferChannel f50804c;

    /* renamed from: d, reason: collision with root package name */
    public ByteBuffer f50805d;

    /* renamed from: e, reason: collision with root package name */
    public int f50806e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f50807f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50808g;

    /* renamed from: h, reason: collision with root package name */
    public int f50809h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeByte$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50808g = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50807f = obj;
        this.f50809h |= Integer.MIN_VALUE;
        return ByteBufferChannel.V0(this.f50808g, (byte) 0, this);
    }
}

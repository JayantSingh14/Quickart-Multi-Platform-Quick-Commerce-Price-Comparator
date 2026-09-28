package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {940, 940, 940, 2426, 2481, 940, 940, 2508}, m = "writeShort$suspendImpl")
/* loaded from: classes3.dex */
final class ByteBufferChannel$writeShort$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public short f50848a;

    /* renamed from: b, reason: collision with root package name */
    public Object f50849b;

    /* renamed from: c, reason: collision with root package name */
    public ByteBufferChannel f50850c;

    /* renamed from: d, reason: collision with root package name */
    public ByteBuffer f50851d;

    /* renamed from: e, reason: collision with root package name */
    public int f50852e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f50853f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50854g;

    /* renamed from: h, reason: collision with root package name */
    public int f50855h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeShort$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50854g = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50853f = obj;
        this.f50855h |= Integer.MIN_VALUE;
        return ByteBufferChannel.c1(this.f50854g, (short) 0, this);
    }
}

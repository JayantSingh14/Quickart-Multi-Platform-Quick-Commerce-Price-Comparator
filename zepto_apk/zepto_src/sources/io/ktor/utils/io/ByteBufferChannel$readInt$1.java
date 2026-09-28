package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {2437}, m = "readInt")
/* loaded from: classes3.dex */
final class ByteBufferChannel$readInt$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50720a;

    /* renamed from: b, reason: collision with root package name */
    public int f50721b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50722c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50723d;

    /* renamed from: e, reason: collision with root package name */
    public int f50724e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readInt$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50723d = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50722c = obj;
        this.f50724e |= Integer.MIN_VALUE;
        return this.f50723d.q(this);
    }
}

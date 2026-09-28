package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {2437}, m = "readDouble")
/* loaded from: classes3.dex */
final class ByteBufferChannel$readDouble$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50694a;

    /* renamed from: b, reason: collision with root package name */
    public int f50695b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50696c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50697d;

    /* renamed from: e, reason: collision with root package name */
    public int f50698e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readDouble$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50697d = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50696c = obj;
        this.f50698e |= Integer.MIN_VALUE;
        return this.f50697d.n0(this);
    }
}

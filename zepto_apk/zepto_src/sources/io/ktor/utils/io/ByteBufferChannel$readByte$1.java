package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {2437}, m = "readByte")
/* loaded from: classes3.dex */
final class ByteBufferChannel$readByte$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50689a;

    /* renamed from: b, reason: collision with root package name */
    public int f50690b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50691c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50692d;

    /* renamed from: e, reason: collision with root package name */
    public int f50693e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readByte$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50692d = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50691c = obj;
        this.f50693e |= Integer.MIN_VALUE;
        return this.f50692d.x(this);
    }
}

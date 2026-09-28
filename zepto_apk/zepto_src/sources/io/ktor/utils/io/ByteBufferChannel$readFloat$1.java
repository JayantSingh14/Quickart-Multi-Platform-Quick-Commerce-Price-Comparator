package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {2437}, m = "readFloat")
/* loaded from: classes3.dex */
final class ByteBufferChannel$readFloat$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50699a;

    /* renamed from: b, reason: collision with root package name */
    public int f50700b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f50701c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50702d;

    /* renamed from: e, reason: collision with root package name */
    public int f50703e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readFloat$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50702d = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50701c = obj;
        this.f50703e |= Integer.MIN_VALUE;
        return this.f50702d.o0(this);
    }
}

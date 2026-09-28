package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {729, 733}, m = "readAvailableSuspend")
/* loaded from: classes3.dex */
final class ByteBufferChannel$readAvailableSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50664a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f50665b;

    /* renamed from: c, reason: collision with root package name */
    public int f50666c;

    /* renamed from: d, reason: collision with root package name */
    public int f50667d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f50668e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50669f;

    /* renamed from: g, reason: collision with root package name */
    public int f50670g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readAvailableSuspend$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50669f = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50668e = obj;
        this.f50670g |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.f50605l;
        return this.f50669f.k0(null, 0, 0, this);
    }
}

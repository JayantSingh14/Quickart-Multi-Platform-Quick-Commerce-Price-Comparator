package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1422}, m = "writeFullySuspend")
/* loaded from: classes3.dex */
final class ByteBufferChannel$writeFullySuspend$5 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50820a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f50821b;

    /* renamed from: c, reason: collision with root package name */
    public int f50822c;

    /* renamed from: d, reason: collision with root package name */
    public int f50823d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f50824e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50825f;

    /* renamed from: g, reason: collision with root package name */
    public int f50826g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeFullySuspend$5(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50825f = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50824e = obj;
        this.f50826g |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.f50605l;
        return this.f50825f.X0(null, 0, 0, this);
    }
}

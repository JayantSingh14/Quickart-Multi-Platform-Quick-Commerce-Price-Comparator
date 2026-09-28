package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1790, 1792, 1797, 1802, 1804, 1808}, m = "lookAheadSuspend$suspendImpl")
/* loaded from: classes3.dex */
final class ByteBufferChannel$lookAheadSuspend$1<R> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50648a;

    /* renamed from: b, reason: collision with root package name */
    public Object f50649b;

    /* renamed from: c, reason: collision with root package name */
    public Ref.ObjectRef f50650c;

    /* renamed from: d, reason: collision with root package name */
    public ByteBufferChannel f50651d;

    /* renamed from: e, reason: collision with root package name */
    public Ref.ObjectRef f50652e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f50653f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50654g;

    /* renamed from: h, reason: collision with root package name */
    public int f50655h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$lookAheadSuspend$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50654g = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50653f = obj;
        this.f50655h |= Integer.MIN_VALUE;
        return ByteBufferChannel.c0(this.f50654g, null, this);
    }
}

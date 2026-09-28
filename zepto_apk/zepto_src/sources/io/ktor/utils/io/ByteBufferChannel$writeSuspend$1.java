package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1439, 1441}, m = "writeSuspend")
/* loaded from: classes3.dex */
final class ByteBufferChannel$writeSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50856a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f50857b;

    /* renamed from: c, reason: collision with root package name */
    public int f50858c;

    /* renamed from: d, reason: collision with root package name */
    public int f50859d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f50860e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50861f;

    /* renamed from: g, reason: collision with root package name */
    public int f50862g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeSuspend$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50861f = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50860e = obj;
        this.f50862g |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.f50605l;
        return this.f50861f.e1(null, 0, 0, this);
    }
}

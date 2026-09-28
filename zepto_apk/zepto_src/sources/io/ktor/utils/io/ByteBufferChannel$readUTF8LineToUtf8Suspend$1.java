package io.ktor.utils.io;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1960, 2036}, m = "readUTF8LineToUtf8Suspend")
/* loaded from: classes3.dex */
final class ByteBufferChannel$readUTF8LineToUtf8Suspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteBufferChannel f50763a;

    /* renamed from: b, reason: collision with root package name */
    public Object f50764b;

    /* renamed from: c, reason: collision with root package name */
    public Serializable f50765c;

    /* renamed from: d, reason: collision with root package name */
    public Serializable f50766d;

    /* renamed from: e, reason: collision with root package name */
    public Ref.BooleanRef f50767e;

    /* renamed from: f, reason: collision with root package name */
    public Ref.BooleanRef f50768f;

    /* renamed from: g, reason: collision with root package name */
    public char[] f50769g;

    /* renamed from: h, reason: collision with root package name */
    public Ref.ObjectRef f50770h;

    /* renamed from: i, reason: collision with root package name */
    public Ref.IntRef f50771i;

    /* renamed from: j, reason: collision with root package name */
    public int f50772j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f50773k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50774l;

    /* renamed from: m, reason: collision with root package name */
    public int f50775m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readUTF8LineToUtf8Suspend$1(ByteBufferChannel byteBufferChannel, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50774l = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50773k = obj;
        this.f50775m |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.f50605l;
        return this.f50774l.x0(null, 0, this);
    }
}

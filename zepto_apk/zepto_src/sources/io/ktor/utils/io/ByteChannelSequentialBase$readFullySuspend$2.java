package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {555}, m = "readFullySuspend")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$readFullySuspend$2 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialBase f50955a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f50956b;

    /* renamed from: c, reason: collision with root package name */
    public int f50957c;

    /* renamed from: d, reason: collision with root package name */
    public int f50958d;

    /* renamed from: e, reason: collision with root package name */
    public int f50959e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f50960f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50961g;

    /* renamed from: h, reason: collision with root package name */
    public int f50962h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readFullySuspend$2(ByteChannelSequentialBase byteChannelSequentialBase, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50961g = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50960f = obj;
        this.f50962h |= Integer.MIN_VALUE;
        AtomicLongFieldUpdater atomicLongFieldUpdater = ByteChannelSequentialBase.f50886b;
        return this.f50961g.Y(null, 0, 0, this);
    }
}

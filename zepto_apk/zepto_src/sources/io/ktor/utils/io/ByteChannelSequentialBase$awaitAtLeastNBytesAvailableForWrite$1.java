package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {WKSRecord.Service.HOSTS2_NS}, m = "awaitAtLeastNBytesAvailableForWrite$ktor_io")
/* loaded from: classes3.dex */
final class ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f50896a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f50897b;

    /* renamed from: c, reason: collision with root package name */
    public int f50898c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1(ByteChannelSequentialBase byteChannelSequentialBase, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f50897b = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50896a = obj;
        this.f50898c |= Integer.MIN_VALUE;
        return this.f50897b.P(0, this);
    }
}

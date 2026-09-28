package io.ktor.utils.io.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.internal.AwaitingSlot", f = "AwaitingSlot.kt", l = {Type.RKEY}, m = "trySuspend")
/* loaded from: classes3.dex */
final class AwaitingSlot$trySuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f51235a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AwaitingSlot f51236b;

    /* renamed from: c, reason: collision with root package name */
    public int f51237c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AwaitingSlot$trySuspend$1(AwaitingSlot awaitingSlot, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51236b = awaitingSlot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51235a = obj;
        this.f51237c |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = AwaitingSlot.f51230a;
        return this.f51236b.a(this);
    }
}

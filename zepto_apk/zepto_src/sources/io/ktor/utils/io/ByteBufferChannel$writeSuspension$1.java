package io.ktor.utils.io;

import com.google.android.gms.internal.pal.a;
import io.ktor.utils.io.internal.ClosedElement;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
final class ByteBufferChannel$writeSuspension$1 extends Lambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f50872c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeSuspension$1(ByteBufferChannel byteBufferChannel) {
        super(1);
        this.f50872c = byteBufferChannel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Continuation ucont = (Continuation) obj;
        Intrinsics.checkNotNullParameter(ucont, "ucont");
        int i2 = this.f50872c.writeSuspensionSize;
        while (true) {
            ClosedElement closedElementM = ByteBufferChannel.M(this.f50872c);
            if (closedElementM != null) {
                ByteBufferChannelKt.a(closedElementM.a());
                throw null;
            }
            if (!this.f50872c.f1(i2)) {
                Result.Companion companion = Result.f53538b;
                ucont.resumeWith(Unit.f53572a);
                break;
            }
            ByteBufferChannel byteBufferChannel = this.f50872c;
            Continuation continuationB = IntrinsicsKt.b(ucont);
            ByteBufferChannel byteBufferChannel2 = this.f50872c;
            while (((Continuation) byteBufferChannel._writeOp) == null) {
                if (!byteBufferChannel2.f1(i2)) {
                    break;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.o;
                if (a.p(atomicReferenceFieldUpdater, byteBufferChannel, continuationB)) {
                    if (byteBufferChannel2.f1(i2) || !a.A(atomicReferenceFieldUpdater, byteBufferChannel, continuationB)) {
                        break;
                    }
                }
            }
            throw new IllegalStateException("Operation is already in progress");
        }
        this.f50872c.a0(i2);
        if (this.f50872c.I0()) {
            this.f50872c.D0();
        }
        return CoroutineSingletons.f53689a;
    }
}

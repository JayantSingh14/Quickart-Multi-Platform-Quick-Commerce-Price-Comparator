package io.ktor.utils.io;

import io.ktor.utils.io.core.OutputArraysJVMKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ByteChannelSequentialJVM extends ByteChannelSequentialBase {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f51042g = 0;

    @Nullable
    private volatile Job attachedJob;

    @Metadata
    @SourceDebugExtension
    public static final class Session implements LookAheadSuspendSession {
        @Override // io.ktor.utils.io.LookAheadSession
        public final void B(int i2) {
            throw null;
        }

        @Override // io.ktor.utils.io.LookAheadSuspendSession
        public final Object b(int i2, ContinuationImpl continuationImpl) {
            throw null;
        }

        @Override // io.ktor.utils.io.LookAheadSession
        public final ByteBuffer c(int i2, int i3) {
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.utils.io.ByteWriteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object C(int r5, kotlin.jvm.functions.Function1 r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialJVM$write$1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialJVM$write$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM$write$1) r0
            int r1 = r0.f51058e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51058e = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialJVM$write$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$write$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f51056c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f51058e
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2b
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2b:
            io.ktor.utils.io.ByteChannelSequentialJVM r5 = r0.f51054a
            kotlin.ResultKt.b(r7)
            goto L56
        L31:
            kotlin.ResultKt.b(r7)
            boolean r7 = r4.U()
            if (r7 == 0) goto L48
            java.lang.Throwable r5 = r4.a()
            if (r5 != 0) goto L47
            kotlinx.coroutines.channels.ClosedSendChannelException r5 = new kotlinx.coroutines.channels.ClosedSendChannelException
            java.lang.String r6 = "Channel closed for write"
            r5.<init>(r6)
        L47:
            throw r5
        L48:
            r0.f51054a = r4
            r0.f51055b = r6
            r0.f51058e = r3
            kotlin.Unit r5 = r4.P(r5, r0)
            if (r5 != r1) goto L55
            return r1
        L55:
            r5 = r4
        L56:
            r5.getClass()
            r5 = 0
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.C(int, kotlin.jvm.functions.Function1, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object E(int r5, kotlin.jvm.functions.Function1 r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r4 = this;
            boolean r5 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialJVM$read$1
            if (r5 == 0) goto L13
            r5 = r7
            io.ktor.utils.io.ByteChannelSequentialJVM$read$1 r5 = (io.ktor.utils.io.ByteChannelSequentialJVM$read$1) r5
            int r0 = r5.f51047e
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r5.f51047e = r0
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialJVM$read$1 r5 = new io.ktor.utils.io.ByteChannelSequentialJVM$read$1
            r5.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r5.f51045c
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r5.f51047e
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L32
            if (r1 != r3) goto L2a
            io.ktor.utils.io.ByteChannelSequentialJVM r5 = r5.f51043a
            kotlin.ResultKt.b(r7)
            goto L43
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.b(r7)
            r5.f51043a = r4
            r5.f51044b = r6
            r5.f51047e = r3
            java.lang.Object r7 = r4.c(r2, r5)
            if (r7 != r0) goto L42
            return r0
        L42:
            r5 = r4
        L43:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r6 = r7.booleanValue()
            if (r6 != 0) goto L59
            java.io.EOFException r5 = new java.io.EOFException
            java.lang.String r6 = "Channel closed while "
            java.lang.String r7 = " bytes expected"
            java.lang.String r6 = android.support.v4.media.b.g(r2, r6, r7)
            r5.<init>(r6)
            throw r5
        L59:
            r5.getClass()
            r5 = 0
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.E(int, kotlin.jvm.functions.Function1, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object F(ByteBuffer byteBuffer, ContinuationImpl continuationImpl) throws Throwable {
        Throwable thA = a();
        if (thA != null) {
            throw thA;
        }
        if (U() && g() == 0) {
            return new Integer(-1);
        }
        throw null;
    }

    public final void k0(ByteBuffer byteBuffer) throws Throwable {
        int iRemaining = byteBuffer.remaining();
        int iT = T();
        if (U()) {
            Throwable thA = a();
            if (thA != null) {
                throw thA;
            }
            throw new ClosedSendChannelException("Channel closed for write");
        }
        if (iRemaining != 0) {
            if (iRemaining <= iT) {
                OutputArraysJVMKt.a(null, byteBuffer);
                throw null;
            }
            if (iT != 0) {
                byteBuffer.limit();
                byteBuffer.limit(byteBuffer.position() + iT);
                OutputArraysJVMKt.a(null, byteBuffer);
                throw null;
            }
        }
        N();
    }

    public final Object l0(ByteBuffer byteBuffer, Continuation continuation) throws Throwable {
        ByteChannelSequentialJVM byteChannelSequentialJVM;
        ByteChannelSequentialJVM$writeAvailableSuspend$1 byteChannelSequentialJVM$writeAvailableSuspend$1 = (ByteChannelSequentialJVM$writeAvailableSuspend$1) continuation;
        int i2 = byteChannelSequentialJVM$writeAvailableSuspend$1.f51063e;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            byteChannelSequentialJVM$writeAvailableSuspend$1.f51063e = i2 - Integer.MIN_VALUE;
        } else {
            byteChannelSequentialJVM$writeAvailableSuspend$1 = new ByteChannelSequentialJVM$writeAvailableSuspend$1(this, continuation);
        }
        Object obj = byteChannelSequentialJVM$writeAvailableSuspend$1.f51061c;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = byteChannelSequentialJVM$writeAvailableSuspend$1.f51063e;
        if (i3 == 0) {
            ResultKt.b(obj);
            byteChannelSequentialJVM$writeAvailableSuspend$1.f51059a = this;
            byteChannelSequentialJVM$writeAvailableSuspend$1.f51060b = byteBuffer;
            byteChannelSequentialJVM$writeAvailableSuspend$1.f51063e = 1;
            if (P(1, byteChannelSequentialJVM$writeAvailableSuspend$1) != coroutineSingletons) {
                byteChannelSequentialJVM = this;
            }
        }
        if (i3 != 1) {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        byteBuffer = byteChannelSequentialJVM$writeAvailableSuspend$1.f51060b;
        byteChannelSequentialJVM = byteChannelSequentialJVM$writeAvailableSuspend$1.f51059a;
        ResultKt.b(obj);
        byteChannelSequentialJVM$writeAvailableSuspend$1.f51059a = null;
        byteChannelSequentialJVM$writeAvailableSuspend$1.f51060b = null;
        byteChannelSequentialJVM$writeAvailableSuspend$1.f51063e = 2;
        byteChannelSequentialJVM.k0(byteBuffer);
        Object num = !byteBuffer.hasRemaining() ? new Integer(0) : byteChannelSequentialJVM.l0(byteBuffer, byteChannelSequentialJVM$writeAvailableSuspend$1);
        return num == coroutineSingletons ? coroutineSingletons : num;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0047 -> B:20:0x004a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m0(java.nio.ByteBuffer r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1) r0
            int r1 = r0.f51068e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51068e = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f51066c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f51068e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.nio.ByteBuffer r5 = r0.f51065b
            io.ktor.utils.io.ByteChannelSequentialJVM r2 = r0.f51064a
            kotlin.ResultKt.b(r6)
            goto L4a
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r6)
            r2 = r4
        L37:
            boolean r6 = r5.hasRemaining()
            if (r6 == 0) goto L51
            r0.f51064a = r2
            r0.f51065b = r5
            r0.f51068e = r3
            kotlin.Unit r6 = r2.P(r3, r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            r2.k0(r5)
            r2.N()
            goto L37
        L51:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.m0(java.nio.ByteBuffer, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object r(ByteBuffer byteBuffer, ContinuationImpl continuationImpl) throws Throwable {
        k0(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return Unit.f53572a;
        }
        Object objM0 = m0(byteBuffer, continuationImpl);
        return objM0 == CoroutineSingletons.f53689a ? objM0 : Unit.f53572a;
    }
}

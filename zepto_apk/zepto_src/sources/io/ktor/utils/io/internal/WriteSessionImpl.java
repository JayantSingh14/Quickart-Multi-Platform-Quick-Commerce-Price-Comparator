package io.ktor.utils.io.internal;

import android.support.v4.media.b;
import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.WriterSuspendSession;
import io.ktor.utils.io.core.BufferUtilsJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class WriteSessionImpl implements WriterSuspendSession {

    /* renamed from: a, reason: collision with root package name */
    public int f51287a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBufferChannel f51288b;

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer f51289c;

    /* renamed from: d, reason: collision with root package name */
    public ChunkBuffer f51290d;

    /* renamed from: e, reason: collision with root package name */
    public RingBufferCapacity f51291e;

    @Override // io.ktor.utils.io.WriterSession
    public final void a(int i2) {
        int i3;
        if (i2 < 0 || i2 > (i3 = this.f51287a)) {
            if (i2 >= 0) {
                throw new IllegalStateException(b.o(b.u(i2, "Unable to mark ", " bytes as written: only "), this.f51287a, " were pre-locked."));
            }
            throw new IllegalArgumentException(b.f(i2, "Written bytes count shouldn't be negative: "));
        }
        this.f51287a = i3 - i2;
        ByteBufferChannel byteBufferChannel = this.f51288b;
        ByteBuffer buffer = this.f51289c;
        RingBufferCapacity capacity = this.f51291e;
        byteBufferChannel.getClass();
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(capacity, "capacity");
        byteBufferChannel.T(buffer, capacity, i2);
    }

    @Override // io.ktor.utils.io.WriterSession
    public final ChunkBuffer b(int i2) {
        int i3;
        int i4 = this.f51287a;
        RingBufferCapacity ringBufferCapacity = this.f51291e;
        while (true) {
            i3 = ringBufferCapacity._availableForWrite$internal;
            if (i3 < 0) {
                i3 = 0;
                break;
            }
            if (RingBufferCapacity.f51270c.compareAndSet(ringBufferCapacity, i3, 0)) {
                break;
            }
        }
        int i5 = i3 + i4;
        this.f51287a = i5;
        if (i5 < i2) {
            return null;
        }
        this.f51288b.f0(i5, this.f51289c);
        if (this.f51289c.remaining() < i2) {
            return null;
        }
        BufferUtilsJvmKt.d(this.f51290d, this.f51289c);
        return this.f51290d;
    }

    @Override // io.ktor.utils.io.WriterSuspendSession
    public final Object c(int i2, ContinuationImpl continuationImpl) throws Throwable {
        if (this.f51288b.b0() != null) {
            Object objF = f(i2, continuationImpl);
            return objF == CoroutineSingletons.f53689a ? objF : Unit.f53572a;
        }
        int i3 = this.f51287a;
        if (i3 >= i2) {
            return Unit.f53572a;
        }
        if (i3 > 0) {
            this.f51291e.a(i3);
            this.f51287a = 0;
        }
        Object objO0 = this.f51288b.O0(i2, continuationImpl);
        return objO0 == CoroutineSingletons.f53689a ? objO0 : Unit.f53572a;
    }

    public final void d() {
        ByteBufferChannel byteBufferChannel = this.f51288b;
        byteBufferChannel.z0();
        this.f51288b = byteBufferChannel;
        ByteBuffer byteBufferH0 = byteBufferChannel.H0();
        if (byteBufferH0 == null) {
            return;
        }
        this.f51289c = byteBufferH0;
        ChunkBuffer chunkBufferA = BufferUtilsJvmKt.a(this.f51288b.X().f51253a, null);
        this.f51290d = chunkBufferA;
        BufferUtilsJvmKt.d(chunkBufferA, this.f51289c);
        this.f51291e = this.f51288b.X().f51254b;
    }

    public final void e() {
        int i2 = this.f51287a;
        if (i2 > 0) {
            this.f51291e.a(i2);
            this.f51287a = 0;
        }
        this.f51288b.C0();
        this.f51288b.M0();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(int r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1 r0 = (io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1) r0
            int r1 = r0.f51295d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51295d = r1
            goto L18
        L13:
            io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1 r0 = new io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f51293b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f51295d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            io.ktor.utils.io.internal.WriteSessionImpl r5 = r0.f51292a
            kotlin.ResultKt.b(r6)
            goto L5d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r6)
            int r6 = r4.f51287a
            if (r6 <= 0) goto L40
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r4.f51291e
            r2.a(r6)
            r6 = 0
            r4.f51287a = r6
        L40:
            io.ktor.utils.io.ByteBufferChannel r6 = r4.f51288b
            r6.a0(r3)
            io.ktor.utils.io.ByteBufferChannel r6 = r4.f51288b
            r6.C0()
            io.ktor.utils.io.ByteBufferChannel r6 = r4.f51288b
            r6.M0()
            io.ktor.utils.io.ByteBufferChannel r6 = r4.f51288b
            r0.f51292a = r4
            r0.f51295d = r3
            java.lang.Object r5 = r6.O0(r5, r0)
            if (r5 != r1) goto L5c
            return r1
        L5c:
            r5 = r4
        L5d:
            io.ktor.utils.io.ByteBufferChannel r6 = r5.f51288b
            r6.z0()
            r5.f51288b = r6
            java.nio.ByteBuffer r6 = r6.H0()
            if (r6 != 0) goto L6b
            goto L8a
        L6b:
            r5.f51289c = r6
            io.ktor.utils.io.ByteBufferChannel r6 = r5.f51288b
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r6.X()
            java.nio.ByteBuffer r6 = r6.f51253a
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = io.ktor.utils.io.core.BufferUtilsJvmKt.b(r6)
            r5.f51290d = r6
            java.nio.ByteBuffer r0 = r5.f51289c
            io.ktor.utils.io.core.BufferUtilsJvmKt.d(r6, r0)
            io.ktor.utils.io.ByteBufferChannel r6 = r5.f51288b
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r6.X()
            io.ktor.utils.io.internal.RingBufferCapacity r6 = r6.f51254b
            r5.f51291e = r6
        L8a:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.WriteSessionImpl.f(int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}

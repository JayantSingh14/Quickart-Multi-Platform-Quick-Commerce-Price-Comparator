package io.ktor.utils.io;

import android.support.v4.media.b;
import com.google.android.gms.common.api.Api;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BufferPrimitivesJvmKt;
import io.ktor.utils.io.core.BufferUtilsJvmKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.OutputArraysJVMKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.internal.CancellableReusableContinuation;
import io.ktor.utils.io.internal.ClosedElement;
import io.ktor.utils.io.internal.JoiningState;
import io.ktor.utils.io.internal.ObjectPoolKt;
import io.ktor.utils.io.internal.ReadSessionImpl;
import io.ktor.utils.io.internal.ReadWriteBufferState;
import io.ktor.utils.io.internal.RingBufferCapacity;
import io.ktor.utils.io.internal.WriteSessionImpl;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xbill.DNS.TTL;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class ByteBufferChannel implements ByteChannel, ByteReadChannel, ByteWriteChannel, LookAheadSuspendSession, HasReadSession, HasWriteSession {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f50605l = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_state");

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f50606m = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_closed");
    public static final /* synthetic */ AtomicReferenceFieldUpdater n = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_readOp");
    public static final /* synthetic */ AtomicReferenceFieldUpdater o = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_writeOp");

    @NotNull
    private volatile /* synthetic */ Object _closed;

    @NotNull
    private volatile /* synthetic */ Object _readOp;

    @NotNull
    private volatile /* synthetic */ Object _state;

    @NotNull
    volatile /* synthetic */ Object _writeOp;

    @Nullable
    private volatile Job attachedJob;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f50607b;

    /* renamed from: c, reason: collision with root package name */
    public final ObjectPool f50608c;

    /* renamed from: d, reason: collision with root package name */
    public final int f50609d;

    /* renamed from: e, reason: collision with root package name */
    public int f50610e;

    /* renamed from: f, reason: collision with root package name */
    public int f50611f;

    /* renamed from: g, reason: collision with root package name */
    public final ReadSessionImpl f50612g;

    /* renamed from: h, reason: collision with root package name */
    public final WriteSessionImpl f50613h;

    /* renamed from: i, reason: collision with root package name */
    public final CancellableReusableContinuation f50614i;

    /* renamed from: j, reason: collision with root package name */
    public final CancellableReusableContinuation f50615j;

    @Nullable
    private volatile JoiningState joining;

    /* renamed from: k, reason: collision with root package name */
    public final Function1 f50616k;
    private volatile long totalBytesRead;
    private volatile long totalBytesWritten;
    private volatile int writeSuspensionSize;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel(ByteBuffer content) {
        this(false, ObjectPoolKt.f51249d, 0);
        Intrinsics.checkNotNullParameter(content, "content");
        ByteBuffer byteBufferSlice = content.slice();
        Intrinsics.checkNotNullExpressionValue(byteBufferSlice, "content.slice()");
        ReadWriteBufferState.Initial initial = new ReadWriteBufferState.Initial(0, byteBufferSlice);
        initial.f51254b.e();
        this._state = initial.f51261g;
        C0();
        ByteWriteChannelKt.a(this);
        M0();
    }

    public static void A0(ByteBufferChannel byteBufferChannel, JoiningState joiningState) {
        if (((ReadWriteBufferState) byteBufferChannel._state) != ReadWriteBufferState.Terminated.f51265c) {
            return;
        }
        joiningState.getClass();
        throw null;
    }

    public static void F0(int i2, ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        byteBuffer.limit(byteBuffer.position() + i2);
        int i3 = i2 - iRemaining;
        for (int i4 = 0; i4 < i3; i4++) {
            byteBuffer.put((byteBuffer.capacity() - 8) + i4, byteBuffer.get(i4));
        }
    }

    public static final ClosedElement M(ByteBufferChannel byteBufferChannel) {
        return (ClosedElement) byteBufferChannel._closed;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object P0(io.ktor.utils.io.ByteBufferChannel r12, int r13, kotlin.jvm.functions.Function1 r14, kotlin.coroutines.jvm.internal.ContinuationImpl r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.P0(io.ktor.utils.io.ByteBufferChannel, int, kotlin.jvm.functions.Function1, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c9, code lost:
    
        if (r8.d1(r9, r0) != r1) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00c9 -> B:43:0x00cc). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object V0(io.ktor.utils.io.ByteBufferChannel r8, byte r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.V0(io.ktor.utils.io.ByteBufferChannel, byte, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c7, code lost:
    
        if (r8.d1(r3, r0) != r1) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00c7 -> B:43:0x00ca). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object Z0(io.ktor.utils.io.ByteBufferChannel r8, int r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.Z0(io.ktor.utils.io.ByteBufferChannel, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00cb, code lost:
    
        if (r10.d1(r11, r0) != r1) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00cb -> B:43:0x00ce). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object a1(io.ktor.utils.io.ByteBufferChannel r10, long r11, kotlin.coroutines.jvm.internal.ContinuationImpl r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.a1(io.ktor.utils.io.ByteBufferChannel, long, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object c0(io.ktor.utils.io.ByteBufferChannel r9, kotlin.jvm.functions.Function2 r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.c0(io.ktor.utils.io.ByteBufferChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c6, code lost:
    
        if (r8.d1(r2, r0) != r1) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00c6 -> B:43:0x00c9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object c1(io.ktor.utils.io.ByteBufferChannel r8, short r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.c1(io.ktor.utils.io.ByteBufferChannel, short, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object d0(io.ktor.utils.io.ByteBufferChannel r12, final java.nio.ByteBuffer r13, final long r14, long r16, final long r18, kotlin.coroutines.jvm.internal.ContinuationImpl r20) {
        /*
            r0 = r20
            boolean r1 = r0 instanceof io.ktor.utils.io.ByteBufferChannel$peekTo$1
            if (r1 == 0) goto L15
            r1 = r0
            io.ktor.utils.io.ByteBufferChannel$peekTo$1 r1 = (io.ktor.utils.io.ByteBufferChannel$peekTo$1) r1
            int r2 = r1.f50659d
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f50659d = r2
            goto L1a
        L15:
            io.ktor.utils.io.ByteBufferChannel$peekTo$1 r1 = new io.ktor.utils.io.ByteBufferChannel$peekTo$1
            r1.<init>(r12, r0)
        L1a:
            java.lang.Object r0 = r1.f50657b
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r3 = r1.f50659d
            r4 = 1
            if (r3 == 0) goto L33
            if (r3 != r4) goto L2b
            kotlin.jvm.internal.Ref$IntRef r12 = r1.f50656a
            kotlin.ResultKt.b(r0)     // Catch: java.io.EOFException -> L5a
            goto L5a
        L2b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L33:
            kotlin.ResultKt.b(r0)
            kotlin.jvm.internal.Ref$IntRef r11 = new kotlin.jvm.internal.Ref$IntRef
            r11.<init>()
            r5 = 4088(0xff8, double:2.0197E-320)
            int r0 = (r16 > r5 ? 1 : (r16 == r5 ? 0 : -1))
            if (r0 <= 0) goto L42
            goto L44
        L42:
            r5 = r16
        L44:
            int r0 = (int) r5
            io.ktor.utils.io.ByteBufferChannel$peekTo$2 r5 = new io.ktor.utils.io.ByteBufferChannel$peekTo$2     // Catch: java.io.EOFException -> L59
            r8 = r13
            r9 = r14
            r6 = r18
            r5.<init>()     // Catch: java.io.EOFException -> L59
            r1.f50656a = r11     // Catch: java.io.EOFException -> L59
            r1.f50659d = r4     // Catch: java.io.EOFException -> L59
            java.lang.Object r12 = r12.E(r0, r5, r1)     // Catch: java.io.EOFException -> L59
            if (r12 != r2) goto L59
            return r2
        L59:
            r12 = r11
        L5a:
            int r12 = r12.f53799a
            long r12 = (long) r12
            java.lang.Long r0 = new java.lang.Long
            r0.<init>(r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.d0(io.ktor.utils.io.ByteBufferChannel, java.nio.ByteBuffer, long, long, long, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, kotlin.Unit] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object g1(io.ktor.utils.io.ByteBufferChannel r4, kotlin.jvm.functions.Function2 r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteBufferChannel$writeSuspendSession$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteBufferChannel$writeSuspendSession$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeSuspendSession$1) r0
            int r1 = r0.f50871d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50871d = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$writeSuspendSession$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeSuspendSession$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f50869b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50871d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            io.ktor.utils.io.internal.WriteSessionImpl r4 = r0.f50868a
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L29
            goto L46
        L29:
            r5 = move-exception
            goto L4c
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.b(r6)
            io.ktor.utils.io.internal.WriteSessionImpl r4 = r4.f50613h
            r4.d()
            r0.f50868a = r4     // Catch: java.lang.Throwable -> L29
            r0.f50871d = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r5 = r5.invoke(r4, r0)     // Catch: java.lang.Throwable -> L29
            if (r5 != r1) goto L46
            return r1
        L46:
            r4.e()
            kotlin.Unit r4 = kotlin.Unit.f53572a
            return r4
        L4c:
            r4.e()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.g1(io.ktor.utils.io.ByteBufferChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static int i0(ByteBufferChannel byteBufferChannel, ChunkBuffer chunkBuffer, int i2, int i3) throws Throwable {
        int iH;
        boolean z;
        if ((i3 & 4) != 0) {
            i2 = chunkBuffer.f51184e - chunkBuffer.f51182c;
        }
        int i4 = 0;
        do {
            ByteBuffer byteBufferG0 = byteBufferChannel.G0();
            if (byteBufferG0 == null) {
                z = false;
                iH = 0;
            } else {
                RingBufferCapacity ringBufferCapacity = ((ReadWriteBufferState) byteBufferChannel._state).f51254b;
                try {
                    if (ringBufferCapacity._availableForRead$internal == 0) {
                        byteBufferChannel.B0();
                        byteBufferChannel.M0();
                        z = false;
                        iH = 0;
                    } else {
                        int i5 = chunkBuffer.f51184e - chunkBuffer.f51182c;
                        iH = ringBufferCapacity.h(Math.min(byteBufferG0.remaining(), Math.min(i5, i2)));
                        if (iH <= 0) {
                            z = false;
                        } else {
                            if (i5 < byteBufferG0.remaining()) {
                                byteBufferG0.limit(byteBufferG0.position() + i5);
                            }
                            BufferPrimitivesJvmKt.a(chunkBuffer, byteBufferG0);
                            byteBufferChannel.S(byteBufferG0, ringBufferCapacity, iH);
                            z = true;
                        }
                    }
                } finally {
                    byteBufferChannel.B0();
                    byteBufferChannel.M0();
                }
            }
            i4 += iH;
            i2 -= iH;
            if (!z || chunkBuffer.f51184e <= chunkBuffer.f51182c) {
                break;
            }
        } while (((ReadWriteBufferState) byteBufferChannel._state).f51254b._availableForRead$internal > 0);
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object w0(io.ktor.utils.io.ByteBufferChannel r5, int r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$readUTF8Line$1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$readUTF8Line$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readUTF8Line$1) r0
            int r1 = r0.f50762d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50762d = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readUTF8Line$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readUTF8Line$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f50760b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50762d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            java.lang.StringBuilder r5 = r0.f50759a
            kotlin.ResultKt.b(r7)
            goto L59
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r0.f50759a = r7
            r0.f50762d = r3
            java.lang.Object r2 = r5._state
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = (io.ktor.utils.io.internal.ReadWriteBufferState) r2
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.f51265c
            if (r2 != r3) goto L4f
            java.lang.Throwable r5 = r5.a()
            if (r5 != 0) goto L4e
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            goto L53
        L4e:
            throw r5
        L4f:
            java.lang.Object r5 = r5.x0(r7, r6, r0)
        L53:
            if (r5 != r1) goto L56
            return r1
        L56:
            r4 = r7
            r7 = r5
            r5 = r4
        L59:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r6 = r7.booleanValue()
            if (r6 != 0) goto L63
            r5 = 0
            return r5
        L63:
            java.lang.String r5 = r5.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.w0(io.ktor.utils.io.ByteBufferChannel, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.utils.io.HasReadSession
    public final SuspendableReadSession A() {
        return this.f50612g;
    }

    @Override // io.ktor.utils.io.LookAheadSession
    public final void B(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) this._state;
        if (!readWriteBufferState.f51254b.i(i2)) {
            throw new IllegalStateException(b.g(i2, "Unable to consume ", " bytes: not enough available bytes"));
        }
        if (i2 > 0) {
            S(readWriteBufferState.b(), readWriteBufferState.f51254b, i2);
        }
    }

    public final void B0() {
        ReadWriteBufferState readWriteBufferStateF;
        ReadWriteBufferState readWriteBufferState = null;
        loop0: while (true) {
            Object obj = this._state;
            ReadWriteBufferState readWriteBufferState2 = (ReadWriteBufferState) obj;
            ReadWriteBufferState.IdleNonEmpty idleNonEmpty = (ReadWriteBufferState.IdleNonEmpty) readWriteBufferState;
            if (idleNonEmpty != null) {
                idleNonEmpty.f51254b.f();
                E0();
                readWriteBufferState = null;
            }
            readWriteBufferStateF = readWriteBufferState2.f();
            if ((readWriteBufferStateF instanceof ReadWriteBufferState.IdleNonEmpty) && ((ReadWriteBufferState) this._state) == readWriteBufferState2 && readWriteBufferStateF.f51254b.g()) {
                readWriteBufferStateF = ReadWriteBufferState.IdleEmpty.f51255c;
                readWriteBufferState = readWriteBufferStateF;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f50605l;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, readWriteBufferStateF)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
        }
        ReadWriteBufferState.IdleEmpty idleEmpty = ReadWriteBufferState.IdleEmpty.f51255c;
        if (readWriteBufferStateF == idleEmpty) {
            ReadWriteBufferState.IdleNonEmpty idleNonEmpty2 = (ReadWriteBufferState.IdleNonEmpty) readWriteBufferState;
            if (idleNonEmpty2 != null) {
                y0(idleNonEmpty2.f51256c);
            }
            E0();
            return;
        }
        if (readWriteBufferStateF instanceof ReadWriteBufferState.IdleNonEmpty) {
            RingBufferCapacity ringBufferCapacity = readWriteBufferStateF.f51254b;
            if (ringBufferCapacity._availableForWrite$internal == ringBufferCapacity.f51272a && readWriteBufferStateF.f51254b.g()) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f50605l;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, readWriteBufferStateF, idleEmpty)) {
                    if (atomicReferenceFieldUpdater2.get(this) != readWriteBufferStateF) {
                        return;
                    }
                }
                readWriteBufferStateF.f51254b.f();
                y0(((ReadWriteBufferState.IdleNonEmpty) readWriteBufferStateF).f51256c);
                E0();
            }
        }
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object C(int i2, Function1 function1, ContinuationImpl continuationImpl) {
        return P0(this, 1, function1, continuationImpl);
    }

    public final void C0() {
        ReadWriteBufferState readWriteBufferStateG;
        ReadWriteBufferState.IdleNonEmpty idleNonEmpty;
        ReadWriteBufferState readWriteBufferState = null;
        loop0: while (true) {
            Object obj = this._state;
            readWriteBufferStateG = ((ReadWriteBufferState) obj).g();
            if (readWriteBufferStateG instanceof ReadWriteBufferState.IdleNonEmpty) {
                RingBufferCapacity ringBufferCapacity = readWriteBufferStateG.f51254b;
                if (ringBufferCapacity._availableForWrite$internal == ringBufferCapacity.f51272a) {
                    readWriteBufferStateG = ReadWriteBufferState.IdleEmpty.f51255c;
                    readWriteBufferState = readWriteBufferStateG;
                }
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f50605l;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, readWriteBufferStateG)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
        }
        if (readWriteBufferStateG != ReadWriteBufferState.IdleEmpty.f51255c || (idleNonEmpty = (ReadWriteBufferState.IdleNonEmpty) readWriteBufferState) == null) {
            return;
        }
        y0(idleNonEmpty.f51256c);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object D(long j2, ContinuationImpl continuationImpl) throws Throwable {
        long j3 = 0;
        if (j2 < 0) {
            throw new IllegalArgumentException(b.i(j2, "max shouldn't be negative: ").toString());
        }
        ByteBuffer byteBufferG0 = G0();
        if (byteBufferG0 != null) {
            RingBufferCapacity ringBufferCapacity = ((ReadWriteBufferState) this._state).f51254b;
            try {
                if (ringBufferCapacity._availableForRead$internal != 0) {
                    int iH = ringBufferCapacity.h((int) Math.min(TTL.MAX_VALUE, j2));
                    S(byteBufferG0, ringBufferCapacity, iH);
                    j3 = iH;
                }
            } finally {
                B0();
                M0();
            }
        }
        long j4 = j3;
        return (j4 == j2 || K()) ? new Long(j4) : Y(j4, j2, continuationImpl);
    }

    public final void D0() {
        Continuation continuation = (Continuation) n.getAndSet(this, null);
        if (continuation != null) {
            ClosedElement closedElement = (ClosedElement) this._closed;
            Throwable th = closedElement != null ? closedElement.f51244a : null;
            if (th != null) {
                Result.Companion companion = Result.f53538b;
                continuation.resumeWith(ResultKt.a(th));
            } else {
                Result.Companion companion2 = Result.f53538b;
                continuation.resumeWith(Boolean.TRUE);
            }
        }
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object E(int i2, Function1 function1, ContinuationImpl continuationImpl) throws Throwable {
        int i3;
        if (i2 < 0) {
            throw new IllegalArgumentException("min should be positive or zero");
        }
        ByteBuffer byteBufferG0 = G0();
        boolean z = false;
        if (byteBufferG0 != null) {
            RingBufferCapacity ringBufferCapacity = ((ReadWriteBufferState) this._state).f51254b;
            try {
                if (ringBufferCapacity._availableForRead$internal != 0 && (i3 = ringBufferCapacity._availableForRead$internal) > 0 && i3 >= i2) {
                    int iPosition = byteBufferG0.position();
                    int iLimit = byteBufferG0.limit();
                    function1.invoke(byteBufferG0);
                    if (iLimit != byteBufferG0.limit()) {
                        throw new IllegalStateException("Buffer limit modified.");
                    }
                    int iPosition2 = byteBufferG0.position() - iPosition;
                    if (iPosition2 < 0) {
                        throw new IllegalStateException("Position has been moved backward: pushback is not supported.");
                    }
                    if (!ringBufferCapacity.i(iPosition2)) {
                        throw new IllegalStateException("Check failed.");
                    }
                    S(byteBufferG0, ringBufferCapacity, iPosition2);
                    z = true;
                }
            } finally {
                B0();
                M0();
            }
        }
        if (z) {
            return Unit.f53572a;
        }
        if (K() && i2 > 0) {
            throw new EOFException(b.g(i2, "Got EOF but at least ", " bytes were expected"));
        }
        Object objM0 = m0(i2, function1, continuationImpl);
        return objM0 == CoroutineSingletons.f53689a ? objM0 : Unit.f53572a;
    }

    public final void E0() {
        while (true) {
            Continuation continuation = (Continuation) this._writeOp;
            if (continuation == null) {
                return;
            }
            ClosedElement closedElement = (ClosedElement) this._closed;
            if (closedElement == null && this.joining != null) {
                ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) this._state;
                if (!(readWriteBufferState instanceof ReadWriteBufferState.Writing) && !(readWriteBufferState instanceof ReadWriteBufferState.ReadingWriting) && readWriteBufferState != ReadWriteBufferState.Terminated.f51265c) {
                    return;
                }
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, continuation, null)) {
                if (atomicReferenceFieldUpdater.get(this) != continuation) {
                    break;
                }
            }
            if (closedElement == null) {
                Result.Companion companion = Result.f53538b;
                continuation.resumeWith(Unit.f53572a);
                return;
            } else {
                Result.Companion companion2 = Result.f53538b;
                continuation.resumeWith(ResultKt.a(closedElement.a()));
                return;
            }
        }
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object F(ByteBuffer byteBuffer, ContinuationImpl continuationImpl) throws Throwable {
        int iH0 = h0(byteBuffer);
        if (iH0 == 0 && ((ClosedElement) this._closed) != null) {
            iH0 = ((ReadWriteBufferState) this._state).f51254b.c() ? h0(byteBuffer) : -1;
        } else if (iH0 <= 0 && byteBuffer.hasRemaining()) {
            return l0(byteBuffer, continuationImpl);
        }
        return new Integer(iH0);
    }

    @Override // io.ktor.utils.io.HasReadSession
    public final void G() {
        ReadSessionImpl readSessionImpl = this.f50612g;
        readSessionImpl.getClass();
        readSessionImpl.a(ChunkBuffer.f51216l);
        ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) this._state;
        if ((readWriteBufferState instanceof ReadWriteBufferState.Reading) || (readWriteBufferState instanceof ReadWriteBufferState.ReadingWriting)) {
            B0();
            M0();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.nio.ByteBuffer G0() throws java.lang.Throwable {
        /*
            r4 = this;
        L0:
            java.lang.Object r0 = r4._state
            r1 = r0
            io.ktor.utils.io.internal.ReadWriteBufferState r1 = (io.ktor.utils.io.internal.ReadWriteBufferState) r1
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r2 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.f51265c
            boolean r2 = kotlin.jvm.internal.Intrinsics.b(r1, r2)
            if (r2 == 0) goto Lf
            r2 = 1
            goto L15
        Lf:
            io.ktor.utils.io.internal.ReadWriteBufferState$IdleEmpty r2 = io.ktor.utils.io.internal.ReadWriteBufferState.IdleEmpty.f51255c
            boolean r2 = kotlin.jvm.internal.Intrinsics.b(r1, r2)
        L15:
            r3 = 0
            if (r2 == 0) goto L27
            java.lang.Object r0 = r4._closed
            io.ktor.utils.io.internal.ClosedElement r0 = (io.ktor.utils.io.internal.ClosedElement) r0
            if (r0 == 0) goto L3c
            java.lang.Throwable r0 = r0.f51244a
            if (r0 != 0) goto L23
            goto L3c
        L23:
            io.ktor.utils.io.ByteBufferChannelKt.a(r0)
            throw r3
        L27:
            java.lang.Object r2 = r4._closed
            io.ktor.utils.io.internal.ClosedElement r2 = (io.ktor.utils.io.internal.ClosedElement) r2
            if (r2 == 0) goto L36
            java.lang.Throwable r2 = r2.f51244a
            if (r2 != 0) goto L32
            goto L36
        L32:
            io.ktor.utils.io.ByteBufferChannelKt.a(r2)
            throw r3
        L36:
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r1.f51254b
            int r2 = r2._availableForRead$internal
            if (r2 != 0) goto L3d
        L3c:
            return r3
        L3d:
            io.ktor.utils.io.internal.ReadWriteBufferState r1 = r1.d()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = io.ktor.utils.io.ByteBufferChannel.f50605l
        L43:
            boolean r3 = r2.compareAndSet(r4, r0, r1)
            if (r3 == 0) goto L57
            java.nio.ByteBuffer r0 = r1.b()
            int r2 = r4.f50610e
            io.ktor.utils.io.internal.RingBufferCapacity r1 = r1.f51254b
            int r1 = r1._availableForRead$internal
            r4.e0(r0, r2, r1)
            return r0
        L57:
            java.lang.Object r3 = r2.get(r4)
            if (r3 == r0) goto L43
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.G0():java.nio.ByteBuffer");
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object H(int i2, ContinuationImpl continuationImpl) {
        return Z0(this, i2, continuationImpl);
    }

    public final ByteBuffer H0() throws Throwable {
        ReadWriteBufferState readWriteBufferStateE;
        ReadWriteBufferState.Initial initial;
        Continuation continuation = (Continuation) this._writeOp;
        if (continuation != null) {
            throw new IllegalStateException("Write operation is already in progress: " + continuation);
        }
        ReadWriteBufferState.Initial initial2 = null;
        while (true) {
            Object obj = this._state;
            ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) obj;
            if (this.joining == null) {
                if (((ClosedElement) this._closed) != null) {
                    if (initial2 != null) {
                        y0(initial2);
                    }
                    ClosedElement closedElement = (ClosedElement) this._closed;
                    Intrinsics.c(closedElement);
                    ByteBufferChannelKt.a(closedElement.a());
                    throw null;
                }
                if (readWriteBufferState == ReadWriteBufferState.IdleEmpty.f51255c) {
                    if (initial2 == null) {
                        initial2 = (ReadWriteBufferState.Initial) this.f50608c.S0();
                        initial2.f51254b.f();
                    }
                    readWriteBufferStateE = initial2.f51261g;
                } else if (readWriteBufferState == ReadWriteBufferState.Terminated.f51265c) {
                    if (initial2 != null) {
                        y0(initial2);
                    }
                    if (this.joining == null) {
                        ClosedElement closedElement2 = (ClosedElement) this._closed;
                        Intrinsics.c(closedElement2);
                        ByteBufferChannelKt.a(closedElement2.a());
                        throw null;
                    }
                } else {
                    readWriteBufferStateE = readWriteBufferState.e();
                }
                ReadWriteBufferState readWriteBufferState2 = readWriteBufferStateE;
                initial = initial2;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f50605l;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, readWriteBufferState2)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                if (((ClosedElement) this._closed) != null) {
                    C0();
                    M0();
                    ClosedElement closedElement3 = (ClosedElement) this._closed;
                    Intrinsics.c(closedElement3);
                    ByteBufferChannelKt.a(closedElement3.a());
                    throw null;
                }
                ByteBuffer byteBufferC = readWriteBufferState2.c();
                if (initial != null) {
                    if (readWriteBufferState == null) {
                        Intrinsics.h("old");
                        throw null;
                    }
                    if (readWriteBufferState != ReadWriteBufferState.IdleEmpty.f51255c) {
                        y0(initial);
                    }
                }
                e0(byteBufferC, this.f50611f, readWriteBufferState2.f51254b._availableForWrite$internal);
                return byteBufferC;
            }
            if (initial2 != null) {
                y0(initial2);
                return null;
            }
            initial2 = initial;
        }
        return null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object I(ChunkBuffer chunkBuffer, ContinuationImpl continuationImpl) throws Throwable {
        int iI0 = i0(this, chunkBuffer, 0, 6);
        if (iI0 == 0 && ((ClosedElement) this._closed) != null) {
            iI0 = ((ReadWriteBufferState) this._state).f51254b.c() ? i0(this, chunkBuffer, 0, 6) : -1;
        } else if (iI0 <= 0 && chunkBuffer.f51184e > chunkBuffer.f51182c) {
            return j0(chunkBuffer, continuationImpl);
        }
        return new Integer(iI0);
    }

    public final boolean I0() {
        if (this.joining != null) {
            return ((ReadWriteBufferState) this._state) == ReadWriteBufferState.IdleEmpty.f51255c || (((ReadWriteBufferState) this._state) instanceof ReadWriteBufferState.IdleNonEmpty);
        }
        return false;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object J(byte[] bArr, int i2, int i3, ContinuationImpl continuationImpl) throws Throwable {
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            A0(this, joiningState);
        }
        while (i3 > 0) {
            int iQ0 = Q0(i2, bArr, i3);
            if (iQ0 == 0) {
                break;
            }
            i2 += iQ0;
            i3 -= iQ0;
        }
        if (i3 == 0) {
            return Unit.f53572a;
        }
        Object objX0 = X0(bArr, i2, i3, continuationImpl);
        return objX0 == CoroutineSingletons.f53689a ? objX0 : Unit.f53572a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x00d0, code lost:
    
        r5 = kotlin.Result.f53538b;
        r6.resumeWith(java.lang.Boolean.TRUE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J0(int r5, kotlin.coroutines.Continuation r6) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.J0(int, kotlin.coroutines.Continuation):void");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final boolean K() {
        return ((ReadWriteBufferState) this._state) == ReadWriteBufferState.Terminated.f51265c && ((ClosedElement) this._closed) != null;
    }

    public final boolean K0(JoiningState joiningState) {
        if (!L0(true)) {
            return false;
        }
        Z(joiningState);
        Continuation continuation = (Continuation) n.getAndSet(this, null);
        if (continuation != null) {
            Result.Companion companion = Result.f53538b;
            continuation.resumeWith(ResultKt.a(new IllegalStateException("Joining is in progress")));
        }
        E0();
        return true;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final boolean L() {
        return this.f50607b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0081, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean L0(boolean r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = r0
        L2:
            java.lang.Object r2 = r8._state
            r3 = r2
            io.ktor.utils.io.internal.ReadWriteBufferState r3 = (io.ktor.utils.io.internal.ReadWriteBufferState) r3
            java.lang.Object r4 = r8._closed
            io.ktor.utils.io.internal.ClosedElement r4 = (io.ktor.utils.io.internal.ClosedElement) r4
            if (r1 == 0) goto L1e
            if (r4 == 0) goto L12
            java.lang.Throwable r5 = r4.f51244a
            goto L13
        L12:
            r5 = r0
        L13:
            if (r5 != 0) goto L1a
            io.ktor.utils.io.internal.RingBufferCapacity r1 = r1.f51254b
            r1.f()
        L1a:
            r8.E0()
            r1 = r0
        L1e:
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r5 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.f51265c
            r6 = 1
            if (r3 != r5) goto L24
            goto L78
        L24:
            io.ktor.utils.io.internal.ReadWriteBufferState$IdleEmpty r7 = io.ktor.utils.io.internal.ReadWriteBufferState.IdleEmpty.f51255c
            if (r3 != r7) goto L2a
        L28:
            r3 = r1
            goto L63
        L2a:
            r1 = 0
            if (r4 == 0) goto L50
            boolean r7 = r3 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.IdleNonEmpty
            if (r7 == 0) goto L50
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r3.f51254b
            boolean r7 = r7.g()
            if (r7 != 0) goto L3d
            java.lang.Throwable r7 = r4.f51244a
            if (r7 == 0) goto L50
        L3d:
            java.lang.Throwable r4 = r4.f51244a
            if (r4 == 0) goto L4b
            io.ktor.utils.io.internal.RingBufferCapacity r4 = r3.f51254b
            r4.getClass()
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r7 = io.ktor.utils.io.internal.RingBufferCapacity.f51270c
            r7.getAndSet(r4, r1)
        L4b:
            io.ktor.utils.io.internal.ReadWriteBufferState$IdleNonEmpty r3 = (io.ktor.utils.io.internal.ReadWriteBufferState.IdleNonEmpty) r3
            io.ktor.utils.io.internal.ReadWriteBufferState$Initial r1 = r3.f51256c
            goto L28
        L50:
            if (r9 == 0) goto L81
            boolean r4 = r3 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.IdleNonEmpty
            if (r4 == 0) goto L81
            io.ktor.utils.io.internal.RingBufferCapacity r4 = r3.f51254b
            boolean r4 = r4.g()
            if (r4 == 0) goto L81
            io.ktor.utils.io.internal.ReadWriteBufferState$IdleNonEmpty r3 = (io.ktor.utils.io.internal.ReadWriteBufferState.IdleNonEmpty) r3
            io.ktor.utils.io.internal.ReadWriteBufferState$Initial r1 = r3.f51256c
            goto L28
        L63:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = io.ktor.utils.io.ByteBufferChannel.f50605l
        L65:
            boolean r1 = r4.compareAndSet(r8, r2, r5)
            if (r1 == 0) goto L79
            if (r3 == 0) goto L78
            java.lang.Object r9 = r8._state
            io.ktor.utils.io.internal.ReadWriteBufferState r9 = (io.ktor.utils.io.internal.ReadWriteBufferState) r9
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r0 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.f51265c
            if (r9 != r0) goto L78
            r8.y0(r3)
        L78:
            return r6
        L79:
            java.lang.Object r1 = r4.get(r8)
            if (r1 == r2) goto L65
            r1 = r3
            goto L2
        L81:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.L0(boolean):boolean");
    }

    public final void M0() {
        if (((ClosedElement) this._closed) == null || !L0(false)) {
            return;
        }
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            Z(joiningState);
        }
        D0();
        E0();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004b A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int N0(io.ktor.utils.io.core.ByteReadPacket r8) throws java.lang.Throwable {
        /*
            r7 = this;
            io.ktor.utils.io.internal.JoiningState r0 = r7.joining
            if (r0 == 0) goto L7
            A0(r7, r0)
        L7:
            java.nio.ByteBuffer r0 = r7.H0()
            if (r0 != 0) goto Lf
            r8 = 0
            return r8
        Lf:
            java.lang.Object r1 = r7._state
            io.ktor.utils.io.internal.ReadWriteBufferState r1 = (io.ktor.utils.io.internal.ReadWriteBufferState) r1
            io.ktor.utils.io.internal.RingBufferCapacity r1 = r1.f51254b
            r2 = 1
            java.lang.Object r3 = r7._closed     // Catch: java.lang.Throwable -> L3f
            io.ktor.utils.io.internal.ClosedElement r3 = (io.ktor.utils.io.internal.ClosedElement) r3     // Catch: java.lang.Throwable -> L3f
            if (r3 != 0) goto L55
            long r3 = r8.D()     // Catch: java.lang.Throwable -> L3f
            int r5 = r0.remaining()     // Catch: java.lang.Throwable -> L3f
            long r5 = (long) r5     // Catch: java.lang.Throwable -> L3f
            long r3 = java.lang.Math.min(r3, r5)     // Catch: java.lang.Throwable -> L3f
            int r3 = (int) r3     // Catch: java.lang.Throwable -> L3f
            int r3 = r1.j(r3)     // Catch: java.lang.Throwable -> L3f
            if (r3 <= 0) goto L41
            int r4 = r0.position()     // Catch: java.lang.Throwable -> L3f
            int r4 = r4 + r3
            r0.limit(r4)     // Catch: java.lang.Throwable -> L3f
            io.ktor.utils.io.core.ByteBuffersKt.a(r8, r0)     // Catch: java.lang.Throwable -> L3f
            r7.T(r0, r1, r3)     // Catch: java.lang.Throwable -> L3f
            goto L41
        L3f:
            r8 = move-exception
            goto L5e
        L41:
            boolean r8 = r1.d()
            if (r8 != 0) goto L4b
            boolean r8 = r7.f50607b
            if (r8 == 0) goto L4e
        L4b:
            r7.a0(r2)
        L4e:
            r7.C0()
            r7.M0()
            return r3
        L55:
            java.lang.Throwable r8 = r3.a()     // Catch: java.lang.Throwable -> L3f
            io.ktor.utils.io.ByteBufferChannelKt.a(r8)     // Catch: java.lang.Throwable -> L3f
            r8 = 0
            throw r8     // Catch: java.lang.Throwable -> L3f
        L5e:
            boolean r0 = r1.d()
            if (r0 != 0) goto L68
            boolean r0 = r7.f50607b
            if (r0 == 0) goto L6b
        L68:
            r7.a0(r2)
        L6b:
            r7.C0()
            r7.M0()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.N0(io.ktor.utils.io.core.ByteReadPacket):int");
    }

    public final Object O0(int i2, ContinuationImpl frame) throws Throwable {
        if (!f1(i2)) {
            ClosedElement closedElement = (ClosedElement) this._closed;
            if (closedElement == null) {
                return Unit.f53572a;
            }
            ByteBufferChannelKt.a(closedElement.a());
            throw null;
        }
        this.writeSuspensionSize = i2;
        if (this.attachedJob != null) {
            ((ByteBufferChannel$writeSuspension$1) this.f50616k).invoke(frame);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            Intrinsics.checkNotNullParameter(frame, "frame");
            return coroutineSingletons;
        }
        CancellableReusableContinuation cancellableReusableContinuation = this.f50615j;
        ((ByteBufferChannel$writeSuspension$1) this.f50616k).invoke(cancellableReusableContinuation);
        Object objD = cancellableReusableContinuation.d(IntrinsicsKt.b(frame));
        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.f53689a;
        if (objD == coroutineSingletons2) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objD == coroutineSingletons2 ? objD : Unit.f53572a;
    }

    public final void P(Job job) {
        Intrinsics.checkNotNullParameter(job, "job");
        Job job2 = this.attachedJob;
        if (job2 != null) {
            job2.e(null);
        }
        this.attachedJob = job;
        job.D(true, true, new Function1<Throwable, Unit>() { // from class: io.ktor.utils.io.ByteBufferChannel$attachJob$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                ByteBufferChannel byteBufferChannel = this.f50617c;
                byteBufferChannel.attachedJob = null;
                if (th != null) {
                    byteBufferChannel.l(ExceptionUtilsKt.a(th));
                }
                return Unit.f53572a;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Q(int r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteBufferChannel$awaitAtLeastSuspend$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteBufferChannel$awaitAtLeastSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$awaitAtLeastSuspend$1) r0
            int r1 = r0.f50621d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50621d = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$awaitAtLeastSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$awaitAtLeastSuspend$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f50619b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50621d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            io.ktor.utils.io.ByteBufferChannel r5 = r0.f50618a
            kotlin.ResultKt.b(r6)
            goto L40
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r6)
            r0.f50618a = r4
            r0.f50621d = r3
            java.lang.Object r6 = r4.t0(r5, r0)
            if (r6 != r1) goto L3f
            return r1
        L3f:
            r5 = r4
        L40:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r0 = r6.booleanValue()
            if (r0 == 0) goto L55
            java.lang.Object r0 = r5._state
            io.ktor.utils.io.internal.ReadWriteBufferState r0 = (io.ktor.utils.io.internal.ReadWriteBufferState) r0
            boolean r0 = r0.a()
            if (r0 == 0) goto L55
            r5.G0()
        L55:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.Q(int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final int Q0(int i2, byte[] bArr, int i3) throws Throwable {
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            A0(this, joiningState);
        }
        ByteBuffer byteBufferH0 = H0();
        int i4 = 0;
        if (byteBufferH0 == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = ((ReadWriteBufferState) this._state).f51254b;
        try {
            ClosedElement closedElement = (ClosedElement) this._closed;
            if (closedElement != null) {
                ByteBufferChannelKt.a(closedElement.a());
                throw null;
            }
            while (true) {
                int iJ = ringBufferCapacity.j(Math.min(i3 - i4, byteBufferH0.remaining()));
                if (iJ == 0) {
                    T(byteBufferH0, ringBufferCapacity, i4);
                    if (ringBufferCapacity.d() || this.f50607b) {
                        a0(1);
                    }
                    C0();
                    M0();
                    return i4;
                }
                if (iJ <= 0) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                byteBufferH0.put(bArr, i2 + i4, iJ);
                i4 += iJ;
                e0(byteBufferH0, V(this.f50611f + i4, byteBufferH0), ringBufferCapacity._availableForWrite$internal);
            }
        } catch (Throwable th) {
            if (ringBufferCapacity.d() || this.f50607b) {
                a0(1);
            }
            C0();
            M0();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object R(int r5, kotlin.jvm.functions.Function1 r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1 r0 = (io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1) r0
            int r1 = r0.f50626e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50626e = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1 r0 = new io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f50624c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50626e
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 == r3) goto L34
            r5 = 2
            if (r2 != r5) goto L2c
            kotlin.ResultKt.b(r7)
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            io.ktor.utils.io.ByteBufferChannel r5 = r0.f50622a
            kotlin.ResultKt.b(r7)
            goto L4b
        L3a:
            kotlin.ResultKt.b(r7)
            r0.f50622a = r4
            r0.f50623b = r6
            r0.f50626e = r3
            java.lang.Object r5 = r4.d1(r5, r0)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            r5 = r4
        L4b:
            io.ktor.utils.io.internal.JoiningState r6 = r5.joining
            if (r6 == 0) goto L52
            A0(r5, r6)
        L52:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.R(int, kotlin.jvm.functions.Function1, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final int R0(Buffer buffer) throws Throwable {
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            A0(this, joiningState);
        }
        ByteBuffer byteBufferH0 = H0();
        int i2 = 0;
        if (byteBufferH0 == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = ((ReadWriteBufferState) this._state).f51254b;
        try {
            ClosedElement closedElement = (ClosedElement) this._closed;
            if (closedElement != null) {
                ByteBufferChannelKt.a(closedElement.a());
                throw null;
            }
            while (true) {
                int iJ = ringBufferCapacity.j(Math.min(buffer.f51182c - buffer.f51181b, byteBufferH0.remaining()));
                if (iJ == 0) {
                    break;
                }
                BufferUtilsJvmKt.c(buffer, byteBufferH0, iJ);
                i2 += iJ;
                e0(byteBufferH0, V(this.f50611f + i2, byteBufferH0), ringBufferCapacity._availableForWrite$internal);
            }
            T(byteBufferH0, ringBufferCapacity, i2);
            if (ringBufferCapacity.d() || this.f50607b) {
                a0(1);
            }
            C0();
            M0();
            return i2;
        } catch (Throwable th) {
            if (ringBufferCapacity.d() || this.f50607b) {
                a0(1);
            }
            C0();
            M0();
            throw th;
        }
    }

    public final void S(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.f50610e = V(this.f50610e + i2, byteBuffer);
        ringBufferCapacity.a(i2);
        this.totalBytesRead += i2;
        E0();
    }

    public final int S0(ByteBuffer byteBuffer) throws Throwable {
        int iJ;
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            A0(this, joiningState);
        }
        ByteBuffer byteBufferH0 = H0();
        int i2 = 0;
        if (byteBufferH0 == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = ((ReadWriteBufferState) this._state).f51254b;
        try {
            ClosedElement closedElement = (ClosedElement) this._closed;
            if (closedElement != null) {
                ByteBufferChannelKt.a(closedElement.a());
                throw null;
            }
            int iLimit = byteBuffer.limit();
            while (true) {
                int iPosition = iLimit - byteBuffer.position();
                if (iPosition == 0 || (iJ = ringBufferCapacity.j(Math.min(iPosition, byteBufferH0.remaining()))) == 0) {
                    break;
                }
                if (iJ <= 0) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                byteBuffer.limit(byteBuffer.position() + iJ);
                byteBufferH0.put(byteBuffer);
                i2 += iJ;
                e0(byteBufferH0, V(this.f50611f + i2, byteBufferH0), ringBufferCapacity._availableForWrite$internal);
            }
            byteBuffer.limit(iLimit);
            T(byteBufferH0, ringBufferCapacity, i2);
            if (ringBufferCapacity.d() || this.f50607b) {
                a0(1);
            }
            C0();
            M0();
            return i2;
        } catch (Throwable th) {
            if (ringBufferCapacity.d() || this.f50607b) {
                a0(1);
            }
            C0();
            M0();
            throw th;
        }
    }

    public final void T(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.f50611f = V(this.f50611f + i2, byteBuffer);
        ringBufferCapacity.b(i2);
        this.totalBytesWritten += i2;
    }

    public final Object T0(ChunkBuffer chunkBuffer, Continuation continuation) throws Throwable {
        ByteBufferChannel byteBufferChannel;
        Object objT0;
        ByteBufferChannel$writeAvailableSuspend$3 byteBufferChannel$writeAvailableSuspend$3 = (ByteBufferChannel$writeAvailableSuspend$3) continuation;
        int i2 = byteBufferChannel$writeAvailableSuspend$3.f50801e;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            byteBufferChannel$writeAvailableSuspend$3.f50801e = i2 - Integer.MIN_VALUE;
        } else {
            byteBufferChannel$writeAvailableSuspend$3 = new ByteBufferChannel$writeAvailableSuspend$3(this, continuation);
        }
        Object obj = byteBufferChannel$writeAvailableSuspend$3.f50799c;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = byteBufferChannel$writeAvailableSuspend$3.f50801e;
        if (i3 == 0) {
            ResultKt.b(obj);
            byteBufferChannel$writeAvailableSuspend$3.f50797a = this;
            byteBufferChannel$writeAvailableSuspend$3.f50798b = chunkBuffer;
            byteBufferChannel$writeAvailableSuspend$3.f50801e = 1;
            if (d1(1, byteBufferChannel$writeAvailableSuspend$3) != coroutineSingletons) {
                byteBufferChannel = this;
            }
        }
        if (i3 != 1) {
            if (i3 == 2) {
                ResultKt.b(obj);
                return obj;
            }
            if (i3 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        chunkBuffer = byteBufferChannel$writeAvailableSuspend$3.f50798b;
        byteBufferChannel = byteBufferChannel$writeAvailableSuspend$3.f50797a;
        ResultKt.b(obj);
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null) {
            A0(byteBufferChannel, joiningState);
        }
        byteBufferChannel$writeAvailableSuspend$3.f50797a = null;
        byteBufferChannel$writeAvailableSuspend$3.f50798b = null;
        byteBufferChannel$writeAvailableSuspend$3.f50801e = 3;
        JoiningState joiningState2 = byteBufferChannel.joining;
        if (joiningState2 != null) {
            A0(byteBufferChannel, joiningState2);
        }
        int iR0 = byteBufferChannel.R0(chunkBuffer);
        if (iR0 > 0) {
            objT0 = new Integer(iR0);
        } else {
            JoiningState joiningState3 = byteBufferChannel.joining;
            if (joiningState3 != null) {
                A0(byteBufferChannel, joiningState3);
            }
            objT0 = byteBufferChannel.T0(chunkBuffer, byteBufferChannel$writeAvailableSuspend$3);
        }
        return objT0 == coroutineSingletons ? coroutineSingletons : objT0;
    }

    public final void U(ByteBuffer byteBuffer) {
        int iCapacity = byteBuffer.capacity() - this.f50609d;
        int iPosition = byteBuffer.position();
        for (int i2 = iCapacity; i2 < iPosition; i2++) {
            byteBuffer.put(i2 - iCapacity, byteBuffer.get(i2));
        }
    }

    public final Object U0(ByteBuffer byteBuffer, Continuation continuation) throws Throwable {
        ByteBufferChannel byteBufferChannel;
        Object objU0;
        ByteBufferChannel$writeAvailableSuspend$1 byteBufferChannel$writeAvailableSuspend$1 = (ByteBufferChannel$writeAvailableSuspend$1) continuation;
        int i2 = byteBufferChannel$writeAvailableSuspend$1.f50796e;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            byteBufferChannel$writeAvailableSuspend$1.f50796e = i2 - Integer.MIN_VALUE;
        } else {
            byteBufferChannel$writeAvailableSuspend$1 = new ByteBufferChannel$writeAvailableSuspend$1(this, continuation);
        }
        Object obj = byteBufferChannel$writeAvailableSuspend$1.f50794c;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = byteBufferChannel$writeAvailableSuspend$1.f50796e;
        if (i3 == 0) {
            ResultKt.b(obj);
            byteBufferChannel$writeAvailableSuspend$1.f50792a = this;
            byteBufferChannel$writeAvailableSuspend$1.f50793b = byteBuffer;
            byteBufferChannel$writeAvailableSuspend$1.f50796e = 1;
            if (d1(1, byteBufferChannel$writeAvailableSuspend$1) != coroutineSingletons) {
                byteBufferChannel = this;
            }
        }
        if (i3 != 1) {
            if (i3 == 2) {
                ResultKt.b(obj);
                return obj;
            }
            if (i3 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        byteBuffer = byteBufferChannel$writeAvailableSuspend$1.f50793b;
        byteBufferChannel = byteBufferChannel$writeAvailableSuspend$1.f50792a;
        ResultKt.b(obj);
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null) {
            A0(byteBufferChannel, joiningState);
        }
        byteBufferChannel$writeAvailableSuspend$1.f50792a = null;
        byteBufferChannel$writeAvailableSuspend$1.f50793b = null;
        byteBufferChannel$writeAvailableSuspend$1.f50796e = 3;
        JoiningState joiningState2 = byteBufferChannel.joining;
        if (joiningState2 != null) {
            A0(byteBufferChannel, joiningState2);
        }
        int iS0 = byteBufferChannel.S0(byteBuffer);
        if (iS0 > 0) {
            objU0 = new Integer(iS0);
        } else {
            JoiningState joiningState3 = byteBufferChannel.joining;
            if (joiningState3 != null) {
                A0(byteBufferChannel, joiningState3);
            }
            objU0 = byteBufferChannel.U0(byteBuffer, byteBufferChannel$writeAvailableSuspend$1);
        }
        return objU0 == coroutineSingletons ? coroutineSingletons : objU0;
    }

    public final int V(int i2, ByteBuffer byteBuffer) {
        int iCapacity = byteBuffer.capacity();
        int i3 = this.f50609d;
        return i2 >= iCapacity - i3 ? i2 - (byteBuffer.capacity() - i3) : i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:171:0x035b, code lost:
    
        if (r14.O0(1, r6) == r3) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x00f7, code lost:
    
        r2 = r28;
        r28 = r29;
        r0 = r1;
        r4 = r17;
        r5 = r18;
        r17 = r19;
        r6 = r21;
        r7 = r22;
        r14 = r23;
     */
    /* JADX WARN: Path cross not found for [B:129:0x028b, B:131:0x028f], limit reached: 219 */
    /* JADX WARN: Path cross not found for [B:131:0x028f, B:129:0x028b], limit reached: 219 */
    /* JADX WARN: Path cross not found for [B:140:0x02ba, B:147:0x02d5], limit reached: 219 */
    /* JADX WARN: Path cross not found for [B:147:0x02d5, B:140:0x02ba], limit reached: 219 */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x028b A[Catch: all -> 0x035e, TryCatch #13 {all -> 0x035e, blocks: (B:127:0x0285, B:129:0x028b, B:135:0x029a, B:137:0x02aa, B:133:0x0295), top: B:222:0x0285 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x029a A[Catch: all -> 0x035e, TryCatch #13 {all -> 0x035e, blocks: (B:127:0x0285, B:129:0x028b, B:135:0x029a, B:137:0x02aa, B:133:0x0295), top: B:222:0x0285 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02ba A[Catch: all -> 0x0047, TRY_ENTER, TryCatch #4 {all -> 0x0047, blocks: (B:14:0x0039, B:38:0x00c7, B:40:0x00cd, B:42:0x00d1, B:43:0x00d4, B:140:0x02ba, B:143:0x02c2, B:145:0x02ce, B:147:0x02d5, B:149:0x02db, B:151:0x02e5, B:155:0x0311, B:158:0x031b, B:168:0x0336, B:170:0x033a, B:162:0x0324, B:46:0x00dc, B:180:0x0372, B:182:0x0378, B:186:0x0382, B:187:0x038a, B:188:0x0390, B:184:0x037c, B:190:0x0393, B:191:0x0397, B:21:0x005e), top: B:205:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02db A[Catch: all -> 0x0047, TryCatch #4 {all -> 0x0047, blocks: (B:14:0x0039, B:38:0x00c7, B:40:0x00cd, B:42:0x00d1, B:43:0x00d4, B:140:0x02ba, B:143:0x02c2, B:145:0x02ce, B:147:0x02d5, B:149:0x02db, B:151:0x02e5, B:155:0x0311, B:158:0x031b, B:168:0x0336, B:170:0x033a, B:162:0x0324, B:46:0x00dc, B:180:0x0372, B:182:0x0378, B:186:0x0382, B:187:0x038a, B:188:0x0390, B:184:0x037c, B:190:0x0393, B:191:0x0397, B:21:0x005e), top: B:205:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x033a A[Catch: all -> 0x0047, TRY_LEAVE, TryCatch #4 {all -> 0x0047, blocks: (B:14:0x0039, B:38:0x00c7, B:40:0x00cd, B:42:0x00d1, B:43:0x00d4, B:140:0x02ba, B:143:0x02c2, B:145:0x02ce, B:147:0x02d5, B:149:0x02db, B:151:0x02e5, B:155:0x0311, B:158:0x031b, B:168:0x0336, B:170:0x033a, B:162:0x0324, B:46:0x00dc, B:180:0x0372, B:182:0x0378, B:186:0x0382, B:187:0x038a, B:188:0x0390, B:184:0x037c, B:190:0x0393, B:191:0x0397, B:21:0x005e), top: B:205:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0378 A[Catch: all -> 0x0047, TryCatch #4 {all -> 0x0047, blocks: (B:14:0x0039, B:38:0x00c7, B:40:0x00cd, B:42:0x00d1, B:43:0x00d4, B:140:0x02ba, B:143:0x02c2, B:145:0x02ce, B:147:0x02d5, B:149:0x02db, B:151:0x02e5, B:155:0x0311, B:158:0x031b, B:168:0x0336, B:170:0x033a, B:162:0x0324, B:46:0x00dc, B:180:0x0372, B:182:0x0378, B:186:0x0382, B:187:0x038a, B:188:0x0390, B:184:0x037c, B:190:0x0393, B:191:0x0397, B:21:0x005e), top: B:205:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x037c A[Catch: all -> 0x0047, TryCatch #4 {all -> 0x0047, blocks: (B:14:0x0039, B:38:0x00c7, B:40:0x00cd, B:42:0x00d1, B:43:0x00d4, B:140:0x02ba, B:143:0x02c2, B:145:0x02ce, B:147:0x02d5, B:149:0x02db, B:151:0x02e5, B:155:0x0311, B:158:0x031b, B:168:0x0336, B:170:0x033a, B:162:0x0324, B:46:0x00dc, B:180:0x0372, B:182:0x0378, B:186:0x0382, B:187:0x038a, B:188:0x0390, B:184:0x037c, B:190:0x0393, B:191:0x0397, B:21:0x005e), top: B:205:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0382 A[Catch: all -> 0x0047, TryCatch #4 {all -> 0x0047, blocks: (B:14:0x0039, B:38:0x00c7, B:40:0x00cd, B:42:0x00d1, B:43:0x00d4, B:140:0x02ba, B:143:0x02c2, B:145:0x02ce, B:147:0x02d5, B:149:0x02db, B:151:0x02e5, B:155:0x0311, B:158:0x031b, B:168:0x0336, B:170:0x033a, B:162:0x0324, B:46:0x00dc, B:180:0x0372, B:182:0x0378, B:186:0x0382, B:187:0x038a, B:188:0x0390, B:184:0x037c, B:190:0x0393, B:191:0x0397, B:21:0x005e), top: B:205:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0393 A[Catch: all -> 0x0047, TryCatch #4 {all -> 0x0047, blocks: (B:14:0x0039, B:38:0x00c7, B:40:0x00cd, B:42:0x00d1, B:43:0x00d4, B:140:0x02ba, B:143:0x02c2, B:145:0x02ce, B:147:0x02d5, B:149:0x02db, B:151:0x02e5, B:155:0x0311, B:158:0x031b, B:168:0x0336, B:170:0x033a, B:162:0x0324, B:46:0x00dc, B:180:0x0372, B:182:0x0378, B:186:0x0382, B:187:0x038a, B:188:0x0390, B:184:0x037c, B:190:0x0393, B:191:0x0397, B:21:0x005e), top: B:205:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0209 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cd A[Catch: all -> 0x0047, TryCatch #4 {all -> 0x0047, blocks: (B:14:0x0039, B:38:0x00c7, B:40:0x00cd, B:42:0x00d1, B:43:0x00d4, B:140:0x02ba, B:143:0x02c2, B:145:0x02ce, B:147:0x02d5, B:149:0x02db, B:151:0x02e5, B:155:0x0311, B:158:0x031b, B:168:0x0336, B:170:0x033a, B:162:0x0324, B:46:0x00dc, B:180:0x0372, B:182:0x0378, B:186:0x0382, B:187:0x038a, B:188:0x0390, B:184:0x037c, B:190:0x0393, B:191:0x0397, B:21:0x005e), top: B:205:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fd A[Catch: all -> 0x0167, TryCatch #3 {all -> 0x0167, blocks: (B:50:0x00f7, B:52:0x00fd, B:54:0x0101), top: B:203:0x00f7 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013e A[Catch: all -> 0x014c, TRY_LEAVE, TryCatch #7 {all -> 0x014c, blocks: (B:60:0x013a, B:62:0x013e), top: B:210:0x013a }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:145:0x02ce -> B:146:0x02d1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:169:0x0338 -> B:146:0x02d1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:171:0x035b -> B:146:0x02d1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object W(io.ktor.utils.io.ByteBufferChannel r28, long r29, kotlin.coroutines.jvm.internal.ContinuationImpl r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 934
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.W(io.ktor.utils.io.ByteBufferChannel, long, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0050 -> B:24:0x0053). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object W0(io.ktor.utils.io.core.Buffer r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3 r0 = (io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3) r0
            int r1 = r0.f50819e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50819e = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f50817c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50819e
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 == r3) goto L34
            r6 = 2
            if (r2 != r6) goto L2c
            kotlin.ResultKt.b(r7)
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            io.ktor.utils.io.core.Buffer r6 = r0.f50816b
            io.ktor.utils.io.ByteBufferChannel r2 = r0.f50815a
            kotlin.ResultKt.b(r7)
            goto L53
        L3c:
            kotlin.ResultKt.b(r7)
            r2 = r5
        L40:
            int r7 = r6.f51182c
            int r4 = r6.f51181b
            if (r7 <= r4) goto L5e
            r0.f50815a = r2
            r0.f50816b = r6
            r0.f50819e = r3
            java.lang.Object r7 = r2.O0(r3, r0)
            if (r7 != r1) goto L53
            return r1
        L53:
            io.ktor.utils.io.internal.JoiningState r7 = r2.joining
            if (r7 == 0) goto L5a
            A0(r2, r7)
        L5a:
            r2.R0(r6)
            goto L40
        L5e:
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.W0(io.ktor.utils.io.core.Buffer, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final ReadWriteBufferState X() {
        return (ReadWriteBufferState) this._state;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0062 -> B:26:0x0065). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object X0(byte[] r7, int r8, int r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5 r0 = (io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5) r0
            int r1 = r0.f50826g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50826g = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5 r0 = new io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.f50824e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50826g
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            int r7 = r0.f50823d
            int r8 = r0.f50822c
            byte[] r9 = r0.f50821b
            io.ktor.utils.io.ByteBufferChannel r2 = r0.f50820a
            kotlin.ResultKt.b(r10)
            goto L65
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            kotlin.ResultKt.b(r10)
            r2 = r6
        L3b:
            if (r9 <= 0) goto L71
            r0.f50820a = r2
            r0.f50821b = r7
            r0.f50822c = r8
            r0.f50823d = r9
            r0.f50826g = r3
            io.ktor.utils.io.internal.JoiningState r10 = r2.joining
            if (r10 == 0) goto L4e
            A0(r2, r10)
        L4e:
            int r10 = r2.Q0(r8, r7, r9)
            if (r10 <= 0) goto L5b
            java.lang.Integer r4 = new java.lang.Integer
            r4.<init>(r10)
            r10 = r4
            goto L5f
        L5b:
            java.lang.Object r10 = r2.e1(r7, r8, r9, r0)
        L5f:
            if (r10 != r1) goto L62
            return r1
        L62:
            r5 = r9
            r9 = r7
            r7 = r5
        L65:
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            int r8 = r8 + r10
            int r7 = r7 - r10
            r5 = r9
            r9 = r7
            r7 = r5
            goto L3b
        L71:
            kotlin.Unit r7 = kotlin.Unit.f53572a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.X0(byte[], int, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[PHI: r10 r12 r13
      PHI (r10v2 long) = (r10v1 long), (r10v5 long) binds: [B:14:0x0035, B:30:0x007a] A[DONT_GENERATE, DONT_INLINE]
      PHI (r12v2 kotlin.jvm.internal.Ref$LongRef) = (r12v1 kotlin.jvm.internal.Ref$LongRef), (r12v5 kotlin.jvm.internal.Ref$LongRef) binds: [B:14:0x0035, B:30:0x007a] A[DONT_GENERATE, DONT_INLINE]
      PHI (r13v1 io.ktor.utils.io.ByteBufferChannel) = (r13v0 io.ktor.utils.io.ByteBufferChannel), (r13v2 io.ktor.utils.io.ByteBufferChannel) binds: [B:14:0x0035, B:30:0x007a] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0071 -> B:29:0x0074). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Y(long r10, long r12, kotlin.coroutines.jvm.internal.ContinuationImpl r14) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r14 instanceof io.ktor.utils.io.ByteBufferChannel$discardSuspend$1
            if (r0 == 0) goto L13
            r0 = r14
            io.ktor.utils.io.ByteBufferChannel$discardSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$discardSuspend$1) r0
            int r1 = r0.f50645f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50645f = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$discardSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$discardSuspend$1
            r0.<init>(r9, r14)
        L18:
            java.lang.Object r14 = r0.f50643d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50645f
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            long r10 = r0.f50642c
            kotlin.jvm.internal.Ref$LongRef r12 = r0.f50641b
            io.ktor.utils.io.ByteBufferChannel r13 = r0.f50640a
            kotlin.ResultKt.b(r14)
            goto L74
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L35:
            kotlin.ResultKt.b(r14)
            kotlin.jvm.internal.Ref$LongRef r14 = new kotlin.jvm.internal.Ref$LongRef
            r14.<init>()
            r14.f53800a = r10
            r10 = r12
            r12 = r14
            r13 = r9
        L42:
            long r4 = r12.f53800a
            int r14 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r14 >= 0) goto La5
            java.nio.ByteBuffer r14 = r13.G0()
            if (r14 != 0) goto L4f
            goto L5f
        L4f:
            java.lang.Object r2 = r13._state
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = (io.ktor.utils.io.internal.ReadWriteBufferState) r2
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r2.f51254b
            int r4 = r2._availableForRead$internal     // Catch: java.lang.Throwable -> L9d
            if (r4 != 0) goto L7d
            r13.B0()
            r13.M0()
        L5f:
            boolean r14 = r13.K()
            if (r14 != 0) goto La5
            r0.f50640a = r13
            r0.f50641b = r12
            r0.f50642c = r10
            r0.f50645f = r3
            java.lang.Object r14 = r13.t0(r3, r0)
            if (r14 != r1) goto L74
            return r1
        L74:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 != 0) goto L42
            goto La5
        L7d:
            long r4 = r12.f53800a     // Catch: java.lang.Throwable -> L9d
            long r4 = r10 - r4
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r4 = java.lang.Math.min(r6, r4)     // Catch: java.lang.Throwable -> L9d
            int r4 = (int) r4     // Catch: java.lang.Throwable -> L9d
            int r4 = r2.h(r4)     // Catch: java.lang.Throwable -> L9d
            r13.S(r14, r2, r4)     // Catch: java.lang.Throwable -> L9d
            long r5 = r12.f53800a     // Catch: java.lang.Throwable -> L9d
            long r7 = (long) r4     // Catch: java.lang.Throwable -> L9d
            long r5 = r5 + r7
            r12.f53800a = r5     // Catch: java.lang.Throwable -> L9d
            r13.B0()
            r13.M0()
            goto L42
        L9d:
            r10 = move-exception
            r13.B0()
            r13.M0()
            throw r10
        La5:
            long r10 = r12.f53800a
            java.lang.Long r12 = new java.lang.Long
            r12.<init>(r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.Y(long, long, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0050 -> B:24:0x0053). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Y0(java.nio.ByteBuffer r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1) r0
            int r1 = r0.f50814e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50814e = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f50812c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50814e
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 == r3) goto L34
            r5 = 2
            if (r2 != r5) goto L2c
            kotlin.ResultKt.b(r6)
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.nio.ByteBuffer r5 = r0.f50811b
            io.ktor.utils.io.ByteBufferChannel r2 = r0.f50810a
            kotlin.ResultKt.b(r6)
            goto L53
        L3c:
            kotlin.ResultKt.b(r6)
            r2 = r4
        L40:
            boolean r6 = r5.hasRemaining()
            if (r6 == 0) goto L5e
            r0.f50810a = r2
            r0.f50811b = r5
            r0.f50814e = r3
            java.lang.Object r6 = r2.O0(r3, r0)
            if (r6 != r1) goto L53
            return r1
        L53:
            io.ktor.utils.io.internal.JoiningState r6 = r2.joining
            if (r6 == 0) goto L5a
            A0(r2, r6)
        L5a:
            r2.S0(r5)
            goto L40
        L5e:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.Y0(java.nio.ByteBuffer, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void Z(JoiningState joiningState) {
        if (((ClosedElement) this._closed) == null) {
            return;
        }
        this.joining = null;
        joiningState.getClass();
        throw null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public final Throwable a() {
        ClosedElement closedElement = (ClosedElement) this._closed;
        if (closedElement != null) {
            return closedElement.f51244a;
        }
        return null;
    }

    public final void a0(int i2) {
        ReadWriteBufferState readWriteBufferState;
        ReadWriteBufferState.Terminated terminated;
        do {
            readWriteBufferState = (ReadWriteBufferState) this._state;
            terminated = ReadWriteBufferState.Terminated.f51265c;
            if (readWriteBufferState == terminated) {
                return;
            } else {
                readWriteBufferState.f51254b.c();
            }
        } while (readWriteBufferState != ((ReadWriteBufferState) this._state));
        int i3 = readWriteBufferState.f51254b._availableForWrite$internal;
        if (readWriteBufferState.f51254b._availableForRead$internal >= 1) {
            D0();
        }
        JoiningState joiningState = this.joining;
        if (i3 >= i2) {
            if (joiningState == null || ((ReadWriteBufferState) this._state) == terminated) {
                E0();
            }
        }
    }

    @Override // io.ktor.utils.io.LookAheadSuspendSession
    public final Object b(int i2, ContinuationImpl continuationImpl) throws Throwable {
        if (i2 < 0) {
            throw new IllegalArgumentException(b.f(i2, "atLeast parameter shouldn't be negative: ").toString());
        }
        if (i2 > 4088) {
            throw new IllegalArgumentException(b.f(i2, "atLeast parameter shouldn't be larger than max buffer size of 4088: ").toString());
        }
        if (((ReadWriteBufferState) this._state).f51254b._availableForRead$internal < i2) {
            return (((ReadWriteBufferState) this._state).a() || (((ReadWriteBufferState) this._state) instanceof ReadWriteBufferState.Writing)) ? Q(i2, continuationImpl) : i2 == 1 ? u0(1, continuationImpl) : t0(i2, continuationImpl);
        }
        if (((ReadWriteBufferState) this._state).a() || (((ReadWriteBufferState) this._state) instanceof ReadWriteBufferState.Writing)) {
            G0();
        }
        return Boolean.TRUE;
    }

    public final JoiningState b0() {
        return this.joining;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004f A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:14:0x002a, B:22:0x0041, B:30:0x005c, B:32:0x0060, B:33:0x0063, B:25:0x0049, B:27:0x004f), top: B:39:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060 A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:14:0x002a, B:22:0x0041, B:30:0x005c, B:32:0x0060, B:33:0x0063, B:25:0x0049, B:27:0x004f), top: B:39:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0059 -> B:30:0x005c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b1(io.ktor.utils.io.core.ByteReadPacket r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1) r0
            int r1 = r0.f50847e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50847e = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f50845c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50847e
            r3 = 1
            if (r2 == 0) goto L45
            if (r2 == r3) goto L3d
            r5 = 2
            if (r2 != r5) goto L35
            io.ktor.utils.io.ByteBufferChannel r5 = r0.f50843a
            io.ktor.utils.io.core.ByteReadPacket r5 = (io.ktor.utils.io.core.ByteReadPacket) r5
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L33
            kotlin.Unit r6 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L33
            r5.release()
            return r6
        L33:
            r6 = move-exception
            goto L6d
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            io.ktor.utils.io.core.ByteReadPacket r5 = r0.f50844b
            io.ktor.utils.io.ByteBufferChannel r2 = r0.f50843a
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L33
            goto L5c
        L45:
            kotlin.ResultKt.b(r6)
            r2 = r4
        L49:
            boolean r6 = r5.x()     // Catch: java.lang.Throwable -> L33
            if (r6 != 0) goto L67
            r0.f50843a = r2     // Catch: java.lang.Throwable -> L33
            r0.f50844b = r5     // Catch: java.lang.Throwable -> L33
            r0.f50847e = r3     // Catch: java.lang.Throwable -> L33
            java.lang.Object r6 = r2.d1(r3, r0)     // Catch: java.lang.Throwable -> L33
            if (r6 != r1) goto L5c
            return r1
        L5c:
            io.ktor.utils.io.internal.JoiningState r6 = r2.joining     // Catch: java.lang.Throwable -> L33
            if (r6 == 0) goto L63
            A0(r2, r6)     // Catch: java.lang.Throwable -> L33
        L63:
            r2.N0(r5)     // Catch: java.lang.Throwable -> L33
            goto L49
        L67:
            r5.release()
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        L6d:
            r5.release()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.b1(io.ktor.utils.io.core.ByteReadPacket, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.utils.io.LookAheadSession
    public final ByteBuffer c(int i2, int i3) {
        ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) this._state;
        int i4 = readWriteBufferState.f51254b._availableForRead$internal;
        int i5 = this.f50610e;
        if (i4 < i3 + i2) {
            return null;
        }
        if (readWriteBufferState.a() || !((readWriteBufferState instanceof ReadWriteBufferState.Reading) || (readWriteBufferState instanceof ReadWriteBufferState.ReadingWriting))) {
            if (G0() == null) {
                return null;
            }
            return c(i2, i3);
        }
        ByteBuffer byteBufferB = readWriteBufferState.b();
        e0(byteBufferB, V(i5 + i2, byteBufferB), i4 - i2);
        if (byteBufferB.remaining() >= i3) {
            return byteBufferB;
        }
        return null;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean d(Throwable th) {
        JoiningState joiningState;
        if (((ClosedElement) this._closed) == null) {
            ClosedElement closedElement = th == null ? ClosedElement.f51243b : new ClosedElement(th);
            ((ReadWriteBufferState) this._state).f51254b.c();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f50606m;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, closedElement)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                }
            }
            ((ReadWriteBufferState) this._state).f51254b.c();
            RingBufferCapacity ringBufferCapacity = ((ReadWriteBufferState) this._state).f51254b;
            if (ringBufferCapacity._availableForWrite$internal == ringBufferCapacity.f51272a || th != null) {
                M0();
            }
            Continuation continuation = (Continuation) n.getAndSet(this, null);
            if (continuation != null) {
                if (th != null) {
                    Result.Companion companion = Result.f53538b;
                    continuation.resumeWith(ResultKt.a(th));
                } else {
                    Boolean boolValueOf = Boolean.valueOf(((ReadWriteBufferState) this._state).f51254b._availableForRead$internal > 0);
                    Result.Companion companion2 = Result.f53538b;
                    continuation.resumeWith(boolValueOf);
                }
            }
            Continuation continuation2 = (Continuation) o.getAndSet(this, null);
            if (continuation2 != null) {
                Result.Companion companion3 = Result.f53538b;
                continuation2.resumeWith(ResultKt.a(th == null ? new ClosedWriteChannelException("Byte channel was closed") : th));
            }
            if (((ReadWriteBufferState) this._state) == ReadWriteBufferState.Terminated.f51265c && (joiningState = this.joining) != null) {
                Z(joiningState);
            }
            if (th == null) {
                this.f50615j.c(new ClosedWriteChannelException("Byte channel was closed"));
                this.f50614i.b(Boolean.valueOf(((ReadWriteBufferState) this._state).f51254b.c()));
                return true;
            }
            Job job = this.attachedJob;
            if (job != null) {
                job.e(null);
            }
            this.f50614i.c(th);
            this.f50615j.c(th);
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d1(int r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteBufferChannel$writeSuspend$3
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$3 r0 = (io.ktor.utils.io.ByteBufferChannel$writeSuspend$3) r0
            int r1 = r0.f50867e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50867e = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$writeSuspend$3
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f50865c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50867e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            int r8 = r0.f50864b
            io.ktor.utils.io.ByteBufferChannel r2 = r0.f50863a
            kotlin.ResultKt.b(r9)
            goto L37
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L33:
            kotlin.ResultKt.b(r9)
            r2 = r7
        L37:
            boolean r9 = r2.f1(r8)
            r4 = 0
            if (r9 == 0) goto Lb1
            r0.f50863a = r2
            r0.f50864b = r8
            r0.f50867e = r3
            kotlinx.coroutines.CancellableContinuationImpl r9 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r0)
            r9.<init>(r3, r5)
            r9.s()
        L50:
            java.lang.Object r5 = r2._closed
            io.ktor.utils.io.internal.ClosedElement r5 = (io.ktor.utils.io.internal.ClosedElement) r5
            if (r5 != 0) goto La9
            boolean r5 = r2.f1(r8)
            if (r5 != 0) goto L64
            kotlin.Result$Companion r4 = kotlin.Result.f53538b
            kotlin.Unit r4 = kotlin.Unit.f53572a
            r9.resumeWith(r4)
            goto L85
        L64:
            java.lang.Object r5 = r2._writeOp
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            if (r5 != 0) goto La1
            boolean r5 = r2.f1(r8)
            if (r5 != 0) goto L71
            goto L50
        L71:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = io.ktor.utils.io.ByteBufferChannel.o
            boolean r6 = com.google.android.gms.internal.pal.a.m(r5, r2, r9)
            if (r6 == 0) goto L64
            boolean r6 = r2.f1(r8)
            if (r6 != 0) goto L85
            boolean r5 = com.google.android.gms.internal.pal.a.z(r5, r2, r9)
            if (r5 != 0) goto L50
        L85:
            r2.a0(r8)
            boolean r4 = r2.I0()
            if (r4 == 0) goto L91
            r2.D0()
        L91:
            java.lang.Object r9 = r9.r()
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            if (r9 != r4) goto L9e
            java.lang.String r4 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r4)
        L9e:
            if (r9 != r1) goto L37
            return r1
        La1:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Operation is already in progress"
            r8.<init>(r9)
            throw r8
        La9:
            java.lang.Throwable r8 = r5.a()
            io.ktor.utils.io.ByteBufferChannelKt.a(r8)
            throw r4
        Lb1:
            java.lang.Object r8 = r2._closed
            io.ktor.utils.io.internal.ClosedElement r8 = (io.ktor.utils.io.internal.ClosedElement) r8
            if (r8 != 0) goto Lba
            kotlin.Unit r8 = kotlin.Unit.f53572a
            return r8
        Lba:
            java.lang.Throwable r8 = r8.a()
            io.ktor.utils.io.ByteBufferChannelKt.a(r8)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.d1(int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object e(short s, ContinuationImpl continuationImpl) {
        return c1(this, s, continuationImpl);
    }

    public final void e0(ByteBuffer byteBuffer, int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int iCapacity = byteBuffer.capacity() - this.f50609d;
        int i4 = i3 + i2;
        if (i4 <= iCapacity) {
            iCapacity = i4;
        }
        byteBuffer.limit(iCapacity);
        byteBuffer.position(i2);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0055 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0053 -> B:22:0x0056). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e1(byte[] r6, int r7, int r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteBufferChannel$writeSuspend$1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeSuspend$1) r0
            int r1 = r0.f50862g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50862g = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeSuspend$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.f50860e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50862g
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 == r3) goto L32
            r6 = 2
            if (r2 != r6) goto L2a
            kotlin.ResultKt.b(r9)
            return r9
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            int r6 = r0.f50859d
            int r7 = r0.f50858c
            byte[] r8 = r0.f50857b
            io.ktor.utils.io.ByteBufferChannel r2 = r0.f50856a
            kotlin.ResultKt.b(r9)
            r4 = r8
            r8 = r6
            r6 = r4
            goto L56
        L41:
            kotlin.ResultKt.b(r9)
            r2 = r5
        L45:
            r0.f50856a = r2
            r0.f50857b = r6
            r0.f50858c = r7
            r0.f50859d = r8
            r0.f50862g = r3
            java.lang.Object r9 = r2.O0(r3, r0)
            if (r9 != r1) goto L56
            return r1
        L56:
            io.ktor.utils.io.internal.JoiningState r9 = r2.joining
            if (r9 == 0) goto L5d
            A0(r2, r9)
        L5d:
            int r9 = r2.Q0(r7, r6, r8)
            if (r9 <= 0) goto L45
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r9)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.e1(byte[], int, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object f(byte b2, ContinuationImpl continuationImpl) {
        return V0(this, b2, continuationImpl);
    }

    public final void f0(int i2, ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        e0(buffer, this.f50611f, i2);
    }

    public final boolean f1(int i2) {
        JoiningState joiningState = this.joining;
        ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) this._state;
        if (((ClosedElement) this._closed) != null) {
            return false;
        }
        return joiningState == null ? readWriteBufferState.f51254b._availableForWrite$internal < i2 && readWriteBufferState != ReadWriteBufferState.IdleEmpty.f51255c : (readWriteBufferState == ReadWriteBufferState.Terminated.f51265c || (readWriteBufferState instanceof ReadWriteBufferState.Writing) || (readWriteBufferState instanceof ReadWriteBufferState.ReadingWriting)) ? false : true;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final void flush() {
        a0(1);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final int g() {
        return ((ReadWriteBufferState) this._state).f51254b._availableForRead$internal;
    }

    public final int g0(int i2, byte[] bArr, int i3) throws Throwable {
        ByteBuffer byteBufferG0 = G0();
        int i4 = 0;
        if (byteBufferG0 == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = ((ReadWriteBufferState) this._state).f51254b;
        try {
            if (ringBufferCapacity._availableForRead$internal != 0) {
                int iCapacity = byteBufferG0.capacity() - this.f50609d;
                while (true) {
                    int i5 = i3 - i4;
                    if (i5 == 0) {
                        break;
                    }
                    int i6 = this.f50610e;
                    int iH = ringBufferCapacity.h(Math.min(iCapacity - i6, i5));
                    if (iH == 0) {
                        break;
                    }
                    byteBufferG0.limit(i6 + iH);
                    byteBufferG0.position(i6);
                    byteBufferG0.get(bArr, i2 + i4, iH);
                    S(byteBufferG0, ringBufferCapacity, iH);
                    i4 += iH;
                }
            }
            return i4;
        } finally {
            B0();
            M0();
        }
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final boolean h() {
        return ((ClosedElement) this._closed) != null;
    }

    public final int h0(ByteBuffer byteBuffer) throws Throwable {
        ByteBuffer byteBufferG0 = G0();
        int i2 = 0;
        if (byteBufferG0 == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = ((ReadWriteBufferState) this._state).f51254b;
        try {
            if (ringBufferCapacity._availableForRead$internal != 0) {
                int iCapacity = byteBufferG0.capacity() - this.f50609d;
                while (true) {
                    int iRemaining = byteBuffer.remaining();
                    if (iRemaining == 0) {
                        break;
                    }
                    int i3 = this.f50610e;
                    int iH = ringBufferCapacity.h(Math.min(iCapacity - i3, iRemaining));
                    if (iH == 0) {
                        break;
                    }
                    byteBufferG0.limit(i3 + iH);
                    byteBufferG0.position(i3);
                    byteBuffer.put(byteBufferG0);
                    S(byteBufferG0, ringBufferCapacity, iH);
                    i2 += iH;
                }
            }
            return i2;
        } finally {
            B0();
            M0();
        }
    }

    public final boolean h1(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, Function1 function1) {
        int i2;
        int iCapacity = byteBuffer.capacity() - this.f50609d;
        boolean z = true;
        while (z) {
            while (true) {
                i2 = ringBufferCapacity._availableForWrite$internal;
                if (i2 < 1) {
                    i2 = 0;
                    break;
                }
                if (RingBufferCapacity.f51270c.compareAndSet(ringBufferCapacity, i2, 0)) {
                    break;
                }
            }
            if (i2 == 0) {
                break;
            }
            int i3 = this.f50611f;
            int i4 = i3 + i2;
            if (i4 > iCapacity) {
                i4 = iCapacity;
            }
            byteBuffer.limit(i4);
            byteBuffer.position(i3);
            try {
                boolean zBooleanValue = ((Boolean) function1.invoke(byteBuffer)).booleanValue();
                if (byteBuffer.limit() != i4) {
                    throw new IllegalStateException("Buffer limit modified.");
                }
                int iPosition = byteBuffer.position() - i3;
                if (iPosition < 0) {
                    throw new IllegalStateException("Position has been moved backward: pushback is not supported.");
                }
                T(byteBuffer, ringBufferCapacity, iPosition);
                if (iPosition < i2) {
                    ringBufferCapacity.a(i2 - iPosition);
                }
                z = zBooleanValue;
            } catch (Throwable th) {
                ringBufferCapacity.a(i2);
                throw th;
            }
        }
        return z;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object i(ByteBuffer byteBuffer, long j2, long j3, long j4, Continuation continuation) {
        return d0(this, byteBuffer, j2, j3, j4, (ContinuationImpl) continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b7, code lost:
    
        if (((io.ktor.utils.io.internal.ClosedElement) r4._closed) != null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0147, code lost:
    
        if (r0 == r3) goto L81;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9 A[Catch: all -> 0x0050, TryCatch #0 {all -> 0x0050, blocks: (B:16:0x004b, B:33:0x00a5, B:35:0x00a9, B:37:0x00af, B:38:0x00b3, B:30:0x0087), top: B:115:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a1 -> B:33:0x00a5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i1(kotlin.jvm.functions.Function1 r18, kotlin.coroutines.jvm.internal.ContinuationImpl r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 429
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.i1(kotlin.jvm.functions.Function1, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object j(byte[] bArr, int i2, int i3, ContinuationImpl continuationImpl) throws Throwable {
        int iG0 = g0(i2, bArr, i3);
        if (iG0 == 0 && ((ClosedElement) this._closed) != null) {
            iG0 = ((ReadWriteBufferState) this._state).f51254b.c() ? g0(i2, bArr, i3) : -1;
        } else if (iG0 <= 0 && i3 != 0) {
            return k0(bArr, i2, i3, continuationImpl);
        }
        return new Integer(iG0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j0(io.ktor.utils.io.core.internal.ChunkBuffer r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3 r0 = (io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3) r0
            int r1 = r0.f50680e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50680e = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f50678c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50680e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.b(r7)
            return r7
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = r0.f50677b
            io.ktor.utils.io.ByteBufferChannel r2 = r0.f50676a
            kotlin.ResultKt.b(r7)
            goto L4b
        L3a:
            kotlin.ResultKt.b(r7)
            r0.f50676a = r5
            r0.f50677b = r6
            r0.f50680e = r4
            java.lang.Object r7 = r5.t0(r4, r0)
            if (r7 != r1) goto L4a
            goto L67
        L4a:
            r2 = r5
        L4b:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L5a
            java.lang.Integer r6 = new java.lang.Integer
            r7 = -1
            r6.<init>(r7)
            return r6
        L5a:
            r7 = 0
            r0.f50676a = r7
            r0.f50677b = r7
            r0.f50680e = r3
            java.lang.Object r6 = r2.I(r6, r0)
            if (r6 != r1) goto L68
        L67:
            return r1
        L68:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.j0(io.ktor.utils.io.core.internal.ChunkBuffer, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0092 -> B:40:0x0095). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(kotlin.coroutines.jvm.internal.ContinuationImpl r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$readShort$1
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readShort$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readShort$1) r0
            int r1 = r0.f50749e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50749e = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readShort$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readShort$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f50747c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50749e
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            int r2 = r0.f50746b
            io.ktor.utils.io.ByteBufferChannel r4 = r0.f50745a
            kotlin.ResultKt.b(r10)
            goto L95
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L34:
            kotlin.ResultKt.b(r10)
            r10 = 2
            r4 = r9
            r2 = r10
        L3a:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            java.nio.ByteBuffer r5 = r4.G0()
            r6 = 0
            if (r5 != 0) goto L47
            goto L78
        L47:
            java.lang.Object r7 = r4._state
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = (io.ktor.utils.io.internal.ReadWriteBufferState) r7
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.f51254b
            int r8 = r7._availableForRead$internal     // Catch: java.lang.Throwable -> Lac
            if (r8 != 0) goto L58
        L51:
            r4.B0()
            r4.M0()
            goto L78
        L58:
            boolean r8 = r7.i(r2)     // Catch: java.lang.Throwable -> Lac
            if (r8 != 0) goto L5f
            goto L51
        L5f:
            int r6 = r5.remaining()     // Catch: java.lang.Throwable -> Lac
            if (r6 >= r2) goto L68
            F0(r2, r5)     // Catch: java.lang.Throwable -> Lac
        L68:
            short r6 = r5.getShort()     // Catch: java.lang.Throwable -> Lac
            java.lang.Short r8 = new java.lang.Short     // Catch: java.lang.Throwable -> Lac
            r8.<init>(r6)     // Catch: java.lang.Throwable -> Lac
            r10.f53801a = r8     // Catch: java.lang.Throwable -> Lac
            r4.S(r5, r7, r2)     // Catch: java.lang.Throwable -> Lac
            r6 = r3
            goto L51
        L78:
            if (r6 == 0) goto L88
            java.lang.Object r10 = r10.f53801a
            if (r10 == 0) goto L81
            java.lang.Number r10 = (java.lang.Number) r10
            return r10
        L81:
            java.lang.String r10 = "result"
            kotlin.jvm.internal.Intrinsics.h(r10)
            r10 = 0
            throw r10
        L88:
            r0.f50745a = r4
            r0.f50746b = r2
            r0.f50749e = r3
            java.lang.Object r10 = r4.t0(r2, r0)
            if (r10 != r1) goto L95
            return r1
        L95:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L9e
            goto L3a
        L9e:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r10 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.String r0 = "EOF while "
            java.lang.String r1 = " bytes expected"
            java.lang.String r0 = android.support.v4.media.b.g(r2, r0, r1)
            r10.<init>(r0)
            throw r10
        Lac:
            r10 = move-exception
            r4.B0()
            r4.M0()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.k(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k0(byte[] r6, int r7, int r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1) r0
            int r1 = r0.f50670g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50670g = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.f50668e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50670g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.b(r9)
            return r9
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            int r8 = r0.f50667d
            int r7 = r0.f50666c
            byte[] r6 = r0.f50665b
            io.ktor.utils.io.ByteBufferChannel r2 = r0.f50664a
            kotlin.ResultKt.b(r9)
            goto L53
        L3e:
            kotlin.ResultKt.b(r9)
            r0.f50664a = r5
            r0.f50665b = r6
            r0.f50666c = r7
            r0.f50667d = r8
            r0.f50670g = r4
            java.lang.Object r9 = r5.t0(r4, r0)
            if (r9 != r1) goto L52
            goto L6f
        L52:
            r2 = r5
        L53:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L62
            java.lang.Integer r6 = new java.lang.Integer
            r7 = -1
            r6.<init>(r7)
            return r6
        L62:
            r9 = 0
            r0.f50664a = r9
            r0.f50665b = r9
            r0.f50670g = r3
            java.lang.Object r6 = r2.j(r6, r7, r8, r0)
            if (r6 != r1) goto L70
        L6f:
            return r1
        L70:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.k0(byte[], int, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final boolean l(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel has been cancelled");
        }
        return d(th);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l0(java.nio.ByteBuffer r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$2
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$2 r0 = (io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$2) r0
            int r1 = r0.f50675e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50675e = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$2 r0 = new io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$2
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f50673c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50675e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.b(r7)
            return r7
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            java.nio.ByteBuffer r6 = r0.f50672b
            io.ktor.utils.io.ByteBufferChannel r2 = r0.f50671a
            kotlin.ResultKt.b(r7)
            goto L4b
        L3a:
            kotlin.ResultKt.b(r7)
            r0.f50671a = r5
            r0.f50672b = r6
            r0.f50675e = r4
            java.lang.Object r7 = r5.t0(r4, r0)
            if (r7 != r1) goto L4a
            goto L67
        L4a:
            r2 = r5
        L4b:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L5a
            java.lang.Integer r6 = new java.lang.Integer
            r7 = -1
            r6.<init>(r7)
            return r6
        L5a:
            r7 = 0
            r0.f50671a = r7
            r0.f50672b = r7
            r0.f50675e = r3
            java.lang.Object r6 = r2.F(r6, r0)
            if (r6 != r1) goto L68
        L67:
            return r1
        L68:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.l0(java.nio.ByteBuffer, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object m(Function2 function2, Continuation continuation) {
        return g1(this, function2, (ContinuationImpl) continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x007a, code lost:
    
        if (r2.E(r6, r7, r0) == r1) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m0(int r6, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$readBlockSuspend$1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$readBlockSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readBlockSuspend$1) r0
            int r1 = r0.f50686f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50686f = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readBlockSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readBlockSuspend$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f50684d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50686f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.b(r8)
            goto L7d
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            int r6 = r0.f50683c
            kotlin.jvm.functions.Function1 r7 = r0.f50682b
            io.ktor.utils.io.ByteBufferChannel r2 = r0.f50681a
            kotlin.ResultKt.b(r8)
            goto L54
        L3c:
            kotlin.ResultKt.b(r8)
            if (r6 >= r4) goto L43
            r8 = r4
            goto L44
        L43:
            r8 = r6
        L44:
            r0.f50681a = r5
            r0.f50682b = r7
            r0.f50683c = r6
            r0.f50686f = r4
            java.lang.Object r8 = r5.t0(r8, r0)
            if (r8 != r1) goto L53
            goto L7c
        L53:
            r2 = r5
        L54:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L6f
            if (r6 > 0) goto L61
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        L61:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r8 = "Got EOF but at least "
            java.lang.String r0 = " bytes were expected"
            java.lang.String r6 = android.support.v4.media.b.g(r6, r8, r0)
            r7.<init>(r6)
            throw r7
        L6f:
            r8 = 0
            r0.f50681a = r8
            r0.f50682b = r8
            r0.f50686f = r3
            java.lang.Object r6 = r2.E(r6, r7, r0)
            if (r6 != r1) goto L7d
        L7c:
            return r1
        L7d:
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.m0(int, kotlin.jvm.functions.Function1, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object n(long j2, ContinuationImpl continuationImpl) throws Throwable {
        if (!h()) {
            return s0(j2, continuationImpl);
        }
        Throwable thA = a();
        if (thA != null) {
            ByteBufferChannelKt.a(thA);
            throw null;
        }
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(0);
        try {
            ChunkBuffer chunkBufferD = UnsafeKt.d(bytePacketBuilder, 1, null);
            while (true) {
                try {
                    if (chunkBufferD.f51184e - chunkBufferD.f51182c > j2) {
                        chunkBufferD.f((int) j2);
                    }
                    j2 -= i0(this, chunkBufferD, 0, 6);
                    if (j2 <= 0 || K()) {
                        break;
                    }
                    chunkBufferD = UnsafeKt.d(bytePacketBuilder, 1, chunkBufferD);
                } catch (Throwable th) {
                    bytePacketBuilder.a();
                    throw th;
                }
            }
            bytePacketBuilder.a();
            return bytePacketBuilder.V();
        } catch (Throwable th2) {
            bytePacketBuilder.close();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00a0 -> B:40:0x00a3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n0(kotlin.coroutines.jvm.internal.ContinuationImpl r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteBufferChannel$readDouble$1
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.utils.io.ByteBufferChannel$readDouble$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readDouble$1) r0
            int r1 = r0.f50698e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50698e = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readDouble$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readDouble$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.f50696c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50698e
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            int r2 = r0.f50695b
            io.ktor.utils.io.ByteBufferChannel r4 = r0.f50694a
            kotlin.ResultKt.b(r11)
            goto La3
        L2c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L34:
            kotlin.ResultKt.b(r11)
            r11 = 8
            r4 = r10
            r2 = r11
        L3b:
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            java.nio.ByteBuffer r5 = r4.G0()
            r6 = 0
            if (r5 != 0) goto L48
            goto L79
        L48:
            java.lang.Object r7 = r4._state
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = (io.ktor.utils.io.internal.ReadWriteBufferState) r7
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.f51254b
            int r8 = r7._availableForRead$internal     // Catch: java.lang.Throwable -> Lba
            if (r8 != 0) goto L59
        L52:
            r4.B0()
            r4.M0()
            goto L79
        L59:
            boolean r8 = r7.i(r2)     // Catch: java.lang.Throwable -> Lba
            if (r8 != 0) goto L60
            goto L52
        L60:
            int r6 = r5.remaining()     // Catch: java.lang.Throwable -> Lba
            if (r6 >= r2) goto L69
            F0(r2, r5)     // Catch: java.lang.Throwable -> Lba
        L69:
            long r8 = r5.getLong()     // Catch: java.lang.Throwable -> Lba
            java.lang.Long r6 = new java.lang.Long     // Catch: java.lang.Throwable -> Lba
            r6.<init>(r8)     // Catch: java.lang.Throwable -> Lba
            r11.f53801a = r6     // Catch: java.lang.Throwable -> Lba
            r4.S(r5, r7, r2)     // Catch: java.lang.Throwable -> Lba
            r6 = r3
            goto L52
        L79:
            if (r6 == 0) goto L96
            java.lang.Object r11 = r11.f53801a
            if (r11 == 0) goto L8f
            java.lang.Number r11 = (java.lang.Number) r11
            long r0 = r11.longValue()
            double r0 = java.lang.Double.longBitsToDouble(r0)
            java.lang.Double r11 = new java.lang.Double
            r11.<init>(r0)
            return r11
        L8f:
            java.lang.String r11 = "result"
            kotlin.jvm.internal.Intrinsics.h(r11)
            r11 = 0
            throw r11
        L96:
            r0.f50694a = r4
            r0.f50695b = r2
            r0.f50698e = r3
            java.lang.Object r11 = r4.t0(r2, r0)
            if (r11 != r1) goto La3
            return r1
        La3:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto Lac
            goto L3b
        Lac:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r11 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.String r0 = "EOF while "
            java.lang.String r1 = " bytes expected"
            java.lang.String r0 = android.support.v4.media.b.g(r2, r0, r1)
            r11.<init>(r0)
            throw r11
        Lba:
            r11 = move-exception
            r4.B0()
            r4.M0()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.n0(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0093 -> B:40:0x0096). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(kotlin.coroutines.jvm.internal.ContinuationImpl r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteBufferChannel$readLong$1
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.utils.io.ByteBufferChannel$readLong$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readLong$1) r0
            int r1 = r0.f50729e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50729e = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readLong$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readLong$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.f50727c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50729e
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            int r2 = r0.f50726b
            io.ktor.utils.io.ByteBufferChannel r4 = r0.f50725a
            kotlin.ResultKt.b(r11)
            goto L96
        L2c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L34:
            kotlin.ResultKt.b(r11)
            r11 = 8
            r4 = r10
            r2 = r11
        L3b:
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            java.nio.ByteBuffer r5 = r4.G0()
            r6 = 0
            if (r5 != 0) goto L48
            goto L79
        L48:
            java.lang.Object r7 = r4._state
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = (io.ktor.utils.io.internal.ReadWriteBufferState) r7
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.f51254b
            int r8 = r7._availableForRead$internal     // Catch: java.lang.Throwable -> Lad
            if (r8 != 0) goto L59
        L52:
            r4.B0()
            r4.M0()
            goto L79
        L59:
            boolean r8 = r7.i(r2)     // Catch: java.lang.Throwable -> Lad
            if (r8 != 0) goto L60
            goto L52
        L60:
            int r6 = r5.remaining()     // Catch: java.lang.Throwable -> Lad
            if (r6 >= r2) goto L69
            F0(r2, r5)     // Catch: java.lang.Throwable -> Lad
        L69:
            long r8 = r5.getLong()     // Catch: java.lang.Throwable -> Lad
            java.lang.Long r6 = new java.lang.Long     // Catch: java.lang.Throwable -> Lad
            r6.<init>(r8)     // Catch: java.lang.Throwable -> Lad
            r11.f53801a = r6     // Catch: java.lang.Throwable -> Lad
            r4.S(r5, r7, r2)     // Catch: java.lang.Throwable -> Lad
            r6 = r3
            goto L52
        L79:
            if (r6 == 0) goto L89
            java.lang.Object r11 = r11.f53801a
            if (r11 == 0) goto L82
            java.lang.Number r11 = (java.lang.Number) r11
            return r11
        L82:
            java.lang.String r11 = "result"
            kotlin.jvm.internal.Intrinsics.h(r11)
            r11 = 0
            throw r11
        L89:
            r0.f50725a = r4
            r0.f50726b = r2
            r0.f50729e = r3
            java.lang.Object r11 = r4.t0(r2, r0)
            if (r11 != r1) goto L96
            return r1
        L96:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L9f
            goto L3b
        L9f:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r11 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.String r0 = "EOF while "
            java.lang.String r1 = " bytes expected"
            java.lang.String r0 = android.support.v4.media.b.g(r2, r0, r1)
            r11.<init>(r0)
            throw r11
        Lad:
            r11 = move-exception
            r4.B0()
            r4.M0()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.o(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x009f -> B:40:0x00a2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o0(kotlin.coroutines.jvm.internal.ContinuationImpl r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$readFloat$1
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readFloat$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readFloat$1) r0
            int r1 = r0.f50703e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50703e = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readFloat$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readFloat$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f50701c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50703e
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            int r2 = r0.f50700b
            io.ktor.utils.io.ByteBufferChannel r4 = r0.f50699a
            kotlin.ResultKt.b(r10)
            goto La2
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L34:
            kotlin.ResultKt.b(r10)
            r10 = 4
            r4 = r9
            r2 = r10
        L3a:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            java.nio.ByteBuffer r5 = r4.G0()
            r6 = 0
            if (r5 != 0) goto L47
            goto L78
        L47:
            java.lang.Object r7 = r4._state
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = (io.ktor.utils.io.internal.ReadWriteBufferState) r7
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.f51254b
            int r8 = r7._availableForRead$internal     // Catch: java.lang.Throwable -> Lb9
            if (r8 != 0) goto L58
        L51:
            r4.B0()
            r4.M0()
            goto L78
        L58:
            boolean r8 = r7.i(r2)     // Catch: java.lang.Throwable -> Lb9
            if (r8 != 0) goto L5f
            goto L51
        L5f:
            int r6 = r5.remaining()     // Catch: java.lang.Throwable -> Lb9
            if (r6 >= r2) goto L68
            F0(r2, r5)     // Catch: java.lang.Throwable -> Lb9
        L68:
            int r6 = r5.getInt()     // Catch: java.lang.Throwable -> Lb9
            java.lang.Integer r8 = new java.lang.Integer     // Catch: java.lang.Throwable -> Lb9
            r8.<init>(r6)     // Catch: java.lang.Throwable -> Lb9
            r10.f53801a = r8     // Catch: java.lang.Throwable -> Lb9
            r4.S(r5, r7, r2)     // Catch: java.lang.Throwable -> Lb9
            r6 = r3
            goto L51
        L78:
            if (r6 == 0) goto L95
            java.lang.Object r10 = r10.f53801a
            if (r10 == 0) goto L8e
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            float r10 = java.lang.Float.intBitsToFloat(r10)
            java.lang.Float r0 = new java.lang.Float
            r0.<init>(r10)
            return r0
        L8e:
            java.lang.String r10 = "result"
            kotlin.jvm.internal.Intrinsics.h(r10)
            r10 = 0
            throw r10
        L95:
            r0.f50699a = r4
            r0.f50700b = r2
            r0.f50703e = r3
            java.lang.Object r10 = r4.t0(r2, r0)
            if (r10 != r1) goto La2
            return r1
        La2:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto Lab
            goto L3a
        Lab:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r10 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.String r0 = "EOF while "
            java.lang.String r1 = " bytes expected"
            java.lang.String r0 = android.support.v4.media.b.g(r2, r0, r1)
            r10.<init>(r0)
            throw r10
        Lb9:
            r10 = move-exception
            r4.B0()
            r4.M0()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.o0(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object p(long j2, ContinuationImpl continuationImpl) {
        return a1(this, j2, continuationImpl);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004e -> B:21:0x0051). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p0(java.nio.ByteBuffer r6, int r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$readFullySuspend$1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readFullySuspend$1) r0
            int r1 = r0.f50709f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50709f = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readFullySuspend$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f50707d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50709f
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            int r6 = r0.f50706c
            java.nio.ByteBuffer r7 = r0.f50705b
            io.ktor.utils.io.ByteBufferChannel r2 = r0.f50704a
            kotlin.ResultKt.b(r8)
            goto L51
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.ResultKt.b(r8)
            r2 = r5
        L39:
            boolean r8 = r6.hasRemaining()
            if (r8 == 0) goto L7f
            r0.f50704a = r2
            r0.f50705b = r6
            r0.f50706c = r7
            r0.f50709f = r3
            java.lang.Object r8 = r2.t0(r3, r0)
            if (r8 != r1) goto L4e
            return r1
        L4e:
            r4 = r7
            r7 = r6
            r6 = r4
        L51:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L62
            int r8 = r2.h0(r7)
            int r6 = r6 + r8
            r4 = r7
            r7 = r6
            r6 = r4
            goto L39
        L62:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r6 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "Unexpected EOF: expected "
            r8.<init>(r0)
            int r7 = r7.remaining()
            r8.append(r7)
            java.lang.String r7 = " more bytes"
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r6.<init>(r7)
            throw r6
        L7f:
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.p0(java.nio.ByteBuffer, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0092 -> B:40:0x0095). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(kotlin.coroutines.jvm.internal.ContinuationImpl r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$readInt$1
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readInt$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readInt$1) r0
            int r1 = r0.f50724e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50724e = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readInt$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readInt$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f50722c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50724e
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            int r2 = r0.f50721b
            io.ktor.utils.io.ByteBufferChannel r4 = r0.f50720a
            kotlin.ResultKt.b(r10)
            goto L95
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L34:
            kotlin.ResultKt.b(r10)
            r10 = 4
            r4 = r9
            r2 = r10
        L3a:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            java.nio.ByteBuffer r5 = r4.G0()
            r6 = 0
            if (r5 != 0) goto L47
            goto L78
        L47:
            java.lang.Object r7 = r4._state
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = (io.ktor.utils.io.internal.ReadWriteBufferState) r7
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.f51254b
            int r8 = r7._availableForRead$internal     // Catch: java.lang.Throwable -> Lac
            if (r8 != 0) goto L58
        L51:
            r4.B0()
            r4.M0()
            goto L78
        L58:
            boolean r8 = r7.i(r2)     // Catch: java.lang.Throwable -> Lac
            if (r8 != 0) goto L5f
            goto L51
        L5f:
            int r6 = r5.remaining()     // Catch: java.lang.Throwable -> Lac
            if (r6 >= r2) goto L68
            F0(r2, r5)     // Catch: java.lang.Throwable -> Lac
        L68:
            int r6 = r5.getInt()     // Catch: java.lang.Throwable -> Lac
            java.lang.Integer r8 = new java.lang.Integer     // Catch: java.lang.Throwable -> Lac
            r8.<init>(r6)     // Catch: java.lang.Throwable -> Lac
            r10.f53801a = r8     // Catch: java.lang.Throwable -> Lac
            r4.S(r5, r7, r2)     // Catch: java.lang.Throwable -> Lac
            r6 = r3
            goto L51
        L78:
            if (r6 == 0) goto L88
            java.lang.Object r10 = r10.f53801a
            if (r10 == 0) goto L81
            java.lang.Number r10 = (java.lang.Number) r10
            return r10
        L81:
            java.lang.String r10 = "result"
            kotlin.jvm.internal.Intrinsics.h(r10)
            r10 = 0
            throw r10
        L88:
            r0.f50720a = r4
            r0.f50721b = r2
            r0.f50724e = r3
            java.lang.Object r10 = r4.t0(r2, r0)
            if (r10 != r1) goto L95
            return r1
        L95:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L9e
            goto L3a
        L9e:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r10 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.String r0 = "EOF while "
            java.lang.String r1 = " bytes expected"
            java.lang.String r0 = android.support.v4.media.b.g(r2, r0, r1)
            r10.<init>(r0)
            throw r10
        Lac:
            r10 = move-exception
            r4.B0()
            r4.M0()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.q(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0050 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0051 -> B:19:0x0058). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q0(byte[] r7, int r8, int r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$readFullySuspend$3
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$3 r0 = (io.ktor.utils.io.ByteBufferChannel$readFullySuspend$3) r0
            int r1 = r0.f50719h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50719h = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$readFullySuspend$3
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.f50717f
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50719h
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            int r7 = r0.f50716e
            int r8 = r0.f50715d
            int r9 = r0.f50714c
            byte[] r2 = r0.f50713b
            io.ktor.utils.io.ByteBufferChannel r4 = r0.f50712a
            kotlin.ResultKt.b(r10)
            goto L58
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            kotlin.ResultKt.b(r10)
            r10 = 0
            r4 = r6
        L3e:
            r0.f50712a = r4
            r0.f50713b = r7
            r0.f50714c = r8
            r0.f50715d = r9
            r0.f50716e = r10
            r0.f50719h = r3
            java.lang.Object r2 = r4.t0(r3, r0)
            if (r2 != r1) goto L51
            return r1
        L51:
            r5 = r2
            r2 = r7
            r7 = r10
            r10 = r5
            r5 = r9
            r9 = r8
            r8 = r5
        L58:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L70
            int r9 = r9 + r7
            int r7 = r8 - r7
            int r10 = r4.g0(r9, r2, r7)
            if (r10 < r7) goto L6c
            kotlin.Unit r7 = kotlin.Unit.f53572a
            return r7
        L6c:
            r8 = r9
            r9 = r7
            r7 = r2
            goto L3e
        L70:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r7 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.String r9 = "Unexpected EOF: expected "
            java.lang.String r10 = " more bytes"
            java.lang.String r8 = android.support.v4.media.b.g(r8, r9, r10)
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.q0(byte[], int, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object r(ByteBuffer byteBuffer, ContinuationImpl continuationImpl) throws Throwable {
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            A0(this, joiningState);
        }
        S0(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return Unit.f53572a;
        }
        Object objY0 = Y0(byteBuffer, continuationImpl);
        return objY0 == CoroutineSingletons.f53689a ? objY0 : Unit.f53572a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0076, code lost:
    
        if (r10 == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042 A[Catch: all -> 0x004f, TRY_ENTER, TryCatch #2 {all -> 0x004f, blocks: (B:31:0x0076, B:20:0x0042, B:22:0x004b, B:25:0x0054, B:27:0x0068, B:28:0x006f, B:32:0x0084), top: B:44:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084 A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:31:0x0076, B:20:0x0042, B:22:0x004b, B:25:0x0054, B:27:0x0068, B:28:0x006f, B:32:0x0084), top: B:44:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r0(int r7, io.ktor.utils.io.core.BytePacketBuilder r8, java.nio.ByteBuffer r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$readPacketSuspend$1
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readPacketSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readPacketSuspend$1) r0
            int r1 = r0.f50736g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50736g = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readPacketSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readPacketSuspend$1
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.f50734e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50736g
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            int r7 = r0.f50733d
            java.nio.ByteBuffer r8 = r0.f50732c
            io.ktor.utils.io.core.BytePacketBuilder r9 = r0.f50731b
            io.ktor.utils.io.ByteBufferChannel r2 = r0.f50730a
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L32
            r5 = r9
            r9 = r8
            r8 = r5
            goto L76
        L32:
            r7 = move-exception
            goto L8e
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            kotlin.ResultKt.b(r10)
            r2 = r6
        L40:
            if (r7 <= 0) goto L84
            r9.clear()     // Catch: java.lang.Throwable -> L4f
            int r10 = r9.remaining()     // Catch: java.lang.Throwable -> L4f
            if (r10 <= r7) goto L54
            r9.limit(r7)     // Catch: java.lang.Throwable -> L4f
            goto L54
        L4f:
            r7 = move-exception
            r5 = r9
            r9 = r8
            r8 = r5
            goto L8e
        L54:
            r0.f50730a = r2     // Catch: java.lang.Throwable -> L4f
            r0.f50731b = r8     // Catch: java.lang.Throwable -> L4f
            r0.f50732c = r9     // Catch: java.lang.Throwable -> L4f
            r0.f50733d = r7     // Catch: java.lang.Throwable -> L4f
            r0.f50736g = r3     // Catch: java.lang.Throwable -> L4f
            int r10 = r2.h0(r9)     // Catch: java.lang.Throwable -> L4f
            boolean r4 = r9.hasRemaining()     // Catch: java.lang.Throwable -> L4f
            if (r4 != 0) goto L6f
            java.lang.Integer r4 = new java.lang.Integer     // Catch: java.lang.Throwable -> L4f
            r4.<init>(r10)     // Catch: java.lang.Throwable -> L4f
            r10 = r4
            goto L73
        L6f:
            java.lang.Object r10 = r2.p0(r9, r10, r0)     // Catch: java.lang.Throwable -> L4f
        L73:
            if (r10 != r1) goto L76
            return r1
        L76:
            java.lang.Number r10 = (java.lang.Number) r10     // Catch: java.lang.Throwable -> L4f
            int r10 = r10.intValue()     // Catch: java.lang.Throwable -> L4f
            r9.flip()     // Catch: java.lang.Throwable -> L4f
            io.ktor.utils.io.core.OutputArraysJVMKt.a(r8, r9)     // Catch: java.lang.Throwable -> L4f
            int r7 = r7 - r10
            goto L40
        L84:
            io.ktor.utils.io.core.ByteReadPacket r7 = r8.V()     // Catch: java.lang.Throwable -> L4f
            io.ktor.utils.io.pool.DirectByteBufferPool r8 = io.ktor.utils.io.internal.ObjectPoolKt.f51247b
            r8.G1(r9)
            return r7
        L8e:
            r9.close()     // Catch: java.lang.Throwable -> L92
            throw r7     // Catch: java.lang.Throwable -> L92
        L92:
            r7 = move-exception
            io.ktor.utils.io.pool.DirectByteBufferPool r9 = io.ktor.utils.io.internal.ObjectPoolKt.f51247b
            r9.G1(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.r0(int, io.ktor.utils.io.core.BytePacketBuilder, java.nio.ByteBuffer, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object s(Buffer buffer, ContinuationImpl continuationImpl) throws Throwable {
        R0(buffer);
        if (buffer.f51182c <= buffer.f51181b) {
            return Unit.f53572a;
        }
        Object objW0 = W0(buffer, continuationImpl);
        return objW0 == CoroutineSingletons.f53689a ? objW0 : Unit.f53572a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0060 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:12:0x002e, B:31:0x008e, B:36:0x009b, B:21:0x0054, B:23:0x0060, B:24:0x0064, B:26:0x0075, B:28:0x007b), top: B:50:0x002e, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:12:0x002e, B:31:0x008e, B:36:0x009b, B:21:0x0054, B:23:0x0060, B:24:0x0064, B:26:0x0075, B:28:0x007b), top: B:50:0x002e, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009b A[Catch: all -> 0x0032, TRY_LEAVE, TryCatch #0 {all -> 0x0032, blocks: (B:12:0x002e, B:31:0x008e, B:36:0x009b, B:21:0x0054, B:23:0x0060, B:24:0x0064, B:26:0x0075, B:28:0x007b), top: B:50:0x002e, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a0 A[Catch: all -> 0x00ae, TRY_ENTER, TryCatch #2 {all -> 0x00ae, blocks: (B:38:0x00a0, B:40:0x00a9, B:44:0x00b1, B:45:0x00b2, B:46:0x00b5, B:12:0x002e, B:31:0x008e, B:36:0x009b, B:21:0x0054, B:23:0x0060, B:24:0x0064, B:26:0x0075, B:28:0x007b), top: B:50:0x002e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008b -> B:31:0x008e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0098 -> B:35:0x0099). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s0(long r12, kotlin.coroutines.jvm.internal.ContinuationImpl r14) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r14 instanceof io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1
            if (r0 == 0) goto L13
            r0 = r14
            io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1) r0
            int r1 = r0.f50744h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50744h = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1
            r0.<init>(r11, r14)
        L18:
            java.lang.Object r14 = r0.f50742f
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50744h
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 != r4) goto L35
            io.ktor.utils.io.core.internal.ChunkBuffer r12 = r0.f50741e
            io.ktor.utils.io.core.Output r13 = r0.f50740d
            kotlin.jvm.internal.Ref$LongRef r2 = r0.f50739c
            io.ktor.utils.io.core.BytePacketBuilder r5 = r0.f50738b
            io.ktor.utils.io.ByteBufferChannel r6 = r0.f50737a
            kotlin.ResultKt.b(r14)     // Catch: java.lang.Throwable -> L32
            goto L8e
        L32:
            r12 = move-exception
            goto Lb2
        L35:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3d:
            kotlin.ResultKt.b(r14)
            io.ktor.utils.io.core.BytePacketBuilder r14 = new io.ktor.utils.io.core.BytePacketBuilder
            r14.<init>(r3)
            kotlin.jvm.internal.Ref$LongRef r2 = new kotlin.jvm.internal.Ref$LongRef     // Catch: java.lang.Throwable -> Lb6
            r2.<init>()     // Catch: java.lang.Throwable -> Lb6
            r2.f53800a = r12     // Catch: java.lang.Throwable -> Lb6
            r12 = 0
            io.ktor.utils.io.core.internal.ChunkBuffer r12 = io.ktor.utils.io.core.internal.UnsafeKt.d(r14, r4, r12)     // Catch: java.lang.Throwable -> Lb6
            r6 = r11
            r13 = r14
            r5 = r13
        L54:
            int r14 = r12.f51184e     // Catch: java.lang.Throwable -> L32
            int r7 = r12.f51182c     // Catch: java.lang.Throwable -> L32
            int r14 = r14 - r7
            long r7 = (long) r14     // Catch: java.lang.Throwable -> L32
            long r9 = r2.f53800a     // Catch: java.lang.Throwable -> L32
            int r14 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r14 <= 0) goto L64
            int r14 = (int) r9     // Catch: java.lang.Throwable -> L32
            r12.f(r14)     // Catch: java.lang.Throwable -> L32
        L64:
            r14 = 6
            int r14 = i0(r6, r12, r3, r14)     // Catch: java.lang.Throwable -> L32
            long r7 = r2.f53800a     // Catch: java.lang.Throwable -> L32
            long r9 = (long) r14     // Catch: java.lang.Throwable -> L32
            long r7 = r7 - r9
            r2.f53800a = r7     // Catch: java.lang.Throwable -> L32
            r9 = 0
            int r14 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r14 <= 0) goto L98
            boolean r14 = r6.K()     // Catch: java.lang.Throwable -> L32
            if (r14 != 0) goto L98
            r0.f50737a = r6     // Catch: java.lang.Throwable -> L32
            r0.f50738b = r5     // Catch: java.lang.Throwable -> L32
            r0.f50739c = r2     // Catch: java.lang.Throwable -> L32
            r0.f50740d = r13     // Catch: java.lang.Throwable -> L32
            r0.f50741e = r12     // Catch: java.lang.Throwable -> L32
            r0.f50744h = r4     // Catch: java.lang.Throwable -> L32
            java.lang.Object r14 = r6.t0(r4, r0)     // Catch: java.lang.Throwable -> L32
            if (r14 != r1) goto L8e
            return r1
        L8e:
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch: java.lang.Throwable -> L32
            boolean r14 = r14.booleanValue()     // Catch: java.lang.Throwable -> L32
            if (r14 == 0) goto L98
            r14 = r4
            goto L99
        L98:
            r14 = r3
        L99:
            if (r14 == 0) goto La0
            io.ktor.utils.io.core.internal.ChunkBuffer r12 = io.ktor.utils.io.core.internal.UnsafeKt.d(r13, r4, r12)     // Catch: java.lang.Throwable -> L32
            goto L54
        La0:
            r13.a()     // Catch: java.lang.Throwable -> Lae
            java.lang.Throwable r12 = r6.a()     // Catch: java.lang.Throwable -> Lae
            if (r12 != 0) goto Lb1
            io.ktor.utils.io.core.ByteReadPacket r12 = r5.V()     // Catch: java.lang.Throwable -> Lae
            return r12
        Lae:
            r12 = move-exception
            r14 = r5
            goto Lb7
        Lb1:
            throw r12     // Catch: java.lang.Throwable -> Lae
        Lb2:
            r13.a()     // Catch: java.lang.Throwable -> Lae
            throw r12     // Catch: java.lang.Throwable -> Lae
        Lb6:
            r12 = move-exception
        Lb7:
            r14.close()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.s0(long, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object t(int i2, ContinuationImpl continuationImpl) throws Throwable {
        Throwable th;
        ClosedElement closedElement = (ClosedElement) this._closed;
        if (closedElement != null && (th = closedElement.f51244a) != null) {
            ByteBufferChannelKt.a(th);
            throw null;
        }
        if (i2 == 0) {
            return ByteReadPacket.f51189h;
        }
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(0);
        ByteBuffer byteBuffer = (ByteBuffer) ObjectPoolKt.f51247b.S0();
        while (i2 > 0) {
            try {
                byteBuffer.clear();
                if (byteBuffer.remaining() > i2) {
                    byteBuffer.limit(i2);
                }
                int iH0 = h0(byteBuffer);
                if (iH0 == 0) {
                    break;
                }
                byteBuffer.flip();
                OutputArraysJVMKt.a(bytePacketBuilder, byteBuffer);
                i2 -= iH0;
            } catch (Throwable th2) {
                ObjectPoolKt.f51247b.G1(byteBuffer);
                bytePacketBuilder.close();
                throw th2;
            }
        }
        if (i2 != 0) {
            return r0(i2, bytePacketBuilder, byteBuffer, continuationImpl);
        }
        ObjectPoolKt.f51247b.G1(byteBuffer);
        return bytePacketBuilder.V();
    }

    public final Object t0(int i2, ContinuationImpl continuationImpl) throws Throwable {
        if (((ReadWriteBufferState) this._state).f51254b._availableForRead$internal >= i2) {
            return Boolean.TRUE;
        }
        ClosedElement closedElement = (ClosedElement) this._closed;
        if (closedElement == null) {
            return i2 == 1 ? u0(1, continuationImpl) : v0(i2, continuationImpl);
        }
        Throwable th = closedElement.f51244a;
        if (th != null) {
            ByteBufferChannelKt.a(th);
            throw null;
        }
        RingBufferCapacity ringBufferCapacity = ((ReadWriteBufferState) this._state).f51254b;
        boolean z = ringBufferCapacity.c() && ringBufferCapacity._availableForRead$internal >= i2;
        if (((Continuation) this._readOp) == null) {
            return Boolean.valueOf(z);
        }
        throw new IllegalStateException("Read operation is already in progress");
    }

    public final String toString() {
        return "ByteBufferChannel(" + hashCode() + ", " + ((ReadWriteBufferState) this._state) + ')';
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object u(ByteReadPacket byteReadPacket, ContinuationImpl continuationImpl) {
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            A0(this, joiningState);
        }
        while (!byteReadPacket.x() && N0(byteReadPacket) != 0) {
            try {
            } catch (Throwable th) {
                byteReadPacket.release();
                throw th;
            }
        }
        if (byteReadPacket.D() <= 0) {
            return Unit.f53572a;
        }
        JoiningState joiningState2 = this.joining;
        if (joiningState2 != null) {
            A0(this, joiningState2);
        }
        Object objB1 = b1(byteReadPacket, continuationImpl);
        return objB1 == CoroutineSingletons.f53689a ? objB1 : Unit.f53572a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u0(int r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1) r0
            int r1 = r0.f50753d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50753d = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f50751b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50753d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            io.ktor.utils.io.ByteBufferChannel r5 = r0.f50750a
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L29
            return r6
        L29:
            r6 = move-exception
            goto L77
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r6)
            java.lang.Object r6 = r4._state
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = (io.ktor.utils.io.internal.ReadWriteBufferState) r6
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r6.f51254b
            int r2 = r2._availableForRead$internal
            if (r2 >= r5) goto L7b
            io.ktor.utils.io.internal.JoiningState r2 = r4.joining
            if (r2 == 0) goto L52
            java.lang.Object r2 = r4._writeOp
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            if (r2 == 0) goto L52
            io.ktor.utils.io.internal.ReadWriteBufferState$IdleEmpty r2 = io.ktor.utils.io.internal.ReadWriteBufferState.IdleEmpty.f51255c
            if (r6 == r2) goto L7b
            boolean r6 = r6 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.IdleNonEmpty
            if (r6 != 0) goto L7b
        L52:
            r0.f50750a = r4     // Catch: java.lang.Throwable -> L75
            r0.f50753d = r3     // Catch: java.lang.Throwable -> L75
            io.ktor.utils.io.internal.CancellableReusableContinuation r6 = r4.f50614i     // Catch: java.lang.Throwable -> L75
            r4.J0(r5, r6)     // Catch: java.lang.Throwable -> L75
            kotlin.coroutines.Continuation r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r0)     // Catch: java.lang.Throwable -> L75
            java.lang.Object r5 = r6.d(r5)     // Catch: java.lang.Throwable -> L75
            if (r5 != r1) goto L71
            java.lang.String r6 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r6)     // Catch: java.lang.Throwable -> L6d
            goto L71
        L6b:
            r6 = r5
            goto L6f
        L6d:
            r5 = move-exception
            goto L6b
        L6f:
            r5 = r4
            goto L77
        L71:
            if (r5 != r1) goto L74
            return r1
        L74:
            return r5
        L75:
            r6 = move-exception
            goto L6f
        L77:
            r0 = 0
            r5._readOp = r0
            throw r6
        L7b:
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.u0(int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object v(byte[] bArr, int i2, ContinuationImpl continuationImpl) throws Throwable {
        int iG0 = g0(0, bArr, i2);
        if (iG0 >= i2) {
            return Unit.f53572a;
        }
        Object objQ0 = q0(bArr, iG0, i2 - iG0, continuationImpl);
        return objQ0 == CoroutineSingletons.f53689a ? objQ0 : Unit.f53572a;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0082 -> B:40:0x0085). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v0(int r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1) r0
            int r1 = r0.f50758e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50758e = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f50756c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50758e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            int r5 = r0.f50755b
            io.ktor.utils.io.ByteBufferChannel r2 = r0.f50754a
            kotlin.ResultKt.b(r6)
            goto L85
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r6)
            r2 = r4
        L37:
            java.lang.Object r6 = r2._state
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = (io.ktor.utils.io.internal.ReadWriteBufferState) r6
            io.ktor.utils.io.internal.RingBufferCapacity r6 = r6.f51254b
            int r6 = r6._availableForRead$internal
            if (r6 < r5) goto L44
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            return r5
        L44:
            java.lang.Object r6 = r2._closed
            io.ktor.utils.io.internal.ClosedElement r6 = (io.ktor.utils.io.internal.ClosedElement) r6
            if (r6 == 0) goto L78
            java.lang.Throwable r6 = r6.f51244a
            if (r6 != 0) goto L73
            java.lang.Object r6 = r2._state
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = (io.ktor.utils.io.internal.ReadWriteBufferState) r6
            io.ktor.utils.io.internal.RingBufferCapacity r6 = r6.f51254b
            boolean r0 = r6.c()
            if (r0 == 0) goto L5f
            int r6 = r6._availableForRead$internal
            if (r6 < r5) goto L5f
            goto L60
        L5f:
            r3 = 0
        L60:
            java.lang.Object r5 = r2._readOp
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            if (r5 != 0) goto L6b
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            return r5
        L6b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Read operation is already in progress"
            r5.<init>(r6)
            throw r5
        L73:
            io.ktor.utils.io.ByteBufferChannelKt.a(r6)
            r5 = 0
            throw r5
        L78:
            r0.f50754a = r2
            r0.f50755b = r5
            r0.f50758e = r3
            java.lang.Object r6 = r2.u0(r5, r0)
            if (r6 != r1) goto L85
            return r1
        L85:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L37
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.v0(int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object w(Continuation continuation) {
        return w0(this, Api.BaseClientBuilder.API_PRIORITY_OTHER, (ContinuationImpl) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0091 -> B:40:0x0094). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$readByte$1
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readByte$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readByte$1) r0
            int r1 = r0.f50693e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50693e = r1
            goto L1a
        L13:
            io.ktor.utils.io.ByteBufferChannel$readByte$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readByte$1
            kotlin.coroutines.jvm.internal.ContinuationImpl r10 = (kotlin.coroutines.jvm.internal.ContinuationImpl) r10
            r0.<init>(r9, r10)
        L1a:
            java.lang.Object r10 = r0.f50691c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50693e
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            int r2 = r0.f50690b
            io.ktor.utils.io.ByteBufferChannel r4 = r0.f50689a
            kotlin.ResultKt.b(r10)
            goto L94
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L35:
            kotlin.ResultKt.b(r10)
            r4 = r9
            r2 = r3
        L3a:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            java.nio.ByteBuffer r5 = r4.G0()
            r6 = 0
            if (r5 != 0) goto L47
            goto L77
        L47:
            java.lang.Object r7 = r4._state
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = (io.ktor.utils.io.internal.ReadWriteBufferState) r7
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.f51254b
            int r8 = r7._availableForRead$internal     // Catch: java.lang.Throwable -> Lab
            if (r8 != 0) goto L58
        L51:
            r4.B0()
            r4.M0()
            goto L77
        L58:
            boolean r8 = r7.i(r2)     // Catch: java.lang.Throwable -> Lab
            if (r8 != 0) goto L5f
            goto L51
        L5f:
            int r6 = r5.remaining()     // Catch: java.lang.Throwable -> Lab
            if (r6 >= r2) goto L68
            F0(r2, r5)     // Catch: java.lang.Throwable -> Lab
        L68:
            byte r6 = r5.get()     // Catch: java.lang.Throwable -> Lab
            java.lang.Byte r6 = java.lang.Byte.valueOf(r6)     // Catch: java.lang.Throwable -> Lab
            r10.f53801a = r6     // Catch: java.lang.Throwable -> Lab
            r4.S(r5, r7, r2)     // Catch: java.lang.Throwable -> Lab
            r6 = r3
            goto L51
        L77:
            if (r6 == 0) goto L87
            java.lang.Object r10 = r10.f53801a
            if (r10 == 0) goto L80
            java.lang.Number r10 = (java.lang.Number) r10
            return r10
        L80:
            java.lang.String r10 = "result"
            kotlin.jvm.internal.Intrinsics.h(r10)
            r10 = 0
            throw r10
        L87:
            r0.f50689a = r4
            r0.f50690b = r2
            r0.f50693e = r3
            java.lang.Object r10 = r4.t0(r2, r0)
            if (r10 != r1) goto L94
            return r1
        L94:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L9d
            goto L3a
        L9d:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r10 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.String r0 = "EOF while "
            java.lang.String r1 = " bytes expected"
            java.lang.String r0 = android.support.v4.media.b.g(r2, r0, r1)
            r10.<init>(r0)
            throw r10
        Lab:
            r10 = move-exception
            r4.B0()
            r4.M0()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.x(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:(1:82)|35|36|80|37|38|88|39|(9:42|20|43|23|(7:25|34|49|(0)|52|(1:54)|63)(0)|64|(0)(0)|74|75)) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:82|35|36|80|37|38|88|39|(9:42|20|43|23|(7:25|34|49|(0)|52|(1:54)|63)(0)|64|(0)(0)|74|75)) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0116, code lost:
    
        r20 = r9;
        r21 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x011a, code lost:
    
        r9 = r18;
        r8 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x011e, code lost:
    
        r0 = r16;
        r12 = r17;
        r8 = r18;
        r7 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0165, code lost:
    
        if (r1.E(1, r5, r4) == r3) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0070, code lost:
    
        r9 = r8;
        r8 = r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.lang.Appendable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x010c -> B:20:0x0070). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x0(java.lang.StringBuilder r23, int r24, kotlin.coroutines.jvm.internal.ContinuationImpl r25) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.x0(java.lang.StringBuilder, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.utils.io.HasWriteSession
    public final WriterSuspendSession y() {
        WriteSessionImpl writeSessionImpl = this.f50613h;
        writeSessionImpl.d();
        return writeSessionImpl;
    }

    public final void y0(ReadWriteBufferState.Initial initial) {
        this.f50608c.G1(initial);
    }

    @Override // io.ktor.utils.io.HasWriteSession
    public final void z(int i2) {
        WriteSessionImpl writeSessionImpl = this.f50613h;
        writeSessionImpl.a(i2);
        writeSessionImpl.e();
    }

    public final void z0() {
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            A0(this, joiningState);
        }
    }

    public ByteBufferChannel(boolean z, ObjectPool pool, int i2) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.f50607b = z;
        this.f50608c = pool;
        this.f50609d = i2;
        this._state = ReadWriteBufferState.IdleEmpty.f51255c;
        this._closed = null;
        this._readOp = null;
        this._writeOp = null;
        this.f50612g = new ReadSessionImpl(this);
        Intrinsics.checkNotNullParameter(this, "channel");
        WriteSessionImpl writeSessionImpl = new WriteSessionImpl();
        z0();
        writeSessionImpl.f51288b = this;
        ChunkBuffer chunkBuffer = ChunkBuffer.f51216l;
        writeSessionImpl.f51289c = chunkBuffer.f51180a;
        writeSessionImpl.f51290d = chunkBuffer;
        writeSessionImpl.f51291e = ((ReadWriteBufferState) this._state).f51254b;
        this.f50613h = writeSessionImpl;
        this.f50614i = new CancellableReusableContinuation();
        this.f50615j = new CancellableReusableContinuation();
        this.f50616k = new ByteBufferChannel$writeSuspension$1(this);
    }
}

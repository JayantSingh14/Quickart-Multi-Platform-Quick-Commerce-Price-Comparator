package io.ktor.utils.io;

import android.support.v4.media.a;
import android.support.v4.media.b;
import com.google.android.gms.common.api.Api;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.InsufficientSpaceException;
import io.ktor.utils.io.core.OutputKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.io.EOFException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class ByteChannelSequentialBase implements ByteChannel, ByteReadChannel, ByteWriteChannel, SuspendableReadSession, HasReadSession, HasWriteSession {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f50886b = AtomicLongFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_totalBytesRead");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f50887c = AtomicLongFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_totalBytesWritten");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f50888d = AtomicIntegerFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_availableForRead");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f50889e = AtomicIntegerFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "channelSize");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f50890f = AtomicReferenceFieldUpdater.newUpdater(ByteChannelSequentialBase.class, Object.class, "_closed");

    @NotNull
    private volatile /* synthetic */ int _availableForRead;

    @NotNull
    private volatile /* synthetic */ Object _closed;

    @NotNull
    private volatile /* synthetic */ Object _lastReadView;

    @NotNull
    private volatile /* synthetic */ long _totalBytesRead;

    @NotNull
    private volatile /* synthetic */ long _totalBytesWritten;

    @NotNull
    private volatile /* synthetic */ int channelSize;

    @NotNull
    private volatile /* synthetic */ int lastReadAvailable$delegate;

    @NotNull
    private volatile /* synthetic */ Object lastReadView$delegate;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object W(io.ktor.utils.io.ByteChannelSequentialBase r2, byte[] r3, int r4, int r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) throws java.lang.Throwable {
        /*
            boolean r3 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4
            if (r3 == 0) goto L13
            r3 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4 r3 = (io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4) r3
            int r4 = r3.f50928d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L13
            int r4 = r4 - r0
            r3.f50928d = r4
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4 r3 = new io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4
            r3.<init>(r2, r6)
        L18:
            java.lang.Object r4 = r3.f50926b
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r0 = r3.f50928d
            r1 = 1
            if (r0 == 0) goto L31
            if (r0 == r1) goto L2b
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
            r2.<init>(r3)
            throw r2
        L2b:
            io.ktor.utils.io.ByteChannelSequentialBase r2 = r3.f50925a
            kotlin.ResultKt.b(r4)
            goto L60
        L31:
            kotlin.ResultKt.b(r4)
            java.lang.Throwable r4 = r2.a()
            if (r4 != 0) goto L65
            boolean r4 = r2.U()
            if (r4 == 0) goto L4b
            int r4 = r2._availableForRead
            if (r4 != 0) goto L4b
            java.lang.Integer r2 = new java.lang.Integer
            r3 = -1
            r2.<init>(r3)
            return r2
        L4b:
            if (r5 != 0) goto L54
            java.lang.Integer r2 = new java.lang.Integer
            r3 = 0
            r2.<init>(r3)
            return r2
        L54:
            int r4 = r2._availableForRead
            if (r4 != 0) goto L60
            r3.f50925a = r2
            r3.f50928d = r1
            r2.Q(r1, r3)
            return r6
        L60:
            r2.getClass()
            r2 = 0
            throw r2
        L65:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.W(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        if (r5.Y(r6, r8, r7 - r8, r0) == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object X(io.ktor.utils.io.ByteChannelSequentialBase r5, byte[] r6, int r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readFully$6
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.ByteChannelSequentialBase$readFully$6 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readFully$6) r0
            int r1 = r0.f50950f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50950f = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$readFully$6 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readFully$6
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f50948d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50950f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.b(r8)
            goto L6f
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            int r7 = r0.f50947c
            byte[] r6 = r0.f50946b
            io.ktor.utils.io.ByteChannelSequentialBase r5 = r0.f50945a
            kotlin.ResultKt.b(r8)
            goto L52
        L3c:
            kotlin.ResultKt.b(r8)
            r0.f50945a = r5
            r0.f50946b = r6
            r0.f50947c = r7
            r0.f50950f = r4
            r5.getClass()
            r8 = 0
            java.lang.Object r8 = W(r5, r6, r8, r7, r0)
            if (r8 != r1) goto L52
            goto L6e
        L52:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            if (r8 != r7) goto L5d
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        L5d:
            r2 = -1
            if (r8 == r2) goto L72
            int r7 = r7 - r8
            r2 = 0
            r0.f50945a = r2
            r0.f50946b = r2
            r0.f50950f = r3
            java.lang.Object r5 = r5.Y(r6, r8, r7, r0)
            if (r5 != r1) goto L6f
        L6e:
            return r1
        L6f:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        L72:
            java.io.EOFException r5 = new java.io.EOFException
            java.lang.String r6 = "Unexpected end of stream"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.X(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v0, types: [io.ktor.utils.io.ByteChannelSequentialBase, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [io.ktor.utils.io.ByteChannelSequentialBase] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, kotlin.Unit] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object Z(io.ktor.utils.io.ByteChannelSequentialBase r4, kotlin.jvm.functions.Function2 r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1) r0
            int r1 = r0.f50984d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50984d = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f50982b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50984d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            io.ktor.utils.io.ByteChannelSequentialBase r4 = r0.f50981a
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L29
            goto L43
        L29:
            r5 = move-exception
            goto L49
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.b(r6)
            r0.f50981a = r4     // Catch: java.lang.Throwable -> L29
            r0.f50984d = r3     // Catch: java.lang.Throwable -> L29
            io.ktor.utils.io.ByteChannelSequentialBase$peekTo$2 r5 = (io.ktor.utils.io.ByteChannelSequentialBase$peekTo$2) r5     // Catch: java.lang.Throwable -> L29
            java.lang.Object r5 = r5.invoke(r4, r0)     // Catch: java.lang.Throwable -> L29
            if (r5 != r1) goto L43
            return r1
        L43:
            r4.S()
            kotlin.Unit r4 = kotlin.Unit.f53572a
            return r4
        L49:
            r4.S()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.Z(io.ktor.utils.io.ByteChannelSequentialBase, kotlin.jvm.functions.Function2, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object a0(final io.ktor.utils.io.ByteChannelSequentialBase r6, int r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1) r0
            int r1 = r0.f50988d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50988d = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f50986b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50988d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            java.lang.StringBuilder r6 = r0.f50985a
            kotlin.ResultKt.b(r8)
            goto L62
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.ResultKt.b(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r0.f50985a = r8
            r0.f50988d = r4
            boolean r2 = r6.K()
            if (r2 == 0) goto L4e
            java.lang.Throwable r6 = r6.a()
            if (r6 != 0) goto L4d
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            goto L5c
        L4d:
            throw r6
        L4e:
            io.ktor.utils.io.ByteChannelSequentialBase$readUTF8LineTo$2 r2 = new io.ktor.utils.io.ByteChannelSequentialBase$readUTF8LineTo$2
            r2.<init>(r6, r3)
            io.ktor.utils.io.ByteChannelSequentialBase$readUTF8LineTo$3 r4 = new io.ktor.utils.io.ByteChannelSequentialBase$readUTF8LineTo$3
            r4.<init>()
            java.lang.Object r6 = io.ktor.utils.io.core.internal.UTF8Kt.a(r8, r7, r2, r4, r0)
        L5c:
            if (r6 != r1) goto L5f
            return r1
        L5f:
            r5 = r8
            r8 = r6
            r6 = r5
        L62:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r7 = r8.booleanValue()
            if (r7 != 0) goto L6b
            return r3
        L6b:
            java.lang.String r6 = r6.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.a0(io.ktor.utils.io.ByteChannelSequentialBase, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c0(io.ktor.utils.io.ByteChannelSequentialBase r3, byte r4, kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            boolean r4 = r5 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1
            if (r4 == 0) goto L13
            r4 = r5
            io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1 r4 = (io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1) r4
            int r0 = r4.f51005d
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r4.f51005d = r0
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1 r4 = new io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1
            r4.<init>(r3, r5)
        L18:
            java.lang.Object r5 = r4.f51003b
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r4.f51005d
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 == r2) goto L2b
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L2b:
            io.ktor.utils.io.ByteChannelSequentialBase r3 = r4.f51002a
            kotlin.ResultKt.b(r5)
            goto L3f
        L31:
            kotlin.ResultKt.b(r5)
            r4.f51002a = r3
            r4.f51005d = r2
            kotlin.Unit r4 = r3.P(r2, r4)
            if (r4 != r0) goto L3f
            return
        L3f:
            r3.getClass()
            r3 = 0
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.c0(io.ktor.utils.io.ByteChannelSequentialBase, byte, kotlin.coroutines.jvm.internal.ContinuationImpl):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object d0(io.ktor.utils.io.ByteChannelSequentialBase r5, byte[] r6, int r7, int r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2) r0
            int r1 = r0.f51021g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51021g = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.f51019e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f51021g
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 == r3) goto L2b
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2b:
            int r5 = r0.f51018d
            int r7 = r0.f51017c
            byte[] r6 = r0.f51016b
            io.ktor.utils.io.ByteChannelSequentialBase r8 = r0.f51015a
            kotlin.ResultKt.b(r9)
            r4 = r8
            r8 = r5
            r5 = r4
            goto L51
        L3a:
            kotlin.ResultKt.b(r9)
            int r8 = r8 + r7
            if (r7 >= r8) goto L5f
            r0.f51015a = r5
            r0.f51016b = r6
            r0.f51017c = r7
            r0.f51018d = r8
            r0.f51021g = r3
            kotlin.Unit r9 = r5.P(r3, r0)
            if (r9 != r1) goto L51
            return r1
        L51:
            int r5 = r5.T()
            int r8 = r8 - r7
            int r5 = java.lang.Math.min(r5, r8)
            r8 = 0
            io.ktor.utils.io.core.OutputKt.b(r8, r6, r7, r5)
            throw r8
        L5f:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.d0(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e0(io.ktor.utils.io.ByteChannelSequentialBase r4, io.ktor.utils.io.core.Buffer r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1) r0
            int r1 = r0.f51014e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51014e = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f51012c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f51014e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            io.ktor.utils.io.core.Buffer r5 = r0.f51011b
            io.ktor.utils.io.ByteChannelSequentialBase r4 = r0.f51010a
            kotlin.ResultKt.b(r6)
            goto L43
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.b(r6)
            r0.f51010a = r4
            r0.f51011b = r5
            r0.f51014e = r3
            kotlin.Unit r6 = r4.P(r3, r0)
            if (r6 != r1) goto L43
            return
        L43:
            int r6 = r5.f51182c
            r4.getClass()
            int r4 = r5.f51182c
            int r6 = r5.f51181b
            int r4 = r4 - r6
            io.ktor.utils.io.core.OutputKt.a(r5, r4)
            r4 = 0
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.e0(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.core.Buffer, kotlin.coroutines.jvm.internal.ContinuationImpl):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void f0(io.ktor.utils.io.ByteChannelSequentialBase r3, int r4, kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            boolean r4 = r5 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1
            if (r4 == 0) goto L13
            r4 = r5
            io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1 r4 = (io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1) r4
            int r0 = r4.f51027d
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r4.f51027d = r0
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1 r4 = new io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1
            r4.<init>(r3, r5)
        L18:
            java.lang.Object r5 = r4.f51025b
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r4.f51027d
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 == r2) goto L2b
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L2b:
            io.ktor.utils.io.ByteChannelSequentialBase r3 = r4.f51024a
            kotlin.ResultKt.b(r5)
            goto L40
        L31:
            kotlin.ResultKt.b(r5)
            r4.f51024a = r3
            r4.f51027d = r2
            r5 = 4
            kotlin.Unit r4 = r3.P(r5, r4)
            if (r4 != r0) goto L40
            return
        L40:
            r3.getClass()
            r3 = 0
            java.lang.String r4 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.f0(io.ktor.utils.io.ByteChannelSequentialBase, int, kotlin.coroutines.jvm.internal.ContinuationImpl):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g0(io.ktor.utils.io.ByteChannelSequentialBase r2, long r3, kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            boolean r3 = r5 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1
            if (r3 == 0) goto L13
            r3 = r5
            io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1 r3 = (io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1) r3
            int r4 = r3.f51031d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L13
            int r4 = r4 - r0
            r3.f51031d = r4
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1 r3 = new io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1
            r3.<init>(r2, r5)
        L18:
            java.lang.Object r4 = r3.f51029b
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r0 = r3.f51031d
            r1 = 1
            if (r0 == 0) goto L31
            if (r0 == r1) goto L2b
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
            r2.<init>(r3)
            throw r2
        L2b:
            io.ktor.utils.io.ByteChannelSequentialBase r2 = r3.f51028a
            kotlin.ResultKt.b(r4)
            goto L41
        L31:
            kotlin.ResultKt.b(r4)
            r3.f51028a = r2
            r3.f51031d = r1
            r4 = 8
            kotlin.Unit r3 = r2.P(r4, r3)
            if (r3 != r5) goto L41
            return
        L41:
            r2.getClass()
            r2 = 0
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.g0(io.ktor.utils.io.ByteChannelSequentialBase, long, kotlin.coroutines.jvm.internal.ContinuationImpl):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void h0(io.ktor.utils.io.ByteChannelSequentialBase r4, io.ktor.utils.io.core.ByteReadPacket r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1) r0
            int r1 = r0.f51036e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51036e = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f51034c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f51036e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 == r3) goto L2b
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2b:
            io.ktor.utils.io.core.ByteReadPacket r5 = r0.f51033b
            io.ktor.utils.io.ByteChannelSequentialBase r4 = r0.f51032a
            kotlin.ResultKt.b(r6)
            goto L43
        L33:
            kotlin.ResultKt.b(r6)
            r0.f51032a = r4
            r0.f51033b = r5
            r0.f51036e = r3
            kotlin.Unit r6 = r4.P(r3, r0)
            if (r6 != r1) goto L43
            return
        L43:
            r5.getClass()
            r4.getClass()
            r4 = 0
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.h0(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.core.ByteReadPacket, kotlin.coroutines.jvm.internal.ContinuationImpl):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void i0(io.ktor.utils.io.ByteChannelSequentialBase r4, short r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) throws io.ktor.utils.io.core.InsufficientSpaceException {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1) r0
            int r1 = r0.f51041e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51041e = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f51039c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f51041e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 == r3) goto L2b
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2b:
            short r5 = r0.f51038b
            io.ktor.utils.io.ByteChannelSequentialBase r4 = r0.f51037a
            kotlin.ResultKt.b(r6)
            goto L44
        L33:
            kotlin.ResultKt.b(r6)
            r0.f51037a = r4
            r0.f51038b = r5
            r0.f51041e = r3
            r6 = 2
            kotlin.Unit r6 = r4.P(r6, r0)
            if (r6 != r1) goto L44
            return
        L44:
            r4.getClass()
            short r4 = (short) r5
            r5 = 0
            io.ktor.utils.io.core.OutputPrimitivesKt.a(r5, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.i0(io.ktor.utils.io.ByteChannelSequentialBase, short, kotlin.coroutines.jvm.internal.ContinuationImpl):void");
    }

    @Override // io.ktor.utils.io.HasReadSession
    public final SuspendableReadSession A() {
        return this;
    }

    @Override // io.ktor.utils.io.ReadSession
    public final int B(int i2) throws Throwable {
        Throwable thA = a();
        if (thA != null) {
            throw thA;
        }
        if (i2 == 0) {
            return 0;
        }
        throw null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object D(long j2, ContinuationImpl continuationImpl) {
        throw null;
    }

    @Override // io.ktor.utils.io.HasReadSession
    public final void G() {
        S();
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object H(int i2, ContinuationImpl continuationImpl) {
        f0(this, i2, continuationImpl);
        return CoroutineSingletons.f53689a;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object I(ChunkBuffer chunkBuffer, ContinuationImpl continuationImpl) {
        return V(chunkBuffer, continuationImpl);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object J(byte[] bArr, int i2, int i3, ContinuationImpl continuationImpl) {
        return d0(this, bArr, i2, i3, continuationImpl);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final boolean K() {
        CloseElement closeElement = (CloseElement) this._closed;
        if ((closeElement != null ? closeElement.f51121a : null) != null) {
            return true;
        }
        return U() && this.channelSize == 0;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final boolean L() {
        return false;
    }

    public final void M(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(b.f(i2, "Can't read negative amount of bytes: ").toString());
        }
        int i3 = -i2;
        f50889e.getAndAdd(this, i3);
        f50886b.addAndGet(this, i2);
        f50888d.getAndAdd(this, i3);
        if (this.channelSize < 0) {
            StringBuilder sb = new StringBuilder("Readable bytes count is negative: ");
            a.q(this._availableForRead, i2, ", ", " in ", sb);
            sb.append(this);
            throw new IllegalStateException(sb.toString().toString());
        }
        if (this._availableForRead >= 0) {
            throw null;
        }
        StringBuilder sb2 = new StringBuilder("Readable bytes count is negative: ");
        a.q(this._availableForRead, i2, ", ", " in ", sb2);
        sb2.append(this);
        throw new IllegalStateException(sb2.toString().toString());
    }

    public final void N() {
        f50889e.getAndAdd(this, 0);
        f50887c.addAndGet(this, 0);
        if (this.channelSize >= 0) {
            if (U() || T() == 0) {
                throw null;
            }
        } else {
            throw new IllegalStateException(("Readable bytes count is negative: " + this.channelSize + ", 0 in " + this).toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.Unit O(int r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1) r0
            int r1 = r0.f50895e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50895e = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f50893c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r0.f50895e
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            int r5 = r0.f50892b
            io.ktor.utils.io.ByteChannelSequentialBase r1 = r0.f50891a
            kotlin.ResultKt.b(r6)
            goto L37
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r6)
            r1 = r4
        L37:
            int r6 = r1._availableForRead
            if (r6 >= r5) goto L4a
            boolean r6 = r1.K()
            if (r6 == 0) goto L42
            goto L4a
        L42:
            r0.f50891a = r1
            r0.f50892b = r5
            r0.f50895e = r2
            r5 = 0
            throw r5
        L4a:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.O(int, kotlin.coroutines.jvm.internal.ContinuationImpl):kotlin.Unit");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.Unit P(int r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1) r0
            int r1 = r0.f50898c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50898c = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f50896a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r0 = r0.f50898c
            r1 = 0
            if (r0 == 0) goto L32
            r5 = 1
            if (r0 != r5) goto L2a
            kotlin.ResultKt.b(r6)
            r5 = 0
            r6 = r1
            goto L36
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.b(r6)
            r6 = r4
        L36:
            int r0 = r6.T()
            if (r0 >= r5) goto L44
            boolean r5 = r6.U()
            if (r5 == 0) goto L43
            goto L44
        L43:
            throw r1
        L44:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.P(int, kotlin.coroutines.jvm.internal.ContinuationImpl):kotlin.Unit");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q(int r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1) r0
            int r1 = r0.f50904d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50904d = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f50902b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50904d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2b
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2b:
            io.ktor.utils.io.ByteChannelSequentialBase r5 = r0.f50901a
            kotlin.ResultKt.b(r6)
            goto L42
        L31:
            kotlin.ResultKt.b(r6)
            if (r5 < 0) goto L47
            r0.f50901a = r4
            r0.f50904d = r3
            kotlin.Unit r5 = r4.O(r5, r0)
            if (r5 != r1) goto L41
            return
        L41:
            r5 = r4
        L42:
            r5.getClass()
            r5 = 0
            throw r5
        L47:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Failed requirement."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.Q(int, kotlin.coroutines.jvm.internal.ContinuationImpl):void");
    }

    public final void R(int i2, BytePacketBuilder bytePacketBuilder) throws Throwable {
        Throwable thA = a();
        if (thA != null) {
            if (bytePacketBuilder == null) {
                throw thA;
            }
            bytePacketBuilder.close();
            throw thA;
        }
        if (!U() || this._availableForRead >= i2) {
            return;
        }
        if (bytePacketBuilder != null) {
            bytePacketBuilder.close();
        }
        throw new EOFException(i2 + " bytes required but EOF reached");
    }

    public final void S() {
        ChunkBuffer chunkBuffer = (ChunkBuffer) this.lastReadView$delegate;
        int i2 = this.lastReadAvailable$delegate - (chunkBuffer.f51182c - chunkBuffer.f51181b);
        ChunkBuffer chunkBuffer2 = (ChunkBuffer) this.lastReadView$delegate;
        ChunkBuffer chunkBuffer3 = ChunkBuffer.f51216l;
        if (chunkBuffer2 != chunkBuffer3) {
            UnsafeKt.a(null, (ChunkBuffer) this.lastReadView$delegate);
            throw null;
        }
        if (i2 > 0) {
            M(i2);
            throw null;
        }
        this.lastReadAvailable$delegate = 0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ChunkBuffer.f51213i;
        this.lastReadView$delegate = chunkBuffer3;
    }

    public final int T() {
        return Math.max(0, 4088 - this.channelSize);
    }

    public final boolean U() {
        return this._closed != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object V(io.ktor.utils.io.core.internal.ChunkBuffer r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2) r0
            int r1 = r0.f50924d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50924d = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f50922b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50924d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2b
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2b:
            io.ktor.utils.io.ByteChannelSequentialBase r5 = r0.f50921a
            kotlin.ResultKt.b(r6)
            goto L66
        L31:
            kotlin.ResultKt.b(r6)
            java.lang.Throwable r6 = r4.a()
            if (r6 != 0) goto L6b
            boolean r6 = r4.U()
            if (r6 == 0) goto L4b
            int r6 = r4._availableForRead
            if (r6 != 0) goto L4b
            java.lang.Integer r5 = new java.lang.Integer
            r6 = -1
            r5.<init>(r6)
            return r5
        L4b:
            int r6 = r5.f51184e
            int r5 = r5.f51182c
            int r6 = r6 - r5
            if (r6 != 0) goto L59
            java.lang.Integer r5 = new java.lang.Integer
            r6 = 0
            r5.<init>(r6)
            return r5
        L59:
            int r5 = r4._availableForRead
            if (r5 != 0) goto L65
            r0.f50921a = r4
            r0.f50924d = r3
            r4.Q(r3, r0)
            return r1
        L65:
            r5 = r4
        L66:
            r5.getClass()
            r5 = 0
            throw r5
        L6b:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.V(io.ktor.utils.io.core.internal.ChunkBuffer, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0063 -> B:12:0x0033). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Y(byte[] r8, int r9, int r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2) r0
            int r1 = r0.f50962h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50962h = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2
            r0.<init>(r7, r11)
        L18:
            java.lang.Object r11 = r0.f50960f
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50962h
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            int r8 = r0.f50959e
            int r9 = r0.f50958d
            int r10 = r0.f50957c
            byte[] r2 = r0.f50956b
            io.ktor.utils.io.ByteChannelSequentialBase r4 = r0.f50955a
            kotlin.ResultKt.b(r11)
            r6 = r0
            r0 = r9
            r9 = r2
        L33:
            r2 = r6
            goto L67
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3d:
            kotlin.ResultKt.b(r11)
            r11 = 0
            r4 = r9
            r9 = r8
            r8 = r11
            r11 = r10
            r10 = r4
            r4 = r7
        L47:
            if (r8 >= r11) goto L7c
            int r2 = r10 + r8
            int r5 = r11 - r8
            r0.f50955a = r4
            r0.f50956b = r9
            r0.f50957c = r10
            r0.f50958d = r11
            r0.f50959e = r8
            r0.f50962h = r3
            r4.getClass()
            java.lang.Object r2 = W(r4, r9, r2, r5, r0)
            if (r2 != r1) goto L63
            return r1
        L63:
            r6 = r0
            r0 = r11
            r11 = r2
            goto L33
        L67:
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            r5 = -1
            if (r11 == r5) goto L74
            int r8 = r8 + r11
            r11 = r0
            r0 = r2
            goto L47
        L74:
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.String r9 = "Unexpected end of stream"
            r8.<init>(r9)
            throw r8
        L7c:
            kotlin.Unit r8 = kotlin.Unit.f53572a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.Y(byte[], int, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public final Throwable a() {
        CloseElement closeElement = (CloseElement) this._closed;
        if (closeElement != null) {
            return closeElement.f51121a;
        }
        return null;
    }

    @Override // io.ktor.utils.io.ReadSession
    public final ChunkBuffer b(int i2) throws Throwable {
        Throwable thA = a();
        if (thA != null) {
            throw thA;
        }
        S();
        throw null;
    }

    public final Object b0(ChunkBuffer chunkBuffer, Continuation continuation) {
        ByteChannelSequentialBase byteChannelSequentialBase;
        Object objB0;
        ByteChannelSequentialBase$writeAvailableSuspend$1 byteChannelSequentialBase$writeAvailableSuspend$1 = (ByteChannelSequentialBase$writeAvailableSuspend$1) continuation;
        int i2 = byteChannelSequentialBase$writeAvailableSuspend$1.f50997e;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            byteChannelSequentialBase$writeAvailableSuspend$1.f50997e = i2 - Integer.MIN_VALUE;
        } else {
            byteChannelSequentialBase$writeAvailableSuspend$1 = new ByteChannelSequentialBase$writeAvailableSuspend$1(this, continuation);
        }
        Object obj = byteChannelSequentialBase$writeAvailableSuspend$1.f50995c;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = byteChannelSequentialBase$writeAvailableSuspend$1.f50997e;
        if (i3 == 0) {
            ResultKt.b(obj);
            byteChannelSequentialBase$writeAvailableSuspend$1.f50993a = this;
            byteChannelSequentialBase$writeAvailableSuspend$1.f50994b = chunkBuffer;
            byteChannelSequentialBase$writeAvailableSuspend$1.f50997e = 1;
            if (P(1, byteChannelSequentialBase$writeAvailableSuspend$1) != coroutineSingletons) {
                byteChannelSequentialBase = this;
            }
        }
        if (i3 != 1) {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        chunkBuffer = byteChannelSequentialBase$writeAvailableSuspend$1.f50994b;
        byteChannelSequentialBase = byteChannelSequentialBase$writeAvailableSuspend$1.f50993a;
        ResultKt.b(obj);
        byteChannelSequentialBase$writeAvailableSuspend$1.f50993a = null;
        byteChannelSequentialBase$writeAvailableSuspend$1.f50994b = null;
        byteChannelSequentialBase$writeAvailableSuspend$1.f50997e = 2;
        byteChannelSequentialBase.getClass();
        int i4 = chunkBuffer.f51182c - chunkBuffer.f51181b;
        if (i4 == 0) {
            objB0 = new Integer(0);
        } else {
            int iMin = Math.min(i4, byteChannelSequentialBase.T());
            if (iMin != 0) {
                OutputKt.a(chunkBuffer, iMin);
                throw null;
            }
            objB0 = byteChannelSequentialBase.b0(chunkBuffer, byteChannelSequentialBase$writeAvailableSuspend$1);
        }
        return objB0 == coroutineSingletons ? coroutineSingletons : objB0;
    }

    @Override // io.ktor.utils.io.SuspendableReadSession
    public final Object c(int i2, ContinuationImpl continuationImpl) {
        if (i2 < 0) {
            throw new IllegalArgumentException(b.f(i2, "atLeast parameter shouldn't be negative: ").toString());
        }
        if (i2 > 4088) {
            throw new IllegalArgumentException(b.f(i2, "atLeast parameter shouldn't be larger than max buffer size of 4088: ").toString());
        }
        S();
        if (i2 == 0) {
            return Boolean.valueOf(!K());
        }
        throw null;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final boolean d(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        CloseElement closeElement = th == null ? CloseElementKt.f51122a : new CloseElement(th);
        do {
            atomicReferenceFieldUpdater = f50890f;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, closeElement)) {
                th.getClass();
                throw null;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return false;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object e(short s, ContinuationImpl continuationImpl) throws InsufficientSpaceException {
        i0(this, s, continuationImpl);
        return CoroutineSingletons.f53689a;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object f(byte b2, ContinuationImpl continuationImpl) {
        c0(this, b2, continuationImpl);
        return CoroutineSingletons.f53689a;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final void flush() {
        throw null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final int g() {
        return this._availableForRead;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final boolean h() {
        return U();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.nio.ByteBuffer r17, long r18, long r20, long r22, kotlin.coroutines.Continuation r24) {
        /*
            r16 = this;
            r0 = r16
            r1 = r24
            boolean r2 = r1 instanceof io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1
            if (r2 == 0) goto L17
            r2 = r1
            io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1 r2 = (io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1) r2
            int r3 = r2.f50913d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.f50913d = r3
            goto L1e
        L17:
            io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1 r2 = new io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1
            kotlin.coroutines.jvm.internal.ContinuationImpl r1 = (kotlin.coroutines.jvm.internal.ContinuationImpl) r1
            r2.<init>(r0, r1)
        L1e:
            java.lang.Object r1 = r2.f50911b
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r4 = r2.f50913d
            r5 = 1
            if (r4 == 0) goto L37
            if (r4 != r5) goto L2f
            kotlin.jvm.internal.Ref$LongRef r2 = r2.f50910a
            kotlin.ResultKt.b(r1)
            goto L59
        L2f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L37:
            kotlin.ResultKt.b(r1)
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            io.ktor.utils.io.ByteChannelSequentialBase$peekTo$2 r6 = new io.ktor.utils.io.ByteChannelSequentialBase$peekTo$2
            r15 = 0
            r12 = r17
            r13 = r18
            r7 = r20
            r10 = r22
            r6.<init>(r7, r9, r10, r12, r13, r15)
            r2.f50910a = r9
            r2.f50913d = r5
            java.lang.Object r1 = Z(r0, r6, r2)
            if (r1 != r3) goto L58
            return r3
        L58:
            r2 = r9
        L59:
            long r1 = r2.f53800a
            java.lang.Long r3 = new java.lang.Long
            r3.<init>(r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.i(java.nio.ByteBuffer, long, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object j(byte[] bArr, int i2, int i3, ContinuationImpl continuationImpl) {
        return W(this, bArr, i2, i3, continuationImpl);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object k(ContinuationImpl continuationImpl) {
        throw null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final boolean l(Throwable th) {
        if (a() == null && !U()) {
            if (th == null) {
                th = new CancellationException("Channel cancelled");
            }
            d(th);
        }
        return false;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object m(Function2 function2, Continuation continuation) {
        Object objInvoke = function2.invoke(new ByteChannelSequentialBase$beginWriteSession$1(this), continuation);
        return objInvoke == CoroutineSingletons.f53689a ? objInvoke : Unit.f53572a;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object n(long j2, ContinuationImpl continuationImpl) throws Throwable {
        Throwable thA = a();
        if (thA != null) {
            throw thA;
        }
        new BytePacketBuilder(0);
        throw null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object o(ContinuationImpl continuationImpl) {
        throw null;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object p(long j2, ContinuationImpl continuationImpl) {
        g0(this, j2, continuationImpl);
        return CoroutineSingletons.f53689a;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object q(ContinuationImpl continuationImpl) {
        throw null;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object s(Buffer buffer, ContinuationImpl continuationImpl) {
        e0(this, buffer, continuationImpl);
        return CoroutineSingletons.f53689a;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object t(int i2, ContinuationImpl continuationImpl) throws Throwable {
        R(i2, null);
        new BytePacketBuilder(0);
        throw null;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public final Object u(ByteReadPacket byteReadPacket, ContinuationImpl continuationImpl) {
        h0(this, byteReadPacket, continuationImpl);
        return CoroutineSingletons.f53689a;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object v(byte[] bArr, int i2, ContinuationImpl continuationImpl) {
        return X(this, bArr, i2, continuationImpl);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object w(Continuation continuation) {
        return a0(this, Api.BaseClientBuilder.API_PRIORITY_OTHER, (ContinuationImpl) continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Object x(Continuation continuation) {
        throw null;
    }

    @Override // io.ktor.utils.io.HasWriteSession
    public final WriterSuspendSession y() {
        return new ByteChannelSequentialBase$beginWriteSession$1(this);
    }

    @Override // io.ktor.utils.io.HasWriteSession
    public final void z(int i2) {
        throw null;
    }
}

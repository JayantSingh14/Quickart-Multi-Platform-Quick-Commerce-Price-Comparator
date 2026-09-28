package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", l = {246}, m = "writeWhile")
/* loaded from: classes3.dex */
final class ByteChannelSequentialJVM$writeWhile$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteChannelSequentialJVM f51069a;

    /* renamed from: b, reason: collision with root package name */
    public Function1 f51070b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f51071c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialJVM f51072d;

    /* renamed from: e, reason: collision with root package name */
    public int f51073e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialJVM$writeWhile$1(ByteChannelSequentialJVM byteChannelSequentialJVM, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51072d = byteChannelSequentialJVM;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r5.f51071c = r6
            int r6 = r5.f51073e
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r6 | r0
            r5.f51073e = r6
            io.ktor.utils.io.ByteChannelSequentialJVM r6 = r5.f51072d
            r6.getClass()
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteChannelSequentialJVM$writeWhile$1
            if (r0 == 0) goto L1f
            int r0 = r5.f51073e
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L1f
            int r0 = r0 - r1
            r5.f51073e = r0
            r0 = r5
            goto L24
        L1f:
            io.ktor.utils.io.ByteChannelSequentialJVM$writeWhile$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$writeWhile$1
            r0.<init>(r6, r5)
        L24:
            java.lang.Object r1 = r0.f51071c
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r3 = r0.f51073e
            r4 = 1
            if (r3 == 0) goto L3d
            if (r3 == r4) goto L37
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L37:
            io.ktor.utils.io.ByteChannelSequentialJVM r6 = r0.f51069a
            kotlin.ResultKt.b(r1)
            goto L66
        L3d:
            kotlin.ResultKt.b(r1)
            boolean r1 = r6.U()
            if (r1 == 0) goto L54
            java.lang.Throwable r6 = r6.a()
            if (r6 != 0) goto L53
            kotlinx.coroutines.channels.ClosedSendChannelException r6 = new kotlinx.coroutines.channels.ClosedSendChannelException
            java.lang.String r0 = "Channel closed for write"
            r6.<init>(r0)
        L53:
            throw r6
        L54:
            kotlin.jvm.internal.Ref$BooleanRef r1 = new kotlin.jvm.internal.Ref$BooleanRef
            r1.<init>()
            r0.f51069a = r6
            r0.f51073e = r4
            kotlin.Unit r0 = r6.P(r4, r0)
            if (r0 != r2) goto L66
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            return r6
        L66:
            r6.getClass()
            r6 = 0
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM$writeWhile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

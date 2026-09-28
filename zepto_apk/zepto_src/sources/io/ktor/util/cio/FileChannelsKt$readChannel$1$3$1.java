package io.ktor.util.cio;

import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.WriterSuspendSession;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(c = "io.ktor.util.cio.FileChannelsKt$readChannel$1$3$1", f = "FileChannels.kt", l = {49}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class FileChannelsKt$readChannel$1$3$1 extends SuspendLambda implements Function2<WriterSuspendSession, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f50516a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f50517b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WriterScope f50518c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FileChannel f50519d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileChannelsKt$readChannel$1$3$1(WriterScope writerScope, FileChannel fileChannel, Continuation continuation) {
        super(2, continuation);
        this.f50518c = writerScope;
        this.f50519d = fileChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FileChannelsKt$readChannel$1$3$1 fileChannelsKt$readChannel$1$3$1 = new FileChannelsKt$readChannel$1$3$1(this.f50518c, this.f50519d, continuation);
        fileChannelsKt$readChannel$1$3$1.f50517b = obj;
        return fileChannelsKt$readChannel$1$3$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((FileChannelsKt$readChannel$1$3$1) create((WriterSuspendSession) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x008d, code lost:
    
        throw new java.lang.IllegalStateException(android.support.v4.media.b.g(r5, "Wrong buffer position change: ", ". Position should be moved forward only by at most size bytes (size = 1)"));
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.io.IOException {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r8.f50516a
            r2 = 1
            if (r1 == 0) goto L19
            if (r1 != r2) goto L11
            java.lang.Object r1 = r8.f50517b
            io.ktor.utils.io.WriterSuspendSession r1 = (io.ktor.utils.io.WriterSuspendSession) r1
            kotlin.ResultKt.b(r9)
            goto L21
        L11:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L19:
            kotlin.ResultKt.b(r9)
            java.lang.Object r9 = r8.f50517b
            io.ktor.utils.io.WriterSuspendSession r9 = (io.ktor.utils.io.WriterSuspendSession) r9
            r1 = r9
        L21:
            io.ktor.utils.io.core.internal.ChunkBuffer r9 = r1.b(r2)
            if (r9 != 0) goto L3b
            io.ktor.utils.io.WriterScope r9 = r8.f50518c
            io.ktor.utils.io.ByteChannel r9 = r9.l0()
            r9.flush()
            r8.f50517b = r1
            r8.f50516a = r2
            java.lang.Object r9 = r1.c(r2, r8)
            if (r9 != r0) goto L21
            return r0
        L3b:
            java.nio.channels.FileChannel r3 = r8.f50519d
            java.lang.String r4 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            java.lang.String r4 = "buffer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r4)
            int r4 = r9.f51184e
            int r5 = r9.f51182c
            int r4 = r4 - r5
            if (r4 != 0) goto L50
            r9 = 0
            goto L76
        L50:
            if (r2 > r4) goto L8e
            java.nio.ByteBuffer r5 = r9.f51180a
            java.nio.ByteBuffer r5 = r5.duplicate()
            kotlin.jvm.internal.Intrinsics.c(r5)
            int r6 = r9.f51182c
            int r7 = r9.f51184e
            r5.limit(r7)
            r5.position(r6)
            int r3 = r3.read(r5)
            int r5 = r5.position()
            int r5 = r5 - r6
            if (r5 < 0) goto L80
            if (r5 > r4) goto L80
            r9.a(r5)
            r9 = r3
        L76:
            r3 = -1
            if (r9 == r3) goto L7d
            r1.a(r9)
            goto L21
        L7d:
            kotlin.Unit r9 = kotlin.Unit.f53572a
            return r9
        L80:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "Wrong buffer position change: "
            java.lang.String r1 = ". Position should be moved forward only by at most size bytes (size = 1)"
            java.lang.String r0 = android.support.v4.media.b.g(r5, r0, r1)
            r9.<init>(r0)
            throw r9
        L8e:
            java.lang.String r9 = "size 1 is greater than buffer's remaining capacity "
            java.lang.String r9 = android.support.v4.media.b.f(r4, r9)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.cio.FileChannelsKt$readChannel$1$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

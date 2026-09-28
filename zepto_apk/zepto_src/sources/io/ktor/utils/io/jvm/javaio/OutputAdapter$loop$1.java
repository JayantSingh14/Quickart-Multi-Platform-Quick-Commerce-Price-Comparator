package io.ktor.utils.io.jvm.javaio;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OutputAdapter$loop$1 extends BlockingAdapter {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ OutputAdapter f51324g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutputAdapter$loop$1(OutputAdapter outputAdapter) {
        super(null);
        this.f51324g = outputAdapter;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int, io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1] */
    @Override // io.ktor.utils.io.jvm.javaio.BlockingAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(kotlin.coroutines.jvm.internal.ContinuationImpl r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1$loop$1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1$loop$1 r0 = (io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1$loop$1) r0
            int r1 = r0.f51328d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51328d = r1
            goto L18
        L13:
            io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1$loop$1 r0 = new io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1$loop$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f51326b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f51328d
            r3 = 1
            if (r2 == 0) goto L88
            r4 = 2
            if (r2 == r3) goto L36
            if (r2 != r4) goto L2e
            io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1 r2 = r0.f51325a
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L2c
            goto L8c
        L2c:
            r9 = move-exception
            goto L9c
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L36:
            io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1 r2 = r0.f51325a
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r5 = io.ktor.utils.io.jvm.javaio.BlockingKt.f51308b     // Catch: java.lang.Throwable -> L2c
            if (r9 != r5) goto L58
            io.ktor.utils.io.jvm.javaio.OutputAdapter r9 = r2.f51324g
            io.ktor.utils.io.ByteWriteChannel r9 = r9.f51321a
            boolean r9 = io.ktor.utils.io.ByteWriteChannelKt.a(r9)
            if (r9 != 0) goto L55
            io.ktor.utils.io.jvm.javaio.OutputAdapter r9 = r2.f51324g
            io.ktor.utils.io.ByteWriteChannel r9 = r9.f51321a
            java.lang.Throwable r9 = r9.a()
            if (r9 != 0) goto L54
            goto L55
        L54:
            throw r9
        L55:
            kotlin.Unit r9 = kotlin.Unit.f53572a
            return r9
        L58:
            java.lang.Object r5 = io.ktor.utils.io.jvm.javaio.BlockingKt.f51309c     // Catch: java.lang.Throwable -> L2c
            if (r9 != r5) goto L6f
            io.ktor.utils.io.jvm.javaio.OutputAdapter r9 = r2.f51324g     // Catch: java.lang.Throwable -> L2c
            io.ktor.utils.io.ByteWriteChannel r9 = r9.f51321a     // Catch: java.lang.Throwable -> L2c
            r9.flush()     // Catch: java.lang.Throwable -> L2c
            io.ktor.utils.io.jvm.javaio.OutputAdapter r9 = r2.f51324g     // Catch: java.lang.Throwable -> L2c
            io.ktor.utils.io.ByteWriteChannel r9 = r9.f51321a     // Catch: java.lang.Throwable -> L2c
            java.lang.Throwable r9 = r9.a()     // Catch: java.lang.Throwable -> L2c
            if (r9 != 0) goto L6e
            goto L8c
        L6e:
            throw r9     // Catch: java.lang.Throwable -> L2c
        L6f:
            boolean r5 = r9 instanceof byte[]     // Catch: java.lang.Throwable -> L2c
            if (r5 == 0) goto L8c
            io.ktor.utils.io.jvm.javaio.OutputAdapter r5 = r2.f51324g     // Catch: java.lang.Throwable -> L2c
            io.ktor.utils.io.ByteWriteChannel r5 = r5.f51321a     // Catch: java.lang.Throwable -> L2c
            byte[] r9 = (byte[]) r9     // Catch: java.lang.Throwable -> L2c
            int r6 = r2.f51300d     // Catch: java.lang.Throwable -> L2c
            int r7 = r2.f51301e     // Catch: java.lang.Throwable -> L2c
            r0.f51325a = r2     // Catch: java.lang.Throwable -> L2c
            r0.f51328d = r4     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r9 = r5.J(r9, r6, r7, r0)     // Catch: java.lang.Throwable -> L2c
            if (r9 != r1) goto L8c
            return r1
        L88:
            kotlin.ResultKt.b(r9)
            r2 = r8
        L8c:
            r9 = 0
            r2.result = r9     // Catch: java.lang.Throwable -> L2c
            r0.f51325a = r2     // Catch: java.lang.Throwable -> L2c
            r0.f51328d = r3     // Catch: java.lang.Throwable -> L2c
            io.ktor.utils.io.jvm.javaio.BlockingAdapter.a(r2, r0)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r9 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r9)     // Catch: java.lang.Throwable -> L2c
            return r1
        L9c:
            boolean r0 = r9 instanceof java.util.concurrent.CancellationException     // Catch: java.lang.Throwable -> La8
            if (r0 != 0) goto Laa
            io.ktor.utils.io.jvm.javaio.OutputAdapter r0 = r2.f51324g     // Catch: java.lang.Throwable -> La8
            io.ktor.utils.io.ByteWriteChannel r0 = r0.f51321a     // Catch: java.lang.Throwable -> La8
            r0.d(r9)     // Catch: java.lang.Throwable -> La8
            goto Laa
        La8:
            r9 = move-exception
            goto Lab
        Laa:
            throw r9     // Catch: java.lang.Throwable -> La8
        Lab:
            io.ktor.utils.io.jvm.javaio.OutputAdapter r0 = r2.f51324g
            io.ktor.utils.io.ByteWriteChannel r0 = r0.f51321a
            boolean r0 = io.ktor.utils.io.ByteWriteChannelKt.a(r0)
            if (r0 != 0) goto Lc0
            io.ktor.utils.io.jvm.javaio.OutputAdapter r0 = r2.f51324g
            io.ktor.utils.io.ByteWriteChannel r0 = r0.f51321a
            java.lang.Throwable r0 = r0.a()
            if (r0 == 0) goto Lc0
            throw r0
        Lc0:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1.b(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}

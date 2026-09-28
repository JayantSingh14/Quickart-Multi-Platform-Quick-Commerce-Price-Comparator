package io.ktor.utils.io.jvm.javaio;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class InputAdapter$loop$1 extends BlockingAdapter {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ InputAdapter f51316g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAdapter$loop$1(Job job, InputAdapter inputAdapter) {
        super(job);
        this.f51316g = inputAdapter;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.utils.io.jvm.javaio.BlockingAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1 r0 = (io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1) r0
            int r1 = r0.f51320d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51320d = r1
            goto L18
        L13:
            io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1 r0 = new io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f51318b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f51320d
            r3 = 1
            if (r2 == 0) goto L68
            r4 = 2
            if (r2 == r3) goto L34
            if (r2 != r4) goto L2c
            io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1 r2 = r0.f51317a
            kotlin.ResultKt.b(r9)
            goto L53
        L2c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L34:
            io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1 r2 = r0.f51317a
            kotlin.ResultKt.b(r9)
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.ByteArray"
            kotlin.jvm.internal.Intrinsics.d(r9, r5)
            byte[] r9 = (byte[]) r9
            io.ktor.utils.io.jvm.javaio.InputAdapter r5 = r2.f51316g
            io.ktor.utils.io.ByteReadChannel r5 = r5.f51312a
            int r6 = r2.f51300d
            int r7 = r2.f51301e
            r0.f51317a = r2
            r0.f51320d = r4
            java.lang.Object r9 = r5.j(r9, r6, r7, r0)
            if (r9 != r1) goto L53
            return r1
        L53:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            r4 = -1
            if (r9 != r4) goto L6d
            io.ktor.utils.io.jvm.javaio.InputAdapter r0 = r2.f51316g
            kotlinx.coroutines.JobImpl r0 = r0.f51313b
            r0.complete()
            r2.result = r9
            kotlin.Unit r9 = kotlin.Unit.f53572a
            return r9
        L68:
            kotlin.ResultKt.b(r9)
            r9 = 0
            r2 = r8
        L6d:
            r2.result = r9
            r0.f51317a = r2
            r0.f51320d = r3
            io.ktor.utils.io.jvm.javaio.BlockingAdapter.a(r2, r0)
            java.lang.String r9 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1.b(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}

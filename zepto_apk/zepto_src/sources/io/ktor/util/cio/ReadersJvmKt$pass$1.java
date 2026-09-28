package io.ktor.util.cio;

import io.ktor.utils.io.ByteReadChannel;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@DebugMetadata(c = "io.ktor.util.cio.ReadersJvmKt", f = "ReadersJvm.kt", l = {18}, m = "pass")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ReadersJvmKt$pass$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ByteReadChannel f50520a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f50521b;

    /* renamed from: c, reason: collision with root package name */
    public Function1 f50522c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f50523d;

    /* renamed from: e, reason: collision with root package name */
    public int f50524e;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0041 -> B:14:0x0044). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            r6.f50523d = r7
            int r0 = r6.f50524e
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            int r0 = r0 - r1
            r6.f50524e = r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            r2 = 1
            if (r0 == 0) goto L24
            if (r0 != r2) goto L1c
            kotlin.jvm.functions.Function1 r0 = r6.f50522c
            java.nio.ByteBuffer r3 = r6.f50521b
            io.ktor.utils.io.ByteReadChannel r4 = r6.f50520a
            kotlin.ResultKt.b(r7)
            r7 = r6
            goto L44
        L1c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L24:
            kotlin.ResultKt.b(r7)
            r7 = 0
            r0 = r7
            r3 = r0
            r4 = r3
            r7 = r6
        L2c:
            boolean r5 = r4.K()
            if (r5 != 0) goto L4b
            r3.clear()
            r7.f50520a = r4
            r7.f50521b = r3
            r7.f50522c = r0
            r7.f50524e = r2
            java.lang.Object r5 = r4.F(r3, r7)
            if (r5 != r1) goto L44
            return r1
        L44:
            r3.flip()
            r0.invoke(r3)
            goto L2c
        L4b:
            java.lang.Throwable r7 = r4.a()
            if (r7 != 0) goto L54
            kotlin.Unit r7 = kotlin.Unit.f53572a
            return r7
        L54:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.cio.ReadersJvmKt$pass$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteWriteChannel;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.ReadingKt", f = "Reading.kt", l = {29}, m = "copyTo")
/* loaded from: classes3.dex */
final class ReadingKt$copyTo$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public InputStream f51331a;

    /* renamed from: b, reason: collision with root package name */
    public ByteWriteChannel f51332b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f51333c;

    /* renamed from: d, reason: collision with root package name */
    public long f51334d;

    /* renamed from: e, reason: collision with root package name */
    public long f51335e;

    /* renamed from: f, reason: collision with root package name */
    public long f51336f;

    /* renamed from: g, reason: collision with root package name */
    public int f51337g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f51338h;

    /* renamed from: i, reason: collision with root package name */
    public int f51339i;

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047 A[Catch: all -> 0x0024, TryCatch #0 {all -> 0x0024, blocks: (B:6:0x001f, B:23:0x0070, B:16:0x0047, B:20:0x0059, B:24:0x0073, B:13:0x003a), top: B:29:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[LOOP:0: B:14:0x0043->B:35:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x006d -> B:23:0x0070). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            r14.f51338h = r15
            int r0 = r14.f51339i
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            int r0 = r0 - r1
            r14.f51339i = r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            r2 = 1
            if (r0 == 0) goto L2e
            if (r0 != r2) goto L26
            int r0 = r14.f51337g
            long r3 = r14.f51336f
            long r5 = r14.f51335e
            long r7 = r14.f51334d
            byte[] r9 = r14.f51333c
            io.ktor.utils.io.ByteWriteChannel r10 = r14.f51332b
            java.io.InputStream r11 = r14.f51331a
            kotlin.ResultKt.b(r15)     // Catch: java.lang.Throwable -> L24
            r15 = r14
            goto L70
        L24:
            r15 = move-exception
            goto L7e
        L26:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L2e:
            kotlin.ResultKt.b(r15)
            io.ktor.utils.io.pool.ByteArrayPoolKt$ByteArrayPool$1 r15 = io.ktor.utils.io.pool.ByteArrayPoolKt.f51367a
            java.lang.Object r15 = r15.S0()
            r9 = r15
            byte[] r9 = (byte[]) r9
            int r15 = r9.length     // Catch: java.lang.Throwable -> L24
            long r3 = (long) r15     // Catch: java.lang.Throwable -> L24
            r15 = 0
            r5 = 0
            r10 = r15
            r11 = r10
            r7 = r5
            r15 = r14
        L43:
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 >= 0) goto L73
            long r12 = r7 - r5
            long r12 = java.lang.Math.min(r12, r3)     // Catch: java.lang.Throwable -> L24
            int r0 = (int) r12     // Catch: java.lang.Throwable -> L24
            r12 = 0
            int r0 = r11.read(r9, r12, r0)     // Catch: java.lang.Throwable -> L24
            r13 = -1
            if (r0 != r13) goto L57
            goto L73
        L57:
            if (r0 <= 0) goto L43
            r15.f51331a = r11     // Catch: java.lang.Throwable -> L24
            r15.f51332b = r10     // Catch: java.lang.Throwable -> L24
            r15.f51333c = r9     // Catch: java.lang.Throwable -> L24
            r15.f51334d = r7     // Catch: java.lang.Throwable -> L24
            r15.f51335e = r5     // Catch: java.lang.Throwable -> L24
            r15.f51336f = r3     // Catch: java.lang.Throwable -> L24
            r15.f51337g = r0     // Catch: java.lang.Throwable -> L24
            r15.f51339i = r2     // Catch: java.lang.Throwable -> L24
            java.lang.Object r12 = r10.J(r9, r12, r0, r15)     // Catch: java.lang.Throwable -> L24
            if (r12 != r1) goto L70
            return r1
        L70:
            long r12 = (long) r0     // Catch: java.lang.Throwable -> L24
            long r5 = r5 + r12
            goto L43
        L73:
            java.lang.Long r15 = new java.lang.Long     // Catch: java.lang.Throwable -> L24
            r15.<init>(r5)     // Catch: java.lang.Throwable -> L24
            io.ktor.utils.io.pool.ByteArrayPoolKt$ByteArrayPool$1 r0 = io.ktor.utils.io.pool.ByteArrayPoolKt.f51367a
            r0.G1(r9)
            return r15
        L7e:
            io.ktor.utils.io.pool.ByteArrayPoolKt$ByteArrayPool$1 r0 = io.ktor.utils.io.pool.ByteArrayPoolKt.f51367a
            r0.G1(r9)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.ReadingKt$copyTo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

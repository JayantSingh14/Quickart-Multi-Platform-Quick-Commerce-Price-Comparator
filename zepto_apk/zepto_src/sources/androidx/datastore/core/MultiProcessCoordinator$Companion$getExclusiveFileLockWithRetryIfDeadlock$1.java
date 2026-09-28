package androidx.datastore.core;

import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.MultiProcessCoordinator$Companion", f = "MultiProcessCoordinator.android.kt", l = {182}, m = "getExclusiveFileLockWithRetryIfDeadlock")
/* loaded from: classes3.dex */
final class MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public FileOutputStream f3586a;

    /* renamed from: b, reason: collision with root package name */
    public long f3587b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3588c;

    /* renamed from: d, reason: collision with root package name */
    public int f3589d;

    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007a -> B:27:0x007d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.io.IOException {
        /*
            r13 = this;
            r13.f3588c = r14
            int r14 = r13.f3589d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r14 = r14 | r0
            r13.f3589d = r14
            r14 = 0
            boolean r0 = r13 instanceof androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1
            if (r0 == 0) goto L1b
            int r0 = r13.f3589d
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L1b
            int r0 = r0 - r1
            r13.f3589d = r0
            r0 = r13
            goto L20
        L1b:
            androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 r0 = new androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1
            r0.<init>(r13)
        L20:
            java.lang.Object r1 = r0.f3588c
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r3 = r0.f3589d
            r4 = 1
            if (r3 == 0) goto L3c
            if (r3 != r4) goto L34
            long r5 = r0.f3587b
            java.io.FileOutputStream r14 = r0.f3586a
            kotlin.ResultKt.b(r1)
            r1 = r0
            goto L7d
        L34:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L3c:
            kotlin.ResultKt.b(r1)
            r5 = 10
            r1 = r0
        L42:
            r7 = 60000(0xea60, double:2.9644E-319)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
        */
        //  java.lang.String r3 = "lockFileStream.getChanne…LUE, /* shared= */ false)"
        /*
            if (r0 > 0) goto L82
            java.nio.channels.FileChannel r7 = r14.getChannel()     // Catch: java.io.IOException -> L60
            r8 = 0
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r12 = 0
            java.nio.channels.FileLock r0 = r7.lock(r8, r10, r12)     // Catch: java.io.IOException -> L60
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch: java.io.IOException -> L60
            r2 = r0
            goto L95
        L60:
            r0 = move-exception
            java.lang.String r3 = r0.getMessage()
            if (r3 == 0) goto L81
            r7 = 0
            java.lang.String r8 = "Resource deadlock would occur"
            boolean r3 = kotlin.text.StringsKt.n(r3, r8, r7)
            if (r3 != r4) goto L81
            r1.f3586a = r14
            r1.f3587b = r5
            r1.f3589d = r4
            java.lang.Object r0 = kotlinx.coroutines.DelayKt.a(r5, r1)
            if (r0 != r2) goto L7d
            goto L95
        L7d:
            r0 = 2
            long r7 = (long) r0
            long r5 = r5 * r7
            goto L42
        L81:
            throw r0
        L82:
            java.nio.channels.FileChannel r7 = r14.getChannel()
            r8 = 0
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r12 = 0
            java.nio.channels.FileLock r2 = r7.lock(r8, r10, r12)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
        L95:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

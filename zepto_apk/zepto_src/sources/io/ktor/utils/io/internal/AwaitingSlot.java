package io.ktor.utils.io.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class AwaitingSlot {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51230a = AtomicReferenceFieldUpdater.newUpdater(AwaitingSlot.class, Object.class, "suspension");

    @NotNull
    private volatile /* synthetic */ Object suspension = null;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r5 = this;
            r0 = 0
            boolean r1 = r6 instanceof io.ktor.utils.io.internal.AwaitingSlot$trySuspend$1
            if (r1 == 0) goto L14
            r1 = r6
            io.ktor.utils.io.internal.AwaitingSlot$trySuspend$1 r1 = (io.ktor.utils.io.internal.AwaitingSlot$trySuspend$1) r1
            int r2 = r1.f51237c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L14
            int r2 = r2 - r3
            r1.f51237c = r2
            goto L19
        L14:
            io.ktor.utils.io.internal.AwaitingSlot$trySuspend$1 r1 = new io.ktor.utils.io.internal.AwaitingSlot$trySuspend$1
            r1.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r1.f51235a
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r1.f51237c
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L28
            kotlin.ResultKt.b(r6)
            goto L46
        L28:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L30:
            kotlin.ResultKt.b(r6)
            kotlinx.coroutines.JobImpl r6 = kotlinx.coroutines.JobKt.a()
        L37:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = io.ktor.utils.io.internal.AwaitingSlot.f51230a
            r2 = 0
            boolean r3 = r1.compareAndSet(r5, r2, r6)
            if (r3 != 0) goto L4b
            java.lang.Object r1 = r1.get(r5)
            if (r1 == 0) goto L37
        L46:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r0)
            return r6
        L4b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.AwaitingSlot.a(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}

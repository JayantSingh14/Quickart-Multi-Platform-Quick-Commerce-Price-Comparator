package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {153, 156}, m = "lastOrNull")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$lastOrNull$1<E> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ReceiveChannel f54347a;

    /* renamed from: b, reason: collision with root package name */
    public ChannelIterator f54348b;

    /* renamed from: c, reason: collision with root package name */
    public Object f54349c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54350d;

    /* renamed from: e, reason: collision with root package name */
    public int f54351e;

    /* JADX WARN: Removed duplicated region for block: B:23:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067 A[Catch: all -> 0x0071, TRY_LEAVE, TryCatch #1 {all -> 0x0071, blocks: (B:25:0x005f, B:27:0x0067), top: B:44:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0059 -> B:44:0x005f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            r8.f54350d = r9
            int r0 = r8.f54351e
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            int r0 = r0 - r1
            r8.f54351e = r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            r2 = 0
            if (r0 == 0) goto L7b
            r3 = 1
            r4 = 2
            if (r0 == r3) goto L2f
            if (r0 != r4) goto L27
            java.lang.Object r0 = r8.f54349c
            kotlinx.coroutines.channels.ChannelIterator r3 = r8.f54348b
            kotlinx.coroutines.channels.ReceiveChannel r5 = r8.f54347a
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L23
            r6 = r5
            r5 = r3
            r3 = r0
            r0 = r8
            goto L5f
        L23:
            r9 = move-exception
            r2 = r5
            goto L80
        L27:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L2f:
            kotlinx.coroutines.channels.ChannelIterator r0 = r8.f54348b
            kotlinx.coroutines.channels.ReceiveChannel r3 = r8.f54347a
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L78
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L78
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L78
            if (r9 != 0) goto L42
            r3.e(r2)
            return r2
        L42:
            java.lang.Object r9 = r0.next()     // Catch: java.lang.Throwable -> L78
            r5 = r3
            r3 = r0
            r0 = r9
            r9 = r8
        L4a:
            r9.f54347a = r5     // Catch: java.lang.Throwable -> L23
            r9.f54348b = r3     // Catch: java.lang.Throwable -> L23
            r9.f54349c = r0     // Catch: java.lang.Throwable -> L23
            r9.f54351e = r4     // Catch: java.lang.Throwable -> L23
            java.lang.Object r6 = r3.b(r9)     // Catch: java.lang.Throwable -> L23
            if (r6 != r1) goto L59
            return r1
        L59:
            r7 = r0
            r0 = r9
            r9 = r6
            r6 = r5
            r5 = r3
            r3 = r7
        L5f:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L71
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L71
            if (r9 == 0) goto L74
            java.lang.Object r9 = r5.next()     // Catch: java.lang.Throwable -> L71
            r3 = r0
            r0 = r9
            r9 = r3
            r3 = r5
            r5 = r6
            goto L4a
        L71:
            r9 = move-exception
            r2 = r6
            goto L80
        L74:
            r6.e(r2)
            return r3
        L78:
            r9 = move-exception
            r2 = r3
            goto L80
        L7b:
            kotlin.ResultKt.b(r9)
            throw r2     // Catch: java.lang.Throwable -> L7f
        L7f:
            r9 = move-exception
        L80:
            throw r9     // Catch: java.lang.Throwable -> L81
        L81:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.a(r2, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

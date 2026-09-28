package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {WKSRecord.Service.LOCUS_CON, WKSRecord.Service.CISCO_FNA}, m = "last")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$last$1<E> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ReceiveChannel f54336a;

    /* renamed from: b, reason: collision with root package name */
    public ChannelIterator f54337b;

    /* renamed from: c, reason: collision with root package name */
    public Object f54338c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54339d;

    /* renamed from: e, reason: collision with root package name */
    public int f54340e;

    /* JADX WARN: Removed duplicated region for block: B:21:0x0054 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0063 A[Catch: all -> 0x006d, TRY_LEAVE, TryCatch #4 {all -> 0x006d, blocks: (B:23:0x005b, B:25:0x0063), top: B:49:0x005b }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0070  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0055 -> B:49:0x005b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            r8.f54339d = r9
            int r0 = r8.f54340e
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            int r0 = r0 - r1
            r8.f54340e = r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            r2 = 0
            if (r0 == 0) goto L7f
            r3 = 1
            r4 = 2
            if (r0 == r3) goto L2f
            if (r0 != r4) goto L27
            java.lang.Object r0 = r8.f54338c
            kotlinx.coroutines.channels.ChannelIterator r3 = r8.f54337b
            kotlinx.coroutines.channels.ReceiveChannel r5 = r8.f54336a
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L23
            r6 = r5
            r5 = r3
            r3 = r0
            r0 = r8
            goto L5b
        L23:
            r9 = move-exception
            r2 = r5
            goto L84
        L27:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L2f:
            kotlinx.coroutines.channels.ChannelIterator r0 = r8.f54337b
            kotlinx.coroutines.channels.ReceiveChannel r3 = r8.f54336a
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L74
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L74
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L74
            if (r9 == 0) goto L77
            java.lang.Object r9 = r0.next()     // Catch: java.lang.Throwable -> L74
            r5 = r3
            r3 = r0
            r0 = r9
            r9 = r8
        L46:
            r9.f54336a = r5     // Catch: java.lang.Throwable -> L23
            r9.f54337b = r3     // Catch: java.lang.Throwable -> L23
            r9.f54338c = r0     // Catch: java.lang.Throwable -> L23
            r9.f54340e = r4     // Catch: java.lang.Throwable -> L23
            java.lang.Object r6 = r3.b(r9)     // Catch: java.lang.Throwable -> L23
            if (r6 != r1) goto L55
            return r1
        L55:
            r7 = r0
            r0 = r9
            r9 = r6
            r6 = r5
            r5 = r3
            r3 = r7
        L5b:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L6d
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L6d
            if (r9 == 0) goto L70
            java.lang.Object r9 = r5.next()     // Catch: java.lang.Throwable -> L6d
            r3 = r0
            r0 = r9
            r9 = r3
            r3 = r5
            r5 = r6
            goto L46
        L6d:
            r9 = move-exception
            r2 = r6
            goto L84
        L70:
            r6.e(r2)
            return r3
        L74:
            r9 = move-exception
            r2 = r3
            goto L84
        L77:
            java.util.NoSuchElementException r9 = new java.util.NoSuchElementException     // Catch: java.lang.Throwable -> L74
            java.lang.String r0 = "ReceiveChannel is empty."
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L74
            throw r9     // Catch: java.lang.Throwable -> L74
        L7f:
            kotlin.ResultKt.b(r9)
            throw r2     // Catch: java.lang.Throwable -> L83
        L83:
            r9 = move-exception
        L84:
            throw r9     // Catch: java.lang.Throwable -> L85
        L85:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.a(r2, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$last$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

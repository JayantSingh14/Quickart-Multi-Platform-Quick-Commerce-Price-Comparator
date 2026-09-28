package kotlinx.coroutines.channels;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {464, 466}, m = "minWith")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$minWith$1<E> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Comparator f54369a;

    /* renamed from: b, reason: collision with root package name */
    public ReceiveChannel f54370b;

    /* renamed from: c, reason: collision with root package name */
    public ChannelIterator f54371c;

    /* renamed from: d, reason: collision with root package name */
    public Object f54372d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f54373e;

    /* renamed from: f, reason: collision with root package name */
    public int f54374f;

    /* JADX WARN: Removed duplicated region for block: B:23:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0070 A[Catch: all -> 0x0084, TRY_LEAVE, TryCatch #2 {all -> 0x0084, blocks: (B:25:0x0068, B:27:0x0070), top: B:49:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0087  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0061 -> B:49:0x0068). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            r10.f54373e = r11
            int r0 = r10.f54374f
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            int r0 = r0 - r1
            r10.f54374f = r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            r2 = 0
            if (r0 == 0) goto L8e
            r3 = 1
            r4 = 2
            if (r0 == r3) goto L32
            if (r0 != r4) goto L2a
            java.lang.Object r0 = r10.f54372d
            kotlinx.coroutines.channels.ChannelIterator r3 = r10.f54371c
            kotlinx.coroutines.channels.ReceiveChannel r5 = r10.f54370b
            java.util.Comparator r6 = r10.f54369a
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L26
            r7 = r6
            r6 = r5
            r5 = r3
            r3 = r0
            r0 = r10
            goto L68
        L26:
            r11 = move-exception
            r2 = r5
            goto L93
        L2a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L32:
            kotlinx.coroutines.channels.ChannelIterator r0 = r10.f54371c
            kotlinx.coroutines.channels.ReceiveChannel r3 = r10.f54370b
            java.util.Comparator r5 = r10.f54369a
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L8b
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch: java.lang.Throwable -> L8b
            boolean r11 = r11.booleanValue()     // Catch: java.lang.Throwable -> L8b
            if (r11 != 0) goto L47
            r3.e(r2)
            return r2
        L47:
            java.lang.Object r11 = r0.next()     // Catch: java.lang.Throwable -> L8b
            r6 = r5
            r5 = r3
            r3 = r0
            r0 = r11
            r11 = r10
        L50:
            r11.f54369a = r6     // Catch: java.lang.Throwable -> L26
            r11.f54370b = r5     // Catch: java.lang.Throwable -> L26
            r11.f54371c = r3     // Catch: java.lang.Throwable -> L26
            r11.f54372d = r0     // Catch: java.lang.Throwable -> L26
            r11.f54374f = r4     // Catch: java.lang.Throwable -> L26
            java.lang.Object r7 = r3.b(r11)     // Catch: java.lang.Throwable -> L26
            if (r7 != r1) goto L61
            return r1
        L61:
            r9 = r0
            r0 = r11
            r11 = r7
            r7 = r6
            r6 = r5
            r5 = r3
            r3 = r9
        L68:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch: java.lang.Throwable -> L84
            boolean r11 = r11.booleanValue()     // Catch: java.lang.Throwable -> L84
            if (r11 == 0) goto L87
            java.lang.Object r11 = r5.next()     // Catch: java.lang.Throwable -> L84
            int r8 = r7.compare(r3, r11)     // Catch: java.lang.Throwable -> L84
            if (r8 <= 0) goto L81
            r3 = r0
            r0 = r11
            r11 = r3
        L7d:
            r3 = r5
            r5 = r6
            r6 = r7
            goto L50
        L81:
            r11 = r0
            r0 = r3
            goto L7d
        L84:
            r11 = move-exception
            r2 = r6
            goto L93
        L87:
            r6.e(r2)
            return r3
        L8b:
            r11 = move-exception
            r2 = r3
            goto L93
        L8e:
            kotlin.ResultKt.b(r11)
            throw r2     // Catch: java.lang.Throwable -> L92
        L92:
            r11 = move-exception
        L93:
            throw r11     // Catch: java.lang.Throwable -> L94
        L94:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.a(r2, r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

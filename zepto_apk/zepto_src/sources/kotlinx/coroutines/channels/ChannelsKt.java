package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata
/* loaded from: classes3.dex */
public final class ChannelsKt {
    public static final void a(ReceiveChannel receiveChannel, Throwable th) {
        if (th != null) {
            cancellationExceptionA = th instanceof CancellationException ? (CancellationException) th : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = ExceptionsKt.a("Channel was consumed, consumer had failed", th);
            }
        }
        receiveChannel.e(cancellationExceptionA);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
    
        if (r2.o(r8, r0) == r1) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:13:0x002c, B:28:0x0062, B:30:0x006a, B:33:0x007d, B:20:0x0043), top: B:42:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007d A[Catch: all -> 0x0033, TRY_LEAVE, TryCatch #0 {all -> 0x0033, blocks: (B:13:0x002c, B:28:0x0062, B:30:0x006a, B:33:0x007d, B:20:0x0043), top: B:42:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlinx.coroutines.channels.ProducerScope] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007a -> B:14:0x002f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(kotlinx.coroutines.channels.ReceiveChannel r6, kotlinx.coroutines.channels.ProducerScope r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1) r0
            int r1 = r0.f54397e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f54397e = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f54396d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f54397e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            kotlinx.coroutines.channels.ChannelIterator r6 = r0.f54395c
            kotlinx.coroutines.channels.ReceiveChannel r7 = r0.f54394b
            kotlinx.coroutines.channels.SendChannel r2 = r0.f54393a
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L33
        L2f:
            r8 = r6
            r6 = r7
            r7 = r2
            goto L4e
        L33:
            r6 = move-exception
            goto L88
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlinx.coroutines.channels.ChannelIterator r6 = r0.f54395c
            kotlinx.coroutines.channels.ReceiveChannel r7 = r0.f54394b
            kotlinx.coroutines.channels.SendChannel r2 = r0.f54393a
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L33
            goto L62
        L47:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch: java.lang.Throwable -> L84
        L4e:
            r0.f54393a = r7     // Catch: java.lang.Throwable -> L84
            r0.f54394b = r6     // Catch: java.lang.Throwable -> L84
            r0.f54395c = r8     // Catch: java.lang.Throwable -> L84
            r0.f54397e = r4     // Catch: java.lang.Throwable -> L84
            java.lang.Object r2 = r8.b(r0)     // Catch: java.lang.Throwable -> L84
            if (r2 != r1) goto L5d
            goto L7c
        L5d:
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r2
            r2 = r5
        L62:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L33
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L33
            if (r8 == 0) goto L7d
            java.lang.Object r8 = r6.next()     // Catch: java.lang.Throwable -> L33
            r0.f54393a = r2     // Catch: java.lang.Throwable -> L33
            r0.f54394b = r7     // Catch: java.lang.Throwable -> L33
            r0.f54395c = r6     // Catch: java.lang.Throwable -> L33
            r0.f54397e = r3     // Catch: java.lang.Throwable -> L33
            java.lang.Object r8 = r2.o(r8, r0)     // Catch: java.lang.Throwable -> L33
            if (r8 != r1) goto L2f
        L7c:
            return r1
        L7d:
            kotlin.Unit r6 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L33
            r6 = 0
            r7.e(r6)
            return r2
        L84:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L88:
            throw r6     // Catch: java.lang.Throwable -> L89
        L89:
            r8 = move-exception
            a(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt.b(kotlinx.coroutines.channels.ReceiveChannel, kotlinx.coroutines.channels.ProducerScope, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final void c(SendChannel sendChannel, Object obj) {
        Object objI = sendChannel.i(obj);
        if (objI instanceof ChannelResult.Failed) {
            Object obj2 = ((ChannelResult) BuildersKt.d(new ChannelsKt__ChannelsKt$trySendBlocking$2(sendChannel, obj, null))).f54255a;
            return;
        }
        ChannelResult.Failed failed = ChannelResult.f54254b;
        Unit unit = Unit.f53572a;
    }
}

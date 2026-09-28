package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.SendChannel;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {514, 272}, m = "filterNotNullTo")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$filterNotNullTo$3<E, C extends SendChannel<? super E>> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public SendChannel f54319a;

    /* renamed from: b, reason: collision with root package name */
    public ReceiveChannel f54320b;

    /* renamed from: c, reason: collision with root package name */
    public ChannelIterator f54321c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54322d;

    /* renamed from: e, reason: collision with root package name */
    public int f54323e;

    /* JADX WARN: Path cross not found for [B:20:0x0043, B:23:0x0052], limit reached: 42 */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0035 A[Catch: all -> 0x0020, PHI: r0 r5 r6 r7 r9
      0x0035: PHI (r0v5 kotlinx.coroutines.channels.ChannelIterator) = (r0v4 kotlinx.coroutines.channels.ChannelIterator), (r0v6 kotlinx.coroutines.channels.ChannelIterator) binds: [B:15:0x0031, B:24:0x005e] A[DONT_GENERATE, DONT_INLINE]
      0x0035: PHI (r5v2 kotlinx.coroutines.channels.ReceiveChannel) = (r5v1 kotlinx.coroutines.channels.ReceiveChannel), (r5v3 kotlinx.coroutines.channels.ReceiveChannel) binds: [B:15:0x0031, B:24:0x005e] A[DONT_GENERATE, DONT_INLINE]
      0x0035: PHI (r6v1 kotlinx.coroutines.channels.SendChannel) = (r6v0 kotlinx.coroutines.channels.SendChannel), (r6v2 kotlinx.coroutines.channels.SendChannel) binds: [B:15:0x0031, B:24:0x005e] A[DONT_GENERATE, DONT_INLINE]
      0x0035: PHI (r7v1 kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3<E, C extends kotlinx.coroutines.channels.SendChannel<? super E>>) = 
      (r7v0 kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3<E, C extends kotlinx.coroutines.channels.SendChannel<? super E>>)
      (r7v2 kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3<E, C extends kotlinx.coroutines.channels.SendChannel<? super E>>)
     binds: [B:15:0x0031, B:24:0x005e] A[DONT_GENERATE, DONT_INLINE]
      0x0035: PHI (r9v4 java.lang.Object) = (r9v0 java.lang.Object), (r9v10 java.lang.Object) binds: [B:15:0x0031, B:24:0x005e] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0020, blocks: (B:8:0x001b, B:23:0x0052, B:16:0x0035, B:18:0x003d, B:20:0x0043, B:26:0x0061, B:15:0x0031), top: B:36:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003d A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x001b, B:23:0x0052, B:16:0x0035, B:18:0x003d, B:20:0x0043, B:26:0x0061, B:15:0x0031), top: B:36:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0061 A[Catch: all -> 0x0020, TRY_LEAVE, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x001b, B:23:0x0052, B:16:0x0035, B:18:0x003d, B:20:0x0043, B:26:0x0061, B:15:0x0031), top: B:36:0x0011 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0041 -> B:23:0x0052). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x004f -> B:23:0x0052). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            r8.f54322d = r9
            int r0 = r8.f54323e
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            int r0 = r0 - r1
            r8.f54323e = r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            r2 = 0
            if (r0 == 0) goto L67
            r3 = 2
            r4 = 1
            if (r0 == r4) goto L2b
            if (r0 != r3) goto L23
            kotlinx.coroutines.channels.ChannelIterator r0 = r8.f54321c
            kotlinx.coroutines.channels.ReceiveChannel r5 = r8.f54320b
            kotlinx.coroutines.channels.SendChannel r6 = r8.f54319a
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L20
            r7 = r8
            goto L52
        L20:
            r9 = move-exception
            r2 = r5
            goto L6c
        L23:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L2b:
            kotlinx.coroutines.channels.ChannelIterator r0 = r8.f54321c
            kotlinx.coroutines.channels.ReceiveChannel r5 = r8.f54320b
            kotlinx.coroutines.channels.SendChannel r6 = r8.f54319a
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L20
            r7 = r8
        L35:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L20
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L20
            if (r9 == 0) goto L61
            java.lang.Object r9 = r0.next()     // Catch: java.lang.Throwable -> L20
            if (r9 == 0) goto L52
            r7.f54319a = r6     // Catch: java.lang.Throwable -> L20
            r7.f54320b = r5     // Catch: java.lang.Throwable -> L20
            r7.f54321c = r0     // Catch: java.lang.Throwable -> L20
            r7.f54323e = r3     // Catch: java.lang.Throwable -> L20
            java.lang.Object r9 = r6.o(r9, r7)     // Catch: java.lang.Throwable -> L20
            if (r9 != r1) goto L52
            goto L60
        L52:
            r7.f54319a = r6     // Catch: java.lang.Throwable -> L20
            r7.f54320b = r5     // Catch: java.lang.Throwable -> L20
            r7.f54321c = r0     // Catch: java.lang.Throwable -> L20
            r7.f54323e = r4     // Catch: java.lang.Throwable -> L20
            java.lang.Object r9 = r0.b(r7)     // Catch: java.lang.Throwable -> L20
            if (r9 != r1) goto L35
        L60:
            return r1
        L61:
            kotlin.Unit r9 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L20
            r5.e(r2)
            return r6
        L67:
            kotlin.ResultKt.b(r9)
            throw r2     // Catch: java.lang.Throwable -> L6b
        L6b:
            r9 = move-exception
        L6c:
            throw r9     // Catch: java.lang.Throwable -> L6d
        L6d:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.a(r2, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

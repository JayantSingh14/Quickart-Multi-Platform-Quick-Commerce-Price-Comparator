package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", l = {514, 363, 363}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$map$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Function2 f54352a;

    /* renamed from: b, reason: collision with root package name */
    public ReceiveChannel f54353b;

    /* renamed from: c, reason: collision with root package name */
    public ChannelIterator f54354c;

    /* renamed from: d, reason: collision with root package name */
    public ProducerScope f54355d;

    /* renamed from: e, reason: collision with root package name */
    public int f54356e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f54357f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__DeprecatedKt$map$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004a A[Catch: all -> 0x001f, PHI: r1 r6 r7 r8 r11
      0x004a: PHI (r1v4 kotlinx.coroutines.channels.ChannelIterator) = (r1v1 kotlinx.coroutines.channels.ChannelIterator), (r1v6 kotlinx.coroutines.channels.ChannelIterator) binds: [B:21:0x0047, B:33:0x0093] A[DONT_GENERATE, DONT_INLINE]
      0x004a: PHI (r6v6 kotlinx.coroutines.channels.ReceiveChannel) = (r6v2 kotlinx.coroutines.channels.ReceiveChannel), (r6v8 kotlinx.coroutines.channels.ReceiveChannel) binds: [B:21:0x0047, B:33:0x0093] A[DONT_GENERATE, DONT_INLINE]
      0x004a: PHI (r7v4 kotlin.jvm.functions.Function2) = (r7v0 kotlin.jvm.functions.Function2), (r7v6 kotlin.jvm.functions.Function2) binds: [B:21:0x0047, B:33:0x0093] A[DONT_GENERATE, DONT_INLINE]
      0x004a: PHI (r8v4 kotlinx.coroutines.channels.ProducerScope) = (r8v1 kotlinx.coroutines.channels.ProducerScope), (r8v6 kotlinx.coroutines.channels.ProducerScope) binds: [B:21:0x0047, B:33:0x0093] A[DONT_GENERATE, DONT_INLINE]
      0x004a: PHI (r11v8 java.lang.Object) = (r11v0 java.lang.Object), (r11v15 java.lang.Object) binds: [B:21:0x0047, B:33:0x0093] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {all -> 0x001f, blocks: (B:9:0x001a, B:32:0x0085, B:22:0x004a, B:24:0x0052, B:35:0x0096, B:21:0x0047), top: B:48:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0052 A[Catch: all -> 0x001f, TRY_LEAVE, TryCatch #2 {all -> 0x001f, blocks: (B:9:0x001a, B:32:0x0085, B:22:0x004a, B:24:0x0052, B:35:0x0096, B:21:0x0047), top: B:48:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0096 A[Catch: all -> 0x001f, TRY_LEAVE, TryCatch #2 {all -> 0x001f, blocks: (B:9:0x001a, B:32:0x0085, B:22:0x004a, B:24:0x0052, B:35:0x0096, B:21:0x0047), top: B:48:0x000a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0081 -> B:32:0x0085). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r10.f54356e
            r2 = 0
            if (r1 == 0) goto La4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == r5) goto L3d
            if (r1 == r4) goto L2a
            if (r1 != r3) goto L22
            kotlinx.coroutines.channels.ChannelIterator r1 = r10.f54354c
            kotlinx.coroutines.channels.ReceiveChannel r6 = r10.f54353b
            kotlin.jvm.functions.Function2 r7 = r10.f54352a
            java.lang.Object r8 = r10.f54357f
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L1f
            goto L85
        L1f:
            r11 = move-exception
            goto L9e
        L22:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L2a:
            kotlinx.coroutines.channels.ProducerScope r1 = r10.f54355d
            kotlinx.coroutines.channels.ChannelIterator r6 = r10.f54354c
            kotlinx.coroutines.channels.ReceiveChannel r7 = r10.f54353b
            kotlin.jvm.functions.Function2 r8 = r10.f54352a
            java.lang.Object r9 = r10.f54357f
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L3a
            goto L6e
        L3a:
            r11 = move-exception
            r6 = r7
            goto L9e
        L3d:
            kotlinx.coroutines.channels.ChannelIterator r1 = r10.f54354c
            kotlinx.coroutines.channels.ReceiveChannel r6 = r10.f54353b
            kotlin.jvm.functions.Function2 r7 = r10.f54352a
            java.lang.Object r8 = r10.f54357f
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L1f
        L4a:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch: java.lang.Throwable -> L1f
            boolean r11 = r11.booleanValue()     // Catch: java.lang.Throwable -> L1f
            if (r11 == 0) goto L96
            java.lang.Object r11 = r1.next()     // Catch: java.lang.Throwable -> L1f
            r10.f54357f = r8     // Catch: java.lang.Throwable -> L1f
            r10.f54352a = r7     // Catch: java.lang.Throwable -> L1f
            r10.f54353b = r6     // Catch: java.lang.Throwable -> L1f
            r10.f54354c = r1     // Catch: java.lang.Throwable -> L1f
            r10.f54355d = r8     // Catch: java.lang.Throwable -> L1f
            r10.f54356e = r4     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r11 = r7.invoke(r11, r10)     // Catch: java.lang.Throwable -> L1f
            if (r11 != r0) goto L69
            goto L95
        L69:
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r9
        L6e:
            r10.f54357f = r9     // Catch: java.lang.Throwable -> L3a
            r10.f54352a = r8     // Catch: java.lang.Throwable -> L3a
            r10.f54353b = r7     // Catch: java.lang.Throwable -> L3a
            r10.f54354c = r6     // Catch: java.lang.Throwable -> L3a
            r10.f54355d = r2     // Catch: java.lang.Throwable -> L3a
            r10.f54356e = r3     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r11 = r1.o(r11, r10)     // Catch: java.lang.Throwable -> L3a
            if (r11 != r0) goto L81
            goto L95
        L81:
            r1 = r6
            r6 = r7
            r7 = r8
            r8 = r9
        L85:
            r10.f54357f = r8     // Catch: java.lang.Throwable -> L1f
            r10.f54352a = r7     // Catch: java.lang.Throwable -> L1f
            r10.f54353b = r6     // Catch: java.lang.Throwable -> L1f
            r10.f54354c = r1     // Catch: java.lang.Throwable -> L1f
            r10.f54356e = r5     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r11 = r1.b(r10)     // Catch: java.lang.Throwable -> L1f
            if (r11 != r0) goto L4a
        L95:
            return r0
        L96:
            kotlin.Unit r11 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L1f
            r6.e(r2)
            kotlin.Unit r11 = kotlin.Unit.f53572a
            return r11
        L9e:
            throw r11     // Catch: java.lang.Throwable -> L9f
        L9f:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.a(r6, r11)
            throw r0
        La4:
            kotlin.ResultKt.b(r11)
            java.lang.Object r11 = r10.f54357f
            kotlinx.coroutines.channels.ProducerScope r11 = (kotlinx.coroutines.channels.ProducerScope) r11
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

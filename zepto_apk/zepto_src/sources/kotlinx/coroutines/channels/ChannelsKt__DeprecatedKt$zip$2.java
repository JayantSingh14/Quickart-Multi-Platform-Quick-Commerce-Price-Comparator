package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", l = {514, 499, 501}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$zip$2 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public ChannelIterator f54412a;

    /* renamed from: b, reason: collision with root package name */
    public Function2 f54413b;

    /* renamed from: c, reason: collision with root package name */
    public ReceiveChannel f54414c;

    /* renamed from: d, reason: collision with root package name */
    public ChannelIterator f54415d;

    /* renamed from: e, reason: collision with root package name */
    public Object f54416e;

    /* renamed from: f, reason: collision with root package name */
    public int f54417f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f54418g;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__DeprecatedKt$zip$2) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a5, code lost:
    
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054 A[Catch: all -> 0x0021, PHI: r1 r6 r7 r8 r9 r13
      0x0054: PHI (r1v3 kotlinx.coroutines.channels.ChannelIterator) = (r1v1 kotlinx.coroutines.channels.ChannelIterator), (r1v4 kotlinx.coroutines.channels.ChannelIterator) binds: [B:21:0x0051, B:35:0x00b7] A[DONT_GENERATE, DONT_INLINE]
      0x0054: PHI (r6v7 kotlinx.coroutines.channels.ReceiveChannel) = (r6v2 kotlinx.coroutines.channels.ReceiveChannel), (r6v9 kotlinx.coroutines.channels.ReceiveChannel) binds: [B:21:0x0051, B:35:0x00b7] A[DONT_GENERATE, DONT_INLINE]
      0x0054: PHI (r7v5 kotlin.jvm.functions.Function2) = (r7v0 kotlin.jvm.functions.Function2), (r7v7 kotlin.jvm.functions.Function2) binds: [B:21:0x0051, B:35:0x00b7] A[DONT_GENERATE, DONT_INLINE]
      0x0054: PHI (r8v4 kotlinx.coroutines.channels.ChannelIterator) = (r8v0 kotlinx.coroutines.channels.ChannelIterator), (r8v6 kotlinx.coroutines.channels.ChannelIterator) binds: [B:21:0x0051, B:35:0x00b7] A[DONT_GENERATE, DONT_INLINE]
      0x0054: PHI (r9v5 kotlinx.coroutines.channels.ProducerScope) = (r9v1 kotlinx.coroutines.channels.ProducerScope), (r9v7 kotlinx.coroutines.channels.ProducerScope) binds: [B:21:0x0051, B:35:0x00b7] A[DONT_GENERATE, DONT_INLINE]
      0x0054: PHI (r13v12 java.lang.Object) = (r13v0 java.lang.Object), (r13v19 java.lang.Object) binds: [B:21:0x0051, B:35:0x00b7] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {all -> 0x0021, blocks: (B:9:0x001c, B:34:0x00a5, B:22:0x0054, B:24:0x005c, B:37:0x00ba, B:21:0x0051), top: B:48:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c A[Catch: all -> 0x0021, TRY_LEAVE, TryCatch #1 {all -> 0x0021, blocks: (B:9:0x001c, B:34:0x00a5, B:22:0x0054, B:24:0x005c, B:37:0x00ba, B:21:0x0051), top: B:48:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084 A[Catch: all -> 0x0041, TRY_LEAVE, TryCatch #0 {all -> 0x0041, blocks: (B:28:0x007c, B:30:0x0084, B:16:0x003a), top: B:46:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba A[Catch: all -> 0x0021, TRY_LEAVE, TryCatch #1 {all -> 0x0021, blocks: (B:9:0x001c, B:34:0x00a5, B:22:0x0054, B:24:0x005c, B:37:0x00ba, B:21:0x0051), top: B:48:0x000a }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

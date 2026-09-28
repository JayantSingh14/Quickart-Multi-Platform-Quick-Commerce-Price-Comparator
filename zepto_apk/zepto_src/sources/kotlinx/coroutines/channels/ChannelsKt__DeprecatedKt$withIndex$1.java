package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", l = {400, 401}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$withIndex$1 extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public ChannelIterator f54408a;

    /* renamed from: b, reason: collision with root package name */
    public int f54409b;

    /* renamed from: c, reason: collision with root package name */
    public int f54410c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54411d;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__DeprecatedKt$withIndex$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b A[PHI: r1 r4 r5 r9
      0x002b: PHI (r1v2 int) = (r1v1 int), (r1v4 int) binds: [B:10:0x0020, B:18:0x005a] A[DONT_GENERATE, DONT_INLINE]
      0x002b: PHI (r4v1 kotlinx.coroutines.channels.ChannelIterator) = (r4v0 kotlinx.coroutines.channels.ChannelIterator), (r4v2 kotlinx.coroutines.channels.ChannelIterator) binds: [B:10:0x0020, B:18:0x005a] A[DONT_GENERATE, DONT_INLINE]
      0x002b: PHI (r5v2 kotlinx.coroutines.channels.ProducerScope) = (r5v1 kotlinx.coroutines.channels.ProducerScope), (r5v3 kotlinx.coroutines.channels.ProducerScope) binds: [B:10:0x0020, B:18:0x005a] A[DONT_GENERATE, DONT_INLINE]
      0x002b: PHI (r9v4 java.lang.Object) = (r9v0 java.lang.Object), (r9v10 java.lang.Object) binds: [B:10:0x0020, B:18:0x005a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004d -> B:17:0x004e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r8.f54410c
            if (r1 == 0) goto L60
            r2 = 1
            r3 = 2
            if (r1 == r2) goto L20
            if (r1 != r3) goto L18
            int r1 = r8.f54409b
            kotlinx.coroutines.channels.ChannelIterator r4 = r8.f54408a
            java.lang.Object r5 = r8.f54411d
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.b(r9)
            goto L4e
        L18:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L20:
            int r1 = r8.f54409b
            kotlinx.coroutines.channels.ChannelIterator r4 = r8.f54408a
            java.lang.Object r5 = r8.f54411d
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.b(r9)
        L2b:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L5d
            java.lang.Object r9 = r4.next()
            kotlin.collections.IndexedValue r6 = new kotlin.collections.IndexedValue
            int r7 = r1 + 1
            r6.<init>(r1, r9)
            r8.f54411d = r5
            r8.f54408a = r4
            r8.f54409b = r7
            r8.f54410c = r3
            java.lang.Object r9 = r5.o(r6, r8)
            if (r9 != r0) goto L4d
            goto L5c
        L4d:
            r1 = r7
        L4e:
            r8.f54411d = r5
            r8.f54408a = r4
            r8.f54409b = r1
            r8.f54410c = r2
            java.lang.Object r9 = r4.b(r8)
            if (r9 != r0) goto L2b
        L5c:
            return r0
        L5d:
            kotlin.Unit r9 = kotlin.Unit.f53572a
            return r9
        L60:
            kotlin.ResultKt.b(r9)
            java.lang.Object r9 = r8.f54411d
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

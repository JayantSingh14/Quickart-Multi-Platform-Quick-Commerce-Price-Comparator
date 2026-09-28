package androidx.collection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequenceScope;

@Metadata
@DebugMetadata(c = "androidx.collection.MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1", f = "ScatterMap.kt", l = {1431}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public long[] f1512b;

    /* renamed from: c, reason: collision with root package name */
    public int f1513c;

    /* renamed from: d, reason: collision with root package name */
    public int f1514d;

    /* renamed from: e, reason: collision with root package name */
    public int f1515e;

    /* renamed from: f, reason: collision with root package name */
    public int f1516f;

    /* renamed from: g, reason: collision with root package name */
    public long f1517g;

    /* renamed from: h, reason: collision with root package name */
    public int f1518h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f1519i;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1 mutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1 = new MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1(2, continuation);
        mutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1.f1519i = obj;
        return mutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005e, code lost:
    
        r3 = 8 - ((~(r6 - r7)) >>> 31);
        r2 = 0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            r0 = 1
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r14.f1518h
            if (r2 == 0) goto L72
            if (r2 != r0) goto L6a
            int r2 = r14.f1516f
            int r3 = r14.f1515e
            long r4 = r14.f1517g
            int r6 = r14.f1514d
            int r7 = r14.f1513c
            long[] r8 = r14.f1512b
            java.lang.Object r9 = r14.f1519i
            kotlin.sequences.SequenceScope r9 = (kotlin.sequences.SequenceScope) r9
            kotlin.ResultKt.b(r15)
        L1c:
            r15 = 8
            long r4 = r4 >> r15
            int r2 = r2 + r0
        L20:
            if (r2 >= r3) goto L49
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r4
            r12 = 128(0x80, double:6.32E-322)
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 >= 0) goto L1c
            int r15 = r6 << 3
            int r15 = r15 + r2
            java.lang.Integer r10 = new java.lang.Integer
            r10.<init>(r15)
            r14.f1519i = r9
            r14.f1512b = r8
            r14.f1513c = r7
            r14.f1514d = r6
            r14.f1517g = r4
            r14.f1515e = r3
            r14.f1516f = r2
            r14.f1518h = r0
            r9.a(r10, r14)
            kotlin.coroutines.intrinsics.CoroutineSingletons r15 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            return r1
        L49:
            if (r3 != r15) goto L67
        L4b:
            if (r6 == r7) goto L67
            int r6 = r6 + r0
            r4 = r8[r6]
            long r2 = ~r4
            r10 = 7
            long r2 = r2 << r10
            long r2 = r2 & r4
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r2 = r2 & r10
            int r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r2 == 0) goto L4b
            int r2 = r6 - r7
            int r2 = ~r2
            int r2 = r2 >>> 31
            int r3 = 8 - r2
            r2 = 0
            goto L20
        L67:
            kotlin.Unit r15 = kotlin.Unit.f53572a
            return r15
        L6a:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L72:
            kotlin.ResultKt.b(r15)
            java.lang.Object r15 = r14.f1519i
            kotlin.sequences.SequenceScope r15 = (kotlin.sequences.SequenceScope) r15
            r15 = 0
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

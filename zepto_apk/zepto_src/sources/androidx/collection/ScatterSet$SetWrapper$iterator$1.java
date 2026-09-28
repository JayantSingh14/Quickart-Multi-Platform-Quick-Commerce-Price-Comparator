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
@DebugMetadata(c = "androidx.collection.ScatterSet$SetWrapper$iterator$1", f = "ScatterSet.kt", l = {495}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ScatterSet$SetWrapper$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<Object>, Continuation<? super Unit>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public Object[] f1593b;

    /* renamed from: c, reason: collision with root package name */
    public long[] f1594c;

    /* renamed from: d, reason: collision with root package name */
    public int f1595d;

    /* renamed from: e, reason: collision with root package name */
    public int f1596e;

    /* renamed from: f, reason: collision with root package name */
    public int f1597f;

    /* renamed from: g, reason: collision with root package name */
    public int f1598g;

    /* renamed from: h, reason: collision with root package name */
    public long f1599h;

    /* renamed from: i, reason: collision with root package name */
    public int f1600i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f1601j;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ScatterSet$SetWrapper$iterator$1 scatterSet$SetWrapper$iterator$1 = new ScatterSet$SetWrapper$iterator$1(2, continuation);
        scatterSet$SetWrapper$iterator$1.f1601j = obj;
        return scatterSet$SetWrapper$iterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ScatterSet$SetWrapper$iterator$1) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
    
        r4 = 8 - ((~(r7 - r8)) >>> 31);
        r3 = 0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = 1
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r3 = r0.f1600i
            if (r3 == 0) goto L75
            if (r3 != r1) goto L6d
            int r3 = r0.f1598g
            int r4 = r0.f1597f
            long r5 = r0.f1599h
            int r7 = r0.f1596e
            int r8 = r0.f1595d
            long[] r9 = r0.f1594c
            java.lang.Object[] r10 = r0.f1593b
            java.lang.Object r11 = r0.f1601j
            kotlin.sequences.SequenceScope r11 = (kotlin.sequences.SequenceScope) r11
            kotlin.ResultKt.b(r17)
        L20:
            r12 = 8
            long r5 = r5 >> r12
            int r3 = r3 + r1
        L24:
            if (r3 >= r4) goto L4c
            r12 = 255(0xff, double:1.26E-321)
            long r12 = r12 & r5
            r14 = 128(0x80, double:6.32E-322)
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 >= 0) goto L20
            int r12 = r7 << 3
            int r12 = r12 + r3
            r12 = r10[r12]
            r0.f1601j = r11
            r0.f1593b = r10
            r0.f1594c = r9
            r0.f1595d = r8
            r0.f1596e = r7
            r0.f1599h = r5
            r0.f1597f = r4
            r0.f1598g = r3
            r0.f1600i = r1
            r11.a(r12, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            return r2
        L4c:
            if (r4 != r12) goto L6a
        L4e:
            if (r7 == r8) goto L6a
            int r7 = r7 + r1
            r5 = r9[r7]
            long r3 = ~r5
            r13 = 7
            long r3 = r3 << r13
            long r3 = r3 & r5
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r3 = r3 & r13
            int r3 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r3 == 0) goto L4e
            int r3 = r7 - r8
            int r3 = ~r3
            int r3 = r3 >>> 31
            int r4 = 8 - r3
            r3 = 0
            goto L24
        L6a:
            kotlin.Unit r1 = kotlin.Unit.f53572a
            return r1
        L6d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L75:
            kotlin.ResultKt.b(r17)
            java.lang.Object r1 = r0.f1601j
            kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterSet$SetWrapper$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

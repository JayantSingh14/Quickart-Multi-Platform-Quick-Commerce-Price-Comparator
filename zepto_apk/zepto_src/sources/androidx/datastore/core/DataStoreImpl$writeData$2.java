package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$writeData$2", f = "DataStoreImpl.kt", l = {352, 353}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class DataStoreImpl$writeData$2 extends SuspendLambda implements Function2<WriteScope<Object>, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Ref.IntRef f3535a;

    /* renamed from: b, reason: collision with root package name */
    public int f3536b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3537c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f3538d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl f3539e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f3540f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f3541g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$writeData$2(Ref.IntRef intRef, DataStoreImpl dataStoreImpl, Object obj, boolean z, Continuation continuation) {
        super(2, continuation);
        this.f3538d = intRef;
        this.f3539e = dataStoreImpl;
        this.f3540f = obj;
        this.f3541g = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DataStoreImpl$writeData$2 dataStoreImpl$writeData$2 = new DataStoreImpl$writeData$2(this.f3538d, this.f3539e, this.f3540f, this.f3541g, continuation);
        dataStoreImpl$writeData$2.f3537c = obj;
        return dataStoreImpl$writeData$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((DataStoreImpl$writeData$2) create((WriteScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0056, code lost:
    
        if (r6.d(r3, r7) == r0) goto L16;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r7.f3536b
            kotlin.jvm.internal.Ref$IntRef r2 = r7.f3538d
            java.lang.Object r3 = r7.f3540f
            androidx.datastore.core.DataStoreImpl r4 = r7.f3539e
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L28
            if (r1 == r6) goto L1e
            if (r1 != r5) goto L16
            kotlin.ResultKt.b(r8)
            goto L59
        L16:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1e:
            kotlin.jvm.internal.Ref$IntRef r1 = r7.f3535a
            java.lang.Object r6 = r7.f3537c
            androidx.datastore.core.WriteScope r6 = (androidx.datastore.core.WriteScope) r6
            kotlin.ResultKt.b(r8)
            goto L43
        L28:
            kotlin.ResultKt.b(r8)
            java.lang.Object r8 = r7.f3537c
            androidx.datastore.core.WriteScope r8 = (androidx.datastore.core.WriteScope) r8
            androidx.datastore.core.InterProcessCoordinator r1 = r4.g()
            r7.f3537c = r8
            r7.f3535a = r2
            r7.f3536b = r6
            java.lang.Object r1 = r1.e(r7)
            if (r1 != r0) goto L40
            goto L58
        L40:
            r6 = r8
            r8 = r1
            r1 = r2
        L43:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r1.f53799a = r8
            r8 = 0
            r7.f3537c = r8
            r7.f3535a = r8
            r7.f3536b = r5
            java.lang.Object r8 = r6.d(r3, r7)
            if (r8 != r0) goto L59
        L58:
            return r0
        L59:
            boolean r8 = r7.f3541g
            if (r8 == 0) goto L71
            androidx.datastore.core.DataStoreInMemoryCache r8 = r4.f3403h
            androidx.datastore.core.Data r0 = new androidx.datastore.core.Data
            if (r3 == 0) goto L68
            int r1 = r3.hashCode()
            goto L69
        L68:
            r1 = 0
        L69:
            int r2 = r2.f53799a
            r0.<init>(r1, r2, r3)
            r8.b(r0)
        L71:
            kotlin.Unit r8 = kotlin.Unit.f53572a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$writeData$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

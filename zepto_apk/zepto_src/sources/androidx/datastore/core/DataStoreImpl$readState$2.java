package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$readState$2", f = "DataStoreImpl.kt", l = {218, 226}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class DataStoreImpl$readState$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super State<Object>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f3511a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DataStoreImpl f3512b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readState$2(DataStoreImpl dataStoreImpl, Continuation continuation) {
        super(2, continuation);
        this.f3512b = dataStoreImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DataStoreImpl$readState$2(this.f3512b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((DataStoreImpl$readState$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        if (r6 == r0) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r5.f3511a
            r2 = 2
            r3 = 1
            androidx.datastore.core.DataStoreImpl r4 = r5.f3512b
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r6)
            goto L47
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L1e
            goto L3d
        L1e:
            r6 = move-exception
            goto L4a
        L20:
            kotlin.ResultKt.b(r6)
            androidx.datastore.core.DataStoreInMemoryCache r6 = r4.f3403h
            androidx.datastore.core.State r6 = r6.a()
            boolean r6 = r6 instanceof androidx.datastore.core.Final
            if (r6 == 0) goto L34
            androidx.datastore.core.DataStoreInMemoryCache r6 = r4.f3403h
            androidx.datastore.core.State r6 = r6.a()
            return r6
        L34:
            r5.f3511a = r3     // Catch: java.lang.Throwable -> L1e
            java.lang.Object r6 = r4.h(r5)     // Catch: java.lang.Throwable -> L1e
            if (r6 != r0) goto L3d
            goto L46
        L3d:
            r5.f3511a = r2
            r6 = 0
            java.lang.Object r6 = androidx.datastore.core.DataStoreImpl.e(r4, r6, r5)
            if (r6 != r0) goto L47
        L46:
            return r0
        L47:
            androidx.datastore.core.State r6 = (androidx.datastore.core.State) r6
            return r6
        L4a:
            androidx.datastore.core.ReadException r0 = new androidx.datastore.core.ReadException
            r1 = -1
            r0.<init>(r1, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$readState$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

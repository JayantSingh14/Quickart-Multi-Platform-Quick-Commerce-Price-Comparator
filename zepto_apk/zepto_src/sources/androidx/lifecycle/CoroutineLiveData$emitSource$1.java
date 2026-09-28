package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "androidx.lifecycle.CoroutineLiveData", f = "CoroutineLiveData.kt", l = {228, 229}, m = "emitSource$lifecycle_livedata_release")
/* loaded from: classes3.dex */
final class CoroutineLiveData$emitSource$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public CoroutineLiveData f4780a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f4781b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CoroutineLiveData f4782c;

    /* renamed from: d, reason: collision with root package name */
    public int f4783d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineLiveData$emitSource$1(CoroutineLiveData coroutineLiveData, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f4782c = coroutineLiveData;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        if (r1 == r2) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            r6.f4781b = r7
            int r7 = r6.f4783d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r7 | r0
            r6.f4783d = r7
            androidx.lifecycle.CoroutineLiveData r7 = r6.f4782c
            r7.getClass()
            int r1 = r6.f4783d
            r2 = r1 & r0
            if (r2 == 0) goto L19
            int r1 = r1 - r0
            r6.f4783d = r1
            r0 = r6
            goto L1e
        L19:
            androidx.lifecycle.CoroutineLiveData$emitSource$1 r0 = new androidx.lifecycle.CoroutineLiveData$emitSource$1
            r0.<init>(r7, r6)
        L1e:
            java.lang.Object r1 = r0.f4781b
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r3 = r0.f4783d
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L40
            if (r3 == r5) goto L3a
            if (r3 != r4) goto L32
            androidx.lifecycle.CoroutineLiveData r7 = r0.f4780a
            kotlin.ResultKt.b(r1)
            goto L67
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3a:
            androidx.lifecycle.CoroutineLiveData r7 = r0.f4780a
            kotlin.ResultKt.b(r1)
            goto L4e
        L40:
            kotlin.ResultKt.b(r1)
            r0.f4780a = r7
            r0.f4783d = r5
            java.lang.Object r1 = r7.m(r0)
            if (r1 != r2) goto L4e
            goto L66
        L4e:
            r0.f4780a = r7
            r0.f4783d = r4
            kotlinx.coroutines.scheduling.DefaultScheduler r1 = kotlinx.coroutines.Dispatchers.f54091a
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.internal.MainDispatcherLoader.f55099a
            kotlinx.coroutines.MainCoroutineDispatcher r1 = r1.O1()
            androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2 r3 = new androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2
            r4 = 0
            r3.<init>(r7, r4, r4)
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.e(r1, r3, r0)
            if (r1 != r2) goto L67
        L66:
            return r2
        L67:
            androidx.lifecycle.EmittedSource r1 = (androidx.lifecycle.EmittedSource) r1
            r7.f4775m = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.CoroutineLiveData$emitSource$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

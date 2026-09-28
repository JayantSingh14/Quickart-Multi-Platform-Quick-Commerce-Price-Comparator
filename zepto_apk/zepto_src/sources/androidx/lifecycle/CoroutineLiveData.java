package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {

    /* renamed from: m, reason: collision with root package name */
    public EmittedSource f4775m;

    @Metadata
    /* renamed from: androidx.lifecycle.CoroutineLiveData$1, reason: invalid class name */
    final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            throw null;
        }
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    public final void g() {
        super.g();
        throw null;
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    public final void h() {
        super.h();
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(kotlin.coroutines.jvm.internal.ContinuationImpl r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.lifecycle.CoroutineLiveData$clearSource$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.lifecycle.CoroutineLiveData$clearSource$1 r0 = (androidx.lifecycle.CoroutineLiveData$clearSource$1) r0
            int r1 = r0.f4779d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4779d = r1
            goto L18
        L13:
            androidx.lifecycle.CoroutineLiveData$clearSource$1 r0 = new androidx.lifecycle.CoroutineLiveData$clearSource$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f4777b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f4779d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            androidx.lifecycle.CoroutineLiveData r0 = r0.f4776a
            kotlin.ResultKt.b(r6)
            goto L57
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L32:
            kotlin.ResultKt.b(r6)
            androidx.lifecycle.EmittedSource r6 = r5.f4775m
            if (r6 == 0) goto L56
            r0.f4776a = r5
            r0.f4779d = r4
            kotlinx.coroutines.scheduling.DefaultScheduler r2 = kotlinx.coroutines.Dispatchers.f54091a
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.internal.MainDispatcherLoader.f55099a
            kotlinx.coroutines.MainCoroutineDispatcher r2 = r2.O1()
            androidx.lifecycle.EmittedSource$disposeNow$2 r4 = new androidx.lifecycle.EmittedSource$disposeNow$2
            r4.<init>(r6, r3)
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.e(r2, r4, r0)
            if (r6 != r1) goto L51
            goto L53
        L51:
            kotlin.Unit r6 = kotlin.Unit.f53572a
        L53:
            if (r6 != r1) goto L56
            return r1
        L56:
            r0 = r5
        L57:
            r0.f4775m = r3
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.CoroutineLiveData.m(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}

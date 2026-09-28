package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DataStoreInMemoryCache<T> {

    /* renamed from: a, reason: collision with root package name */
    public final MutableStateFlow f3542a = StateFlowKt.a(UnInitialized.f3641b);

    public final State a() {
        return (State) this.f3542a.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(androidx.datastore.core.State r6) {
        /*
            r5 = this;
            java.lang.String r0 = "newState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlinx.coroutines.flow.MutableStateFlow r0 = r5.f3542a
        L7:
            java.lang.Object r1 = r0.getValue()
            r2 = r1
            androidx.datastore.core.State r2 = (androidx.datastore.core.State) r2
            boolean r3 = r2 instanceof androidx.datastore.core.ReadException
            if (r3 == 0) goto L14
            r3 = 1
            goto L1a
        L14:
            androidx.datastore.core.UnInitialized r3 = androidx.datastore.core.UnInitialized.f3641b
            boolean r3 = kotlin.jvm.internal.Intrinsics.b(r2, r3)
        L1a:
            if (r3 == 0) goto L1d
            goto L27
        L1d:
            boolean r3 = r2 instanceof androidx.datastore.core.Data
            if (r3 == 0) goto L29
            int r3 = r6.f3637a
            int r4 = r2.f3637a
            if (r3 <= r4) goto L2d
        L27:
            r2 = r6
            goto L2d
        L29:
            boolean r3 = r2 instanceof androidx.datastore.core.Final
            if (r3 == 0) goto L34
        L2d:
            boolean r1 = r0.e(r1, r2)
            if (r1 == 0) goto L7
            return
        L34:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreInMemoryCache.b(androidx.datastore.core.State):void");
    }
}

package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.BuildersKt;

@Metadata
/* loaded from: classes3.dex */
public final class LiveDataScopeImpl<T> implements LiveDataScope<T> {
    @Override // androidx.lifecycle.LiveDataScope
    public final Object a(Object obj, Continuation continuation) throws Throwable {
        Object objE = BuildersKt.e(null, new LiveDataScopeImpl$emit$2(this, obj, null), continuation);
        return objE == CoroutineSingletons.f53689a ? objE : Unit.f53572a;
    }
}

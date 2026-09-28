package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata
/* loaded from: classes.dex */
public final class OnTimeoutKt {
    public static final void a(SelectImplementation selectImplementation, long j2, Function1 function1) {
        OnTimeout onTimeout = new OnTimeout(j2);
        OnTimeout$selectClause$1 onTimeout$selectClause$1 = OnTimeout$selectClause$1.f55173b;
        TypeIntrinsics.b(3, onTimeout$selectClause$1);
        selectImplementation.j(new SelectClause0Impl(onTimeout, onTimeout$selectClause$1), function1);
    }
}

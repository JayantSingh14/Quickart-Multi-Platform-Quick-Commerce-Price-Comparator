package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class StateFlowKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Symbol f54926a = new Symbol("NONE");

    /* renamed from: b, reason: collision with root package name */
    public static final Symbol f54927b = new Symbol("PENDING");

    public static final MutableStateFlow a(Object obj) {
        if (obj == null) {
            obj = NullSurrogateKt.f55041a;
        }
        return new StateFlowImpl(obj);
    }
}

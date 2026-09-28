package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class TestScopeImpl$enter$exceptions$1$2 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ((TestScopeImpl) this.receiver).getClass();
        throw null;
    }
}

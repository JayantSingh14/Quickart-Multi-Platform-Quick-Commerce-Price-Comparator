package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@PublishedApi
@SourceDebugExtension
/* loaded from: classes3.dex */
public class UnbiasedSelectImplementation<R> extends SelectImplementation<R> {
    /* JADX WARN: Code restructure failed: missing block: B:8:?, code lost:
    
        throw null;
     */
    @Override // kotlinx.coroutines.selects.SelectImplementation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(kotlin.coroutines.Continuation r1) {
        /*
            r0 = this;
            r1 = 0
            java.util.Collections.shuffle(r1)     // Catch: java.lang.Throwable -> L5
            throw r1     // Catch: java.lang.Throwable -> L5
        L5:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.UnbiasedSelectImplementation.g(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation
    public final void j(SelectClause0Impl selectClause0Impl, Function1 function1) {
        Function3 function3 = SelectKt.f55205a;
        throw null;
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation
    public final void k(SelectClause1 selectClause1, Function2 function2) {
        throw null;
    }
}

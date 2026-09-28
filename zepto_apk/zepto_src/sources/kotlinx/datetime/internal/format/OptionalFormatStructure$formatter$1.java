package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class OptionalFormatStructure$formatter$1 extends FunctionReferenceImpl implements Function1<Object, Boolean> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Boolean.valueOf(((Predicate) this.receiver).test(obj));
    }
}

package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class StringFieldFormatDirective$formatter$1 extends FunctionReferenceImpl implements Function1<Object, String> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return (String) ((Accessor) this.receiver).b(obj);
    }
}

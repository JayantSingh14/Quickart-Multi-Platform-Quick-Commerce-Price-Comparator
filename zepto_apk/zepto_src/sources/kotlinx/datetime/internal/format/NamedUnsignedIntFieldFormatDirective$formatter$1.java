package kotlinx.datetime.internal.format;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class NamedUnsignedIntFieldFormatDirective$formatter$1 extends FunctionReferenceImpl implements Function1<Object, String> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NamedUnsignedIntFieldFormatDirective namedUnsignedIntFieldFormatDirective = (NamedUnsignedIntFieldFormatDirective) this.receiver;
        UnsignedFieldSpec unsignedFieldSpec = namedUnsignedIntFieldFormatDirective.f55544a;
        int iIntValue = ((Number) unsignedFieldSpec.f55563a.b(obj)).intValue();
        String str = (String) CollectionsKt.C(iIntValue - unsignedFieldSpec.f55564b, namedUnsignedIntFieldFormatDirective.f55545b);
        return str == null ? b.r(b.u(iIntValue, "The value ", " of "), unsignedFieldSpec.f55566d, " does not have a corresponding string representation") : str;
    }
}

package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.ToKotlinCodeKt;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class LocalDateFormatKt$toKotlinCode$1 extends FunctionReferenceImpl implements Function1<String, String> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String p0 = (String) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ToKotlinCodeKt.a(p0);
    }
}

package kotlinx.datetime.internal.format;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class SignedFormatStructure$formatter$1 extends FunctionReferenceImpl implements Function1<Object, Boolean> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SignedFormatStructure f55557b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignedFormatStructure$formatter$1(SignedFormatStructure signedFormatStructure) {
        super(1, Intrinsics.Kotlin.class, "checkIfAllNegative", "formatter$checkIfAllNegative(Lkotlinx/datetime/internal/format/SignedFormatStructure;Ljava/lang/Object;)Z", 0);
        this.f55557b = signedFormatStructure;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Iterator it = this.f55557b.f55556b.iterator();
        boolean z = false;
        boolean z2 = false;
        while (true) {
            if (!it.hasNext()) {
                z = z2;
                break;
            }
            FieldSign fieldSign = (FieldSign) it.next();
            if (Intrinsics.b(fieldSign.b().f55554a.get(obj), Boolean.TRUE)) {
                z2 = true;
            } else if (!fieldSign.a(obj)) {
                break;
            }
        }
        return Boolean.valueOf(z);
    }
}

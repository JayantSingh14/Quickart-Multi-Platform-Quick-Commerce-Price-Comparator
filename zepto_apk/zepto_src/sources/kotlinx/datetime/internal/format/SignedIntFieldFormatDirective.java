package kotlinx.datetime.internal.format;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.formatter.SignedIntFormatterStructure;
import kotlinx.datetime.internal.format.formatter.SpacePaddedFormatter;
import kotlinx.datetime.internal.format.parser.NumberSpanParserOperation;
import kotlinx.datetime.internal.format.parser.ParserOperationKt;
import kotlinx.datetime.internal.format.parser.ParserStructure;
import kotlinx.datetime.internal.format.parser.PlainStringParserOperation;
import kotlinx.datetime.internal.format.parser.UnsignedIntConsumer;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class SignedIntFieldFormatDirective<Target> implements FieldFormatDirective<Target> {

    /* renamed from: a, reason: collision with root package name */
    public final GenericFieldSpec f55559a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f55560b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f55561c;

    public SignedIntFieldFormatDirective(GenericFieldSpec field, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(field, "field");
        this.f55559a = field;
        this.f55560b = num;
        this.f55561c = num2;
        if (num.intValue() >= 0) {
            return;
        }
        throw new IllegalArgumentException(("The minimum number of digits (" + num + ") is negative").toString());
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final FormatterStructure a() {
        SignedIntFormatterStructure signedIntFormatterStructure = new SignedIntFormatterStructure(this.f55560b.intValue(), new SignedIntFieldFormatDirective$formatter$formatter$1(1, this.f55559a.f55541a, Accessor.class, "getterNotNull", "getterNotNull(Ljava/lang/Object;)Ljava/lang/Object;", 0));
        return this.f55561c != null ? new SpacePaddedFormatter(signedIntFormatterStructure) : signedIntFormatterStructure;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final ParserStructure b() {
        GenericFieldSpec genericFieldSpec = this.f55559a;
        PropertyAccessor setter = genericFieldSpec.f55541a;
        Intrinsics.checkNotNullParameter(setter, "setter");
        String name = genericFieldSpec.f55542b;
        Intrinsics.checkNotNullParameter(name, "name");
        Integer num = this.f55560b;
        Integer num2 = this.f55561c;
        ArrayList arrayListJ = CollectionsKt.J(ParserOperationKt.a(num, null, num2, setter, name, true));
        arrayListJ.add(ParserOperationKt.a(num, 4, num2, setter, name, false));
        List listI = CollectionsKt.I(new PlainStringParserOperation("+"), new NumberSpanParserOperation(CollectionsKt.H(new UnsignedIntConsumer(5, null, setter, name, false))));
        EmptyList emptyList = EmptyList.f53609a;
        arrayListJ.add(new ParserStructure(listI, emptyList));
        return new ParserStructure(emptyList, arrayListJ);
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final FieldSpec c() {
        return this.f55559a;
    }
}

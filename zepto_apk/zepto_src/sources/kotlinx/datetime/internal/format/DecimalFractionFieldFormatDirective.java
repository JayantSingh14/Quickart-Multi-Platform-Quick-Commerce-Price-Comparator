package kotlinx.datetime.internal.format;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.formatter.DecimalFractionFormatterStructure;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.FractionPartConsumer;
import kotlinx.datetime.internal.format.parser.NumberSpanParserOperation;
import kotlinx.datetime.internal.format.parser.ParserStructure;

@Metadata
/* loaded from: classes3.dex */
public abstract class DecimalFractionFieldFormatDirective<Target> implements FieldFormatDirective<Target> {

    /* renamed from: a, reason: collision with root package name */
    public final GenericFieldSpec f55537a;

    /* renamed from: b, reason: collision with root package name */
    public final int f55538b;

    /* renamed from: c, reason: collision with root package name */
    public final int f55539c;

    /* renamed from: d, reason: collision with root package name */
    public final List f55540d;

    public DecimalFractionFieldFormatDirective(GenericFieldSpec field, int i2, int i3, List zerosToAdd) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(zerosToAdd, "zerosToAdd");
        this.f55537a = field;
        this.f55538b = i2;
        this.f55539c = i3;
        this.f55540d = zerosToAdd;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final FormatterStructure a() {
        return new DecimalFractionFormatterStructure(new DecimalFractionFieldFormatDirective$formatter$1(1, this.f55537a.f55541a, Accessor.class, "getterNotNull", "getterNotNull(Ljava/lang/Object;)Ljava/lang/Object;", 0), this.f55538b, this.f55539c, this.f55540d);
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final ParserStructure b() {
        GenericFieldSpec genericFieldSpec = this.f55537a;
        return new ParserStructure(CollectionsKt.H(new NumberSpanParserOperation(CollectionsKt.H(new FractionPartConsumer(this.f55538b, this.f55539c, genericFieldSpec.f55541a, genericFieldSpec.f55542b)))), EmptyList.f53609a);
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final FieldSpec c() {
        return this.f55537a;
    }
}

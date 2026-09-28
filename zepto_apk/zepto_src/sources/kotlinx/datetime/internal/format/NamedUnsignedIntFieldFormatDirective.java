package kotlinx.datetime.internal.format;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.formatter.StringFormatterStructure;
import kotlinx.datetime.internal.format.parser.AssignableField;
import kotlinx.datetime.internal.format.parser.ParserStructure;
import kotlinx.datetime.internal.format.parser.StringSetParserOperation;

@Metadata
/* loaded from: classes3.dex */
public abstract class NamedUnsignedIntFieldFormatDirective<Target> implements FieldFormatDirective<Target> {

    /* renamed from: a, reason: collision with root package name */
    public final UnsignedFieldSpec f55544a;

    /* renamed from: b, reason: collision with root package name */
    public final List f55545b;

    /* renamed from: c, reason: collision with root package name */
    public final String f55546c;

    @Metadata
    public final class AssignableString implements AssignableField<Target, String> {
        public AssignableString() {
        }

        @Override // kotlinx.datetime.internal.format.parser.AssignableField
        public final Object c(Object obj, Object obj2) {
            String newValue = (String) obj2;
            Intrinsics.checkNotNullParameter(newValue, "newValue");
            NamedUnsignedIntFieldFormatDirective namedUnsignedIntFieldFormatDirective = NamedUnsignedIntFieldFormatDirective.this;
            PropertyAccessor propertyAccessor = namedUnsignedIntFieldFormatDirective.f55544a.f55563a;
            List list = namedUnsignedIntFieldFormatDirective.f55545b;
            int iIndexOf = list.indexOf(newValue);
            UnsignedFieldSpec unsignedFieldSpec = namedUnsignedIntFieldFormatDirective.f55544a;
            Integer num = (Integer) propertyAccessor.c(obj, Integer.valueOf(iIndexOf + unsignedFieldSpec.f55564b));
            if (num != null) {
                return (String) list.get(num.intValue() - unsignedFieldSpec.f55564b);
            }
            return null;
        }

        @Override // kotlinx.datetime.internal.format.parser.AssignableField
        public final String getName() {
            return NamedUnsignedIntFieldFormatDirective.this.f55546c;
        }
    }

    public NamedUnsignedIntFieldFormatDirective(UnsignedFieldSpec field, List values, String name) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f55544a = field;
        this.f55545b = values;
        this.f55546c = name;
        int size = values.size();
        int i2 = field.f55565c;
        int i3 = field.f55564b;
        if (size == (i2 - i3) + 1) {
            return;
        }
        throw new IllegalArgumentException(("The number of values (" + values.size() + ") in " + values + " does not match the range of the field (" + ((field.f55565c - i3) + 1) + ')').toString());
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final FormatterStructure a() {
        return new StringFormatterStructure(new NamedUnsignedIntFieldFormatDirective$formatter$1(1, this, NamedUnsignedIntFieldFormatDirective.class, "getStringValue", "getStringValue(Ljava/lang/Object;)Ljava/lang/String;", 0));
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final ParserStructure b() {
        List list = this.f55545b;
        return new ParserStructure(CollectionsKt.H(new StringSetParserOperation(list, new AssignableString(), "one of " + list + " for " + this.f55546c)), EmptyList.f53609a);
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final /* bridge */ /* synthetic */ FieldSpec c() {
        return this.f55544a;
    }
}

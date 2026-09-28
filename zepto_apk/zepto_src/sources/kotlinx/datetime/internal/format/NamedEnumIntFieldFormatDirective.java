package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.formatter.StringFormatterStructure;
import kotlinx.datetime.internal.format.parser.AssignableField;
import kotlinx.datetime.internal.format.parser.ParserStructure;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class NamedEnumIntFieldFormatDirective<Target, Type> implements FieldFormatDirective<Target> {

    @Metadata
    @SourceDebugExtension
    public final class AssignableString implements AssignableField<Target, String> {
        @Override // kotlinx.datetime.internal.format.parser.AssignableField
        public final Object c(Object obj, Object obj2) {
            String newValue = (String) obj2;
            Intrinsics.checkNotNullParameter(newValue, "newValue");
            throw null;
        }

        @Override // kotlinx.datetime.internal.format.parser.AssignableField
        public final String getName() {
            throw null;
        }
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final FormatterStructure a() {
        return new StringFormatterStructure(new NamedEnumIntFieldFormatDirective$formatter$1(1, this, NamedEnumIntFieldFormatDirective.class, "getStringValue", "getStringValue(Ljava/lang/Object;)Ljava/lang/String;", 0));
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final ParserStructure b() {
        throw null;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final FieldSpec c() {
        return null;
    }
}

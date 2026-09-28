package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserStructure;

@Metadata
/* loaded from: classes3.dex */
public abstract class StringFieldFormatDirective<Target> implements FieldFormatDirective<Target> {
    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final FormatterStructure a() {
        throw null;
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

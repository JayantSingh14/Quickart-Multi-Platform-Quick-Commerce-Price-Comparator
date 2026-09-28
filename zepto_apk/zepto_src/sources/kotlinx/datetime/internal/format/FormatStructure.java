package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserStructure;

@Metadata
/* loaded from: classes3.dex */
public interface FormatStructure<T> {
    FormatterStructure a();

    ParserStructure b();
}

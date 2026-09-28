package kotlinx.datetime.internal.format;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class FormatStructureKt {
    public static final void a(ListBuilder listBuilder, FormatStructure formatStructure) {
        if (formatStructure instanceof BasicFormatStructure) {
            listBuilder.add(((BasicFormatStructure) formatStructure).f55529a);
            return;
        }
        if (formatStructure instanceof ConcatenatedFormatStructure) {
            Iterator it = ((ConcatenatedFormatStructure) formatStructure).f55534a.iterator();
            while (it.hasNext()) {
                a(listBuilder, (NonConcatenatedFormatStructure) it.next());
            }
            return;
        }
        if (formatStructure instanceof ConstantFormatStructure) {
            return;
        }
        if (formatStructure instanceof SignedFormatStructure) {
            a(listBuilder, ((SignedFormatStructure) formatStructure).f55555a);
            return;
        }
        if (!(formatStructure instanceof AlternativesParsingFormatStructure)) {
            if (formatStructure instanceof OptionalFormatStructure) {
                a(listBuilder, ((OptionalFormatStructure) formatStructure).f55549b);
            }
        } else {
            AlternativesParsingFormatStructure alternativesParsingFormatStructure = (AlternativesParsingFormatStructure) formatStructure;
            a(listBuilder, alternativesParsingFormatStructure.f55526a);
            Iterator it2 = alternativesParsingFormatStructure.f55527b.iterator();
            while (it2.hasNext()) {
                a(listBuilder, (FormatStructure) it2.next());
            }
        }
    }
}

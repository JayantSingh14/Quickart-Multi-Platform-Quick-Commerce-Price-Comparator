package kotlinx.datetime.internal.format;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserStructure;

@Metadata
/* loaded from: classes3.dex */
public final class AlternativesParsingFormatStructure<T> implements NonConcatenatedFormatStructure<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ConcatenatedFormatStructure f55526a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f55527b;

    public AlternativesParsingFormatStructure(ConcatenatedFormatStructure mainFormat, ArrayList formats) {
        Intrinsics.checkNotNullParameter(mainFormat, "mainFormat");
        Intrinsics.checkNotNullParameter(formats, "formats");
        this.f55526a = mainFormat;
        this.f55527b = formats;
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public final FormatterStructure a() {
        return this.f55526a.a();
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public final ParserStructure b() {
        EmptyList emptyList = EmptyList.f53609a;
        ListBuilder builder = CollectionsKt.u();
        builder.add(this.f55526a.b());
        Iterator it = this.f55527b.iterator();
        while (it.hasNext()) {
            builder.add(((FormatStructure) it.next()).b());
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        return new ParserStructure(emptyList, builder.j());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AlternativesParsingFormatStructure)) {
            return false;
        }
        AlternativesParsingFormatStructure alternativesParsingFormatStructure = (AlternativesParsingFormatStructure) obj;
        return this.f55526a.equals(alternativesParsingFormatStructure.f55526a) && this.f55527b.equals(alternativesParsingFormatStructure.f55527b);
    }

    public final int hashCode() {
        return this.f55527b.hashCode() + (this.f55526a.hashCode() * 31);
    }

    public final String toString() {
        return "AlternativesParsing(" + this.f55527b + ')';
    }
}

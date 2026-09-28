package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserStructure;

@Metadata
/* loaded from: classes3.dex */
public final class BasicFormatStructure<T> implements NonConcatenatedFormatStructure<T> {

    /* renamed from: a, reason: collision with root package name */
    public final FieldFormatDirective f55529a;

    public BasicFormatStructure(FieldFormatDirective directive) {
        Intrinsics.checkNotNullParameter(directive, "directive");
        this.f55529a = directive;
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public final FormatterStructure a() {
        return this.f55529a.a();
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public final ParserStructure b() {
        return this.f55529a.b();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof BasicFormatStructure) {
            return Intrinsics.b(this.f55529a, ((BasicFormatStructure) obj).f55529a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f55529a.hashCode();
    }

    public final String toString() {
        return "BasicFormatStructure(" + this.f55529a + ')';
    }
}

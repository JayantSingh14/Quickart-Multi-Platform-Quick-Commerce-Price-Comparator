package kotlinx.datetime.internal.format;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.formatter.SignedFormatter;
import kotlinx.datetime.internal.format.parser.ParserKt;
import kotlinx.datetime.internal.format.parser.ParserStructure;
import kotlinx.datetime.internal.format.parser.SignParser;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SignedFormatStructure<T> implements NonConcatenatedFormatStructure<T> {

    /* renamed from: a, reason: collision with root package name */
    public final BasicFormatStructure f55555a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f55556b;

    public SignedFormatStructure(BasicFormatStructure format) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.f55555a = format;
        ListBuilder builder = CollectionsKt.u();
        FormatStructureKt.a(builder, format);
        Intrinsics.checkNotNullParameter(builder, "builder");
        ListBuilder listBuilderJ = builder.j();
        ArrayList arrayList = new ArrayList();
        ListIterator listIterator = listBuilderJ.listIterator(0);
        while (listIterator.hasNext()) {
            FieldSign fieldSignB = ((FieldFormatDirective) listIterator.next()).c().b();
            if (fieldSignB != null) {
                arrayList.add(fieldSignB);
            }
        }
        Set setH0 = CollectionsKt.h0(arrayList);
        this.f55556b = setH0;
        if (setH0.isEmpty()) {
            throw new IllegalArgumentException("Signed format must contain at least one field with a sign");
        }
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public final FormatterStructure a() {
        return new SignedFormatter(this.f55555a.f55529a.a(), new SignedFormatStructure$formatter$1(this));
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public final ParserStructure b() {
        return ParserKt.a(CollectionsKt.I(new ParserStructure(CollectionsKt.H(new SignParser(new Function2<Object, Boolean, Unit>() { // from class: kotlinx.datetime.internal.format.SignedFormatStructure$parser$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                boolean zBooleanValue = ((Boolean) obj2).booleanValue();
                for (FieldSign fieldSign : this.f55558c.f55556b) {
                    fieldSign.b().c(obj, Boolean.valueOf(zBooleanValue != Intrinsics.b(fieldSign.b().f55554a.get(obj), Boolean.TRUE)));
                }
                return Unit.f53572a;
            }
        }, "sign for " + this.f55556b)), EmptyList.f53609a), this.f55555a.f55529a.b()));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof SignedFormatStructure) {
            return this.f55555a.equals(((SignedFormatStructure) obj).f55555a);
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + (this.f55555a.f55529a.hashCode() * 31);
    }

    public final String toString() {
        return "SignedFormatStructure(" + this.f55555a + ')';
    }
}

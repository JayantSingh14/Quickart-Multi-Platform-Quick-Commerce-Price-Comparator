package kotlinx.datetime.internal.format;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.internal.format.OptionalFormatStructure;
import kotlinx.datetime.internal.format.formatter.ConditionalFormatter;
import kotlinx.datetime.internal.format.formatter.ConstantStringFormatterStructure;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserKt;
import kotlinx.datetime.internal.format.parser.ParserStructure;
import kotlinx.datetime.internal.format.parser.UnconditionalModification;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OptionalFormatStructure<T> implements NonConcatenatedFormatStructure<T> {

    /* renamed from: a, reason: collision with root package name */
    public final String f55548a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcatenatedFormatStructure f55549b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f55550c;

    @Metadata
    public static final class PropertyWithDefault<T, E> {

        /* renamed from: a, reason: collision with root package name */
        public final Accessor f55551a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f55552b;

        @Metadata
        public static final class Companion {
        }

        public PropertyWithDefault(Accessor accessor, Object obj) {
            this.f55551a = accessor;
            this.f55552b = obj;
        }
    }

    public OptionalFormatStructure(String onZero, ConcatenatedFormatStructure format) {
        Intrinsics.checkNotNullParameter(onZero, "onZero");
        Intrinsics.checkNotNullParameter(format, "format");
        this.f55548a = onZero;
        this.f55549b = format;
        ListBuilder builder = CollectionsKt.u();
        FormatStructureKt.a(builder, format);
        Intrinsics.checkNotNullParameter(builder, "builder");
        ListBuilder listBuilderJ = builder.j();
        ArrayList arrayList = new ArrayList(CollectionsKt.r(listBuilderJ, 10));
        ListIterator listIterator = listBuilderJ.listIterator(0);
        while (listIterator.hasNext()) {
            arrayList.add(((FieldFormatDirective) listIterator.next()).c());
        }
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        List<FieldSpec> listE0 = CollectionsKt.e0(CollectionsKt.g0(arrayList));
        ArrayList arrayList2 = new ArrayList(CollectionsKt.r(listE0, 10));
        for (FieldSpec field : listE0) {
            Intrinsics.checkNotNullParameter(field, "field");
            Object objC = field.c();
            if (objC == null) {
                throw new IllegalArgumentException(("The field '" + field.getName() + "' does not define a default value").toString());
            }
            arrayList2.add(new PropertyWithDefault(field.a(), objC));
        }
        this.f55550c = arrayList2;
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public final FormatterStructure a() {
        Predicate conjunctionPredicate;
        FormatterStructure formatterStructureA = this.f55549b.a();
        ArrayList arrayList = this.f55550c;
        ArrayList predicates = new ArrayList(CollectionsKt.r(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            PropertyWithDefault propertyWithDefault = (PropertyWithDefault) it.next();
            predicates.add(new ComparisonPredicate(propertyWithDefault.f55552b, new OptionalFormatStructure$PropertyWithDefault$isDefaultComparisonPredicate$1(1, propertyWithDefault.f55551a, Accessor.class, "getter", "getter(Ljava/lang/Object;)Ljava/lang/Object;", 0)));
        }
        Intrinsics.checkNotNullParameter(predicates, "predicates");
        boolean zIsEmpty = predicates.isEmpty();
        Predicate predicate = Truth.f55562a;
        if (zIsEmpty) {
            conjunctionPredicate = predicate;
        } else {
            conjunctionPredicate = predicates.size() == 1 ? (Predicate) CollectionsKt.T(predicates) : new ConjunctionPredicate(predicates);
        }
        boolean z = conjunctionPredicate instanceof Truth;
        String string = this.f55548a;
        if (z) {
            Intrinsics.checkNotNullParameter(string, "string");
            return new ConstantStringFormatterStructure();
        }
        OptionalFormatStructure$formatter$1 optionalFormatStructure$formatter$1 = new OptionalFormatStructure$formatter$1(1, conjunctionPredicate, Predicate.class, "test", "test(Ljava/lang/Object;)Z", 0);
        Intrinsics.checkNotNullParameter(string, "string");
        return new ConditionalFormatter(CollectionsKt.I(new Pair(optionalFormatStructure$formatter$1, new ConstantStringFormatterStructure()), new Pair(new OptionalFormatStructure$formatter$2(1, predicate, Truth.class, "test", "test(Ljava/lang/Object;)Z", 0), formatterStructureA)));
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public final ParserStructure b() {
        EmptyList emptyList = EmptyList.f53609a;
        return new ParserStructure(emptyList, CollectionsKt.I(this.f55549b.b(), ParserKt.a(CollectionsKt.I(new ConstantFormatStructure(this.f55548a).b(), new ParserStructure(this.f55550c.isEmpty() ? emptyList : CollectionsKt.H(new UnconditionalModification(new Function1<Object, Unit>() { // from class: kotlinx.datetime.internal.format.OptionalFormatStructure$parser$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Iterator it = this.f55553c.f55550c.iterator();
                while (it.hasNext()) {
                    OptionalFormatStructure.PropertyWithDefault propertyWithDefault = (OptionalFormatStructure.PropertyWithDefault) it.next();
                    propertyWithDefault.f55551a.c(obj, propertyWithDefault.f55552b);
                }
                return Unit.f53572a;
            }
        })), emptyList)))));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof OptionalFormatStructure)) {
            return false;
        }
        OptionalFormatStructure optionalFormatStructure = (OptionalFormatStructure) obj;
        return this.f55548a.equals(optionalFormatStructure.f55548a) && this.f55549b.equals(optionalFormatStructure.f55549b);
    }

    public final int hashCode() {
        return this.f55549b.hashCode() + (this.f55548a.hashCode() * 31);
    }

    public final String toString() {
        return "Optional(" + this.f55548a + ", " + this.f55549b + ')';
    }
}

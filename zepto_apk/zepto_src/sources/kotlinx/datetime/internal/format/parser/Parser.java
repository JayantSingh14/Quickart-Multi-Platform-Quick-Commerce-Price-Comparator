package kotlinx.datetime.internal.format.parser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.internal.format.parser.Copyable;

@Metadata
@JvmInline
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class Parser<Output extends Copyable<Output>> {

    @Metadata
    public static final class ParserState<Output> {

        /* renamed from: a, reason: collision with root package name */
        public final Copyable f55605a;

        /* renamed from: b, reason: collision with root package name */
        public final ParserStructure f55606b;

        /* renamed from: c, reason: collision with root package name */
        public final int f55607c;

        public ParserState(Copyable copyable, ParserStructure parserStructure, int i2) {
            Intrinsics.checkNotNullParameter(parserStructure, "parserStructure");
            this.f55605a = copyable;
            this.f55606b = parserStructure;
            this.f55607c = i2;
        }
    }

    /* JADX WARN: Type inference failed for: r9v20, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    public static Copyable a(ParserStructure parserStructure, String input, Copyable initialContainer) throws ParseException {
        String string;
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(initialContainer, "initialContainer");
        ArrayList errors = new ArrayList();
        ArrayList arrayListJ = CollectionsKt.J(new ParserState(initialContainer, parserStructure, 0));
        while (true) {
            Intrinsics.checkNotNullParameter(arrayListJ, "<this>");
            ParserState parserState = (ParserState) (arrayListJ.isEmpty() ? null : arrayListJ.remove(CollectionsKt.B(arrayListJ)));
            if (parserState == null) {
                if (errors.size() > 1) {
                    CollectionsKt.W(errors, new Comparator() { // from class: kotlinx.datetime.internal.format.parser.Parser$match-impl$$inlined$sortByDescending$1
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            return ComparisonsKt.a(Integer.valueOf(((ParseError) obj2).f55603a), Integer.valueOf(((ParseError) obj).f55603a));
                        }
                    });
                }
                Intrinsics.checkNotNullParameter(errors, "errors");
                if (errors.size() == 1) {
                    string = "Position " + ((ParseError) errors.get(0)).f55603a + ": " + ((String) ((ParseError) errors.get(0)).f55604b.invoke());
                } else {
                    StringBuilder sb = new StringBuilder(errors.size() * 33);
                    CollectionsKt.D(errors, sb, ", ", ParserKt$formatError$1.f55609c, 56);
                    string = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                }
                throw new ParseException(string);
            }
            Copyable copyable = (Copyable) parserState.f55605a.copy();
            ParserStructure parserStructure2 = parserState.f55606b;
            int size = parserStructure2.f55613a.size();
            int iIntValue = parserState.f55607c;
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    Object objA = ((ParserOperation) parserStructure2.f55613a.get(i2)).a(copyable, input, iIntValue);
                    if (objA instanceof Integer) {
                        iIntValue = ((Number) objA).intValue();
                        i2++;
                    } else {
                        if (!(objA instanceof ParseError)) {
                            throw new IllegalStateException(("Unexpected parse result: " + objA).toString());
                        }
                        errors.add((ParseError) objA);
                    }
                } else {
                    List list = parserStructure2.f55614b;
                    if (!list.isEmpty()) {
                        int size2 = list.size() - 1;
                        if (size2 >= 0) {
                            while (true) {
                                int i3 = size2 - 1;
                                arrayListJ.add(new ParserState(copyable, (ParserStructure) list.get(size2), iIntValue));
                                if (i3 < 0) {
                                    break;
                                }
                                size2 = i3;
                            }
                        }
                    } else {
                        if (iIntValue == input.length()) {
                            return copyable;
                        }
                        errors.add(new ParseError(iIntValue, new Function0<String>() { // from class: kotlinx.datetime.internal.format.parser.Parser$parse$1$3
                            @Override // kotlin.jvm.functions.Function0
                            public final /* bridge */ /* synthetic */ Object invoke() {
                                return "There is more input to consume";
                            }
                        }));
                    }
                }
            }
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Parser)) {
            return false;
        }
        ((Parser) obj).getClass();
        return Intrinsics.b(null, null);
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "Parser(commands=null)";
    }
}

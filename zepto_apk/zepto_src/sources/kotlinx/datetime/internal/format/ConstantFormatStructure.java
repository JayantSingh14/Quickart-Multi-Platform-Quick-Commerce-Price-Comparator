package kotlinx.datetime.internal.format;

import androidx.fragment.app.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.UtilKt;
import kotlinx.datetime.internal.format.formatter.ConstantStringFormatterStructure;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.ConstantNumberConsumer;
import kotlinx.datetime.internal.format.parser.NumberSpanParserOperation;
import kotlinx.datetime.internal.format.parser.ParserStructure;
import kotlinx.datetime.internal.format.parser.PlainStringParserOperation;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ConstantFormatStructure<T> implements NonConcatenatedFormatStructure<T> {

    /* renamed from: a, reason: collision with root package name */
    public final String f55536a;

    public ConstantFormatStructure(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.f55536a = string;
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public final FormatterStructure a() {
        String string = this.f55536a;
        Intrinsics.checkNotNullParameter(string, "string");
        return new ConstantStringFormatterStructure();
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public final ParserStructure b() {
        List listJ;
        String strSubstring;
        String strSubstring2 = this.f55536a;
        if (strSubstring2.length() == 0) {
            listJ = EmptyList.f53609a;
        } else {
            ListBuilder builder = CollectionsKt.u();
            String strSubstring3 = "";
            if (UtilKt.a(strSubstring2.charAt(0))) {
                int length = strSubstring2.length();
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        strSubstring = strSubstring2;
                        break;
                    }
                    if (!UtilKt.a(strSubstring2.charAt(i2))) {
                        strSubstring = strSubstring2.substring(0, i2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        break;
                    }
                    i2++;
                }
                builder.add(new NumberSpanParserOperation(CollectionsKt.H(new ConstantNumberConsumer(strSubstring))));
                int length2 = strSubstring2.length();
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        strSubstring2 = "";
                        break;
                    }
                    if (!UtilKt.a(strSubstring2.charAt(i3))) {
                        strSubstring2 = strSubstring2.substring(i3);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        break;
                    }
                    i3++;
                }
            }
            if (strSubstring2.length() > 0) {
                if (UtilKt.a(strSubstring2.charAt(strSubstring2.length() - 1))) {
                    int iV = StringsKt.v(strSubstring2);
                    while (true) {
                        if (-1 >= iV) {
                            break;
                        }
                        if (!UtilKt.a(strSubstring2.charAt(iV))) {
                            strSubstring3 = strSubstring2.substring(0, iV + 1);
                            Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                            break;
                        }
                        iV--;
                    }
                    builder.add(new PlainStringParserOperation(strSubstring3));
                    int iV2 = StringsKt.v(strSubstring2);
                    while (true) {
                        if (-1 >= iV2) {
                            break;
                        }
                        if (!UtilKt.a(strSubstring2.charAt(iV2))) {
                            strSubstring2 = strSubstring2.substring(iV2 + 1);
                            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                            break;
                        }
                        iV2--;
                    }
                    builder.add(new NumberSpanParserOperation(CollectionsKt.H(new ConstantNumberConsumer(strSubstring2))));
                } else {
                    builder.add(new PlainStringParserOperation(strSubstring2));
                }
            }
            Intrinsics.checkNotNullParameter(builder, "builder");
            listJ = builder.j();
        }
        return new ParserStructure(listJ, EmptyList.f53609a);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ConstantFormatStructure) {
            return Intrinsics.b(this.f55536a, ((ConstantFormatStructure) obj).f55536a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f55536a.hashCode();
    }

    public final String toString() {
        return e.t(new StringBuilder("ConstantFormatStructure("), this.f55536a, ')');
    }
}

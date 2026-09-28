package io.ktor.http.parsing.regex;

import androidx.fragment.app.e;
import io.ktor.http.parsing.AnyOfGrammar;
import io.ktor.http.parsing.AtLeastOne;
import io.ktor.http.parsing.ComplexGrammar;
import io.ktor.http.parsing.Grammar;
import io.ktor.http.parsing.ManyGrammar;
import io.ktor.http.parsing.MaybeGrammar;
import io.ktor.http.parsing.NamedGrammar;
import io.ktor.http.parsing.OrGrammar;
import io.ktor.http.parsing.RangeGrammar;
import io.ktor.http.parsing.RawGrammar;
import io.ktor.http.parsing.SimpleGrammar;
import io.ktor.http.parsing.StringGrammar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.apache.commons.codec.language.Soundex;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class RegexParserGeneratorKt {
    public static final RegexParser a(OrGrammar orGrammar) {
        Intrinsics.checkNotNullParameter(orGrammar, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        return new RegexParser(new Regex(c(orGrammar, linkedHashMap, 0, 6).f50310a), linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final GrammarRegex b(Grammar grammar, LinkedHashMap linkedHashMap, int i2, boolean z) {
        char c2;
        int i3 = 0;
        if (grammar instanceof StringGrammar) {
            Regex.Companion companion = Regex.f53991b;
            String literal = ((StringGrammar) grammar).f50309a;
            companion.getClass();
            Intrinsics.checkNotNullParameter(literal, "literal");
            String strQuote = Pattern.quote(literal);
            Intrinsics.checkNotNullExpressionValue(strQuote, "quote(...)");
            return new GrammarRegex(strQuote, 0, 6);
        }
        if (grammar instanceof RawGrammar) {
            ((RawGrammar) grammar).getClass();
            return new GrammarRegex("\\d", 0, 6);
        }
        if (grammar instanceof NamedGrammar) {
            ((NamedGrammar) grammar).getClass();
            GrammarRegex grammarRegexC = c(null, linkedHashMap, i2 + 1, 4);
            if (!linkedHashMap.containsKey(null)) {
                linkedHashMap.put(null, new ArrayList());
            }
            Integer numValueOf = Integer.valueOf(i2);
            Object obj = linkedHashMap.get(null);
            Intrinsics.c(obj);
            ((Collection) obj).add(numValueOf);
            return new GrammarRegex(grammarRegexC.f50310a, grammarRegexC.f50311b, true);
        }
        if (grammar instanceof ComplexGrammar) {
            StringBuilder sb = new StringBuilder();
            int i4 = z ? i2 + 1 : i2;
            for (Object obj2 : ((ComplexGrammar) grammar).a()) {
                int i5 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.b0();
                    throw null;
                }
                GrammarRegex grammarRegexB = b((Grammar) obj2, linkedHashMap, i4, true);
                if (i3 != 0 && (grammar instanceof OrGrammar)) {
                    sb.append(CLConstants.SALT_DELIMETER);
                }
                sb.append(grammarRegexB.f50310a);
                i4 += grammarRegexB.f50311b;
                i3 = i5;
            }
            int i6 = i4 - i2;
            if (z) {
                i6--;
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "expression.toString()");
            return new GrammarRegex(string, i6, z);
        }
        if (grammar instanceof SimpleGrammar) {
            if (grammar instanceof MaybeGrammar) {
                c2 = '?';
            } else if (grammar instanceof ManyGrammar) {
                c2 = '*';
            } else {
                if (!(grammar instanceof AtLeastOne)) {
                    throw new IllegalStateException(("Unsupported simple grammar element: " + grammar).toString());
                }
                c2 = '+';
            }
            GrammarRegex grammarRegexB2 = b(((SimpleGrammar) grammar).b(), linkedHashMap, i2, true);
            return new GrammarRegex(e.t(new StringBuilder(), grammarRegexB2.f50310a, c2), grammarRegexB2.f50311b, 4);
        }
        if (grammar instanceof AnyOfGrammar) {
            Regex.Companion companion2 = Regex.f53991b;
            ((AnyOfGrammar) grammar).getClass();
            companion2.getClass();
            Intrinsics.checkNotNullParameter(null, "literal");
            Intrinsics.checkNotNullExpressionValue(Pattern.quote(null), "quote(...)");
            throw null;
        }
        if (!(grammar instanceof RangeGrammar)) {
            throw new IllegalStateException(("Unsupported grammar element: " + grammar).toString());
        }
        StringBuilder sb2 = new StringBuilder("[");
        RangeGrammar rangeGrammar = (RangeGrammar) grammar;
        sb2.append(rangeGrammar.f50306a);
        sb2.append(Soundex.SILENT_MARKER);
        sb2.append(rangeGrammar.f50307b);
        sb2.append(']');
        return new GrammarRegex(sb2.toString(), 0, 6);
    }

    public static /* synthetic */ GrammarRegex c(OrGrammar orGrammar, LinkedHashMap linkedHashMap, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        return b(orGrammar, linkedHashMap, i2, false);
    }
}

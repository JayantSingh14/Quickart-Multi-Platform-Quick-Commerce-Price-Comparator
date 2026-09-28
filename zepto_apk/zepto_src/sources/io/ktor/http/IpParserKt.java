package io.ktor.http;

import io.ktor.http.parsing.AtLeastOne;
import io.ktor.http.parsing.OrGrammar;
import io.ktor.http.parsing.ParserDslKt;
import io.ktor.http.parsing.RangeGrammar;
import io.ktor.http.parsing.RawGrammar;
import io.ktor.http.parsing.SequenceGrammar;
import io.ktor.http.parsing.StringGrammar;
import io.ktor.http.parsing.regex.RegexParser;
import io.ktor.http.parsing.regex.RegexParserGeneratorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes3.dex */
public final class IpParserKt {

    /* renamed from: a, reason: collision with root package name */
    public static final RegexParser f50231a;

    static {
        Intrinsics.checkNotNullParameter("\\d", CLConstants.FIELD_PAY_INFO_VALUE);
        RawGrammar grammar = new RawGrammar();
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        SequenceGrammar sequenceGrammarC = ParserDslKt.c(new AtLeastOne(grammar), CLConstants.DOT_SALT_DELIMETER);
        Intrinsics.checkNotNullParameter("\\d", CLConstants.FIELD_PAY_INFO_VALUE);
        RawGrammar grammar2 = new RawGrammar();
        Intrinsics.checkNotNullParameter(grammar2, "grammar");
        SequenceGrammar sequenceGrammarC2 = ParserDslKt.c(ParserDslKt.b(sequenceGrammarC, new AtLeastOne(grammar2)), CLConstants.DOT_SALT_DELIMETER);
        Intrinsics.checkNotNullParameter("\\d", CLConstants.FIELD_PAY_INFO_VALUE);
        RawGrammar grammar3 = new RawGrammar();
        Intrinsics.checkNotNullParameter(grammar3, "grammar");
        SequenceGrammar sequenceGrammarC3 = ParserDslKt.c(ParserDslKt.b(sequenceGrammarC2, new AtLeastOne(grammar3)), CLConstants.DOT_SALT_DELIMETER);
        Intrinsics.checkNotNullParameter("\\d", CLConstants.FIELD_PAY_INFO_VALUE);
        RawGrammar grammar4 = new RawGrammar();
        Intrinsics.checkNotNullParameter(grammar4, "grammar");
        SequenceGrammar sequenceGrammarB = ParserDslKt.b(sequenceGrammarC3, new AtLeastOne(grammar4));
        Intrinsics.checkNotNullParameter("\\d", CLConstants.FIELD_PAY_INFO_VALUE);
        OrGrammar orGrammarA = ParserDslKt.a(ParserDslKt.a(new RawGrammar(), new RangeGrammar('A', 'F')), new RangeGrammar('a', 'f'));
        Intrinsics.checkNotNullParameter(orGrammarA, "<this>");
        Intrinsics.checkNotNullParameter(":", CLConstants.FIELD_PAY_INFO_VALUE);
        OrGrammar grammar5 = ParserDslKt.a(orGrammarA, new StringGrammar(":"));
        Intrinsics.checkNotNullParameter(grammar5, "grammar");
        AtLeastOne grammar6 = new AtLeastOne(grammar5);
        Intrinsics.checkNotNullParameter("[", "<this>");
        Intrinsics.checkNotNullParameter(grammar6, "grammar");
        f50231a = RegexParserGeneratorKt.a(ParserDslKt.a(sequenceGrammarB, ParserDslKt.c(ParserDslKt.b(new StringGrammar("["), grammar6), "]")));
    }
}

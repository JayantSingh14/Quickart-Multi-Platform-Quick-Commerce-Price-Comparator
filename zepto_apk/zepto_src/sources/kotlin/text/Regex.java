package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Regex implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Companion f53991b = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final Pattern f53992a;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Serialized implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final Companion f53993a = new Companion(null);

        @Metadata
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }
    }

    public Regex(Pattern nativePattern) {
        Intrinsics.checkNotNullParameter(nativePattern, "nativePattern");
        this.f53992a = nativePattern;
    }

    public static Sequence a(Regex regex, CharSequence input) {
        regex.getClass();
        Intrinsics.checkNotNullParameter(input, "input");
        if (input.length() >= 0) {
            return SequencesKt.j(new com.facebook.imagepipeline.core.b(4, regex, input), Regex$findAll$2.f53994b);
        }
        StringBuilder sbU = android.support.v4.media.b.u(0, "Start index out of bounds: ", ", input length: ");
        sbU.append(input.length());
        throw new IndexOutOfBoundsException(sbU.toString());
    }

    public final MatchResult b(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher matcher = this.f53992a.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        return RegexKt.b(matcher, input);
    }

    public final boolean c(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.f53992a.matcher(input).matches();
    }

    public final String d(String input, Function1 transform) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher matcher = this.f53992a.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        int i2 = 0;
        MatchResult matchResultA = RegexKt.a(matcher, 0, input);
        if (matchResultA == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            MatcherMatchResult matcherMatchResult = (MatcherMatchResult) matchResultA;
            sb.append((CharSequence) input, i2, matcherMatchResult.b().f53838a);
            sb.append((CharSequence) transform.invoke(matchResultA));
            i2 = matcherMatchResult.b().f53839b + 1;
            matchResultA = matcherMatchResult.next();
            if (i2 >= length) {
                break;
            }
        } while (matchResultA != null);
        if (i2 < length) {
            sb.append((CharSequence) input, i2, length);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final List e(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        int iEnd = 0;
        StringsKt__StringsKt.h(0);
        Matcher matcher = this.f53992a.matcher(input);
        if (!matcher.find()) {
            return CollectionsKt.H(input.toString());
        }
        ArrayList arrayList = new ArrayList(10);
        do {
            arrayList.add(input.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
        } while (matcher.find());
        arrayList.add(input.subSequence(iEnd, input.length()).toString());
        return arrayList;
    }

    @NotNull
    public final String replace(@NotNull CharSequence input, @NotNull String replacement) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        String strReplaceAll = this.f53992a.matcher(input).replaceAll(replacement);
        Intrinsics.checkNotNullExpressionValue(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public final String toString() {
        String string = this.f53992a.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(@NotNull String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Pattern patternCompile = Pattern.compile(pattern);
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String pattern, RegexOption option) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(option, "option");
        Companion companion = f53991b;
        int value = option.getValue();
        companion.getClass();
        Pattern patternCompile = Pattern.compile(pattern, (value & 2) != 0 ? value | 64 : value);
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        this(patternCompile);
    }
}

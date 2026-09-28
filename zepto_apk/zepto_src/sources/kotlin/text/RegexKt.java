package kotlin.text;

import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class RegexKt {
    public static final MatchResult a(Matcher matcher, int i2, CharSequence charSequence) {
        if (matcher.find(i2)) {
            return new MatcherMatchResult(matcher, charSequence);
        }
        return null;
    }

    public static final MatchResult b(Matcher matcher, String str) {
        if (matcher.matches()) {
            return new MatcherMatchResult(matcher, str);
        }
        return null;
    }
}

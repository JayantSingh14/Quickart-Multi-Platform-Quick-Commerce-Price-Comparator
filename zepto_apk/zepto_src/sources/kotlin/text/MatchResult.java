package kotlin.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

@Metadata
/* loaded from: classes3.dex */
public interface MatchResult {

    @Metadata
    public static final class DefaultImpls {
    }

    @Metadata
    public static final class Destructured {
    }

    List a();

    IntRange b();

    MatcherMatchResult$groups$1 c();

    String getValue();

    MatchResult next();
}

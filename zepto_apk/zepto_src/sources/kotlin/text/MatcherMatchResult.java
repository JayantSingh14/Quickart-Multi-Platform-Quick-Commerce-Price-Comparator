package kotlin.text;

import java.util.List;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata
/* loaded from: classes3.dex */
final class MatcherMatchResult implements MatchResult {

    /* renamed from: a, reason: collision with root package name */
    public final Matcher f53985a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f53986b;

    /* renamed from: c, reason: collision with root package name */
    public final MatcherMatchResult$groups$1 f53987c;

    /* renamed from: d, reason: collision with root package name */
    public MatcherMatchResult$groupValues$1 f53988d;

    public MatcherMatchResult(Matcher matcher, CharSequence input) {
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        Intrinsics.checkNotNullParameter(input, "input");
        this.f53985a = matcher;
        this.f53986b = input;
        this.f53987c = new MatcherMatchResult$groups$1(this);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.text.MatcherMatchResult$groupValues$1] */
    @Override // kotlin.text.MatchResult
    public final List a() {
        if (this.f53988d == null) {
            this.f53988d = new AbstractList<String>() { // from class: kotlin.text.MatcherMatchResult$groupValues$1
                @Override // kotlin.collections.AbstractCollection
                public final int b() {
                    return this.f53989b.f53985a.groupCount() + 1;
                }

                @Override // kotlin.collections.AbstractCollection, java.util.Collection
                public final /* bridge */ boolean contains(Object obj) {
                    if (obj instanceof String) {
                        return super.contains((String) obj);
                    }
                    return false;
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final Object get(int i2) {
                    String strGroup = this.f53989b.f53985a.group(i2);
                    return strGroup == null ? "" : strGroup;
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final /* bridge */ int indexOf(Object obj) {
                    if (obj instanceof String) {
                        return super.indexOf((String) obj);
                    }
                    return -1;
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final /* bridge */ int lastIndexOf(Object obj) {
                    if (obj instanceof String) {
                        return super.lastIndexOf((String) obj);
                    }
                    return -1;
                }
            };
        }
        MatcherMatchResult$groupValues$1 matcherMatchResult$groupValues$1 = this.f53988d;
        Intrinsics.c(matcherMatchResult$groupValues$1);
        return matcherMatchResult$groupValues$1;
    }

    @Override // kotlin.text.MatchResult
    public final IntRange b() {
        Matcher matcher = this.f53985a;
        return RangesKt.f(matcher.start(), matcher.end());
    }

    @Override // kotlin.text.MatchResult
    public final MatcherMatchResult$groups$1 c() {
        return this.f53987c;
    }

    @Override // kotlin.text.MatchResult
    public final String getValue() {
        String strGroup = this.f53985a.group();
        Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
        return strGroup;
    }

    @Override // kotlin.text.MatchResult
    public final MatchResult next() {
        Matcher matcher = this.f53985a;
        int iEnd = matcher.end() + (matcher.end() == matcher.start() ? 1 : 0);
        CharSequence charSequence = this.f53986b;
        if (iEnd > charSequence.length()) {
            return null;
        }
        Matcher matcher2 = matcher.pattern().matcher(charSequence);
        Intrinsics.checkNotNullExpressionValue(matcher2, "matcher(...)");
        return RegexKt.a(matcher2, iEnd, charSequence);
    }
}

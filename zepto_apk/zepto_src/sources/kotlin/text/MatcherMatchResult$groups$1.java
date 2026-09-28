package kotlin.text;

import java.util.Iterator;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.TransformingSequence;

@Metadata
/* loaded from: classes3.dex */
public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> implements MatchNamedGroupCollection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MatcherMatchResult f53990a;

    public MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.f53990a = matcherMatchResult;
    }

    @Override // kotlin.collections.AbstractCollection
    public final int b() {
        return this.f53990a.f53985a.groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof MatchGroup) {
            return super.contains((MatchGroup) obj);
        }
        return false;
    }

    public final MatchGroup d(int i2) {
        MatcherMatchResult matcherMatchResult = this.f53990a;
        Matcher matcher = matcherMatchResult.f53985a;
        IntRange intRangeF = RangesKt.f(matcher.start(i2), matcher.end(i2));
        if (intRangeF.f53838a < 0) {
            return null;
        }
        String strGroup = matcherMatchResult.f53985a.group(i2);
        Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
        return new MatchGroup(strGroup, intRangeF);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new TransformingSequence.AnonymousClass1();
    }
}

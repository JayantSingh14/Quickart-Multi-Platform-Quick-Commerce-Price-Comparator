package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.CharRange;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class UnicodeKt {
    static {
        CollectionsKt.L(CollectionsKt.M(new CharRange('a', 'z'), new CharRange('A', 'Z')), CollectionsKt.I('[', ']', '\''));
    }
}

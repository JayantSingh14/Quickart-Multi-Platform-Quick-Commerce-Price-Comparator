package kotlin.sequences;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata
/* loaded from: classes3.dex */
public final class SequencesKt___SequencesKt$sortedWith$1 implements Sequence<Object> {
    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        List listB = SequencesKt___SequencesKt.b(null);
        CollectionsKt.W(listB, null);
        return listB.iterator();
    }
}

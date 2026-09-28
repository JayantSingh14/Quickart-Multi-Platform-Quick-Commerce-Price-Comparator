package kotlin.sequences;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
class SequencesKt___SequencesKt extends SequencesKt___SequencesJvmKt {
    public static final FilteringSequence a(TransformingSequence transformingSequence, Function1 predicate) {
        Intrinsics.checkNotNullParameter(transformingSequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new FilteringSequence(transformingSequence, false, predicate);
    }

    public static final List b(FilteringSequence filteringSequence) {
        Intrinsics.checkNotNullParameter(filteringSequence, "<this>");
        ArrayList arrayList = new ArrayList();
        SequencesKt.p(filteringSequence, arrayList);
        return arrayList;
    }
}

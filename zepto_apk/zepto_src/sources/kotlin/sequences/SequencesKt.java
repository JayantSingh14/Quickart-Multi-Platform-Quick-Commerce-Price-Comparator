package kotlin.sequences;

import coil3.disk.a;
import com.facebook.imagepipeline.core.b;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class SequencesKt extends SequencesKt___SequencesKt {
    public static ConstrainedOnceSequence c(final Iterator it) {
        Intrinsics.checkNotNullParameter(it, "<this>");
        return d(new Sequence<Object>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public final Iterator iterator() {
                return it;
            }
        });
    }

    public static ConstrainedOnceSequence d(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        if (!(sequence instanceof ConstrainedOnceSequence)) {
            sequence = new ConstrainedOnceSequence(sequence);
        }
        return (ConstrainedOnceSequence) sequence;
    }

    public static int e(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator it = sequence.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            it.next();
            i2++;
            if (i2 < 0) {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i2;
    }

    public static Sequence f() {
        return EmptySequence.f53903a;
    }

    public static FilteringSequence g(Sequence sequence, Function1 predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new FilteringSequence(sequence, true, predicate);
    }

    public static Object h(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator it = sequence.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static ConstrainedOnceSequence i(Function0 nextFunction) {
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return d(new GeneratorSequence(nextFunction, new a(nextFunction, 4)));
    }

    public static Sequence j(b seedFunction, Function1 nextFunction) {
        Intrinsics.checkNotNullParameter(seedFunction, "seedFunction");
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return new GeneratorSequence(seedFunction, nextFunction);
    }

    public static Sequence k(Type type, Function1 nextFunction) {
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return type == null ? EmptySequence.f53903a : new GeneratorSequence(new coil3.decode.a(type, 11), nextFunction);
    }

    public static Iterator l(Function2 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SequenceBuilderIterator sequenceBuilderIterator = new SequenceBuilderIterator();
        sequenceBuilderIterator.d(IntrinsicsKt.a(sequenceBuilderIterator, sequenceBuilderIterator, block));
        return sequenceBuilderIterator;
    }

    public static TransformingSequence m(Sequence sequence, Function1 transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new TransformingSequence(sequence, transform);
    }

    public static FilteringSequence n(Sequence sequence, Function1 transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        TransformingSequence transformingSequence = new TransformingSequence(sequence, transform);
        Intrinsics.checkNotNullParameter(transformingSequence, "<this>");
        return SequencesKt___SequencesKt.a(transformingSequence, new com.zeptoconsumerapp.AutoLogin.a(3));
    }

    public static SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1 o(Function2 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return new SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1(block);
    }

    public static void p(Sequence sequence, Collection destination) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Iterator it = sequence.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
    }

    public static List q(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator it = sequence.iterator();
        if (!it.hasNext()) {
            return EmptyList.f53609a;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return CollectionsKt.H(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}

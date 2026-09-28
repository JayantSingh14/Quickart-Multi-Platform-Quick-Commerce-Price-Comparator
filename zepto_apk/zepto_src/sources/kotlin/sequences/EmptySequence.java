package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.EmptyIterator;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
final class EmptySequence implements Sequence, DropTakeSequence {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final EmptySequence f53903a = new EmptySequence();

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence a(int i2) {
        return f53903a;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return EmptyIterator.f53608a;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence take() {
        return f53903a;
    }
}

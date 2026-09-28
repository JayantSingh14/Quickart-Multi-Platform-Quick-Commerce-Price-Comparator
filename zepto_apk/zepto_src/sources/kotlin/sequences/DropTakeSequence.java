package kotlin.sequences;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface DropTakeSequence<T> extends Sequence<T> {
    Sequence a(int i2);

    Sequence take();
}

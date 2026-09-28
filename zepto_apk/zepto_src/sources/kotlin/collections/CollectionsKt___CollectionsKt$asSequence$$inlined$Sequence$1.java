package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 implements Sequence<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterable f53607a;

    public CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1(Iterable iterable) {
        this.f53607a = iterable;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return this.f53607a.iterator();
    }
}

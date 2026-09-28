package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class StringsKt__StringsKt$lineSequence$$inlined$Sequence$1 implements Sequence<String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CharSequence f54001a;

    public StringsKt__StringsKt$lineSequence$$inlined$Sequence$1(CharSequence charSequence) {
        this.f54001a = charSequence;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new LinesIterator(this.f54001a);
    }
}

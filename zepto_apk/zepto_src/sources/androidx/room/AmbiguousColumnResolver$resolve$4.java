package androidx.room;

import androidx.room.AmbiguousColumnResolver;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class AmbiguousColumnResolver$resolve$4 extends Lambda implements Function1<List<? extends AmbiguousColumnResolver.Match>, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        List matches = (List) obj;
        Intrinsics.checkNotNullParameter(matches, "it");
        int i2 = AmbiguousColumnResolver.Solution.f11720d;
        Intrinsics.checkNotNullParameter(matches, "matches");
        List list = matches;
        Iterator it = list.iterator();
        if (it.hasNext()) {
            throw null;
        }
        Iterator it2 = list.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        throw null;
    }
}

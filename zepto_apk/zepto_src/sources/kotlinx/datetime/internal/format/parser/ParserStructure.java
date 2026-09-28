package kotlinx.datetime.internal.format.parser;

import androidx.fragment.app.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ParserStructure<Output> {

    /* renamed from: a, reason: collision with root package name */
    public final List f55613a;

    /* renamed from: b, reason: collision with root package name */
    public final List f55614b;

    public ParserStructure(List operations, List followedBy) {
        Intrinsics.checkNotNullParameter(operations, "operations");
        Intrinsics.checkNotNullParameter(followedBy, "followedBy");
        this.f55613a = operations;
        this.f55614b = followedBy;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CollectionsKt.E(this.f55613a, ", ", null, null, null, 62));
        sb.append('(');
        return e.t(sb, CollectionsKt.E(this.f55614b, ";", null, null, null, 62), ')');
    }
}

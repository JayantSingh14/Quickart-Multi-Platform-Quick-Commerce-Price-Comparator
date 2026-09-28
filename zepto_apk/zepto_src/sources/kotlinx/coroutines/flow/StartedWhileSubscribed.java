package kotlinx.coroutines.flow;

import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class StartedWhileSubscribed implements SharingStarted {
    public final boolean equals(Object obj) {
        if (!(obj instanceof StartedWhileSubscribed)) {
            return false;
        }
        StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) obj;
        startedWhileSubscribed.getClass();
        startedWhileSubscribed.getClass();
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(0L) + (Long.hashCode(0L) * 31);
    }

    public final String toString() {
        ListBuilder builder = new ListBuilder(2);
        builder.add("replayExpiration=0ms");
        Intrinsics.checkNotNullParameter(builder, "builder");
        return e.t(new StringBuilder("SharingStarted.WhileSubscribed("), CollectionsKt.E(builder.j(), null, null, null, null, 63), ')');
    }
}

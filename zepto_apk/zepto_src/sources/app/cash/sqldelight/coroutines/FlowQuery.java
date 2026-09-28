package app.cash.sqldelight.coroutines;

import app.cash.sqldelight.Query;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata
@JvmName
@SourceDebugExtension
/* loaded from: classes.dex */
public final class FlowQuery {
    public static final Flow a(Query query) {
        Intrinsics.checkNotNullParameter(query, "<this>");
        return FlowKt.l(new FlowQuery$asFlow$1(query, null));
    }
}

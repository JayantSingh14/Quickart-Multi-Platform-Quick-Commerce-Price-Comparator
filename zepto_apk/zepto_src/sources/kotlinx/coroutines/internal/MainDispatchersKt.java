package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class MainDispatchersKt {
    public static final boolean a(MainCoroutineDispatcher mainCoroutineDispatcher) {
        return mainCoroutineDispatcher.O1() instanceof MissingMainCoroutineDispatcher;
    }
}

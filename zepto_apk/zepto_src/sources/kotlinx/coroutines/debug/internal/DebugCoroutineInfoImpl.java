package kotlinx.coroutines.debug.internal;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@PublishedApi
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DebugCoroutineInfoImpl {

    @JvmField
    @Nullable
    public volatile WeakReference<CoroutineStackFrame> _lastObservedFrame;

    @JvmField
    @NotNull
    public volatile String _state;

    @JvmField
    @Nullable
    public volatile Thread lastObservedThread;

    public final String toString() {
        throw null;
    }
}

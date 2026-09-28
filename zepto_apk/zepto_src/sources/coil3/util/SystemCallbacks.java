package coil3.util;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface SystemCallbacks {
    void registerMemoryPressureCallbacks();

    void shutdown();
}

package com.facebook.react.bridge;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface PerformanceCounter {
    @Nullable
    Map<String, Long> getPerformanceCounters();

    void profileNextBatch();
}

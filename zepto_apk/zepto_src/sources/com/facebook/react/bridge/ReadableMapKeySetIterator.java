package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@DoNotStrip
@Metadata
/* loaded from: classes.dex */
public interface ReadableMapKeySetIterator {
    boolean hasNextKey();

    @NotNull
    String nextKey();
}

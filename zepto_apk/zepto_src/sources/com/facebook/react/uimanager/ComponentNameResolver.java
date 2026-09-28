package com.facebook.react.uimanager;

import com.facebook.proguard.annotations.DoNotStripAny;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@DoNotStripAny
@Metadata
/* loaded from: classes3.dex */
public interface ComponentNameResolver {
    @Nullable
    String[] getComponentNames();
}

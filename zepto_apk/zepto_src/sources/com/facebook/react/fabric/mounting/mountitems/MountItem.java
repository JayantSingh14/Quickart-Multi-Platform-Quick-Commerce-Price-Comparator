package com.facebook.react.fabric.mounting.mountitems;

import androidx.annotation.AnyThread;
import androidx.annotation.UiThread;
import com.facebook.proguard.annotations.DoNotStripAny;
import com.facebook.react.fabric.mounting.MountingManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@DoNotStripAny
@Metadata
/* loaded from: classes3.dex */
public interface MountItem {
    @UiThread
    void execute(@NotNull MountingManager mountingManager);

    @AnyThread
    int getSurfaceId();
}

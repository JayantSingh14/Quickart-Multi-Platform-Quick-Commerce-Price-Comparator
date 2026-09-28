package in.juspay.hypersdk.lifecycle;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public interface EventListener {
    void onEvent(@NotNull String str, @NotNull HyperFragment hyperFragment);
}

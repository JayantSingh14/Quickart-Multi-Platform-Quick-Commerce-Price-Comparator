package in.juspay.airborne.ota;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public interface ReleaseConfigCallback {
    @NotNull
    String getReleaseConfig(boolean z);

    boolean shouldRetry();
}

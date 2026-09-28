package in.juspay.airborne;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public interface LazyDownloadCallback {
    void fileInstalled(@NotNull String str, boolean z);

    void lazySplitsInstalled(boolean z);
}

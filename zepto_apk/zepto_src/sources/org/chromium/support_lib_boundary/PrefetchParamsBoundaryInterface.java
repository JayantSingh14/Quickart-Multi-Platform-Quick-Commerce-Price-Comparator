package org.chromium.support_lib_boundary;

import androidx.annotation.Nullable;
import java.util.Map;

/* loaded from: classes5.dex */
public interface PrefetchParamsBoundaryInterface {
    @Nullable
    Map<String, String> getAdditionalHeaders();

    @Nullable
    String getNoVarySearchHint();
}

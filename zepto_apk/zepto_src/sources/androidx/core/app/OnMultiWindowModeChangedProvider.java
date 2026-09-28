package androidx.core.app;

import androidx.core.util.Consumer;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface OnMultiWindowModeChangedProvider {
    void addOnMultiWindowModeChangedListener(Consumer consumer);

    void removeOnMultiWindowModeChangedListener(Consumer consumer);
}

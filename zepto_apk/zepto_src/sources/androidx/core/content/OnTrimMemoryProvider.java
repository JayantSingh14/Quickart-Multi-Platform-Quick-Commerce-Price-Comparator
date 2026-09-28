package androidx.core.content;

import androidx.core.util.Consumer;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface OnTrimMemoryProvider {
    void addOnTrimMemoryListener(Consumer consumer);

    void removeOnTrimMemoryListener(Consumer consumer);
}

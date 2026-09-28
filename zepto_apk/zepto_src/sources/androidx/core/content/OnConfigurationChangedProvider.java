package androidx.core.content;

import androidx.core.util.Consumer;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface OnConfigurationChangedProvider {
    void addOnConfigurationChangedListener(Consumer consumer);

    void removeOnConfigurationChangedListener(Consumer consumer);
}

package androidx.core.app;

import androidx.core.util.Consumer;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface OnPictureInPictureModeChangedProvider {
    void addOnPictureInPictureModeChangedListener(Consumer consumer);

    void removeOnPictureInPictureModeChangedListener(Consumer consumer);
}

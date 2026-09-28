package coil3.request;

import coil3.Image;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface ImageResult {
    @Nullable
    Image getImage();

    @NotNull
    ImageRequest getRequest();
}

package coil3.decode;

import android.content.res.AssetFileDescriptor;
import coil3.Uri;
import coil3.decode.ImageSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class ContentMetadata extends ImageSource.Metadata {

    @NotNull
    private final AssetFileDescriptor assetFileDescriptor;

    @NotNull
    private final Uri uri;

    public ContentMetadata(@NotNull Uri uri, @NotNull AssetFileDescriptor assetFileDescriptor) {
        this.uri = uri;
        this.assetFileDescriptor = assetFileDescriptor;
    }

    @NotNull
    public final AssetFileDescriptor getAssetFileDescriptor() {
        return this.assetFileDescriptor;
    }

    @NotNull
    public final Uri getUri() {
        return this.uri;
    }
}

package coil3.decode;

import coil3.decode.ImageSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class AssetMetadata extends ImageSource.Metadata {

    @NotNull
    private final String filePath;

    public AssetMetadata(@NotNull String str) {
        this.filePath = str;
    }

    @NotNull
    public final String getFilePath() {
        return this.filePath;
    }
}

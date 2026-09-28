package coil3.decode;

import coil3.annotation.ExperimentalCoilApi;
import coil3.decode.ImageSource;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
@ExperimentalCoilApi
/* loaded from: classes3.dex */
public final class ByteBufferMetadata extends ImageSource.Metadata {

    @NotNull
    private final ByteBuffer byteBuffer;

    public ByteBufferMetadata(@NotNull ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    @NotNull
    public final ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }
}

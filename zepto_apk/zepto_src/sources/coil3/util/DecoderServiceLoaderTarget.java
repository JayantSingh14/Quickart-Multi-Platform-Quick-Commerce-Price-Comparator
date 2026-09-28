package coil3.util;

import coil3.annotation.InternalCoilApi;
import coil3.decode.Decoder;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata
@InternalCoilApi
/* loaded from: classes.dex */
public interface DecoderServiceLoaderTarget {
    @Nullable
    Decoder.Factory factory();

    default int priority() {
        return 0;
    }
}

package coil3.memory;

import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.transform.Transformation;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MemoryCacheServiceKt {
    @NotNull
    public static final Map<String, String> createComplexMemoryCacheKeyExtras(@NotNull ImageRequest imageRequest, @NotNull Options options) {
        Map<String, String> memoryCacheKeyExtras = imageRequest.getMemoryCacheKeyExtras();
        if (!ImageRequests_androidKt.getTransformations(imageRequest).isEmpty()) {
            memoryCacheKeyExtras = MapsKt.n(memoryCacheKeyExtras);
            List<Transformation> transformations = ImageRequests_androidKt.getTransformations(imageRequest);
            int size = transformations.size();
            for (int i2 = 0; i2 < size; i2++) {
                memoryCacheKeyExtras.put(android.support.v4.media.b.f(i2, MemoryCacheService.EXTRA_TRANSFORMATION_INDEX), transformations.get(i2).getCacheKey());
            }
            memoryCacheKeyExtras.put(MemoryCacheService.EXTRA_TRANSFORMATION_SIZE, options.getSize().toString());
        }
        return memoryCacheKeyExtras;
    }
}

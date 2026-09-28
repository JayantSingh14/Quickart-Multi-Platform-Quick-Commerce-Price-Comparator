package coil3.request;

import coil3.memory.MemoryCache;
import coil3.size.Size;
import coil3.size.SizeResolver;
import kotlin.Metadata;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public interface RequestService {
    boolean isCacheValueValidForHardware(@NotNull ImageRequest imageRequest, @NotNull MemoryCache.Value value);

    @NotNull
    Options options(@NotNull ImageRequest imageRequest, @NotNull SizeResolver sizeResolver, @NotNull Size size);

    @NotNull
    RequestDelegate requestDelegate(@NotNull ImageRequest imageRequest, @NotNull Job job, boolean z);

    @NotNull
    SizeResolver sizeResolver(@NotNull ImageRequest imageRequest);

    @NotNull
    Options updateOptionsOnWorkerThread(@NotNull Options options);
}

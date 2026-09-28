package coil3;

import coil3.ComponentRegistry;
import coil3.RealImageLoader;
import coil3.fetch.ByteBufferFetcher;
import coil3.fetch.JarFileFetcher;
import coil3.map.FileMapper;
import java.io.File;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RealImageLoader_jvmCommonKt {
    @NotNull
    public static final ComponentRegistry.Builder addJvmComponents(@NotNull ComponentRegistry.Builder builder, @NotNull RealImageLoader.Options options) {
        return builder.add(new FileMapper(), Reflection.a(File.class)).add(new JarFileFetcher.Factory(), Reflection.a(Uri.class)).add(new ByteBufferFetcher.Factory(), Reflection.a(ByteBuffer.class));
    }
}

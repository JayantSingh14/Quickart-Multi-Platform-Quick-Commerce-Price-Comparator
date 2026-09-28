package coil3.util;

import android.os.StatFs;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class FileSystems_androidKt {
    public static final long remainingFreeSpaceBytes(@NotNull FileSystem fileSystem, @NotNull Path path) {
        File fileG = path.g();
        fileG.mkdir();
        StatFs statFs = new StatFs(fileG.getAbsolutePath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }
}

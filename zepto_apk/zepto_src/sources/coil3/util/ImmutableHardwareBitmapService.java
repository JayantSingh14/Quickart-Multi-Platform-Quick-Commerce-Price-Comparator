package coil3.util;

import coil3.size.Size;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
final class ImmutableHardwareBitmapService implements HardwareBitmapService {
    private final boolean allowHardware;

    public ImmutableHardwareBitmapService(boolean z) {
        this.allowHardware = z;
    }

    @Override // coil3.util.HardwareBitmapService
    public boolean allowHardwareMainThread(@NotNull Size size) {
        return this.allowHardware;
    }

    @Override // coil3.util.HardwareBitmapService
    public boolean allowHardwareWorkerThread() {
        return this.allowHardware;
    }
}

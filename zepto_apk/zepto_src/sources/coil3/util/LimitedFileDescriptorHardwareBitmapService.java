package coil3.util;

import coil3.size.Dimension;
import coil3.size.Size;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class LimitedFileDescriptorHardwareBitmapService implements HardwareBitmapService {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int MIN_SIZE_DIMENSION = 100;

    @Nullable
    private final Logger logger;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public LimitedFileDescriptorHardwareBitmapService(@Nullable Logger logger) {
        this.logger = logger;
    }

    @Override // coil3.util.HardwareBitmapService
    public boolean allowHardwareMainThread(@NotNull Size size) {
        Dimension width = size.getWidth();
        boolean z = width instanceof Dimension.Pixels;
        int iM42unboximpl = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if ((z ? ((Dimension.Pixels) width).m42unboximpl() : Integer.MAX_VALUE) <= 100) {
            return false;
        }
        Dimension height = size.getHeight();
        if (height instanceof Dimension.Pixels) {
            iM42unboximpl = ((Dimension.Pixels) height).m42unboximpl();
        }
        return iM42unboximpl > 100;
    }

    @Override // coil3.util.HardwareBitmapService
    public boolean allowHardwareWorkerThread() {
        return FileDescriptorCounter.INSTANCE.hasAvailableFileDescriptors(this.logger);
    }
}

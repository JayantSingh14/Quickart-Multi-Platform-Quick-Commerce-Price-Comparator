package in.juspay.hypersdk.analytics;

import in.juspay.airborne.services.Workspace;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public final class LogWorkspace extends Workspace {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String LOGS_DIR_NAME = "juspay_logs";

    @JvmField
    @NotNull
    public final File logsDir;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogWorkspace(@NotNull Workspace workspace) {
        super(workspace);
        Intrinsics.checkNotNullParameter(workspace, "workspace");
        File fileOpenInCache = openInCache(LOGS_DIR_NAME);
        this.logsDir = fileOpenInCache;
        if (!fileOpenInCache.exists()) {
            fileOpenInCache.mkdir();
        }
        setRoot(fileOpenInCache);
    }
}

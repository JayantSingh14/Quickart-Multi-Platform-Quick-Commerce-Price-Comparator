package in.juspay.airborne;

import android.content.Context;
import androidx.annotation.Keep;
import in.juspay.airborne.ota.ApplicationManager;
import in.juspay.airborne.services.OTAServices;
import in.juspay.airborne.services.Workspace;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata
/* loaded from: classes4.dex */
public final class HyperOTAServices {

    @NotNull
    private final Context context;
    private final boolean fromAirborne;

    @Nullable
    private final Function1<String, Unit> onBootComplete;

    @NotNull
    private final OTAServices otaServices;

    @NotNull
    private final String releaseConfigTemplateUrl;

    @NotNull
    private final Workspace workspace;

    /* JADX WARN: Multi-variable type inference failed */
    public HyperOTAServices(@NotNull Context context, @NotNull String workSpacePath, @NotNull String appVersion, @NotNull String releaseConfigTemplateUrl, @NotNull TrackerCallback trackerCallback, @Nullable Function1<? super String, Unit> function1, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workSpacePath, "workSpacePath");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(releaseConfigTemplateUrl, "releaseConfigTemplateUrl");
        Intrinsics.checkNotNullParameter(trackerCallback, "trackerCallback");
        this.context = context;
        this.releaseConfigTemplateUrl = releaseConfigTemplateUrl;
        this.onBootComplete = function1;
        this.fromAirborne = z2;
        Workspace workspace = new Workspace(context, workSpacePath, z2);
        this.workspace = workspace;
        this.otaServices = new OTAServices(context, workspace, appVersion, z, trackerCallback, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApplicationManager createApplicationManager$default(HyperOTAServices hyperOTAServices, Map map, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            map = null;
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        return hyperOTAServices.createApplicationManager(map, str);
    }

    @Keep
    @NotNull
    public final ApplicationManager createApplicationManager(@Nullable Map<String, String> map, @Nullable String str) {
        return new ApplicationManager(this.context, this.releaseConfigTemplateUrl, this.otaServices, str, map, this.onBootComplete, this.fromAirborne);
    }

    @NotNull
    public final OTAServices getOtaServices() {
        return this.otaServices;
    }

    @NotNull
    public final Workspace getWorkspace() {
        return this.workspace;
    }

    public /* synthetic */ HyperOTAServices(Context context, String str, String str2, String str3, TrackerCallback trackerCallback, Function1 function1, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2, str3, trackerCallback, (i2 & 32) != 0 ? null : function1, (i2 & 64) != 0 ? false : z, (i2 & 128) != 0 ? true : z2);
    }
}

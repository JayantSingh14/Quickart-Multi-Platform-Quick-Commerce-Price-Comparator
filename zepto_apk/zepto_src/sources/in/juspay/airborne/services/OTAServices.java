package in.juspay.airborne.services;

import android.content.Context;
import in.juspay.airborne.TrackerCallback;
import in.juspay.hyperutil.constants.LogSubCategory;
import in.juspay.hyperutil.constants.OTAConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class OTAServices {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String TAG = "OTAServices";

    @NotNull
    private final String cleanUpValue;

    @Nullable
    private String clientId;

    @NotNull
    private final Context ctx;

    @NotNull
    private final FileProviderService fileProviderService;
    private final boolean fromAirborne;

    @NotNull
    private final RemoteAssetService remoteAssetService;

    @NotNull
    private final TrackerCallback trackerCallback;
    private final boolean useBundledAssets;

    @NotNull
    private final Workspace workspace;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public OTAServices(@NotNull Context ctx, @NotNull Workspace workspace, @NotNull String cleanUpValue, boolean z, @NotNull TrackerCallback trackerCallback, boolean z2) throws JSONException {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(workspace, "workspace");
        Intrinsics.checkNotNullParameter(cleanUpValue, "cleanUpValue");
        Intrinsics.checkNotNullParameter(trackerCallback, "trackerCallback");
        this.ctx = ctx;
        this.workspace = workspace;
        this.cleanUpValue = cleanUpValue;
        this.useBundledAssets = z;
        this.trackerCallback = trackerCallback;
        this.fromAirborne = z2;
        this.fileProviderService = new FileProviderService(this);
        this.remoteAssetService = new RemoteAssetService(this);
        firstTimeCleanup();
    }

    private final void firstTimeCleanup() throws JSONException {
        if (Intrinsics.b(this.workspace.getFromSharedPreference(OTAConstants.OTA_BUILD_ID, "__failed"), this.cleanUpValue)) {
            return;
        }
        TrackerCallback trackerCallback = this.trackerCallback;
        JSONObject jSONObjectPut = new JSONObject().put(CLConstants.OTP_STATUS, "started");
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(\"status\", \"started\")");
        trackerCallback.track("lifecycle", LogSubCategory.LifeCycle.HYPER_OTA, "info", "first_time_setup", "started", jSONObjectPut);
        this.workspace.writeToSharedPreference(OTAConstants.OTA_BUILD_ID, this.cleanUpValue);
        this.workspace.removeFromSharedPreference("asset_metadata.json");
        try {
            this.workspace.clean(this.ctx);
            TrackerCallback trackerCallback2 = this.trackerCallback;
            JSONObject jSONObjectPut2 = new JSONObject().put(CLConstants.OTP_STATUS, "completed");
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut2, "JSONObject().put(\"status\", \"completed\")");
            trackerCallback2.track("lifecycle", LogSubCategory.LifeCycle.HYPER_OTA, "info", "first_time_setup", "completed", jSONObjectPut2);
        } catch (Exception e2) {
            this.trackerCallback.trackAndLogException(TAG, "lifecycle", LogSubCategory.LifeCycle.HYPER_OTA, "first_time_setup", "Exception in firstTimeCleanUp", e2);
        }
    }

    @NotNull
    public final String getCleanUpValue() {
        return this.cleanUpValue;
    }

    @Nullable
    public final String getClientId() {
        return this.clientId;
    }

    @NotNull
    public final FileProviderService getFileProviderService() {
        return this.fileProviderService;
    }

    public final boolean getFromAirborne() {
        return this.fromAirborne;
    }

    @NotNull
    public final RemoteAssetService getRemoteAssetService() {
        return this.remoteAssetService;
    }

    @NotNull
    public final TrackerCallback getTrackerCallback() {
        return this.trackerCallback;
    }

    public final boolean getUseBundledAssets() {
        return this.useBundledAssets;
    }

    @NotNull
    public final Workspace getWorkspace() {
        return this.workspace;
    }

    public final void setClientId(@Nullable String str) {
        this.clientId = str;
    }

    public /* synthetic */ OTAServices(Context context, Workspace workspace, String str, boolean z, TrackerCallback trackerCallback, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, workspace, str, z, trackerCallback, (i2 & 32) != 0 ? true : z2);
    }
}

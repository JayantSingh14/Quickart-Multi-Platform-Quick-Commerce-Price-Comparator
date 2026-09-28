package in.juspay.airborne.ota;

import in.juspay.airborne.ota.ReleaseConfig;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata
/* loaded from: classes4.dex */
public final class Constants {

    @NotNull
    public static final String APP_DIR = "app";

    @NotNull
    public static final String CONFIG_FILE_NAME = "config.json";

    @NotNull
    private static final ReleaseConfig.PackageManifest DEFAULT_PKG;

    @NotNull
    private static final ReleaseConfig.ResourceManifest DEFAULT_RESOURCES;

    @NotNull
    public static final String DEFAULT_VERSION = "1";

    @NotNull
    public static final String PACKAGE_DIR_NAME = "package";

    @NotNull
    public static final String PACKAGE_MANIFEST_FILE_NAME = "pkg.json";

    @NotNull
    public static final String RC_VERSION_FILE_NAME = "rc_version.txt";

    @NotNull
    public static final String RESOURCES_DIR_NAME = "resources";

    @NotNull
    public static final String RESOURCES_FILE_NAME = "resources.json";

    @NotNull
    public static final Constants INSTANCE = new Constants();

    @NotNull
    private static final ReleaseConfig.Config DEFAULT_CONFIG = new ReleaseConfig.Config("v000000", 3000, 7000, new JSONObject());

    static {
        JSONObject jSONObject = new JSONObject();
        EmptyList emptyList = EmptyList.f53609a;
        DEFAULT_PKG = new ReleaseConfig.PackageManifest("", "v000000", jSONObject, null, emptyList, emptyList);
        DEFAULT_RESOURCES = new ReleaseConfig.ResourceManifest(emptyList);
    }

    private Constants() {
    }

    @NotNull
    public final ReleaseConfig.Config getDEFAULT_CONFIG() {
        return DEFAULT_CONFIG;
    }

    @NotNull
    public final ReleaseConfig.PackageManifest getDEFAULT_PKG() {
        return DEFAULT_PKG;
    }

    @NotNull
    public final ReleaseConfig.ResourceManifest getDEFAULT_RESOURCES() {
        return DEFAULT_RESOURCES;
    }
}

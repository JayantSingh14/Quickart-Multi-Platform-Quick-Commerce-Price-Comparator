package in.juspay.hyperutil.constants;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public final class OTAConstants {

    @NotNull
    public static final String ATTR_HASH_IN_DISK = "hashInDisk";

    @NotNull
    public static final String DECRYPTED_JSA_EXT = ".jsajs";

    @NotNull
    public static final OTAConstants INSTANCE = new OTAConstants();

    @NotNull
    public static final String OTA_BUILD_ID = "jp_hyper_ota_build_id";

    private OTAConstants() {
    }
}

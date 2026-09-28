package in.juspay.hypersdk.ota;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public final class Constants {

    @NotNull
    public static final Constants INSTANCE = new Constants();

    @NotNull
    public static final String PATCH_TOSS = "patch_toss";
    public static final int TOSS_TIMEOUT = 604800;

    private Constants() {
    }
}

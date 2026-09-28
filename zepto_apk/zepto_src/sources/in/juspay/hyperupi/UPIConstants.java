package in.juspay.hyperupi;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public final class UPIConstants {

    @NotNull
    public static final String DELIVERY_INTENT_BINDING = "useSmsDeliveryIntentForDeviceBinding";

    @NotNull
    public static final UPIConstants INSTANCE = new UPIConstants();

    @NotNull
    public static final String MOBILE_DATA = "MOBILE_DATA";

    @NotNull
    public static final String MOBILE_DATA_AND_WIFI = "MOBILE_DATA_AND_WIFI";

    @NotNull
    public static final String NETWORK_PERMISSION_DENIED = "NETWORK_PERMISSION_DENIED";

    @NotNull
    public static final String NETWORK_UNAVAILABLE = "NETWORK_UNAVAILABLE";

    @NotNull
    public static final String SMS_DELIVERY = "SMS_DELIVERY";

    @NotNull
    public static final String SMS_SENT = "SMS_SENT";

    @NotNull
    public static final String WIFI = "WIFI";

    private UPIConstants() {
    }
}

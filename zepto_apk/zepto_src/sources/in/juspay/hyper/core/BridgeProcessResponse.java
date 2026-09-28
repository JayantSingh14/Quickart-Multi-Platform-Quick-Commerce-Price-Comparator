package in.juspay.hyper.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata
/* loaded from: classes4.dex */
public final class BridgeProcessResponse {
    private final boolean processConsumed;

    @NotNull
    private final JSONObject reqPayload;

    public BridgeProcessResponse(boolean z, @NotNull JSONObject reqPayload) {
        Intrinsics.checkNotNullParameter(reqPayload, "reqPayload");
        this.processConsumed = z;
        this.reqPayload = reqPayload;
    }

    public final boolean getProcessConsumed() {
        return this.processConsumed;
    }

    @NotNull
    public final JSONObject getReqPayload() {
        return this.reqPayload;
    }
}

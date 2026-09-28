package in.juspay.hyper.bridge;

import android.content.Intent;
import in.juspay.hyper.core.BridgeComponents;
import in.juspay.hyper.core.BridgeProcessResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata
/* loaded from: classes4.dex */
public abstract class HyperBridge implements HBridge {

    @NotNull
    private final BridgeComponents bridgeComponents;

    public HyperBridge(@NotNull BridgeComponents bridgeComponents) {
        Intrinsics.checkNotNullParameter(bridgeComponents, "bridgeComponents");
        this.bridgeComponents = bridgeComponents;
    }

    @NotNull
    public final BridgeComponents getBridgeComponents() {
        return this.bridgeComponents;
    }

    @Override // in.juspay.hyper.bridge.HBridge
    @NotNull
    public String getInterfaceName() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) {
        return false;
    }

    public boolean onRequestPermissionResult(int i2, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        return false;
    }

    @NotNull
    public BridgeProcessResponse process(@NotNull JSONObject payload, @NotNull Function1<? super JSONObject, Unit> merchantCallback) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(merchantCallback, "merchantCallback");
        return new BridgeProcessResponse(false, payload);
    }

    public void reset() {
    }

    public void terminate() {
    }
}

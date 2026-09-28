package in.juspay.hyper.bridge;

import android.webkit.JavascriptInterface;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

@Metadata
/* loaded from: classes4.dex */
public final class BridgeList implements HBridge {

    @NotNull
    private final Map<String, HyperBridge> bridgeList = new LinkedHashMap();

    public final void addHyperBridge(@NotNull HyperBridge bridge) {
        Intrinsics.checkNotNullParameter(bridge, "bridge");
        this.bridgeList.put(bridge.getInterfaceName(), bridge);
    }

    @JavascriptInterface
    @NotNull
    public final String getBridgeKeys() {
        String string = new JSONArray((Collection) this.bridgeList.keySet()).toString();
        Intrinsics.checkNotNullExpressionValue(string, "JSONArray(bridgeList.keys).toString()");
        return string;
    }

    @NotNull
    public final Map<String, HyperBridge> getBridgeList() {
        return this.bridgeList;
    }

    @Override // in.juspay.hyper.bridge.HBridge
    @NotNull
    public String getInterfaceName() {
        Intrinsics.checkNotNullExpressionValue("BridgeList", "javaClass.simpleName");
        return "BridgeList";
    }
}

package in.juspay.services;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import in.juspay.hyper.bridge.HyperBridge;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@Keep
/* loaded from: classes4.dex */
public interface TenantParams {
    @Nullable
    default String getBaseContent() {
        return null;
    }

    @NonNull
    List<Class<? extends HyperBridge>> getBridgeClasses();

    @NonNull
    default Map<String, String> getHeaders() {
        HashMap map = new HashMap();
        map.put("os", "ANDROID");
        return map;
    }

    @Nullable
    default JSONObject getLogsEndPoint() {
        return null;
    }

    @Nullable
    default String getOTAEndPoint() {
        return null;
    }

    String getTenant();
}

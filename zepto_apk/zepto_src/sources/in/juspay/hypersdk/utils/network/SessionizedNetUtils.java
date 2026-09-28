package in.juspay.hypersdk.utils.network;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import in.juspay.hyper.core.JuspayCoreLib;
import in.juspay.hypersdk.data.SessionInfo;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class SessionizedNetUtils extends HyperNetUtils {

    @NonNull
    private final SessionInfo sessionInfo;

    public SessionizedNetUtils(@NonNull SessionInfo sessionInfo, @IntRange int i2, @IntRange int i3, boolean z) {
        super(JuspayCoreLib.getApplicationContext(), i2, i3, z);
        this.sessionInfo = sessionInfo;
    }

    private String trimClientId(@NonNull String str) {
        Matcher matcher = Pattern.compile("^(.*)_android$", 2).matcher(str);
        return (!matcher.matches() || matcher.groupCount() <= 0) ? str : matcher.group(1);
    }

    @Override // in.juspay.hypersdk.utils.network.HyperNetUtils, in.juspay.airborne.network.NetUtils
    @NonNull
    public Map<String, String> getDefaultSDKHeaders() {
        Map<String, String> defaultSDKHeaders = super.getDefaultSDKHeaders();
        defaultSDKHeaders.put("x-merchant-id", this.sessionInfo.tryGetMerchantId());
        String strTryGetClientId = this.sessionInfo.tryGetClientId();
        if (strTryGetClientId != null) {
            strTryGetClientId = trimClientId(strTryGetClientId);
        }
        defaultSDKHeaders.put("x-client-id", strTryGetClientId);
        return defaultSDKHeaders;
    }
}

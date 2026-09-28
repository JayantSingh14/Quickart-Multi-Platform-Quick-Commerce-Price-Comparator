package in.juspay.hypersdk.safe;

import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import in.juspay.airborne.ota.Constants;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hypersdk.core.JBridge;
import in.juspay.hypersdk.core.v;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class JuspayWebChromeClient extends WebChromeClient {

    @NonNull
    private final Godel godelManager;

    public JuspayWebChromeClient(@NonNull Godel godel) {
        this.godelManager = godel;
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest permissionRequest) throws JSONException {
        if (permissionRequest == null) {
            super.onPermissionRequest(permissionRequest);
            return;
        }
        try {
            String[] resources = permissionRequest.getResources();
            if (resources == null || resources.length <= 0) {
                super.onPermissionRequest(permissionRequest);
                return;
            }
            String strCachePermissionRequest = JBridge.cachePermissionRequest(permissionRequest);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", strCachePermissionRequest);
            JSONArray jSONArray = new JSONArray();
            for (String str : resources) {
                jSONArray.put(str);
            }
            jSONObject.put(Constants.RESOURCES_DIR_NAME, jSONArray);
            jSONObject.put("origin", permissionRequest.getOrigin().toString());
            this.godelManager.getDuiInterface().invokeFnInDUIWebview("onPermissionRequest", jSONObject.toString());
        } catch (Exception unused) {
            ExecutorManager.runOnMainThread(new v(permissionRequest, 1));
        }
    }

    @Override // android.webkit.WebChromeClient
    @CallSuper
    public void onProgressChanged(WebView webView, int i2) {
        super.onProgressChanged(webView, i2);
        this.godelManager.getDuiInterface().invokeFnInDUIWebview("onProgressChanged", String.valueOf(i2));
    }
}

package in.juspay.hypersdk.core;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class RedirectResponseActivity extends Activity {
    public static final String DEEPLINK_RESULT_ACTION = "deeplink-result";

    private void handleDeepLink(Intent intent) throws JSONException {
        if ("android.intent.action.VIEW".equals(intent.getAction())) {
            Uri data = intent.getData();
            if (data != null && "juspayexternalapp".equals(data.getScheme()) && getPackageName().equals(data.getHost())) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (String str : data.getQueryParameterNames()) {
                        jSONObject.put(str, data.getQueryParameter(str));
                    }
                    jSONObject.put("path", data.getPath() != null ? data.getPath() : "");
                    jSONObject.put("fragment", data.getFragment() != null ? data.getFragment() : "");
                    sendResultToWebViewUsingBroadcast(jSONObject.toString());
                    setResult(-1);
                } catch (Exception e2) {
                    sendErrorToWebViewUsingBroadcast("Exception parsing deep link: " + e2.getMessage());
                    setResult(0);
                }
            } else {
                sendErrorToWebViewUsingBroadcast(android.support.v4.media.a.l(data, "Invalid deep link URI: "));
                setResult(0);
            }
        } else {
            sendErrorToWebViewUsingBroadcast("Invalid intent action");
            setResult(0);
        }
        finish();
    }

    private void sendErrorToWebViewUsingBroadcast(String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", str);
            sendResultToWebViewUsingBroadcast(jSONObject.toString());
        } catch (Exception unused) {
            sendResultToWebViewUsingBroadcast("{\"error\":\"Unknown error\"}");
        }
    }

    private void sendResultToWebViewUsingBroadcast(String str) {
        Intent intent = new Intent(DEEPLINK_RESULT_ACTION);
        intent.putExtra("redirect_result", str);
        LocalBroadcastManager.a(this).c(intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws JSONException {
        super.onCreate(bundle);
        handleDeepLink(getIntent());
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) throws JSONException {
        super.onNewIntent(intent);
        handleDeepLink(intent);
    }
}

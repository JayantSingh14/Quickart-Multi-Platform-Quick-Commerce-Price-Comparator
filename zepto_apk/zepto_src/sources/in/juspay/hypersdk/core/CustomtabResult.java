package in.juspay.hypersdk.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import in.juspay.hyper.core.JuspayLogger;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class CustomtabResult extends Activity {
    public static final String CUSTOMTAB_RESULT = "customtab-result";
    private static final String LOG_TAG = "CustomtabResult";

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent("customtab-result");
        try {
            intent.putExtra("response", getIntent().getDataString());
        } catch (Exception e2) {
            JuspayLogger.e(LOG_TAG, "Couldn't find data from url", e2);
        }
        intent.putExtra(CLConstants.OTP_STATUS, MerchantConstants.SUCCESS);
        LocalBroadcastManager.a(this).c(intent);
        startActivity(new Intent(this, (Class<?>) CustomtabActivity.class));
        finish();
    }
}

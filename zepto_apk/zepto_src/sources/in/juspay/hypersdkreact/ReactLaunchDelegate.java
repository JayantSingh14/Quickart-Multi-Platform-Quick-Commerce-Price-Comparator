package in.juspay.hypersdkreact;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.react.bridge.ReactApplicationContext;
import in.juspay.hypersdk.ui.ActivityLaunchDelegate;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
final class ReactLaunchDelegate implements ActivityLaunchDelegate {
    private static final Set<Integer> intentRequestCodes = new HashSet();
    private final ReactApplicationContext context;

    public ReactLaunchDelegate(ReactApplicationContext reactApplicationContext) {
        this.context = reactApplicationContext;
    }

    public static Set<Integer> getIntentRequestCodes() {
        return intentRequestCodes;
    }

    @Override // in.juspay.hypersdk.ui.ActivityLaunchDelegate
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        intentRequestCodes.add(Integer.valueOf(i2));
        this.context.startActivityForResult(intent, i2, bundle);
    }
}

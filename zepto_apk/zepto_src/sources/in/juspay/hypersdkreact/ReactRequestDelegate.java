package in.juspay.hypersdkreact;

import android.app.Activity;
import androidx.annotation.NonNull;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.ui.RequestPermissionDelegate;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
final class ReactRequestDelegate implements RequestPermissionDelegate {
    private static final Set<Integer> permissionRequestCodes = new HashSet();

    @NonNull
    private final WeakReference<Activity> activity;

    public ReactRequestDelegate(Activity activity) {
        this.activity = new WeakReference<>(activity);
    }

    public static Set<Integer> getPermissionRequestCodes() {
        return permissionRequestCodes;
    }

    @Override // in.juspay.hypersdk.ui.RequestPermissionDelegate
    public void requestPermission(String[] strArr, int i2) {
        SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", "hyper_sdk_react", "requestPermission", "requestPermission() called with: permissions = [" + Arrays.toString(strArr) + "], requestCode = [" + i2 + "]");
        Activity activity = this.activity.get();
        if (activity != null) {
            permissionRequestCodes.add(Integer.valueOf(i2));
            activity.requestPermissions(strArr, i2);
        }
    }
}

package in.juspay.hypersdkreact;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes4.dex */
public class ProcessActivity extends AppCompatActivity {

    @Nullable
    private static ActivityCallback activityCallback;

    public static void setActivityCallback(@Nullable ActivityCallback activityCallback2) {
        activityCallback = activityCallback2;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ActivityCallback activityCallback2 = activityCallback;
        if (activityCallback2 == null || activityCallback2.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        ActivityCallback activityCallback2 = activityCallback;
        if (activityCallback2 != null) {
            activityCallback2.onCreated(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ActivityCallback activityCallback2 = activityCallback;
        if (activityCallback2 != null) {
            activityCallback2.resetActivity(this);
        }
        super.onDestroy();
    }
}

package in.juspay.hypersmshandler;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata
/* loaded from: classes4.dex */
public final class DeliverReceiver extends BroadcastReceiver implements JuspayDuiHook {
    @Override // in.juspay.hypersmshandler.JuspayDuiHook
    public final void attach(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Build.VERSION.SDK_INT >= 33) {
            activity.registerReceiver(this, new IntentFilter("SMS_DELIVERED"), 2);
        } else {
            activity.registerReceiver(this, new IntentFilter("SMS_DELIVERED"));
        }
    }

    @Override // in.juspay.hypersmshandler.JuspayDuiHook
    public final void detach(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.unregisterReceiver(this);
    }

    @Override // in.juspay.hypersmshandler.JuspayDuiHook
    public final String execute(Activity activity, String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return null;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        int resultCode = getResultCode();
        if (resultCode == -1) {
            Toast.makeText(context, "SMS DELIVERED", 0).show();
        } else {
            if (resultCode != 0) {
                return;
            }
            Toast.makeText(context, "SMS NOT DELIVERED", 0).show();
        }
    }
}

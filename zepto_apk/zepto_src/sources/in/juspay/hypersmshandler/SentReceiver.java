package in.juspay.hypersmshandler;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import in.juspay.hyperupi.UPIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata
/* loaded from: classes4.dex */
public final class SentReceiver extends BroadcastReceiver implements JuspayDuiHook {

    /* renamed from: a, reason: collision with root package name */
    public final SmsComponents f48733a;

    public SentReceiver(SmsComponents smsComponents) {
        Intrinsics.checkNotNullParameter(smsComponents, "smsComponents");
        this.f48733a = smsComponents;
    }

    @Override // in.juspay.hypersmshandler.JuspayDuiHook
    public final void attach(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Build.VERSION.SDK_INT >= 33) {
            activity.registerReceiver(this, new IntentFilter(UPIConstants.SMS_SENT), 2);
        } else {
            activity.registerReceiver(this, new IntentFilter(UPIConstants.SMS_SENT));
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
        this.f48733a.getSmsEventInterface().onSentReceiverEvent(getResultCode());
    }
}

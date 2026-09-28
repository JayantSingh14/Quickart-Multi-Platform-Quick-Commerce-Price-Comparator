package in.juspay.hyperupi;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.telephony.SmsManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.core.TrackerInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes4.dex */
public final class SimUtils {

    @NotNull
    public static final SimUtils INSTANCE = new SimUtils();
    private static final String LOG_TAG = "SimUtils";

    private SimUtils() {
    }

    public final boolean isDualSim(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ContextCompat.a(context, "android.permission.READ_PHONE_STATE") == 0 && SubscriptionManager.from(context).getActiveSubscriptionInfoCount() > 1;
    }

    public final boolean isSimSupport(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("phone");
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        return (telephonyManager == null || telephonyManager.getSimState() == 1) ? false : true;
    }

    @TargetApi(22)
    public final void sendSMS(@NotNull Context ctx, @NotNull TrackerInterface trackerInterface, int i2, @Nullable String str, @Nullable String str2, @Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(trackerInterface, "trackerInterface");
        try {
            if (!isDualSim(ctx)) {
                SmsManager.getDefault().sendTextMessage(str, null, str2, pendingIntent, pendingIntent2);
                return;
            }
            ArrayList arrayList = new ArrayList();
            List<SubscriptionInfo> activeSubscriptionInfoList = SubscriptionManager.from(ctx).getActiveSubscriptionInfoList();
            if (activeSubscriptionInfoList != null) {
                Iterator<SubscriptionInfo> it = activeSubscriptionInfoList.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(it.next().getSubscriptionId()));
                }
            }
            Object obj = arrayList.get(i2);
            Intrinsics.checkNotNullExpressionValue(obj, "subIds[simID]");
            SmsManager.getSmsManagerForSubscriptionId(((Number) obj).intValue()).sendTextMessage(str, null, str2, pendingIntent, pendingIntent2);
        } catch (Exception e2) {
            String LOG_TAG2 = LOG_TAG;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
            trackerInterface.trackAndLogException(LOG_TAG2, "action", "system", Labels.System.UTIL, "Exception while sending SMS", e2);
        }
    }
}

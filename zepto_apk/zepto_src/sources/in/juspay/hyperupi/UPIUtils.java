package in.juspay.hyperupi;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogLevel;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.BridgeComponents;
import in.juspay.hyper.core.JsCallback;
import in.juspay.hyper.core.TrackerInterface;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes4.dex */
public final class UPIUtils {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final String LOG_TAG = "UPIUtils";

    @NotNull
    private final BridgeComponents bridgeComponents;

    @NotNull
    private final Context context;
    private final int deliveryFailedCode;
    private boolean isBindStarted;
    private int smsSendingTryCount;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata
    public final class SendSmsThread extends Thread {
        private boolean bindDeviceOnDeliveryIntent;

        @Nullable
        private final String callback;
        private int counter;
        private boolean isInterrupted;
        private final int length;

        @NotNull
        private final String mobileNumber;

        @NotNull
        private final OnRegisterCallback onRegisterCallback;

        @NotNull
        private final String simSlot;

        @Nullable
        private Thread smsTimeoutThread;
        final /* synthetic */ UPIUtils this$0;

        @Nullable
        private final String token;
        private final int tries;

        @Metadata
        public abstract class SMSBroadcastReceiver extends BroadcastReceiver implements ResetCallback {
            private boolean isRegistered;

            public SMSBroadcastReceiver() {
            }

            public final synchronized void registerWithFlag(@NotNull OnRegisterCallback onRegisterCallback) {
                try {
                    Intrinsics.checkNotNullParameter(onRegisterCallback, "onRegisterCallback");
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 33) {
                        SendSmsThread.this.this$0.context.registerReceiver(this, new IntentFilter(UPIConstants.SMS_SENT + SendSmsThread.this.getMobileNumber()), 2);
                    } else {
                        SendSmsThread.this.this$0.context.registerReceiver(this, new IntentFilter(UPIConstants.SMS_SENT + SendSmsThread.this.getMobileNumber()));
                    }
                    if (SendSmsThread.this.getBindDeviceOnDeliveryIntent()) {
                        if (i2 >= 33) {
                            SendSmsThread.this.this$0.context.registerReceiver(this, new IntentFilter(UPIConstants.SMS_DELIVERY + SendSmsThread.this.getMobileNumber()), 2);
                        } else {
                            SendSmsThread.this.this$0.context.registerReceiver(this, new IntentFilter(UPIConstants.SMS_DELIVERY + SendSmsThread.this.getMobileNumber()));
                        }
                    }
                    this.isRegistered = true;
                    onRegisterCallback.onRegistered(this);
                } catch (Throwable th) {
                    throw th;
                }
            }

            @Override // in.juspay.hyperupi.ResetCallback
            public void reset() {
                unregisterWithFlag();
            }

            public final synchronized void unregisterWithFlag() {
                if (this.isRegistered) {
                    this.isRegistered = false;
                    SendSmsThread.this.this$0.context.unregisterReceiver(this);
                }
            }
        }

        public SendSmsThread(@NotNull UPIUtils uPIUtils, @NotNull String simSlot, @Nullable String mobileNumber, @Nullable String str, String str2, int i2, @NotNull int i3, OnRegisterCallback onRegisterCallback) {
            Intrinsics.checkNotNullParameter(simSlot, "simSlot");
            Intrinsics.checkNotNullParameter(mobileNumber, "mobileNumber");
            Intrinsics.checkNotNullParameter(onRegisterCallback, "onRegisterCallback");
            this.this$0 = uPIUtils;
            this.simSlot = simSlot;
            this.mobileNumber = mobileNumber;
            this.token = str;
            this.callback = str2;
            this.tries = i2;
            this.length = i3;
            this.onRegisterCallback = onRegisterCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void sendCallback(SMSBroadcastReceiver sMSBroadcastReceiver, int i2, int i3) {
            String strR;
            this.this$0.bridgeComponents.getTrackerInterface().trackAction(LogSubCategory.ApiCall.SDK, "info", Labels.System.UPI_UTILS, "SMS Callback", android.support.v4.media.b.d(i2, i3, "resultCode : ", ", errorCode : "));
            sMSBroadcastReceiver.unregisterWithFlag();
            if (this.callback == null) {
                return;
            }
            if (i2 == -1) {
                strR = android.support.v4.media.b.r(new StringBuilder("window.callUICallback(\""), this.callback, "\", \"SUCCESS\")");
            } else if (i2 == 1) {
                StringBuilder sb = new StringBuilder("window.callUICallback(\"");
                sb.append(this.callback);
                sb.append("\", \"GENERIC_FAILURE");
                strR = android.support.v4.media.b.r(sb, i3 == 0 ? "" : android.support.v4.media.b.f(i3, Attributes.PREDEFINED_ATTRIBUTE_PREFIX), "\", \"837\")");
            } else {
                strR = i2 == 4 ? android.support.v4.media.b.r(new StringBuilder("window.callUICallback(\""), this.callback, "\", \"NO_SERVICE\", \"838\")") : i2 == 3 ? android.support.v4.media.b.r(new StringBuilder("window.callUICallback(\""), this.callback, "\", \"NULL_PDU\", \"839\")") : i2 == 2 ? android.support.v4.media.b.r(new StringBuilder("window.callUICallback(\""), this.callback, "\", \"RADIO_OFF\", \"840\")") : i3 == this.this$0.deliveryFailedCode ? android.support.v4.media.b.r(new StringBuilder("window.callUICallback(\""), this.callback, "\", \"DELIVERY_FAILED\", \"841\")") : android.support.v4.media.b.r(new StringBuilder("window.callUICallback(\""), this.callback, "\", \"EXCEPTION\", \"837\")");
            }
            JsCallback jsCallback = this.this$0.bridgeComponents.getJsCallback();
            if (jsCallback != null) {
                jsCallback.addJsToWebView(strR);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void sendSMS(final PendingIntent pendingIntent, final PendingIntent pendingIntent2, final SMSBroadcastReceiver sMSBroadcastReceiver) throws NumberFormatException {
            this.counter++;
            this.isInterrupted = false;
            SimUtils.INSTANCE.sendSMS(this.this$0.context, this.this$0.bridgeComponents.getTrackerInterface(), Integer.parseInt(this.simSlot), this.mobileNumber, this.token + ' ' + this.mobileNumber, pendingIntent, pendingIntent2);
            Thread thread = this.smsTimeoutThread;
            if (thread != null) {
                thread.interrupt();
            }
            final UPIUtils uPIUtils = this.this$0;
            Thread thread2 = new Thread() { // from class: in.juspay.hyperupi.UPIUtils$SendSmsThread$sendSMS$1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws InterruptedException, NumberFormatException {
                    super.run();
                    try {
                        Thread.sleep(15000L);
                    } catch (InterruptedException e2) {
                        TrackerInterface trackerInterface = uPIUtils.bridgeComponents.getTrackerInterface();
                        String LOG_TAG = UPIUtils.LOG_TAG;
                        Intrinsics.checkNotNullExpressionValue(LOG_TAG, "LOG_TAG");
                        trackerInterface.trackAndLogException(LOG_TAG, "action", "system", Labels.System.UPI_UTILS, "SendSMS InterruptedException", e2);
                    }
                    if (isInterrupted()) {
                        return;
                    }
                    if (this.counter < this.getTries()) {
                        this.sendSMS(pendingIntent, pendingIntent2, sMSBroadcastReceiver);
                        return;
                    }
                    if (!uPIUtils.isBindStarted() && uPIUtils.getSmsSendingTryCount() == this.getLength()) {
                        this.sendCallback(sMSBroadcastReceiver, 0, uPIUtils.deliveryFailedCode);
                        return;
                    }
                    UPIUtils uPIUtils2 = uPIUtils;
                    synchronized (this) {
                        uPIUtils2.setSmsSendingTryCount(uPIUtils2.getSmsSendingTryCount() + 1);
                    }
                    try {
                        sMSBroadcastReceiver.unregisterWithFlag();
                    } catch (Exception e3) {
                        TrackerInterface trackerInterface2 = uPIUtils.bridgeComponents.getTrackerInterface();
                        String LOG_TAG2 = UPIUtils.LOG_TAG;
                        Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
                        trackerInterface2.trackAndLogException(LOG_TAG2, "action", "system", Labels.System.UPI_UTILS, "SendSMS Unregistering Receiver Exception", e3);
                    }
                }
            };
            this.smsTimeoutThread = thread2;
            thread2.start();
        }

        public final boolean getBindDeviceOnDeliveryIntent() {
            return this.bindDeviceOnDeliveryIntent;
        }

        @Nullable
        public final String getCallback() {
            return this.callback;
        }

        public final int getLength() {
            return this.length;
        }

        @NotNull
        public final String getMobileNumber() {
            return this.mobileNumber;
        }

        @Nullable
        public final String getToken() {
            return this.token;
        }

        public final int getTries() {
            return this.tries;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws NumberFormatException {
            final PendingIntent broadcast;
            this.bindDeviceOnDeliveryIntent = this.this$0.bridgeComponents.getSdkConfig().optBoolean(UPIConstants.DELIVERY_INTENT_BINDING, false);
            final PendingIntent broadcast2 = PendingIntent.getBroadcast(this.this$0.context, 0, new Intent(UPIConstants.SMS_SENT + this.mobileNumber), 67108864);
            if (this.bindDeviceOnDeliveryIntent) {
                broadcast = PendingIntent.getBroadcast(this.this$0.context, 0, new Intent(UPIConstants.SMS_DELIVERY + this.mobileNumber), 67108864);
            } else {
                broadcast = null;
            }
            final UPIUtils uPIUtils = this.this$0;
            SMSBroadcastReceiver sMSBroadcastReceiver = new SMSBroadcastReceiver() { // from class: in.juspay.hyperupi.UPIUtils$SendSmsThread$run$sentSmsListener$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(@NotNull Context context, @Nullable Intent intent) throws NumberFormatException {
                    Bundle extras;
                    Intrinsics.checkNotNullParameter(context, "context");
                    int resultCode = getResultCode();
                    int i2 = 0;
                    if (intent != null && intent.getExtras() != null && (extras = intent.getExtras()) != null) {
                        i2 = extras.getInt(CLConstants.FIELD_ERROR_CODE);
                    }
                    if (resultCode == -1 && !uPIUtils.isBindStarted() && !this.this$0.getBindDeviceOnDeliveryIntent()) {
                        uPIUtils.setBindStarted(true);
                        this.this$0.sendCallback(this, resultCode, i2);
                        return;
                    }
                    if (resultCode != -1 && this.this$0.counter < this.this$0.getTries()) {
                        this.this$0.sendSMS(broadcast2, broadcast, this);
                        return;
                    }
                    if (!uPIUtils.isBindStarted() && uPIUtils.getSmsSendingTryCount() == this.this$0.getLength()) {
                        this.this$0.sendCallback(this, resultCode, i2);
                        return;
                    }
                    UPIUtils uPIUtils2 = uPIUtils;
                    synchronized (this) {
                        uPIUtils2.setSmsSendingTryCount(uPIUtils2.getSmsSendingTryCount() + 1);
                    }
                    unregisterWithFlag();
                }
            };
            sMSBroadcastReceiver.registerWithFlag(this.onRegisterCallback);
            sendSMS(broadcast2, broadcast, sMSBroadcastReceiver);
            if (this.bindDeviceOnDeliveryIntent) {
                final UPIUtils uPIUtils2 = this.this$0;
                new SMSBroadcastReceiver() { // from class: in.juspay.hyperupi.UPIUtils$SendSmsThread$run$deliverSmsListener$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super();
                    }

                    @Override // android.content.BroadcastReceiver
                    public void onReceive(@NotNull Context context, @NotNull Intent intent) throws NumberFormatException {
                        Intrinsics.checkNotNullParameter(context, "context");
                        Intrinsics.checkNotNullParameter(intent, "intent");
                        int resultCode = getResultCode();
                        this.this$0.isInterrupted = true;
                        if (resultCode == -1 && !uPIUtils2.isBindStarted()) {
                            uPIUtils2.setBindStarted(true);
                            this.this$0.sendCallback(this, -1, 0);
                            return;
                        }
                        if (resultCode != -1 && this.this$0.counter < this.this$0.getTries()) {
                            this.this$0.sendSMS(broadcast2, broadcast, this);
                            return;
                        }
                        if (!uPIUtils2.isBindStarted() && uPIUtils2.getSmsSendingTryCount() == this.this$0.getLength()) {
                            this.this$0.sendCallback(this, resultCode, uPIUtils2.deliveryFailedCode);
                            return;
                        }
                        UPIUtils uPIUtils3 = uPIUtils2;
                        synchronized (this) {
                            uPIUtils3.setSmsSendingTryCount(uPIUtils3.getSmsSendingTryCount() + 1);
                        }
                        try {
                            unregisterWithFlag();
                        } catch (Exception e2) {
                            TrackerInterface trackerInterface = uPIUtils2.bridgeComponents.getTrackerInterface();
                            String LOG_TAG = UPIUtils.LOG_TAG;
                            Intrinsics.checkNotNullExpressionValue(LOG_TAG, "LOG_TAG");
                            trackerInterface.trackAndLogException(LOG_TAG, "action", "system", Labels.System.UPI_UTILS, "Unregistering Receiver Exception", e2);
                        }
                    }
                }.registerWithFlag(this.onRegisterCallback);
            }
        }

        public final void setBindDeviceOnDeliveryIntent(boolean z) {
            this.bindDeviceOnDeliveryIntent = z;
        }
    }

    public UPIUtils(@NotNull BridgeComponents bridgeComponents) {
        Intrinsics.checkNotNullParameter(bridgeComponents, "bridgeComponents");
        this.bridgeComponents = bridgeComponents;
        this.deliveryFailedCode = 9999;
        this.context = bridgeComponents.getContext();
    }

    private final String getSubscriberId() {
        String string;
        JSONArray jSONArray = new JSONArray();
        SubscriptionManager subscriptionManager = (SubscriptionManager) this.context.getSystemService(SubscriptionManager.class);
        List<SubscriptionInfo> activeSubscriptionInfoList = subscriptionManager != null ? subscriptionManager.getActiveSubscriptionInfoList() : null;
        if (activeSubscriptionInfoList != null) {
            Iterator<SubscriptionInfo> it = activeSubscriptionInfoList.iterator();
            while (it.hasNext()) {
                jSONArray.put(String.valueOf(it.next().getSubscriptionId()));
            }
            string = jSONArray.toString();
        } else {
            string = "SIM_CARD_NOT_AVAILABLE";
        }
        Intrinsics.checkNotNullExpressionValue(string, "{\n            val simDet…\"\n            }\n        }");
        return string;
    }

    @NotNull
    public final String getContactList() throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", false);
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor cursorQuery = this.context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"display_name", "data1"}, null, null, "display_name ASC");
            if (cursorQuery != null) {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    while (cursor2.moveToNext()) {
                        String string = cursor2.getString(cursor2.getColumnIndexOrThrow("display_name"));
                        String string2 = cursor2.getString(cursor2.getColumnIndexOrThrow("data1"));
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(CLConstants.FIELD_PAY_INFO_NAME, string);
                        jSONObject2.put("mobileNumber", string2);
                        jSONArray.put(jSONObject2);
                    }
                    Unit unit = Unit.f53572a;
                    cursor.close();
                } finally {
                }
            }
            jSONObject.put(PaymentConstants.PAYLOAD, jSONArray);
        } catch (Exception e2) {
            TrackerInterface trackerInterface = this.bridgeComponents.getTrackerInterface();
            String LOG_TAG2 = LOG_TAG;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
            trackerInterface.trackAndLogException(LOG_TAG2, "action", "system", Labels.System.UPI_UTILS, "GetContactList Exception", e2);
            jSONObject.put("error", true);
            jSONObject.put(PaymentConstants.PAYLOAD, e2.toString());
        }
        String string3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string3, "response.toString()");
        return string3;
    }

    @SuppressLint({"HardwareIds"})
    @NotNull
    public final String getDeviceDetails() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", "ANDROID");
            jSONObject.put("androidAPILevel", String.valueOf(Build.VERSION.SDK_INT));
            jSONObject.put("version", Build.VERSION.RELEASE);
            jSONObject.put("appVersion", this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put("geocode", "");
            jSONObject.put("location", "");
            jSONObject.put("capability", "");
            jSONObject.put("ip", "");
            jSONObject.put("packageName", this.context.getPackageName());
            jSONObject.put(CLConstants.SALT_FIELD_DEVICE_ID, this.bridgeComponents.getSessionInfoInterface().getDeviceId());
            jSONObject.put("subscriberId", getSubscriberId());
            jSONObject.put("androidId", Settings.Secure.getString(this.context.getContentResolver(), "android_id"));
        } catch (Exception e2) {
            TrackerInterface trackerInterface = this.bridgeComponents.getTrackerInterface();
            String LOG_TAG2 = LOG_TAG;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
            trackerInterface.trackAndLogException(LOG_TAG2, "action", "system", Labels.System.UPI_UTILS, "GetDeviceDetails Exception", e2);
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "deviceDetails.toString()");
        return string;
    }

    @Nullable
    public final String getSimOperators() {
        try {
            JSONArray jSONArray = new JSONArray();
            int i2 = Build.VERSION.SDK_INT;
            SubscriptionManager subscriptionManager = (SubscriptionManager) this.context.getSystemService(SubscriptionManager.class);
            List<SubscriptionInfo> activeSubscriptionInfoList = subscriptionManager != null ? subscriptionManager.getActiveSubscriptionInfoList() : null;
            if (activeSubscriptionInfoList != null) {
                int i3 = 0;
                for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(CLConstants.SHARED_PREFERENCE_ITEM_ID, String.valueOf(i3));
                    jSONObject.put("simSerialNo", String.valueOf(subscriptionInfo.getSubscriptionId()));
                    jSONObject.put("provider", subscriptionInfo.getCarrierName());
                    jSONArray.put(jSONObject);
                    i3++;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("simDetails", jSONArray);
                return jSONObject2.toString();
            }
            if (i2 >= 34) {
                List allSubscriptionInfoList = subscriptionManager != null ? subscriptionManager.getAllSubscriptionInfoList() : null;
                if (allSubscriptionInfoList != null) {
                    this.bridgeComponents.getTrackerInterface().trackLifecycle(LogSubCategory.Action.USER, LogLevel.CRITICAL, Labels.System.UPI_UTILS, "GetSIMOperators FAILED : allSubscriptionInfoList", allSubscriptionInfoList);
                }
            }
            if (i2 >= 30) {
                List completeActiveSubscriptionInfoList = subscriptionManager != null ? subscriptionManager.getCompleteActiveSubscriptionInfoList() : null;
                if (completeActiveSubscriptionInfoList != null) {
                    this.bridgeComponents.getTrackerInterface().trackLifecycle(LogSubCategory.Action.USER, LogLevel.CRITICAL, Labels.System.UPI_UTILS, "GetSIMOperators FAILED : completeActiveSubscriptionInfoList", completeActiveSubscriptionInfoList);
                }
            }
            if (i2 < 28) {
                return "SIM_CARD_NOT_AVAILABLE";
            }
            List accessibleSubscriptionInfoList = subscriptionManager != null ? subscriptionManager.getAccessibleSubscriptionInfoList() : null;
            if (accessibleSubscriptionInfoList == null) {
                return "SIM_CARD_NOT_AVAILABLE";
            }
            this.bridgeComponents.getTrackerInterface().trackLifecycle(LogSubCategory.Action.USER, LogLevel.CRITICAL, Labels.System.UPI_UTILS, "GetSIMOperators FAILED : accessibleSubscriptionInfoList", accessibleSubscriptionInfoList);
            return "SIM_CARD_NOT_AVAILABLE";
        } catch (Exception e2) {
            TrackerInterface trackerInterface = this.bridgeComponents.getTrackerInterface();
            String LOG_TAG2 = LOG_TAG;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
            trackerInterface.trackAndLogException(LOG_TAG2, "action", "system", Labels.System.UPI_UTILS, "GetSIMOperators Exception", e2);
            return null;
        }
    }

    public final int getSmsSendingTryCount() {
        return this.smsSendingTryCount;
    }

    public final boolean isAirplaneModeOn() {
        return Settings.Global.getInt(this.context.getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    public final boolean isBindStarted() {
        return this.isBindStarted;
    }

    public final boolean isSimActive(int i2) {
        SubscriptionInfo subscriptionInfo;
        TelephonyManager telephonyManagerCreateForSubscriptionId;
        SubscriptionInfo subscriptionInfo2;
        if (Build.VERSION.SDK_INT >= 26) {
            SubscriptionManager subscriptionManager = (SubscriptionManager) this.context.getSystemService(SubscriptionManager.class);
            List<SubscriptionInfo> activeSubscriptionInfoList = subscriptionManager != null ? subscriptionManager.getActiveSubscriptionInfoList() : null;
            if (activeSubscriptionInfoList == null || (subscriptionInfo2 = activeSubscriptionInfoList.get(i2)) == null) {
                return false;
            }
            int simSlotIndex = subscriptionInfo2.getSimSlotIndex();
            Object systemService = this.context.getSystemService("phone");
            telephonyManagerCreateForSubscriptionId = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
            return telephonyManagerCreateForSubscriptionId != null && telephonyManagerCreateForSubscriptionId.getSimState(simSlotIndex) == 5;
        }
        SubscriptionManager subscriptionManager2 = (SubscriptionManager) this.context.getSystemService(SubscriptionManager.class);
        List<SubscriptionInfo> activeSubscriptionInfoList2 = subscriptionManager2 != null ? subscriptionManager2.getActiveSubscriptionInfoList() : null;
        if (activeSubscriptionInfoList2 == null || (subscriptionInfo = activeSubscriptionInfoList2.get(i2)) == null) {
            return false;
        }
        int subscriptionId = subscriptionInfo.getSubscriptionId();
        Object systemService2 = this.context.getSystemService("phone");
        TelephonyManager telephonyManager = systemService2 instanceof TelephonyManager ? (TelephonyManager) systemService2 : null;
        telephonyManagerCreateForSubscriptionId = telephonyManager != null ? telephonyManager.createForSubscriptionId(subscriptionId) : null;
        return telephonyManagerCreateForSubscriptionId != null && telephonyManagerCreateForSubscriptionId.getSimState() == 5;
    }

    public final void sendSms(@NotNull String simSlot, @NotNull String[] mobileNumbers, @Nullable String str, @NotNull String tries, @Nullable String str2, @NotNull OnRegisterCallback onRegisterCallback) {
        Intrinsics.checkNotNullParameter(simSlot, "simSlot");
        Intrinsics.checkNotNullParameter(mobileNumbers, "mobileNumbers");
        Intrinsics.checkNotNullParameter(tries, "tries");
        OnRegisterCallback onRegisterCallback2 = onRegisterCallback;
        Intrinsics.checkNotNullParameter(onRegisterCallback2, "onRegisterCallback");
        int i2 = 0;
        this.isBindStarted = false;
        this.smsSendingTryCount = 1;
        int length = mobileNumbers.length;
        int length2 = mobileNumbers.length;
        while (i2 < length2) {
            new SendSmsThread(this, simSlot, mobileNumbers[i2], str, str2, Integer.parseInt(tries), length, onRegisterCallback2).start();
            i2++;
            onRegisterCallback2 = onRegisterCallback;
        }
    }

    public final void setBindStarted(boolean z) {
        this.isBindStarted = z;
    }

    public final void setSmsSendingTryCount(int i2) {
        this.smsSendingTryCount = i2;
    }
}

package in.juspay.hypersmshandler;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata
/* loaded from: classes4.dex */
public final class SmsReceiver extends BroadcastReceiver implements JuspayDuiHook, OnResultHook {

    /* renamed from: d, reason: collision with root package name */
    public static final String f48740d;

    /* renamed from: a, reason: collision with root package name */
    public final SmsServices f48741a;

    /* renamed from: b, reason: collision with root package name */
    public IntentFilter f48742b;

    /* renamed from: c, reason: collision with root package name */
    public final Tracker f48743c;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(int i2) {
            this();
        }

        private Companion() {
        }
    }

    static {
        new Companion(0);
        f48740d = "SmsReceiver";
    }

    public SmsReceiver(SmsServices smsServices) {
        Intrinsics.checkNotNullParameter(smsServices, "smsServices");
        this.f48741a = smsServices;
        this.f48743c = smsServices.f48754a.getTracker();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.content.Intent r11) throws org.json.JSONException {
        /*
            r10 = this;
            android.os.Bundle r11 = r11.getExtras()
            if (r11 == 0) goto La1
            java.lang.String r0 = "pdus"
            java.lang.Object r11 = r11.get(r0)
            boolean r0 = r11 instanceof java.lang.Object[]
            if (r0 == 0) goto L13
            java.lang.Object[] r11 = (java.lang.Object[]) r11
            goto L14
        L13:
            r11 = 0
        L14:
            r0 = 0
            if (r11 != 0) goto L19
            byte[][] r11 = new byte[r0][]
        L19:
            int r1 = r11.length
            android.telephony.SmsMessage[] r2 = new android.telephony.SmsMessage[r1]
            org.json.JSONArray r3 = new org.json.JSONArray
            r3.<init>()
        L21:
            if (r0 >= r1) goto L87
            r4 = r11[r0]
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.ByteArray"
            kotlin.jvm.internal.Intrinsics.d(r4, r5)
            byte[] r4 = (byte[]) r4
            android.telephony.SmsMessage r4 = android.telephony.SmsMessage.createFromPdu(r4)
            java.lang.String r5 = r4.getOriginatingAddress()
            java.lang.String r6 = "this as java.lang.String).toUpperCase(locale)"
            java.lang.String r7 = "getDefault()"
            if (r5 == 0) goto L4a
            java.util.Locale r8 = java.util.Locale.getDefault()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
            java.lang.String r5 = r5.toUpperCase(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            if (r5 != 0) goto L4c
        L4a:
            java.lang.String r5 = ""
        L4c:
            java.lang.String r8 = r4.getMessageBody()
            java.lang.String r9 = "smsMsg.messageBody"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            java.util.Locale r9 = java.util.Locale.getDefault()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r7)
            java.lang.String r7 = r8.toUpperCase(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
            long r8 = r4.getTimestampMillis()
            java.lang.String r6 = java.lang.String.valueOf(r8)
            r2[r0] = r4
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            java.lang.String r8 = "from"
            r4.put(r8, r5)
            java.lang.String r5 = "body"
            r4.put(r5, r7)
            java.lang.String r5 = "time"
            r4.put(r5, r6)
            r3.put(r4)
            int r0 = r0 + 1
            goto L21
        L87:
            int r11 = r3.length()
            if (r11 <= 0) goto La1
            in.juspay.hypersmshandler.SmsServices r11 = r10.f48741a
            in.juspay.hypersmshandler.SmsComponents r11 = r11.f48754a
            in.juspay.hypersmshandler.SmsEventInterface r11 = r11.getSmsEventInterface()
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = "receivedMsgs.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r11.onSmsReceiverEvent(r0)
        La1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersmshandler.SmsReceiver.a(android.content.Intent):void");
    }

    @Override // in.juspay.hypersmshandler.JuspayDuiHook
    public final void attach(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.f48742b != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f48741a.f48754a.getContext().registerReceiver(this, this.f48742b, 2);
                return;
            } else {
                this.f48741a.f48754a.getContext().registerReceiver(this, this.f48742b);
                return;
            }
        }
        SmsServices smsServices = this.f48741a;
        SmsConsentHandler smsConsentHandler = smsServices.f48755b;
        if (smsConsentHandler == null) {
            this.f48743c.trackAction("system", "error", "sms_receiver", "missing", "SmsConsentHandler");
            return;
        }
        Intent intent = smsConsentHandler.f48736b;
        if (intent != null) {
            smsServices.f48754a.getSmsEventInterface().onSmsConsentEvent(intent, 11, null);
        }
        smsConsentHandler.f48738d = new c(this, smsConsentHandler, 1);
    }

    @Override // in.juspay.hypersmshandler.JuspayDuiHook
    public final void detach(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            if (this.f48742b != null) {
                this.f48741a.f48754a.getContext().unregisterReceiver(this);
                return;
            }
            SmsConsentHandler smsConsentHandler = this.f48741a.f48755b;
            if (smsConsentHandler != null) {
                smsConsentHandler.f48738d = null;
            }
        } catch (Exception unused) {
        }
    }

    @Override // in.juspay.hypersmshandler.JuspayDuiHook
    public final String execute(Activity activity, String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (jSONObject != null) {
            try {
                if (jSONObject.has("smsReadStartTime")) {
                    return this.f48741a.a(null, jSONObject.getString("smsReadStartTime"), null);
                }
            } catch (JSONException e2) {
                Tracker tracker = this.f48743c;
                String LOG_TAG = f48740d;
                Intrinsics.checkNotNullExpressionValue(LOG_TAG, "LOG_TAG");
                tracker.trackAndLogException(LOG_TAG, "action", "system", "broadcast_receiver", "Exception while trying to read sms from Inbox: ", e2);
                return "[]";
            }
        }
        return this.f48741a.a(null, String.valueOf(System.currentTimeMillis() - 60000), null);
    }

    @Override // in.juspay.hypersmshandler.OnResultHook
    public final boolean onActivityResult(int i2, int i3, Intent intent) throws JSONException {
        if (i2 != 11) {
            return false;
        }
        SmsServices smsServices = this.f48741a;
        SmsConsentHandler smsConsentHandler = smsServices.f48755b;
        if (smsConsentHandler != null) {
            smsConsentHandler.c();
        }
        SmsServices$resetSmsConsentHandler$1 smsServices$resetSmsConsentHandler$1 = new SmsServices$resetSmsConsentHandler$1(smsServices, smsServices.f48754a);
        smsServices.f48755b = smsServices$resetSmsConsentHandler$1;
        smsServices$resetSmsConsentHandler$1.f48738d = null;
        if (intent == null) {
            SmsEventInterface smsEventInterface = this.f48741a.f48754a.getSmsEventInterface();
            SmsServices.f48751c.getClass();
            smsEventInterface.onActivityResultEvent(SmsServices.f48752d);
            return true;
        }
        if (i3 == -1) {
            String stringExtra = intent.getStringExtra("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("from", "UNKNOWN_BANK");
                jSONObject.put("body", stringExtra);
                jSONObject.put("time", String.valueOf(System.currentTimeMillis()));
                this.f48741a.f48754a.getSmsEventInterface().onActivityResultEvent(jSONObject.toString());
                this.f48743c.trackAction("system", "debug", "broadcast_receiver", Labels.Android.ON_ACTIVITY_RESULT, "Response sent back to microapp");
            } catch (JSONException e2) {
                SmsEventInterface smsEventInterface2 = this.f48741a.f48754a.getSmsEventInterface();
                SmsServices.f48751c.getClass();
                smsEventInterface2.onActivityResultEvent(SmsServices.f48752d);
                Tracker tracker = this.f48743c;
                String LOG_TAG = f48740d;
                Intrinsics.checkNotNullExpressionValue(LOG_TAG, "LOG_TAG");
                tracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, "sms_consent", "JSON Exception", e2);
            }
        } else if (i3 == 0) {
            this.f48743c.trackAction("system", "debug", "broadcast_receiver", Labels.Android.ON_ACTIVITY_RESULT, "User denied SMS consent");
            this.f48741a.f48754a.getSmsEventInterface().onActivityResultEvent("DENIED");
        }
        return true;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            if ("android.provider.Telephony.SMS_RECEIVED".equals(intent.getAction())) {
                a(intent);
            }
        } catch (Exception e2) {
            Tracker tracker = this.f48743c;
            String LOG_TAG = f48740d;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG, "LOG_TAG");
            tracker.trackAndLogException(LOG_TAG, "action", "system", "broadcast_receiver", "Failed to receive sms", e2);
        }
    }

    public static final void a(SmsReceiver this$0, SmsConsentHandler smsConsentHandler) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getClass();
        Intent intent = smsConsentHandler.f48736b;
        if (intent != null) {
            this$0.f48741a.f48754a.getSmsEventInterface().onSmsConsentEvent(intent, 11, null);
        }
    }
}

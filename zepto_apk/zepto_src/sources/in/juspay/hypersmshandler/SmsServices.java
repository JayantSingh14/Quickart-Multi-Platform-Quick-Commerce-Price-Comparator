package in.juspay.hypersmshandler;

import android.content.IntentFilter;
import androidx.annotation.Keep;
import androidx.core.content.PermissionChecker;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class SmsServices {

    /* renamed from: c, reason: collision with root package name */
    public static final Companion f48751c = new Companion(0);

    /* renamed from: d, reason: collision with root package name */
    public static final String f48752d = "DENIED";

    /* renamed from: e, reason: collision with root package name */
    public static final String f48753e = "SmsServices";

    /* renamed from: a, reason: collision with root package name */
    public final SmsComponents f48754a;

    /* renamed from: b, reason: collision with root package name */
    public SmsConsentHandler f48755b;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(int i2) {
            this();
        }

        private Companion() {
        }
    }

    @Keep
    public SmsServices(@NotNull SmsComponents smsComponents) {
        Intrinsics.checkNotNullParameter(smsComponents, "smsComponents");
        this.f48754a = smsComponents;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x020a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0200 A[Catch: all -> 0x01f6, TRY_LEAVE, TryCatch #3 {all -> 0x01f6, blocks: (B:79:0x01f1, B:84:0x0200), top: B:133:0x01f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0207  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a(java.lang.String r27, java.lang.String r28, java.lang.String r29) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 704
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersmshandler.SmsServices.a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    @Keep
    @NotNull
    public final JuspayDuiHook createDeliveredSMSReceiver() {
        return new DeliverReceiver();
    }

    @Keep
    public final void createSMSConsent() {
        try {
            if (this.f48755b == null && this.f48754a.getContext().getPackageManager().checkPermission("android.permission.READ_SMS", "com.google.android.gms") == 0) {
                SmsConsentHandler smsConsentHandler = new SmsConsentHandler(this.f48754a) { // from class: in.juspay.hypersmshandler.SmsServices.createSMSConsent.1
                    @Override // in.juspay.hypersmshandler.SmsConsentHandler
                    public final void a() {
                        SmsServices smsServices = SmsServices.this;
                        SmsConsentHandler smsConsentHandler2 = smsServices.f48755b;
                        if (smsConsentHandler2 != null) {
                            smsConsentHandler2.c();
                        }
                        SmsServices$resetSmsConsentHandler$1 smsServices$resetSmsConsentHandler$1 = new SmsServices$resetSmsConsentHandler$1(smsServices, smsServices.f48754a);
                        smsServices.f48755b = smsServices$resetSmsConsentHandler$1;
                        smsServices$resetSmsConsentHandler$1.f48738d = null;
                    }
                };
                this.f48755b = smsConsentHandler;
                smsConsentHandler.f48738d = null;
            }
        } catch (Exception e2) {
            Tracker tracker = this.f48754a.getTracker();
            String LOG_TAG = f48753e;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG, "LOG_TAG");
            tracker.trackAndLogException(LOG_TAG, "lifecycle", "hyper_sdk", "sms_consent", "Exception happened while initializing", e2);
        }
    }

    @Keep
    @Nullable
    public final JuspayDuiHook createSMSReceiver() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
            intentFilter.setPriority(999);
            if (!a("android.permission.RECEIVE_SMS")) {
                return null;
            }
            SmsReceiver smsReceiver = new SmsReceiver(this);
            smsReceiver.f48742b = intentFilter;
            return smsReceiver;
        } catch (Throwable th) {
            Tracker tracker = this.f48754a.getTracker();
            String LOG_TAG = f48753e;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG, "LOG_TAG");
            tracker.trackAndLogException(LOG_TAG, "action", "system", "sms_receiver", "Failed to register SMS broadcast receiver (Ignoring)", th);
            return null;
        }
    }

    @Keep
    @NotNull
    public final JuspayDuiHook createSendSMSReceiver() {
        return new SentReceiver(this.f48754a);
    }

    @Keep
    @Nullable
    public final JuspayDuiHook createSmsReceiverForConsent() {
        try {
            SmsReceiver smsReceiver = new SmsReceiver(this);
            smsReceiver.f48742b = null;
            return smsReceiver;
        } catch (Exception e2) {
            Tracker tracker = this.f48754a.getTracker();
            String LOG_TAG = f48753e;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG, "LOG_TAG");
            tracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, "sms_consent", "Failed to register SMS Consent", e2);
            return null;
        }
    }

    @Keep
    @NotNull
    public final JuspayDuiHook createSmsRetriever() {
        return new SmsRetriever(this.f48754a);
    }

    @Keep
    @NotNull
    public final String fetchSms(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return a(str2, str, str3);
    }

    @Keep
    public final void unregisterSmsConsent() {
        SmsConsentHandler smsConsentHandler = this.f48755b;
        if (smsConsentHandler != null) {
            smsConsentHandler.c();
        }
        this.f48755b = null;
    }

    public final boolean a(String str) {
        return PermissionChecker.a(this.f48754a.getContext(), str) == 0;
    }
}

package in.juspay.hypersmshandler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import androidx.media3.exoplayer.analytics.l;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.p001authapiphone.zzah;
import com.google.android.gms.internal.p001authapiphone.zzak;
import com.google.android.gms.internal.p001authapiphone.zzal;
import com.google.android.gms.tasks.Task;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public abstract class SmsConsentHandler extends BroadcastReceiver {

    /* renamed from: e, reason: collision with root package name */
    public static final ExecutorService f48734e;

    /* renamed from: a, reason: collision with root package name */
    public final SmsComponents f48735a;

    /* renamed from: b, reason: collision with root package name */
    public Intent f48736b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f48737c;

    /* renamed from: d, reason: collision with root package name */
    public Runnable f48738d;

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
        f48734e = Executors.newSingleThreadExecutor();
    }

    public SmsConsentHandler(SmsComponents smsComponents) {
        Intrinsics.checkNotNullParameter(smsComponents, "smsComponents");
        this.f48735a = smsComponents;
        this.f48737c = smsComponents.getContext();
        f48734e.execute(new a(this, 0));
    }

    public static final void a(SmsConsentHandler this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b();
        IntentFilter intentFilter = new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED");
        if (Build.VERSION.SDK_INT >= 33) {
            this$0.f48737c.registerReceiver(this$0, intentFilter, 2);
        } else {
            this$0.f48737c.registerReceiver(this$0, intentFilter);
        }
    }

    public abstract void a();

    public final void b() {
        final Tracker tracker = this.f48735a.getTracker();
        Task<TResult> taskDoWrite = new zzak(this.f48737c, SmsRetrieverClient.f22138a, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS).doWrite(TaskApiCall.builder().run(new zzah()).setFeatures(zzal.f36248b).setMethodKey(1568).build());
        Intrinsics.checkNotNullExpressionValue(taskDoWrite, "getClient(context).startSmsUserConsent(null)");
        taskDoWrite.e(new b(0, new Function1<Void, Unit>() { // from class: in.juspay.hypersmshandler.SmsConsentHandler$startListener$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                tracker.trackAction("system", "debug", "sms_consent", "sms_consent_listener", "SmsConsent listener started successfully");
                return Unit.f53572a;
            }
        }));
        taskDoWrite.c(new l(tracker, 26));
    }

    public final void c() {
        f48734e.execute(new a(this, 1));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            if ("com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(intent.getAction()) && (extras = intent.getExtras()) != null) {
                Status status = (Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
                int statusCode = status != null ? status.getStatusCode() : 16;
                if (statusCode != 0) {
                    if (statusCode != 15) {
                        return;
                    }
                    a();
                } else {
                    this.f48736b = (Intent) extras.getParcelable("com.google.android.gms.auth.api.phone.EXTRA_CONSENT_INTENT");
                    Runnable runnable = this.f48738d;
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            }
        } catch (Exception e2) {
            this.f48735a.getTracker().trackAndLogException("SmsConsentHandler", "lifecycle", "system", "broadcast_receiver", "SmsConsentHandler onReceive exception", e2);
        }
    }

    public static final void a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void a(Tracker tracker, Exception e2) {
        Intrinsics.checkNotNullParameter(tracker, "$tracker");
        Intrinsics.checkNotNullParameter(e2, "e");
        tracker.trackAndLogException("SmsConsentHandler", LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, "sms_consent", "SmsConsent listener failed to start", e2);
    }

    public static final void b(SmsConsentHandler this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.f48737c.unregisterReceiver(this$0);
        } catch (Exception unused) {
        }
    }
}

package in.juspay.hypersmshandler;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import androidx.media3.exoplayer.analytics.l;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001authapiphone.zzak;
import com.google.android.gms.tasks.Task;
import in.juspay.hypersmshandler.SmsEventInterface;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata
/* loaded from: classes4.dex */
public final class SmsRetriever extends BroadcastReceiver implements JuspayDuiHook {

    /* renamed from: e, reason: collision with root package name */
    public static final ExecutorService f48744e;

    /* renamed from: a, reason: collision with root package name */
    public final SmsComponents f48745a;

    /* renamed from: b, reason: collision with root package name */
    public JSONArray f48746b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f48747c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f48748d;

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
        f48744e = Executors.newSingleThreadExecutor();
    }

    public SmsRetriever(SmsComponents smsComponents) {
        Intrinsics.checkNotNullParameter(smsComponents, "smsComponents");
        this.f48745a = smsComponents;
        this.f48746b = new JSONArray();
        this.f48748d = smsComponents.getContext();
    }

    public static final void a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // in.juspay.hypersmshandler.JuspayDuiHook
    public final void attach(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        zzak zzakVar = new zzak(this.f48748d, SmsRetrieverClient.f22138a, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
        Intrinsics.checkNotNullExpressionValue(zzakVar, "getClient(context)");
        Task taskB = zzakVar.b();
        Intrinsics.checkNotNullExpressionValue(taskB, "client.startSmsRetriever()");
        taskB.e(new b(1, new AnonymousClass1(activity, this)));
        taskB.c(new l(this, 27));
    }

    @Override // in.juspay.hypersmshandler.JuspayDuiHook
    public final void detach(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        f48744e.execute(new com.swmansion.gesturehandler.react.b(this, 9));
    }

    @Override // in.juspay.hypersmshandler.JuspayDuiHook
    public final String execute(Activity activity, String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (str != null) {
            if (str.equals("getOtp")) {
                if (this.f48746b.length() == 0) {
                    if (this.f48747c) {
                        this.f48745a.getSmsEventInterface().onSmsRetrieverEvent(SmsEventInterface.RetrieverEvents.ON_EXECUTE, "TIMEOUT");
                    }
                    return MerchantConstants.SUCCESS;
                }
                SmsEventInterface smsEventInterface = this.f48745a.getSmsEventInterface();
                SmsEventInterface.RetrieverEvents retrieverEvents = SmsEventInterface.RetrieverEvents.ON_EXECUTE;
                String string = this.f48746b.toString();
                Intrinsics.checkNotNullExpressionValue(string, "otp.toString()");
                smsEventInterface.onSmsRetrieverEvent(retrieverEvents, string);
                this.f48746b = new JSONArray();
                return MerchantConstants.SUCCESS;
            }
            if (str.equals("cancel")) {
                return MerchantConstants.SUCCESS;
            }
        }
        return "FAILURE";
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) throws JSONException {
        Bundle extras;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!"com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(intent.getAction()) || (extras = intent.getExtras()) == null) {
            return;
        }
        Status status = (Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
        String string = extras.getString("com.google.android.gms.auth.api.phone.EXTRA_SMS_ORIGINATING_ADDRESS");
        int statusCode = status != null ? status.getStatusCode() : 16;
        if (statusCode != 0) {
            if (statusCode != 15) {
                return;
            }
            this.f48747c = true;
            this.f48745a.getSmsEventInterface().onSmsRetrieverEvent(SmsEventInterface.RetrieverEvents.ON_RECEIVE, "TIMEOUT");
            return;
        }
        String str = (String) extras.get("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "UNKNOWN_BANK");
            jSONObject.put("body", str);
            jSONObject.put("time", String.valueOf(System.currentTimeMillis()));
            jSONObject.put("senderId", string);
        } catch (Exception unused) {
        }
        this.f48746b.put(jSONObject);
        SmsEventInterface smsEventInterface = this.f48745a.getSmsEventInterface();
        SmsEventInterface.RetrieverEvents retrieverEvents = SmsEventInterface.RetrieverEvents.ON_RECEIVE;
        String string2 = this.f48746b.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "otp.toString()");
        smsEventInterface.onSmsRetrieverEvent(retrieverEvents, string2);
        this.f48746b = new JSONArray();
    }

    @Metadata
    /* renamed from: in.juspay.hypersmshandler.SmsRetriever$attach$1, reason: invalid class name */
    final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f48749a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SmsRetriever f48750b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Activity activity, SmsRetriever smsRetriever) {
            super(1);
            this.f48749a = activity;
            this.f48750b = smsRetriever;
        }

        public final void a() {
            SmsRetriever.f48744e.execute(new c(this.f48749a, this.f48750b, 0));
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a();
            return Unit.f53572a;
        }

        public static final void a(Activity activity, SmsRetriever this$0) {
            Intrinsics.checkNotNullParameter(activity, "$activity");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            IntentFilter intentFilter = new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED");
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (Build.VERSION.SDK_INT >= 33) {
                activity.registerReceiver(this$0, intentFilter, 2);
            } else {
                activity.registerReceiver(this$0, intentFilter);
            }
            this$0.f48745a.getSmsEventInterface().onSmsRetrieverEvent(SmsEventInterface.RetrieverEvents.ON_ATTACH, MerchantConstants.SUCCESS);
        }
    }

    public static final void a(SmsRetriever this$0, Exception it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.f48745a.getSmsEventInterface().onSmsRetrieverEvent(SmsEventInterface.RetrieverEvents.ON_ATTACH, "FAILURE");
    }

    public static final void a(SmsRetriever this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.f48748d.unregisterReceiver(this$0);
        } catch (IllegalArgumentException unused) {
        }
    }
}

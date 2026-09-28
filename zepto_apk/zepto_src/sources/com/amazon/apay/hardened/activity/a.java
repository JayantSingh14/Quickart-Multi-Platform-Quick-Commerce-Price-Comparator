package com.amazon.apay.hardened.activity;

import android.app.PendingIntent;
import android.os.Handler;
import android.widget.TextView;
import com.amazon.apay.hardened.R;
import com.amazon.apay.hardened.external.model.APayError;

/* loaded from: classes3.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ APayBrowserActivity f14969a;

    /* renamed from: com.amazon.apay.hardened.activity.a$a, reason: collision with other inner class name */
    public class RunnableC0014a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14970a;

        public RunnableC0014a(String str) {
            this.f14970a = str;
        }

        @Override // java.lang.Runnable
        public final void run() throws PendingIntent.CanceledException {
            APayBrowserActivity aPayBrowserActivity = a.this.f14969a;
            int i2 = APayBrowserActivity.o;
            if (aPayBrowserActivity.c()) {
                com.amazon.apay.hardened.manager.b.a(this.f14970a, "KUBER_HARDENED_SDK.BUSINESS_METRICS");
                aPayBrowserActivity.n(APayError.ErrorType.AUTH_ERROR, "OPERATION_CANCELLED", "Operation cancelled", null);
            } else {
                aPayBrowserActivity.n(APayError.ErrorType.PAYMENT_ERROR, "OPERATION_CANCELLED", "Operation cancelled", null);
            }
            aPayBrowserActivity.finish();
        }
    }

    public a(APayBrowserActivity aPayBrowserActivity) {
        this.f14969a = aPayBrowserActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = APayBrowserActivity.o;
        APayBrowserActivity aPayBrowserActivity = this.f14969a;
        if (aPayBrowserActivity.c()) {
            ((TextView) aPayBrowserActivity.findViewById(R.id.loading_text)).setText("Canceling your Amazon Pay authorization");
        } else {
            ((TextView) aPayBrowserActivity.findViewById(R.id.loading_text)).setText("Canceling your Amazon Pay transaction");
        }
        new Handler().postDelayed(new RunnableC0014a("OPERATION_CANCELLED".equals("OPERATION_CANCELLED") ? "LoginDroppedOff" : "LoginCanceled"), 1000L);
    }
}

package com.amazon.android.apay.commonlibrary.browsinglib.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.amazon.android.apay.commonlibrary.R;
import com.amazon.android.apay.commonlibrary.browsinglib.browsing.b;
import com.amazon.android.apay.commonlibrary.browsinglib.model.BrowsingRequest;
import com.amazon.android.apay.commonlibrary.commonlib.exception.ApayUncaughtExceptionHandler;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayError;
import java.util.UUID;

/* loaded from: classes3.dex */
public class BrowsingActivity extends AppCompatActivity {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f14847l = 0;

    /* renamed from: i, reason: collision with root package name */
    public BrowsingRequest f14848i;

    /* renamed from: j, reason: collision with root package name */
    public ApayUncaughtExceptionHandler f14849j;

    /* renamed from: k, reason: collision with root package name */
    public String f14850k;

    public static Intent l(AmazonPayError amazonPayError) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(MerchantConstants.ERROR, amazonPayError);
        return new Intent().putExtras(bundle);
    }

    public final void m(Bundle bundle) {
        BrowsingRequest browsingRequest = (BrowsingRequest) bundle.getParcelable("BrowsingActivityRequest");
        this.f14848i = browsingRequest;
        if (browsingRequest == null) {
            InstrumentUtil.addMetricEvent("ExtractStateFailed", "BrowsingActivity", this.f14850k);
            n("ExtractStateFailed", "BrowsingRequestExtractionFailed");
        } else {
            this.f14849j.setStitchingId(this.f14850k);
            InstrumentUtil.addMetricEvent("ExtractStateSuccess", "BrowsingActivity", this.f14850k);
        }
    }

    public final void n(String str, String str2) {
        InstrumentUtil.addMetricEvent(str, "BrowsingActivity", this.f14850k);
        setResult(0, l(new AmazonPayError(MerchantConstants.PAYMENT_ERROR, str2)));
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                setTheme(R.style.AppTheme_Opaque);
            }
            super.onCreate(bundle);
            ApayUncaughtExceptionHandler apayUncaughtExceptionHandler = new ApayUncaughtExceptionHandler(this, "UNKNOWN");
            this.f14849j = apayUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(apayUncaughtExceptionHandler);
            setContentView(R.layout.browsing_activity);
            this.f14850k = bundle != null ? bundle.getString("stitchingId") : getIntent().getExtras() != null ? getIntent().getStringExtra("stitchingId") : UUID.randomUUID().toString();
            if (bundle == null) {
                Bundle extras = getIntent().getExtras();
                if (extras == null) {
                    n("IntentExtrasNotFound", "Invalid Request : Intent Extras not passed from 3p App");
                    return;
                }
                m(extras);
            } else {
                m(bundle);
            }
            InstrumentUtil.addMetricEvent("OnCreateCalled", "BrowsingActivity", this.f14850k);
        } catch (Exception e2) {
            n("OnCreateFailed", e2.toString());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        try {
            super.onDestroy();
            InstrumentUtil.addMetricEvent("OnDestroyCalled", "BrowsingActivity", getIntent().getExtras() != null ? getIntent().getStringExtra("stitchingId") : UUID.randomUUID().toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f14849j.getPrevDefaultExceptionHandler());
            this.f14849j.tearDown();
            this.f14849j = null;
        } catch (Exception e2) {
            n("OnDestroyFailed", e2.toString());
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        try {
            super.onNewIntent(intent);
            setIntent(intent);
            this.f14848i.setIsNewIntentCalled(Boolean.TRUE);
            InstrumentUtil.addMetricEvent("OnNewIntentCalled", "BrowsingActivity", this.f14850k);
        } catch (Exception e2) {
            n("OnNewIntentFailed", e2.toString());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        try {
            super.onResume();
            if (!this.f14848i.isBrowserLaunched().booleanValue()) {
                InstrumentUtil.addMetricEvent("BrowsingInitiated", "BrowsingActivity", this.f14850k);
                final int i2 = 0;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: com.amazon.android.apay.commonlibrary.browsinglib.activity.a

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ BrowsingActivity f14852b;

                    {
                        this.f14852b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        BrowsingActivity browsingActivity = this.f14852b;
                        switch (i2) {
                            case 0:
                                int i3 = BrowsingActivity.f14847l;
                                try {
                                    b.b(browsingActivity.f14848i, browsingActivity);
                                    InstrumentUtil.addMetricEvent("OpenUrlSuccess", "BrowsingActivity", browsingActivity.f14850k);
                                    break;
                                } catch (AmazonPayError e2) {
                                    browsingActivity.setResult(0, BrowsingActivity.l(e2));
                                    browsingActivity.finish();
                                    return;
                                }
                            default:
                                int i4 = BrowsingActivity.f14847l;
                                ((TextView) browsingActivity.findViewById(R.id.loading_text)).setText(R.string.canceling_your_amazon_pay_transaction);
                                browsingActivity.setResult(0, BrowsingActivity.l(new AmazonPayError(MerchantConstants.PAYMENT_ERROR, "Operation Canceled by User")));
                                browsingActivity.finish();
                                break;
                        }
                    }
                }, 100);
                this.f14848i.setIsBrowserLaunched(Boolean.TRUE);
                return;
            }
            Intent intent = getIntent();
            if (intent.getData() != null) {
                InstrumentUtil.addMetricEvent("BrowserRedirectSuccess", "BrowsingActivity", this.f14850k);
                intent.putExtra(MerchantConstants.SUCCESS, getIntent().getData());
                setResult(-1, intent);
                finish();
                return;
            }
            if (this.f14848i.isNewIntentCalled().booleanValue()) {
                return;
            }
            InstrumentUtil.addMetricEvent("BrowsingCanceled", "BrowsingActivity", this.f14850k);
            final int i3 = 1;
            runOnUiThread(new Runnable(this) { // from class: com.amazon.android.apay.commonlibrary.browsinglib.activity.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ BrowsingActivity f14852b;

                {
                    this.f14852b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    BrowsingActivity browsingActivity = this.f14852b;
                    switch (i3) {
                        case 0:
                            int i32 = BrowsingActivity.f14847l;
                            try {
                                b.b(browsingActivity.f14848i, browsingActivity);
                                InstrumentUtil.addMetricEvent("OpenUrlSuccess", "BrowsingActivity", browsingActivity.f14850k);
                                break;
                            } catch (AmazonPayError e2) {
                                browsingActivity.setResult(0, BrowsingActivity.l(e2));
                                browsingActivity.finish();
                                return;
                            }
                        default:
                            int i4 = BrowsingActivity.f14847l;
                            ((TextView) browsingActivity.findViewById(R.id.loading_text)).setText(R.string.canceling_your_amazon_pay_transaction);
                            browsingActivity.setResult(0, BrowsingActivity.l(new AmazonPayError(MerchantConstants.PAYMENT_ERROR, "Operation Canceled by User")));
                            browsingActivity.finish();
                            break;
                    }
                }
            });
        } catch (Exception e2) {
            n("OnResumeFailed", e2.toString());
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("BrowsingActivityRequest", this.f14848i);
    }
}

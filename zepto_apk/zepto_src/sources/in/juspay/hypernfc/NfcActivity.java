package in.juspay.hypernfc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import com.cardreader.card_reader_lib.CardTask;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class NfcActivity extends FragmentActivity {

    @Nullable
    private TimerTask task;

    @NotNull
    private final JSONObject data = new JSONObject();

    @NotNull
    private final CardTask cardTask = new CardTask();

    @NotNull
    private final Timer timerForWaitingInActivity = new Timer();

    @NotNull
    private final Timer timerToReadChangedMessage = new Timer();

    @Metadata
    /* renamed from: in.juspay.hypernfc.NfcActivity$onCreate$4, reason: invalid class name */
    public static final class AnonymousClass4 extends TimerTask {
        public AnonymousClass4() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$0(NfcActivity this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.findViewById(R.id.backgroundImage).setBackground(this$0.getApplicationContext().getDrawable(R.drawable.image_border));
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() throws JSONException {
            try {
                NfcActivity.this.data.put("error", "Request timed out!");
                NfcActivity.this.data.put("data", (Object) null);
                NfcActivity nfcActivity = NfcActivity.this;
                nfcActivity.runOnUiThread(new c(nfcActivity, 1));
                NfcActivity nfcActivity2 = NfcActivity.this;
                nfcActivity2.timedOut(nfcActivity2.data);
            } catch (Exception unused) {
                Intent intent = new Intent();
                intent.putExtra("result_data", "{\"error\":\"Couldn't read the card! Try again or type your card number\"}");
                NfcActivity.this.setResult(0, intent);
                NfcActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreate$lambda$0(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insetsD = insets.d(647);
        Intrinsics.checkNotNullExpressionValue(insetsD, "insets.getInsets(WindowI…pat.Type.displayCutout())");
        v.setPadding(insetsD.f2808a, insetsD.f2809b, insetsD.f2810c, insetsD.f2811d);
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(NfcActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(NfcActivity this$0, ImageView imageView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((Wave) this$0.findViewById(R.id.rippleView)).startRippleAnimation((imageView.getHeight() / 2) + imageView.getTop());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNewIntent$lambda$3(NfcActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.findViewById(R.id.backgroundImage).setBackground(this$0.getApplicationContext().getDrawable(R.drawable.image_border));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void timedOut(final JSONObject jSONObject) {
        ((TextView) findViewById(R.id.nfcStatus)).setText(R.string.no_card_detected);
        TimerTask timerTask = new TimerTask() { // from class: in.juspay.hypernfc.NfcActivity.timedOut.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Intent intent = new Intent();
                intent.putExtra("result_data", jSONObject.toString());
                this.setResult(0, intent);
                this.finish();
            }
        };
        this.task = timerTask;
        this.timerToReadChangedMessage.schedule(timerTask, 1500L);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated
    public void onBackPressed() {
        setResult(0, new Intent());
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        EdgeToEdge.a(this);
        Bundle extras = getIntent().getExtras();
        int i2 = extras != null ? extras.getInt("waitingTime") : 7000;
        setContentView(R.layout.activity_nfc);
        ViewCompat.H(findViewById(android.R.id.content), new a());
        View viewFindViewById = findViewById(R.id.backpressImage);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new com.google.android.material.datepicker.d(this, 4));
        }
        ImageView imageView = (ImageView) findViewById(R.id.backgroundImage);
        imageView.post(new b(0, this, imageView));
        AnonymousClass4 anonymousClass4 = new AnonymousClass4();
        this.task = anonymousClass4;
        this.timerForWaitingInActivity.schedule(anonymousClass4, i2);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            TimerTask timerTask = this.task;
            if (timerTask != null) {
                timerTask.cancel();
            }
            this.timerForWaitingInActivity.cancel();
            this.timerToReadChangedMessage.cancel();
        } catch (Exception unused) {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) throws JSONException {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        try {
            String cardDetails = this.cardTask.getCardDetails(intent);
            this.data.put("error", (Object) null);
            this.data.put("data", cardDetails);
            if (cardDetails != null) {
                ((TextView) findViewById(R.id.nfcStatus)).setText(R.string.scan_successful);
                TimerTask timerTask = new TimerTask() { // from class: in.juspay.hypernfc.NfcActivity.onNewIntent.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        Intent intent2 = new Intent();
                        intent2.putExtra("result_data", NfcActivity.this.data.toString());
                        NfcActivity.this.setResult(-1, intent2);
                        NfcActivity.this.finish();
                    }
                };
                this.task = timerTask;
                this.timerToReadChangedMessage.schedule(timerTask, 1500L);
                return;
            }
            runOnUiThread(new c(this, 0));
            ((TextView) findViewById(R.id.nfcStatus)).setText(R.string.scan_failed);
            TimerTask timerTask2 = new TimerTask() { // from class: in.juspay.hypernfc.NfcActivity.onNewIntent.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Intent intent2 = new Intent();
                    intent2.putExtra("result_data", "{\"error\":\"Couldn't read your card ! Try again or type your card number\"}");
                    NfcActivity.this.setResult(0, intent2);
                    NfcActivity.this.finish();
                }
            };
            this.task = timerTask2;
            this.timerToReadChangedMessage.schedule(timerTask2, 1500L);
        } catch (Exception unused) {
            Intent intent2 = new Intent();
            intent2.putExtra("result_data", "{\"error\":\"Couldn't recognize card ! Try again or type your card number\"}");
            setResult(0, intent2);
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.cardTask.isNFCEnabled(this)) {
            this.cardTask.onPauseClone(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cardTask.isNFCEnabled(this)) {
            this.cardTask.onResumeClone(this);
        }
    }
}

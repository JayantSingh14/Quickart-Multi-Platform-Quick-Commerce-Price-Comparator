package com.truecaller.android.sdk.oAuth.clients;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Process;
import android.provider.Settings;
import android.support.v4.media.b;
import android.telephony.TelephonyManager;
import android.util.Base64;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import com.truecaller.android.sdk.R;
import com.truecaller.android.sdk.SdkUtils;
import com.truecaller.android.sdk.common.VerificationCallback;
import com.truecaller.android.sdk.common.VerificationRequestManager;
import com.truecaller.android.sdk.common.VerificationRequestManagerImpl;
import com.truecaller.android.sdk.common.callVerification.CallRejector;
import com.truecaller.android.sdk.common.callVerification.CallRejectorLegacyImpl;
import com.truecaller.android.sdk.common.callVerification.CallRejectorPieImpl;
import com.truecaller.android.sdk.common.callVerification.IncomingCallListener;
import com.truecaller.android.sdk.common.callbacks.MissedCallInstallationCallback;
import com.truecaller.android.sdk.common.imOtpVerification.ImOtpReceiverClientHandler;
import com.truecaller.android.sdk.common.imOtpVerification.ImOtpReceiverClientHandler$startCountDownTimer$1;
import com.truecaller.android.sdk.common.imOtpVerification.TruecallerImOtpReceiver;
import com.truecaller.android.sdk.common.network.ProfileService;
import com.truecaller.android.sdk.common.network.RestAdapter;
import com.truecaller.android.sdk.common.network.VerificationService;
import com.truecaller.android.sdk.common.otpVerification.SmsRetrieverClientHandler;
import com.truecaller.android.sdk.oAuth.TcOAuthCallback;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@RestrictTo
/* loaded from: classes4.dex */
public final class VerificationClientV2 extends BaseClient implements VerificationRequestManager.Client {

    /* renamed from: j, reason: collision with root package name */
    public final VerificationRequestManagerImpl f47286j;

    /* renamed from: k, reason: collision with root package name */
    public final CallRejector f47287k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f47288l;

    /* renamed from: m, reason: collision with root package name */
    public IncomingCallListener f47289m;
    public Handler n;
    public ImOtpReceiverClientHandler o;

    public VerificationClientV2(Context context, String str, TcOAuthCallback tcOAuthCallback, boolean z) {
        super(context, str, tcOAuthCallback, 2);
        this.f47288l = z;
        String string = context.getString(R.string.sdk_variant);
        String string2 = context.getString(R.string.sdk_variant_version);
        this.f47286j = new VerificationRequestManagerImpl(this, (ProfileService) RestAdapter.a("https://outline.truecaller.com/v1/", ProfileService.class, "3.2.1", string, string2), (VerificationService) RestAdapter.a("https://sdk-otp-verification-noneu.truecaller.com/v2/otp/client/installation/", VerificationService.class, "3.2.1", string, string2), tcOAuthCallback, new SmsRetrieverClientHandler(context));
        this.f47287k = Build.VERSION.SDK_INT >= 28 ? new CallRejectorPieImpl(context) : new CallRejectorLegacyImpl(context);
        this.o = new ImOtpReceiverClientHandler(context);
    }

    @Override // com.truecaller.android.sdk.common.VerificationRequestManager.Client
    public final void a() {
        this.f47287k.a();
    }

    @Override // com.truecaller.android.sdk.common.VerificationRequestManager.Client
    public final boolean b() {
        return Settings.Global.getInt(this.f47276a.getContentResolver(), "airplane_mode_on", 0) == 0;
    }

    @Override // com.truecaller.android.sdk.common.VerificationRequestManager.Client
    public final void c(MissedCallInstallationCallback missedCallInstallationCallback) {
        TelephonyManager telephonyManager = (TelephonyManager) this.f47276a.getSystemService("phone");
        IncomingCallListener incomingCallListener = new IncomingCallListener(missedCallInstallationCallback);
        this.f47289m = incomingCallListener;
        telephonyManager.listen(incomingCallListener, 32);
    }

    @Override // com.truecaller.android.sdk.common.VerificationRequestManager.Client
    public final boolean d() {
        if (h("android.permission.READ_PHONE_STATE") && h("android.permission.READ_CALL_LOG")) {
            return Build.VERSION.SDK_INT < 26 ? h("android.permission.CALL_PHONE") : h("android.permission.ANSWER_PHONE_CALLS");
        }
        return false;
    }

    @Override // com.truecaller.android.sdk.common.VerificationRequestManager.Client
    public final int e() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f47276a.getSystemService("phone");
        if (telephonyManager == null) {
            return 0;
        }
        return telephonyManager.getSimState();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.truecaller.android.sdk.common.imOtpVerification.ImOtpReceiverClientHandler$startCountDownTimer$1] */
    @Override // com.truecaller.android.sdk.common.VerificationRequestManager.Client
    public final void f(VerificationCallback verificationCallback, final long j2) throws NoSuchAlgorithmException {
        byte[] bArrDigest;
        ImOtpReceiverClientHandler imOtpReceiverClientHandler = this.o;
        if (imOtpReceiverClientHandler != null) {
            String requestNonce = this.f47283h;
            WeakReference weakReference = SdkUtils.f47190a;
            String clientIdentifier = this.f47279d;
            Intrinsics.checkNotNullParameter(clientIdentifier, "clientIdentifier");
            Intrinsics.checkNotNullParameter(requestNonce, "requestNonce");
            StringBuilder sb = new StringBuilder();
            sb.append(clientIdentifier);
            byte[] bytes = b.r(sb, "&", requestNonce).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
                messageDigest.update(bytes);
                bArrDigest = messageDigest.digest();
                Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
            } catch (NoSuchAlgorithmException unused) {
                bArrDigest = null;
            }
            String strEncodeToString = Base64.encodeToString(bArrDigest, 9);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
            String action = StringsKt.W(10, strEncodeToString);
            Intrinsics.checkNotNullParameter(verificationCallback, "verificationCallback");
            Intrinsics.checkNotNullParameter(action, "action");
            WeakReference weakReference2 = imOtpReceiverClientHandler.f47233a;
            if (weakReference2.get() != null) {
                imOtpReceiverClientHandler.a();
                imOtpReceiverClientHandler.f47234b = new TruecallerImOtpReceiver(verificationCallback);
                Context context = (Context) weakReference2.get();
                if (context != null) {
                    ContextCompat.e(context, imOtpReceiverClientHandler.f47234b, new IntentFilter(action), 2);
                }
            }
            final ImOtpReceiverClientHandler imOtpReceiverClientHandler2 = this.o;
            ImOtpReceiverClientHandler$startCountDownTimer$1 imOtpReceiverClientHandler$startCountDownTimer$1 = imOtpReceiverClientHandler2.f47235c;
            if (imOtpReceiverClientHandler$startCountDownTimer$1 != null) {
                imOtpReceiverClientHandler$startCountDownTimer$1.cancel();
            }
            imOtpReceiverClientHandler2.f47235c = null;
            imOtpReceiverClientHandler2.f47235c = new CountDownTimer(j2) { // from class: com.truecaller.android.sdk.common.imOtpVerification.ImOtpReceiverClientHandler$startCountDownTimer$1
                @Override // android.os.CountDownTimer
                public final void onFinish() {
                    imOtpReceiverClientHandler2.a();
                }

                @Override // android.os.CountDownTimer
                public final void onTick(long j3) {
                }
            };
        }
    }

    @Override // com.truecaller.android.sdk.common.VerificationRequestManager.Client
    public final void g() {
        ((TelephonyManager) this.f47276a.getSystemService("phone")).listen(this.f47289m, 0);
    }

    @Override // com.truecaller.android.sdk.common.VerificationRequestManager.Client
    public final Handler getHandler() {
        if (this.n == null) {
            this.n = new Handler();
        }
        return this.n;
    }

    public final boolean h(String str) {
        return this.f47276a.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }
}

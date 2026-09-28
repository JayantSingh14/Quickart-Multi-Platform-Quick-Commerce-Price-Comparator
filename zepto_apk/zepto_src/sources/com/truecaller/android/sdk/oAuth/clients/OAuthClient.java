package com.truecaller.android.sdk.oAuth.clients;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentActivity;
import com.truecaller.android.sdk.R;
import com.truecaller.android.sdk.SdkUtils;
import com.truecaller.android.sdk.common.TrueException;
import com.truecaller.android.sdk.oAuth.ClientManagerV2;
import com.truecaller.android.sdk.oAuth.SdkOptionsDataBundle;
import com.truecaller.android.sdk.oAuth.SdkOptionsEvaluator;
import com.truecaller.android.sdk.oAuth.ShareProfileHelperV2;
import com.truecaller.android.sdk.oAuth.TcOAuthCallback;
import com.truecaller.android.sdk.oAuth.TcOAuthError;
import com.truecaller.android.sdk.oAuth.UtilsV2;
import java.util.ArrayList;

@RestrictTo
/* loaded from: classes4.dex */
public class OAuthClient extends BaseClient {

    /* renamed from: j, reason: collision with root package name */
    public final SdkOptionsEvaluator f47285j;

    public OAuthClient(Context context, String str, TcOAuthCallback tcOAuthCallback, SdkOptionsEvaluator sdkOptionsEvaluator) {
        super(context, str, tcOAuthCallback, 1);
        this.f47285j = sdkOptionsEvaluator;
    }

    public final Intent h(FragmentActivity fragmentActivity) {
        String strA = UtilsV2.a(fragmentActivity);
        if (strA == null) {
            throw new RuntimeException(TrueException.TYPE_APP_SIGNATURE_MISSING);
        }
        PartnerInformationV2 partnerInformationV2 = new PartnerInformationV2("3.2.1", this.f47279d, fragmentActivity.getPackageName(), strA, this.f47280e, fragmentActivity.getString(R.string.sdk_variant), fragmentActivity.getString(R.string.sdk_variant_version), this.f47284i, this.f47282g, this.f47283h, this.f47281f);
        SdkOptionsEvaluator sdkOptionsEvaluator = this.f47285j;
        ArrayList arrayList = ShareProfileHelperV2.f47274a;
        int i2 = sdkOptionsEvaluator.f47272a;
        Intent intentA = (i2 & 2048) == 2048 ? ShareProfileHelperV2.a(fragmentActivity, "com.truecaller.android.sdk.intent.action.v2.oAuth") : null;
        if (intentA == null) {
            intentA = ShareProfileHelperV2.a(fragmentActivity, "com.truecaller.android.sdk.intent.action.v1.oAuth");
        }
        if (intentA == null) {
            return null;
        }
        intentA.putExtra("truesdk_partner_info", partnerInformationV2);
        intentA.putExtra("truesdk_flags", i2);
        SdkOptionsDataBundle sdkOptionsDataBundle = sdkOptionsEvaluator.f47273b;
        if (sdkOptionsDataBundle != null) {
            intentA.putExtra("truesdk_options_info", sdkOptionsDataBundle);
        }
        return intentA;
    }

    public final void i(FragmentActivity fragmentActivity, TcOAuthError tcOAuthError) {
        boolean z = (this.f47285j.f47272a & 64) == 64;
        TcOAuthCallback tcOAuthCallback = this.f47277b;
        if (!z) {
            tcOAuthCallback.onFailure(tcOAuthError);
            return;
        }
        ClientManagerV2 clientManagerV2 = ClientManagerV2.f47270b;
        String str = this.f47283h;
        clientManagerV2.getClass();
        VerificationClientV2 verificationClientV2 = new VerificationClientV2(this.f47276a, this.f47279d, tcOAuthCallback, true);
        SdkUtils.c(fragmentActivity);
        tcOAuthCallback.onVerificationRequired(tcOAuthError);
        clientManagerV2.f47271a = verificationClientV2;
        verificationClientV2.f47283h = str;
    }
}

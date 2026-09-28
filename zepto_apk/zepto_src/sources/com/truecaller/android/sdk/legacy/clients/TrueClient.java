package com.truecaller.android.sdk.legacy.clients;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentActivity;
import com.truecaller.android.sdk.PartnerInformation;
import com.truecaller.android.sdk.R;
import com.truecaller.android.sdk.SdkUtils;
import com.truecaller.android.sdk.common.TrueException;
import com.truecaller.android.sdk.legacy.ClientManager;
import com.truecaller.android.sdk.legacy.ITrueCallback;
import com.truecaller.android.sdk.legacy.ShareProfileHelper;
import com.truecaller.android.sdk.legacy.TrueError;
import com.truecaller.android.sdk.legacy.Utils;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.UUID;

@RestrictTo
/* loaded from: classes4.dex */
public class TrueClient extends TcClient {

    /* renamed from: h, reason: collision with root package name */
    public final SdkScopeEvaluator f47264h;

    public TrueClient(Context context, String str, ITrueCallback iTrueCallback, SdkScopeEvaluator sdkScopeEvaluator) {
        super(context, str, iTrueCallback, 1);
        this.f47264h = sdkScopeEvaluator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r13v2, types: [android.os.BaseBundle, android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.os.Parcelable, com.truecaller.android.sdk.PartnerInformation] */
    public final Intent h(FragmentActivity fragmentActivity) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        String strA = Utils.a(fragmentActivity);
        if (strA == null) {
            throw new RuntimeException(TrueException.TYPE_APP_SIGNATURE_MISSING);
        }
        if (TextUtils.isEmpty(this.f47261e)) {
            this.f47261e = UUID.randomUUID().toString();
        }
        ?? partnerInformation = new PartnerInformation("2.9.0", this.f47260d, fragmentActivity.getPackageName(), strA, this.f47261e, this.f47262f, this.f47263g, fragmentActivity.getString(R.string.sdk_variant), fragmentActivity.getString(R.string.sdk_variant_version));
        SdkScopeEvaluator sdkScopeEvaluator = this.f47264h;
        ArrayList arrayList = ShareProfileHelper.f47245a;
        int i2 = sdkScopeEvaluator.f47254a;
        ?? A = (i2 & 8) == 8 ? ShareProfileHelper.a(fragmentActivity, "com.truecaller.android.sdk.intent.action.v2.SHARE_PROFILE") : (i2 & 128) == 128 ? ShareProfileHelper.a(fragmentActivity, "com.truecaller.android.sdk.intent.action.v3.SHARE_PROFILE") : 0;
        if (A == 0) {
            A = ShareProfileHelper.a(fragmentActivity, "com.truecaller.android.sdk.intent.action.v1.SHARE_PROFILE");
        }
        if (A == 0) {
            return null;
        }
        ?? bundle = new Bundle();
        partnerInformation.writeToBundle(bundle);
        bundle.putParcelable(PartnerInformation.PARTNER_INFO_EXTRA, partnerInformation);
        A.putExtra("PARTNERINFO_OTHER_NUMBER", true);
        A.putExtra("truesdk flags", i2);
        A.putExtra("truesdk_consent_title", sdkScopeEvaluator.f47255b);
        CustomDataBundle customDataBundle = sdkScopeEvaluator.f47256c;
        if (customDataBundle != null) {
            bundle.putInt("CUSTOMDATA_BTN_COLOR", customDataBundle.f47247a);
            bundle.putInt("CUSTOMDATA_BTN_TEXT_COLOR", customDataBundle.f47248b);
            bundle.putString("CUSTOMDATA_PRIVACY_URL", customDataBundle.f47249c);
            bundle.putString("CUSTOMDATA_TERMS_URL", customDataBundle.f47250d);
            bundle.putInt("CUSTOMDATA_CTA_TEXT_PREFIX_OPTION", customDataBundle.f47253g);
            bundle.putInt("CUSTOMDATA_LOGIN_TEXT_PREFIX_OPTION", customDataBundle.f47251e);
            bundle.putInt("CUSTOMDATA_LOGIN_TEXT_SUFFIX_OPTION", customDataBundle.f47252f);
        }
        A.putExtras(bundle);
        return A;
    }

    public final void i(FragmentActivity fragmentActivity, int i2) {
        if ((this.f47264h.f47254a & 32) != 32) {
            this.f47258b.onFailureProfileShared(new TrueError(i2));
            return;
        }
        ClientManager clientManager = ClientManager.f47243b;
        if (TextUtils.isEmpty(this.f47261e)) {
            this.f47261e = UUID.randomUUID().toString();
        }
        String str = this.f47261e;
        ITrueCallback iTrueCallback = this.f47258b;
        clientManager.getClass();
        VerificationClient verificationClient = new VerificationClient(this.f47257a, this.f47260d, iTrueCallback, true);
        SdkUtils.c(fragmentActivity);
        iTrueCallback.onVerificationRequired(new TrueError(i2));
        clientManager.f47244a = verificationClient;
        verificationClient.f47261e = str;
    }
}

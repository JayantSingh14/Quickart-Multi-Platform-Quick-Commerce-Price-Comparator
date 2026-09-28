package com.amazon.identity.auth.internal.role;

import a.a;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.amazon.android.apay.commonlibrary.interfaces.internal.SDKAuthRole;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayAuthorizationRequest;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayError;
import com.amazon.identity.auth.apay.activity.AuthActivity;
import com.amazon.identity.auth.apay.manager.AuthManager;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class SDKAuthRoleImpl implements SDKAuthRole {
    @Override // com.amazon.android.apay.commonlibrary.interfaces.internal.SDKAuthRole
    public final Intent getAuthorizationIntent(AmazonPayAuthorizationRequest amazonPayAuthorizationRequest, Context context) throws Exception {
        AuthManager authManager = new AuthManager();
        String clientId = amazonPayAuthorizationRequest.getClientId();
        if (clientId == null) {
            clientId = context.getPackageName() == null ? "UNKNOWN" : context.getPackageName();
        }
        String str = authManager.f15075a;
        try {
            if (context == null) {
                throw new AmazonPayError(MerchantConstants.AUTH_ERROR, "Context cannot be null");
            }
            if (!(context instanceof Activity)) {
                throw new AmazonPayError(MerchantConstants.AUTH_ERROR, "Do not pass ApplicationContext. Pass activity context instead.");
            }
            if (amazonPayAuthorizationRequest.getCodeChallenge() == null) {
                throw new AmazonPayError(MerchantConstants.AUTH_ERROR, "CodeChallenge cannot be null");
            }
            String codeChallenge = amazonPayAuthorizationRequest.getCodeChallenge();
            List<String> additionalAuthScopes = amazonPayAuthorizationRequest.getAdditionalAuthScopes();
            Intent intent = new Intent(context, (Class<?>) AuthActivity.class);
            intent.putExtra("AuthRequest", new a(codeChallenge, clientId, str, additionalAuthScopes));
            return intent;
        } catch (Exception e2) {
            InstrumentUtil.addMetricEvent(MerchantConstants.ERROR, "AuthManager", "AuthorizationIntentBuildError", Arrays.toString(e2.getStackTrace()), str);
            if (e2 instanceof AmazonPayError) {
                throw e2;
            }
            throw new AmazonPayError(MerchantConstants.ERROR, "Something went wrong!!", e2);
        }
    }

    @Override // com.amazon.android.apay.commonlibrary.interfaces.internal.SDKAuthRole
    public final void startAuth(List list, String str, String str2, Activity activity, int i2) {
        String str3 = new AuthManager().f15075a;
        if (str == null) {
            try {
                str = activity.getPackageName() == null ? "UNKNOWN" : activity.getPackageName();
            } catch (AmazonPayError e2) {
                InstrumentUtil.addMetricEvent(MerchantConstants.ERROR, "AuthManager", "AuthorizationError", Arrays.toString(e2.getStackTrace()), str3);
                throw e2;
            } catch (Exception e3) {
                InstrumentUtil.addMetricEvent(MerchantConstants.ERROR, "AuthManager", "AuthorizationError", Arrays.toString(e3.getStackTrace()), str3);
                throw new AmazonPayError("AuthorizationError", "Something went wrong!!", e3);
            }
        }
        Intent intent = new Intent(activity, (Class<?>) AuthActivity.class);
        intent.putExtra("AuthRequest", new a(str2, str, str3, list));
        activity.startActivityForResult(intent, i2);
    }
}

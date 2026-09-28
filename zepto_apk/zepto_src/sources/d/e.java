package d;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.amazon.identity.auth.device.authorization.AmazonAuthorizationServiceInterface;
import com.amazon.identity.auth.device.authorization.ServiceConnectionState;
import com.amazon.identity.auth.device.authorization.ThirdPartyAuthorizationHelper;
import com.amazon.identity.auth.device.utils.LWAServiceWrapper;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final class e extends LWAServiceWrapper<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String[] f48310a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f48311b;

    public e(String[] strArr, Bundle bundle) {
        this.f48310a = strArr;
        this.f48311b = bundle;
    }

    @Override // com.amazon.identity.auth.device.utils.LWAServiceWrapper
    public final Object a(Context context, AmazonAuthorizationServiceInterface amazonAuthorizationServiceInterface) throws JSONException, RemoteException {
        int i2 = ThirdPartyAuthorizationHelper.f15171c + 1;
        ThirdPartyAuthorizationHelper.f15171c = i2;
        if (i2 > 1) {
            InstrumentUtil.addMetricEvent("RetryingAuthWithService", "LWA_LITE_SDK.AUTHORIZE_WITH_SERVICE", context, (String) null, (String) null);
            InstrumentUtil.addMetricEvent("LoginWithSSORetry", "LWA_LITE_SDK.BUSINESS_METRICS", context, (String) null, (String) null);
        } else {
            InstrumentUtil.addMetricEvent("StartingAuthWithService", "LWA_LITE_SDK.AUTHORIZE_WITH_SERVICE", context, (String) null, (String) null);
            InstrumentUtil.addMetricEvent("LoginWithSSOInvoked", "LWA_LITE_SDK.BUSINESS_METRICS", context, (String) null, (String) null);
        }
        Bundle bundleAuthorize = amazonAuthorizationServiceInterface.authorize(this.f48311b, context.getPackageName(), this.f48310a);
        if (bundleAuthorize != null) {
            bundleAuthorize.setClassLoader(context.getClassLoader());
        }
        return bundleAuthorize;
    }

    @Override // com.amazon.identity.auth.device.utils.LWAServiceWrapper
    public final void c(ServiceConnectionState serviceConnectionState) {
        ThirdPartyAuthorizationHelper.serviceStatus = serviceConnectionState;
    }
}

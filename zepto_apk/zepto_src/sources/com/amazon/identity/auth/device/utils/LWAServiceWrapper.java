package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.os.RemoteException;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.authorization.AmazonAuthorizationServiceInterface;
import com.amazon.identity.auth.device.authorization.ServiceConnectionState;
import com.amazon.identity.auth.device.authorization.ThirdPartyServiceHelper;
import org.apache.commons.lang3.exception.ExceptionUtils;

/* loaded from: classes3.dex */
public abstract class LWAServiceWrapper<Result> {
    public abstract Object a(Context context, AmazonAuthorizationServiceInterface amazonAuthorizationServiceInterface);

    public final Object b(Context context, ThirdPartyServiceHelper thirdPartyServiceHelper) {
        AmazonAuthorizationServiceInterface remoteAndroidService;
        Object objA = null;
        RemoteException e2 = null;
        int i2 = 0;
        while (i2 <= 3) {
            try {
                remoteAndroidService = thirdPartyServiceHelper.getRemoteAndroidService(context, i2 == 3);
            } catch (RemoteException e3) {
                e2 = e3;
                InstrumentUtil.addMetricEvent("RemoteAuthServiceFound", "LWA_LITE_SDK.AUTHORIZE_WITH_SERVICE", context, "RemoteException", ExceptionUtils.getStackTrace(e2));
                ThirdPartyServiceHelper.unbind(context);
            }
            if (remoteAndroidService != null) {
                c(ServiceConnectionState.INITIATED);
                InstrumentUtil.addMetricEvent("RemoteAuthServiceFound", "LWA_LITE_SDK.AUTHORIZE_WITH_SERVICE", context, (String) null, (String) null);
                objA = a(context, remoteAndroidService);
                ThirdPartyServiceHelper.unbind(context);
                c(ServiceConnectionState.CLOSED);
                return objA;
            }
            continue;
            i2++;
        }
        if (objA != null || e2 == null) {
            return objA;
        }
        throw new AuthError("Service Failure", e2, AuthError.ERROR_TYPE.ERROR_THREAD);
    }

    public void c(ServiceConnectionState serviceConnectionState) {
    }
}

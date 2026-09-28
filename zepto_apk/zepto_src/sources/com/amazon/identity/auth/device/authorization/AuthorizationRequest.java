package com.amazon.identity.auth.device.authorization;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.a;
import com.amazon.identity.auth.device.api.authorization.AuthorizeRequest;
import com.amazon.identity.auth.device.authorization.api.AuthorizationListener;
import com.amazon.identity.auth.device.dataobject.AppInfo;
import java.net.MalformedURLException;

/* loaded from: classes3.dex */
public class AuthorizationRequest extends a {

    /* renamed from: b, reason: collision with root package name */
    public final String f15133b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f15134c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f15135d;

    /* renamed from: e, reason: collision with root package name */
    public final AppInfo f15136e;

    /* renamed from: f, reason: collision with root package name */
    public final AuthorizationListener f15137f;

    public AuthorizationRequest(AuthorizeRequest authorizeRequest, String str, String[] strArr, Bundle bundle, AppInfo appInfo, AuthorizationListener authorizationListener) {
        super(authorizeRequest);
        this.f15133b = str;
        this.f15134c = strArr;
        this.f15135d = bundle;
        this.f15136e = appInfo;
        this.f15137f = authorizationListener;
        if (authorizeRequest != null) {
            bundle.putString("InteractiveRequestType", authorizeRequest.getRequestType());
        }
    }

    @Override // com.amazon.identity.auth.device.a
    public String getUrl(Context context) throws AuthError {
        try {
            return AuthorizationHelper.getOAuth2Url(context, context.getPackageName(), this.f15133b, this.f15134c, this.requestId, true, false, this.f15135d, this.f15136e);
        } catch (MalformedURLException e2) {
            throw new AuthError("MalformedURLException", e2, AuthError.ERROR_TYPE.ERROR_BAD_PARAM);
        }
    }

    @Override // com.amazon.identity.auth.device.a
    public boolean handleResponse(Uri uri, Context context) {
        AuthorizationResponseProcessor.handleResponse(context, uri, this.f15134c, this.originalRequest != null, this.f15137f);
        return true;
    }
}

package d;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.appid.AppIdentifier;
import com.amazon.identity.auth.device.authorization.AuthorizationHelper;
import com.amazon.identity.auth.device.authorization.AuthorizationResponseParser;
import com.amazon.identity.auth.device.authorization.api.AuthorizationListener;
import com.amazon.identity.auth.device.dataobject.AppInfo;
import com.amazon.identity.auth.device.endpoint.TokenVendor;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bundle f48298a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f48299b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48300c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f48301d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ TokenVendor f48302e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Bundle f48303f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AuthorizationListener f48304g;

    public b(Context context, Bundle bundle, Bundle bundle2, AppIdentifier appIdentifier, AuthorizationHelper authorizationHelper, AuthorizationListener authorizationListener, TokenVendor tokenVendor, String str, String str2) {
        this.f48298a = bundle;
        this.f48299b = context;
        this.f48300c = str;
        this.f48301d = str2;
        this.f48302e = tokenVendor;
        this.f48303f = bundle2;
        this.f48304g = authorizationListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AuthorizationListener authorizationListener = this.f48304g;
        Bundle bundle = this.f48298a;
        String str = this.f48301d;
        TokenVendor tokenVendor = this.f48302e;
        Bundle bundle2 = this.f48303f;
        int i2 = j.a.f53503a;
        if (Looper.getMainLooper() != null && Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException("authorize started on main thread");
        }
        String string = bundle.getString("code");
        if (TextUtils.isEmpty(string)) {
            authorizationListener.onError(new AuthError("Response bundle from Authorization was empty", AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE));
            return;
        }
        bundle.getString("clientId");
        String string2 = bundle.getString(AuthorizationResponseParser.REDIRECT_URI_STATE);
        String[] stringArray = bundle.getStringArray(AuthorizationResponseParser.SCOPE);
        bundle.getString(AuthorizationResponseParser.RESPONSE_URL);
        Arrays.toString(stringArray);
        String str2 = this.f48300c;
        Context context = this.f48299b;
        AppInfo appInfoA = AppIdentifier.a(context, str2);
        if (appInfoA == null) {
            authorizationListener.onError(new AuthError("Unable to extract AppInfo", AuthError.ERROR_TYPE.ERROR_UNKNOWN));
            return;
        }
        try {
            authorizationListener.onSuccess(tokenVendor.a(string, str, string2, stringArray, context, appInfoA, bundle2));
        } catch (AuthError e2) {
            e2.getMessage();
            authorizationListener.onError(e2);
        } catch (IOException e3) {
            authorizationListener.onError(new AuthError("Failed to exchange code for token", e3, AuthError.ERROR_TYPE.ERROR_IO));
        }
    }
}

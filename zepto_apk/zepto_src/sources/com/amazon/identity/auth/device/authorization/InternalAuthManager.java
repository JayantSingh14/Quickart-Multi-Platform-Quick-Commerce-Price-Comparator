package com.amazon.identity.auth.device.authorization;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.authorization.AuthorizationManager;
import com.amazon.identity.auth.device.api.authorization.AuthorizeRequest;
import com.amazon.identity.auth.device.api.authorization.Region;
import com.amazon.identity.auth.device.appid.AppIdentifier;
import com.amazon.identity.auth.device.authorization.api.AuthorizationListener;
import com.amazon.identity.auth.device.authorization.api.AuthzConstants;
import com.amazon.identity.auth.device.dataobject.AppInfo;
import com.amazon.identity.auth.device.endpoint.TokenVendor;
import com.amazon.identity.auth.device.env.LWAEnvironment;
import com.amazon.identity.auth.device.shared.APIListener;
import com.amazon.identity.auth.device.thread.AuthzCallbackFuture;
import com.amazon.identity.auth.device.utils.DefaultLibraryInfo;
import f.j;
import f.k;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.Future;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class InternalAuthManager {

    /* renamed from: c, reason: collision with root package name */
    public static final AppIdentifier f15139c = new AppIdentifier();

    /* renamed from: d, reason: collision with root package name */
    public static final TokenVendor f15140d = new TokenVendor();

    /* renamed from: e, reason: collision with root package name */
    public static InternalAuthManager f15141e;

    /* renamed from: a, reason: collision with root package name */
    public final String f15142a;

    /* renamed from: b, reason: collision with root package name */
    public final AppInfo f15143b;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f15144a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AuthorizationListener f15145b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Bundle f15146c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AuthorizeRequest f15147d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String[] f15148e;

        public a(Context context, AuthorizationListener authorizationListener, Bundle bundle, AuthorizeRequest authorizeRequest, String[] strArr) {
            this.f15144a = context;
            this.f15145b = authorizationListener;
            this.f15146c = bundle;
            this.f15147d = authorizeRequest;
            this.f15148e = strArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InternalAuthManager internalAuthManager = InternalAuthManager.this;
            Context context = this.f15144a;
            boolean zIsAPIKeyValid = internalAuthManager.isAPIKeyValid(context);
            AuthorizationListener authorizationListener = this.f15145b;
            if (!zIsAPIKeyValid) {
                authorizationListener.onError(new AuthError("APIKey is invalid", AuthError.ERROR_TYPE.ERROR_ACCESS_DENIED));
                return;
            }
            Bundle bundle = this.f15146c;
            Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
            AuthzConstants.BUNDLE_KEY bundle_key = AuthzConstants.BUNDLE_KEY.SANDBOX;
            if (!bundle2.containsKey(bundle_key.val)) {
                bundle2.putBoolean(bundle_key.val, AuthorizationManager.isSandboxMode(context));
            }
            try {
                new ThirdPartyAuthorizationHelper().authorize(this.f15147d, context, context.getPackageName(), internalAuthManager.f15142a, internalAuthManager.getRedirectURI(context), this.f15148e, true, InternalAuthManager.f15140d, this.f15145b, bundle2);
            } catch (AuthError e2) {
                authorizationListener.onError(e2);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f15150a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AuthzCallbackFuture f15151b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String[] f15152c;

        public final class a implements APIListener {
            public a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
            public final void onError(AuthError authError) {
                b.this.f15151b.onError(authError);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
            public final void onSuccess(Bundle bundle) {
                b.this.f15151b.onSuccess(bundle);
            }
        }

        public b(Context context, AuthzCallbackFuture authzCallbackFuture, String[] strArr) {
            this.f15150a = context;
            this.f15151b = authzCallbackFuture;
            this.f15152c = strArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AuthzCallbackFuture authzCallbackFuture = this.f15151b;
            InternalAuthManager internalAuthManager = InternalAuthManager.this;
            Context context = this.f15150a;
            try {
                if (!internalAuthManager.isAPIKeyValid(context)) {
                    authzCallbackFuture.onError(new AuthError("APIKey is invalid", AuthError.ERROR_TYPE.ERROR_ACCESS_DENIED));
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean(AuthzConstants.BUNDLE_KEY.SANDBOX.val, AuthorizationManager.isSandboxMode(context));
                TokenHelper.getToken(context, context.getPackageName(), internalAuthManager.f15142a, this.f15152c, new a(), new AppIdentifier(), bundle);
            } catch (AuthError e2) {
                authzCallbackFuture.onError(e2);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f15155a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AuthzCallbackFuture f15156b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Bundle f15157c;

        public final class a implements APIListener {
            public a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
            public final void onError(AuthError authError) {
                c.this.f15156b.onError(authError);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
            public final void onSuccess(Bundle bundle) {
                c.this.f15156b.onSuccess(bundle);
            }
        }

        public c(Context context, AuthzCallbackFuture authzCallbackFuture, Bundle bundle) {
            this.f15155a = context;
            this.f15156b = authzCallbackFuture;
            this.f15157c = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InternalAuthManager internalAuthManager = InternalAuthManager.this;
            Context context = this.f15155a;
            if (!internalAuthManager.isAPIKeyValid(context)) {
                this.f15156b.onError(new AuthError("APIKey is invalid", AuthError.ERROR_TYPE.ERROR_ACCESS_DENIED));
                return;
            }
            Bundle bundle = this.f15157c;
            Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
            AuthzConstants.BUNDLE_KEY bundle_key = AuthzConstants.BUNDLE_KEY.SANDBOX;
            if (!bundle2.containsKey(bundle_key.val)) {
                bundle2.putBoolean(bundle_key.val, AuthorizationManager.isSandboxMode(context));
            }
            ProfileHelper.getProfile(context, context.getPackageName(), bundle2, new a());
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f15160a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AuthzCallbackFuture f15161b;

        public d(Context context, AuthzCallbackFuture authzCallbackFuture) {
            this.f15160a = context;
            this.f15161b = authzCallbackFuture;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InternalAuthManager internalAuthManager = InternalAuthManager.this;
            Context context = this.f15160a;
            boolean zIsAPIKeyValid = internalAuthManager.isAPIKeyValid(context);
            AuthzCallbackFuture authzCallbackFuture = this.f15161b;
            if (!zIsAPIKeyValid) {
                authzCallbackFuture.onError(new AuthError("APIKey is invalid", AuthError.ERROR_TYPE.ERROR_ACCESS_DENIED));
                return;
            }
            internalAuthManager.getClass();
            AuthError authError = null;
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean(AuthzConstants.BUNDLE_KEY.SANDBOX.val, AuthorizationManager.isSandboxMode(context));
                TokenHelper.clearAuthStateServerSide(context, internalAuthManager.f15143b, bundle);
                e = null;
            } catch (AuthError e2) {
                e = e2;
            }
            internalAuthManager.getClass();
            try {
                int i2 = k.f48364b;
                new j().b(context, new ThirdPartyServiceHelper());
            } catch (AuthError e3) {
                authError = e3;
            }
            k.c(context);
            if (e == null && authError == null) {
                authzCallbackFuture.onSuccess(new Bundle());
            } else if (e != null) {
                authzCallbackFuture.onError(e);
            } else if (authError != null) {
                authzCallbackFuture.onError(authError);
            }
        }
    }

    public InternalAuthManager(Context context) {
        String str;
        AppIdentifier appIdentifier = f15139c;
        String packageName = context.getPackageName();
        appIdentifier.getClass();
        AppInfo appInfoA = AppIdentifier.a(context, packageName);
        this.f15143b = appInfoA;
        if (appInfoA == null || (str = appInfoA.f15208e) == null) {
            throw new IllegalArgumentException("Invalid API Key");
        }
        this.f15142a = str;
    }

    public static InternalAuthManager getInstance(Context context) {
        if (f15141e == null) {
            synchronized (InternalAuthManager.class) {
                try {
                    if (f15141e == null) {
                        f15141e = new InternalAuthManager(context);
                    }
                } finally {
                }
            }
        }
        return f15141e;
    }

    public Future<Bundle> authorize(AuthorizeRequest authorizeRequest, Context context, String[] strArr, Bundle bundle, AuthorizationListener authorizationListener) throws JSONException {
        InstrumentUtil.addMetricEvent("authorizeStarted", "LWA_LITE_SDK.INTERNAL_AUTH_MANAGER_OPERATION", context, (String) null, (String) null);
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("scopes must not be null or empty!");
        }
        context.getPackageName();
        Arrays.toString(strArr);
        j.a.f53504b.execute(new a(context, authorizationListener, bundle, authorizeRequest, strArr));
        return null;
    }

    public Future<Bundle> clearAuthorizationState(Context context, APIListener aPIListener) {
        AuthzCallbackFuture authzCallbackFuture = new AuthzCallbackFuture(aPIListener);
        context.getPackageName();
        j.a.f53504b.execute(new d(context, authzCallbackFuture));
        return authzCallbackFuture;
    }

    public String getClientId() {
        return this.f15142a;
    }

    public Future<Bundle> getProfile(Context context, Bundle bundle, APIListener aPIListener) {
        context.getPackageName();
        AuthzCallbackFuture authzCallbackFuture = new AuthzCallbackFuture(aPIListener);
        j.a.f53504b.execute(new c(context, authzCallbackFuture, bundle));
        return authzCallbackFuture;
    }

    public String getRedirectURI(Context context) {
        f15139c.getClass();
        return "amzn://" + context.getPackageName();
    }

    public Region getRegion(Context context) {
        h.b bVar;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.amazon.lwa.LWASharedPreferences", 0);
        Region region = Region.AUTO;
        Region regionValueOf = Region.valueOf(sharedPreferences.getString("com.amazon.lwa.regionMode", region.toString()));
        if (region != regionValueOf) {
            return regionValueOf;
        }
        AppInfo appInfo = this.f15143b;
        synchronized (LWAEnvironment.class) {
            bVar = new h.b(context, appInfo);
        }
        Region region2 = Region.NA;
        try {
            String str = bVar.f48435f;
            if (str != null) {
                return (Region) h.a.f48429h.get("https://" + new URL(str).getHost());
            }
        } catch (MalformedURLException unused) {
        }
        return region2;
    }

    public Future<Bundle> getToken(Context context, String[] strArr, APIListener aPIListener) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("scopes must not be null or empty!");
        }
        context.getPackageName();
        Arrays.toString(strArr);
        AuthzCallbackFuture authzCallbackFuture = new AuthzCallbackFuture(aPIListener);
        j.a.f53504b.execute(new b(context, authzCallbackFuture, strArr));
        return authzCallbackFuture;
    }

    public boolean isAPIKeyValid(Context context) {
        String packageName;
        f15139c.getClass();
        return (context == null || (packageName = context.getPackageName()) == null || AppIdentifier.a(context, packageName) == null || this.f15142a == null) ? false : true;
    }

    public void setRegion(Context context, Region region) {
        Region region2;
        synchronized (DefaultLibraryInfo.class) {
            region2 = DefaultLibraryInfo.f15245a;
        }
        if (region2 != region) {
            context.getSharedPreferences("com.amazon.lwa.LWASharedPreferences", 0).edit().putString("com.amazon.lwa.regionMode", region.toString()).commit();
            synchronized (DefaultLibraryInfo.class) {
                DefaultLibraryInfo.f15245a = region;
                region.toString();
            }
        }
    }
}

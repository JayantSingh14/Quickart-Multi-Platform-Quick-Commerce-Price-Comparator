package com.amazon.identity.auth.device.authorization;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.appid.AppIdentifier;
import com.amazon.identity.auth.device.dataobject.AppInfo;
import com.amazon.identity.auth.device.dataobject.Profile;
import com.amazon.identity.auth.device.dataobject.RequestedScope;
import com.amazon.identity.auth.device.endpoint.ServerCommunication;
import com.amazon.identity.auth.device.shared.APIListener;
import f.m;
import f.n;
import g.p;
import g.q;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import k.b;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ProfileHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final ServerCommunication f15163a = new ServerCommunication();

    public class a implements APIListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f15164a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bundle f15165b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ APIListener f15166c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AppInfo f15167d;

        public a(Context context, Bundle bundle, APIListener aPIListener, AppInfo appInfo) {
            this.f15164a = context;
            this.f15165b = bundle;
            this.f15166c = aPIListener;
            this.f15167d = appInfo;
        }

        @Override // com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
        public final void onError(AuthError authError) {
            this.f15166c.onError(authError);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
        @Override // com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void onSuccess(android.os.Bundle r9) {
            /*
                Method dump skipped, instructions count: 293
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazon.identity.auth.device.authorization.ProfileHelper.a.onSuccess(android.os.Bundle):void");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amazon.identity.auth.device.shared.APIListener
        public final void onError(AuthError authError) {
            this.f15166c.onError(authError);
        }
    }

    public static JSONObject a(Context context, Bundle bundle, AppInfo appInfo, String str) throws AuthError, IOException {
        f15163a.getClass();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null) {
            throw new IOException("Network is unavailable");
        }
        q qVar = (q) new p(context, bundle, appInfo, str).k();
        qVar.f();
        return qVar.f48427d;
    }

    public static void getProfile(Context context, String str, Bundle bundle, APIListener aPIListener) {
        new AppIdentifier();
        AppInfo appInfoA = AppIdentifier.a(context, str);
        if (appInfoA == null) {
            aPIListener.onError(new AuthError("App info is null", AuthError.ERROR_TYPE.ERROR_ACCESS_DENIED));
            return;
        }
        try {
            TokenHelper.getToken(context, str, appInfoA.f15208e, a(context, appInfoA), new a(context, bundle, aPIListener, appInfoA), new AppIdentifier(), bundle);
        } catch (AuthError e2) {
            aPIListener.onError(e2);
        }
    }

    public static void a(Context context, String str, JSONObject jSONObject) {
        m mVarK = m.k(context);
        mVarK.f();
        String string = jSONObject.toString();
        Date date = new Date(Calendar.getInstance().getTime().getTime() + DateUtils.MILLIS_PER_HOUR);
        Profile profile = new Profile();
        profile.f15223b = str;
        profile.f15224c = string;
        profile.f15225d = date;
        mVarK.b(profile, null);
    }

    public static Bundle a(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            bundle.putString(next, jSONObject.getString(next));
        }
        bundle.toString();
        return bundle;
    }

    public static boolean a(Bundle bundle) {
        return bundle != null && bundle.containsKey("com.amazon.identity.auth.device.authorization.failOnInsufficientScope");
    }

    public static String[] a(Context context, AppInfo appInfo) {
        n nVar;
        synchronized (n.class) {
            try {
                if (n.f48367b == null) {
                    n.f48367b = new n(b.b(context));
                }
                nVar = n.f48367b;
            } catch (Throwable th) {
                throw th;
            }
        }
        String str = appInfo.f15205b;
        nVar.getClass();
        ArrayList arrayListE = nVar.e(new String[]{RequestedScope.f15226g[2]}, new String[]{str});
        String[] strArr = new String[arrayListE.size()];
        Iterator it = arrayListE.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            strArr[i2] = ((RequestedScope) it.next()).f15227b;
            i2++;
        }
        return strArr;
    }
}

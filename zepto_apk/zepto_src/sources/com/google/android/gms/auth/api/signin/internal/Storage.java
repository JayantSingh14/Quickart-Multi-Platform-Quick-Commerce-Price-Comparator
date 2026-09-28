package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.media.b;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@KeepForSdk
/* loaded from: classes4.dex */
public class Storage {

    /* renamed from: c, reason: collision with root package name */
    public static final ReentrantLock f22203c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    public static Storage f22204d;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantLock f22205a = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f22206b;

    public Storage(Context context) {
        this.f22206b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static Storage a(Context context) {
        Preconditions.checkNotNull(context);
        ReentrantLock reentrantLock = f22203c;
        reentrantLock.lock();
        try {
            if (f22204d == null) {
                f22204d = new Storage(context.getApplicationContext());
            }
            Storage storage = f22204d;
            reentrantLock.unlock();
            return storage;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static final String g(String str, String str2) {
        return b.l(str, ":", str2);
    }

    public final GoogleSignInAccount b() {
        String strD;
        String strD2 = d("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strD2) || (strD = d(g("googleSignInAccount", strD2))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.r(strD);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final void c(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) throws JSONException {
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        f("defaultGoogleSignInAccount", googleSignInAccount.f22159i);
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        String str = googleSignInAccount.f22159i;
        String strG = g("googleSignInAccount", str);
        JSONObject jSONObject = new JSONObject();
        try {
            String str2 = googleSignInAccount.f22152b;
            if (str2 != null) {
                jSONObject.put(CLConstants.SHARED_PREFERENCE_ITEM_ID, str2);
            }
            String str3 = googleSignInAccount.f22153c;
            if (str3 != null) {
                jSONObject.put("tokenId", str3);
            }
            String str4 = googleSignInAccount.f22154d;
            if (str4 != null) {
                jSONObject.put(Scopes.EMAIL, str4);
            }
            String str5 = googleSignInAccount.f22155e;
            if (str5 != null) {
                jSONObject.put("displayName", str5);
            }
            String str6 = googleSignInAccount.f22161k;
            if (str6 != null) {
                jSONObject.put("givenName", str6);
            }
            String str7 = googleSignInAccount.f22162l;
            if (str7 != null) {
                jSONObject.put("familyName", str7);
            }
            Uri uri = googleSignInAccount.f22156f;
            if (uri != null) {
                jSONObject.put("photoUrl", uri.toString());
            }
            String str8 = googleSignInAccount.f22157g;
            if (str8 != null) {
                jSONObject.put("serverAuthCode", str8);
            }
            jSONObject.put("expirationTime", googleSignInAccount.f22158h);
            jSONObject.put("obfuscatedIdentifier", str);
            JSONArray jSONArray = new JSONArray();
            ArrayList arrayList = googleSignInAccount.f22160j;
            Scope[] scopeArr = (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
            Arrays.sort(scopeArr, com.google.android.gms.auth.api.signin.zaa.f22221a);
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.getScopeUri());
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove("serverAuthCode");
            f(strG, jSONObject.toString());
            String strG2 = g("googleSignInOptions", str);
            String str9 = googleSignInOptions.f22175h;
            String str10 = googleSignInOptions.f22174g;
            ArrayList arrayList2 = googleSignInOptions.f22169b;
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONArray jSONArray2 = new JSONArray();
                Collections.sort(arrayList2, GoogleSignInOptions.o);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(((Scope) it.next()).getScopeUri());
                }
                jSONObject2.put("scopes", jSONArray2);
                Account account = googleSignInOptions.f22170c;
                if (account != null) {
                    jSONObject2.put("accountName", account.name);
                }
                jSONObject2.put("idTokenRequested", googleSignInOptions.f22171d);
                jSONObject2.put("forceCodeForRefreshToken", googleSignInOptions.f22173f);
                jSONObject2.put("serverAuthRequested", googleSignInOptions.f22172e);
                if (!TextUtils.isEmpty(str10)) {
                    jSONObject2.put("serverClientId", str10);
                }
                if (!TextUtils.isEmpty(str9)) {
                    jSONObject2.put("hostedDomain", str9);
                }
                f(strG2, jSONObject2.toString());
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        } catch (JSONException e3) {
            throw new RuntimeException(e3);
        }
    }

    public final String d(String str) {
        ReentrantLock reentrantLock = this.f22205a;
        reentrantLock.lock();
        try {
            return this.f22206b.getString(str, null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void e(String str) {
        ReentrantLock reentrantLock = this.f22205a;
        reentrantLock.lock();
        try {
            this.f22206b.edit().remove(str).apply();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void f(String str, String str2) {
        ReentrantLock reentrantLock = this.f22205a;
        reentrantLock.lock();
        try {
            this.f22206b.edit().putString(str, str2).apply();
        } finally {
            reentrantLock.unlock();
        }
    }
}

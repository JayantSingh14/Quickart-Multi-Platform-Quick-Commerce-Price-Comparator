package com.amazon.identity.auth.device.api.authorization;

import android.content.Context;
import android.os.Bundle;
import c.b;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.Listener;
import com.amazon.identity.auth.device.authorization.InternalAuthManager;
import com.google.android.gms.common.Scopes;
import java.util.HashMap;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public final class User {

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, String> f15121a;

    public User(HashMap map) {
        this.f15121a = map;
    }

    public static void fetch(Context context, Listener<User, AuthError> listener) {
        InternalAuthManager internalAuthManager = InternalAuthManager.getInstance(context);
        context.getPackageName();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.amazon.identity.auth.device.authorization.failOnInsufficientScope", true);
        internalAuthManager.getProfile(context, bundle, new b(listener));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || User.class != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        Map<String, String> map = this.f15121a;
        if (map == null) {
            if (user.f15121a != null) {
                return false;
            }
        } else if (!map.equals(user.f15121a)) {
            return false;
        }
        return true;
    }

    public String getUserEmail() {
        return this.f15121a.get(Scopes.EMAIL);
    }

    public String getUserId() {
        return this.f15121a.get("user_id");
    }

    public Map<String, String> getUserInfo() {
        return this.f15121a;
    }

    public String getUserName() {
        return this.f15121a.get(CLConstants.FIELD_PAY_INFO_NAME);
    }

    public String getUserPostalCode() {
        return this.f15121a.get("postal_code");
    }

    public int hashCode() {
        Map<String, String> map = this.f15121a;
        return (map == null ? 0 : map.hashCode()) + 31;
    }

    public String toString() {
        return String.format("%s={userInfo=%s}", super.toString(), this.f15121a);
    }
}

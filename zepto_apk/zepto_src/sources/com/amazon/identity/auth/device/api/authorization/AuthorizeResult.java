package com.amazon.identity.auth.device.api.authorization;

import android.os.Bundle;
import com.amazon.identity.auth.device.authorization.api.AuthzConstants;

/* loaded from: classes3.dex */
public final class AuthorizeResult {

    /* renamed from: a, reason: collision with root package name */
    public final String f15109a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15110b;

    /* renamed from: c, reason: collision with root package name */
    public final User f15111c;

    /* renamed from: d, reason: collision with root package name */
    public final String f15112d;

    /* renamed from: e, reason: collision with root package name */
    public final String f15113e;

    public AuthorizeResult(Bundle bundle) {
        this(bundle, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthorizeResult.class != obj.getClass()) {
            return false;
        }
        AuthorizeResult authorizeResult = (AuthorizeResult) obj;
        String str = this.f15109a;
        if (str == null) {
            if (authorizeResult.f15109a != null) {
                return false;
            }
        } else if (!str.equals(authorizeResult.f15109a)) {
            return false;
        }
        String str2 = this.f15110b;
        if (str2 == null) {
            if (authorizeResult.f15110b != null) {
                return false;
            }
        } else if (!str2.equals(authorizeResult.f15110b)) {
            return false;
        }
        User user = this.f15111c;
        if (user == null) {
            if (authorizeResult.f15111c != null) {
                return false;
            }
        } else if (!user.equals(authorizeResult.f15111c)) {
            return false;
        }
        String str3 = this.f15112d;
        if (str3 == null) {
            if (authorizeResult.f15112d != null) {
                return false;
            }
        } else if (!str3.equals(authorizeResult.f15112d)) {
            return false;
        }
        String str4 = this.f15113e;
        if (str4 == null) {
            if (authorizeResult.f15113e != null) {
                return false;
            }
        } else if (!str4.equals(authorizeResult.f15113e)) {
            return false;
        }
        return true;
    }

    public String getAccessToken() {
        return this.f15109a;
    }

    public String getAuthorizationCode() {
        return this.f15110b;
    }

    public String getClientId() {
        return this.f15112d;
    }

    public String getRedirectURI() {
        return this.f15113e;
    }

    public User getUser() {
        return this.f15111c;
    }

    public int hashCode() {
        String str = this.f15109a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f15110b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        User user = this.f15111c;
        int iHashCode3 = (iHashCode2 + (user == null ? 0 : user.hashCode())) * 31;
        String str3 = this.f15112d;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f15113e;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public AuthorizeResult(Bundle bundle, User user) {
        this.f15109a = bundle.getString(AuthzConstants.BUNDLE_KEY.TOKEN.val);
        this.f15110b = bundle.getString(AuthzConstants.BUNDLE_KEY.AUTHORIZATION_CODE.val);
        this.f15112d = bundle.getString(AuthzConstants.BUNDLE_KEY.CLIENT_ID.val);
        this.f15113e = bundle.getString(AuthzConstants.BUNDLE_KEY.REDIRECT_URI.val);
        this.f15111c = user;
    }
}

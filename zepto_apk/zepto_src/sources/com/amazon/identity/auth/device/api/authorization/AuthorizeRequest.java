package com.amazon.identity.auth.device.api.authorization;

import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.workflow.RequestContext;
import com.amazon.identity.auth.device.interactive.InteractiveRequest;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public final class AuthorizeRequest extends InteractiveRequest<AuthorizeListener, AuthorizeResult, AuthCancellation, AuthError> {

    /* renamed from: b, reason: collision with root package name */
    public List<Scope> f15100b;

    /* renamed from: c, reason: collision with root package name */
    public GrantType f15101c;

    /* renamed from: d, reason: collision with root package name */
    public String f15102d;

    /* renamed from: e, reason: collision with root package name */
    public String f15103e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15104f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15105g;

    /* renamed from: h, reason: collision with root package name */
    public SubRegion f15106h;

    public static final class Builder extends InteractiveRequest.Builder<AuthorizeRequest> {

        /* renamed from: a, reason: collision with root package name */
        public final AuthorizeRequest f15107a;

        public Builder(RequestContext requestContext) {
            super(requestContext);
            this.f15107a = new AuthorizeRequest(this.requestContext);
        }

        public Builder addScope(Scope scope) {
            this.f15107a.addScope(scope);
            return this;
        }

        public Builder addScopes(Scope... scopeArr) {
            this.f15107a.addScopes(scopeArr);
            return this;
        }

        public Builder forGrantType(GrantType grantType) {
            this.f15107a.setGrantType(grantType);
            return this;
        }

        public Builder shouldReturnUserData(boolean z) {
            this.f15107a.setShouldReturnUserData(z);
            return this;
        }

        public Builder showProgress(boolean z) {
            this.f15107a.showProgress(z);
            return this;
        }

        public Builder splitSignInForSubRegion(SubRegion subRegion) {
            this.f15107a.setSplitSignInForSubRegion(subRegion);
            return this;
        }

        public Builder withProofKeyParameters(String str, String str2) {
            this.f15107a.setProofKeyParameters(str, str2);
            return this;
        }

        @Override // com.amazon.identity.auth.device.interactive.InteractiveRequest.Builder
        public AuthorizeRequest build() {
            return this.f15107a;
        }
    }

    public enum GrantType {
        ACCESS_TOKEN,
        AUTHORIZATION_CODE
    }

    public AuthorizeRequest(RequestContext requestContext) {
        super(requestContext);
        this.f15100b = new LinkedList();
        this.f15101c = GrantType.ACCESS_TOKEN;
        this.f15105g = true;
        this.f15104f = true;
    }

    public void addScope(Scope scope) {
        this.f15100b.add(scope);
    }

    public void addScopes(Scope... scopeArr) {
        Collections.addAll(this.f15100b, scopeArr);
    }

    public String getCodeChallenge() {
        return this.f15102d;
    }

    public String getCodeChallengeMethod() {
        return this.f15103e;
    }

    public GrantType getGrantType() {
        return this.f15101c;
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveRequest
    public final Class<AuthorizeListener> getListenerClass() {
        return AuthorizeListener.class;
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveRequest
    public final Bundle getRequestExtras() {
        Bundle bundle = new Bundle();
        String[] strArr = new String[this.f15100b.size()];
        for (int i2 = 0; i2 < this.f15100b.size(); i2++) {
            strArr[i2] = this.f15100b.get(i2).getName();
        }
        bundle.putStringArray("requestedScopes", strArr);
        bundle.putBoolean("shouldReturnUserData", shouldReturnUserData());
        bundle.putBoolean("com.amazon.identity.auth.device.authorizationshowProgress", this.f15104f);
        return bundle;
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveAPI
    public final String getRequestType() {
        return "com.amazon.identity.auth.device.authorization.request.authorize";
    }

    public List<Scope> getScopes() {
        return this.f15100b;
    }

    public SubRegion getSplitSignInForSubRegion() {
        return this.f15106h;
    }

    public void setCodeChallenge(String str) {
        this.f15102d = str;
    }

    public void setCodeChallengeMethod(String str) {
        this.f15103e = str;
    }

    public void setGrantType(GrantType grantType) {
        this.f15101c = grantType;
    }

    public void setProofKeyParameters(String str, String str2) {
        setCodeChallenge(str);
        setCodeChallengeMethod(str2);
    }

    public void setScopes(List<Scope> list) {
        this.f15100b = list;
    }

    public void setShouldReturnUserData(boolean z) {
        this.f15105g = z;
    }

    public void setSplitSignInForSubRegion(SubRegion subRegion) {
        this.f15106h = subRegion;
    }

    public boolean shouldReturnUserData() {
        return this.f15105g;
    }

    public boolean shouldShowProgress() {
        return this.f15104f;
    }

    public void showProgress(boolean z) {
        this.f15104f = z;
    }
}

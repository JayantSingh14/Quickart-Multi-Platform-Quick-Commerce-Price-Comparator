package com.google.android.gms.auth.api;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzbt;

/* loaded from: classes4.dex */
public final class Auth {

    /* renamed from: a, reason: collision with root package name */
    public static final Api f22022a;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        Api.ClientKey clientKey2 = new Api.ClientKey();
        zba zbaVar = new zba();
        zbb zbbVar = new zbb();
        Api api = AuthProxy.f22023a;
        new Api("Auth.CREDENTIALS_API", zbaVar, clientKey);
        f22022a = new Api("Auth.GOOGLE_SIGN_IN_API", zbbVar, clientKey2);
        zzbt zzbtVar = AuthProxy.f22024b;
        new com.google.android.gms.auth.api.signin.internal.zbd();
    }
}

package com.google.android.gms.signin;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;

/* loaded from: classes4.dex */
public final class zad {

    /* renamed from: a, reason: collision with root package name */
    public static final Api.AbstractClientBuilder f39732a;

    /* renamed from: b, reason: collision with root package name */
    public static final Api f39733b;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        Api.ClientKey clientKey2 = new Api.ClientKey();
        zaa zaaVar = new zaa();
        f39732a = zaaVar;
        zab zabVar = new zab();
        new Scope(Scopes.PROFILE);
        new Scope(Scopes.EMAIL);
        f39733b = new Api("SignIn.API", zaaVar, clientKey);
        new Api("SignIn.INTERNAL_API", zabVar, clientKey2);
    }
}

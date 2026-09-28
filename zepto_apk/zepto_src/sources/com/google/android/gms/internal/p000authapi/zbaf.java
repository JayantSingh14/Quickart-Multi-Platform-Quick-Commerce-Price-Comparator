package com.google.android.gms.internal.p000authapi;

import com.google.android.gms.auth.api.identity.CredentialSavingClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;

/* loaded from: classes4.dex */
public final class zbaf extends GoogleApi implements CredentialSavingClient {
    static {
        new Api("Auth.Api.Identity.CredentialSaving.API", new zbac(), new Api.ClientKey());
    }
}

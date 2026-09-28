package com.google.android.gms.fido.fido2;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;

/* loaded from: classes4.dex */
public class Fido2ApiClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    static {
        new Api("Fido.FIDO2_API", new com.google.android.gms.internal.fido.zzo(), new Api.ClientKey());
    }
}

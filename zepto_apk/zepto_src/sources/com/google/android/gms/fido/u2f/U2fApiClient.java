package com.google.android.gms.fido.u2f;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.internal.fido.zzx;

@Deprecated
/* loaded from: classes4.dex */
public class U2fApiClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    static {
        new Api("Fido.U2F_API", new zzx(), new Api.ClientKey());
    }
}

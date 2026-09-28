package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes4.dex */
public final class AuthProxyOptions implements Api.ApiOptions.Optional {
    static {
        new Bundle();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthProxyOptions)) {
            return false;
        }
        throw null;
    }

    public final int hashCode() {
        throw null;
    }
}

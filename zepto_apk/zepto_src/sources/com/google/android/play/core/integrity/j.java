package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.common.api.ApiException;

/* loaded from: classes4.dex */
public final class j implements k {
    public final ApiException a(Bundle bundle) {
        int i2 = bundle.getInt("error");
        if (i2 == 0) {
            return null;
        }
        return new StandardIntegrityException(i2, null);
    }
}

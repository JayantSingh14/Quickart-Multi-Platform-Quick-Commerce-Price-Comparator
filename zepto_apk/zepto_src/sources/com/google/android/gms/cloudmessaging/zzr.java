package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* loaded from: classes4.dex */
final class zzr extends zzs {
    @Override // com.google.android.gms.cloudmessaging.zzs
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            d(null);
        } else {
            c(new zzt("Invalid response to one way request", null));
        }
    }

    @Override // com.google.android.gms.cloudmessaging.zzs
    public final boolean b() {
        return true;
    }
}

package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* loaded from: classes4.dex */
final class zzu extends zzs {
    @Override // com.google.android.gms.cloudmessaging.zzs
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        d(bundle2);
    }

    @Override // com.google.android.gms.cloudmessaging.zzs
    public final boolean b() {
        return false;
    }
}

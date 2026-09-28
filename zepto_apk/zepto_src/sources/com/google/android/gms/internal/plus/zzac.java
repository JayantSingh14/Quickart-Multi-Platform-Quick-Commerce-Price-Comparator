package com.google.android.gms.internal.plus;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.internal.plus.zzr;
import com.google.android.gms.plus.model.people.Person;

/* loaded from: classes4.dex */
public final class zzac extends DataBufferRef implements Person {
    @Override // com.google.android.gms.common.data.Freezable
    public final Person freeze() {
        int i2;
        String string = getString("displayName");
        String string2 = getString("personId");
        zzr.zzc zzcVar = new zzr.zzc(getString("image"));
        String string3 = getString("objectType");
        if (string3.equals("person")) {
            i2 = 0;
        } else {
            if (!string3.equals("page")) {
                throw new IllegalArgumentException(string3.length() != 0 ? "Unknown objectType string: ".concat(string3) : new String("Unknown objectType string: "));
            }
            i2 = 1;
        }
        return new zzr(string, string2, zzcVar, i2, getString("url"));
    }
}

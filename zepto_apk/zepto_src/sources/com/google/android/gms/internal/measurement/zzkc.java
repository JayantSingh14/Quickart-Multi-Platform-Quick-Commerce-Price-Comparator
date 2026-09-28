package com.google.android.gms.internal.measurement;

import android.support.v4.media.a;
import android.util.Log;

/* loaded from: classes.dex */
final class zzkc extends zzkl {
    @Override // com.google.android.gms.internal.measurement.zzkl
    public final /* synthetic */ Object a(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzjg.f36987b.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (zzjg.f36988c.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        String string = obj.toString();
        String str2 = this.f37035b;
        Log.e("PhenotypeFlag", a.n(new StringBuilder(str2.length() + 28 + string.length()), "Invalid boolean value for ", str2, ": ", string));
        return null;
    }
}

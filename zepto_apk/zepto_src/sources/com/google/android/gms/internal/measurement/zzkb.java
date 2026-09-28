package com.google.android.gms.internal.measurement;

import android.support.v4.media.a;
import android.util.Log;

/* loaded from: classes.dex */
final class zzkb extends zzkl {
    @Override // com.google.android.gms.internal.measurement.zzkl
    public final /* synthetic */ Object a(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String string = obj.toString();
        String str = this.f37035b;
        Log.e("PhenotypeFlag", a.n(new StringBuilder(str.length() + 25 + string.length()), "Invalid long value for ", str, ": ", string));
        return null;
    }
}

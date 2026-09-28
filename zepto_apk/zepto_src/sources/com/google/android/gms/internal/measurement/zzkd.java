package com.google.android.gms.internal.measurement;

import android.support.v4.media.a;
import android.util.Log;

/* loaded from: classes.dex */
final class zzkd extends zzkl {
    @Override // com.google.android.gms.internal.measurement.zzkl
    public final /* synthetic */ Object a(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String string = obj.toString();
        String str = this.f37035b;
        Log.e("PhenotypeFlag", a.n(new StringBuilder(str.length() + 27 + string.length()), "Invalid double value for ", str, ": ", string));
        return null;
    }
}

package com.google.android.gms.internal.measurement;

import android.support.v4.media.b;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzbi extends zzav {
    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao a(String str, zzg zzgVar, ArrayList arrayList) {
        if (str == null || str.isEmpty() || !zzgVar.d(str)) {
            throw new IllegalArgumentException(b.C("Command not found: ", str));
        }
        zzao zzaoVarG = zzgVar.g(str);
        if (zzaoVarG instanceof zzai) {
            return ((zzai) zzaoVarG).a(zzgVar, arrayList);
        }
        throw new IllegalArgumentException(b.D("Function ", str, " is not defined"));
    }
}

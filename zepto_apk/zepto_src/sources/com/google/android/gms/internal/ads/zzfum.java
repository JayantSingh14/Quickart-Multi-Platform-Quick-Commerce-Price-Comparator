package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.concurrent.TimeUnit;

@ShowFirstParty
/* loaded from: classes4.dex */
public final class zzfum {
    public static zzawp a(Context context, String str, String str2) {
        zzawp zzawpVar;
        try {
            zzawpVar = (zzawp) new zzful(context, str, str2).f31891d.poll(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zzawpVar = null;
        }
        return zzawpVar == null ? zzful.b() : zzawpVar;
    }
}

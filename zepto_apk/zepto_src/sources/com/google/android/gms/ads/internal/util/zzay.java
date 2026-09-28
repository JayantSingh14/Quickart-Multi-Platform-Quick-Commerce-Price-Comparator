package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.internal.ads.zzarg;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzarz;
import com.google.android.gms.internal.ads.zzasl;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbpl;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class zzay extends zzarz {

    /* renamed from: c, reason: collision with root package name */
    public final Context f21512c;

    public zzay(Context context, zzasl zzaslVar) {
        super(zzaslVar);
        this.f21512c = context;
    }

    @Override // com.google.android.gms.internal.ads.zzarz, com.google.android.gms.internal.ads.zzard
    public final zzarg a(zzark zzarkVar) {
        if (zzarkVar.f24214b == 0) {
            String str = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.f5);
            String str2 = zzarkVar.f24215c;
            if (Pattern.matches(str, str2)) {
                com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a;
                GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
                Context context = this.f21512c;
                if (googleApiAvailabilityLight.isGooglePlayServicesAvailable(context, 13400000) == 0) {
                    zzarg zzargVarA = new zzbpl(context).a(zzarkVar);
                    if (zzargVarA != null) {
                        zze.k("Got gmscore asset response: ".concat(String.valueOf(str2)));
                        return zzargVarA;
                    }
                    zze.k("Failed to get gmscore asset response: ".concat(String.valueOf(str2)));
                }
            }
        }
        return super.a(zzarkVar);
    }
}

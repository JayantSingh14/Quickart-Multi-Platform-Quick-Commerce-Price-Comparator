package com.google.android.gms.internal.ads;

import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzbme implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final zzbmf f25319a;

    public zzbme(zzbmf zzbmfVar) {
        this.f25319a = zzbmfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        String str = (String) map.get(CLConstants.FIELD_PAY_INFO_NAME);
        if (str == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("App event with no name parameter.");
        } else {
            this.f25319a.p1(str, (String) map.get("info"));
        }
    }
}

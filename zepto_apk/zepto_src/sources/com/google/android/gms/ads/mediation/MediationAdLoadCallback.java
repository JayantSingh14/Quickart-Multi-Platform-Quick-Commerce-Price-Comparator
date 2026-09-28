package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public interface MediationAdLoadCallback<MediationAdT, MediationAdCallbackT> {
    void a(AdError adError);
}

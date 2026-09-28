package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
final class zzem implements zzuj {
    public zzem(zzen zzenVar) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuj
    public final /* bridge */ /* synthetic */ zzuc zza(Object obj, Type type, zzui zzuiVar) {
        CompanionAdSlot companionAdSlot = (CompanionAdSlot) obj;
        return new zzuh(companionAdSlot.getWidth() + "x" + companionAdSlot.getHeight());
    }
}

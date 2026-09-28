package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.impl.JavaScriptMessage;
import com.google.ads.interactivemedia.v3.internal.zzqs;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public final class zze implements com.google.ads.interactivemedia.v3.api.zza {
    private final List<com.google.ads.interactivemedia.v3.api.zzb> icons;
    private final com.google.ads.interactivemedia.v3.impl.zzav router;
    private final String sessionId;

    public zze(com.google.ads.interactivemedia.v3.impl.zzav zzavVar, List<com.google.ads.interactivemedia.v3.api.zzb> list, String str) {
        this.router = zzavVar;
        this.icons = list;
        this.sessionId = str;
    }

    private Map<String, Object> createIconData(com.google.ads.interactivemedia.v3.api.zzb zzbVar) {
        HashMap mapZzb = zzqs.zzb(1);
        mapZzb.put(CLConstants.SHARED_PREFERENCE_ITEM_ID, Integer.valueOf(zzbVar.getId()));
        return mapZzb;
    }

    public List<com.google.ads.interactivemedia.v3.api.zzb> getIcons() {
        return this.icons;
    }

    public void iconClicked(com.google.ads.interactivemedia.v3.api.zzb zzbVar) {
        this.router.zzp(new JavaScriptMessage(JavaScriptMessage.MsgChannel.nativeUi, JavaScriptMessage.MsgType.iconClicked, this.sessionId, createIconData(zzbVar)));
    }

    public void iconShown(com.google.ads.interactivemedia.v3.api.zzb zzbVar) {
        this.router.zzp(new JavaScriptMessage(JavaScriptMessage.MsgChannel.nativeUi, JavaScriptMessage.MsgType.iconRendered, this.sessionId, createIconData(zzbVar)));
    }
}

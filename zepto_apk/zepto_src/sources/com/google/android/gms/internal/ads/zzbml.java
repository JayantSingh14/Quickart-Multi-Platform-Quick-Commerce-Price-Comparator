package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.text.TextUtils;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class zzbml implements zzbnn {
    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) throws NumberFormatException {
        zzcir zzcirVar = (zzcir) obj;
        if (TextUtils.isEmpty((CharSequence) map.get(CLConstants.SALT_FIELD_APP_ID))) {
            com.google.android.gms.ads.internal.util.zze.k("Missing App Id, cannot show LMD Overlay without it");
            return;
        }
        zzgnm zzgnmVar = new zzgnm();
        zzgnmVar.f32979c = 8388691;
        byte b2 = (byte) (zzgnmVar.f32983g | 1);
        zzgnmVar.f32980d = -1.0f;
        zzgnmVar.f32983g = (byte) (((byte) (((byte) (b2 | 2)) | 4)) | 8);
        zzgnmVar.f32978b = (String) map.get(CLConstants.SALT_FIELD_APP_ID);
        zzgnmVar.f32981e = zzcirVar.getWidth();
        zzgnmVar.f32983g = (byte) (zzgnmVar.f32983g | 16);
        IBinder windowToken = zzcirVar.x().getWindowToken();
        if (windowToken == null) {
            throw new NullPointerException("Null windowToken");
        }
        zzgnmVar.f32977a = windowToken;
        if (map.containsKey("gravityX") && map.containsKey("gravityY")) {
            zzgnmVar.f32979c = Integer.parseInt((String) map.get("gravityX")) | Integer.parseInt((String) map.get("gravityY"));
            zzgnmVar.f32983g = (byte) (zzgnmVar.f32983g | 1);
        } else {
            zzgnmVar.f32979c = 81;
            zzgnmVar.f32983g = (byte) (zzgnmVar.f32983g | 1);
        }
        if (map.containsKey("verticalMargin")) {
            zzgnmVar.f32980d = Float.parseFloat((String) map.get("verticalMargin"));
            zzgnmVar.f32983g = (byte) (zzgnmVar.f32983g | 2);
        } else {
            zzgnmVar.f32980d = 0.02f;
            zzgnmVar.f32983g = (byte) (zzgnmVar.f32983g | 2);
        }
        if (map.containsKey("enifd")) {
            zzgnmVar.f32982f = (String) map.get("enifd");
        }
        try {
            com.google.android.gms.ads.internal.zzt.C.s.b(zzcirVar, zzgnmVar.a());
        } catch (NullPointerException e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("DefaultGmsgHandlers.ShowLMDOverlay", e2);
            com.google.android.gms.ads.internal.util.zze.k("Missing parameters for LMD Overlay show request");
        }
    }
}

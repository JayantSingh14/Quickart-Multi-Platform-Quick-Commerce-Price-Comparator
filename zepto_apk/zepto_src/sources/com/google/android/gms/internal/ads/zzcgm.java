package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzcgm implements zzbnn {
    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) throws NumberFormatException {
        zzcfk zzcfkVar = (zzcfk) obj;
        zzcjx zzcjxVarZzh = zzcfkVar.zzh();
        if (zzcjxVarZzh == null) {
            try {
                zzcjx zzcjxVar = new zzcjx(zzcfkVar, Float.parseFloat((String) map.get("duration")), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                zzcfkVar.t(zzcjxVar);
                zzcjxVarZzh = zzcjxVar;
            } catch (NullPointerException e2) {
                e = e2;
                Throwable th = e;
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Unable to parse videoMeta message.", th);
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("VideoMetaGmsgHandler.onGmsg", th);
                return;
            } catch (NumberFormatException e3) {
                e = e3;
                Throwable th2 = e;
                int i22 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Unable to parse videoMeta message.", th2);
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("VideoMetaGmsgHandler.onGmsg", th2);
                return;
            }
        }
        float f2 = Float.parseFloat((String) map.get("duration"));
        boolean zEquals = "1".equals(map.get("muted"));
        float f3 = Float.parseFloat((String) map.get("currentTime"));
        int i3 = Integer.parseInt((String) map.get("playbackState"));
        if (i3 < 0 || i3 > 3) {
            i3 = 0;
        }
        String str = (String) map.get("aspectRatio");
        float f4 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
        if (com.google.android.gms.ads.internal.util.client.zzo.j(3)) {
            StringBuilder sb = new StringBuilder(String.valueOf(f3).length() + 45 + String.valueOf(f2).length() + 13 + String.valueOf(zEquals).length() + 19 + String.valueOf(i3).length() + 17 + String.valueOf(str).length());
            sb.append("Video Meta GMSG: currentTime : ");
            sb.append(f3);
            sb.append(" , duration : ");
            sb.append(f2);
            sb.append(" , isMuted : ");
            sb.append(zEquals);
            sb.append(" , playbackState : ");
            sb.append(i3);
            sb.append(" , aspectRatio : ");
            sb.append(str);
            com.google.android.gms.ads.internal.util.client.zzo.a(sb.toString());
        }
        zzcjxVarZzh.Zb(f3, f2, f4, i3, zEquals);
    }
}

package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.UiElement;
import com.google.ads.interactivemedia.v3.impl.JavaScriptMessage;
import java.net.MalformedURLException;

/* loaded from: classes3.dex */
public final class zzen {
    private final zztx zza;

    public zzen() {
        zzty zztyVar = new zzty();
        zztyVar.zzb(UiElement.class, com.google.ads.interactivemedia.v3.impl.data.zzcw.GSON_TYPE_ADAPTER);
        zztyVar.zzb(CompanionAdSlot.class, new zzem(this));
        zztyVar.zzc(new zzoq());
        this.zza = zztyVar.zza();
    }

    public final JavaScriptMessage zza(String str) throws MalformedURLException {
        Uri uri = Uri.parse(str);
        String path = uri.getPath();
        if (path == null) {
            throw new MalformedURLException("URL must have message.");
        }
        String strSubstring = path.substring(1);
        if (uri.getQueryParameter("sid") != null) {
            return new JavaScriptMessage(JavaScriptMessage.MsgChannel.zza(strSubstring), JavaScriptMessage.MsgType.zza(uri.getQueryParameter("type")), uri.getQueryParameter("sid"), this.zza.zze(uri.getQueryParameter("data"), com.google.ads.interactivemedia.v3.impl.data.zzcf.class));
        }
        throw new MalformedURLException("Session id must be provided in message.");
    }

    public final JavaScriptMessage zzb(String str) {
        com.google.ads.interactivemedia.v3.impl.data.zzcg zzcgVar = (com.google.ads.interactivemedia.v3.impl.data.zzcg) this.zza.zze(str, com.google.ads.interactivemedia.v3.impl.data.zzcg.class);
        if (zzcgVar.sid != null) {
            return new JavaScriptMessage(JavaScriptMessage.MsgChannel.zza(zzcgVar.name), JavaScriptMessage.MsgType.zza(zzcgVar.type), zzcgVar.sid, this.zza.zze(zzcgVar.data, com.google.ads.interactivemedia.v3.impl.data.zzcf.class));
        }
        throw new NullPointerException("Session id must be provided in message.");
    }

    public final String zzc(JavaScriptMessage javaScriptMessage) {
        zzqh zzqhVar = new zzqh();
        zzqhVar.zza("type", javaScriptMessage.zzb());
        zzqhVar.zza("sid", javaScriptMessage.zzd());
        if (javaScriptMessage.zzc() != null) {
            zzqhVar.zza("data", javaScriptMessage.zzc());
        }
        zzqi zzqiVarZzc = zzqhVar.zzc();
        return "javascript:adsense.mobileads.afmanotify.receiveMessage('" + javaScriptMessage.zza() + "', " + this.zza.zzf(zzqiVarZzc) + ");";
    }
}

package com.google.ads.interactivemedia.v3.impl;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.CuePoint;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.StreamManager;
import com.google.ads.interactivemedia.v3.impl.JavaScriptMessage;
import com.google.ads.interactivemedia.v3.internal.zzqh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class zzbr extends zzac implements StreamManager {
    private final String zza;
    private List zzb;

    @VisibleForTesting
    public zzbr(String str, zzav zzavVar, StreamDisplayContainer streamDisplayContainer, zzbu zzbuVar, @Nullable zzb zzbVar, zzbm zzbmVar, zzak zzakVar, Context context, String str2, boolean z) {
        super(str, zzavVar, zzbuVar, streamDisplayContainer, zzbVar, zzbmVar, zzakVar, context, z);
        this.zzb = new ArrayList();
        this.zza = str2;
        zzbuVar.zzk();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzac, com.google.ads.interactivemedia.v3.api.BaseManager
    public final void destroy() {
        super.destroy();
        zzp(JavaScriptMessage.MsgType.contentComplete);
        zzn();
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamManager
    public final double getContentTimeForStreamTime(double d2) {
        double endTime = d2;
        for (CuePoint cuePoint : this.zzb) {
            if (cuePoint.getStartTime() > cuePoint.getEndTime()) {
                return 0.0d;
            }
            if (d2 >= cuePoint.getEndTime()) {
                endTime -= cuePoint.getEndTime() - cuePoint.getStartTime();
            } else if (d2 < cuePoint.getEndTime() && d2 > cuePoint.getStartTime()) {
                endTime -= d2 - cuePoint.getStartTime();
            }
        }
        return endTime;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamManager
    public final long getContentTimeMsForStreamTimeMs(long j2) {
        long endTimeMs = j2;
        for (CuePoint cuePoint : this.zzb) {
            if (cuePoint.getStartTimeMs() > cuePoint.getEndTimeMs()) {
                return 0L;
            }
            if (j2 >= cuePoint.getEndTimeMs()) {
                endTimeMs -= cuePoint.getEndTimeMs() - cuePoint.getStartTimeMs();
            } else if (j2 < cuePoint.getEndTimeMs() && j2 > cuePoint.getStartTimeMs()) {
                endTimeMs -= j2 - cuePoint.getStartTimeMs();
            }
        }
        return endTimeMs;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamManager
    public final List<CuePoint> getCuePoints() {
        return Collections.unmodifiableList(this.zzb);
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamManager
    public final CuePoint getPreviousCuePointForStreamTime(double d2) {
        CuePoint cuePoint = null;
        for (CuePoint cuePoint2 : this.zzb) {
            if (cuePoint2.getStartTime() < d2) {
                cuePoint = cuePoint2;
            }
        }
        return cuePoint;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamManager
    public final CuePoint getPreviousCuePointForStreamTimeMs(long j2) {
        CuePoint cuePoint = null;
        for (CuePoint cuePoint2 : this.zzb) {
            if (cuePoint2.getStartTimeMs() < j2) {
                cuePoint = cuePoint2;
            }
        }
        return cuePoint;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamManager
    public final String getStreamId() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamManager
    public final double getStreamTimeForContentTime(double d2) {
        double endTime = d2;
        double startTime = 0.0d;
        double endTime2 = 0.0d;
        for (CuePoint cuePoint : this.zzb) {
            if (cuePoint.getStartTime() > cuePoint.getEndTime()) {
                return 0.0d;
            }
            startTime += cuePoint.getStartTime() - endTime2;
            if (startTime > d2) {
                break;
            }
            endTime += cuePoint.getEndTime() - cuePoint.getStartTime();
            endTime2 = cuePoint.getEndTime();
        }
        return endTime;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamManager
    public final long getStreamTimeMsForContentTimeMs(long j2) {
        long endTimeMs = j2;
        long startTimeMs = 0;
        long endTimeMs2 = 0;
        for (CuePoint cuePoint : this.zzb) {
            if (cuePoint.getStartTimeMs() > cuePoint.getEndTimeMs()) {
                return 0L;
            }
            startTimeMs += cuePoint.getStartTimeMs() - endTimeMs2;
            if (startTimeMs > j2) {
                break;
            }
            endTimeMs += cuePoint.getEndTimeMs() - cuePoint.getStartTimeMs();
            endTimeMs2 = cuePoint.getEndTimeMs();
        }
        return endTimeMs;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public final boolean isCustomPlaybackUsed() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamManager
    public final void loadThirdPartyStream(String str, List<? extends Map<String, String>> list) {
        zzqh zzqhVar = new zzqh();
        zzqhVar.zza("streamUrl", str);
        zzqhVar.zza("subtitles", list);
        zzo(JavaScriptMessage.MsgChannel.adsManager, JavaScriptMessage.MsgType.loadStreamMetadata, zzqhVar.zzc());
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamManager
    public final void replaceAdTagParameters(Map<String, String> map) {
        if (map == null) {
            return;
        }
        HashMap map2 = new HashMap();
        map2.put("adTagParameters", map);
        zzo(JavaScriptMessage.MsgChannel.adsManager, JavaScriptMessage.MsgType.replaceAdTagParameters, map2);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzac, com.google.ads.interactivemedia.v3.impl.zzat
    public final void zzc(zzas zzasVar) {
        zzbu zzbuVar = (zzbu) zzd();
        AdEvent.AdEventType adEventType = AdEvent.AdEventType.ALL_ADS_COMPLETED;
        int iOrdinal = zzasVar.zza.ordinal();
        if (iOrdinal == 3) {
            zzbuVar.zzn();
        } else if (iOrdinal == 4) {
            this.zzb = zzasVar.zzd;
        } else if (iOrdinal == 14) {
            Log.i("IMASDK", "Seek time when ad is skipped: " + zzasVar.zzg);
            zzbuVar.zzl(Math.round(zzasVar.zzg * 1000.0d));
        } else if (iOrdinal != 15) {
            switch (iOrdinal) {
                case 23:
                    zzbuVar.zze();
                    break;
                case 24:
                    zzbuVar.zzb();
                    break;
                case 25:
                    zzbuVar.zzj();
                    break;
                case 26:
                    zzbuVar.zzi();
                    break;
            }
        } else {
            zzbuVar.zzm(zzasVar.zzb);
        }
        super.zzc(zzasVar);
    }
}

package com.google.ads.interactivemedia.v3.impl.data;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.internal.zzagh;
import com.google.ads.interactivemedia.v3.internal.zzagk;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: classes3.dex */
public final class zzcf {
    public double adBreakDuration;
    public String adBreakTime;
    public List<Float> adCuePoints;
    public zzc adData;
    public double adPeriodDuration;
    public zzd adPodInfo;
    public int adPosition;
    public long adTimeUpdateMs;
    public List<Long> adsDurationsMs;
    public long appSetIdTimeoutMs;
    public double bufferedTime;
    public Map<String, zzbk> companions;
    public zzcd consentSettingsConfig;
    public List<zzbl> cuepoints;
    public double currentTime;
    public boolean disableAppSetId;
    public double duration;
    public boolean enableGks;
    public boolean enableInstrumentation;
    public int errorCode;
    public String errorMessage;

    @Nullable
    public Integer espAdapterTimeoutMs;

    @Nullable
    public List<String> espAdapters;
    public String eventId;

    @Nullable
    public List<String> gksDaiNativeXhrApps;
    public List<String> gksFirstPartyAdServers;
    public int gksTimeoutMs;
    public List<zzbs> iconClickFallbackImages;
    public zzbu iconsView;
    public String innerError;
    public SortedSet<Float> internalCuePoints;
    public Set<String> jsConsentCheckRequiredParameters;
    public String ln;
    public zzce logData;

    /* renamed from: m, reason: collision with root package name */
    public String f20500m;
    public boolean monitorAppLifecycle;

    @Nullable
    public Integer msParameterTimeoutMs;
    public String n;
    public zzcj networkRequest;

    @Nullable
    public Integer platformSignalCollectorTimeoutMs;
    public String queryId;
    public zzcp resizeAndPositionVideo;
    public double seekTime;
    public zzct skipView;
    public String streamId;
    public String streamUrl;
    public List<HashMap<String, String>> subtitles;
    public int totalAds;
    public String url;
    public String vastEvent;
    public String videoUrl;

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        return zzagh.zzf(this, obj, false, null, false, new String[0]);
    }

    public int hashCode() {
        return zzagk.zza(this, new String[0]);
    }

    public String toString() throws IllegalAccessException, SecurityException, IllegalArgumentException {
        StringBuilder sb = new StringBuilder("JavaScriptMsgData[");
        for (Field field : zzcf.class.getFields()) {
            try {
                Object obj = field.get(this);
                sb.append(field.getName());
                sb.append(":");
                sb.append(obj);
                sb.append(",");
            } catch (IllegalAccessException e2) {
                Log.e("IMASDK", "IllegalAccessException occurred", e2);
            } catch (IllegalArgumentException e3) {
                Log.e("IMASDK", "IllegalArgumentException occurred", e3);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

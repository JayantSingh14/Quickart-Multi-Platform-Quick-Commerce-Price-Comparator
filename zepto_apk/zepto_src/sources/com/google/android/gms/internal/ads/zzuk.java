package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import androidx.annotation.RequiresApi;
import java.util.List;

@RequiresApi
/* loaded from: classes4.dex */
final class zzuk {
    public static int a(boolean z) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        List supportedPerformancePoints;
        try {
            zzt zztVar = new zzt();
            zztVar.e("video/avc");
            zzv zzvVar = new zzv(zztVar);
            if (zzvVar.f35691m != null) {
                zzus zzusVar = zzus.f35671a;
                List listB = zzvc.b(zzur.f35670b, zzvVar, z, false);
                for (int i2 = 0; i2 < ((zzguy) listB).f33234d; i2++) {
                    zzguy zzguyVar = (zzguy) listB;
                    if (((zzuj) zzguyVar.get(i2)).f35648d != null && (videoCapabilities = ((zzuj) zzguyVar.get(i2)).f35648d.getVideoCapabilities()) != null && (supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints()) != null && !supportedPerformancePoints.isEmpty()) {
                        androidx.media3.exoplayer.audio.a.i();
                        MediaCodecInfo.VideoCapabilities.PerformancePoint performancePointE = androidx.media3.exoplayer.audio.a.e();
                        for (int i3 = 0; i3 < supportedPerformancePoints.size(); i3++) {
                            if (androidx.media3.exoplayer.audio.a.g(supportedPerformancePoints.get(i3)).covers(performancePointE)) {
                                return 2;
                            }
                        }
                        return 1;
                    }
                }
            }
        } catch (zzuu unused) {
        }
        return 0;
    }
}

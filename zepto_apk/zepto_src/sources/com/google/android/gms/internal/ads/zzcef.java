package com.google.android.gms.internal.ads;

import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.os.Build;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.HashMap;

/* loaded from: classes4.dex */
final class zzcef implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaPlayer f26002a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzceo f26003b;

    public zzcef(zzceo zzceoVar, MediaPlayer mediaPlayer) {
        this.f26002a = mediaPlayer;
        this.f26003b = zzceoVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzcir zzcirVar;
        MediaPlayer mediaPlayer;
        MediaFormat format;
        zzceo zzceoVar = this.f26003b;
        zzceoVar.getClass();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.l2)).booleanValue() && (zzcirVar = zzceoVar.f26017c) != null && (mediaPlayer = this.f26002a) != null) {
            try {
                MediaPlayer.TrackInfo[] trackInfo = mediaPlayer.getTrackInfo();
                if (trackInfo != null) {
                    HashMap map = new HashMap();
                    for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
                        if (trackInfo2 != null) {
                            int trackType = trackInfo2.getTrackType();
                            if (trackType == 1) {
                                MediaFormat format2 = trackInfo2.getFormat();
                                if (format2 != null) {
                                    if (format2.containsKey("frame-rate")) {
                                        try {
                                            map.put("frameRate", String.valueOf(format2.getFloat("frame-rate")));
                                        } catch (ClassCastException unused) {
                                            map.put("frameRate", String.valueOf(format2.getInteger("frame-rate")));
                                        }
                                    }
                                    if (format2.containsKey("bitrate")) {
                                        Integer numValueOf = Integer.valueOf(format2.getInteger("bitrate"));
                                        zzceoVar.s = numValueOf;
                                        map.put("bitRate", String.valueOf(numValueOf));
                                    }
                                    if (format2.containsKey(Snapshot.WIDTH) && format2.containsKey(Snapshot.HEIGHT)) {
                                        int integer = format2.getInteger(Snapshot.WIDTH);
                                        int integer2 = format2.getInteger(Snapshot.HEIGHT);
                                        StringBuilder sb = new StringBuilder(androidx.fragment.app.e.a(integer, 1) + String.valueOf(integer2).length());
                                        sb.append(integer);
                                        sb.append("x");
                                        sb.append(integer2);
                                        map.put("resolution", sb.toString());
                                    }
                                    if (format2.containsKey("mime")) {
                                        map.put("videoMime", format2.getString("mime"));
                                    }
                                    if (Build.VERSION.SDK_INT >= 30 && format2.containsKey("codecs-string")) {
                                        map.put("videoCodec", format2.getString("codecs-string"));
                                    }
                                }
                            } else if (trackType == 2 && (format = trackInfo2.getFormat()) != null) {
                                if (format.containsKey("mime")) {
                                    map.put("audioMime", format.getString("mime"));
                                }
                                if (Build.VERSION.SDK_INT >= 30 && format.containsKey("codecs-string")) {
                                    map.put("audioCodec", format.getString("codecs-string"));
                                }
                            }
                        }
                    }
                    if (!map.isEmpty()) {
                        zzcirVar.g("onMetadataEvent", map);
                    }
                }
            } catch (RuntimeException e2) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdMediaPlayerView.reportMetadata", e2);
            }
        }
        zzcey zzceyVar = zzceoVar.q;
        if (zzceyVar != null) {
            zzceyVar.f();
        }
    }
}

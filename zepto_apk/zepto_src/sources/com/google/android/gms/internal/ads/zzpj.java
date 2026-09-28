package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.media3.exoplayer.analytics.s;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Executor;

@RequiresApi
/* loaded from: classes4.dex */
public final class zzpj implements zzmx, zzpk {

    /* renamed from: a, reason: collision with root package name */
    public final Context f35311a;

    /* renamed from: c, reason: collision with root package name */
    public final zzpc f35313c;

    /* renamed from: d, reason: collision with root package name */
    public final PlaybackSession f35314d;

    /* renamed from: j, reason: collision with root package name */
    public String f35320j;

    /* renamed from: k, reason: collision with root package name */
    public PlaybackMetrics.Builder f35321k;
    public zzau n;
    public zzpi o;
    public zzpi p;
    public zzpi q;
    public zzv r;
    public zzv s;
    public zzv t;
    public boolean u;
    public boolean v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f35312b = zzdh.a();

    /* renamed from: f, reason: collision with root package name */
    public final zzbe f35316f = new zzbe();

    /* renamed from: g, reason: collision with root package name */
    public final zzbd f35317g = new zzbd();

    /* renamed from: i, reason: collision with root package name */
    public final HashMap f35319i = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f35318h = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final long f35315e = SystemClock.elapsedRealtime();

    /* renamed from: l, reason: collision with root package name */
    public int f35322l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f35323m = 0;

    public zzpj(Context context, PlaybackSession playbackSession) {
        this.f35311a = context.getApplicationContext();
        this.f35314d = playbackSession;
        zzpc zzpcVar = new zzpc(0);
        this.f35313c = zzpcVar;
        zzpcVar.f35295d = this;
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x0211 A[PHI: r6
      0x0211: PHI (r6v49 int) = (r6v31 int), (r6v83 int) binds: [B:215:0x0307, B:137:0x020d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0214 A[PHI: r6
      0x0214: PHI (r6v48 int) = (r6v31 int), (r6v83 int) binds: [B:215:0x0307, B:137:0x020d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0217 A[PHI: r6
      0x0217: PHI (r6v47 int) = (r6v31 int), (r6v83 int) binds: [B:215:0x0307, B:137:0x020d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x021a A[PHI: r6
      0x021a: PHI (r6v46 int) = (r6v31 int), (r6v83 int) binds: [B:215:0x0307, B:137:0x020d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02af  */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.google.android.gms.internal.ads.zzpi, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r9v4 */
    @Override // com.google.android.gms.internal.ads.zzmx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.google.android.gms.internal.ads.zzms r25, com.google.android.gms.internal.ads.zzmw r26) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpj.a(com.google.android.gms.internal.ads.zzms, com.google.android.gms.internal.ads.zzmw):void");
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void b(zzbv zzbvVar) {
        zzpi zzpiVar = this.o;
        if (zzpiVar != null) {
            zzv zzvVar = zzpiVar.f35309a;
            if (zzvVar.u == -1) {
                zzt zztVar = new zzt(zzvVar);
                zztVar.s = zzbvVar.f25578a;
                zztVar.t = zzbvVar.f25579b;
                this.o = new zzpi(new zzv(zztVar), zzpiVar.f35310b);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void d(zzik zzikVar) {
        this.w += zzikVar.f34917g;
        this.x += zzikVar.f34915e;
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void e(zzmv zzmvVar, zzwc zzwcVar) {
        zzwg zzwgVar = zzmvVar.f35235d;
        if (zzwgVar == null) {
            return;
        }
        zzv zzvVar = zzwcVar.f35755b;
        zzvVar.getClass();
        zzpi zzpiVar = new zzpi(zzvVar, this.f35313c.a(zzmvVar.f35233b, zzwgVar));
        int i2 = zzwcVar.f35754a;
        if (i2 != 0) {
            if (i2 == 1) {
                this.p = zzpiVar;
                return;
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                this.q = zzpiVar;
                return;
            }
        }
        this.o = zzpiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void f(zzmv zzmvVar, int i2, long j2) {
        zzwg zzwgVar = zzmvVar.f35235d;
        if (zzwgVar != null) {
            String strA = this.f35313c.a(zzmvVar.f35233b, zzwgVar);
            HashMap map = this.f35319i;
            Long l2 = (Long) map.get(strA);
            HashMap map2 = this.f35318h;
            Long l3 = (Long) map2.get(strA);
            map.put(strA, Long.valueOf((l2 == null ? 0L : l2.longValue()) + j2));
            map2.put(strA, Long.valueOf((l3 != null ? l3.longValue() : 0L) + i2));
        }
    }

    public final void g(int i2, long j2, zzv zzvVar, int i3) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = s.j(i2).setTimeSinceCreatedMillis(j2 - this.f35315e);
        if (zzvVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(i3 != 1 ? 1 : 2);
            String str = zzvVar.f35690l;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = zzvVar.f35691m;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = zzvVar.f35688j;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i4 = zzvVar.f35687i;
            if (i4 != -1) {
                timeSinceCreatedMillis.setBitrate(i4);
            }
            int i5 = zzvVar.t;
            if (i5 != -1) {
                timeSinceCreatedMillis.setWidth(i5);
            }
            int i6 = zzvVar.u;
            if (i6 != -1) {
                timeSinceCreatedMillis.setHeight(i6);
            }
            int i7 = zzvVar.E;
            if (i7 != -1) {
                timeSinceCreatedMillis.setChannelCount(i7);
            }
            int i8 = zzvVar.F;
            if (i8 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i8);
            }
            String str4 = zzvVar.f35682d;
            if (str4 != null) {
                String str5 = zzfj.f31254a;
                String[] strArrSplit = str4.split("-", -1);
                Pair pairCreate = Pair.create(strArrSplit[0], strArrSplit.length >= 2 ? strArrSplit[1] : null);
                timeSinceCreatedMillis.setLanguage((String) pairCreate.first);
                Object obj = pairCreate.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f2 = zzvVar.x;
            if (f2 != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f2);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.z = true;
        final TrackChangeEvent trackChangeEventBuild = timeSinceCreatedMillis.build();
        this.f35312b.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpf
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f35303a.f35314d.reportTrackChangeEvent(trackChangeEventBuild);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void i(int i2) {
        if (i2 == 1) {
            this.u = true;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(com.google.android.gms.internal.ads.zzbf r10, com.google.android.gms.internal.ads.zzwg r11) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpj.l(com.google.android.gms.internal.ads.zzbf, com.google.android.gms.internal.ads.zzwg):void");
    }

    public final void m() {
        PlaybackMetrics.Builder builder = this.f35321k;
        if (builder != null && this.z) {
            builder.setAudioUnderrunCount(this.y);
            this.f35321k.setVideoFramesDropped(this.w);
            this.f35321k.setVideoFramesPlayed(this.x);
            Long l2 = (Long) this.f35318h.get(this.f35320j);
            this.f35321k.setNetworkTransferDurationMillis(l2 == null ? 0L : l2.longValue());
            Long l3 = (Long) this.f35319i.get(this.f35320j);
            this.f35321k.setNetworkBytesRead(l3 == null ? 0L : l3.longValue());
            this.f35321k.setStreamSource((l3 == null || l3.longValue() <= 0) ? 0 : 1);
            final PlaybackMetrics playbackMetricsBuild = this.f35321k.build();
            this.f35312b.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpg
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f35305a.f35314d.reportPlaybackMetrics(playbackMetricsBuild);
                }
            });
        }
        this.f35321k = null;
        this.f35320j = null;
        this.y = 0;
        this.w = 0;
        this.x = 0;
        this.r = null;
        this.s = null;
        this.t = null;
        this.z = false;
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void n(zzau zzauVar) {
        this.n = zzauVar;
    }

    public final void p(zzmv zzmvVar, String str) {
        zzwg zzwgVar = zzmvVar.f35235d;
        if ((zzwgVar == null || !zzwgVar.b()) && str.equals(this.f35320j)) {
            m();
        }
        this.f35318h.remove(str);
        this.f35319i.remove(str);
    }

    public final boolean q(zzpi zzpiVar) {
        String str;
        if (zzpiVar == null) {
            return false;
        }
        zzpc zzpcVar = this.f35313c;
        String str2 = zzpiVar.f35310b;
        synchronized (zzpcVar) {
            str = zzpcVar.f35297f;
        }
        return str2.equals(str);
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void h(IOException iOException) {
    }
}

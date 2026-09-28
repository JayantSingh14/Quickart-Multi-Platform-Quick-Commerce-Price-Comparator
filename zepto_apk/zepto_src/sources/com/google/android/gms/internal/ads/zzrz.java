package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioRouting;
import android.media.AudioTrack;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
final class zzrz implements zzpz {
    public static final Object o = new Object();
    public static ScheduledExecutorService p;
    public static int q;

    /* renamed from: a, reason: collision with root package name */
    public final AudioTrack f35465a;

    /* renamed from: b, reason: collision with root package name */
    public final zzqi f35466b;

    /* renamed from: c, reason: collision with root package name */
    public zzrq f35467c;

    /* renamed from: d, reason: collision with root package name */
    public final zzsg f35468d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f35469e;

    /* renamed from: f, reason: collision with root package name */
    public final int f35470f;

    /* renamed from: g, reason: collision with root package name */
    public final zzry f35471g;

    /* renamed from: h, reason: collision with root package name */
    public final zzed f35472h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f35473i;

    /* renamed from: j, reason: collision with root package name */
    public long f35474j;

    /* renamed from: k, reason: collision with root package name */
    public long f35475k;

    /* renamed from: l, reason: collision with root package name */
    public int f35476l;

    /* renamed from: m, reason: collision with root package name */
    public int f35477m;
    public final zzsd n;

    public zzrz(AudioTrack audioTrack, zzqi zzqiVar, zzsd zzsdVar, zzfc zzfcVar) {
        this.f35465a = audioTrack;
        this.f35466b = zzqiVar;
        this.n = zzsdVar;
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        zzed zzedVar = new zzed(looperMyLooper, zzfcVar);
        this.f35472h = zzedVar;
        zzedVar.f29105i = false;
        boolean zA = zzfj.a(zzqiVar.f35392a);
        this.f35469e = zA;
        if (zA) {
            this.f35470f = zzfj.d(zzqiVar.f35392a) * Integer.bitCount(zzqiVar.f35394c);
        } else {
            this.f35470f = -1;
        }
        this.f35468d = new zzsg(new zzrs(this), zzfcVar, audioTrack, zzqiVar.f35392a, this.f35470f, zzqiVar.f35395d);
        if (zzsdVar != null) {
            this.f35467c = new zzrq(audioTrack, zzsdVar);
        }
        this.f35471g = zzg() ? new zzry(this) : null;
    }

    @Override // com.google.android.gms.internal.ads.zzpz
    public final boolean a(int i2, ByteBuffer byteBuffer) throws zzpy {
        zzsd zzsdVar;
        zzse zzseVar;
        zzpu zzpuVar;
        boolean z = this.f35469e;
        if (!z && this.f35476l == 0) {
            this.f35476l = zzss.c(this.f35466b.f35392a, byteBuffer);
        }
        e();
        AudioTrack audioTrack = this.f35465a;
        int underrunCount = audioTrack.getUnderrunCount();
        int i3 = this.f35477m;
        this.f35477m = underrunCount;
        if (underrunCount > i3) {
            zzrj zzrjVar = zzrj.f35440a;
            zzed zzedVar = this.f35472h;
            zzedVar.c(-1, zzrjVar);
            zzedVar.d();
        }
        int iRemaining = byteBuffer.remaining();
        int iWrite = audioTrack.write(byteBuffer, byteBuffer.remaining(), 1);
        if (iWrite >= 0) {
            z = iWrite == iRemaining;
            if (z) {
                this.f35474j += iWrite;
                return z;
            }
            if (z) {
                this.f35475k = (this.f35476l * i2) + this.f35475k;
            }
            return z;
        }
        if (iWrite != -6 && iWrite != -32) {
            z = false;
        }
        if (z && (zzsdVar = this.n) != null && (zzpuVar = (zzseVar = zzsdVar.f35484a).f35490f) != null) {
            zzpp zzppVar = zzpp.f35332c;
            zzseVar.f35489e = zzppVar;
            zzpuVar.a(zzppVar);
        }
        throw new zzpy(iWrite, z);
    }

    @Override // com.google.android.gms.internal.ads.zzpz
    public final void b(AudioDeviceInfo audioDeviceInfo) {
        this.f35465a.setPreferredDevice(audioDeviceInfo);
    }

    @Override // com.google.android.gms.internal.ads.zzpz
    public final void c(zzpn zzpnVar) {
        LogSessionId logSessionId;
        if (Build.VERSION.SDK_INT < 31) {
            return;
        }
        synchronized (zzpnVar) {
            zzpm zzpmVar = zzpnVar.f35327b;
            if (zzpmVar == null) {
                throw null;
            }
            logSessionId = zzpmVar.f35324a;
        }
        LogSessionId unused = LogSessionId.LOG_SESSION_ID_NONE;
        if (logSessionId.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            return;
        }
        this.f35465a.setLogSessionId(logSessionId);
    }

    @Override // com.google.android.gms.internal.ads.zzpz
    public final void d(zzpx zzpxVar) {
        this.f35472h.a(zzpxVar);
    }

    public final long e() {
        if (!this.f35469e) {
            return this.f35475k;
        }
        long j2 = this.f35474j;
        String str = zzfj.f31254a;
        return ((j2 + r2) - 1) / this.f35470f;
    }

    @Override // com.google.android.gms.internal.ads.zzpz
    public final void o0(float f2) {
        this.f35465a.setVolume(f2);
    }

    @Override // com.google.android.gms.internal.ads.zzpz
    public final void zza() throws IllegalStateException {
        zzsg zzsgVar = this.f35468d;
        if (zzsgVar.u != -9223372036854775807L) {
            zzsgVar.f35495b.getClass();
            zzsgVar.u = zzfj.s(SystemClock.elapsedRealtime());
        }
        zzsgVar.f35503j = zzfj.t(zzsgVar.f35498e, zzsgVar.c());
        zzsgVar.f35501h.a(0);
        if (!this.f35473i || zzg()) {
            this.f35465a.play();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpz
    public final void zzb() throws IllegalStateException {
        zzsg zzsgVar = this.f35468d;
        zzsgVar.f35504k = 0L;
        zzsgVar.t = 0;
        zzsgVar.s = 0;
        zzsgVar.f35505l = 0L;
        zzsgVar.y = -9223372036854775807L;
        zzsgVar.z = -9223372036854775807L;
        if (zzsgVar.u == -9223372036854775807L) {
            zzsgVar.f35501h.a(0);
        }
        zzsgVar.w = zzsgVar.c();
        if (!this.f35473i || zzg()) {
            this.f35465a.pause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpz
    public final void zzd() throws IllegalStateException {
        if (this.f35473i) {
            return;
        }
        this.f35473i = true;
        long jE = e();
        zzsg zzsgVar = this.f35468d;
        zzsgVar.w = zzsgVar.c();
        zzsgVar.f35495b.getClass();
        zzsgVar.u = zzfj.s(SystemClock.elapsedRealtime());
        zzsgVar.x = jE;
        this.f35465a.stop();
    }

    @Override // com.google.android.gms.internal.ads.zzpz
    public final void zze() throws IllegalStateException {
        if (this.f35468d.f35497d.getPlayState() == 3) {
            this.f35465a.pause();
        }
        if (Build.VERSION.SDK_INT >= 29 && zzg()) {
            zzry zzryVar = this.f35471g;
            zzryVar.getClass();
            zzryVar.f35464c.f35465a.unregisterStreamEventCallback(zzryVar.f35463b);
            zzryVar.f35462a.removeCallbacksAndMessages(null);
        }
        zzrq zzrqVar = this.f35467c;
        if (zzrqVar != null) {
            AudioRouting.OnRoutingChangedListener onRoutingChangedListener = zzrqVar.f35453c;
            onRoutingChangedListener.getClass();
            zzrqVar.f35451a.removeOnRoutingChangedListener(onRoutingChangedListener);
            zzrqVar.f35453c = null;
            this.f35467c = null;
        }
        final AudioTrack audioTrack = this.f35465a;
        final zzed zzedVar = this.f35472h;
        final Handler handlerN = zzfj.n();
        synchronized (o) {
            try {
                if (p == null) {
                    p = Executors.newSingleThreadScheduledExecutor(new zzfh());
                }
                q++;
                p.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrm
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        AudioTrack audioTrack2 = audioTrack;
                        Handler handler = handlerN;
                        final zzed zzedVar2 = zzedVar;
                        try {
                            audioTrack2.flush();
                            audioTrack2.release();
                            if (handler.getLooper().getThread().isAlive()) {
                                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrk
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        zzri zzriVar = zzri.f35439a;
                                        zzed zzedVar3 = zzedVar2;
                                        zzedVar3.c(-1, zzriVar);
                                        zzedVar3.d();
                                    }
                                });
                            }
                            synchronized (zzrz.o) {
                                try {
                                    int i2 = zzrz.q - 1;
                                    zzrz.q = i2;
                                    if (i2 == 0) {
                                        ScheduledExecutorService scheduledExecutorService = zzrz.p;
                                        if (scheduledExecutorService == null) {
                                            throw null;
                                        }
                                        scheduledExecutorService.shutdown();
                                        zzrz.p = null;
                                    }
                                } finally {
                                }
                            }
                        } catch (Throwable th) {
                            if (handler.getLooper().getThread().isAlive()) {
                                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrl
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        zzri zzriVar = zzri.f35439a;
                                        zzed zzedVar3 = zzedVar2;
                                        zzedVar3.c(-1, zzriVar);
                                        zzedVar3.d();
                                    }
                                });
                            }
                            synchronized (zzrz.o) {
                                try {
                                    int i3 = zzrz.q - 1;
                                    zzrz.q = i3;
                                    if (i3 == 0) {
                                        ScheduledExecutorService scheduledExecutorService2 = zzrz.p;
                                        if (scheduledExecutorService2 == null) {
                                            throw null;
                                        }
                                        scheduledExecutorService2.shutdown();
                                        zzrz.p = null;
                                    }
                                    throw th;
                                } finally {
                                }
                            }
                        }
                    }
                }, 20L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpz
    public final boolean zzg() {
        return Build.VERSION.SDK_INT >= 29 && this.f35465a.isOffloadedPlayback();
    }

    @Override // com.google.android.gms.internal.ads.zzpz
    public final int zzh() {
        return this.f35465a.getAudioSessionId();
    }

    @Override // com.google.android.gms.internal.ads.zzpz
    public final int zzi() {
        return this.f35465a.getSampleRate();
    }

    @Override // com.google.android.gms.internal.ads.zzpz
    public final long zzj() {
        return this.f35465a.getBufferSizeInFrames();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0345  */
    @Override // com.google.android.gms.internal.ads.zzpz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zzk() {
        /*
            Method dump skipped, instructions count: 969
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrz.zzk():long");
    }

    @Override // com.google.android.gms.internal.ads.zzpz
    public final boolean zzl() {
        long jE = e();
        zzsg zzsgVar = this.f35468d;
        if (zzsgVar.v == -9223372036854775807L || jE <= 0) {
            return false;
        }
        zzsgVar.f35495b.getClass();
        return SystemClock.elapsedRealtime() - zzsgVar.v >= 200;
    }
}

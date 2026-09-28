package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* loaded from: classes4.dex */
public final class zzse implements zzqj {

    /* renamed from: a, reason: collision with root package name */
    public final Context f35485a;

    /* renamed from: b, reason: collision with root package name */
    public final zzsd f35486b;

    /* renamed from: c, reason: collision with root package name */
    public zzed f35487c;

    /* renamed from: d, reason: collision with root package name */
    public zzfc f35488d;

    /* renamed from: e, reason: collision with root package name */
    public zzpp f35489e;

    /* renamed from: f, reason: collision with root package name */
    public zzpu f35490f;

    /* renamed from: g, reason: collision with root package name */
    public Looper f35491g;

    /* renamed from: h, reason: collision with root package name */
    public Context f35492h;

    /* renamed from: i, reason: collision with root package name */
    public final zzsi f35493i;

    public /* synthetic */ zzse(zzsc zzscVar) {
        Context context = zzscVar.f35481a;
        this.f35485a = context;
        zzsi zzsiVar = zzscVar.f35483c;
        zzsiVar.getClass();
        this.f35493i = zzsiVar;
        this.f35489e = zzscVar.f35482b;
        this.f35486b = context == null ? null : new zzsd(this);
        this.f35488d = zzdn.f27991a;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzqe a(com.google.android.gms.internal.ads.zzqc r12) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzse.a(com.google.android.gms.internal.ads.zzqc):com.google.android.gms.internal.ads.zzqe");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzqi b(com.google.android.gms.internal.ads.zzqc r20) throws com.google.android.gms.internal.ads.zzqa {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzse.b(com.google.android.gms.internal.ads.zzqc):com.google.android.gms.internal.ads.zzqi");
    }

    public final zzpz c(zzqi zzqiVar) throws UnsupportedOperationException, zzqf, IllegalArgumentException {
        Context context;
        Context context2;
        try {
            int i2 = zzqiVar.f35397f;
            int i3 = zzqiVar.f35398g;
            if (i3 == -1 || (context2 = this.f35485a) == null || Build.VERSION.SDK_INT < 34) {
                context = null;
            } else {
                Context context3 = this.f35492h;
                if (context3 == null || context3.getDeviceId() != i3) {
                    this.f35492h = context2.createDeviceContext(i3);
                }
                context = this.f35492h;
                i2 = 0;
            }
            AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(zzqiVar.f35396e.a()).setAudioFormat(new AudioFormat.Builder().setSampleRate(zzqiVar.f35393b).setChannelMask(zzqiVar.f35394c).setEncoding(zzqiVar.f35392a).build()).setTransferMode(1).setBufferSizeInBytes(zzqiVar.f35395d).setSessionId(i2);
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 29) {
                sessionId.setOffloadedPlayback(false);
            }
            if (i4 >= 34 && context != null) {
                sessionId.setContext(context);
            }
            AudioTrack audioTrackBuild = sessionId.build();
            if (audioTrackBuild.getState() == 1) {
                return new zzrz(audioTrackBuild, zzqiVar, this.f35486b, this.f35488d);
            }
            try {
                audioTrackBuild.release();
            } catch (Exception unused) {
            }
            throw new zzqf(null);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw new zzqf(e);
        } catch (UnsupportedOperationException e3) {
            e = e3;
            throw new zzqf(e);
        }
    }

    public final void d(zzqc zzqcVar) {
        Context context;
        zzpp zzppVarB;
        e();
        zzpu zzpuVar = this.f35490f;
        AudioDeviceInfo audioDeviceInfo = zzqcVar.f35373c;
        zzd zzdVar = zzqcVar.f35372b;
        if (zzpuVar == null && (context = this.f35485a) != null) {
            zzpu zzpuVar2 = new zzpu(context, new zzsb(this), zzdVar, audioDeviceInfo);
            this.f35490f = zzpuVar2;
            if (zzpuVar2.f35351j) {
                zzppVarB = zzpuVar2.f35348g;
                zzppVarB.getClass();
            } else {
                zzpuVar2.f35351j = true;
                zzpr zzprVar = zzpuVar2.f35347f;
                if (zzprVar != null) {
                    zzprVar.f35338a.registerContentObserver(zzprVar.f35339b, false, zzprVar);
                }
                Handler handler = zzpuVar2.f35344c;
                Context context2 = zzpuVar2.f35342a;
                zzcj.a(context2).registerAudioDeviceCallback(zzpuVar2.f35345d, handler);
                zzppVarB = zzpp.b(context2, context2.registerReceiver(zzpuVar2.f35346e, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, handler), zzpuVar2.f35350i, zzpuVar2.f35349h);
                zzpuVar2.f35348g = zzppVarB;
            }
            this.f35489e = zzppVarB;
        } else if (zzpuVar != null) {
            if (audioDeviceInfo != null && !audioDeviceInfo.equals(zzpuVar.f35349h)) {
                zzpuVar.f35349h = audioDeviceInfo;
                zzpuVar.a(zzpp.a(zzpuVar.f35342a, zzpuVar.f35350i, audioDeviceInfo));
            }
            zzpu zzpuVar3 = this.f35490f;
            zzpuVar3.f35350i = zzdVar;
            zzpuVar3.a(zzpp.a(zzpuVar3.f35342a, zzdVar, zzpuVar3.f35349h));
        }
        this.f35489e.getClass();
    }

    public final void e() {
        if (this.f35485a == null) {
            return;
        }
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.f35491g;
        boolean z = true;
        if (looper != null && looper != looperMyLooper) {
            z = false;
        }
        String name = looper == null ? "null" : looper.getThread().getName();
        String name2 = looperMyLooper != null ? looperMyLooper.getThread().getName() : "null";
        if (!z) {
            throw new IllegalStateException(zzgqr.b("AudioTrackAudioOutputProvider accessed on multiple threads: %s and %s", name, name2));
        }
        this.f35491g = looperMyLooper;
    }
}

package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioRouting;
import android.media.AudioTrack;
import android.os.Handler;
import androidx.annotation.RequiresApi;

@RequiresApi
/* loaded from: classes4.dex */
final class zzrq {

    /* renamed from: a, reason: collision with root package name */
    public final AudioTrack f35451a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f35452b;

    /* renamed from: c, reason: collision with root package name */
    public AudioRouting.OnRoutingChangedListener f35453c;

    /* renamed from: d, reason: collision with root package name */
    public final zzsd f35454d;

    public /* synthetic */ zzrq(AudioTrack audioTrack, zzsd zzsdVar) {
        this.f35451a = audioTrack;
        this.f35454d = zzsdVar;
        Handler handlerN = zzfj.n();
        this.f35452b = handlerN;
        AudioRouting.OnRoutingChangedListener onRoutingChangedListener = new AudioRouting.OnRoutingChangedListener() { // from class: com.google.android.gms.internal.ads.zzrp
            @Override // android.media.AudioRouting.OnRoutingChangedListener
            public final /* synthetic */ void onRoutingChanged(final AudioRouting audioRouting) {
                final zzrq zzrqVar = this.f35450a;
                if (zzrqVar.f35453c == null) {
                    return;
                }
                zzdh.a().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrn
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        final zzrq zzrqVar2 = zzrqVar;
                        zzrqVar2.getClass();
                        final AudioDeviceInfo routedDevice = audioRouting.getRoutedDevice();
                        if (routedDevice != null) {
                            zzrqVar2.f35452b.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzro
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzpu zzpuVar;
                                    zzrq zzrqVar3 = zzrqVar2;
                                    if (zzrqVar3.f35453c == null || (zzpuVar = zzrqVar3.f35454d.f35484a.f35490f) == null) {
                                        return;
                                    }
                                    AudioDeviceInfo audioDeviceInfo = routedDevice;
                                    if (audioDeviceInfo.equals(zzpuVar.f35349h)) {
                                        return;
                                    }
                                    zzpuVar.f35349h = audioDeviceInfo;
                                    zzpuVar.a(zzpp.a(zzpuVar.f35342a, zzpuVar.f35350i, audioDeviceInfo));
                                }
                            });
                        }
                    }
                });
            }
        };
        this.f35453c = onRoutingChangedListener;
        audioTrack.addOnRoutingChangedListener(onRoutingChangedListener, handlerN);
    }
}

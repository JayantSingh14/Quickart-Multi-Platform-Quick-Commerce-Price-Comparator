package com.google.android.gms.internal.ads;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzpq extends AudioDeviceCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzpu f35337a;

    public /* synthetic */ zzpq(zzpu zzpuVar) {
        Objects.requireNonNull(zzpuVar);
        this.f35337a = zzpuVar;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzpu zzpuVar = this.f35337a;
        zzpuVar.a(zzpp.a(zzpuVar.f35342a, zzpuVar.f35350i, zzpuVar.f35349h));
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzpu zzpuVar;
        String str = zzfj.f31254a;
        int length = audioDeviceInfoArr.length;
        int i2 = 0;
        while (true) {
            zzpuVar = this.f35337a;
            if (i2 >= length) {
                break;
            }
            if (Objects.equals(audioDeviceInfoArr[i2], zzpuVar.f35349h)) {
                zzpuVar.f35349h = null;
                break;
            }
            i2++;
        }
        zzpuVar.a(zzpp.a(zzpuVar.f35342a, zzpuVar.f35350i, zzpuVar.f35349h));
    }
}

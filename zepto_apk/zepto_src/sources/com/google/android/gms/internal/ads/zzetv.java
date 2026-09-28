package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzetv implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30319a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f30320b;

    public zzetv(Context context, zzgyw zzgywVar) {
        this.f30319a = zzgywVar;
        this.f30320b = context;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30319a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzetu
            @Override // java.util.concurrent.Callable
            public final Object call() {
                boolean z;
                int iF;
                int streamMaxVolume;
                AudioManager audioManager = (AudioManager) this.f30318a.f30320b.getSystemService("audio");
                com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
                float fA = zztVar.f21685i.a();
                com.google.android.gms.ads.internal.util.zzaa zzaaVar = zztVar.f21685i;
                synchronized (zzaaVar) {
                    z = zzaaVar.f21456a;
                }
                if (audioManager == null) {
                    return new zzetw(-1, false, false, -1, -1, -1, -1, -1, fA, z, true);
                }
                int mode = audioManager.getMode();
                boolean zIsMusicActive = audioManager.isMusicActive();
                boolean zIsSpeakerphoneOn = audioManager.isSpeakerphoneOn();
                int streamVolume = audioManager.getStreamVolume(3);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ec)).booleanValue()) {
                    iF = zztVar.f21682f.f(audioManager);
                    streamMaxVolume = audioManager.getStreamMaxVolume(3);
                } else {
                    iF = -1;
                    streamMaxVolume = -1;
                }
                return new zzetw(mode, zIsMusicActive, zIsSpeakerphoneOn, streamVolume, iF, streamMaxVolume, audioManager.getRingerMode(), audioManager.getStreamVolume(2), fA, z, false);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 13;
    }
}

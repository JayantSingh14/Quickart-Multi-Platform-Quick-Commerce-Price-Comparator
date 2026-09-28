package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzch {

    /* renamed from: a, reason: collision with root package name */
    public final AudioManager.OnAudioFocusChangeListener f26219a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f26220b;

    /* renamed from: c, reason: collision with root package name */
    public final zzd f26221c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f26222d;

    public zzch(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler, zzd zzdVar) {
        this.f26220b = handler;
        this.f26221c = zzdVar;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            this.f26219a = new zzcg(onAudioFocusChangeListener, handler);
        } else {
            this.f26219a = onAudioFocusChangeListener;
        }
        this.f26222d = i2 >= 26 ? e.c().setAudioAttributes(zzdVar.a()).setWillPauseWhenDucked(false).setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler).build() : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzch)) {
            return false;
        }
        zzch zzchVar = (zzch) obj;
        zzchVar.getClass();
        return Objects.equals(this.f26219a, zzchVar.f26219a) && Objects.equals(this.f26220b, zzchVar.f26220b) && Objects.equals(this.f26221c, zzchVar.f26221c);
    }

    public final int hashCode() {
        return Objects.hash(1, this.f26219a, this.f26220b, this.f26221c, Boolean.FALSE);
    }
}

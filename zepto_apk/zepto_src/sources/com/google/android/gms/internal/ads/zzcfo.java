package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;

/* loaded from: classes4.dex */
public final class zzcfo implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final AudioManager f26113a;

    /* renamed from: b, reason: collision with root package name */
    public final zzceq f26114b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f26115c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f26116d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f26117e;

    /* renamed from: f, reason: collision with root package name */
    public float f26118f = 1.0f;

    public zzcfo(Context context, zzceq zzceqVar) {
        this.f26113a = (AudioManager) context.getSystemService("audio");
        this.f26114b = zzceqVar;
    }

    public final void a() {
        boolean z = this.f26116d;
        zzceq zzceqVar = this.f26114b;
        AudioManager audioManager = this.f26113a;
        if (!z || this.f26117e || this.f26118f <= 0.0f) {
            if (this.f26115c) {
                if (audioManager != null) {
                    this.f26115c = audioManager.abandonAudioFocus(this) == 0;
                }
                zzceqVar.zzq();
                return;
            }
            return;
        }
        if (this.f26115c) {
            return;
        }
        if (audioManager != null) {
            this.f26115c = audioManager.requestAudioFocus(this, 3, 2) == 1;
        }
        zzceqVar.zzq();
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i2) {
        this.f26115c = i2 > 0;
        this.f26114b.zzq();
    }
}

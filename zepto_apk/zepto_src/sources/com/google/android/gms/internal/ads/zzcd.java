package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzcd {

    /* renamed from: a, reason: collision with root package name */
    public final zzgqs f25923a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f25924b;

    /* renamed from: c, reason: collision with root package name */
    public zzcc f25925c;

    /* renamed from: d, reason: collision with root package name */
    public zzd f25926d;

    /* renamed from: f, reason: collision with root package name */
    public int f25928f;

    /* renamed from: h, reason: collision with root package name */
    public zzch f25930h;

    /* renamed from: g, reason: collision with root package name */
    public float f25929g = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    public int f25927e = 0;

    public zzcd(final Context context, Looper looper, zzcc zzccVar) {
        this.f25923a = zzgqw.a(new zzgqs() { // from class: com.google.android.gms.internal.ads.zzcb
            @Override // com.google.android.gms.internal.ads.zzgqs
            public final /* synthetic */ Object zza() {
                return zzcj.a(context);
            }
        });
        this.f25925c = zzccVar;
        this.f25924b = new Handler(looper);
    }

    public final void a(zzd zzdVar) {
        if (Objects.equals(this.f25926d, zzdVar)) {
            return;
        }
        this.f25926d = zzdVar;
        this.f25928f = zzdVar == null ? 0 : 1;
    }

    public final int b(int i2, boolean z) {
        int iRequestAudioFocus;
        if (i2 == 1 || this.f25928f != 1) {
            d();
            e(0);
            return 1;
        }
        if (!z) {
            int i3 = this.f25927e;
            if (i3 == 1) {
                return -1;
            }
            if (i3 == 3) {
                return 0;
            }
        } else if (this.f25927e != 2) {
            if (this.f25930h == null) {
                zzce zzceVar = new zzce();
                zzceVar.f25996a = zzd.f27533b;
                zzd zzdVar = this.f25926d;
                zzdVar.getClass();
                zzceVar.f25996a = zzdVar;
                AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.google.android.gms.internal.ads.zzca
                    @Override // android.media.AudioManager.OnAudioFocusChangeListener
                    public final void onAudioFocusChange(int i4) {
                        zzcd zzcdVar = this.f25786a;
                        zzcdVar.getClass();
                        if (i4 == -3 || i4 == -2) {
                            if (i4 != -2) {
                                zzcdVar.e(4);
                                return;
                            }
                            zzcc zzccVar = zzcdVar.f25925c;
                            if (zzccVar != null) {
                                ((zzfd) ((zzlc) zzccVar).f35075h.b(33, 0, 0)).a();
                            }
                            zzcdVar.e(3);
                            return;
                        }
                        if (i4 == -1) {
                            zzcc zzccVar2 = zzcdVar.f25925c;
                            if (zzccVar2 != null) {
                                ((zzfd) ((zzlc) zzccVar2).f35075h.b(33, -1, 0)).a();
                            }
                            zzcdVar.d();
                            zzcdVar.e(1);
                            return;
                        }
                        if (i4 != 1) {
                            b.d(new StringBuilder(String.valueOf(i4).length() + 27), "Unknown focus change type: ", i4, "AudioFocusManager");
                            return;
                        }
                        zzcdVar.e(2);
                        zzcc zzccVar3 = zzcdVar.f25925c;
                        if (zzccVar3 != null) {
                            ((zzfd) ((zzlc) zzccVar3).f35075h.b(33, 1, 0)).a();
                        }
                    }
                };
                Handler handler = this.f25924b;
                handler.getClass();
                this.f25930h = new zzch(onAudioFocusChangeListener, handler, zzceVar.f25996a);
            }
            AudioManager audioManager = (AudioManager) this.f25923a.zza();
            zzch zzchVar = this.f25930h;
            if (Build.VERSION.SDK_INT >= 26) {
                Object obj = zzchVar.f26222d;
                obj.getClass();
                iRequestAudioFocus = audioManager.requestAudioFocus(e.f(obj));
            } else {
                iRequestAudioFocus = audioManager.requestAudioFocus(zzchVar.f26219a, 3, 1);
            }
            if (iRequestAudioFocus == 1) {
                e(2);
                return 1;
            }
            e(1);
            return -1;
        }
        return 1;
    }

    public final void c() {
        this.f25925c = null;
        d();
        e(0);
    }

    public final void d() {
        int i2 = this.f25927e;
        if (i2 == 1 || i2 == 0 || this.f25930h == null) {
            return;
        }
        AudioManager audioManager = (AudioManager) this.f25923a.zza();
        zzch zzchVar = this.f25930h;
        if (Build.VERSION.SDK_INT < 26) {
            audioManager.abandonAudioFocus(zzchVar.f26219a);
            return;
        }
        Object obj = zzchVar.f26222d;
        obj.getClass();
        audioManager.abandonAudioFocusRequest(e.f(obj));
    }

    public final void e(int i2) {
        if (this.f25927e == i2) {
            return;
        }
        this.f25927e = i2;
        float f2 = i2 == 4 ? 0.2f : 1.0f;
        if (this.f25929g != f2) {
            this.f25929g = f2;
            zzcc zzccVar = this.f25925c;
            if (zzccVar != null) {
                ((zzlc) zzccVar).f35075h.zzh(34);
            }
        }
    }
}

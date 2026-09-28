package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* loaded from: classes4.dex */
final class zzabx extends HandlerThread implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public zzdt f22686a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f22687b;

    /* renamed from: c, reason: collision with root package name */
    public Error f22688c;

    /* renamed from: d, reason: collision with root package name */
    public RuntimeException f22689d;

    /* renamed from: e, reason: collision with root package name */
    public zzaby f22690e;

    public zzabx() {
        super("ExoPlayer:PlaceholderSurface");
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        zzdt zzdtVar;
        int i2 = message.what;
        try {
            if (i2 == 1) {
                try {
                    int i3 = message.arg1;
                    zzdt zzdtVar2 = this.f22686a;
                    if (zzdtVar2 == null) {
                        throw null;
                    }
                    zzdtVar2.a(i3);
                    SurfaceTexture surfaceTexture = this.f22686a.f28509f;
                    surfaceTexture.getClass();
                    this.f22690e = new zzaby(this, surfaceTexture, i3 != 0);
                    synchronized (this) {
                        notify();
                    }
                    return true;
                } catch (zzdu e2) {
                    zzee.f("PlaceholderSurface", "Failed to initialize placeholder surface", e2);
                    this.f22689d = new IllegalStateException(e2);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e3) {
                    zzee.f("PlaceholderSurface", "Failed to initialize placeholder surface", e3);
                    this.f22688c = e3;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e4) {
                    zzee.f("PlaceholderSurface", "Failed to initialize placeholder surface", e4);
                    this.f22689d = e4;
                    synchronized (this) {
                        notify();
                    }
                }
            } else if (i2 == 2) {
                try {
                    zzdtVar = this.f22686a;
                } finally {
                    try {
                        return true;
                    } finally {
                    }
                }
                if (zzdtVar == null) {
                    throw null;
                }
                zzdtVar.b();
                return true;
            }
            return true;
        } catch (Throwable th) {
            synchronized (this) {
                notify();
                throw th;
            }
        }
    }
}

package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzjl implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, zzadg, zzqy, zzyk, zzve, zzby, zzeu {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzkp f35004a;

    public /* synthetic */ zzjl(zzkp zzkpVar) {
        Objects.requireNonNull(zzkpVar);
        this.f35004a = zzkpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    public final void a(zzfb zzfbVar) {
        this.f35004a.d(new zzit(2, zzfbVar, 1003));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        zzkp zzkpVar = this.f35004a;
        zzkpVar.getClass();
        Surface surface = new Surface(surfaceTexture);
        zzkpVar.m(surface);
        zzkpVar.M = surface;
        zzkpVar.n(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzkp zzkpVar = this.f35004a;
        zzkpVar.m(null);
        zzkpVar.n(0, 0);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.f35004a.n(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.f35004a.n(i3, i4);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f35004a.n(0, 0);
    }
}

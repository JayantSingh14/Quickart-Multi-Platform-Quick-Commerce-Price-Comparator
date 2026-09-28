package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzceo extends zzceq implements TextureView.SurfaceTextureListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener {
    public static final HashMap t;

    /* renamed from: c, reason: collision with root package name */
    public final zzcir f26017c;

    /* renamed from: d, reason: collision with root package name */
    public final zzcfl f26018d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f26019e;

    /* renamed from: f, reason: collision with root package name */
    public final zzdxe f26020f;

    /* renamed from: g, reason: collision with root package name */
    public int f26021g;

    /* renamed from: h, reason: collision with root package name */
    public int f26022h;

    /* renamed from: i, reason: collision with root package name */
    public MediaPlayer f26023i;

    /* renamed from: j, reason: collision with root package name */
    public Uri f26024j;

    /* renamed from: k, reason: collision with root package name */
    public int f26025k;

    /* renamed from: l, reason: collision with root package name */
    public int f26026l;

    /* renamed from: m, reason: collision with root package name */
    public int f26027m;
    public zzcfi n;
    public final boolean o;
    public int p;
    public zzcey q;
    public boolean r;
    public Integer s;

    static {
        HashMap map = new HashMap();
        t = map;
        map.put(-1004, "MEDIA_ERROR_IO");
        map.put(-1007, "MEDIA_ERROR_MALFORMED");
        map.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
        map.put(-110, "MEDIA_ERROR_TIMED_OUT");
        map.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        map.put(100, "MEDIA_ERROR_SERVER_DIED");
        map.put(1, "MEDIA_ERROR_UNKNOWN");
        map.put(1, "MEDIA_INFO_UNKNOWN");
        map.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        map.put(701, "MEDIA_INFO_BUFFERING_START");
        map.put(702, "MEDIA_INFO_BUFFERING_END");
        map.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        map.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        map.put(802, "MEDIA_INFO_METADATA_UPDATE");
        map.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        map.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzceo(Context context, zzcir zzcirVar, boolean z, boolean z2, zzcfl zzcflVar, zzdxe zzdxeVar) {
        super(context);
        this.f26021g = 0;
        this.f26022h = 0;
        this.r = false;
        this.s = null;
        this.f26017c = zzcirVar;
        this.f26018d = zzcflVar;
        this.o = z;
        this.f26019e = z2;
        zzcflVar.a(this);
        this.f26020f = zzdxeVar;
    }

    public final void C() throws IllegalStateException, InterruptedException, IOException, SecurityException, IllegalArgumentException {
        SurfaceTexture surfaceTexture;
        zzdxe zzdxeVar;
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture2 = getSurfaceTexture();
        if (this.f26024j == null || surfaceTexture2 == null) {
            return;
        }
        D(false);
        try {
            com.google.android.gms.ads.internal.overlay.zzae zzaeVar = com.google.android.gms.ads.internal.zzt.C.u;
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f26023i = mediaPlayer;
            mediaPlayer.setOnBufferingUpdateListener(this);
            this.f26023i.setOnCompletionListener(this);
            this.f26023i.setOnErrorListener(this);
            this.f26023i.setOnInfoListener(this);
            this.f26023i.setOnPreparedListener(this);
            this.f26023i.setOnVideoSizeChangedListener(this);
            this.f26027m = 0;
            if (this.o) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.te)).booleanValue() && (zzdxeVar = this.f26020f) != null) {
                    zzdxd zzdxdVarA = zzdxeVar.a();
                    zzdxdVarA.b("action", "svp_ampv");
                    zzdxdVarA.c();
                }
                zzcfi zzcfiVar = new zzcfi(getContext());
                this.n = zzcfiVar;
                int width = getWidth();
                int height = getHeight();
                zzcfiVar.f26084m = width;
                zzcfiVar.f26083l = height;
                zzcfiVar.o = surfaceTexture2;
                zzcfi zzcfiVar2 = this.n;
                zzcfiVar2.start();
                if (zzcfiVar2.o == null) {
                    surfaceTexture = null;
                } else {
                    try {
                        zzcfiVar2.t.await();
                    } catch (InterruptedException unused) {
                    }
                    surfaceTexture = zzcfiVar2.n;
                }
                if (surfaceTexture != null) {
                    surfaceTexture2 = surfaceTexture;
                } else {
                    this.n.b();
                    this.n = null;
                }
            }
            this.f26023i.setDataSource(getContext(), this.f26024j);
            this.f26023i.setSurface(new Surface(surfaceTexture2));
            this.f26023i.setAudioStreamType(3);
            this.f26023i.setScreenOnWhilePlaying(true);
            this.f26023i.prepareAsync();
            F(1);
        } catch (IOException e2) {
            e = e2;
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to initialize MediaPlayer at ".concat(String.valueOf(this.f26024j)), e);
            onError(this.f26023i, 1, 0);
        } catch (IllegalArgumentException e3) {
            e = e3;
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to initialize MediaPlayer at ".concat(String.valueOf(this.f26024j)), e);
            onError(this.f26023i, 1, 0);
        } catch (IllegalStateException e4) {
            e = e4;
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to initialize MediaPlayer at ".concat(String.valueOf(this.f26024j)), e);
            onError(this.f26023i, 1, 0);
        }
    }

    public final void D(boolean z) {
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView release");
        zzcfi zzcfiVar = this.n;
        if (zzcfiVar != null) {
            zzcfiVar.b();
            this.n = null;
        }
        MediaPlayer mediaPlayer = this.f26023i;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f26023i.release();
            this.f26023i = null;
            F(0);
            if (z) {
                this.f26022h = 0;
            }
        }
    }

    public final boolean E() {
        int i2;
        return (this.f26023i == null || (i2 = this.f26021g) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    public final void F(int i2) {
        zzcfo zzcfoVar = this.f26029b;
        zzcfl zzcflVar = this.f26018d;
        if (i2 == 3) {
            zzcflVar.d();
            zzcfoVar.f26116d = true;
            zzcfoVar.a();
        } else if (this.f26021g == 3) {
            zzcflVar.f26110m = false;
            zzcfoVar.f26116d = false;
            zzcfoVar.a();
        }
        this.f26021g = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final String h() {
        return "MediaPlayer".concat(true != this.o ? "" : " spherical");
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void i(zzcey zzceyVar) {
        this.q = zzceyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void j(String str) throws IllegalStateException, InterruptedException, IOException, SecurityException, IllegalArgumentException {
        Uri uri = Uri.parse(str);
        zzbev zzbevVarB = zzbev.b(uri);
        if (zzbevVarB == null || zzbevVarB.f24857a != null) {
            if (zzbevVarB != null) {
                uri = Uri.parse(zzbevVarB.f24857a);
            }
            this.f26024j = uri;
            this.p = 0;
            C();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void l() throws IllegalStateException {
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.f26023i;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f26023i.release();
            this.f26023i = null;
            F(0);
            this.f26022h = 0;
        }
        this.f26018d.b();
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void m() throws IllegalStateException {
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView play");
        if (E()) {
            this.f26023i.start();
            F(3);
            this.f26028a.f26063c = true;
            com.google.android.gms.ads.internal.util.zzs.f21608l.post(new zzcel(this));
        }
        this.f26022h = 3;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void n() throws IllegalStateException {
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView pause");
        if (E() && this.f26023i.isPlaying()) {
            this.f26023i.pause();
            F(4);
            com.google.android.gms.ads.internal.util.zzs.f21608l.post(new zzcem(this));
        }
        this.f26022h = 4;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final int o() {
        if (E()) {
            return this.f26023i.getDuration();
        }
        return -1;
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setSurfaceTextureListener(this);
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
        this.f26027m = i2;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView completion");
        F(5);
        this.f26022h = 5;
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new zzceg(this));
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        HashMap map = t;
        String str = (String) map.get(Integer.valueOf(i2));
        String str2 = (String) map.get(Integer.valueOf(i3));
        String strN = android.support.v4.media.a.n(new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length()), "AdMediaPlayerView MediaPlayer error: ", str, ":", str2);
        int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.f(strN);
        F(-1);
        this.f26022h = -1;
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new zzceh(this, str, str2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        HashMap map = t;
        String str = (String) map.get(Integer.valueOf(i2));
        String str2 = (String) map.get(Integer.valueOf(i3));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.f26025k
            int r0 = android.view.View.getDefaultSize(r0, r6)
            int r1 = r5.f26026l
            int r1 = android.view.View.getDefaultSize(r1, r7)
            int r2 = r5.f26025k
            if (r2 <= 0) goto L7a
            int r2 = r5.f26026l
            if (r2 <= 0) goto L7a
            com.google.android.gms.internal.ads.zzcfi r2 = r5.n
            if (r2 != 0) goto L7a
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L43
            if (r1 != r2) goto L42
            int r0 = r5.f26025k
            int r1 = r0 * r7
            int r2 = r5.f26026l
            int r3 = r6 * r2
            if (r1 >= r3) goto L3c
            int r0 = r1 / r2
        L3a:
            r1 = r7
            goto L7a
        L3c:
            if (r1 <= r3) goto L60
            int r1 = r3 / r0
        L40:
            r0 = r6
            goto L7a
        L42:
            r0 = r2
        L43:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L54
            int r0 = r5.f26026l
            int r0 = r0 * r6
            int r2 = r5.f26025k
            int r0 = r0 / r2
            if (r1 != r3) goto L52
            if (r0 <= r7) goto L52
            goto L60
        L52:
            r1 = r0
            goto L40
        L54:
            if (r1 != r2) goto L64
            int r1 = r5.f26025k
            int r1 = r1 * r7
            int r2 = r5.f26026l
            int r1 = r1 / r2
            if (r0 != r3) goto L62
            if (r1 <= r6) goto L62
        L60:
            r0 = r6
            goto L3a
        L62:
            r0 = r1
            goto L3a
        L64:
            int r2 = r5.f26025k
            int r4 = r5.f26026l
            if (r1 != r3) goto L70
            if (r4 <= r7) goto L70
            int r1 = r7 * r2
            int r1 = r1 / r4
            goto L72
        L70:
            r1 = r2
            r7 = r4
        L72:
            if (r0 != r3) goto L62
            if (r1 <= r6) goto L62
            int r4 = r4 * r6
            int r1 = r4 / r2
            goto L40
        L7a:
            r5.setMeasuredDimension(r0, r1)
            com.google.android.gms.internal.ads.zzcfi r6 = r5.n
            if (r6 == 0) goto L84
            r6.a(r0, r1)
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzceo.onMeasure(int, int):void");
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView prepared");
        F(2);
        zzcfl zzcflVar = this.f26018d;
        if (zzcflVar.f26106i && !zzcflVar.f26107j) {
            zzbgr.a(zzcflVar.f26102e, zzcflVar.f26101d, "vfr2");
            zzcflVar.f26107j = true;
        }
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new zzcef(this, mediaPlayer));
        this.f26025k = mediaPlayer.getVideoWidth();
        this.f26026l = mediaPlayer.getVideoHeight();
        int i2 = this.p;
        if (i2 != 0) {
            q(i2);
        }
        if (this.f26019e && E() && this.f26023i.getCurrentPosition() > 0 && this.f26022h != 3) {
            com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView nudging MediaPlayer");
            MediaPlayer mediaPlayer2 = this.f26023i;
            if (mediaPlayer2 != null) {
                try {
                    mediaPlayer2.setVolume(0.0f, 0.0f);
                } catch (IllegalStateException unused) {
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzo.f("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
            }
            this.f26023i.start();
            int currentPosition = this.f26023i.getCurrentPosition();
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis();
            while (E() && this.f26023i.getCurrentPosition() == currentPosition && com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis() - jCurrentTimeMillis <= 250) {
            }
            this.f26023i.pause();
            zzq();
        }
        int i3 = this.f26025k;
        int i4 = this.f26026l;
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 40 + String.valueOf(i4).length());
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i3);
        sb.append(" x ");
        sb.append(i4);
        com.google.android.gms.ads.internal.util.client.zzo.e(sb.toString());
        if (this.f26022h == 3) {
            m();
        }
        zzq();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) throws IllegalStateException, InterruptedException, IOException, SecurityException, IllegalArgumentException {
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView surface created");
        C();
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new zzcei(this));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.f26023i;
        if (mediaPlayer != null && this.p == 0) {
            this.p = mediaPlayer.getCurrentPosition();
        }
        zzcfi zzcfiVar = this.n;
        if (zzcfiVar != null) {
            zzcfiVar.b();
        }
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new zzcek(this));
        D(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) throws IllegalStateException {
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView surface changed");
        int i4 = this.f26022h;
        boolean z = false;
        if (this.f26025k == i2 && this.f26026l == i3) {
            z = true;
        }
        if (this.f26023i != null && i4 == 3 && z) {
            int i5 = this.p;
            if (i5 != 0) {
                q(i5);
            }
            m();
        }
        zzcfi zzcfiVar = this.n;
        if (zzcfiVar != null) {
            zzcfiVar.a(i2, i3);
        }
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new zzcej(this, i2, i3));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f26018d.c(this);
        this.f26028a.a(surfaceTexture, this.q);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 35 + String.valueOf(i3).length());
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        this.f26025k = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.f26026l = videoHeight;
        if (this.f26025k == 0 || videoHeight == 0) {
            return;
        }
        requestLayout();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(final int i2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 47);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i2);
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcen
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzcey zzceyVar = this.f26015a.q;
                if (zzceyVar != null) {
                    zzceyVar.onWindowVisibilityChanged(i2);
                }
            }
        });
        super.onWindowVisibilityChanged(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final int p() {
        if (E()) {
            return this.f26023i.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void q(int i2) throws IllegalStateException {
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 23);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i2);
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        if (!E()) {
            this.p = i2;
        } else {
            this.f26023i.seekTo(i2);
            this.p = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void r(float f2, float f3) {
        zzcfi zzcfiVar = this.n;
        if (zzcfiVar != null) {
            zzcfiVar.c(f2, f3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final int s() {
        MediaPlayer mediaPlayer = this.f26023i;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final int t() {
        MediaPlayer mediaPlayer = this.f26023i;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // android.view.View
    public final String toString() {
        String name = zzceo.class.getName();
        String hexString = Integer.toHexString(hashCode());
        return android.support.v4.media.b.s(new StringBuilder(name.length() + 1 + String.valueOf(hexString).length()), name, "@", hexString);
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final long u() {
        if (this.s != null) {
            return (w() * this.f26027m) / 100;
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final long v() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final long w() {
        if (this.s != null) {
            return o() * this.s.intValue();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final int x() {
        if (Build.VERSION.SDK_INT < 26 || !E()) {
            return -1;
        }
        return this.f26023i.getMetrics().getInt("android.media.mediaplayer.dropped");
    }

    @Override // com.google.android.gms.internal.ads.zzcfn
    public final void zzq() {
        zzcfo zzcfoVar = this.f26029b;
        float f2 = zzcfoVar.f26115c ? zzcfoVar.f26117e ? 0.0f : zzcfoVar.f26118f : 0.0f;
        MediaPlayer mediaPlayer = this.f26023i;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f2, f2);
            } catch (IllegalStateException unused) {
            }
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }
}

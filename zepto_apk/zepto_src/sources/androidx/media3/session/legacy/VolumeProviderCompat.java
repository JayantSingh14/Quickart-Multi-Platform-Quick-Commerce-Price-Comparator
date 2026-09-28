package androidx.media3.session.legacy;

import android.media.VolumeProvider;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RestrictTo
@UnstableApi
/* loaded from: classes3.dex */
public abstract class VolumeProviderCompat {

    /* renamed from: a, reason: collision with root package name */
    public final int f10692a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10693b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10694c;

    /* renamed from: d, reason: collision with root package name */
    public int f10695d;

    /* renamed from: e, reason: collision with root package name */
    public VolumeProvider f10696e;

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        public static void a(VolumeProvider volumeProvider, int i2) {
            volumeProvider.setCurrentVolume(i2);
        }
    }

    public static abstract class Callback {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ControlType {
    }

    public VolumeProviderCompat(int i2, int i3, int i4, String str) {
        this.f10692a = i2;
        this.f10693b = i3;
        this.f10695d = i4;
        this.f10694c = str;
    }

    public final VolumeProvider a() {
        VolumeProviderCompat volumeProviderCompat;
        if (this.f10696e != null) {
            volumeProviderCompat = this;
        } else if (Build.VERSION.SDK_INT >= 30) {
            volumeProviderCompat = this;
            volumeProviderCompat.f10696e = new VolumeProvider(this.f10692a, this.f10693b, this.f10695d, this.f10694c) { // from class: androidx.media3.session.legacy.VolumeProviderCompat.1
                @Override // android.media.VolumeProvider
                public final void onAdjustVolume(int i2) {
                    VolumeProviderCompat.this.b(i2);
                }

                @Override // android.media.VolumeProvider
                public final void onSetVolumeTo(int i2) {
                    VolumeProviderCompat.this.c(i2);
                }
            };
        } else {
            volumeProviderCompat = this;
            volumeProviderCompat.f10696e = new VolumeProvider(volumeProviderCompat.f10692a, volumeProviderCompat.f10693b, volumeProviderCompat.f10695d) { // from class: androidx.media3.session.legacy.VolumeProviderCompat.2
                @Override // android.media.VolumeProvider
                public final void onAdjustVolume(int i2) {
                    VolumeProviderCompat.this.b(i2);
                }

                @Override // android.media.VolumeProvider
                public final void onSetVolumeTo(int i2) {
                    VolumeProviderCompat.this.c(i2);
                }
            };
        }
        return volumeProviderCompat.f10696e;
    }

    public void b(int i2) {
    }

    public void c(int i2) {
    }

    public final void d(int i2) {
        this.f10695d = i2;
        Api21Impl.a(a(), i2);
    }
}

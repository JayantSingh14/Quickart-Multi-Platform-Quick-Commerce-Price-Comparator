package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public abstract class VolumeProviderCompat {

    /* renamed from: androidx.media.VolumeProviderCompat$1, reason: invalid class name */
    class AnonymousClass1 extends VolumeProvider {
        @Override // android.media.VolumeProvider
        public final void onAdjustVolume(int i2) {
            throw null;
        }

        @Override // android.media.VolumeProvider
        public final void onSetVolumeTo(int i2) {
            throw null;
        }
    }

    /* renamed from: androidx.media.VolumeProviderCompat$2, reason: invalid class name */
    class AnonymousClass2 extends VolumeProvider {
        @Override // android.media.VolumeProvider
        public final void onAdjustVolume(int i2) {
            throw null;
        }

        @Override // android.media.VolumeProvider
        public final void onSetVolumeTo(int i2) {
            throw null;
        }
    }

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
    @RestrictTo
    public @interface ControlType {
    }
}

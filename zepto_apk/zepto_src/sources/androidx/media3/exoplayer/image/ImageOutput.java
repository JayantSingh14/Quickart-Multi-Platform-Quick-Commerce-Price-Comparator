package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public interface ImageOutput {

    /* renamed from: a, reason: collision with root package name */
    public static final ImageOutput f7259a = new AnonymousClass1();

    /* renamed from: androidx.media3.exoplayer.image.ImageOutput$1, reason: invalid class name */
    public class AnonymousClass1 implements ImageOutput {
        @Override // androidx.media3.exoplayer.image.ImageOutput
        public final void a() {
        }

        @Override // androidx.media3.exoplayer.image.ImageOutput
        public final void onImageAvailable(long j2, Bitmap bitmap) {
        }
    }

    void a();

    void onImageAvailable(long j2, Bitmap bitmap);
}

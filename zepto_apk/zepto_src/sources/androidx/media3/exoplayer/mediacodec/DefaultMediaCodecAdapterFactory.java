package androidx.media3.exoplayer.mediacodec;

import android.content.Context;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.SynchronousMediaCodecAdapter;

@UnstableApi
/* loaded from: classes3.dex */
public final class DefaultMediaCodecAdapterFactory implements MediaCodecAdapter.Factory {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7312a;

    /* renamed from: b, reason: collision with root package name */
    public int f7313b;

    @Deprecated
    public DefaultMediaCodecAdapterFactory() {
        this.f7313b = 0;
        this.f7312a = null;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.Factory
    public final MediaCodecAdapter a(MediaCodecAdapter.Configuration configuration) {
        int i2;
        Context context;
        int i3 = Util.f5744a;
        if (i3 < 23 || ((i2 = this.f7313b) != 1 && (i2 != 0 || (i3 < 31 && ((context = this.f7312a) == null || i3 < 28 || !context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen")))))) {
            return new SynchronousMediaCodecAdapter.Factory().a(configuration);
        }
        int i4 = MimeTypes.i(configuration.f7316c.f5225m);
        Log.g("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + Util.H(i4));
        return new AsynchronousMediaCodecAdapter.Factory(i4).a(configuration);
    }

    public DefaultMediaCodecAdapterFactory(Context context) {
        this.f7312a = context;
        this.f7313b = 0;
    }
}

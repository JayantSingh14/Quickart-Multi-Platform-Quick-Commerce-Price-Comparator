package androidx.media3.exoplayer.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.AudioOffloadSupport;
import androidx.media3.exoplayer.audio.DefaultAudioSink;

@UnstableApi
/* loaded from: classes3.dex */
public final class DefaultAudioOffloadSupportProvider implements DefaultAudioSink.AudioOffloadSupportProvider {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6567a;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f6568b;

    @RequiresApi
    public static final class Api29 {
        @DoNotInline
        public static AudioOffloadSupport a(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z) {
            if (!AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
                return AudioOffloadSupport.f6516d;
            }
            AudioOffloadSupport.Builder builder = new AudioOffloadSupport.Builder();
            builder.f6520a = true;
            builder.f6522c = z;
            return builder.a();
        }
    }

    @RequiresApi
    public static final class Api31 {
        @DoNotInline
        public static AudioOffloadSupport a(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z) {
            int playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
            if (playbackOffloadSupport == 0) {
                return AudioOffloadSupport.f6516d;
            }
            AudioOffloadSupport.Builder builder = new AudioOffloadSupport.Builder();
            boolean z2 = Util.f5744a > 32 && playbackOffloadSupport == 2;
            builder.f6520a = true;
            builder.f6521b = z2;
            builder.f6522c = z;
            return builder.a();
        }
    }

    public DefaultAudioOffloadSupportProvider() {
        this(null);
    }

    public DefaultAudioOffloadSupportProvider(Context context) {
        this.f6567a = context;
    }
}

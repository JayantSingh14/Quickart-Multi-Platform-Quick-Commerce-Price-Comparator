package androidx.media;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.media.AudioAttributesCompat;
import androidx.media.AudioAttributesImpl;
import java.util.Objects;

/* loaded from: classes3.dex */
public class AudioFocusRequestCompat {

    @RequiresApi
    public static class Api26Impl {
        @DoNotInline
        public static AudioFocusRequest a(int i2, AudioAttributes audioAttributes, boolean z, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
            return new AudioFocusRequest.Builder(i2).setAudioAttributes(audioAttributes).setWillPauseWhenDucked(z).setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler).build();
        }
    }

    public static final class Builder {
    }

    public static class OnAudioFocusChangeListenerHandlerCompat implements Handler.Callback, AudioManager.OnAudioFocusChangeListener {
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what != 2782386) {
                return false;
            }
            throw null;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i2) {
            Message.obtain(null, 2782386, i2, 0);
            throw null;
        }
    }

    static {
        AudioAttributesImpl.Builder builder = new AudioAttributesCompat.Builder().f5027a;
        builder.a();
        builder.build();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioFocusRequestCompat)) {
            return false;
        }
        ((AudioFocusRequestCompat) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return Objects.hash(0, null, null, null, Boolean.FALSE);
    }
}

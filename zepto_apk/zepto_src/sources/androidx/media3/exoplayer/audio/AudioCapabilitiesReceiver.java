package androidx.media3.exoplayer.audio;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.AudioSink;

@UnstableApi
/* loaded from: classes3.dex */
public final class AudioCapabilitiesReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6500a;

    /* renamed from: b, reason: collision with root package name */
    public final k f6501b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f6502c;

    /* renamed from: d, reason: collision with root package name */
    public final AudioDeviceCallbackV23 f6503d;

    /* renamed from: e, reason: collision with root package name */
    public final BroadcastReceiver f6504e;

    /* renamed from: f, reason: collision with root package name */
    public final ExternalSurroundSoundSettingObserver f6505f;

    /* renamed from: g, reason: collision with root package name */
    public AudioCapabilities f6506g;

    /* renamed from: h, reason: collision with root package name */
    public AudioDeviceInfoApi23 f6507h;

    /* renamed from: i, reason: collision with root package name */
    public AudioAttributes f6508i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6509j;

    @RequiresApi
    public static final class Api23 {
        @DoNotInline
        public static void a(Context context, AudioDeviceCallback audioDeviceCallback, Handler handler) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            audioManager.getClass();
            audioManager.registerAudioDeviceCallback(audioDeviceCallback, handler);
        }

        @DoNotInline
        public static void b(Context context, AudioDeviceCallback audioDeviceCallback) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            audioManager.getClass();
            audioManager.unregisterAudioDeviceCallback(audioDeviceCallback);
        }
    }

    @RequiresApi
    public final class AudioDeviceCallbackV23 extends AudioDeviceCallback {
        public AudioDeviceCallbackV23() {
        }

        @Override // android.media.AudioDeviceCallback
        public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
            audioCapabilitiesReceiver.a(AudioCapabilities.c(audioCapabilitiesReceiver.f6500a, audioCapabilitiesReceiver.f6508i, audioCapabilitiesReceiver.f6507h));
        }

        @Override // android.media.AudioDeviceCallback
        public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
            if (Util.m(audioDeviceInfoArr, audioCapabilitiesReceiver.f6507h)) {
                audioCapabilitiesReceiver.f6507h = null;
            }
            audioCapabilitiesReceiver.a(AudioCapabilities.c(audioCapabilitiesReceiver.f6500a, audioCapabilitiesReceiver.f6508i, audioCapabilitiesReceiver.f6507h));
        }
    }

    public final class ExternalSurroundSoundSettingObserver extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        public final ContentResolver f6511a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f6512b;

        public ExternalSurroundSoundSettingObserver(Handler handler, ContentResolver contentResolver, Uri uri) {
            super(handler);
            this.f6511a = contentResolver;
            this.f6512b = uri;
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z) {
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
            audioCapabilitiesReceiver.a(AudioCapabilities.c(audioCapabilitiesReceiver.f6500a, audioCapabilitiesReceiver.f6508i, audioCapabilitiesReceiver.f6507h));
        }
    }

    public final class HdmiAudioPlugBroadcastReceiver extends BroadcastReceiver {
        public HdmiAudioPlugBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
            audioCapabilitiesReceiver.a(AudioCapabilities.b(context, intent, audioCapabilitiesReceiver.f6508i, audioCapabilitiesReceiver.f6507h));
        }
    }

    public interface Listener {
    }

    public AudioCapabilitiesReceiver(Context context, k kVar, AudioAttributes audioAttributes, AudioDeviceInfoApi23 audioDeviceInfoApi23) {
        Context applicationContext = context.getApplicationContext();
        this.f6500a = applicationContext;
        this.f6501b = kVar;
        this.f6508i = audioAttributes;
        this.f6507h = audioDeviceInfoApi23;
        int i2 = Util.f5744a;
        Looper looperMyLooper = Looper.myLooper();
        Handler handler = new Handler(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper, null);
        this.f6502c = handler;
        int i3 = Util.f5744a;
        this.f6503d = i3 >= 23 ? new AudioDeviceCallbackV23() : null;
        this.f6504e = i3 >= 21 ? new HdmiAudioPlugBroadcastReceiver() : null;
        AudioCapabilities audioCapabilities = AudioCapabilities.f6491c;
        String str = Util.f5746c;
        Uri uriFor = ("Amazon".equals(str) || "Xiaomi".equals(str)) ? Settings.Global.getUriFor("external_surround_sound_enabled") : null;
        this.f6505f = uriFor != null ? new ExternalSurroundSoundSettingObserver(handler, applicationContext.getContentResolver(), uriFor) : null;
    }

    public final void a(AudioCapabilities audioCapabilities) {
        if (!this.f6509j || audioCapabilities.equals(this.f6506g)) {
            return;
        }
        this.f6506g = audioCapabilities;
        DefaultAudioSink defaultAudioSink = this.f6501b.f6665a;
        defaultAudioSink.getClass();
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = defaultAudioSink.i0;
        if (looper != looperMyLooper) {
            throw new IllegalStateException(android.support.v4.media.b.m("Current looper (", looperMyLooper != null ? looperMyLooper.getThread().getName() : "null", ") is not the playback looper (", looper == null ? "null" : looper.getThread().getName(), ")"));
        }
        if (audioCapabilities.equals(defaultAudioSink.x)) {
            return;
        }
        defaultAudioSink.x = audioCapabilities;
        AudioSink.Listener listener = defaultAudioSink.s;
        if (listener != null) {
            listener.i();
        }
    }

    public final void b(AudioDeviceInfo audioDeviceInfo) {
        AudioDeviceInfoApi23 audioDeviceInfoApi23 = this.f6507h;
        if (Util.a(audioDeviceInfo, audioDeviceInfoApi23 == null ? null : audioDeviceInfoApi23.f6515a)) {
            return;
        }
        AudioDeviceInfoApi23 audioDeviceInfoApi232 = audioDeviceInfo != null ? new AudioDeviceInfoApi23(audioDeviceInfo) : null;
        this.f6507h = audioDeviceInfoApi232;
        a(AudioCapabilities.c(this.f6500a, this.f6508i, audioDeviceInfoApi232));
    }
}

package androidx.media3.exoplayer;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.AudioFocusManager;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes3.dex */
final class AudioFocusManager {

    /* renamed from: a, reason: collision with root package name */
    public final AudioManager f6102a;

    /* renamed from: b, reason: collision with root package name */
    public final AudioFocusListener f6103b;

    /* renamed from: c, reason: collision with root package name */
    public PlayerControl f6104c;

    /* renamed from: d, reason: collision with root package name */
    public AudioAttributes f6105d;

    /* renamed from: e, reason: collision with root package name */
    public int f6106e;

    /* renamed from: f, reason: collision with root package name */
    public int f6107f;

    /* renamed from: g, reason: collision with root package name */
    public float f6108g = 1.0f;

    /* renamed from: h, reason: collision with root package name */
    public AudioFocusRequest f6109h;

    public class AudioFocusListener implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f6110a;

        public AudioFocusListener(Handler handler) {
            this.f6110a = handler;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(final int i2) {
            this.f6110a.post(new Runnable() { // from class: androidx.media3.exoplayer.a
                @Override // java.lang.Runnable
                public final void run() {
                    AudioFocusManager audioFocusManager = AudioFocusManager.this;
                    audioFocusManager.getClass();
                    int i3 = i2;
                    if (i3 == -3 || i3 == -2) {
                        if (i3 != -2) {
                            AudioAttributes audioAttributes = audioFocusManager.f6105d;
                            if (!(audioAttributes != null && audioAttributes.f5149a == 1)) {
                                audioFocusManager.c(4);
                                return;
                            }
                        }
                        AudioFocusManager.PlayerControl playerControl = audioFocusManager.f6104c;
                        if (playerControl != null) {
                            playerControl.B(0);
                        }
                        audioFocusManager.c(3);
                        return;
                    }
                    if (i3 == -1) {
                        AudioFocusManager.PlayerControl playerControl2 = audioFocusManager.f6104c;
                        if (playerControl2 != null) {
                            playerControl2.B(-1);
                        }
                        audioFocusManager.a();
                        audioFocusManager.c(1);
                        return;
                    }
                    if (i3 != 1) {
                        android.support.v4.media.a.r(i3, "Unknown focus change type: ", "AudioFocusManager");
                        return;
                    }
                    audioFocusManager.c(2);
                    AudioFocusManager.PlayerControl playerControl3 = audioFocusManager.f6104c;
                    if (playerControl3 != null) {
                        playerControl3.B(1);
                    }
                }
            });
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayerCommand {
    }

    public interface PlayerControl {
        void B(int i2);

        void C();
    }

    public AudioFocusManager(Context context, Handler handler, PlayerControl playerControl) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        audioManager.getClass();
        this.f6102a = audioManager;
        this.f6104c = playerControl;
        this.f6103b = new AudioFocusListener(handler);
        this.f6106e = 0;
    }

    public final void a() {
        int i2 = this.f6106e;
        if (i2 == 1 || i2 == 0) {
            return;
        }
        int i3 = Util.f5744a;
        AudioManager audioManager = this.f6102a;
        if (i3 < 26) {
            audioManager.abandonAudioFocus(this.f6103b);
            return;
        }
        AudioFocusRequest audioFocusRequest = this.f6109h;
        if (audioFocusRequest != null) {
            audioManager.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(androidx.media3.common.AudioAttributes r7) {
        /*
            r6 = this;
            androidx.media3.common.AudioAttributes r0 = r6.f6105d
            boolean r0 = androidx.media3.common.util.Util.a(r0, r7)
            if (r0 != 0) goto L3b
            r6.f6105d = r7
            r0 = 0
            r1 = 1
            if (r7 != 0) goto L10
        Le:
            r2 = r0
            goto L2f
        L10:
            r2 = 3
            r3 = 2
            java.lang.String r4 = "AudioFocusManager"
            int r5 = r7.f5151c
            switch(r5) {
                case 0: goto L29;
                case 1: goto L27;
                case 2: goto L25;
                case 3: goto Le;
                case 4: goto L25;
                case 5: goto L2f;
                case 6: goto L2f;
                case 7: goto L2f;
                case 8: goto L2f;
                case 9: goto L2f;
                case 10: goto L2f;
                case 11: goto L21;
                case 12: goto L2f;
                case 13: goto L2f;
                case 14: goto L27;
                case 15: goto L19;
                case 16: goto L1f;
                default: goto L19;
            }
        L19:
            java.lang.String r7 = "Unidentified audio usage: "
            android.support.v4.media.a.r(r5, r7, r4)
            goto Le
        L1f:
            r2 = 4
            goto L2f
        L21:
            int r7 = r7.f5149a
            if (r7 != r1) goto L2f
        L25:
            r2 = r3
            goto L2f
        L27:
            r2 = r1
            goto L2f
        L29:
            java.lang.String r7 = "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default."
            androidx.media3.common.util.Log.h(r4, r7)
            goto L27
        L2f:
            r6.f6107f = r2
            if (r2 == r1) goto L35
            if (r2 != 0) goto L36
        L35:
            r0 = r1
        L36:
            java.lang.String r7 = "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME."
            androidx.media3.common.util.Assertions.b(r0, r7)
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.AudioFocusManager.b(androidx.media3.common.AudioAttributes):void");
    }

    public final void c(int i2) {
        if (this.f6106e == i2) {
            return;
        }
        this.f6106e = i2;
        float f2 = i2 == 4 ? 0.2f : 1.0f;
        if (this.f6108g == f2) {
            return;
        }
        this.f6108g = f2;
        PlayerControl playerControl = this.f6104c;
        if (playerControl != null) {
            playerControl.C();
        }
    }

    public final int d(int i2, boolean z) {
        int iRequestAudioFocus;
        AudioFocusRequest.Builder builderO;
        int i3 = 0;
        z = false;
        boolean z2 = false;
        if (i2 == 1 || this.f6107f != 1) {
            a();
            c(0);
            return 1;
        }
        if (!z) {
            int i4 = this.f6106e;
            if (i4 == 1) {
                return -1;
            }
            if (i4 == 3) {
                return 0;
            }
        } else if (this.f6106e != 2) {
            int i5 = Util.f5744a;
            AudioManager audioManager = this.f6102a;
            AudioFocusListener audioFocusListener = this.f6103b;
            if (i5 >= 26) {
                AudioFocusRequest audioFocusRequest = this.f6109h;
                if (audioFocusRequest == null) {
                    if (audioFocusRequest == null) {
                        androidx.appcompat.app.c.t();
                        builderO = androidx.appcompat.app.c.k(this.f6107f);
                    } else {
                        androidx.appcompat.app.c.t();
                        builderO = androidx.appcompat.app.c.o(this.f6109h);
                    }
                    AudioAttributes audioAttributes = this.f6105d;
                    if (audioAttributes != null && audioAttributes.f5149a == 1) {
                        z2 = true;
                    }
                    audioAttributes.getClass();
                    this.f6109h = builderO.setAudioAttributes(audioAttributes.b().f5155a).setWillPauseWhenDucked(z2).setOnAudioFocusChangeListener(audioFocusListener).build();
                }
                iRequestAudioFocus = audioManager.requestAudioFocus(this.f6109h);
            } else {
                AudioAttributes audioAttributes2 = this.f6105d;
                audioAttributes2.getClass();
                int i6 = audioAttributes2.f5151c;
                if (i6 != 13) {
                    switch (i6) {
                        case 2:
                            break;
                        case 3:
                            i3 = 8;
                            break;
                        case 4:
                            i3 = 4;
                            break;
                        case 5:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            i3 = 5;
                            break;
                        case 6:
                            i3 = 2;
                            break;
                        default:
                            i3 = 3;
                            break;
                    }
                } else {
                    i3 = 1;
                }
                iRequestAudioFocus = audioManager.requestAudioFocus(audioFocusListener, i3, this.f6107f);
            }
            if (iRequestAudioFocus == 1) {
                c(2);
                return 1;
            }
            c(1);
            return -1;
        }
        return 1;
    }
}

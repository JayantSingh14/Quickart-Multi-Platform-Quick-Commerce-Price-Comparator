package androidx.media3.exoplayer.audio;

import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6637a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f6638b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AudioSink.AudioTrackConfig f6639c;

    public /* synthetic */ c(AudioRendererEventListener.EventDispatcher eventDispatcher, AudioSink.AudioTrackConfig audioTrackConfig, int i2) {
        this.f6637a = i2;
        this.f6638b = eventDispatcher;
        this.f6639c = audioTrackConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioSink.AudioTrackConfig audioTrackConfig = this.f6639c;
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.f6638b;
        int i2 = this.f6637a;
        eventDispatcher.getClass();
        switch (i2) {
            case 0:
                int i3 = Util.f5744a;
                eventDispatcher.f6524b.a(audioTrackConfig);
                break;
            default:
                int i4 = Util.f5744a;
                eventDispatcher.f6524b.c(audioTrackConfig);
                break;
        }
    }
}

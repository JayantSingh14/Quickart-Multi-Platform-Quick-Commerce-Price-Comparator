package androidx.media3.exoplayer.audio;

import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6640a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f6641b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Exception f6642c;

    public /* synthetic */ d(AudioRendererEventListener.EventDispatcher eventDispatcher, Exception exc, int i2) {
        this.f6640a = i2;
        this.f6641b = eventDispatcher;
        this.f6642c = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Exception exc = this.f6642c;
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.f6641b;
        int i2 = this.f6640a;
        eventDispatcher.getClass();
        switch (i2) {
            case 0:
                int i3 = Util.f5744a;
                eventDispatcher.f6524b.w(exc);
                break;
            default:
                int i4 = Util.f5744a;
                eventDispatcher.f6524b.e(exc);
                break;
        }
    }
}

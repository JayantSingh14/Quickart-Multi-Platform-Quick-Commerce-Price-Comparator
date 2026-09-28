package androidx.media3.exoplayer.audio;

import androidx.core.view.WindowInsetsControllerCompat;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import com.swmansion.reanimated.keyboard.WindowsInsetsManager;
import com.swmansion.rnscreens.ScreenFragment;
import in.juspay.hypersdk.analytics.LogManager;

/* loaded from: classes3.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6655a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f6656b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6657c;

    public /* synthetic */ h(Object obj, boolean z, int i2) {
        this.f6655a = i2;
        this.f6657c = obj;
        this.f6656b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = this.f6656b;
        Object obj = this.f6657c;
        switch (this.f6655a) {
            case 0:
                AudioRendererEventListener.EventDispatcher eventDispatcher = (AudioRendererEventListener.EventDispatcher) obj;
                eventDispatcher.getClass();
                int i2 = Util.f5744a;
                eventDispatcher.f6524b.d(z);
                break;
            case 1:
                ((WindowsInsetsManager) obj).lambda$updateWindowDecor$0(z);
                break;
            case 2:
                ScreenFragment screenFragment = (ScreenFragment) obj;
                screenFragment.getClass();
                if (!z) {
                    screenFragment.z(ScreenFragment.ScreenLifecycleEvent.f47010b, screenFragment);
                    screenFragment.A(0.0f, false);
                    break;
                } else {
                    screenFragment.z(ScreenFragment.ScreenLifecycleEvent.f47009a, screenFragment);
                    screenFragment.A(1.0f, false);
                    break;
                }
            case 3:
                WindowInsetsControllerCompat windowInsetsControllerCompat = (WindowInsetsControllerCompat) obj;
                if (!z) {
                    windowInsetsControllerCompat.g(1);
                    break;
                } else {
                    windowInsetsControllerCompat.b(1);
                    break;
                }
            default:
                LogManager.startPushTasks$lambda$3((LogManager) obj, z);
                break;
        }
    }

    public /* synthetic */ h(boolean z, Object obj, int i2) {
        this.f6655a = i2;
        this.f6656b = z;
        this.f6657c = obj;
    }
}

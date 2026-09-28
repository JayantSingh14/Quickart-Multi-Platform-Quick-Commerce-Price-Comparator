package io.sentry.android.core.performance;

import android.view.Window;
import com.swmansion.reanimated.layoutReanimation.c;
import io.sentry.android.core.internal.gestures.WindowCallbackAdapter;

/* loaded from: classes3.dex */
public class WindowContentChangedCallback extends WindowCallbackAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final c f52384b;

    public WindowContentChangedCallback(Window.Callback callback, c cVar) {
        super(callback);
        this.f52384b = cVar;
    }

    @Override // io.sentry.android.core.internal.gestures.WindowCallbackAdapter, android.view.Window.Callback
    public final void onContentChanged() {
        super.onContentChanged();
        this.f52384b.run();
    }
}

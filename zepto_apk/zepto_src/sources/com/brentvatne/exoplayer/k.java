package com.brentvatne.exoplayer;

import android.view.View;
import com.brentvatne.exoplayer.ReactExoplayerView;

/* loaded from: classes3.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15628a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f15629b;

    public /* synthetic */ k(Object obj, int i2) {
        this.f15628a = i2;
        this.f15629b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.f15629b;
        switch (this.f15628a) {
            case 0:
                ReactExoplayerView reactExoplayerView = ((ReactExoplayerView.OnAudioFocusChangedListener) obj).f15583a;
                reactExoplayerView.f15570k.b1(reactExoplayerView.E * 0.8f);
                break;
            case 1:
                ReactExoplayerView reactExoplayerView2 = ((ReactExoplayerView.OnAudioFocusChangedListener) obj).f15583a;
                reactExoplayerView2.f15570k.b1(reactExoplayerView2.E * 1.0f);
                break;
            default:
                int i2 = ExoPlayerView.o;
                ExoPlayerView exoPlayerView = (ExoPlayerView) obj;
                exoPlayerView.measure(View.MeasureSpec.makeMeasureSpec(exoPlayerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(exoPlayerView.getHeight(), 1073741824));
                exoPlayerView.layout(exoPlayerView.getLeft(), exoPlayerView.getTop(), exoPlayerView.getRight(), exoPlayerView.getBottom());
                break;
        }
    }
}

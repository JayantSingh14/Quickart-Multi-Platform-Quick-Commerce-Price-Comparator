package androidx.media3.ui;

import android.view.View;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10992a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f10993b;

    public /* synthetic */ a(int i2, View view) {
        this.f10992a = i2;
        this.f10993b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view = this.f10993b;
        switch (this.f10992a) {
            case 0:
                int i2 = DefaultTimeBar.B0;
                ((DefaultTimeBar) view).f(false);
                break;
            case 1:
                float[] fArr = PlayerControlView.k1;
                ((PlayerControlView) view).o();
                break;
            default:
                ((PlayerView) view).invalidate();
                break;
        }
    }
}

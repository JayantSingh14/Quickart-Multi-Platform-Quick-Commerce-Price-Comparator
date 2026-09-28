package eightbitlab.com.blurview;

import android.graphics.Canvas;

/* loaded from: classes4.dex */
public class NoOpController implements BlurController {
    @Override // eightbitlab.com.blurview.BlurViewFacade
    public final BlurViewFacade a(int i2) {
        return this;
    }

    @Override // eightbitlab.com.blurview.BlurViewFacade
    public final BlurViewFacade b(boolean z) {
        return this;
    }

    @Override // eightbitlab.com.blurview.BlurViewFacade
    public final BlurViewFacade c(boolean z) {
        return this;
    }

    @Override // eightbitlab.com.blurview.BlurController
    public final void d() {
    }

    @Override // eightbitlab.com.blurview.BlurController
    public final void destroy() {
    }

    @Override // eightbitlab.com.blurview.BlurController
    public final boolean draw(Canvas canvas) {
        return true;
    }

    @Override // eightbitlab.com.blurview.BlurViewFacade
    public final BlurViewFacade e(float f2) {
        return this;
    }
}

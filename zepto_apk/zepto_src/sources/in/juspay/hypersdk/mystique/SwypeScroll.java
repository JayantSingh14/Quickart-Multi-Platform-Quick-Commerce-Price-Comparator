package in.juspay.hypersdk.mystique;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes4.dex */
public class SwypeScroll extends ScrollView {
    private float lastX;
    private float lastY;
    private float xDistance;
    private float yDistance;

    public SwypeScroll(Context context) {
        super(context);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.yDistance = 0.0f;
            this.xDistance = 0.0f;
            this.lastX = motionEvent.getX();
            this.lastY = motionEvent.getY();
        } else if (action == 2) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.xDistance = Math.abs(x - this.lastX) + this.xDistance;
            float fAbs = Math.abs(y - this.lastY) + this.yDistance;
            this.yDistance = fAbs;
            this.lastX = x;
            this.lastY = y;
            if (this.xDistance > fAbs) {
                return false;
            }
            SwypeLayout swypeLayout = SwypeLayout.partialSwypeWeakReference.get();
            SwypeLayout swypeLayout2 = SwypeLayout.activeLayoutWeakReference.get();
            if (swypeLayout != null && swypeLayout != swypeLayout2) {
                swypeLayout.reset();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}

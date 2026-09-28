package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.Motion;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes3.dex */
public class Transition implements TypedValues {

    public static class KeyPosition {
    }

    public static class OnSwipe {
    }

    public static class WidgetState {
        public WidgetState() {
            new KeyCache();
            WidgetFrame widgetFrame = new WidgetFrame();
            WidgetFrame widgetFrame2 = new WidgetFrame();
            WidgetFrame widgetFrame3 = new WidgetFrame();
            MotionWidget motionWidget = new MotionWidget(widgetFrame);
            MotionWidget motionWidget2 = new MotionWidget(widgetFrame2);
            new MotionWidget(widgetFrame3);
            Motion motion = new Motion(motionWidget);
            motion.b(motionWidget);
            motion.a(motionWidget2);
        }
    }
}

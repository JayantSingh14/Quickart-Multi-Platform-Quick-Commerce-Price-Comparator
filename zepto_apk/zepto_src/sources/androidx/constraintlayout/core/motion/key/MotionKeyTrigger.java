package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.utils.FloatRect;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class MotionKeyTrigger extends MotionKey {
    public MotionKeyTrigger() {
        new FloatRect();
        new FloatRect();
        new HashMap();
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* renamed from: a */
    public final MotionKey clone() {
        return new MotionKeyTrigger();
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public final Object clone() {
        return new MotionKeyTrigger();
    }
}

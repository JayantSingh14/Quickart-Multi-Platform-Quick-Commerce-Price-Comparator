package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        U();
    }

    public final void U() {
        T(1);
        P(new Fade(2));
        P(new ChangeBounds());
        P(new Fade(1));
    }

    public AutoTransition(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        U();
    }
}

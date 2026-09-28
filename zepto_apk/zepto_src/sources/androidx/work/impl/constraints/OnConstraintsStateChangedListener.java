package androidx.work.impl.constraints;

import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface OnConstraintsStateChangedListener {
    void e(WorkSpec workSpec, ConstraintsState constraintsState);
}

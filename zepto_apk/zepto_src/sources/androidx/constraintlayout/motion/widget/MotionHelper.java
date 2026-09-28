package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class MotionHelper extends ConstraintHelper implements MotionHelperInterface {

    /* renamed from: j, reason: collision with root package name */
    public boolean f2168j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2169k;

    /* renamed from: l, reason: collision with root package name */
    public float f2170l;

    /* renamed from: m, reason: collision with root package name */
    public View[] f2171m;

    public MotionHelper(Context context, AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context, attributeSet);
        this.f2168j = false;
        this.f2169k = false;
        k(attributeSet);
    }

    public float getProgress() {
        return this.f2170l;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.k(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionHelper);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MotionHelper_onShow) {
                    this.f2168j = typedArrayObtainStyledAttributes.getBoolean(index, this.f2168j);
                } else if (index == R.styleable.MotionHelper_onHide) {
                    this.f2169k = typedArrayObtainStyledAttributes.getBoolean(index, this.f2169k);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void r(MotionLayout motionLayout, HashMap map) {
    }

    public void setProgress(float f2) {
        this.f2170l = f2;
        int i2 = 0;
        if (this.f2389b > 0) {
            this.f2171m = j((ConstraintLayout) getParent());
            while (i2 < this.f2389b) {
                View view = this.f2171m[i2];
                i2++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i2 < childCount) {
            boolean z = viewGroup.getChildAt(i2) instanceof MotionHelper;
            i2++;
        }
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i2) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context, attributeSet, i2);
        this.f2168j = false;
        this.f2169k = false;
        k(attributeSet);
    }

    public void a(int i2) {
    }
}

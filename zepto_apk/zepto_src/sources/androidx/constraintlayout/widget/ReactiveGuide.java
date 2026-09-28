package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.SharedValues;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ReactiveGuide extends View implements SharedValues.SharedValuesListener {

    /* renamed from: a, reason: collision with root package name */
    public int f2528a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2529b;

    /* renamed from: c, reason: collision with root package name */
    public int f2530c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2531d;

    public ReactiveGuide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2528a = -1;
        this.f2529b = false;
        this.f2530c = 0;
        this.f2531d = true;
        super.setVisibility(8);
        a(attributeSet);
    }

    public final void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_ReactiveGuide);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) {
                    this.f2528a = typedArrayObtainStyledAttributes.getResourceId(index, this.f2528a);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) {
                    this.f2529b = typedArrayObtainStyledAttributes.getBoolean(index, this.f2529b);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) {
                    this.f2530c = typedArrayObtainStyledAttributes.getResourceId(index, this.f2530c);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) {
                    this.f2531d = typedArrayObtainStyledAttributes.getBoolean(index, this.f2531d);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.f2528a != -1) {
            ConstraintLayout.getSharedValues().a(this.f2528a, this);
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    public int getApplyToConstraintSetId() {
        return this.f2530c;
    }

    public int getAttributeId() {
        return this.f2528a;
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        setMeasuredDimension(0, 0);
    }

    public void setAnimateChange(boolean z) {
        this.f2529b = z;
    }

    public void setApplyToConstraintSetId(int i2) {
        this.f2530c = i2;
    }

    public void setAttributeId(int i2) {
        HashSet hashSet;
        SharedValues sharedValues = ConstraintLayout.getSharedValues();
        int i3 = this.f2528a;
        if (i3 != -1 && (hashSet = (HashSet) sharedValues.f2532a.get(Integer.valueOf(i3))) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                SharedValues.SharedValuesListener sharedValuesListener = (SharedValues.SharedValuesListener) weakReference.get();
                if (sharedValuesListener == null || sharedValuesListener == this) {
                    arrayList.add(weakReference);
                }
            }
            hashSet.removeAll(arrayList);
        }
        this.f2528a = i2;
        if (i2 != -1) {
            sharedValues.a(i2, this);
        }
    }

    public void setGuidelineBegin(int i2) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f2411a = i2;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i2) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f2412b = i2;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f2) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f2413c = f2;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2528a = -1;
        this.f2529b = false;
        this.f2530c = 0;
        this.f2531d = true;
        super.setVisibility(8);
        a(attributeSet);
    }
}

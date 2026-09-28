package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public class MotionSpec {

    /* renamed from: a, reason: collision with root package name */
    public final SimpleArrayMap f39828a = new SimpleArrayMap();

    /* renamed from: b, reason: collision with root package name */
    public final SimpleArrayMap f39829b = new SimpleArrayMap();

    public static MotionSpec a(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return b(resourceId, context);
    }

    public static MotionSpec b(int i2, Context context) throws Resources.NotFoundException {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i2);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return c(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return c(arrayList);
        } catch (Exception e2) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i2), e2);
            return null;
        }
    }

    public static MotionSpec c(ArrayList arrayList) {
        MotionSpec motionSpec = new MotionSpec();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Animator animator = (Animator) arrayList.get(i2);
            if (!(animator instanceof ObjectAnimator)) {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            motionSpec.h(objectAnimator.getPropertyName(), objectAnimator.getValues());
            String propertyName = objectAnimator.getPropertyName();
            long startDelay = objectAnimator.getStartDelay();
            long duration = objectAnimator.getDuration();
            TimeInterpolator interpolator = objectAnimator.getInterpolator();
            if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                interpolator = AnimationUtils.f39817b;
            } else if (interpolator instanceof AccelerateInterpolator) {
                interpolator = AnimationUtils.f39818c;
            } else if (interpolator instanceof DecelerateInterpolator) {
                interpolator = AnimationUtils.f39819d;
            }
            MotionTiming motionTiming = new MotionTiming();
            motionTiming.f39833d = 0;
            motionTiming.f39834e = 1;
            motionTiming.f39830a = startDelay;
            motionTiming.f39831b = duration;
            motionTiming.f39832c = interpolator;
            motionTiming.f39833d = objectAnimator.getRepeatCount();
            motionTiming.f39834e = objectAnimator.getRepeatMode();
            motionSpec.f39828a.put(propertyName, motionTiming);
        }
        return motionSpec;
    }

    public final ObjectAnimator d(String str, Object obj, Property property) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(obj, e(str));
        objectAnimatorOfPropertyValuesHolder.setProperty(property);
        f(str).a(objectAnimatorOfPropertyValuesHolder);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public final PropertyValuesHolder[] e(String str) {
        if (!g(str)) {
            throw new IllegalArgumentException();
        }
        PropertyValuesHolder[] propertyValuesHolderArr = (PropertyValuesHolder[]) this.f39829b.get(str);
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i2 = 0; i2 < propertyValuesHolderArr.length; i2++) {
            propertyValuesHolderArr2[i2] = propertyValuesHolderArr[i2].clone();
        }
        return propertyValuesHolderArr2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MotionSpec) {
            return this.f39828a.equals(((MotionSpec) obj).f39828a);
        }
        return false;
    }

    public final MotionTiming f(String str) {
        SimpleArrayMap simpleArrayMap = this.f39828a;
        if (simpleArrayMap.get(str) != null) {
            return (MotionTiming) simpleArrayMap.get(str);
        }
        throw new IllegalArgumentException();
    }

    public final boolean g(String str) {
        return this.f39829b.get(str) != null;
    }

    public final void h(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f39829b.put(str, propertyValuesHolderArr);
    }

    public final int hashCode() {
        return this.f39828a.hashCode();
    }

    public final String toString() {
        return StringUtils.LF + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f39828a + "}\n";
    }
}

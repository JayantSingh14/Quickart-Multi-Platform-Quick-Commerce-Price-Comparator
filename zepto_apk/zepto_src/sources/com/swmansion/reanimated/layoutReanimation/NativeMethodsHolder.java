package com.swmansion.reanimated.layoutReanimation;

import java.util.HashMap;

/* loaded from: classes.dex */
public interface NativeMethodsHolder {
    void cancelAnimation(int i2);

    void checkDuplicateSharedTag(int i2, int i3);

    void clearAnimationConfig(int i2);

    int findPrecedingViewTagForTransition(int i2);

    int[] getSharedGroup(int i2);

    boolean hasAnimation(int i2, int i3);

    boolean isLayoutAnimationEnabled();

    boolean shouldAnimateExiting(int i2, boolean z);

    void startAnimation(int i2, int i3, HashMap<String, Object> map);
}

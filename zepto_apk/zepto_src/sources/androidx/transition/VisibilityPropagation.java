package androidx.transition;

/* loaded from: classes3.dex */
public abstract class VisibilityPropagation extends TransitionPropagation {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f12212a = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    public static int b(TransitionValues transitionValues, int i2) {
        int[] iArr;
        if (transitionValues == null || (iArr = (int[]) transitionValues.f12163a.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i2];
    }
}

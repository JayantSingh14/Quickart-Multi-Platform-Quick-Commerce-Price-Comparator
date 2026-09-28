package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class NestedScrollingChildHelper {

    /* renamed from: a, reason: collision with root package name */
    public ViewParent f3054a;

    /* renamed from: b, reason: collision with root package name */
    public ViewParent f3055b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f3056c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3057d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f3058e;

    public NestedScrollingChildHelper(ViewGroup viewGroup) {
        this.f3056c = viewGroup;
    }

    public final boolean a(float f2, float f3, boolean z) {
        ViewParent viewParentH;
        if (this.f3057d && (viewParentH = h(0)) != null) {
            try {
                return viewParentH.onNestedFling(this.f3056c, f2, f3, z);
            } catch (AbstractMethodError e2) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentH + " does not implement interface method onNestedFling", e2);
            }
        }
        return false;
    }

    public final boolean b(float f2, float f3) {
        ViewParent viewParentH;
        if (this.f3057d && (viewParentH = h(0)) != null) {
            try {
                return viewParentH.onNestedPreFling(this.f3056c, f2, f3);
            } catch (AbstractMethodError e2) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentH + " does not implement interface method onNestedPreFling", e2);
            }
        }
        return false;
    }

    public final boolean c(int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        ViewParent viewParentH;
        int i5;
        int i6;
        int[] iArr3;
        if (!this.f3057d || (viewParentH = h(i4)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        ViewGroup viewGroup = this.f3056c;
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            i5 = iArr2[0];
            i6 = iArr2[1];
        } else {
            i5 = 0;
            i6 = 0;
        }
        if (iArr == null) {
            if (this.f3058e == null) {
                this.f3058e = new int[2];
            }
            iArr3 = this.f3058e;
        } else {
            iArr3 = iArr;
        }
        iArr3[0] = 0;
        iArr3[1] = 0;
        if (viewParentH instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParentH).k(viewGroup, i2, i3, iArr3, i4);
        } else if (i4 == 0) {
            try {
                viewParentH.onNestedPreScroll(viewGroup, i2, i3, iArr3);
            } catch (AbstractMethodError e2) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentH + " does not implement interface method onNestedPreScroll", e2);
            }
        }
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i5;
            iArr2[1] = iArr2[1] - i6;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public final boolean d(int i2, int i3, int[] iArr, int[] iArr2) {
        return c(i2, i3, 0, iArr, iArr2);
    }

    public final void e(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        g(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public final boolean f(int i2, int i3, int i4, int i5, int[] iArr) {
        return g(i2, i3, i4, i5, iArr, 0, null);
    }

    public final boolean g(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        ViewParent viewParentH;
        int i7;
        int i8;
        int[] iArr3;
        if (this.f3057d && (viewParentH = h(i6)) != null) {
            if (i2 != 0 || i3 != 0 || i4 != 0 || i5 != 0) {
                ViewGroup viewGroup = this.f3056c;
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    i7 = iArr[0];
                    i8 = iArr[1];
                } else {
                    i7 = 0;
                    i8 = 0;
                }
                if (iArr2 == null) {
                    if (this.f3058e == null) {
                        this.f3058e = new int[2];
                    }
                    int[] iArr4 = this.f3058e;
                    iArr4[0] = 0;
                    iArr4[1] = 0;
                    iArr3 = iArr4;
                } else {
                    iArr3 = iArr2;
                }
                if (viewParentH instanceof NestedScrollingParent3) {
                    ((NestedScrollingParent3) viewParentH).m(viewGroup, i2, i3, i4, i5, i6, iArr3);
                } else {
                    iArr3[0] = iArr3[0] + i4;
                    iArr3[1] = iArr3[1] + i5;
                    if (viewParentH instanceof NestedScrollingParent2) {
                        ((NestedScrollingParent2) viewParentH).n(viewGroup, i2, i3, i4, i5, i6);
                    } else if (i6 == 0) {
                        try {
                            viewParentH.onNestedScroll(viewGroup, i2, i3, i4, i5);
                        } catch (AbstractMethodError e2) {
                            Log.e("ViewParentCompat", "ViewParent " + viewParentH + " does not implement interface method onNestedScroll", e2);
                        }
                    }
                }
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - i7;
                    iArr[1] = iArr[1] - i8;
                }
                return true;
            }
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                return false;
            }
        }
        return false;
    }

    public final ViewParent h(int i2) {
        if (i2 == 0) {
            return this.f3054a;
        }
        if (i2 != 1) {
            return null;
        }
        return this.f3055b;
    }

    public final boolean i() {
        return j(0);
    }

    public final boolean j(int i2) {
        return h(i2) != null;
    }

    public final boolean k() {
        return this.f3057d;
    }

    public final void l(boolean z) {
        if (this.f3057d) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            ViewCompat.Api21Impl.r(this.f3056c);
        }
        this.f3057d = z;
    }

    public final boolean m(int i2) {
        return n(i2, 0);
    }

    public final boolean n(int i2, int i3) {
        boolean zOnStartNestedScroll;
        if (!j(i3)) {
            if (this.f3057d) {
                View view = this.f3056c;
                View view2 = view;
                for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                    boolean z = parent instanceof NestedScrollingParent2;
                    if (z) {
                        zOnStartNestedScroll = ((NestedScrollingParent2) parent).o(view2, view, i2, i3);
                    } else if (i3 == 0) {
                        try {
                            zOnStartNestedScroll = parent.onStartNestedScroll(view2, view, i2);
                        } catch (AbstractMethodError e2) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e2);
                        }
                    } else {
                        zOnStartNestedScroll = false;
                    }
                    if (zOnStartNestedScroll) {
                        if (i3 == 0) {
                            this.f3054a = parent;
                        } else if (i3 == 1) {
                            this.f3055b = parent;
                        }
                        if (z) {
                            ((NestedScrollingParent2) parent).j(view2, view, i2, i3);
                        } else if (i3 == 0) {
                            try {
                                parent.onNestedScrollAccepted(view2, view, i2);
                            } catch (AbstractMethodError e3) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e3);
                            }
                        }
                    } else {
                        if (parent instanceof View) {
                            view2 = parent;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void o() {
        p(0);
    }

    public final void p(int i2) {
        ViewParent viewParentH = h(i2);
        if (viewParentH != null) {
            boolean z = viewParentH instanceof NestedScrollingParent2;
            ViewGroup viewGroup = this.f3056c;
            if (z) {
                ((NestedScrollingParent2) viewParentH).i(i2, viewGroup);
            } else if (i2 == 0) {
                try {
                    viewParentH.onStopNestedScroll(viewGroup);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentH + " does not implement interface method onStopNestedScroll", e2);
                }
            }
            if (i2 == 0) {
                this.f3054a = null;
            } else {
                if (i2 != 1) {
                    return;
                }
                this.f3055b = null;
            }
        }
    }
}

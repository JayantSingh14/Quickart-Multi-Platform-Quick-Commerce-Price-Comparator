package androidx.customview.widget;

import android.graphics.Rect;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes3.dex */
class FocusStrategy {

    /* loaded from: classes.dex */
    public interface BoundsAdapter<T> {
    }

    /* loaded from: classes.dex */
    public interface CollectionAdapter<T, V> {
    }

    public static class SequentialComparator<T> implements Comparator<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Rect f3336a = new Rect();

        /* renamed from: b, reason: collision with root package name */
        public final Rect f3337b = new Rect();

        /* renamed from: c, reason: collision with root package name */
        public final boolean f3338c;

        /* renamed from: d, reason: collision with root package name */
        public final BoundsAdapter f3339d;

        public SequentialComparator(boolean z, BoundsAdapter boundsAdapter) {
            this.f3338c = z;
            this.f3339d = boundsAdapter;
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            ExploreByTouchHelper.AnonymousClass1 anonymousClass1 = (ExploreByTouchHelper.AnonymousClass1) this.f3339d;
            Rect rect = this.f3336a;
            anonymousClass1.a(obj, rect);
            Rect rect2 = this.f3337b;
            anonymousClass1.a(obj2, rect2);
            int i2 = rect.top;
            int i3 = rect2.top;
            if (i2 < i3) {
                return -1;
            }
            if (i2 > i3) {
                return 1;
            }
            int i4 = rect.left;
            int i5 = rect2.left;
            boolean z = this.f3338c;
            if (i4 < i5) {
                return z ? 1 : -1;
            }
            if (i4 > i5) {
                return z ? -1 : 1;
            }
            int i6 = rect.bottom;
            int i7 = rect2.bottom;
            if (i6 < i7) {
                return -1;
            }
            if (i6 > i7) {
                return 1;
            }
            int i8 = rect.right;
            int i9 = rect2.right;
            if (i8 < i9) {
                return z ? 1 : -1;
            }
            if (i8 > i9) {
                return z ? -1 : 1;
            }
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(int r8, android.graphics.Rect r9, android.graphics.Rect r10, android.graphics.Rect r11) {
        /*
            boolean r0 = b(r8, r9, r10)
            boolean r1 = b(r8, r9, r11)
            if (r1 != 0) goto L75
            if (r0 != 0) goto Le
            goto L75
        Le:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r2 = 33
            r3 = 66
            r4 = 17
            r5 = 1
            if (r8 == r4) goto L3c
            if (r8 == r2) goto L35
            if (r8 == r3) goto L2e
            if (r8 != r1) goto L28
            int r6 = r9.bottom
            int r7 = r11.top
            if (r6 > r7) goto L74
            goto L42
        L28:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r0)
            throw r8
        L2e:
            int r6 = r9.right
            int r7 = r11.left
            if (r6 > r7) goto L74
            goto L42
        L35:
            int r6 = r9.top
            int r7 = r11.bottom
            if (r6 < r7) goto L74
            goto L42
        L3c:
            int r6 = r9.left
            int r7 = r11.right
            if (r6 < r7) goto L74
        L42:
            if (r8 == r4) goto L74
            if (r8 != r3) goto L47
            goto L74
        L47:
            int r10 = f(r8, r9, r10)
            if (r8 == r4) goto L69
            if (r8 == r2) goto L64
            if (r8 == r3) goto L5f
            if (r8 != r1) goto L59
            int r8 = r11.bottom
            int r9 = r9.bottom
        L57:
            int r8 = r8 - r9
            goto L6e
        L59:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r0)
            throw r8
        L5f:
            int r8 = r11.right
            int r9 = r9.right
            goto L57
        L64:
            int r8 = r9.top
            int r9 = r11.top
            goto L57
        L69:
            int r8 = r9.left
            int r9 = r11.left
            goto L57
        L6e:
            int r8 = java.lang.Math.max(r5, r8)
            if (r10 >= r8) goto L75
        L74:
            return r5
        L75:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.FocusStrategy.a(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static boolean b(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object c(androidx.collection.SparseArrayCompat r10, androidx.customview.widget.FocusStrategy.CollectionAdapter r11, androidx.customview.widget.FocusStrategy.BoundsAdapter r12, androidx.core.view.accessibility.AccessibilityNodeInfoCompat r13, android.graphics.Rect r14, int r15) {
        /*
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>(r14)
            r1 = 17
            r2 = 0
            if (r15 == r1) goto L3e
            r1 = 33
            if (r15 == r1) goto L34
            r1 = 66
            if (r15 == r1) goto L29
            r1 = 130(0x82, float:1.82E-43)
            if (r15 != r1) goto L21
            int r1 = r14.height()
            int r1 = r1 + 1
            int r1 = -r1
            r0.offset(r2, r1)
            goto L47
        L21:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r10.<init>(r11)
            throw r10
        L29:
            int r1 = r14.width()
            int r1 = r1 + 1
            int r1 = -r1
            r0.offset(r1, r2)
            goto L47
        L34:
            int r1 = r14.height()
            int r1 = r1 + 1
            r0.offset(r2, r1)
            goto L47
        L3e:
            int r1 = r14.width()
            int r1 = r1 + 1
            r0.offset(r1, r2)
        L47:
            r1 = r11
            androidx.customview.widget.ExploreByTouchHelper$2 r1 = (androidx.customview.widget.ExploreByTouchHelper.AnonymousClass2) r1
            r1.getClass()
            int r1 = r10.f1608c
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            r4 = 0
        L55:
            if (r2 >= r1) goto La9
            r5 = r11
            androidx.customview.widget.ExploreByTouchHelper$2 r5 = (androidx.customview.widget.ExploreByTouchHelper.AnonymousClass2) r5
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat r5 = r5.a(r10, r2)
            if (r5 != r13) goto L61
            goto La6
        L61:
            r6 = r12
            androidx.customview.widget.ExploreByTouchHelper$1 r6 = (androidx.customview.widget.ExploreByTouchHelper.AnonymousClass1) r6
            r6.getClass()
            r5.g(r3)
            boolean r6 = e(r15, r14, r3)
            if (r6 != 0) goto L71
            goto La6
        L71:
            boolean r6 = e(r15, r14, r0)
            if (r6 != 0) goto L78
            goto La2
        L78:
            boolean r6 = a(r15, r14, r3, r0)
            if (r6 == 0) goto L7f
            goto La2
        L7f:
            boolean r6 = a(r15, r14, r0, r3)
            if (r6 == 0) goto L86
            goto La6
        L86:
            int r6 = f(r15, r14, r3)
            int r7 = g(r15, r14, r3)
            int r8 = r6 * 13
            int r8 = r8 * r6
            int r7 = r7 * r7
            int r7 = r7 + r8
            int r6 = f(r15, r14, r0)
            int r8 = g(r15, r14, r0)
            int r9 = r6 * 13
            int r9 = r9 * r6
            int r8 = r8 * r8
            int r8 = r8 + r9
            if (r7 >= r8) goto La6
        La2:
            r0.set(r3)
            r4 = r5
        La6:
            int r2 = r2 + 1
            goto L55
        La9:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.FocusStrategy.c(androidx.collection.SparseArrayCompat, androidx.customview.widget.FocusStrategy$CollectionAdapter, androidx.customview.widget.FocusStrategy$BoundsAdapter, androidx.core.view.accessibility.AccessibilityNodeInfoCompat, android.graphics.Rect, int):java.lang.Object");
    }

    public static Object d(SparseArrayCompat sparseArrayCompat, CollectionAdapter collectionAdapter, BoundsAdapter boundsAdapter, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, int i2, boolean z) {
        ((ExploreByTouchHelper.AnonymousClass2) collectionAdapter).getClass();
        int i3 = sparseArrayCompat.f1608c;
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            arrayList.add(((ExploreByTouchHelper.AnonymousClass2) collectionAdapter).a(sparseArrayCompat, i4));
        }
        Collections.sort(arrayList, new SequentialComparator(z, boundsAdapter));
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
            }
            int size = arrayList.size();
            int iLastIndexOf = (accessibilityNodeInfoCompat == null ? -1 : arrayList.lastIndexOf(accessibilityNodeInfoCompat)) + 1;
            if (iLastIndexOf < size) {
                return arrayList.get(iLastIndexOf);
            }
            return null;
        }
        int size2 = arrayList.size();
        if (accessibilityNodeInfoCompat != null) {
            size2 = arrayList.indexOf(accessibilityNodeInfoCompat);
        }
        int i5 = size2 - 1;
        if (i5 >= 0) {
            return arrayList.get(i5);
        }
        return null;
    }

    public static boolean e(int i2, Rect rect, Rect rect2) {
        if (i2 == 17) {
            int i3 = rect.right;
            int i4 = rect2.right;
            return (i3 > i4 || rect.left >= i4) && rect.left > rect2.left;
        }
        if (i2 == 33) {
            int i5 = rect.bottom;
            int i6 = rect2.bottom;
            return (i5 > i6 || rect.top >= i6) && rect.top > rect2.top;
        }
        if (i2 == 66) {
            int i7 = rect.left;
            int i8 = rect2.left;
            return (i7 < i8 || rect.right <= i8) && rect.right < rect2.right;
        }
        if (i2 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i9 = rect.top;
        int i10 = rect2.top;
        return (i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom;
    }

    public static int f(int i2, Rect rect, Rect rect2) {
        int i3;
        int i4;
        if (i2 == 17) {
            i3 = rect.left;
            i4 = rect2.right;
        } else if (i2 == 33) {
            i3 = rect.top;
            i4 = rect2.bottom;
        } else if (i2 == 66) {
            i3 = rect2.left;
            i4 = rect.right;
        } else {
            if (i2 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i3 = rect2.top;
            i4 = rect.bottom;
        }
        return Math.max(0, i3 - i4);
    }

    public static int g(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }
}

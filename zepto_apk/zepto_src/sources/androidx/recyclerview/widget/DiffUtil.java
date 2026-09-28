package androidx.recyclerview.widget;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class DiffUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final Comparator f11426a = new AnonymousClass1();

    /* renamed from: androidx.recyclerview.widget.DiffUtil$1, reason: invalid class name */
    public class AnonymousClass1 implements Comparator<Diagonal> {
        @Override // java.util.Comparator
        public final int compare(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.f11429a - diagonal2.f11429a;
        }
    }

    public static abstract class Callback {
        public abstract boolean a(int i2, int i3);

        public abstract boolean b(int i2, int i3);

        public Object c(int i2, int i3) {
            return null;
        }

        public abstract int d();

        public abstract int e();
    }

    public static class CenteredArray {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f11427a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11428b;

        public CenteredArray(int i2) {
            int[] iArr = new int[i2];
            this.f11427a = iArr;
            this.f11428b = iArr.length / 2;
        }

        public final int a(int i2) {
            return this.f11427a[i2 + this.f11428b];
        }
    }

    public static class Diagonal {

        /* renamed from: a, reason: collision with root package name */
        public final int f11429a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11430b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11431c;

        public Diagonal(int i2, int i3, int i4) {
            this.f11429a = i2;
            this.f11430b = i3;
            this.f11431c = i4;
        }
    }

    public static class DiffResult {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f11432a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f11433b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f11434c;

        /* renamed from: d, reason: collision with root package name */
        public final Callback f11435d;

        /* renamed from: e, reason: collision with root package name */
        public final int f11436e;

        /* renamed from: f, reason: collision with root package name */
        public final int f11437f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f11438g;

        public DiffResult(Callback callback, ArrayList arrayList, int[] iArr, int[] iArr2) {
            int[] iArr3;
            int[] iArr4;
            Callback callback2;
            int i2;
            Diagonal diagonal;
            int i3;
            this.f11432a = arrayList;
            this.f11433b = iArr;
            this.f11434c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f11435d = callback;
            int iE = callback.e();
            this.f11436e = iE;
            int iD = callback.d();
            this.f11437f = iD;
            this.f11438g = true;
            Diagonal diagonal2 = arrayList.isEmpty() ? null : (Diagonal) arrayList.get(0);
            if (diagonal2 == null || diagonal2.f11429a != 0 || diagonal2.f11430b != 0) {
                arrayList.add(0, new Diagonal(0, 0, 0));
            }
            arrayList.add(new Diagonal(iE, iD, 0));
            Iterator it = arrayList.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                iArr3 = this.f11434c;
                iArr4 = this.f11433b;
                callback2 = this.f11435d;
                if (!zHasNext) {
                    break;
                }
                Diagonal diagonal3 = (Diagonal) it.next();
                for (int i4 = 0; i4 < diagonal3.f11431c; i4++) {
                    int i5 = diagonal3.f11429a + i4;
                    int i6 = diagonal3.f11430b + i4;
                    int i7 = callback2.a(i5, i6) ? 1 : 2;
                    iArr4[i5] = (i6 << 4) | i7;
                    iArr3[i6] = (i5 << 4) | i7;
                }
            }
            if (this.f11438g) {
                Iterator it2 = arrayList.iterator();
                int i8 = 0;
                while (it2.hasNext()) {
                    Diagonal diagonal4 = (Diagonal) it2.next();
                    while (true) {
                        i2 = diagonal4.f11429a;
                        if (i8 < i2) {
                            if (iArr4[i8] == 0) {
                                int size = arrayList.size();
                                int i9 = 0;
                                int i10 = 0;
                                while (true) {
                                    if (i9 < size) {
                                        diagonal = (Diagonal) arrayList.get(i9);
                                        while (true) {
                                            i3 = diagonal.f11430b;
                                            if (i10 < i3) {
                                                if (iArr3[i10] == 0 && callback2.b(i8, i10)) {
                                                    int i11 = callback2.a(i8, i10) ? 8 : 4;
                                                    iArr4[i8] = (i10 << 4) | i11;
                                                    iArr3[i10] = i11 | (i8 << 4);
                                                } else {
                                                    i10++;
                                                }
                                            }
                                        }
                                    }
                                    i10 = diagonal.f11431c + i3;
                                    i9++;
                                }
                            }
                            i8++;
                        }
                    }
                    i8 = diagonal4.f11431c + i2;
                }
            }
        }

        public static PostponedUpdate a(ArrayDeque arrayDeque, int i2, boolean z) {
            PostponedUpdate postponedUpdate;
            Iterator it = arrayDeque.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postponedUpdate = null;
                    break;
                }
                postponedUpdate = (PostponedUpdate) it.next();
                if (postponedUpdate.f11439a == i2 && postponedUpdate.f11441c == z) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                PostponedUpdate postponedUpdate2 = (PostponedUpdate) it.next();
                if (z) {
                    postponedUpdate2.f11440b--;
                } else {
                    postponedUpdate2.f11440b++;
                }
            }
            return postponedUpdate;
        }
    }

    public static abstract class ItemCallback<T> {
    }

    public static class PostponedUpdate {

        /* renamed from: a, reason: collision with root package name */
        public final int f11439a;

        /* renamed from: b, reason: collision with root package name */
        public int f11440b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f11441c;

        public PostponedUpdate(int i2, int i3, boolean z) {
            this.f11439a = i2;
            this.f11440b = i3;
            this.f11441c = z;
        }
    }

    public static class Range {

        /* renamed from: a, reason: collision with root package name */
        public int f11442a;

        /* renamed from: b, reason: collision with root package name */
        public int f11443b;

        /* renamed from: c, reason: collision with root package name */
        public int f11444c;

        /* renamed from: d, reason: collision with root package name */
        public int f11445d;

        public final int a() {
            return this.f11445d - this.f11444c;
        }

        public final int b() {
            return this.f11443b - this.f11442a;
        }
    }

    public static class Snake {

        /* renamed from: a, reason: collision with root package name */
        public int f11446a;

        /* renamed from: b, reason: collision with root package name */
        public int f11447b;

        /* renamed from: c, reason: collision with root package name */
        public int f11448c;

        /* renamed from: d, reason: collision with root package name */
        public int f11449d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f11450e;

        public final int a() {
            return Math.min(this.f11448c - this.f11446a, this.f11449d - this.f11447b);
        }
    }
}

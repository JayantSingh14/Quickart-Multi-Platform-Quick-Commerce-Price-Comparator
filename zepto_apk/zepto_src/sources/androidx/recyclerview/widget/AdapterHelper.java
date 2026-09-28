package androidx.recyclerview.widget;

import android.support.v4.media.b;
import androidx.core.util.Pools;
import androidx.recyclerview.widget.OpReorderer;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
final class AdapterHelper implements OpReorderer.Callback {

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView.AnonymousClass6 f11341d;

    /* renamed from: a, reason: collision with root package name */
    public final Pools.SimplePool f11338a = new Pools.SimplePool(30);

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f11339b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f11340c = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public int f11343f = 0;

    /* renamed from: e, reason: collision with root package name */
    public final OpReorderer f11342e = new OpReorderer(this);

    public interface Callback {
    }

    public static final class UpdateOp {

        /* renamed from: a, reason: collision with root package name */
        public int f11344a;

        /* renamed from: b, reason: collision with root package name */
        public int f11345b;

        /* renamed from: c, reason: collision with root package name */
        public Object f11346c;

        /* renamed from: d, reason: collision with root package name */
        public int f11347d;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof UpdateOp)) {
                    return false;
                }
                UpdateOp updateOp = (UpdateOp) obj;
                int i2 = this.f11344a;
                if (i2 != updateOp.f11344a) {
                    return false;
                }
                if (i2 != 8 || Math.abs(this.f11347d - this.f11345b) != 1 || this.f11347d != updateOp.f11345b || this.f11345b != updateOp.f11347d) {
                    if (this.f11347d != updateOp.f11347d || this.f11345b != updateOp.f11345b) {
                        return false;
                    }
                    Object obj2 = this.f11346c;
                    if (obj2 != null) {
                        if (!obj2.equals(updateOp.f11346c)) {
                            return false;
                        }
                    } else if (updateOp.f11346c != null) {
                        return false;
                    }
                }
            }
            return true;
        }

        public final int hashCode() {
            return (((this.f11344a * 31) + this.f11345b) * 31) + this.f11347d;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int i2 = this.f11344a;
            sb.append(i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? "??" : "mv" : "up" : "rm" : "add");
            sb.append(",s:");
            sb.append(this.f11345b);
            sb.append("c:");
            sb.append(this.f11347d);
            sb.append(",p:");
            return b.q(sb, this.f11346c, "]");
        }
    }

    public AdapterHelper(RecyclerView.AnonymousClass6 anonymousClass6) {
        this.f11341d = anonymousClass6;
    }

    public final boolean a(int i2) {
        ArrayList arrayList = this.f11340c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            UpdateOp updateOp = (UpdateOp) arrayList.get(i3);
            int i4 = updateOp.f11344a;
            if (i4 != 8) {
                if (i4 == 1) {
                    int i5 = updateOp.f11345b;
                    int i6 = updateOp.f11347d + i5;
                    while (i5 < i6) {
                        if (f(i5, i3 + 1) == i2) {
                            return true;
                        }
                        i5++;
                    }
                } else {
                    continue;
                }
            } else {
                if (f(updateOp.f11347d, i3 + 1) == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void b() {
        ArrayList arrayList = this.f11340c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f11341d.a((UpdateOp) arrayList.get(i2));
        }
        k(arrayList);
        this.f11343f = 0;
    }

    public final void c() {
        b();
        ArrayList arrayList = this.f11339b;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = (UpdateOp) arrayList.get(i2);
            int i3 = updateOp.f11344a;
            RecyclerView.AnonymousClass6 anonymousClass6 = this.f11341d;
            if (i3 == 1) {
                anonymousClass6.a(updateOp);
                anonymousClass6.d(updateOp.f11345b, updateOp.f11347d);
            } else if (i3 == 2) {
                anonymousClass6.a(updateOp);
                anonymousClass6.f(updateOp.f11345b, updateOp.f11347d);
            } else if (i3 == 4) {
                anonymousClass6.a(updateOp);
                anonymousClass6.c(updateOp.f11345b, updateOp.f11347d, updateOp.f11346c);
            } else if (i3 == 8) {
                anonymousClass6.a(updateOp);
                anonymousClass6.e(updateOp.f11345b, updateOp.f11347d);
            }
        }
        k(arrayList);
        this.f11343f = 0;
    }

    public final void d(UpdateOp updateOp) {
        int i2;
        int i3 = updateOp.f11344a;
        if (i3 == 1 || i3 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iL = l(updateOp.f11345b, i3);
        int i4 = updateOp.f11345b;
        int i5 = updateOp.f11344a;
        if (i5 == 2) {
            i2 = 0;
        } else {
            if (i5 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + updateOp);
            }
            i2 = 1;
        }
        int i6 = 1;
        for (int i7 = 1; i7 < updateOp.f11347d; i7++) {
            int iL2 = l((i2 * i7) + updateOp.f11345b, updateOp.f11344a);
            int i8 = updateOp.f11344a;
            if (i8 == 2 ? iL2 != iL : !(i8 == 4 && iL2 == iL + 1)) {
                UpdateOp updateOpH = h(updateOp.f11346c, i8, iL, i6);
                e(updateOpH, i4);
                updateOpH.f11346c = null;
                this.f11338a.a(updateOpH);
                if (updateOp.f11344a == 4) {
                    i4 += i6;
                }
                i6 = 1;
                iL = iL2;
            } else {
                i6++;
            }
        }
        Object obj = updateOp.f11346c;
        updateOp.f11346c = null;
        this.f11338a.a(updateOp);
        if (i6 > 0) {
            UpdateOp updateOpH2 = h(obj, updateOp.f11344a, iL, i6);
            e(updateOpH2, i4);
            updateOpH2.f11346c = null;
            this.f11338a.a(updateOpH2);
        }
    }

    public final void e(UpdateOp updateOp, int i2) {
        RecyclerView.AnonymousClass6 anonymousClass6 = this.f11341d;
        anonymousClass6.a(updateOp);
        int i3 = updateOp.f11344a;
        if (i3 == 2) {
            anonymousClass6.f(i2, updateOp.f11347d);
        } else {
            if (i3 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            anonymousClass6.c(i2, updateOp.f11347d, updateOp.f11346c);
        }
    }

    public final int f(int i2, int i3) {
        ArrayList arrayList = this.f11340c;
        int size = arrayList.size();
        while (i3 < size) {
            UpdateOp updateOp = (UpdateOp) arrayList.get(i3);
            int i4 = updateOp.f11344a;
            if (i4 == 8) {
                int i5 = updateOp.f11345b;
                if (i5 == i2) {
                    i2 = updateOp.f11347d;
                } else {
                    if (i5 < i2) {
                        i2--;
                    }
                    if (updateOp.f11347d <= i2) {
                        i2++;
                    }
                }
            } else {
                int i6 = updateOp.f11345b;
                if (i6 > i2) {
                    continue;
                } else if (i4 == 2) {
                    int i7 = updateOp.f11347d;
                    if (i2 < i6 + i7) {
                        return -1;
                    }
                    i2 -= i7;
                } else if (i4 == 1) {
                    i2 += updateOp.f11347d;
                }
            }
            i3++;
        }
        return i2;
    }

    public final boolean g() {
        return this.f11339b.size() > 0;
    }

    public final UpdateOp h(Object obj, int i2, int i3, int i4) {
        UpdateOp updateOp = (UpdateOp) this.f11338a.b();
        if (updateOp != null) {
            updateOp.f11344a = i2;
            updateOp.f11345b = i3;
            updateOp.f11347d = i4;
            updateOp.f11346c = obj;
            return updateOp;
        }
        UpdateOp updateOp2 = new UpdateOp();
        updateOp2.f11344a = i2;
        updateOp2.f11345b = i3;
        updateOp2.f11347d = i4;
        updateOp2.f11346c = obj;
        return updateOp2;
    }

    public final void i(UpdateOp updateOp) {
        this.f11340c.add(updateOp);
        int i2 = updateOp.f11344a;
        RecyclerView.AnonymousClass6 anonymousClass6 = this.f11341d;
        if (i2 == 1) {
            anonymousClass6.d(updateOp.f11345b, updateOp.f11347d);
            return;
        }
        if (i2 == 2) {
            int i3 = updateOp.f11345b;
            int i4 = updateOp.f11347d;
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.V(i3, i4, false);
            recyclerView.U0 = true;
            return;
        }
        if (i2 == 4) {
            anonymousClass6.c(updateOp.f11345b, updateOp.f11347d, updateOp.f11346c);
        } else if (i2 == 8) {
            anonymousClass6.e(updateOp.f11345b, updateOp.f11347d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + updateOp);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x009f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0111 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instructions count: 665
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.AdapterHelper.j():void");
    }

    public final void k(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = (UpdateOp) arrayList.get(i2);
            updateOp.f11346c = null;
            this.f11338a.a(updateOp);
        }
        arrayList.clear();
    }

    public final int l(int i2, int i3) {
        int i4;
        int i5;
        ArrayList arrayList = this.f11340c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = (UpdateOp) arrayList.get(size);
            int i6 = updateOp.f11344a;
            if (i6 == 8) {
                int i7 = updateOp.f11345b;
                int i8 = updateOp.f11347d;
                if (i7 < i8) {
                    i5 = i7;
                    i4 = i8;
                } else {
                    i4 = i7;
                    i5 = i8;
                }
                if (i2 < i5 || i2 > i4) {
                    if (i2 < i7) {
                        if (i3 == 1) {
                            updateOp.f11345b = i7 + 1;
                            updateOp.f11347d = i8 + 1;
                        } else if (i3 == 2) {
                            updateOp.f11345b = i7 - 1;
                            updateOp.f11347d = i8 - 1;
                        }
                    }
                } else if (i5 == i7) {
                    if (i3 == 1) {
                        updateOp.f11347d = i8 + 1;
                    } else if (i3 == 2) {
                        updateOp.f11347d = i8 - 1;
                    }
                    i2++;
                } else {
                    if (i3 == 1) {
                        updateOp.f11345b = i7 + 1;
                    } else if (i3 == 2) {
                        updateOp.f11345b = i7 - 1;
                    }
                    i2--;
                }
            } else {
                int i9 = updateOp.f11345b;
                if (i9 <= i2) {
                    if (i6 == 1) {
                        i2 -= updateOp.f11347d;
                    } else if (i6 == 2) {
                        i2 += updateOp.f11347d;
                    }
                } else if (i3 == 1) {
                    updateOp.f11345b = i9 + 1;
                } else if (i3 == 2) {
                    updateOp.f11345b = i9 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = (UpdateOp) arrayList.get(size2);
            if (updateOp2.f11344a == 8) {
                int i10 = updateOp2.f11347d;
                if (i10 == updateOp2.f11345b || i10 < 0) {
                    arrayList.remove(size2);
                    updateOp2.f11346c = null;
                    this.f11338a.a(updateOp2);
                }
            } else if (updateOp2.f11347d <= 0) {
                arrayList.remove(size2);
                updateOp2.f11346c = null;
                this.f11338a.a(updateOp2);
            }
        }
        return i2;
    }
}

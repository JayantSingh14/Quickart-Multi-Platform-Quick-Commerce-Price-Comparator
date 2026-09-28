package androidx.media3.exoplayer.source;

import android.util.SparseArray;
import androidx.media3.common.util.Consumer;

/* loaded from: classes3.dex */
final class SpannedData<V> {

    /* renamed from: a, reason: collision with root package name */
    public int f7760a;

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f7761b;

    /* renamed from: c, reason: collision with root package name */
    public final Consumer f7762c;

    public SpannedData() {
        this(new l(3));
    }

    public final Object a(int i2) {
        SparseArray sparseArray;
        if (this.f7760a == -1) {
            this.f7760a = 0;
        }
        while (true) {
            int i3 = this.f7760a;
            sparseArray = this.f7761b;
            if (i3 <= 0 || i2 >= sparseArray.keyAt(i3)) {
                break;
            }
            this.f7760a--;
        }
        while (this.f7760a < sparseArray.size() - 1 && i2 >= sparseArray.keyAt(this.f7760a + 1)) {
            this.f7760a++;
        }
        return sparseArray.valueAt(this.f7760a);
    }

    public SpannedData(Consumer consumer) {
        this.f7761b = new SparseArray();
        this.f7762c = consumer;
        this.f7760a = -1;
    }
}

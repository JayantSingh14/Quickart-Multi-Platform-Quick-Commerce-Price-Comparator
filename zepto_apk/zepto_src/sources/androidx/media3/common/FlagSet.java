package androidx.media3.common;

import android.util.SparseBooleanArray;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
/* loaded from: classes3.dex */
public final class FlagSet {

    /* renamed from: a, reason: collision with root package name */
    public final SparseBooleanArray f5210a;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final SparseBooleanArray f5211a = new SparseBooleanArray();

        /* renamed from: b, reason: collision with root package name */
        public boolean f5212b;

        public final void a(int i2) {
            Assertions.g(!this.f5212b);
            this.f5211a.append(i2, true);
        }

        public final void b(int... iArr) {
            for (int i2 : iArr) {
                a(i2);
            }
        }

        public final FlagSet c() {
            Assertions.g(!this.f5212b);
            this.f5212b = true;
            return new FlagSet(this.f5211a);
        }
    }

    public FlagSet(SparseBooleanArray sparseBooleanArray) {
        this.f5210a = sparseBooleanArray;
    }

    public final boolean a(int... iArr) {
        for (int i2 : iArr) {
            if (this.f5210a.get(i2)) {
                return true;
            }
        }
        return false;
    }

    public final int b(int i2) {
        SparseBooleanArray sparseBooleanArray = this.f5210a;
        Assertions.c(i2, sparseBooleanArray.size());
        return sparseBooleanArray.keyAt(i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlagSet)) {
            return false;
        }
        FlagSet flagSet = (FlagSet) obj;
        int i2 = Util.f5744a;
        SparseBooleanArray sparseBooleanArray = this.f5210a;
        if (i2 >= 24) {
            return sparseBooleanArray.equals(flagSet.f5210a);
        }
        if (sparseBooleanArray.size() != flagSet.f5210a.size()) {
            return false;
        }
        for (int i3 = 0; i3 < sparseBooleanArray.size(); i3++) {
            if (b(i3) != flagSet.b(i3)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = Util.f5744a;
        SparseBooleanArray sparseBooleanArray = this.f5210a;
        if (i2 >= 24) {
            return sparseBooleanArray.hashCode();
        }
        int size = sparseBooleanArray.size();
        for (int i3 = 0; i3 < sparseBooleanArray.size(); i3++) {
            size = (size * 31) + b(i3);
        }
        return size;
    }
}

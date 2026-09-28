package androidx.constraintlayout.core;

import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class SolverVariable implements Comparable<SolverVariable> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1692a;

    /* renamed from: e, reason: collision with root package name */
    public float f1696e;

    /* renamed from: i, reason: collision with root package name */
    public Type f1700i;

    /* renamed from: b, reason: collision with root package name */
    public int f1693b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f1694c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f1695d = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1697f = false;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f1698g = new float[9];

    /* renamed from: h, reason: collision with root package name */
    public final float[] f1699h = new float[9];

    /* renamed from: j, reason: collision with root package name */
    public ArrayRow[] f1701j = new ArrayRow[16];

    /* renamed from: k, reason: collision with root package name */
    public int f1702k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f1703l = 0;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Type {

        /* renamed from: a, reason: collision with root package name */
        public static final Type f1704a;

        /* renamed from: b, reason: collision with root package name */
        public static final Type f1705b;

        /* renamed from: c, reason: collision with root package name */
        public static final Type f1706c;

        /* renamed from: d, reason: collision with root package name */
        public static final Type f1707d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ Type[] f1708e;

        static {
            Type type = new Type("UNRESTRICTED", 0);
            f1704a = type;
            Type type2 = new Type("CONSTANT", 1);
            Type type3 = new Type("SLACK", 2);
            f1705b = type3;
            Type type4 = new Type(MerchantConstants.ERROR, 3);
            f1706c = type4;
            Type type5 = new Type("UNKNOWN", 4);
            f1707d = type5;
            f1708e = new Type[]{type, type2, type3, type4, type5};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f1708e.clone();
        }
    }

    public SolverVariable(Type type) {
        this.f1700i = type;
    }

    public final void a(ArrayRow arrayRow) {
        int i2 = 0;
        while (true) {
            int i3 = this.f1702k;
            if (i2 >= i3) {
                ArrayRow[] arrayRowArr = this.f1701j;
                if (i3 >= arrayRowArr.length) {
                    this.f1701j = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.f1701j;
                int i4 = this.f1702k;
                arrayRowArr2[i4] = arrayRow;
                this.f1702k = i4 + 1;
                return;
            }
            if (this.f1701j[i2] == arrayRow) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final void b(ArrayRow arrayRow) {
        int i2 = this.f1702k;
        int i3 = 0;
        while (i3 < i2) {
            if (this.f1701j[i3] == arrayRow) {
                while (i3 < i2 - 1) {
                    ArrayRow[] arrayRowArr = this.f1701j;
                    int i4 = i3 + 1;
                    arrayRowArr[i3] = arrayRowArr[i4];
                    i3 = i4;
                }
                this.f1702k--;
                return;
            }
            i3++;
        }
    }

    public final void c() {
        this.f1700i = Type.f1707d;
        this.f1695d = 0;
        this.f1693b = -1;
        this.f1694c = -1;
        this.f1696e = 0.0f;
        this.f1697f = false;
        int i2 = this.f1702k;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f1701j[i3] = null;
        }
        this.f1702k = 0;
        this.f1703l = 0;
        this.f1692a = false;
        Arrays.fill(this.f1699h, 0.0f);
    }

    @Override // java.lang.Comparable
    public final int compareTo(SolverVariable solverVariable) {
        return this.f1693b - solverVariable.f1693b;
    }

    public final void d(LinearSystem linearSystem, float f2) {
        this.f1696e = f2;
        this.f1697f = true;
        int i2 = this.f1702k;
        this.f1694c = -1;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f1701j[i3].h(linearSystem, this, false);
        }
        this.f1702k = 0;
    }

    public final void e(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i2 = this.f1702k;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f1701j[i3].i(linearSystem, arrayRow, false);
        }
        this.f1702k = 0;
    }

    public final String toString() {
        return "" + this.f1693b;
    }
}

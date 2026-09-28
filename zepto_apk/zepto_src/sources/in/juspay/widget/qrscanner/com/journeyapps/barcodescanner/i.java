package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public class i implements Comparable<i> {

    /* renamed from: a, reason: collision with root package name */
    public final int f49078a;

    /* renamed from: b, reason: collision with root package name */
    public final int f49079b;

    public i(int i2, int i3) {
        this.f49078a = i2;
        this.f49079b = i3;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull i iVar) {
        int i2 = this.f49079b * this.f49078a;
        int i3 = iVar.f49079b * iVar.f49078a;
        if (i3 < i2) {
            return 1;
        }
        return i3 > i2 ? -1 : 0;
    }

    public i b(i iVar) {
        int i2 = this.f49078a;
        int i3 = iVar.f49079b;
        int i4 = i2 * i3;
        int i5 = iVar.f49078a;
        int i6 = this.f49079b;
        int i7 = i5 * i6;
        return i4 <= i7 ? new i(i5, i7 / i2) : new i(i4 / i6, i3);
    }

    public i c(i iVar) {
        int i2 = this.f49078a;
        int i3 = iVar.f49079b;
        int i4 = i2 * i3;
        int i5 = iVar.f49078a;
        int i6 = this.f49079b;
        int i7 = i5 * i6;
        return i4 >= i7 ? new i(i5, i7 / i2) : new i(i4 / i6, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            if (this.f49078a == iVar.f49078a && this.f49079b == iVar.f49079b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f49078a * 31) + this.f49079b;
    }

    public String toString() {
        return this.f49078a + "x" + this.f49079b;
    }

    public i a() {
        return new i(this.f49079b, this.f49078a);
    }
}

package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;

@RestrictTo
/* loaded from: classes3.dex */
class VersionedParcelParcel extends VersionedParcel {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f12300d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f12301e;

    /* renamed from: f, reason: collision with root package name */
    public final int f12302f;

    /* renamed from: g, reason: collision with root package name */
    public final int f12303g;

    /* renamed from: h, reason: collision with root package name */
    public final String f12304h;

    /* renamed from: i, reason: collision with root package name */
    public int f12305i;

    /* renamed from: j, reason: collision with root package name */
    public int f12306j;

    /* renamed from: k, reason: collision with root package name */
    public int f12307k;

    public VersionedParcelParcel(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void a() {
        int i2 = this.f12305i;
        if (i2 >= 0) {
            int i3 = this.f12300d.get(i2);
            Parcel parcel = this.f12301e;
            int iDataPosition = parcel.dataPosition();
            parcel.setDataPosition(i3);
            parcel.writeInt(iDataPosition - i3);
            parcel.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final VersionedParcel b() {
        Parcel parcel = this.f12301e;
        int iDataPosition = parcel.dataPosition();
        int i2 = this.f12306j;
        if (i2 == this.f12302f) {
            i2 = this.f12303g;
        }
        return new VersionedParcelParcel(parcel, iDataPosition, i2, b.r(new StringBuilder(), this.f12304h, "  "), this.f12297a, this.f12298b, this.f12299c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final boolean g() {
        return this.f12301e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final byte[] h() {
        Parcel parcel = this.f12301e;
        int i2 = parcel.readInt();
        if (i2 < 0) {
            return null;
        }
        byte[] bArr = new byte[i2];
        parcel.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final CharSequence i() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f12301e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final boolean j(int i2) {
        while (this.f12306j < this.f12303g) {
            int i3 = this.f12307k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            int i4 = this.f12306j;
            Parcel parcel = this.f12301e;
            parcel.setDataPosition(i4);
            int i5 = parcel.readInt();
            this.f12307k = parcel.readInt();
            this.f12306j += i5;
        }
        return this.f12307k == i2;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final int k() {
        return this.f12301e.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final Parcelable m() {
        return this.f12301e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final String n() {
        return this.f12301e.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void p(int i2) {
        a();
        this.f12305i = i2;
        this.f12300d.put(i2, this.f12301e.dataPosition());
        u(0);
        u(i2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void r(boolean z) {
        this.f12301e.writeInt(z ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void s(byte[] bArr) {
        Parcel parcel = this.f12301e;
        if (bArr == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void t(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f12301e, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void u(int i2) {
        this.f12301e.writeInt(i2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void w(Parcelable parcelable) {
        this.f12301e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void x(String str) {
        this.f12301e.writeString(str);
    }

    public VersionedParcelParcel(Parcel parcel, int i2, int i3, String str, ArrayMap arrayMap, ArrayMap arrayMap2, ArrayMap arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.f12300d = new SparseIntArray();
        this.f12305i = -1;
        this.f12307k = -1;
        this.f12301e = parcel;
        this.f12302f = i2;
        this.f12303g = i3;
        this.f12306j = i2;
        this.f12304h = str;
    }
}

package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo
/* loaded from: classes3.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final VersionedParcelable f12296a;

    /* renamed from: androidx.versionedparcelable.ParcelImpl$1, reason: invalid class name */
    public static class AnonymousClass1 implements Parcelable.Creator<ParcelImpl> {
        @Override // android.os.Parcelable.Creator
        public final ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelImpl[] newArray(int i2) {
            return new ParcelImpl[i2];
        }
    }

    public ParcelImpl(VersionedParcelable versionedParcelable) {
        this.f12296a = versionedParcelable;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        new VersionedParcelParcel(parcel).y(this.f12296a);
    }

    public ParcelImpl(Parcel parcel) {
        this.f12296a = new VersionedParcelParcel(parcel).o();
    }
}

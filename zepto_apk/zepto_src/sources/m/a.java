package m;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.security.InvalidParameterException;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes3.dex */
public final class a implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f56131a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f56130b = new a("0.0.0");
    public static final Parcelable.Creator<a> CREATOR = new C0075a();

    /* renamed from: m.a$a, reason: collision with other inner class name */
    public class C0075a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        public final a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final a[] newArray(int i2) {
            return new a[i2];
        }
    }

    public a(Parcel parcel) {
        int[] iArr = new int[parcel.readInt()];
        this.f56131a = iArr;
        parcel.readIntArray(iArr);
        toString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (true) {
            int[] iArr = this.f56131a;
            if (i2 >= iArr.length) {
                return stringBuffer.substring(0, stringBuffer.length() - 1);
            }
            stringBuffer.append(iArr[i2]);
            stringBuffer.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            i2++;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int[] iArr = this.f56131a;
        int length = iArr.length;
        parcel.writeInt(iArr.length);
        parcel.writeIntArray(iArr);
    }

    public a(String str) {
        if (str != null) {
            String[] strArrSplit = TextUtils.split(str, "\\.");
            this.f56131a = new int[strArrSplit.length];
            int i2 = 0;
            for (String str2 : strArrSplit) {
                try {
                    this.f56131a[i2] = Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                    this.f56131a[i2] = 0;
                }
                i2++;
            }
            return;
        }
        throw new InvalidParameterException("version must not be null");
    }
}

package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class MlltFrame extends Id3Frame {
    public static final Parcelable.Creator<MlltFrame> CREATOR = new AnonymousClass1();

    /* renamed from: b, reason: collision with root package name */
    public final int f8833b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8834c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8835d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f8836e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f8837f;

    /* renamed from: androidx.media3.extractor.metadata.id3.MlltFrame$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<MlltFrame> {
        @Override // android.os.Parcelable.Creator
        public final MlltFrame createFromParcel(Parcel parcel) {
            return new MlltFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final MlltFrame[] newArray(int i2) {
            return new MlltFrame[i2];
        }
    }

    public MlltFrame(int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f8833b = i2;
        this.f8834c = i3;
        this.f8835d = i4;
        this.f8836e = iArr;
        this.f8837f = iArr2;
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MlltFrame.class == obj.getClass()) {
            MlltFrame mlltFrame = (MlltFrame) obj;
            if (this.f8833b == mlltFrame.f8833b && this.f8834c == mlltFrame.f8834c && this.f8835d == mlltFrame.f8835d && Arrays.equals(this.f8836e, mlltFrame.f8836e) && Arrays.equals(this.f8837f, mlltFrame.f8837f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f8837f) + ((Arrays.hashCode(this.f8836e) + ((((((527 + this.f8833b) * 31) + this.f8834c) * 31) + this.f8835d) * 31)) * 31);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f8833b);
        parcel.writeInt(this.f8834c);
        parcel.writeInt(this.f8835d);
        parcel.writeIntArray(this.f8836e);
        parcel.writeIntArray(this.f8837f);
    }

    public MlltFrame(Parcel parcel) {
        super("MLLT");
        this.f8833b = parcel.readInt();
        this.f8834c = parcel.readInt();
        this.f8835d = parcel.readInt();
        int[] iArrCreateIntArray = parcel.createIntArray();
        int i2 = Util.f5744a;
        this.f8836e = iArrCreateIntArray;
        this.f8837f = parcel.createIntArray();
    }
}

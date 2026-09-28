package androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
/* loaded from: classes3.dex */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final long f8856a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8857b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f8858c;

    /* renamed from: androidx.media3.extractor.metadata.scte35.PrivateCommand$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<PrivateCommand> {
        @Override // android.os.Parcelable.Creator
        public final PrivateCommand createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final PrivateCommand[] newArray(int i2) {
            return new PrivateCommand[i2];
        }
    }

    public PrivateCommand(long j2, byte[] bArr, long j3) {
        this.f8856a = j3;
        this.f8857b = j2;
        this.f8858c = bArr;
    }

    @Override // androidx.media3.extractor.metadata.scte35.SpliceCommand
    public final String toString() {
        StringBuilder sb = new StringBuilder("SCTE-35 PrivateCommand { ptsAdjustment=");
        sb.append(this.f8856a);
        sb.append(", identifier= ");
        return b.p(sb, this.f8857b, " }");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f8856a);
        parcel.writeLong(this.f8857b);
        parcel.writeByteArray(this.f8858c);
    }

    public PrivateCommand(Parcel parcel) {
        this.f8856a = parcel.readLong();
        this.f8857b = parcel.readLong();
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i2 = Util.f5744a;
        this.f8858c = bArrCreateByteArray;
    }
}

package androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final long f8892a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8893b;

    /* renamed from: androidx.media3.extractor.metadata.scte35.TimeSignalCommand$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<TimeSignalCommand> {
        @Override // android.os.Parcelable.Creator
        public final TimeSignalCommand createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final TimeSignalCommand[] newArray(int i2) {
            return new TimeSignalCommand[i2];
        }
    }

    public TimeSignalCommand(long j2, long j3) {
        this.f8892a = j2;
        this.f8893b = j3;
    }

    public static long a(long j2, ParsableByteArray parsableByteArray) {
        long jX = parsableByteArray.x();
        if ((128 & jX) != 0) {
            return 8589934591L & ((((jX & 1) << 32) | parsableByteArray.z()) + j2);
        }
        return -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.metadata.scte35.SpliceCommand
    public final String toString() {
        StringBuilder sb = new StringBuilder("SCTE-35 TimeSignalCommand { ptsTime=");
        sb.append(this.f8892a);
        sb.append(", playbackPositionUs= ");
        return b.p(sb, this.f8893b, " }");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f8892a);
        parcel.writeLong(this.f8893b);
    }
}

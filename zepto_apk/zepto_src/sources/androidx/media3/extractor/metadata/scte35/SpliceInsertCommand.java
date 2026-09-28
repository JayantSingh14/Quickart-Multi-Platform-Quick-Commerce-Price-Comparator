package androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import androidx.media3.common.util.UnstableApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final long f8862a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8863b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8864c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f8865d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f8866e;

    /* renamed from: f, reason: collision with root package name */
    public final long f8867f;

    /* renamed from: g, reason: collision with root package name */
    public final long f8868g;

    /* renamed from: h, reason: collision with root package name */
    public final List f8869h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f8870i;

    /* renamed from: j, reason: collision with root package name */
    public final long f8871j;

    /* renamed from: k, reason: collision with root package name */
    public final int f8872k;

    /* renamed from: l, reason: collision with root package name */
    public final int f8873l;

    /* renamed from: m, reason: collision with root package name */
    public final int f8874m;

    /* renamed from: androidx.media3.extractor.metadata.scte35.SpliceInsertCommand$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<SpliceInsertCommand> {
        @Override // android.os.Parcelable.Creator
        public final SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final SpliceInsertCommand[] newArray(int i2) {
            return new SpliceInsertCommand[i2];
        }
    }

    public static final class ComponentSplice {

        /* renamed from: a, reason: collision with root package name */
        public final int f8875a;

        /* renamed from: b, reason: collision with root package name */
        public final long f8876b;

        /* renamed from: c, reason: collision with root package name */
        public final long f8877c;

        public ComponentSplice(long j2, long j3, int i2) {
            this.f8875a = i2;
            this.f8876b = j2;
            this.f8877c = j3;
        }
    }

    public SpliceInsertCommand(long j2, boolean z, boolean z2, boolean z3, boolean z4, long j3, long j4, List list, boolean z5, long j5, int i2, int i3, int i4) {
        this.f8862a = j2;
        this.f8863b = z;
        this.f8864c = z2;
        this.f8865d = z3;
        this.f8866e = z4;
        this.f8867f = j3;
        this.f8868g = j4;
        this.f8869h = Collections.unmodifiableList(list);
        this.f8870i = z5;
        this.f8871j = j5;
        this.f8872k = i2;
        this.f8873l = i3;
        this.f8874m = i4;
    }

    @Override // androidx.media3.extractor.metadata.scte35.SpliceCommand
    public final String toString() {
        StringBuilder sb = new StringBuilder("SCTE-35 SpliceInsertCommand { programSplicePts=");
        sb.append(this.f8867f);
        sb.append(", programSplicePlaybackPositionUs= ");
        return b.p(sb, this.f8868g, " }");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f8862a);
        parcel.writeByte(this.f8863b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8864c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8865d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8866e ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f8867f);
        parcel.writeLong(this.f8868g);
        List list = this.f8869h;
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            ComponentSplice componentSplice = (ComponentSplice) list.get(i3);
            parcel.writeInt(componentSplice.f8875a);
            parcel.writeLong(componentSplice.f8876b);
            parcel.writeLong(componentSplice.f8877c);
        }
        parcel.writeByte(this.f8870i ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f8871j);
        parcel.writeInt(this.f8872k);
        parcel.writeInt(this.f8873l);
        parcel.writeInt(this.f8874m);
    }

    public SpliceInsertCommand(Parcel parcel) {
        this.f8862a = parcel.readLong();
        this.f8863b = parcel.readByte() == 1;
        this.f8864c = parcel.readByte() == 1;
        this.f8865d = parcel.readByte() == 1;
        this.f8866e = parcel.readByte() == 1;
        this.f8867f = parcel.readLong();
        this.f8868g = parcel.readLong();
        int i2 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(new ComponentSplice(parcel.readLong(), parcel.readLong(), parcel.readInt()));
        }
        this.f8869h = Collections.unmodifiableList(arrayList);
        this.f8870i = parcel.readByte() == 1;
        this.f8871j = parcel.readLong();
        this.f8872k = parcel.readInt();
        this.f8873l = parcel.readInt();
        this.f8874m = parcel.readInt();
    }
}

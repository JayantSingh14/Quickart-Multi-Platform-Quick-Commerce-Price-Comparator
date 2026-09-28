package androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.UnstableApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final List f8878a;

    /* renamed from: androidx.media3.extractor.metadata.scte35.SpliceScheduleCommand$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<SpliceScheduleCommand> {
        @Override // android.os.Parcelable.Creator
        public final SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final SpliceScheduleCommand[] newArray(int i2) {
            return new SpliceScheduleCommand[i2];
        }
    }

    public static final class ComponentSplice {

        /* renamed from: a, reason: collision with root package name */
        public final int f8879a;

        /* renamed from: b, reason: collision with root package name */
        public final long f8880b;

        public ComponentSplice(int i2, long j2) {
            this.f8879a = i2;
            this.f8880b = j2;
        }
    }

    public SpliceScheduleCommand(ArrayList arrayList) {
        this.f8878a = Collections.unmodifiableList(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        List list = this.f8878a;
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            Event event = (Event) list.get(i3);
            parcel.writeLong(event.f8881a);
            parcel.writeByte(event.f8882b ? (byte) 1 : (byte) 0);
            parcel.writeByte(event.f8883c ? (byte) 1 : (byte) 0);
            parcel.writeByte(event.f8884d ? (byte) 1 : (byte) 0);
            List list2 = event.f8886f;
            int size2 = list2.size();
            parcel.writeInt(size2);
            for (int i4 = 0; i4 < size2; i4++) {
                ComponentSplice componentSplice = (ComponentSplice) list2.get(i4);
                parcel.writeInt(componentSplice.f8879a);
                parcel.writeLong(componentSplice.f8880b);
            }
            parcel.writeLong(event.f8885e);
            parcel.writeByte(event.f8887g ? (byte) 1 : (byte) 0);
            parcel.writeLong(event.f8888h);
            parcel.writeInt(event.f8889i);
            parcel.writeInt(event.f8890j);
            parcel.writeInt(event.f8891k);
        }
    }

    public SpliceScheduleCommand(Parcel parcel) {
        int i2 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(new Event(parcel));
        }
        this.f8878a = Collections.unmodifiableList(arrayList);
    }

    public static final class Event {

        /* renamed from: a, reason: collision with root package name */
        public final long f8881a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f8882b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f8883c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f8884d;

        /* renamed from: e, reason: collision with root package name */
        public final long f8885e;

        /* renamed from: f, reason: collision with root package name */
        public final List f8886f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f8887g;

        /* renamed from: h, reason: collision with root package name */
        public final long f8888h;

        /* renamed from: i, reason: collision with root package name */
        public final int f8889i;

        /* renamed from: j, reason: collision with root package name */
        public final int f8890j;

        /* renamed from: k, reason: collision with root package name */
        public final int f8891k;

        public Event(long j2, boolean z, boolean z2, boolean z3, ArrayList arrayList, long j3, boolean z4, long j4, int i2, int i3, int i4) {
            this.f8881a = j2;
            this.f8882b = z;
            this.f8883c = z2;
            this.f8884d = z3;
            this.f8886f = Collections.unmodifiableList(arrayList);
            this.f8885e = j3;
            this.f8887g = z4;
            this.f8888h = j4;
            this.f8889i = i2;
            this.f8890j = i3;
            this.f8891k = i4;
        }

        public Event(Parcel parcel) {
            this.f8881a = parcel.readLong();
            this.f8882b = parcel.readByte() == 1;
            this.f8883c = parcel.readByte() == 1;
            this.f8884d = parcel.readByte() == 1;
            int i2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList.add(new ComponentSplice(parcel.readInt(), parcel.readLong()));
            }
            this.f8886f = Collections.unmodifiableList(arrayList);
            this.f8885e = parcel.readLong();
            this.f8887g = parcel.readByte() == 1;
            this.f8888h = parcel.readLong();
            this.f8889i = parcel.readInt();
            this.f8890j = parcel.readInt();
            this.f8891k = parcel.readInt();
        }
    }
}

package j$.time.zone;

import com.tencent.mmkv.MMKV;
import j$.time.DayOfWeek;
import j$.time.LocalTime;
import j$.time.Month;
import j$.time.ZoneOffset;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public final class e implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;

    /* renamed from: a, reason: collision with root package name */
    public final Month f53483a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f53484b;

    /* renamed from: c, reason: collision with root package name */
    public final DayOfWeek f53485c;

    /* renamed from: d, reason: collision with root package name */
    public final LocalTime f53486d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f53487e;

    /* renamed from: f, reason: collision with root package name */
    public final d f53488f;

    /* renamed from: g, reason: collision with root package name */
    public final ZoneOffset f53489g;

    /* renamed from: h, reason: collision with root package name */
    public final ZoneOffset f53490h;

    /* renamed from: i, reason: collision with root package name */
    public final ZoneOffset f53491i;

    public e(Month month, int i2, DayOfWeek dayOfWeek, LocalTime localTime, boolean z, d dVar, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.f53483a = month;
        this.f53484b = (byte) i2;
        this.f53485c = dayOfWeek;
        this.f53486d = localTime;
        this.f53487e = z;
        this.f53488f = dVar;
        this.f53489g = zoneOffset;
        this.f53490h = zoneOffset2;
        this.f53491i = zoneOffset3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    public final void writeExternal(ObjectOutput objectOutput) {
        LocalTime localTime = this.f53486d;
        boolean z = this.f53487e;
        int secondOfDay = z ? MMKV.ExpireInDay : localTime.toSecondOfDay();
        int totalSeconds = this.f53489g.getTotalSeconds();
        ZoneOffset zoneOffset = this.f53490h;
        int totalSeconds2 = zoneOffset.getTotalSeconds() - totalSeconds;
        ZoneOffset zoneOffset2 = this.f53491i;
        int totalSeconds3 = zoneOffset2.getTotalSeconds() - totalSeconds;
        int hour = secondOfDay % MMKV.ExpireInHour == 0 ? z ? 24 : localTime.getHour() : 31;
        int i2 = totalSeconds % 900 == 0 ? (totalSeconds / 900) + 128 : 255;
        int i3 = (totalSeconds2 == 0 || totalSeconds2 == 1800 || totalSeconds2 == 3600) ? totalSeconds2 / 1800 : 3;
        int i4 = (totalSeconds3 == 0 || totalSeconds3 == 1800 || totalSeconds3 == 3600) ? totalSeconds3 / 1800 : 3;
        DayOfWeek dayOfWeek = this.f53485c;
        objectOutput.writeInt((this.f53483a.q() << 28) + ((this.f53484b + 32) << 22) + ((dayOfWeek == null ? 0 : dayOfWeek.q()) << 19) + (hour << 14) + (this.f53488f.ordinal() << 12) + (i2 << 4) + (i3 << 2) + i4);
        if (hour == 31) {
            objectOutput.writeInt(secondOfDay);
        }
        if (i2 == 255) {
            objectOutput.writeInt(totalSeconds);
        }
        if (i3 == 3) {
            objectOutput.writeInt(zoneOffset.getTotalSeconds());
        }
        if (i4 == 3) {
            objectOutput.writeInt(zoneOffset2.getTotalSeconds());
        }
    }

    public static e a(ObjectInput objectInput) {
        int i2;
        d dVar;
        int i3;
        LocalTime localTimeS;
        int i4 = objectInput.readInt();
        Month monthK = Month.K(i4 >>> 28);
        int i5 = ((264241152 & i4) >>> 22) - 32;
        int i6 = (3670016 & i4) >>> 19;
        DayOfWeek dayOfWeekS = i6 == 0 ? null : DayOfWeek.s(i6);
        int i7 = (507904 & i4) >>> 14;
        d dVar2 = d.values()[(i4 & 12288) >>> 12];
        int i8 = (i4 & 4080) >>> 4;
        int i9 = (i4 & 12) >>> 2;
        int i10 = i4 & 3;
        if (i7 == 31) {
            long j2 = objectInput.readInt();
            LocalTime localTime = LocalTime.MIN;
            j$.time.temporal.a.SECOND_OF_DAY.c0(j2);
            int i11 = (int) (j2 / 3600);
            i2 = i10;
            i3 = 24;
            long j3 = j2 - (i11 * MMKV.ExpireInHour);
            dVar = dVar2;
            localTimeS = LocalTime.s(i11, (int) (j3 / 60), (int) (j3 - (r0 * 60)), 0);
        } else {
            i2 = i10;
            dVar = dVar2;
            i3 = 24;
            int i12 = i7 % 24;
            LocalTime localTime2 = LocalTime.MIN;
            j$.time.temporal.a.HOUR_OF_DAY.c0(i12);
            localTimeS = LocalTime.f53187f[i12];
        }
        ZoneOffset zoneOffsetOfTotalSeconds = i8 == 255 ? ZoneOffset.ofTotalSeconds(objectInput.readInt()) : ZoneOffset.ofTotalSeconds((i8 - 128) * 900);
        ZoneOffset zoneOffsetOfTotalSeconds2 = ZoneOffset.ofTotalSeconds(i9 == 3 ? objectInput.readInt() : (i9 * 1800) + zoneOffsetOfTotalSeconds.getTotalSeconds());
        int i13 = i2;
        ZoneOffset zoneOffsetOfTotalSeconds3 = i13 == 3 ? ZoneOffset.ofTotalSeconds(objectInput.readInt()) : ZoneOffset.ofTotalSeconds((i13 * 1800) + zoneOffsetOfTotalSeconds.getTotalSeconds());
        boolean z = i7 == i3;
        Objects.requireNonNull(monthK, "month");
        Objects.requireNonNull(localTimeS, "time");
        Objects.requireNonNull(dVar, "timeDefnition");
        Objects.requireNonNull(zoneOffsetOfTotalSeconds, "standardOffset");
        Objects.requireNonNull(zoneOffsetOfTotalSeconds2, "offsetBefore");
        Objects.requireNonNull(zoneOffsetOfTotalSeconds3, "offsetAfter");
        if (i5 < -28 || i5 > 31 || i5 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        if (z && !localTimeS.equals(LocalTime.f53186e)) {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        }
        if (localTimeS.getNano() != 0) {
            throw new IllegalArgumentException("Time's nano-of-second must be zero");
        }
        return new e(monthK, i5, dayOfWeekS, localTimeS, z, dVar, zoneOffsetOfTotalSeconds, zoneOffsetOfTotalSeconds2, zoneOffsetOfTotalSeconds3);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f53483a == eVar.f53483a && this.f53484b == eVar.f53484b && this.f53485c == eVar.f53485c && this.f53488f == eVar.f53488f && this.f53486d.equals(eVar.f53486d) && this.f53487e == eVar.f53487e && this.f53489g.equals(eVar.f53489g) && this.f53490h.equals(eVar.f53490h) && this.f53491i.equals(eVar.f53491i)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int secondOfDay = ((this.f53486d.toSecondOfDay() + (this.f53487e ? 1 : 0)) << 15) + (this.f53483a.ordinal() << 11) + ((this.f53484b + 32) << 5);
        DayOfWeek dayOfWeek = this.f53485c;
        return ((this.f53489g.hashCode() ^ (this.f53488f.ordinal() + (secondOfDay + ((dayOfWeek == null ? 7 : dayOfWeek.ordinal()) << 2)))) ^ this.f53490h.hashCode()) ^ this.f53491i.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TransitionRule[");
        ZoneOffset zoneOffset = this.f53490h;
        ZoneOffset zoneOffset2 = this.f53491i;
        sb.append(zoneOffset2.f53202b - zoneOffset.f53202b > 0 ? "Gap " : "Overlap ");
        sb.append(zoneOffset);
        sb.append(" to ");
        sb.append(zoneOffset2);
        sb.append(", ");
        Month month = this.f53483a;
        byte b2 = this.f53484b;
        DayOfWeek dayOfWeek = this.f53485c;
        if (dayOfWeek == null) {
            sb.append(month.name());
            sb.append(' ');
            sb.append((int) b2);
        } else if (b2 == -1) {
            sb.append(dayOfWeek.name());
            sb.append(" on or before last day of ");
            sb.append(month.name());
        } else if (b2 < 0) {
            sb.append(dayOfWeek.name());
            sb.append(" on or before last day minus ");
            sb.append((-b2) - 1);
            sb.append(" of ");
            sb.append(month.name());
        } else {
            sb.append(dayOfWeek.name());
            sb.append(" on or after ");
            sb.append(month.name());
            sb.append(' ');
            sb.append((int) b2);
        }
        sb.append(" at ");
        sb.append(this.f53487e ? "24:00" : this.f53486d.toString());
        sb.append(StringUtils.SPACE);
        sb.append(this.f53488f);
        sb.append(", standard offset ");
        sb.append(this.f53489g);
        sb.append(']');
        return sb.toString();
    }
}

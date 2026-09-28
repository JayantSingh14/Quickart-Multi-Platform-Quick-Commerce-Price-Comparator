package j$.time;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class q implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;

    /* renamed from: a, reason: collision with root package name */
    public byte f53397a;

    /* renamed from: b, reason: collision with root package name */
    public Object f53398b;

    public q() {
    }

    public q(byte b2, Object obj) {
        this.f53397a = b2;
        this.f53398b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b2 = this.f53397a;
        Object obj = this.f53398b;
        objectOutput.writeByte(b2);
        switch (b2) {
            case 1:
                Duration duration = (Duration) obj;
                objectOutput.writeLong(duration.f53177a);
                objectOutput.writeInt(duration.f53178b);
                return;
            case 2:
                Instant instant = (Instant) obj;
                objectOutput.writeLong(instant.f53179a);
                objectOutput.writeInt(instant.f53180b);
                return;
            case 3:
                LocalDate localDate = (LocalDate) obj;
                objectOutput.writeInt(localDate.f53181a);
                objectOutput.writeByte(localDate.f53182b);
                objectOutput.writeByte(localDate.f53183c);
                return;
            case 4:
                ((LocalTime) obj).j0(objectOutput);
                return;
            case 5:
                LocalDateTime localDateTime = (LocalDateTime) obj;
                LocalDate localDate2 = localDateTime.f53184a;
                objectOutput.writeInt(localDate2.f53181a);
                objectOutput.writeByte(localDate2.f53182b);
                objectOutput.writeByte(localDate2.f53183c);
                localDateTime.f53185b.j0(objectOutput);
                return;
            case 6:
                ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
                LocalDateTime localDateTime2 = zonedDateTime.f53204a;
                LocalDate localDate3 = localDateTime2.f53184a;
                objectOutput.writeInt(localDate3.f53181a);
                objectOutput.writeByte(localDate3.f53182b);
                objectOutput.writeByte(localDate3.f53183c);
                localDateTime2.f53185b.j0(objectOutput);
                zonedDateTime.f53205b.e0(objectOutput);
                zonedDateTime.f53206c.X(objectOutput);
                return;
            case 7:
                objectOutput.writeUTF(((v) obj).f53460b);
                return;
            case 8:
                ((ZoneOffset) obj).e0(objectOutput);
                return;
            case 9:
                o oVar = (o) obj;
                oVar.f53391a.j0(objectOutput);
                oVar.f53392b.e0(objectOutput);
                return;
            case 10:
                OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
                LocalDateTime localDateTime3 = offsetDateTime.f53195a;
                LocalDate localDate4 = localDateTime3.f53184a;
                objectOutput.writeInt(localDate4.f53181a);
                objectOutput.writeByte(localDate4.f53182b);
                objectOutput.writeByte(localDate4.f53183c);
                localDateTime3.f53185b.j0(objectOutput);
                offsetDateTime.f53196b.e0(objectOutput);
                return;
            case 11:
                objectOutput.writeInt(((s) obj).f53402a);
                return;
            case 12:
                u uVar = (u) obj;
                objectOutput.writeInt(uVar.f53457a);
                objectOutput.writeByte(uVar.f53458b);
                return;
            case 13:
                l lVar = (l) obj;
                objectOutput.writeByte(lVar.f53386a);
                objectOutput.writeByte(lVar.f53387b);
                return;
            case 14:
                p pVar = (p) obj;
                objectOutput.writeInt(pVar.f53394a);
                objectOutput.writeInt(pVar.f53395b);
                objectOutput.writeInt(pVar.f53396c);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) throws IOException {
        byte b2 = objectInput.readByte();
        this.f53397a = b2;
        this.f53398b = a(b2, objectInput);
    }

    public static Serializable a(byte b2, ObjectInput objectInput) throws IOException {
        switch (b2) {
            case 1:
                Duration duration = Duration.f53175c;
                return Duration.K(objectInput.readLong(), objectInput.readInt());
            case 2:
                Instant instant = Instant.EPOCH;
                return Instant.ofEpochSecond(objectInput.readLong(), objectInput.readInt());
            case 3:
                LocalDate localDate = LocalDate.MIN;
                return LocalDate.of(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return LocalTime.f0(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.MIN;
                LocalDate localDate2 = LocalDate.MIN;
                return LocalDateTime.of(LocalDate.of(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), LocalTime.f0(objectInput));
            case 6:
                LocalDateTime localDateTime2 = LocalDateTime.MIN;
                LocalDate localDate3 = LocalDate.MIN;
                LocalDateTime localDateTimeOf = LocalDateTime.of(LocalDate.of(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), LocalTime.f0(objectInput));
                ZoneOffset zoneOffsetD0 = ZoneOffset.d0(objectInput);
                ZoneId zoneId = (ZoneId) a(objectInput.readByte(), objectInput);
                Objects.requireNonNull(localDateTimeOf, "localDateTime");
                Objects.requireNonNull(zoneOffsetD0, "offset");
                Objects.requireNonNull(zoneId, "zone");
                if (!(zoneId instanceof ZoneOffset) || zoneOffsetD0.equals(zoneId)) {
                    return new ZonedDateTime(localDateTimeOf, zoneId, zoneOffsetD0);
                }
                throw new IllegalArgumentException("ZoneId must match ZoneOffset");
            case 7:
                int i2 = v.f53459d;
                return ZoneId.A(objectInput.readUTF(), false);
            case 8:
                return ZoneOffset.d0(objectInput);
            case 9:
                int i3 = o.f53390c;
                return new o(LocalTime.f0(objectInput), ZoneOffset.d0(objectInput));
            case 10:
                int i4 = OffsetDateTime.f53194c;
                LocalDate localDate4 = LocalDate.MIN;
                return new OffsetDateTime(LocalDateTime.of(LocalDate.of(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), LocalTime.f0(objectInput)), ZoneOffset.d0(objectInput));
            case 11:
                int i5 = s.f53401b;
                return s.s(objectInput.readInt());
            case 12:
                int i6 = u.f53456c;
                int i7 = objectInput.readInt();
                byte b3 = objectInput.readByte();
                j$.time.temporal.a.YEAR.c0(i7);
                j$.time.temporal.a.MONTH_OF_YEAR.c0(b3);
                return new u(i7, b3);
            case 13:
                int i8 = l.f53385c;
                byte b4 = objectInput.readByte();
                byte b5 = objectInput.readByte();
                Month monthK = Month.K(b4);
                Objects.requireNonNull(monthK, "month");
                j$.time.temporal.a.DAY_OF_MONTH.c0(b5);
                if (b5 <= monthK.J()) {
                    return new l(monthK.q(), b5);
                }
                throw new DateTimeException("Illegal value for DayOfMonth field, value " + ((int) b5) + " is not valid for month " + monthK.name());
            case 14:
                p pVar = p.f53393d;
                return p.a(objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.f53398b;
    }
}

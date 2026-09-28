package j$.time.chrono;

import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class D implements Externalizable {
    private static final long serialVersionUID = -6103370247208168577L;

    /* renamed from: a, reason: collision with root package name */
    public byte f53213a;

    /* renamed from: b, reason: collision with root package name */
    public Object f53214b;

    public D() {
    }

    public D(byte b2, Object obj) {
        this.f53213a = b2;
        this.f53214b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b2 = this.f53213a;
        Object obj = this.f53214b;
        objectOutput.writeByte(b2);
        switch (b2) {
            case 1:
                objectOutput.writeUTF(((AbstractC0109a) obj).getId());
                return;
            case 2:
                C0113e c0113e = (C0113e) obj;
                objectOutput.writeObject(c0113e.f53224a);
                objectOutput.writeObject(c0113e.f53225b);
                return;
            case 3:
                j jVar = (j) obj;
                objectOutput.writeObject(jVar.f53233a);
                objectOutput.writeObject(jVar.f53234b);
                objectOutput.writeObject(jVar.f53235c);
                return;
            case 4:
                w wVar = (w) obj;
                wVar.getClass();
                objectOutput.writeInt(wVar.j(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(wVar.j(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(wVar.j(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 5:
                objectOutput.writeByte(((x) obj).f53264a);
                return;
            case 6:
                p pVar = (p) obj;
                objectOutput.writeObject(pVar.f53248a);
                objectOutput.writeInt(pVar.j(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(pVar.j(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(pVar.j(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 7:
                B b3 = (B) obj;
                b3.getClass();
                objectOutput.writeInt(b3.j(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(b3.j(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(b3.j(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 8:
                H h2 = (H) obj;
                h2.getClass();
                objectOutput.writeInt(h2.j(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(h2.j(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(h2.j(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 9:
                C0114f c0114f = (C0114f) obj;
                objectOutput.writeUTF(c0114f.f53227a.getId());
                objectOutput.writeInt(c0114f.f53228b);
                objectOutput.writeInt(c0114f.f53229c);
                objectOutput.writeInt(c0114f.f53230d);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) throws IOException {
        Object objP;
        byte b2 = objectInput.readByte();
        this.f53213a = b2;
        switch (b2) {
            case 1:
                ConcurrentHashMap concurrentHashMap = AbstractC0109a.f53220a;
                objP = k.P(objectInput.readUTF());
                break;
            case 2:
                objP = ((ChronoLocalDate) objectInput.readObject()).M((LocalTime) objectInput.readObject());
                break;
            case 3:
                objP = ((ChronoLocalDateTime) objectInput.readObject()).H((ZoneOffset) objectInput.readObject()).I((ZoneId) objectInput.readObject());
                break;
            case 4:
                LocalDate localDate = w.f53258d;
                int i2 = objectInput.readInt();
                byte b3 = objectInput.readByte();
                byte b4 = objectInput.readByte();
                u.f53256c.getClass();
                objP = new w(LocalDate.of(i2, b3, b4));
                break;
            case 5:
                x xVar = x.f53262d;
                objP = x.t(objectInput.readByte());
                break;
            case 6:
                n nVar = (n) objectInput.readObject();
                int i3 = objectInput.readInt();
                byte b5 = objectInput.readByte();
                byte b6 = objectInput.readByte();
                nVar.getClass();
                objP = new p(nVar, i3, b5, b6);
                break;
            case 7:
                int i4 = objectInput.readInt();
                byte b7 = objectInput.readByte();
                byte b8 = objectInput.readByte();
                z.f53268c.getClass();
                objP = new B(LocalDate.of(i4 + 1911, b7, b8));
                break;
            case 8:
                int i5 = objectInput.readInt();
                byte b9 = objectInput.readByte();
                byte b10 = objectInput.readByte();
                F.f53216c.getClass();
                objP = new H(LocalDate.of(i5 - 543, b9, b10));
                break;
            case 9:
                int i6 = C0114f.f53226e;
                objP = new C0114f(k.P(objectInput.readUTF()), objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
                break;
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
        this.f53214b = objP;
    }

    private Object readResolve() {
        return this.f53214b;
    }
}

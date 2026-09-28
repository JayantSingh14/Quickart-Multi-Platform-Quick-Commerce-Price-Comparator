package org.xbill.DNS;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.function.Supplier;
import lombok.Generated;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.Tokenizer;
import org.xbill.DNS.utils.base16;

/* loaded from: classes5.dex */
public abstract class Record implements Cloneable, Comparable<Record>, Serializable {
    private static final DecimalFormat byteFormat;

    @Generated
    private static final Logger log = LoggerFactory.b(Record.class);
    protected int dclass;
    protected Name name;
    protected long ttl;
    protected int type;

    public static class RecordSerializationProxy implements Serializable {
        private static final long serialVersionUID = 1434159920070152561L;
        private final boolean isEmpty;
        private final byte[] wireData;

        public RecordSerializationProxy(Record record) {
            boolean z = record instanceof EmptyRecord;
            this.isEmpty = z;
            this.wireData = record.toWire(!z ? 1 : 0);
        }

        public Object readResolve() throws ObjectStreamException {
            try {
                return Record.fromWire(this.wireData, !this.isEmpty ? 1 : 0);
            } catch (IOException e2) {
                throw new InvalidObjectException(e2.getMessage());
            }
        }
    }

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        byteFormat = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
    }

    public Record() {
    }

    public static byte[] byteArrayFromString(String str) throws TextParseException {
        byte[] bytes = str.getBytes();
        for (byte b2 : bytes) {
            if (b2 == 92) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i2 = 0;
                boolean z = false;
                int i3 = 0;
                for (byte b3 : bytes) {
                    if (z) {
                        if (b3 >= 48 && b3 <= 57) {
                            i2++;
                            i3 = (i3 * 10) + (b3 - 48);
                            if (i3 > 255) {
                                throw new TextParseException("bad escape");
                            }
                            if (i2 >= 3) {
                                b3 = (byte) i3;
                            }
                        } else if (i2 > 0) {
                            throw new TextParseException("bad escape");
                        }
                        byteArrayOutputStream.write(b3);
                        z = false;
                    } else if (b3 == 92) {
                        z = true;
                        i2 = 0;
                        i3 = 0;
                    } else {
                        byteArrayOutputStream.write(b3);
                    }
                }
                if (i2 > 0 && i2 < 3) {
                    throw new TextParseException("bad escape");
                }
                if (byteArrayOutputStream.toByteArray().length <= 255) {
                    return byteArrayOutputStream.toByteArray();
                }
                throw new TextParseException("text string too long");
            }
        }
        if (bytes.length <= 255) {
            return bytes;
        }
        throw new TextParseException("text string too long");
    }

    public static String byteArrayToString(byte[] bArr, boolean z) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append('\"');
        }
        for (byte b2 : bArr) {
            int i2 = b2 & 255;
            if (i2 < 32 || i2 >= 127) {
                sb.append('\\');
                sb.append(byteFormat.format(i2));
            } else if (i2 == 34 || i2 == 92) {
                sb.append('\\');
                sb.append((char) i2);
            } else {
                sb.append((char) i2);
            }
        }
        if (z) {
            sb.append('\"');
        }
        return sb.toString();
    }

    public static byte[] checkByteArrayLength(String str, byte[] bArr, int i2) {
        if (bArr.length <= 65535) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        throw new IllegalArgumentException("\"" + str + "\" array must have no more than " + i2 + " elements");
    }

    public static Name checkName(String str, Name name) {
        if (name.isAbsolute()) {
            return name;
        }
        throw new RelativeNameException("'" + name + "' on field " + str + " is not an absolute name");
    }

    public static int checkU16(String str, int i2) {
        if (Utils.isUInt16(i2)) {
            return i2;
        }
        throw new IllegalArgumentException("\"" + str + "\" " + i2 + " must be an unsigned 16 bit value");
    }

    public static long checkU32(String str, long j2) {
        if (Utils.isUInt32(j2)) {
            return j2;
        }
        throw new IllegalArgumentException("\"" + str + "\" " + j2 + " must be an unsigned 32 bit value");
    }

    public static int checkU8(String str, int i2) {
        if (Utils.isUInt8(i2)) {
            return i2;
        }
        throw new IllegalArgumentException("\"" + str + "\" " + i2 + " must be an unsigned 8 bit value");
    }

    public static Record fromString(Name name, int i2, int i3, long j2, Tokenizer tokenizer, Name name2) throws IOException {
        if (!name.isAbsolute()) {
            throw new RelativeNameException(name);
        }
        Type.check(i2);
        DClass.check(i3);
        TTL.check(j2);
        Tokenizer.Token token = tokenizer.get();
        if (token.type() == 3 && token.value().equals("\\#")) {
            int uInt16 = tokenizer.getUInt16();
            byte[] hex = tokenizer.getHex();
            if (hex == null) {
                hex = new byte[0];
            }
            if (uInt16 == hex.length) {
                return newRecord(name, i2, i3, j2, uInt16, new DNSInput(hex));
            }
            throw tokenizer.exception("invalid unknown RR encoding: length mismatch");
        }
        tokenizer.unget();
        Record emptyRecord = getEmptyRecord(name, i2, i3, j2, true);
        emptyRecord.rdataFromString(tokenizer, name2);
        Tokenizer.Token token2 = tokenizer.get();
        if (token2.type() == 1 || token2.type() == 0) {
            return emptyRecord;
        }
        throw tokenizer.exception("unexpected tokens at end of record (wanted EOL/EOF, got " + token2 + ")");
    }

    public static Record fromWire(DNSInput dNSInput, int i2, boolean z) throws IOException {
        Name name = new Name(dNSInput);
        int u16 = dNSInput.readU16();
        int u162 = dNSInput.readU16();
        if (i2 == 0) {
            return newRecord(name, u16, u162);
        }
        long u32 = dNSInput.readU32();
        int u163 = dNSInput.readU16();
        return (u163 == 0 && z && (i2 == 1 || i2 == 2)) ? newRecord(name, u16, u162, u32) : newRecord(name, u16, u162, u32, u163, dNSInput);
    }

    private static Record getEmptyRecord(Name name, int i2, int i3, long j2, boolean z) {
        Record emptyRecord;
        if (z) {
            Supplier<Record> factory = Type.getFactory(i2);
            emptyRecord = factory != null ? factory.get() : new UNKRecord();
        } else {
            emptyRecord = new EmptyRecord();
        }
        emptyRecord.name = name;
        emptyRecord.type = i2;
        emptyRecord.dclass = i3;
        emptyRecord.ttl = j2;
        return emptyRecord;
    }

    private static Record newRecord(Name name, int i2, int i3, long j2, int i4, DNSInput dNSInput) throws IOException {
        Record emptyRecord = getEmptyRecord(name, i2, i3, j2, dNSInput != null);
        if (dNSInput == null) {
            return emptyRecord;
        }
        if (dNSInput.remaining() < i4) {
            throw new WireParseException("truncated record");
        }
        dNSInput.setActive(i4);
        emptyRecord.rrFromWire(dNSInput);
        if (dNSInput.remaining() > 0) {
            throw new WireParseException("invalid record length");
        }
        dNSInput.clearActive();
        return emptyRecord;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use RecordSerializationProxy");
    }

    private void toWireCanonical(DNSOutput dNSOutput, boolean z) {
        this.name.toWireCanonical(dNSOutput);
        dNSOutput.writeU16(this.type);
        dNSOutput.writeU16(this.dclass);
        if (z) {
            dNSOutput.writeU32(0L);
        } else {
            dNSOutput.writeU32(this.ttl);
        }
        int iCurrent = dNSOutput.current();
        dNSOutput.writeU16(0);
        rrToWire(dNSOutput, null, true);
        dNSOutput.writeU16At((dNSOutput.current() - iCurrent) - 2, iCurrent);
    }

    public static String unknownToString(byte[] bArr) {
        return "\\# " + bArr.length + StringUtils.SPACE + base16.toString(bArr);
    }

    public Record cloneRecord() {
        try {
            return (Record) clone();
        } catch (CloneNotSupportedException unused) {
            throw new IllegalStateException();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Record)) {
            return false;
        }
        Record record = (Record) obj;
        if (this.type == record.type && this.dclass == record.dclass && this.name.equals(record.name)) {
            return Arrays.equals(rdataToWireCanonical(), record.rdataToWireCanonical());
        }
        return false;
    }

    public Name getAdditionalName() {
        return null;
    }

    public int getDClass() {
        return this.dclass;
    }

    public Name getName() {
        return this.name;
    }

    public int getRRsetType() {
        return this.type;
    }

    public long getTTL() {
        return this.ttl;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int i2 = 0;
        for (byte b2 : toWireCanonical(true)) {
            i2 += (i2 << 3) + (b2 & 255);
        }
        return i2;
    }

    public abstract void rdataFromString(Tokenizer tokenizer, Name name) throws IOException;

    public String rdataToString() {
        return rrToString();
    }

    public byte[] rdataToWireCanonical() {
        DNSOutput dNSOutput = new DNSOutput();
        rrToWire(dNSOutput, null, true);
        return dNSOutput.toByteArray();
    }

    public abstract void rrFromWire(DNSInput dNSInput) throws IOException;

    public abstract String rrToString();

    public abstract void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z);

    public boolean sameRRset(Record record) {
        return getRRsetType() == record.getRRsetType() && this.dclass == record.dclass && this.name.equals(record.name);
    }

    public void setTTL(long j2) {
        this.ttl = j2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        if (sb.length() < 8) {
            sb.append("\t");
        }
        if (sb.length() < 16) {
            sb.append("\t");
        }
        sb.append("\t");
        if (Options.check("BINDTTL")) {
            sb.append(TTL.format(this.ttl));
        } else {
            sb.append(this.ttl);
        }
        sb.append("\t");
        if (this.dclass != 1 || !Options.check("noPrintIN")) {
            sb.append(DClass.string(this.dclass));
            sb.append("\t");
        }
        sb.append(Type.string(this.type));
        String strRrToString = rrToString();
        if (!strRrToString.isEmpty()) {
            sb.append("\t");
            sb.append(strRrToString);
        }
        return sb.toString();
    }

    public void toWire(DNSOutput dNSOutput, int i2, Compression compression) {
        this.name.toWire(dNSOutput, compression);
        dNSOutput.writeU16(this.type);
        dNSOutput.writeU16(this.dclass);
        if (i2 == 0) {
            return;
        }
        dNSOutput.writeU32(this.ttl);
        int iCurrent = dNSOutput.current();
        dNSOutput.writeU16(0);
        rrToWire(dNSOutput, compression, false);
        dNSOutput.writeU16At((dNSOutput.current() - iCurrent) - 2, iCurrent);
    }

    public Record withDClass(int i2, long j2) {
        Record recordCloneRecord = cloneRecord();
        recordCloneRecord.dclass = i2;
        recordCloneRecord.ttl = j2;
        return recordCloneRecord;
    }

    public Record withName(Name name) {
        if (!name.isAbsolute()) {
            throw new RelativeNameException(name);
        }
        Record recordCloneRecord = cloneRecord();
        recordCloneRecord.name = name;
        return recordCloneRecord;
    }

    public Object writeReplace() {
        log.r("Creating proxy object for serialization");
        return new RecordSerializationProxy(this);
    }

    public Record(Name name, int i2, int i3, long j2) {
        if (!name.isAbsolute()) {
            throw new RelativeNameException(name);
        }
        Type.check(i2);
        DClass.check(i3);
        TTL.check(j2);
        this.name = name;
        this.type = i2;
        this.dclass = i3;
        this.ttl = j2;
    }

    @Override // java.lang.Comparable
    public int compareTo(Record record) {
        if (this == record) {
            return 0;
        }
        int iCompareTo = this.name.compareTo(record.name);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int i2 = this.dclass - record.dclass;
        if (i2 != 0) {
            return i2;
        }
        int i3 = this.type - record.type;
        if (i3 != 0) {
            return i3;
        }
        byte[] bArrRdataToWireCanonical = rdataToWireCanonical();
        byte[] bArrRdataToWireCanonical2 = record.rdataToWireCanonical();
        int iMin = Math.min(bArrRdataToWireCanonical.length, bArrRdataToWireCanonical2.length);
        for (int i4 = 0; i4 < iMin; i4++) {
            byte b2 = bArrRdataToWireCanonical[i4];
            byte b3 = bArrRdataToWireCanonical2[i4];
            if (b2 != b3) {
                return (b2 & 255) - (b3 & 255);
            }
        }
        return bArrRdataToWireCanonical.length - bArrRdataToWireCanonical2.length;
    }

    public boolean sameRRset(RRset rRset) {
        return getRRsetType() == rRset.getType() && this.dclass == rRset.getDClass() && this.name.equals(rRset.getName());
    }

    public static Record fromWire(DNSInput dNSInput, int i2) throws IOException {
        return fromWire(dNSInput, i2, false);
    }

    public static Record newRecord(Name name, int i2, int i3, long j2, int i4, byte[] bArr) {
        if (name.isAbsolute()) {
            Type.check(i2);
            DClass.check(i3);
            TTL.check(j2);
            try {
                return newRecord(name, i2, i3, j2, i4, bArr != null ? new DNSInput(bArr) : null);
            } catch (IOException unused) {
                return null;
            }
        }
        throw new RelativeNameException(name);
    }

    public static Record fromWire(byte[] bArr, int i2) throws IOException {
        return fromWire(new DNSInput(bArr), i2, false);
    }

    public byte[] toWire(int i2) {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput, i2, null);
        return dNSOutput.toByteArray();
    }

    private byte[] toWireCanonical(boolean z) {
        DNSOutput dNSOutput = new DNSOutput();
        toWireCanonical(dNSOutput, z);
        return dNSOutput.toByteArray();
    }

    public byte[] toWireCanonical() {
        return toWireCanonical(false);
    }

    public static Record newRecord(Name name, int i2, int i3, long j2, byte[] bArr) {
        return newRecord(name, i2, i3, j2, bArr.length, bArr);
    }

    public static Record newRecord(Name name, int i2, int i3, long j2) {
        if (name.isAbsolute()) {
            Type.check(i2);
            DClass.check(i3);
            TTL.check(j2);
            return getEmptyRecord(name, i2, i3, j2, false);
        }
        throw new RelativeNameException(name);
    }

    public static Record fromString(Name name, int i2, int i3, long j2, String str, Name name2) throws IOException {
        return fromString(name, i2, i3, j2, new Tokenizer(str), name2);
    }

    public static Record newRecord(Name name, int i2, int i3) {
        return newRecord(name, i2, i3, 0L);
    }
}

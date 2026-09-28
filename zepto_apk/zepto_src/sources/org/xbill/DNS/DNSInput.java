package org.xbill.DNS;

import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public class DNSInput {
    private final ByteBuffer byteBuffer;
    private final int limit;
    private final int offset;
    private int savedEnd;
    private int savedPos;

    public DNSInput(byte[] bArr) {
        this(ByteBuffer.wrap(bArr));
    }

    private void require(int i2) throws WireParseException {
        if (i2 > remaining()) {
            throw new WireParseException("end of input");
        }
    }

    public void clearActive() {
        this.byteBuffer.limit(this.limit);
    }

    public int current() {
        return this.byteBuffer.position() - this.offset;
    }

    public void jump(int i2) {
        int i3 = this.offset;
        if (i2 + i3 >= this.limit) {
            throw new IllegalArgumentException("cannot jump past end of input");
        }
        this.byteBuffer.position(i3 + i2);
        this.byteBuffer.limit(this.limit);
    }

    public void readByteArray(byte[] bArr, int i2, int i3) throws WireParseException {
        require(i3);
        this.byteBuffer.get(bArr, i2, i3);
    }

    public byte[] readCountedString() throws WireParseException {
        return readByteArray(readU8());
    }

    public int readU16() throws WireParseException {
        require(2);
        return this.byteBuffer.getShort() & 65535;
    }

    public long readU32() throws WireParseException {
        require(4);
        return this.byteBuffer.getInt() & 4294967295L;
    }

    public int readU8() throws WireParseException {
        require(1);
        return this.byteBuffer.get() & 255;
    }

    public int remaining() {
        return this.byteBuffer.remaining();
    }

    public void restore() {
        int i2 = this.savedPos;
        if (i2 < 0) {
            throw new IllegalStateException("no previous state");
        }
        this.byteBuffer.position(i2);
        this.byteBuffer.limit(this.savedEnd);
        this.savedPos = -1;
        this.savedEnd = -1;
    }

    public void restoreActive(int i2) {
        int i3 = this.offset;
        if (i2 + i3 > this.limit) {
            throw new IllegalArgumentException("cannot set active region past end of input");
        }
        this.byteBuffer.limit(i2 + i3);
    }

    public void save() {
        this.savedPos = this.byteBuffer.position();
        this.savedEnd = this.byteBuffer.limit();
    }

    public int saveActive() {
        return this.byteBuffer.limit() - this.offset;
    }

    public void setActive(int i2) {
        if (i2 > this.limit - this.byteBuffer.position()) {
            throw new IllegalArgumentException("cannot set active region past end of input");
        }
        ByteBuffer byteBuffer = this.byteBuffer;
        byteBuffer.limit(byteBuffer.position() + i2);
    }

    public DNSInput(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
        this.offset = byteBuffer.position();
        this.limit = byteBuffer.limit();
        this.savedPos = -1;
        this.savedEnd = -1;
    }

    public byte[] readByteArray(int i2) throws WireParseException {
        require(i2);
        byte[] bArr = new byte[i2];
        this.byteBuffer.get(bArr, 0, i2);
        return bArr;
    }

    public byte[] readByteArray() {
        int iRemaining = remaining();
        byte[] bArr = new byte[iRemaining];
        this.byteBuffer.get(bArr, 0, iRemaining);
        return bArr;
    }
}

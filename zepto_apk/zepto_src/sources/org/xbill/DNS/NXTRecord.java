package org.xbill.DNS;

import java.io.IOException;
import java.util.BitSet;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.Tokenizer;

/* loaded from: classes5.dex */
public class NXTRecord extends Record {
    private BitSet bitmap;
    private Name next;

    public NXTRecord() {
    }

    public BitSet getBitmap() {
        return this.bitmap;
    }

    public Name getNext() {
        return this.next;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        Tokenizer.Token token;
        this.next = tokenizer.getName(name);
        this.bitmap = new BitSet();
        while (true) {
            token = tokenizer.get();
            if (!token.isString()) {
                tokenizer.unget();
                return;
            }
            int iValue = Type.value(token.value(), true);
            if (iValue <= 0 || iValue > 128) {
                break;
            } else {
                this.bitmap.set(iValue);
            }
        }
        throw tokenizer.exception("Invalid type: " + token.value());
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.next = new Name(dNSInput);
        this.bitmap = new BitSet();
        int iRemaining = dNSInput.remaining();
        for (int i2 = 0; i2 < iRemaining; i2++) {
            int u8 = dNSInput.readU8();
            for (int i3 = 0; i3 < 8; i3++) {
                if (((1 << (7 - i3)) & u8) != 0) {
                    this.bitmap.set((i2 * 8) + i3);
                }
            }
        }
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.next);
        int length = this.bitmap.length();
        for (short s = 0; s < length; s = (short) (s + 1)) {
            if (this.bitmap.get(s)) {
                sb.append(StringUtils.SPACE);
                sb.append(Type.string(s));
            }
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        this.next.toWire(dNSOutput, null, z);
        int length = this.bitmap.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 |= this.bitmap.get(i3) ? 1 << (7 - (i3 % 8)) : 0;
            if (i3 % 8 == 7 || i3 == length - 1) {
                dNSOutput.writeU8(i2);
                i2 = 0;
            }
        }
    }

    public NXTRecord(Name name, int i2, long j2, Name name2, BitSet bitSet) {
        super(name, 30, i2, j2);
        this.next = Record.checkName("next", name2);
        this.bitmap = bitSet;
    }
}

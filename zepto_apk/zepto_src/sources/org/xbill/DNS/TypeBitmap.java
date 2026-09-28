package org.xbill.DNS;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;
import org.xbill.DNS.Tokenizer;

/* loaded from: classes5.dex */
final class TypeBitmap implements Serializable {
    private static final long serialVersionUID = -125354057735389003L;
    private final TreeSet<Integer> types;

    private TypeBitmap() {
        this.types = new TreeSet<>();
    }

    private static int getMapLength(DNSInput dNSInput) throws WireParseException {
        int u8 = dNSInput.readU8();
        if (u8 <= dNSInput.remaining()) {
            return u8;
        }
        throw new WireParseException("invalid bitmap");
    }

    private static int getWindowBlockNumber(DNSInput dNSInput, int i2) throws WireParseException {
        int u8 = dNSInput.readU8();
        if (u8 >= i2) {
            return u8;
        }
        throw new WireParseException("invalid ordering");
    }

    private static void mapToWire(DNSOutput dNSOutput, TreeSet<Integer> treeSet, int i2) {
        int iIntValue = ((treeSet.last().intValue() & 255) / 8) + 1;
        int[] iArr = new int[iIntValue];
        dNSOutput.writeU8(i2);
        dNSOutput.writeU8(iIntValue);
        Iterator<Integer> it = treeSet.iterator();
        while (it.hasNext()) {
            int iIntValue2 = it.next().intValue();
            int i3 = (iIntValue2 & 255) / 8;
            iArr[i3] = (1 << (7 - (iIntValue2 % 8))) | iArr[i3];
        }
        for (int i4 = 0; i4 < iIntValue; i4++) {
            dNSOutput.writeU8(iArr[i4]);
        }
    }

    public boolean contains(int i2) {
        return this.types.contains(Integer.valueOf(i2));
    }

    public boolean empty() {
        return this.types.isEmpty();
    }

    public int[] toArray() {
        int[] iArr = new int[this.types.size()];
        Iterator<Integer> it = this.types.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = it.next().intValue();
            i2++;
        }
        return iArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = this.types.iterator();
        while (it.hasNext()) {
            sb.append(Type.string(it.next().intValue()));
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public void toWire(DNSOutput dNSOutput) {
        if (this.types.isEmpty()) {
            return;
        }
        TreeSet treeSet = new TreeSet();
        Iterator<Integer> it = this.types.iterator();
        int i2 = -1;
        while (it.hasNext()) {
            Integer next = it.next();
            int iIntValue = next.intValue() >> 8;
            if (iIntValue != i2) {
                if (!treeSet.isEmpty()) {
                    mapToWire(dNSOutput, treeSet, i2);
                    treeSet.clear();
                }
                i2 = iIntValue;
            }
            treeSet.add(next);
        }
        mapToWire(dNSOutput, treeSet, i2);
    }

    public TypeBitmap(int[] iArr) {
        this();
        for (int i2 : iArr) {
            Type.check(i2);
            this.types.add(Integer.valueOf(i2));
        }
    }

    public TypeBitmap(DNSInput dNSInput) throws WireParseException {
        this();
        while (dNSInput.remaining() > 0) {
            if (dNSInput.remaining() >= 2) {
                int windowBlockNumber = getWindowBlockNumber(dNSInput, -1);
                int mapLength = getMapLength(dNSInput);
                for (int i2 = 0; i2 < mapLength; i2++) {
                    int u8 = dNSInput.readU8();
                    for (int i3 = 0; i3 < 8 && u8 > 0; i3++) {
                        if (((1 << (7 - i3)) & u8) != 0) {
                            this.types.add(Integer.valueOf((i2 * 8) + (windowBlockNumber * 256) + i3));
                        }
                    }
                }
            } else {
                throw new WireParseException("invalid bitmap descriptor");
            }
        }
    }

    public TypeBitmap(Tokenizer tokenizer) throws IOException {
        this();
        while (true) {
            Tokenizer.Token token = tokenizer.get();
            if (!token.isString()) {
                tokenizer.unget();
                return;
            }
            int iValue = Type.value(token.value());
            if (iValue >= 0) {
                this.types.add(Integer.valueOf(iValue));
            } else {
                throw tokenizer.exception("Invalid type: " + token.value());
            }
        }
    }
}

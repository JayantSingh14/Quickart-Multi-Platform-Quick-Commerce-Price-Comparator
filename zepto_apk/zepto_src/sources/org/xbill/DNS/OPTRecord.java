package org.xbill.DNS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.EDNSOption;

/* loaded from: classes5.dex */
public class OPTRecord extends Record {
    private List<EDNSOption> options;

    public OPTRecord() {
    }

    @Override // org.xbill.DNS.Record
    public boolean equals(Object obj) {
        return super.equals(obj) && this.ttl == ((OPTRecord) obj).ttl;
    }

    public int getExtendedRcode() {
        return (int) (this.ttl >>> 24);
    }

    public int getFlags() {
        return (int) (this.ttl & 65535);
    }

    public List<EDNSOption> getOptions() {
        List<EDNSOption> list = this.options;
        return list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list);
    }

    public int getPayloadSize() {
        return this.dclass;
    }

    public int getVersion() {
        return (int) ((this.ttl >>> 16) & 255);
    }

    @Override // org.xbill.DNS.Record
    public int hashCode() {
        int i2 = 0;
        for (byte b2 : toWireCanonical()) {
            i2 += (i2 << 3) + (b2 & 255);
        }
        return i2;
    }

    public void printPseudoSection(StringBuilder sb) {
        sb.append(";; OPT PSEUDOSECTION: \n; EDNS: version: ");
        sb.append(getVersion());
        sb.append("; flags: ");
        for (int i2 = 0; i2 < 16; i2++) {
            if ((getFlags() & (1 << (15 - i2))) != 0) {
                sb.append(ExtendedFlags.stringFromBit(i2));
                sb.append(StringUtils.SPACE);
            }
        }
        sb.append("; udp: ");
        sb.append(getPayloadSize());
        List<EDNSOption> list = this.options;
        if (list != null) {
            for (EDNSOption eDNSOption : list) {
                sb.append("\n; ");
                sb.append(EDNSOption.Code.string(eDNSOption.getCode()));
                sb.append(": ");
                sb.append(eDNSOption.optionToString());
            }
        }
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        throw tokenizer.exception("no text format defined for OPT");
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        if (dNSInput.remaining() > 0) {
            this.options = new ArrayList();
        }
        while (dNSInput.remaining() > 0) {
            this.options.add(EDNSOption.fromWire(dNSInput));
        }
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        StringBuilder sb = new StringBuilder();
        List<EDNSOption> list = this.options;
        if (list != null) {
            sb.append(list);
            sb.append(StringUtils.SPACE);
        }
        sb.append(" ; payload ");
        sb.append(getPayloadSize());
        sb.append(", xrcode ");
        sb.append(getExtendedRcode());
        sb.append(", version ");
        sb.append(getVersion());
        sb.append(", flags ");
        sb.append(getFlags());
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        List<EDNSOption> list = this.options;
        if (list == null) {
            return;
        }
        Iterator<EDNSOption> it = list.iterator();
        while (it.hasNext()) {
            it.next().toWire(dNSOutput);
        }
    }

    @Override // org.xbill.DNS.Record
    public String toString() {
        return Name.root + "\t\t\t\t" + Type.string(this.type) + "\t" + rrToString();
    }

    public OPTRecord(int i2, int i3, int i4, int i5, EDNSOption... eDNSOptionArr) {
        this(i2, i3, i4, i5);
        if (eDNSOptionArr != null) {
            this.options = new ArrayList(Arrays.asList(eDNSOptionArr));
        }
    }

    public OPTRecord(int i2, int i3, int i4, int i5, List<EDNSOption> list) {
        this(i2, i3, i4, i5);
        if (list != null) {
            this.options = new ArrayList(list);
        }
    }

    public List<EDNSOption> getOptions(int i2) {
        if (this.options == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (EDNSOption eDNSOption : this.options) {
            if (eDNSOption.getCode() == i2) {
                arrayList.add(eDNSOption);
            }
        }
        return arrayList;
    }

    public OPTRecord(int i2, int i3, int i4, int i5) {
        super(Name.root, 41, i2, 0L);
        Record.checkU16("payloadSize", i2);
        Record.checkU8("xrcode", i3);
        Record.checkU8("version", i4);
        Record.checkU16("flags", i5);
        this.ttl = (i3 << 24) + (i4 << 16) + i5;
    }

    public OPTRecord(int i2, int i3, int i4) {
        this(i2, i3, i4, 0);
    }
}

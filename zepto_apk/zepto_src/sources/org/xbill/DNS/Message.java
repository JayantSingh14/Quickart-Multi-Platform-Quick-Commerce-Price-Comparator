package org.xbill.DNS;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import lombok.Generated;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes5.dex */
public class Message implements Cloneable {
    public static final int MAXLENGTH = 65535;
    static final int TSIG_FAILED = 4;
    static final int TSIG_INTERMEDIATE = 2;
    static final int TSIG_SIGNED = 3;
    static final int TSIG_UNSIGNED = 0;
    static final int TSIG_VERIFIED = 1;
    private TSIGRecord generatedTsig;
    private Header header;
    private TSIGRecord querytsig;
    private Resolver resolver;
    private List<Record>[] sections;
    int sig0start;
    private int size;
    int tsigState;
    private int tsigerror;
    private TSIG tsigkey;
    int tsigstart;

    @Generated
    private static final Logger log = LoggerFactory.b(Message.class);
    private static final Record[] emptyRecordArray = new Record[0];

    private Message(Header header) {
        this.sections = new List[4];
        this.header = header;
    }

    private void addAdditionalRRset(RRset rRset, List<RRset> list, List<RRset> list2) {
        if (doesTypeHaveAdditionalRecords(rRset.getType())) {
            for (Record record : rRset.rrs(false)) {
                for (RRset rRset2 : list) {
                    if (rRset2.getName().equals(record.getAdditionalName()) && isTypeAllowedInSection(rRset2.getType(), 3)) {
                        list2.add(rRset2);
                    }
                }
            }
        }
    }

    private boolean doesTypeHaveAdditionalRecords(int i2) {
        return i2 == 2 || i2 == 3 || i2 == 4 || i2 == 7 || i2 == 15 || i2 == 33 || i2 == 35 || i2 == 36;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$normalize$0(RRset rRset) {
        return rRset.getType() == 6;
    }

    private void logOrThrow(boolean z, String str, RRset rRset, Name name, Message message) throws WireParseException {
        if (z) {
            throw new WireParseException(String.format(str.replace("{}", "%s"), rRset.getName(), DClass.string(rRset.getDClass()), Type.string(rRset.getType()), name, DClass.string(message.getQuestion().getDClass()), Type.string(message.getQuestion().getType()), Integer.valueOf(getHeader().getID())));
        }
        log.g(str, rRset.getName(), DClass.string(rRset.getDClass()), Type.string(rRset.getType()), name, DClass.string(message.getQuestion().getDClass()), Type.string(message.getQuestion().getType()), Integer.valueOf(getHeader().getID()));
    }

    public static Message newQuery(Record record) {
        Message message = new Message();
        message.header.setOpcode(0);
        message.header.setFlag(7);
        message.addRecord(record, 0);
        return message;
    }

    public static Message newUpdate(Name name) {
        return new Update(name);
    }

    private List<Record> rrsetListToRecords(List<RRset> list) {
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (RRset rRset : list) {
            arrayList.addAll(rRset.rrs(false));
            arrayList.addAll(rRset.sigs());
        }
        return arrayList;
    }

    private int sectionToWire(DNSOutput dNSOutput, int i2, Compression compression, int i3) {
        int size = this.sections[i2].size();
        int iCurrent = dNSOutput.current();
        int i4 = 0;
        Record record = null;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            Record record2 = this.sections[i2].get(i6);
            if (i2 != 3 || !(record2 instanceof OPTRecord)) {
                if (record != null && !record2.sameRRset(record)) {
                    iCurrent = dNSOutput.current();
                    i4 = i5;
                }
                record2.toWire(dNSOutput, i2, compression);
                if (dNSOutput.current() > i3) {
                    dNSOutput.jump(iCurrent);
                    return size - i4;
                }
                i5++;
                record = record2;
            }
        }
        return size - i5;
    }

    public void addRecord(Record record, int i2) {
        List<Record>[] listArr = this.sections;
        if (listArr[i2] == null) {
            listArr[i2] = new LinkedList();
        }
        this.header.incCount(i2);
        this.sections[i2].add(record);
    }

    public boolean findRRset(Name name, int i2, int i3) {
        Type.check(i2);
        Section.check(i3);
        if (this.sections[i3] == null) {
            return false;
        }
        for (int i4 = 0; i4 < this.sections[i3].size(); i4++) {
            Record record = this.sections[i3].get(i4);
            if (record.getType() == i2 && name.equals(record.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean findRecord(Record record, int i2) {
        Section.check(i2);
        List<Record> list = this.sections[i2];
        return list != null && list.contains(record);
    }

    public TSIGRecord getGeneratedTSIG() {
        return this.generatedTsig;
    }

    public Header getHeader() {
        return this.header;
    }

    public OPTRecord getOPT() {
        for (Record record : getSection(3)) {
            if (record instanceof OPTRecord) {
                return (OPTRecord) record;
            }
        }
        return null;
    }

    public Record getQuestion() {
        List<Record> list = this.sections[0];
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public int getRcode() {
        int rcode = this.header.getRcode();
        OPTRecord opt = getOPT();
        return opt != null ? rcode + (opt.getExtendedRcode() << 4) : rcode;
    }

    public Optional<Resolver> getResolver() {
        return Optional.ofNullable(this.resolver);
    }

    public List<Record> getSection(int i2) {
        Section.check(i2);
        List<Record> list = this.sections[i2];
        return list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list);
    }

    @Deprecated
    public Record[] getSectionArray(int i2) {
        Section.check(i2);
        List<Record> list = this.sections[i2];
        return list == null ? emptyRecordArray : (Record[]) list.toArray(new Record[0]);
    }

    public List<RRset> getSectionRRsets(int i2) {
        Section.check(i2);
        if (this.sections[i2] == null) {
            return Collections.EMPTY_LIST;
        }
        LinkedList linkedList = new LinkedList();
        for (Record record : this.sections[i2]) {
            int size = linkedList.size() - 1;
            while (true) {
                if (size < 0) {
                    linkedList.add(new RRset(record));
                    break;
                }
                RRset rRset = (RRset) linkedList.get(size);
                if (record.sameRRset(rRset)) {
                    rRset.addRR(record);
                    break;
                }
                size--;
            }
        }
        return linkedList;
    }

    public TSIGRecord getTSIG() {
        int count = this.header.getCount(3);
        if (count == 0) {
            return null;
        }
        Record record = this.sections[3].get(count - 1);
        if (record.type != 250) {
            return null;
        }
        return (TSIGRecord) record;
    }

    public boolean isSigned() {
        int i2 = this.tsigState;
        return i2 == 3 || i2 == 1 || i2 == 4;
    }

    public boolean isTypeAllowedInSection(int i2, int i3) {
        Type.check(i2);
        Section.check(i3);
        if (i3 != 2) {
            if (i3 == 3 && (i2 == 1 || i2 == 28)) {
                return true;
            }
        } else if (i2 == 6 || i2 == 2 || i2 == 43 || i2 == 47 || i2 == 50) {
            return true;
        }
        return !Boolean.parseBoolean(System.getProperty("dnsjava.harden_unknown_additional", "true"));
    }

    public boolean isVerified() {
        return this.tsigState == 1;
    }

    public Message normalize(Message message) {
        try {
            return normalize(message, false);
        } catch (WireParseException unused) {
            return null;
        }
    }

    public int numBytes() {
        return this.size;
    }

    public void removeAllRecords(int i2) {
        Section.check(i2);
        this.sections[i2] = null;
        this.header.setCount(i2, 0);
    }

    public boolean removeRecord(Record record, int i2) {
        Section.check(i2);
        List<Record> list = this.sections[i2];
        if (list == null || !list.remove(record)) {
            return false;
        }
        this.header.decCount(i2);
        return true;
    }

    public String sectionToString(int i2) {
        Section.check(i2);
        StringBuilder sb = new StringBuilder();
        sectionToString(sb, i2);
        return sb.toString();
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public void setResolver(Resolver resolver) {
        this.resolver = resolver;
    }

    public void setTSIG(TSIG tsig) {
        setTSIG(tsig, 0, null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        OPTRecord opt = getOPT();
        if (opt != null) {
            sb.append(this.header.toStringWithRcode(getRcode()));
            sb.append("\n\n");
            opt.printPseudoSection(sb);
            sb.append('\n');
        } else {
            sb.append(this.header);
            sb.append('\n');
        }
        if (isSigned()) {
            sb.append(";; TSIG ");
            if (isVerified()) {
                sb.append("ok");
            } else {
                sb.append("invalid");
            }
            sb.append('\n');
        }
        for (int i2 = 0; i2 < 4; i2++) {
            if (this.header.getOpcode() != 5) {
                sb.append(";; ");
                sb.append(Section.longString(i2));
                sb.append(":\n");
            } else {
                sb.append(";; ");
                sb.append(Section.updString(i2));
                sb.append(":\n");
            }
            sectionToString(sb, i2);
            sb.append(StringUtils.LF);
        }
        sb.append(";; Message size: ");
        sb.append(numBytes());
        sb.append(" bytes");
        return sb.toString();
    }

    public void toWire(DNSOutput dNSOutput) {
        this.header.toWire(dNSOutput);
        Compression compression = new Compression();
        int i2 = 0;
        while (true) {
            List<Record>[] listArr = this.sections;
            if (i2 >= listArr.length) {
                return;
            }
            List<Record> list = listArr[i2];
            if (list != null) {
                Iterator<Record> it = list.iterator();
                while (it.hasNext()) {
                    it.next().toWire(dNSOutput, i2, compression);
                }
            }
            i2++;
        }
    }

    public Message clone() {
        Message message = (Message) super.clone();
        message.sections = new List[this.sections.length];
        int i2 = 0;
        while (true) {
            List<Record>[] listArr = this.sections;
            if (i2 >= listArr.length) {
                break;
            }
            if (listArr[i2] != null) {
                message.sections[i2] = new LinkedList(this.sections[i2]);
            }
            i2++;
        }
        message.header = this.header.clone();
        TSIGRecord tSIGRecord = this.querytsig;
        if (tSIGRecord != null) {
            message.querytsig = (TSIGRecord) tSIGRecord.cloneRecord();
        }
        TSIGRecord tSIGRecord2 = this.generatedTsig;
        if (tSIGRecord2 != null) {
            message.generatedTsig = (TSIGRecord) tSIGRecord2.cloneRecord();
        }
        return message;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public org.xbill.DNS.Message normalize(org.xbill.DNS.Message r28, boolean r29) throws org.xbill.DNS.WireParseException {
        /*
            Method dump skipped, instructions count: 1011
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.Message.normalize(org.xbill.DNS.Message, boolean):org.xbill.DNS.Message");
    }

    public void setTSIG(TSIG tsig, int i2, TSIGRecord tSIGRecord) {
        this.tsigkey = tsig;
        this.tsigerror = i2;
        this.querytsig = tSIGRecord;
    }

    public boolean findRecord(Record record) {
        for (int i2 = 1; i2 <= 3; i2++) {
            List<Record> list = this.sections[i2];
            if (list != null && list.contains(record)) {
                return true;
            }
        }
        return false;
    }

    public Message(int i2) {
        this(new Header(i2));
    }

    public Message() {
        this(new Header());
    }

    private void sectionToString(StringBuilder sb, int i2) {
        if (i2 > 3) {
            return;
        }
        for (Record record : getSection(i2)) {
            if (i2 == 0) {
                sb.append(";;\t");
                sb.append(record.name);
                sb.append(", type = ");
                sb.append(Type.string(record.type));
                sb.append(", class = ");
                sb.append(DClass.string(record.dclass));
            } else if (!(record instanceof OPTRecord)) {
                sb.append(record);
            }
            sb.append(StringUtils.LF);
        }
    }

    public Message(DNSInput dNSInput) throws IOException {
        this(new Header(dNSInput));
        boolean z = this.header.getOpcode() == 5;
        boolean flag = this.header.getFlag(6);
        for (int i2 = 0; i2 < 4; i2++) {
            try {
                int count = this.header.getCount(i2);
                if (count > 0) {
                    this.sections[i2] = new ArrayList(count);
                }
                for (int i3 = 0; i3 < count; i3++) {
                    int iCurrent = dNSInput.current();
                    Record recordFromWire = Record.fromWire(dNSInput, i2, z);
                    this.sections[i2].add(recordFromWire);
                    if (i2 == 3) {
                        if (recordFromWire.getType() == 250) {
                            this.tsigstart = iCurrent;
                            if (i3 != count - 1) {
                                throw new WireParseException("TSIG is not the last record in the message");
                            }
                        }
                        if (recordFromWire.getType() == 24 && ((SIGRecord) recordFromWire).getTypeCovered() == 0) {
                            this.sig0start = iCurrent;
                        }
                    }
                }
            } catch (WireParseException e2) {
                if (!flag) {
                    throw e2;
                }
            }
        }
        this.size = dNSInput.current();
    }

    private boolean toWire(DNSOutput dNSOutput, int i2) {
        byte[] wire;
        if (i2 < 12) {
            return false;
        }
        TSIG tsig = this.tsigkey;
        if (tsig != null) {
            i2 -= tsig.recordLength();
        }
        OPTRecord opt = getOPT();
        if (opt != null) {
            wire = opt.toWire(3);
            i2 -= wire.length;
        } else {
            wire = null;
        }
        int iCurrent = dNSOutput.current();
        this.header.toWire(dNSOutput);
        Compression compression = new Compression();
        int flagsByte = this.header.getFlagsByte();
        int i3 = 0;
        int count = 0;
        while (true) {
            if (i3 >= 4) {
                break;
            }
            if (this.sections[i3] != null) {
                int iSectionToWire = sectionToWire(dNSOutput, i3, compression, i2);
                if (iSectionToWire != 0 && i3 != 3) {
                    flagsByte = Header.setFlag(flagsByte, 6, true);
                    int count2 = this.header.getCount(i3) - iSectionToWire;
                    int i4 = iCurrent + 4;
                    dNSOutput.writeU16At(count2, (i3 * 2) + i4);
                    for (int i5 = i3 + 1; i5 < 3; i5++) {
                        dNSOutput.writeU16At(0, (i5 * 2) + i4);
                    }
                } else if (i3 == 3) {
                    count = this.header.getCount(i3) - iSectionToWire;
                }
            }
            i3++;
        }
        if (wire != null) {
            dNSOutput.writeByteArray(wire);
            count++;
        }
        if (flagsByte != this.header.getFlagsByte()) {
            dNSOutput.writeU16At(flagsByte, iCurrent + 2);
        }
        if (count != this.header.getCount(3)) {
            dNSOutput.writeU16At(count, iCurrent + 10);
        }
        TSIG tsig2 = this.tsigkey;
        if (tsig2 != null) {
            TSIGRecord tSIGRecordGenerate = tsig2.generate(this, dNSOutput.toByteArray(), this.tsigerror, this.querytsig);
            tSIGRecordGenerate.toWire(dNSOutput, 3, compression);
            this.generatedTsig = tSIGRecordGenerate;
            dNSOutput.writeU16At(count + 1, iCurrent + 10);
        }
        return !Header.getFlag(flagsByte, 6);
    }

    public boolean findRRset(Name name, int i2) {
        return findRRset(name, i2, 1) || findRRset(name, i2, 2) || findRRset(name, i2, 3);
    }

    public Message(byte[] bArr) throws IOException {
        this(new DNSInput(bArr));
    }

    public Message(ByteBuffer byteBuffer) throws IOException {
        this(new DNSInput(byteBuffer));
    }

    public byte[] toWire() {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput);
        this.size = dNSOutput.current();
        return dNSOutput.toByteArray();
    }

    public byte[] toWire(int i2) {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput, i2);
        this.size = dNSOutput.current();
        return dNSOutput.toByteArray();
    }

    public byte[] toWire(int i2, boolean z) throws MessageSizeExceededException {
        DNSOutput dNSOutput = new DNSOutput();
        if (!toWire(dNSOutput, i2) && !z) {
            throw new MessageSizeExceededException(i2);
        }
        this.size = dNSOutput.current();
        return dNSOutput.toByteArray();
    }
}

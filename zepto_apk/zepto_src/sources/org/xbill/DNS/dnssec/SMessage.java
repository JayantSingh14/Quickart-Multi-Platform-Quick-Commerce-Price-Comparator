package org.xbill.DNS.dnssec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.Flags;
import org.xbill.DNS.Header;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.OPTRecord;
import org.xbill.DNS.RRSIGRecord;
import org.xbill.DNS.RRset;
import org.xbill.DNS.Record;

/* loaded from: classes5.dex */
final class SMessage {
    private static final int EXTENDED_FLAGS_BIT_OFFSET = 4;
    private static final int MAX_FLAGS = 16;
    private static final int NUM_SECTIONS = 3;

    @Generated
    private static final Logger log = LoggerFactory.b(SMessage.class);
    private String bogusReason;
    private int edeReason;
    private final Header header;
    private OPTRecord oPTRecord;
    private Record question;
    private final List<SRRset>[] sections;
    private SecurityStatus securityStatus;

    public SMessage(Header header) {
        this.edeReason = -1;
        this.sections = new List[3];
        this.header = header;
        this.securityStatus = SecurityStatus.UNCHECKED;
    }

    private void addRRset(SRRset sRRset, int i2) {
        checkSectionValidity(i2);
        if (sRRset.getType() == 41) {
            this.oPTRecord = (OPTRecord) sRRset.first();
        } else {
            getSectionRRsets(i2).add(sRRset);
        }
    }

    private void checkSectionValidity(int i2) {
        if (i2 <= 0 || i2 > 3) {
            throw new IllegalArgumentException("Invalid section");
        }
    }

    public SRRset findAnswerRRset(Name name, int i2, int i3) {
        return findRRset(name, i2, i3, 1);
    }

    public SRRset findRRset(Name name, int i2, int i3, int i4) {
        checkSectionValidity(i4);
        for (SRRset sRRset : getSectionRRsets(i4)) {
            if (sRRset.getName().equals(name) && sRRset.getType() == i2 && sRRset.getDClass() == i3) {
                return sRRset;
            }
        }
        return null;
    }

    public String getBogusReason() {
        return this.bogusReason;
    }

    public int getCount(int i2) {
        if (i2 == 0) {
            return 1;
        }
        List<SRRset> sectionRRsets = getSectionRRsets(i2);
        int size = 0;
        if (sectionRRsets.isEmpty()) {
            return 0;
        }
        Iterator<SRRset> it = sectionRRsets.iterator();
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    public int getEdeReason() {
        return this.edeReason;
    }

    public Header getHeader() {
        return this.header;
    }

    public Message getMessage() {
        Message message = new Message(this.header.getID());
        Header header = message.getHeader();
        header.setOpcode(this.header.getOpcode());
        header.setRcode(this.header.getRcode());
        for (int i2 = 0; i2 < 16; i2++) {
            if (Flags.isFlag(i2) && this.header.getFlag(i2)) {
                header.setFlag(i2);
            }
        }
        Record record = this.question;
        if (record != null) {
            message.addRecord(record, 0);
        }
        for (int i3 = 1; i3 <= 3; i3++) {
            for (SRRset sRRset : getSectionRRsets(i3)) {
                Iterator<Record> it = sRRset.rrs().iterator();
                while (it.hasNext()) {
                    message.addRecord(it.next(), i3);
                }
                Iterator<RRSIGRecord> it2 = sRRset.sigs().iterator();
                while (it2.hasNext()) {
                    message.addRecord(it2.next(), i3);
                }
            }
        }
        OPTRecord oPTRecord = this.oPTRecord;
        if (oPTRecord != null) {
            message.addRecord(oPTRecord, 3);
        }
        return message;
    }

    public Record getQuestion() {
        return this.question;
    }

    public int getRcode() {
        int rcode = this.header.getRcode();
        OPTRecord oPTRecord = this.oPTRecord;
        return oPTRecord != null ? rcode + (oPTRecord.getExtendedRcode() << 4) : rcode;
    }

    public List<SRRset> getSectionRRsets(int i2) {
        checkSectionValidity(i2);
        List<SRRset>[] listArr = this.sections;
        int i3 = i2 - 1;
        if (listArr[i3] == null) {
            listArr[i3] = new LinkedList();
        }
        return this.sections[i3];
    }

    public SecurityStatus getStatus() {
        return this.securityStatus;
    }

    public void setBogus(String str) {
        setStatus(SecurityStatus.BOGUS, 6, str);
    }

    public void setStatus(SecurityStatus securityStatus, int i2) {
        setStatus(securityStatus, i2, null);
    }

    public void setBogus(String str, int i2) {
        setStatus(SecurityStatus.BOGUS, i2, str);
    }

    public void setStatus(SecurityStatus securityStatus, int i2, String str) {
        this.securityStatus = securityStatus;
        this.edeReason = i2;
        this.bogusReason = str;
        if (str != null) {
            log.s(str, "Setting bad reason for message to {}");
        }
    }

    public List<SRRset> getSectionRRsets(int i2, int i3) {
        List<SRRset> sectionRRsets = getSectionRRsets(i2);
        if (sectionRRsets.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(sectionRRsets.size());
        for (SRRset sRRset : sectionRRsets) {
            if (sRRset.getType() == i3) {
                arrayList.add(sRRset);
            }
        }
        return arrayList;
    }

    public SMessage(int i2, Record record) {
        this(new Header(i2));
        this.question = record;
    }

    public SMessage(Message message) {
        this(message.getHeader());
        this.question = message.getQuestion();
        this.oPTRecord = message.getOPT();
        for (int i2 = 1; i2 <= 3; i2++) {
            Iterator<RRset> it = message.getSectionRRsets(i2).iterator();
            while (it.hasNext()) {
                addRRset(new SRRset(it.next()), i2);
            }
        }
    }
}

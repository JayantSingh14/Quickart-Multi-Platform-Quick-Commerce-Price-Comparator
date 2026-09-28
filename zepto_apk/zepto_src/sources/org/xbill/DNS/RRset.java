package org.xbill.DNS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import lombok.Generated;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class RRset implements Serializable, Iterable<Record> {
    private short position;
    private final ArrayList<Record> rrs;
    private final ArrayList<RRSIGRecord> sigs;
    private long ttl;

    public RRset() {
        this.rrs = new ArrayList<>(1);
        this.sigs = new ArrayList<>(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <X extends Record> void adjustTtl(long j2, List<X> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Record recordCloneRecord = ((Record) list.get(i2)).cloneRecord();
            recordCloneRecord.setTTL(j2);
            list.set(i2, recordCloneRecord);
        }
    }

    private void appendRrList(Iterator<? extends Record> it, StringBuilder sb) {
        while (it.hasNext()) {
            Record next = it.next();
            sb.append("[");
            sb.append(next.rdataToString());
            sb.append("]");
            if (it.hasNext()) {
                sb.append(StringUtils.SPACE);
            }
        }
    }

    private void checkSameRRset(Record record, List<? extends Record> list) {
        if (!list.isEmpty() && !record.sameRRset(list.get(0))) {
            throw new IllegalArgumentException("record does not match rrset");
        }
    }

    public void addRR(RRSIGRecord rRSIGRecord) {
        addRR(rRSIGRecord, this.sigs);
    }

    @Generated
    public boolean canEqual(Object obj) {
        return obj instanceof RRset;
    }

    public void clear() {
        this.rrs.clear();
        this.sigs.clear();
    }

    public void deleteRR(RRSIGRecord rRSIGRecord) {
        this.sigs.remove(rRSIGRecord);
    }

    @Generated
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RRset)) {
            return false;
        }
        RRset rRset = (RRset) obj;
        if (!rRset.canEqual(this)) {
            return false;
        }
        ArrayList<Record> arrayList = this.rrs;
        ArrayList<Record> arrayList2 = rRset.rrs;
        if (arrayList != null ? !arrayList.equals(arrayList2) : arrayList2 != null) {
            return false;
        }
        ArrayList<RRSIGRecord> arrayList3 = this.sigs;
        ArrayList<RRSIGRecord> arrayList4 = rRset.sigs;
        return arrayList3 != null ? arrayList3.equals(arrayList4) : arrayList4 == null;
    }

    public Record first() {
        if (!this.rrs.isEmpty()) {
            return this.rrs.get(0);
        }
        if (this.sigs.isEmpty()) {
            throw new IllegalStateException("rrset is empty");
        }
        return this.sigs.get(0);
    }

    public int getActualType() {
        return first().getType();
    }

    public int getDClass() {
        return first().getDClass();
    }

    public Name getName() {
        return first().getName();
    }

    public long getTTL() {
        return first().getTTL();
    }

    public int getType() {
        return first().getRRsetType();
    }

    @Generated
    public int hashCode() {
        ArrayList<Record> arrayList = this.rrs;
        int iHashCode = arrayList == null ? 43 : arrayList.hashCode();
        ArrayList<RRSIGRecord> arrayList2 = this.sigs;
        return ((iHashCode + 59) * 59) + (arrayList2 != null ? arrayList2.hashCode() : 43);
    }

    public boolean isEmpty() {
        return this.rrs.isEmpty() && this.sigs.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<Record> iterator() {
        return rrs().iterator();
    }

    public List<Record> rrs(boolean z) {
        if (!z || this.rrs.size() <= 1) {
            return Collections.unmodifiableList(this.rrs);
        }
        ArrayList arrayList = new ArrayList(this.rrs.size());
        if (this.position == Short.MAX_VALUE) {
            this.position = (short) 0;
        }
        short s = this.position;
        this.position = (short) (s + 1);
        int size = s % this.rrs.size();
        ArrayList<Record> arrayList2 = this.rrs;
        arrayList.addAll(arrayList2.subList(size, arrayList2.size()));
        arrayList.addAll(this.rrs.subList(0, size));
        return arrayList;
    }

    public int sigSize() {
        return this.sigs.size();
    }

    public List<RRSIGRecord> sigs() {
        return Collections.unmodifiableList(this.sigs);
    }

    public int size() {
        return this.rrs.size();
    }

    public String toString() {
        if (this.rrs.isEmpty() && this.sigs.isEmpty()) {
            return "{empty}";
        }
        StringBuilder sbW = android.support.v4.media.b.w("{ ");
        sbW.append(getName());
        sbW.append(StringUtils.SPACE);
        sbW.append(getTTL());
        sbW.append(StringUtils.SPACE);
        sbW.append(DClass.string(getDClass()));
        sbW.append(StringUtils.SPACE);
        sbW.append(Type.string(getType()));
        sbW.append(StringUtils.SPACE);
        appendRrList(this.rrs.iterator(), sbW);
        if (!this.sigs.isEmpty()) {
            sbW.append(" sigs: ");
            appendRrList(this.sigs.iterator(), sbW);
        }
        sbW.append(" }");
        return sbW.toString();
    }

    public void addRR(Record record) {
        if (record instanceof RRSIGRecord) {
            addRR((RRSIGRecord) record, this.sigs);
        } else {
            addRR(record, this.rrs);
        }
    }

    public void deleteRR(Record record) {
        if (record instanceof RRSIGRecord) {
            this.sigs.remove(record);
        } else {
            this.rrs.remove(record);
        }
    }

    public RRset(Record record) {
        this();
        addRR(record);
    }

    private <X extends Record> void addRR(X x, List<X> list) {
        if (this.sigs.isEmpty() && this.rrs.isEmpty()) {
            list.add(x);
            this.ttl = x.getTTL();
            return;
        }
        checkSameRRset(x, this.rrs);
        checkSameRRset(x, this.sigs);
        if (x.getTTL() > this.ttl) {
            x = (X) x.cloneRecord();
            x.setTTL(this.ttl);
        } else if (x.getTTL() < this.ttl) {
            this.ttl = x.getTTL();
            adjustTtl(x.getTTL(), this.rrs);
            adjustTtl(x.getTTL(), this.sigs);
        }
        if (list.contains(x)) {
            return;
        }
        list.add(x);
    }

    public RRset(Record... recordArr) {
        this();
        Objects.requireNonNull(recordArr);
        for (Record record : recordArr) {
            addRR(record);
        }
    }

    public List<Record> rrs() {
        return rrs(true);
    }

    public RRset(Iterable<Record> iterable) {
        this();
        Objects.requireNonNull(iterable);
        Iterator<Record> it = iterable.iterator();
        while (it.hasNext()) {
            addRR(it.next());
        }
    }

    public RRset(RRset rRset) {
        this.rrs = new ArrayList<>(rRset.rrs);
        this.sigs = new ArrayList<>(rRset.sigs);
        this.position = rRset.position;
        this.ttl = rRset.ttl;
    }
}

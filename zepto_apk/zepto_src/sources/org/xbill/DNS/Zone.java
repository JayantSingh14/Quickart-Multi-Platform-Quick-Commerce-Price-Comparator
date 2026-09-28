package org.xbill.DNS;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;
import java.util.function.Supplier;
import lombok.Generated;

/* loaded from: classes5.dex */
public class Zone implements Serializable, Iterable<RRset> {
    public static final int PRIMARY = 1;
    public static final int SECONDARY = 2;
    private final Map<Name, Object> data;
    private boolean hasWild;
    private RRset nsRRset;
    private Name origin;
    private Object originNode;
    private final transient ReentrantReadWriteLock.ReadLock readLock;
    private final transient ReentrantReadWriteLock readWriteLock;
    private SOARecord soaRecord;
    private final transient ReentrantReadWriteLock.WriteLock writeLock;

    public class ZoneIterator implements Iterator<RRset> {
        private List<RRset> current;
        private int index;
        private RRset returnedSet;
        private RRset soaSet;
        private boolean wantLastSOA;
        private final Iterator<Map.Entry<Name, Object>> zoneEntries;

        public ZoneIterator(boolean z) {
            this.zoneEntries = Zone.this.data.entrySet().iterator();
            this.wantLastSOA = z;
            List list = (List) Zone.this.withReadLock(new i0(this, 0));
            RRset[] rRsetArr = new RRset[list.size()];
            this.current = Arrays.asList(rRsetArr);
            int i2 = 2;
            for (int i3 = 0; i3 < list.size(); i3++) {
                RRset rRset = (RRset) list.get(i3);
                int type = rRset.getType();
                if (type == 6) {
                    RRset rRset2 = new RRset(rRset);
                    this.soaSet = rRset2;
                    rRsetArr[0] = rRset2;
                } else if (type == 2) {
                    rRsetArr[1] = new RRset(rRset);
                } else {
                    rRsetArr[i2] = new RRset(rRset);
                    i2++;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ArrayList lambda$new$0() {
            Zone zone = Zone.this;
            return new ArrayList(zone.allRRsetsWithoutLock(zone.originNode));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ArrayList lambda$next$1(Map.Entry entry) {
            return new ArrayList(Zone.this.allRRsetsWithoutLock(entry.getValue()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$remove$2() {
            Zone.this.lambda$removeRRset$4(this.returnedSet.getName(), this.returnedSet.getType());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current != null || this.wantLastSOA;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.returnedSet == null) {
                throw new IllegalStateException("Not at an element");
            }
            Zone.this.withWriteLock(new a0(this, 1));
        }

        @Override // java.util.Iterator
        public RRset next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            List<RRset> list = this.current;
            if (list == null) {
                this.wantLastSOA = false;
                RRset rRset = this.soaSet;
                this.returnedSet = rRset;
                return rRset;
            }
            int i2 = this.index;
            this.index = i2 + 1;
            this.returnedSet = new RRset(list.get(i2));
            if (this.index == this.current.size()) {
                this.current = null;
                while (true) {
                    if (!this.zoneEntries.hasNext()) {
                        break;
                    }
                    Map.Entry<Name, Object> next = this.zoneEntries.next();
                    if (!next.getKey().equals(Zone.this.origin)) {
                        List<RRset> list2 = (List) Zone.this.withReadLock(new j0(0, this, next));
                        if (!list2.isEmpty()) {
                            this.current = list2;
                            this.index = 0;
                            break;
                        }
                    }
                }
            }
            return this.returnedSet;
        }
    }

    public Zone(Name name, InputStream inputStream) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.readWriteLock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.data = new ConcurrentSkipListMap();
        if (name == null) {
            throw new IllegalArgumentException("no zone name specified");
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("no input stream specified");
        }
        this.origin = name;
        fromMasterFile(new Master(inputStream, name));
    }

    private void addRRsetWithoutLock(Name name, RRset rRset) {
        if (!this.hasWild && name.isWild()) {
            this.hasWild = true;
        }
        Object obj = this.data.get(name);
        if (obj == null) {
            this.data.put(name, rRset);
            return;
        }
        int type = rRset.getType();
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (((RRset) list.get(i2)).getType() == type) {
                    list.set(i2, rRset);
                    return;
                }
            }
            list.add(rRset);
            return;
        }
        RRset rRset2 = (RRset) obj;
        if (rRset2.getType() == type) {
            this.data.put(name, rRset);
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(rRset2);
        linkedList.add(rRset);
        this.data.put(name, linkedList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<RRset> allRRsetsWithoutLock(Object obj) {
        return obj instanceof List ? (List) obj : Collections.singletonList((RRset) obj);
    }

    private Object exactName(Name name) {
        return this.data.get(name);
    }

    private RRset expandSet(RRset rRset, Name name) {
        RRset rRset2 = new RRset();
        Iterator<Record> it = rRset.rrs(false).iterator();
        while (it.hasNext()) {
            rRset2.addRR(it.next().withName(name));
        }
        Iterator<RRSIGRecord> it2 = rRset.sigs().iterator();
        while (it2.hasNext()) {
            rRset2.addRR(it2.next().withName(name));
        }
        return rRset2;
    }

    private RRset findRRsetWithoutLock(Name name, int i2) {
        Object objExactName = exactName(name);
        if (objExactName == null) {
            return null;
        }
        return oneRRsetWithoutLock(objExactName, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: findRecordsWithoutLock, reason: merged with bridge method [inline-methods] */
    public SetResponse lambda$findRecords$6(Name name, int i2) {
        RRset rRsetOneRRsetWithoutLock;
        int iLabels = name.labels();
        int iLabels2 = this.origin.labels();
        int i3 = iLabels2;
        while (true) {
            if (i3 > iLabels) {
                if (this.hasWild) {
                    while (i < iLabels - iLabels2) {
                        i++;
                        Object objExactName = exactName(name.wild(i));
                        if (objExactName != null) {
                            if (i2 == 255) {
                                SetResponse setResponseOfType = SetResponse.ofType(SetResponseType.SUCCESSFUL);
                                Iterator<RRset> it = allRRsetsWithoutLock(objExactName).iterator();
                                while (it.hasNext()) {
                                    setResponseOfType.addRRset(expandSet(it.next(), name));
                                }
                                return setResponseOfType;
                            }
                            RRset rRsetOneRRsetWithoutLock2 = oneRRsetWithoutLock(objExactName, i2);
                            if (rRsetOneRRsetWithoutLock2 != null) {
                                return SetResponse.ofType(SetResponseType.SUCCESSFUL, expandSet(rRsetOneRRsetWithoutLock2, name));
                            }
                        }
                    }
                }
                return SetResponse.ofType(SetResponseType.NXDOMAIN);
            }
            boolean z = i3 == iLabels2;
            i = i3 == iLabels ? 1 : 0;
            Object objExactName2 = exactName(z ? this.origin : i != 0 ? name : new Name(name, iLabels - i3));
            if (objExactName2 != null) {
                if (!z && (rRsetOneRRsetWithoutLock = oneRRsetWithoutLock(objExactName2, 2)) != null) {
                    return SetResponse.ofType(SetResponseType.DELEGATION, rRsetOneRRsetWithoutLock);
                }
                if (i != 0 && i2 == 255) {
                    SetResponse setResponseOfType2 = SetResponse.ofType(SetResponseType.SUCCESSFUL);
                    Iterator<RRset> it2 = allRRsetsWithoutLock(objExactName2).iterator();
                    while (it2.hasNext()) {
                        setResponseOfType2.addRRset(it2.next());
                    }
                    return setResponseOfType2;
                }
                if (i != 0) {
                    RRset rRsetOneRRsetWithoutLock3 = oneRRsetWithoutLock(objExactName2, i2);
                    if (rRsetOneRRsetWithoutLock3 != null) {
                        return SetResponse.ofType(SetResponseType.SUCCESSFUL, rRsetOneRRsetWithoutLock3);
                    }
                    RRset rRsetOneRRsetWithoutLock4 = oneRRsetWithoutLock(objExactName2, 5);
                    if (rRsetOneRRsetWithoutLock4 != null) {
                        return SetResponse.ofType(SetResponseType.CNAME, rRsetOneRRsetWithoutLock4);
                    }
                } else {
                    RRset rRsetOneRRsetWithoutLock5 = oneRRsetWithoutLock(objExactName2, 39);
                    if (rRsetOneRRsetWithoutLock5 != null) {
                        return SetResponse.ofType(SetResponseType.DNAME, rRsetOneRRsetWithoutLock5);
                    }
                }
                if (i != 0) {
                    return SetResponse.ofType(SetResponseType.NXRRSET);
                }
            }
            i3++;
        }
    }

    private void fromMasterFile(Master master) throws IOException {
        while (true) {
            try {
                Record recordNextRecord = master.nextRecord();
                if (recordNextRecord == null) {
                    master.close();
                    validate();
                    return;
                }
                maybeAddRecord(recordNextRecord);
            } catch (Throwable th) {
                master.close();
                throw th;
            }
        }
    }

    private void fromXFR(ZoneTransferIn zoneTransferIn) throws ZoneTransferException, IOException {
        this.origin = zoneTransferIn.getName();
        zoneTransferIn.run();
        if (!zoneTransferIn.isAXFR()) {
            throw new IllegalArgumentException("zones can only be created from AXFRs");
        }
        Iterator<Record> it = zoneTransferIn.getAXFR().iterator();
        while (it.hasNext()) {
            maybeAddRecord(it.next());
        }
        validate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addRRset$3(Name name, RRset rRset, int i2) {
        addRRsetWithoutLock(name, rRset);
        if (i2 == 6) {
            this.soaRecord = (SOARecord) rRset.first();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addRecord$1(Name name, int i2, Record record, int i3) {
        RRset rRsetFindRRsetWithoutLock = findRRsetWithoutLock(name, i2);
        if (rRsetFindRRsetWithoutLock == null) {
            addRRsetWithoutLock(name, new RRset(record));
            return;
        }
        if (i3 == 6) {
            rRsetFindRRsetWithoutLock.deleteRR(this.soaRecord);
            this.soaRecord = (SOARecord) record;
        }
        rRsetFindRRsetWithoutLock.addRR(record);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ RRset lambda$findExactMatch$5(Name name, int i2) {
        RRset rRsetFindRRsetWithoutLock = findRRsetWithoutLock(name, i2);
        if (rRsetFindRRsetWithoutLock == null) {
            return null;
        }
        return new RRset(rRsetFindRRsetWithoutLock);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ RRset lambda$getNS$0() {
        return new RRset(this.nsRRset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$nodeToString$7(StringBuilder sb, Record record) {
        sb.append(record);
        sb.append('\n');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$nodeToString$8(StringBuilder sb, RRSIGRecord rRSIGRecord) {
        sb.append(rRSIGRecord);
        sb.append('\n');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeRecord$2(Name name, int i2, Record record) {
        RRset rRsetFindRRsetWithoutLock = findRRsetWithoutLock(name, i2);
        if (rRsetFindRRsetWithoutLock == null) {
            return;
        }
        if (i2 == 2 && rRsetFindRRsetWithoutLock.size() == 1) {
            throw new IllegalArgumentException("Cannot remove all NS");
        }
        if (rRsetFindRRsetWithoutLock.sigSize() + rRsetFindRRsetWithoutLock.size() > 1) {
            rRsetFindRRsetWithoutLock.deleteRR(record);
        } else {
            lambda$removeRRset$4(name, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$toMasterFile$9(StringBuilder sb) {
        nodeToString(sb, this.originNode);
        for (Map.Entry<Name, Object> entry : this.data.entrySet()) {
            if (!this.origin.equals(entry.getKey())) {
                nodeToString(sb, entry.getValue());
            }
        }
        return null;
    }

    private void maybeAddRecord(Record record) throws IOException {
        int type = record.getType();
        Name name = record.getName();
        if (type != 6 || name.equals(this.origin)) {
            if (name.subdomain(this.origin)) {
                addRecord(record);
            }
        } else {
            throw new IOException("SOA owner " + name + " does not match zone origin " + this.origin);
        }
    }

    private void nodeToString(final StringBuilder sb, Object obj) {
        for (RRset rRset : allRRsetsWithoutLock(obj)) {
            final int i2 = 0;
            rRset.rrs(false).forEach(new Consumer() { // from class: org.xbill.DNS.h0
                @Override // java.util.function.Consumer
                public final void accept(Object obj2) {
                    switch (i2) {
                        case 0:
                            Zone.lambda$nodeToString$7(sb, (Record) obj2);
                            break;
                        default:
                            Zone.lambda$nodeToString$8(sb, (RRSIGRecord) obj2);
                            break;
                    }
                }
            });
            final int i3 = 1;
            rRset.sigs().forEach(new Consumer() { // from class: org.xbill.DNS.h0
                @Override // java.util.function.Consumer
                public final void accept(Object obj2) {
                    switch (i3) {
                        case 0:
                            Zone.lambda$nodeToString$7(sb, (Record) obj2);
                            break;
                        default:
                            Zone.lambda$nodeToString$8(sb, (RRSIGRecord) obj2);
                            break;
                    }
                }
            });
        }
    }

    private RRset oneRRsetWithoutLock(Object obj, int i2) {
        if (i2 == 255) {
            throw new IllegalArgumentException("Cannot lookup an exact match for type ANY");
        }
        if (!(obj instanceof List)) {
            RRset rRset = (RRset) obj;
            if (rRset.getType() == i2) {
                return rRset;
            }
            return null;
        }
        for (RRset rRset2 : (List) obj) {
            if (rRset2.getType() == i2) {
                return rRset2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeRRsetWithoutLock, reason: merged with bridge method [inline-methods] */
    public void lambda$removeRRset$4(Name name, int i2) {
        if (i2 == 6) {
            throw new IllegalArgumentException("Cannot remove SOA");
        }
        if (i2 == 2) {
            throw new IllegalArgumentException("Cannot remove all NS");
        }
        Object obj = this.data.get(name);
        if (obj == null) {
            return;
        }
        if (!(obj instanceof List)) {
            if (((RRset) obj).getType() != i2) {
                return;
            }
            this.data.remove(name);
            return;
        }
        List list = (List) obj;
        int i3 = 0;
        while (true) {
            if (i3 >= list.size()) {
                break;
            }
            if (((RRset) list.get(i3)).getType() == i2) {
                list.remove(i3);
                break;
            }
            i3++;
        }
        if (list.isEmpty()) {
            this.data.remove(name);
        }
    }

    private void validate() throws IOException {
        Object objExactName = exactName(this.origin);
        this.originNode = objExactName;
        if (objExactName == null) {
            throw new IOException(this.origin + ": no data specified");
        }
        RRset rRsetOneRRsetWithoutLock = oneRRsetWithoutLock(objExactName, 6);
        if (rRsetOneRRsetWithoutLock == null || rRsetOneRRsetWithoutLock.size() != 1) {
            throw new IOException(this.origin + ": exactly 1 SOA must be specified");
        }
        this.soaRecord = (SOARecord) rRsetOneRRsetWithoutLock.first();
        RRset rRsetOneRRsetWithoutLock2 = oneRRsetWithoutLock(this.originNode, 2);
        this.nsRRset = rRsetOneRRsetWithoutLock2;
        if (rRsetOneRRsetWithoutLock2 != null) {
            return;
        }
        throw new IOException(this.origin + ": no NS set specified");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T withReadLock(Supplier<T> supplier) {
        this.readLock.lock();
        try {
            return supplier.get();
        } finally {
            this.readLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void withWriteLock(Runnable runnable) {
        this.writeLock.lock();
        try {
            runnable.run();
        } finally {
            this.writeLock.unlock();
        }
    }

    public Iterator<RRset> AXFR() {
        return new ZoneIterator(true);
    }

    public void addRRset(RRset rRset) {
        if (rRset == null) {
            throw new IllegalArgumentException("rrset must not be null");
        }
        Name name = rRset.getName();
        int type = rRset.getType();
        if (type == 6) {
            if (!name.equals(this.origin)) {
                throw new IllegalArgumentException("SOA owner " + name + " does not match zone origin " + this.origin);
            }
            if (rRset.size() != 1) {
                throw new IllegalArgumentException(this.origin + ": exactly 1 SOA must be specified");
            }
        }
        if (name.subdomain(this.origin)) {
            withWriteLock(new com.google.android.datatransport.runtime.scheduling.jobscheduling.a(this, name, rRset, type));
            return;
        }
        throw new IllegalArgumentException("name " + name + " is absolute and not a subdomain of " + this.origin);
    }

    public <T extends Record> void addRecord(final T t) {
        if (t == null) {
            throw new IllegalArgumentException("r must not be null");
        }
        final Name name = t.getName();
        final int rRsetType = t.getRRsetType();
        final int type = t.getType();
        if (rRsetType == 6 && !name.equals(this.origin)) {
            throw new IllegalArgumentException("SOA owner " + name + " does not match zone origin " + this.origin);
        }
        if (name.subdomain(this.origin)) {
            withWriteLock(new Runnable() { // from class: org.xbill.DNS.g0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f58014a.lambda$addRecord$1(name, rRsetType, t, type);
                }
            });
            return;
        }
        throw new IllegalArgumentException("name " + name + " is absolute and not a subdomain of " + this.origin);
    }

    public RRset findExactMatch(Name name, int i2) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        Type.check(i2);
        return (RRset) withReadLock(new f0(this, name, i2, 0));
    }

    public SetResponse findRecords(Name name, int i2) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        Type.check(i2);
        return !name.subdomain(this.origin) ? SetResponse.ofType(SetResponseType.NXDOMAIN) : (SetResponse) withReadLock(new f0(this, name, i2, 1));
    }

    public int getDClass() {
        return 1;
    }

    public RRset getNS() {
        return (RRset) withReadLock(new i0(this, 1));
    }

    @Generated
    public Name getOrigin() {
        return this.origin;
    }

    public SOARecord getSOA() {
        return this.soaRecord;
    }

    @Override // java.lang.Iterable
    public Iterator<RRset> iterator() {
        return new ZoneIterator(false);
    }

    public void removeRRset(Name name, int i2) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        Type.check(i2);
        withWriteLock(new androidx.activity.g(this, name, i2, 8));
    }

    public void removeRecord(Record record) {
        if (record == null) {
            throw new IllegalArgumentException("r must not be null");
        }
        Name name = record.getName();
        int rRsetType = record.getRRsetType();
        if (record.getType() == 6) {
            throw new IllegalArgumentException("Cannot remove SOA record");
        }
        withWriteLock(new com.google.android.datatransport.runtime.scheduling.jobscheduling.a(rRsetType, 1, this, name, record));
    }

    public String toMasterFile() {
        StringBuilder sb = new StringBuilder();
        withReadLock(new j0(1, this, sb));
        return sb.toString();
    }

    public String toString() {
        return toMasterFile();
    }

    public Zone(Name name, String str) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.readWriteLock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.data = new ConcurrentSkipListMap();
        if (name == null) {
            throw new IllegalArgumentException("no zone name specified");
        }
        if (str != null) {
            this.origin = name;
            fromMasterFile(new Master(str, name));
            return;
        }
        throw new IllegalArgumentException("no file name specified");
    }

    public Zone(Name name, Record... recordArr) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.readWriteLock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.data = new ConcurrentSkipListMap();
        if (name == null) {
            throw new IllegalArgumentException("no zone name specified");
        }
        if (recordArr != null) {
            this.origin = name;
            for (Record record : recordArr) {
                maybeAddRecord(record);
            }
            validate();
            return;
        }
        throw new IllegalArgumentException("no records are specified");
    }

    public Zone(ZoneTransferIn zoneTransferIn) throws ZoneTransferException, IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.readWriteLock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.data = new ConcurrentSkipListMap();
        if (zoneTransferIn != null) {
            fromXFR(zoneTransferIn);
            return;
        }
        throw new IllegalArgumentException("no xfrin specified");
    }

    public Zone(Name name, int i2, String str) throws ZoneTransferException, IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.readWriteLock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.data = new ConcurrentSkipListMap();
        if (name != null) {
            DClass.check(i2);
            ZoneTransferIn zoneTransferInNewAXFR = ZoneTransferIn.newAXFR(name, str, (TSIG) null);
            zoneTransferInNewAXFR.setDClass(i2);
            fromXFR(zoneTransferInNewAXFR);
            return;
        }
        throw new IllegalArgumentException("no zone name specified");
    }
}

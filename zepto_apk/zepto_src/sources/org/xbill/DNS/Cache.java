package org.xbill.DNS;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Generated;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes5.dex */
public class Cache {
    private static final int DEFAULT_MAX_ENTRIES = 50000;

    @Generated
    private static final Logger log = LoggerFactory.b(Cache.class);
    private final CacheMap data;
    private final int dclass;
    private int maxcache;
    private int maxncache;

    public static class CacheMap extends LinkedHashMap<Name, Object> {
        private int maxsize;

        public CacheMap(int i2) {
            super(16, 0.75f, true);
            this.maxsize = i2;
        }

        public int getMaxSize() {
            return this.maxsize;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<Name, Object> entry) {
            return this.maxsize >= 0 && size() > this.maxsize;
        }

        public void setMaxSize(int i2) {
            this.maxsize = i2;
        }
    }

    public interface Element {
        int compareCredibility(int i2);

        boolean expired();

        int getType();

        boolean isAuthenticated();
    }

    public static class NegativeElement implements Element {
        int credibility;
        int expire;
        boolean isAuthenticated;
        Name name;
        int type;

        public NegativeElement(Name name, int i2, SOARecord sOARecord, int i3, long j2, boolean z) {
            this.name = name;
            this.type = i2;
            long jMin = sOARecord != null ? Math.min(sOARecord.getMinimum(), sOARecord.getTTL()) : 0L;
            this.credibility = i3;
            this.expire = Cache.limitExpire(jMin, j2);
            this.isAuthenticated = z;
        }

        @Override // org.xbill.DNS.Cache.Element
        public final int compareCredibility(int i2) {
            return this.credibility - i2;
        }

        @Override // org.xbill.DNS.Cache.Element
        public final boolean expired() {
            return ((int) (System.currentTimeMillis() / 1000)) >= this.expire;
        }

        @Override // org.xbill.DNS.Cache.Element
        public int getType() {
            return this.type;
        }

        @Override // org.xbill.DNS.Cache.Element
        public boolean isAuthenticated() {
            return this.isAuthenticated;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.type == 0) {
                sb.append("NXDOMAIN ");
                sb.append(this.name);
            } else {
                sb.append("NXRRSET ");
                sb.append(this.name);
                sb.append(StringUtils.SPACE);
                sb.append(Type.string(this.type));
            }
            sb.append(" cl = ");
            sb.append(this.credibility);
            return sb.toString();
        }
    }

    public Cache(int i2) {
        this.maxncache = -1;
        this.maxcache = -1;
        this.dclass = i2;
        this.data = new CacheMap(DEFAULT_MAX_ENTRIES);
    }

    private synchronized void addElement(Name name, Element element) {
        Object obj = this.data.get(name);
        if (obj == null) {
            this.data.put(name, element);
            return;
        }
        int type = element.getType();
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (((Element) list.get(i2)).getType() == type) {
                    list.set(i2, element);
                    return;
                }
            }
            list.add(element);
        } else {
            Element element2 = (Element) obj;
            if (element2.getType() == type) {
                this.data.put(name, element);
            } else {
                LinkedList linkedList = new LinkedList();
                linkedList.add(element2);
                linkedList.add(element);
                this.data.put(name, linkedList);
            }
        }
    }

    private synchronized Element[] allElements(Object obj) {
        if (!(obj instanceof List)) {
            return new Element[]{(Element) obj};
        }
        List list = (List) obj;
        return (Element[]) list.toArray(new Element[list.size()]);
    }

    private synchronized Object exactName(Name name) {
        return this.data.get(name);
    }

    private synchronized Element findElement(Name name, int i2, int i3) {
        Object objExactName = exactName(name);
        if (objExactName == null) {
            return null;
        }
        return oneElement(name, objExactName, i2, i3);
    }

    private List<RRset> findRecords(Name name, int i2, int i3) {
        SetResponse setResponseLookupRecords = lookupRecords(name, i2, i3);
        if (setResponseLookupRecords.isSuccessful()) {
            return setResponseLookupRecords.answers();
        }
        return null;
    }

    private int getCred(int i2, boolean z) {
        if (i2 == 1) {
            return z ? 4 : 3;
        }
        if (i2 == 2) {
            return z ? 4 : 3;
        }
        if (i2 == 3) {
            return 1;
        }
        throw new IllegalArgumentException("getCred: invalid section");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int limitExpire(long j2, long j3) {
        if (j3 >= 0 && j3 < j2) {
            j2 = j3;
        }
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) + j2;
        return (jCurrentTimeMillis < 0 || jCurrentTimeMillis > TTL.MAX_VALUE) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : (int) jCurrentTimeMillis;
    }

    private static void markAdditional(RRset rRset, Set<Name> set) {
        if (rRset.first().getAdditionalName() == null) {
            return;
        }
        Iterator<Record> it = rRset.rrs().iterator();
        while (it.hasNext()) {
            Name additionalName = it.next().getAdditionalName();
            if (additionalName != null) {
                set.add(additionalName);
            }
        }
    }

    private synchronized Element oneElement(Name name, Object obj, int i2, int i3) {
        try {
            if (i2 == 255) {
                throw new IllegalArgumentException("oneElement(ANY)");
            }
            if (obj instanceof List) {
                for (Element element : (List) obj) {
                    if (element.getType() == i2) {
                    }
                }
                element = null;
            } else {
                element = (Element) obj;
                if (element.getType() != i2) {
                    element = null;
                }
            }
            if (element == null) {
                return null;
            }
            if (element.expired()) {
                removeElement(name, i2);
                return null;
            }
            if (element.compareCredibility(i3) < 0) {
                return null;
            }
            return element;
        } finally {
        }
    }

    private synchronized void removeElement(Name name, int i2) {
        Object obj = this.data.get(name);
        if (obj == null) {
            return;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (((Element) list.get(i3)).getType() == i2) {
                    list.remove(i3);
                    if (list.isEmpty()) {
                        this.data.remove(name);
                    }
                    return;
                }
            }
        } else if (((Element) obj).getType() == i2) {
            this.data.remove(name);
        }
    }

    private synchronized void removeName(Name name) {
        this.data.remove(name);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.xbill.DNS.SetResponse addMessage(org.xbill.DNS.Message r20) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.Cache.addMessage(org.xbill.DNS.Message):org.xbill.DNS.SetResponse");
    }

    public synchronized void addNegative(Name name, int i2, SOARecord sOARecord, int i3) {
        addNegative(name, i2, sOARecord, i3, false);
    }

    public synchronized <T extends Record> void addRRset(RRset rRset, int i2) {
        addRRset(rRset, i2, false);
    }

    @Deprecated
    public synchronized void addRecord(Record record, int i2, Object obj) {
        addRecord(record, i2, false);
    }

    public synchronized void clearCache() {
        this.data.clear();
    }

    public List<RRset> findAnyRecords(Name name, int i2) {
        return findRecords(name, i2, 2);
    }

    public void flushName(Name name) {
        removeName(name);
    }

    public void flushSet(Name name, int i2) {
        removeElement(name, i2);
    }

    public int getDClass() {
        return this.dclass;
    }

    public int getMaxCache() {
        return this.maxcache;
    }

    public int getMaxEntries() {
        return this.data.getMaxSize();
    }

    public int getMaxNCache() {
        return this.maxncache;
    }

    public int getSize() {
        return this.data.size();
    }

    public synchronized SetResponse lookup(Name name, int i2, int i3) {
        try {
            int iLabels = name.labels();
            int i4 = iLabels;
            while (true) {
                boolean z = true;
                if (i4 < 1) {
                    return SetResponse.ofType(SetResponseType.UNKNOWN);
                }
                boolean z2 = i4 == 1;
                if (i4 != iLabels) {
                    z = false;
                }
                Name name2 = z2 ? Name.root : z ? name : new Name(name, iLabels - i4);
                Object obj = this.data.get(name2);
                if (obj != null) {
                    if (z && i2 == 255) {
                        Element[] elementArrAllElements = allElements(obj);
                        SetResponse setResponseOfType = SetResponse.ofType(SetResponseType.SUCCESSFUL);
                        int i5 = 0;
                        for (Element element : elementArrAllElements) {
                            if (element.expired()) {
                                removeElement(name2, element.getType());
                            } else if ((element instanceof CacheRRset) && element.compareCredibility(i3) >= 0) {
                                setResponseOfType.addRRset((CacheRRset) element);
                                i5++;
                            }
                        }
                        if (i5 > 0) {
                            return setResponseOfType;
                        }
                    } else if (z) {
                        Element elementOneElement = oneElement(name2, obj, i2, i3);
                        if (elementOneElement instanceof CacheRRset) {
                            return SetResponse.ofType(SetResponseType.SUCCESSFUL, (CacheRRset) elementOneElement);
                        }
                        if (elementOneElement != null) {
                            return SetResponse.ofType(SetResponseType.NXRRSET);
                        }
                        Element elementOneElement2 = oneElement(name2, obj, 5, i3);
                        if (elementOneElement2 instanceof CacheRRset) {
                            return SetResponse.ofType(SetResponseType.CNAME, (CacheRRset) elementOneElement2);
                        }
                    } else {
                        Element elementOneElement3 = oneElement(name2, obj, 39, i3);
                        if (elementOneElement3 instanceof CacheRRset) {
                            return SetResponse.ofType(SetResponseType.DNAME, (CacheRRset) elementOneElement3);
                        }
                    }
                    Element elementOneElement4 = oneElement(name2, obj, 2, i3);
                    if (elementOneElement4 instanceof CacheRRset) {
                        return SetResponse.ofType(SetResponseType.DELEGATION, (CacheRRset) elementOneElement4);
                    }
                    if (z && oneElement(name2, obj, 0, i3) != null) {
                        return SetResponse.ofType(SetResponseType.NXDOMAIN);
                    }
                }
                i4--;
            }
        } finally {
        }
    }

    public SetResponse lookupRecords(Name name, int i2, int i3) {
        return lookup(name, i2, i3);
    }

    public void setMaxCache(int i2) {
        this.maxcache = i2;
    }

    public void setMaxEntries(int i2) {
        this.data.setMaxSize(i2);
    }

    public void setMaxNCache(int i2) {
        this.maxncache = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        synchronized (this) {
            try {
                Iterator<Object> it = this.data.values().iterator();
                while (it.hasNext()) {
                    for (Element element : allElements(it.next())) {
                        sb.append(element);
                        sb.append(StringUtils.LF);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb.toString();
    }

    private synchronized void addNegative(Name name, int i2, SOARecord sOARecord, int i3, boolean z) {
        long jMin;
        if (sOARecord != null) {
            try {
                jMin = Math.min(sOARecord.getMinimum(), sOARecord.getTTL());
            } catch (Throwable th) {
                throw th;
            }
        } else {
            jMin = 0;
        }
        Element elementFindElement = findElement(name, i2, 0);
        if (jMin == 0) {
            if (elementFindElement != null && elementFindElement.compareCredibility(i3) <= 0) {
                removeElement(name, i2);
            }
        } else {
            if (elementFindElement != null && elementFindElement.compareCredibility(i3) <= 0) {
                elementFindElement = null;
            }
            if (elementFindElement == null) {
                addElement(name, new NegativeElement(name, i2, sOARecord, i3, this.maxncache, z));
            }
        }
    }

    private synchronized <T extends Record> void addRRset(RRset rRset, int i2, boolean z) {
        CacheRRset cacheRRset;
        try {
            long ttl = rRset.getTTL();
            Name name = rRset.getName();
            int type = rRset.getType();
            Element elementFindElement = findElement(name, type, 0);
            if (ttl == 0) {
                if (elementFindElement != null && elementFindElement.compareCredibility(i2) <= 0) {
                    removeElement(name, type);
                }
            } else {
                if (elementFindElement != null && elementFindElement.compareCredibility(i2) <= 0) {
                    elementFindElement = null;
                }
                if (elementFindElement == null) {
                    if (rRset instanceof CacheRRset) {
                        cacheRRset = (CacheRRset) rRset;
                    } else {
                        cacheRRset = new CacheRRset(rRset, i2, this.maxcache, z);
                    }
                    addElement(name, cacheRRset);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void addRecord(Record record, int i2) {
        addRecord(record, i2, false);
    }

    public List<RRset> findRecords(Name name, int i2) {
        return findRecords(name, i2, 3);
    }

    public static class CacheRRset extends RRset implements Element {
        int credibility;
        int expire;
        boolean isAuthenticated;

        public CacheRRset(Record record, int i2, long j2, boolean z) {
            this.credibility = i2;
            this.expire = Cache.limitExpire(record.getTTL(), j2);
            this.isAuthenticated = z;
            addRR(record);
        }

        @Override // org.xbill.DNS.Cache.Element
        public final int compareCredibility(int i2) {
            return this.credibility - i2;
        }

        @Override // org.xbill.DNS.Cache.Element
        public final boolean expired() {
            return ((int) (System.currentTimeMillis() / 1000)) >= this.expire;
        }

        @Override // org.xbill.DNS.Cache.Element
        public boolean isAuthenticated() {
            return this.isAuthenticated;
        }

        @Override // org.xbill.DNS.RRset
        public String toString() {
            return super.toString() + " cl = " + this.credibility;
        }

        public CacheRRset(RRset rRset, int i2, long j2, boolean z) {
            super(rRset);
            this.credibility = i2;
            this.expire = Cache.limitExpire(rRset.getTTL(), j2);
            this.isAuthenticated = z;
        }
    }

    private synchronized void addRecord(Record record, int i2, boolean z) {
        try {
            Name name = record.getName();
            int rRsetType = record.getRRsetType();
            if (Type.isRR(rRsetType)) {
                Element elementFindElement = findElement(name, rRsetType, i2);
                if (elementFindElement == null) {
                    addRRset(new CacheRRset(record, i2, this.maxcache, z), i2, z);
                } else if (elementFindElement.compareCredibility(i2) == 0 && (elementFindElement instanceof CacheRRset)) {
                    ((CacheRRset) elementFindElement).addRR(record);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public Cache() {
        this(1);
    }

    public Cache(String str) throws IOException {
        this(new Master(str));
    }

    public Cache(InputStream inputStream) throws IOException {
        this(new Master(inputStream));
    }

    private <T> Cache(Master master) throws IOException {
        this();
        while (true) {
            try {
                Record recordNextRecord = master.nextRecord();
                if (recordNextRecord == null) {
                    return;
                } else {
                    addRecord(recordNextRecord, 0);
                }
            } finally {
                master.close();
            }
        }
    }
}

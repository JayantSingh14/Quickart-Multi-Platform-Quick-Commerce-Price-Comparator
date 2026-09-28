package org.xbill.DNS.lookup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Generated;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;

/* loaded from: classes5.dex */
public final class LookupResult {
    private final List<Name> aliases;
    private final boolean isAuthenticated;
    private final Map<Record, Message> queryResponsePairs;
    private final List<Record> records;

    @Deprecated
    public LookupResult(List<Record> list, List<Name> list2) {
        this.records = Collections.unmodifiableList(new ArrayList(list));
        this.aliases = list2 == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(new ArrayList(list2));
        this.queryResponsePairs = Collections.EMPTY_MAP;
        this.isAuthenticated = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(Message message) {
        return message.getHeader().getFlag(10);
    }

    @Generated
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LookupResult)) {
            return false;
        }
        LookupResult lookupResult = (LookupResult) obj;
        if (isAuthenticated() != lookupResult.isAuthenticated()) {
            return false;
        }
        List<Record> records = getRecords();
        List<Record> records2 = lookupResult.getRecords();
        if (records != null ? !records.equals(records2) : records2 != null) {
            return false;
        }
        List<Name> aliases = getAliases();
        List<Name> aliases2 = lookupResult.getAliases();
        if (aliases != null ? !aliases.equals(aliases2) : aliases2 != null) {
            return false;
        }
        Map<Record, Message> queryResponsePairs = getQueryResponsePairs();
        Map<Record, Message> queryResponsePairs2 = lookupResult.getQueryResponsePairs();
        return queryResponsePairs != null ? queryResponsePairs.equals(queryResponsePairs2) : queryResponsePairs2 == null;
    }

    @Generated
    public List<Name> getAliases() {
        return this.aliases;
    }

    @Generated
    public Map<Record, Message> getQueryResponsePairs() {
        return this.queryResponsePairs;
    }

    @Generated
    public List<Record> getRecords() {
        return this.records;
    }

    @Generated
    public int hashCode() {
        int i2 = isAuthenticated() ? 79 : 97;
        List<Record> records = getRecords();
        int iHashCode = ((i2 + 59) * 59) + (records == null ? 43 : records.hashCode());
        List<Name> aliases = getAliases();
        int iHashCode2 = (iHashCode * 59) + (aliases == null ? 43 : aliases.hashCode());
        Map<Record, Message> queryResponsePairs = getQueryResponsePairs();
        return (iHashCode2 * 59) + (queryResponsePairs != null ? queryResponsePairs.hashCode() : 43);
    }

    @Generated
    public boolean isAuthenticated() {
        return this.isAuthenticated;
    }

    @Generated
    public String toString() {
        return "LookupResult(records=" + getRecords() + ", aliases=" + getAliases() + ", queryResponsePairs=" + getQueryResponsePairs() + ", isAuthenticated=" + isAuthenticated() + ")";
    }

    public LookupResult(boolean z) {
        this.queryResponsePairs = Collections.EMPTY_MAP;
        this.isAuthenticated = z;
        List list = Collections.EMPTY_LIST;
        this.records = list;
        this.aliases = list;
    }

    public LookupResult(Record record, boolean z, Record record2) {
        this.queryResponsePairs = Collections.singletonMap(record, null);
        this.isAuthenticated = z;
        this.records = Collections.singletonList(record2);
        this.aliases = Collections.EMPTY_LIST;
    }

    public LookupResult(LookupResult lookupResult, Record record, Message message, boolean z, List<Record> list, List<Name> list2) {
        HashMap map = new HashMap(lookupResult.queryResponsePairs.size() + 1);
        map.putAll(lookupResult.queryResponsePairs);
        map.put(record, message);
        Map<Record, Message> mapUnmodifiableMap = Collections.unmodifiableMap(map);
        this.queryResponsePairs = mapUnmodifiableMap;
        this.isAuthenticated = lookupResult.isAuthenticated && z && mapUnmodifiableMap.values().stream().filter(new org.xbill.DNS.config.a(3)).allMatch(new org.xbill.DNS.config.a(4));
        this.records = Collections.unmodifiableList(new ArrayList(list));
        this.aliases = Collections.unmodifiableList(new ArrayList(list2));
    }
}

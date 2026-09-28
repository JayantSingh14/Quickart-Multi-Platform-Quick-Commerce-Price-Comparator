package org.xbill.DNS;

import com.google.android.gms.common.api.Api;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes5.dex */
public class Compression {
    private static final int MAX_POINTER = 16383;
    private static final int TABLE_SIZE = 17;

    @Generated
    private static final Logger log = LoggerFactory.b(Compression.class);
    private final Entry[] table = new Entry[17];

    public static class Entry {
        Name name;
        Entry next;
        int pos;

        private Entry() {
        }
    }

    public void add(int i2, Name name) {
        if (i2 > MAX_POINTER) {
            return;
        }
        int iHashCode = (name.hashCode() & Api.BaseClientBuilder.API_PRIORITY_OTHER) % 17;
        Entry entry = new Entry();
        entry.name = name;
        entry.pos = i2;
        Entry[] entryArr = this.table;
        entry.next = entryArr[iHashCode];
        entryArr[iHashCode] = entry;
        log.d("Adding {} at {}", name, Integer.valueOf(i2));
    }

    public int get(Name name) {
        int i2 = -1;
        for (Entry entry = this.table[(name.hashCode() & Api.BaseClientBuilder.API_PRIORITY_OTHER) % 17]; entry != null; entry = entry.next) {
            if (entry.name.equals(name)) {
                i2 = entry.pos;
            }
        }
        log.d("Looking for {}, found {}", name, Integer.valueOf(i2));
        return i2;
    }
}

package org.xbill.DNS;

import java.io.IOException;

/* loaded from: classes5.dex */
public class Update extends Message {
    private final int dclass;
    private final Name origin;

    public Update(Name name, int i2) {
        if (!name.isAbsolute()) {
            throw new RelativeNameException(name);
        }
        DClass.check(i2);
        getHeader().setOpcode(5);
        addRecord(Record.newRecord(name, 6, 1), 0);
        this.origin = name;
        this.dclass = i2;
    }

    private void newPrereq(Record record) {
        addRecord(record, 1);
    }

    private void newUpdate(Record record) {
        addRecord(record, 2);
    }

    public void absent(Name name) {
        newPrereq(Record.newRecord(name, 255, 254, 0L));
    }

    public void add(Name name, int i2, long j2, String str) throws IOException {
        newUpdate(Record.fromString(name, i2, this.dclass, j2, str, this.origin));
    }

    public void delete(Name name) {
        newUpdate(Record.newRecord(name, 255, 255, 0L));
    }

    public void present(Name name) {
        newPrereq(Record.newRecord(name, 255, 255, 0L));
    }

    public void replace(Name name, int i2, long j2, String str) throws IOException {
        delete(name, i2);
        add(name, i2, j2, str);
    }

    public void absent(Name name, int i2) {
        newPrereq(Record.newRecord(name, i2, 254, 0L));
    }

    public void add(Name name, int i2, long j2, Tokenizer tokenizer) throws IOException {
        newUpdate(Record.fromString(name, i2, this.dclass, j2, tokenizer, this.origin));
    }

    public void delete(Name name, int i2) {
        newUpdate(Record.newRecord(name, i2, 255, 0L));
    }

    public void present(Name name, int i2) {
        newPrereq(Record.newRecord(name, i2, 255, 0L));
    }

    public void add(Record record) {
        newUpdate(record);
    }

    public void delete(Name name, int i2, String str) throws IOException {
        newUpdate(Record.fromString(name, i2, 254, 0L, str, this.origin));
    }

    public void present(Name name, int i2, String str) throws IOException {
        newPrereq(Record.fromString(name, i2, this.dclass, 0L, str, this.origin));
    }

    public void replace(Name name, int i2, long j2, Tokenizer tokenizer) throws IOException {
        delete(name, i2);
        add(name, i2, j2, tokenizer);
    }

    public void add(Record[] recordArr) {
        for (Record record : recordArr) {
            add(record);
        }
    }

    public void delete(Name name, int i2, Tokenizer tokenizer) throws IOException {
        newUpdate(Record.fromString(name, i2, 254, 0L, tokenizer, this.origin));
    }

    public void present(Name name, int i2, Tokenizer tokenizer) throws IOException {
        newPrereq(Record.fromString(name, i2, this.dclass, 0L, tokenizer, this.origin));
    }

    public void delete(Record record) {
        newUpdate(record.withDClass(254, 0L));
    }

    public void present(Record record) {
        newPrereq(record);
    }

    public void replace(Record record) {
        delete(record.getName(), record.getType());
        add(record);
    }

    public <T extends Record> void add(RRset rRset) {
        rRset.rrs().forEach(new e0(this, 0));
    }

    public void delete(Record[] recordArr) {
        for (Record record : recordArr) {
            delete(record);
        }
    }

    public void replace(Record[] recordArr) {
        for (Record record : recordArr) {
            replace(record);
        }
    }

    public <T extends Record> void delete(RRset rRset) {
        rRset.rrs().forEach(new e0(this, 1));
    }

    public <T extends Record> void replace(RRset rRset) {
        delete(rRset.getName(), rRset.getType());
        rRset.rrs().forEach(new e0(this, 0));
    }

    public Update(Name name) {
        this(name, 1);
    }
}

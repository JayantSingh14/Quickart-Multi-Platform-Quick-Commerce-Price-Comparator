package org.xbill.DNS;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class Master implements AutoCloseable {
    private int currentDClass;
    private long currentTTL;
    private int currentType;
    private long defaultTTL;
    private File file;
    private Generator generator;
    private List<Generator> generators;
    private boolean includeThrowsException;
    private Master included;
    private Record last;
    private boolean needSOATTL;
    private boolean noExpandGenerate;
    private boolean noExpandIncludes;
    private Name origin;
    private final Tokenizer st;

    public Master(File file, Name name, long j2) throws IOException {
        this.last = null;
        this.included = null;
        if (name != null && !name.isAbsolute()) {
            throw new RelativeNameException(name);
        }
        this.file = file;
        this.st = new Tokenizer(file);
        this.origin = name;
        this.defaultTTL = j2;
    }

    private void endGenerate() throws IOException {
        this.st.getEOL();
        this.generator = null;
    }

    private Record nextGenerated() throws IOException {
        try {
            return this.generator.nextRecord();
        } catch (TextParseException e2) {
            throw this.st.exception("Parsing $GENERATE: " + e2.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
    
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0171, code lost:
    
        parseTTLClassAndType();
        r0 = org.xbill.DNS.Record.fromString(r4, r11.currentType, r11.currentDClass, r11.currentTTL, r11.st, r11.origin);
        r11.last = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0186, code lost:
    
        if (r11.needSOATTL == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0188, code lost:
    
        r0 = ((org.xbill.DNS.SOARecord) r0).getMinimum();
        r11.last.setTTL(r0);
        r11.defaultTTL = r0;
        r11.needSOATTL = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0199, code lost:
    
        return r11.last;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.xbill.DNS.Record nextRecordInternal() throws java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.Master.nextRecordInternal():org.xbill.DNS.Record");
    }

    private Name parseName(String str, Name name) throws TextParseException {
        try {
            return Name.fromString(str, name);
        } catch (TextParseException e2) {
            throw this.st.exception(e2.getMessage());
        }
    }

    private void parseTTLClassAndType() throws IOException {
        boolean z;
        String string = this.st.getString();
        int iValue = DClass.value(string);
        this.currentDClass = iValue;
        if (iValue >= 0) {
            string = this.st.getString();
            z = true;
        } else {
            z = false;
        }
        this.currentTTL = -1L;
        try {
            this.currentTTL = TTL.parseTTL(string);
            string = this.st.getString();
        } catch (NumberFormatException unused) {
            long j2 = this.defaultTTL;
            if (j2 >= 0) {
                this.currentTTL = j2;
            } else {
                Record record = this.last;
                if (record != null) {
                    this.currentTTL = record.getTTL();
                }
            }
        }
        if (!z) {
            int iValue2 = DClass.value(string);
            this.currentDClass = iValue2;
            if (iValue2 >= 0) {
                string = this.st.getString();
            } else {
                this.currentDClass = 1;
            }
        }
        int iValue3 = Type.value(string);
        this.currentType = iValue3;
        if (iValue3 < 0) {
            throw this.st.exception("Invalid type '" + string + "'");
        }
        if (this.currentTTL < 0) {
            if (iValue3 != 6) {
                throw this.st.exception("missing TTL");
            }
            this.needSOATTL = true;
            this.currentTTL = 0L;
        }
    }

    private long parseUInt32(String str) throws NumberFormatException {
        if (!Character.isDigit(str.charAt(0))) {
            return -1L;
        }
        try {
            long j2 = Long.parseLong(str);
            if (Utils.isUInt32(j2)) {
                return j2;
            }
            return -1L;
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    private void startGenerate() throws IOException, NumberFormatException {
        String strSubstring;
        String identifier = this.st.getIdentifier();
        int iIndexOf = identifier.indexOf("-");
        if (iIndexOf < 0) {
            throw this.st.exception("Invalid $GENERATE range specifier: ".concat(identifier));
        }
        String strSubstring2 = identifier.substring(0, iIndexOf);
        String strSubstring3 = identifier.substring(iIndexOf + 1);
        int iIndexOf2 = strSubstring3.indexOf("/");
        if (iIndexOf2 >= 0) {
            strSubstring = strSubstring3.substring(iIndexOf2 + 1);
            strSubstring3 = strSubstring3.substring(0, iIndexOf2);
        } else {
            strSubstring = null;
        }
        long uInt32 = parseUInt32(strSubstring2);
        long uInt322 = parseUInt32(strSubstring3);
        long uInt323 = strSubstring != null ? parseUInt32(strSubstring) : 1L;
        if (uInt32 < 0 || uInt322 < 0 || uInt32 > uInt322 || uInt323 <= 0) {
            throw this.st.exception("Invalid $GENERATE range specifier: ".concat(identifier));
        }
        String identifier2 = this.st.getIdentifier();
        parseTTLClassAndType();
        if (!Generator.supportedType(this.currentType)) {
            throw this.st.exception("$GENERATE does not support " + Type.string(this.currentType) + " records");
        }
        String identifier3 = this.st.getIdentifier();
        this.st.getEOL();
        this.st.unget();
        this.generator = new Generator(uInt32, uInt322, uInt323, identifier2, this.currentType, this.currentDClass, this.currentTTL, identifier3, this.origin);
        if (this.generators == null) {
            this.generators = new ArrayList(1);
        }
        this.generators.add(this.generator);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Tokenizer tokenizer = this.st;
        if (tokenizer != null) {
            tokenizer.close();
        }
    }

    public void disableIncludes() {
        disableIncludes(false);
    }

    public void expandGenerate(boolean z) {
        this.noExpandGenerate = !z;
    }

    public Iterator<Generator> generators() {
        List<Generator> list = this.generators;
        return list != null ? Collections.unmodifiableList(list).iterator() : Collections.emptyIterator();
    }

    public Record nextRecord() throws IOException {
        try {
            Record recordNextRecordInternal = nextRecordInternal();
            if (recordNextRecordInternal == null) {
            }
            return recordNextRecordInternal;
        } finally {
            this.st.close();
        }
    }

    public void disableIncludes(boolean z) {
        this.noExpandIncludes = true;
        this.includeThrowsException = z;
    }

    public Master(String str, Name name, long j2) throws IOException {
        this(new File(str), name, j2);
    }

    public Master(String str, Name name) throws IOException {
        this(new File(str), name, -1L);
    }

    public Master(String str) throws IOException {
        this(new File(str), (Name) null, -1L);
    }

    public Master(InputStream inputStream, Name name, long j2) {
        this.last = null;
        this.included = null;
        if (name != null && !name.isAbsolute()) {
            throw new RelativeNameException(name);
        }
        this.st = new Tokenizer(inputStream);
        this.origin = name;
        this.defaultTTL = j2;
    }

    public Master(InputStream inputStream, Name name) {
        this(inputStream, name, -1L);
    }

    public Master(InputStream inputStream) {
        this(inputStream, (Name) null, -1L);
    }
}

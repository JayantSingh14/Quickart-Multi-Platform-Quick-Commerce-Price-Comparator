package org.xbill.DNS;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.xbill.DNS.utils.base16;
import org.xbill.DNS.utils.base32;
import org.xbill.DNS.utils.base64;

/* loaded from: classes5.dex */
public class Tokenizer implements AutoCloseable {
    public static final int COMMENT = 5;
    private static final String DEFAULT_DELIMITERS = " \t\n;()\"";
    public static final int EOF = 0;
    public static final int EOL = 1;
    public static final int IDENTIFIER = 3;
    public static final int QUOTED_STRING = 4;
    private static final String QUOTES = "\"";
    public static final int WHITESPACE = 2;
    private Token current;
    private String delimiters;
    private String filename;
    private final PushbackInputStream is;
    private int line;
    private int multiline;
    private boolean quoting;
    private final StringBuilder sb;
    private boolean ungottenToken;
    private boolean wantClose;

    public static class Token {

        @Deprecated
        public int type;

        @Deprecated
        public String value;

        public boolean isEOL() {
            int i2 = this.type;
            return i2 == 1 || i2 == 0;
        }

        public boolean isString() {
            int i2 = this.type;
            return i2 == 3 || i2 == 4;
        }

        public String toString() {
            int i2 = this.type;
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "<unknown>" : android.support.v4.media.b.r(new StringBuilder("<comment: "), this.value, ">") : android.support.v4.media.b.r(new StringBuilder("<quoted_string: "), this.value, ">") : android.support.v4.media.b.r(new StringBuilder("<identifier: "), this.value, ">") : "<whitespace>" : "<eol>" : "<eof>";
        }

        public int type() {
            return this.type;
        }

        public String value() {
            return this.value;
        }

        private Token(int i2, StringBuilder sb) {
            if (i2 < 0) {
                throw new IllegalArgumentException();
            }
            this.type = i2;
            this.value = sb == null ? null : sb.toString();
        }
    }

    public Tokenizer(InputStream inputStream) {
        this.is = new PushbackInputStream(inputStream instanceof BufferedInputStream ? inputStream : new BufferedInputStream(inputStream), 2);
        this.ungottenToken = false;
        this.multiline = 0;
        this.quoting = false;
        this.delimiters = DEFAULT_DELIMITERS;
        this.sb = new StringBuilder();
        this.filename = "<none>";
        this.line = 1;
    }

    private void checkUnbalancedParens() throws TextParseException {
        if (this.multiline > 0) {
            throw exception("unbalanced parentheses");
        }
    }

    private int getChar() throws IOException {
        int i2 = this.is.read();
        if (i2 == 13) {
            int i3 = this.is.read();
            if (i3 != 10) {
                this.is.unread(i3);
            }
            i2 = 10;
        }
        if (i2 == 10) {
            this.line++;
        }
        return i2;
    }

    private String getIdentifier(String str) throws IOException {
        Token token = get();
        if (token.type == 3) {
            return token.value;
        }
        throw exception("expected " + str);
    }

    private String remainingStrings() throws IOException {
        StringBuilder sb = null;
        while (true) {
            Token token = get();
            if (!token.isString()) {
                break;
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(token.value);
        }
        unget();
        if (sb == null) {
            return null;
        }
        return sb.toString();
    }

    private Token setCurrentToken(int i2, StringBuilder sb) {
        Token token = new Token(i2, sb);
        this.current = token;
        return token;
    }

    private int skipWhitespace() throws IOException {
        int i2;
        int i3 = 0;
        while (true) {
            i2 = getChar();
            if (i2 != 32 && i2 != 9 && (i2 != 10 || this.multiline <= 0)) {
                break;
            }
            i3++;
        }
        ungetChar(i2);
        return i3;
    }

    private void ungetChar(int i2) throws IOException {
        if (i2 == -1) {
            return;
        }
        this.is.unread(i2);
        if (i2 == 10) {
            this.line--;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.wantClose) {
            try {
                this.is.close();
            } catch (IOException unused) {
            }
        }
    }

    public TextParseException exception(String str) {
        return new TextParseException(this.filename + ":" + this.line + ": " + str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
    
        if (r10 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x012b, code lost:
    
        ungetChar(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0134, code lost:
    
        if (r9.sb.length() != 0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0136, code lost:
    
        if (r10 == 4) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0138, code lost:
    
        checkUnbalancedParens();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x013f, code lost:
    
        return setCurrentToken(0, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0146, code lost:
    
        return setCurrentToken(r10, r9.sb);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        if (r11 != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.xbill.DNS.Tokenizer.Token get(boolean r10, boolean r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.Tokenizer.get(boolean, boolean):org.xbill.DNS.Tokenizer$Token");
    }

    public InetAddress getAddress(int i2) throws IOException {
        try {
            return Address.getByAddress(getIdentifier("an address"), i2);
        } catch (UnknownHostException e2) {
            throw exception(e2.getMessage());
        }
    }

    public byte[] getAddressBytes(int i2) throws IOException {
        String identifier = getIdentifier("an address");
        byte[] v4 = i2 == 1 ? IPAddressUtils.parseV4(identifier) : i2 == 2 ? IPAddressUtils.parseV6(identifier) : null;
        if (v4 != null) {
            return v4;
        }
        throw exception("Invalid address: " + identifier);
    }

    public byte[] getBase32String(base32 base32Var) throws IOException {
        byte[] bArrFromString = base32Var.fromString(getIdentifier("a base32 string"));
        if (bArrFromString != null) {
            return bArrFromString;
        }
        throw exception("invalid base32 encoding");
    }

    public byte[] getBase64(boolean z) throws IOException {
        String strRemainingStrings = remainingStrings();
        if (strRemainingStrings == null) {
            if (z) {
                throw exception("expected base64 encoded string");
            }
            return null;
        }
        byte[] bArrFromString = base64.fromString(strRemainingStrings);
        if (bArrFromString != null) {
            return bArrFromString;
        }
        throw exception("invalid base64 encoding");
    }

    public void getEOL() throws IOException {
        int i2 = get().type;
        if (i2 != 1 && i2 != 0) {
            throw exception("expected EOL or EOF");
        }
    }

    public byte[] getHex(boolean z) throws IOException {
        String strRemainingStrings = remainingStrings();
        if (strRemainingStrings == null) {
            if (z) {
                throw exception("expected hex encoded string");
            }
            return null;
        }
        byte[] bArrFromString = base16.fromString(strRemainingStrings);
        if (bArrFromString != null) {
            return bArrFromString;
        }
        throw exception("invalid hex encoding");
    }

    public byte[] getHexString() throws IOException {
        byte[] bArrFromString = base16.fromString(getIdentifier("a hex string"));
        if (bArrFromString != null) {
            return bArrFromString;
        }
        throw exception("invalid hex encoding");
    }

    public long getLong() throws IOException {
        String identifier = getIdentifier("an integer");
        if (!Character.isDigit(identifier.charAt(0))) {
            throw exception("expected an integer");
        }
        try {
            return Long.parseLong(identifier);
        } catch (NumberFormatException unused) {
            throw exception("expected an integer");
        }
    }

    public Name getName(Name name) throws IOException {
        try {
            Name nameFromString = Name.fromString(getIdentifier("a name"), name);
            if (nameFromString.isAbsolute()) {
                return nameFromString;
            }
            throw new RelativeNameException(nameFromString);
        } catch (TextParseException e2) {
            throw exception(e2.getMessage());
        }
    }

    public String getString() throws IOException {
        Token token = get();
        if (token.isString()) {
            return token.value;
        }
        throw exception("expected a string");
    }

    public long getTTL() throws IOException {
        try {
            return TTL.parseTTL(getIdentifier("a TTL value"));
        } catch (NumberFormatException unused) {
            throw exception("expected a TTL value");
        }
    }

    public long getTTLLike() throws IOException {
        try {
            return TTL.parse(getIdentifier("a TTL-like value"), false);
        } catch (NumberFormatException unused) {
            throw exception("expected a TTL-like value");
        }
    }

    public int getUInt16() throws IOException {
        long j2 = getLong();
        if (Utils.isUInt16(j2)) {
            return (int) j2;
        }
        throw exception("expected an 16 bit unsigned integer");
    }

    public long getUInt32() throws IOException {
        long j2 = getLong();
        if (Utils.isUInt32(j2)) {
            return j2;
        }
        throw exception("expected an 32 bit unsigned integer");
    }

    public int getUInt8() throws IOException {
        long j2 = getLong();
        if (Utils.isUInt8(j2)) {
            return (int) j2;
        }
        throw exception("expected an 8 bit unsigned integer");
    }

    public void unget() {
        if (this.ungottenToken) {
            throw new IllegalStateException("Cannot unget multiple tokens");
        }
        if (this.current.type == 1) {
            this.line--;
        }
        this.ungottenToken = true;
    }

    public byte[] getBase64() throws IOException {
        return getBase64(false);
    }

    public byte[] getHex() throws IOException {
        return getHex(false);
    }

    public String getIdentifier() throws IOException {
        return getIdentifier("an identifier");
    }

    public Tokenizer(String str) {
        this(new ByteArrayInputStream(str.getBytes()));
    }

    public Tokenizer(File file) throws FileNotFoundException {
        this(new FileInputStream(file));
        this.wantClose = true;
        this.filename = file.getName();
    }

    public Token get() throws IOException {
        return get(false, false);
    }
}

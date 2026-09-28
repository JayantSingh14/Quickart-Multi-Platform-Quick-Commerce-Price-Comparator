package ch.qos.logback.core.pattern.parser;

import android.support.v4.media.b;
import ch.qos.logback.core.pattern.Converter;
import ch.qos.logback.core.pattern.FormatInfo;
import ch.qos.logback.core.pattern.IdentityCompositeConverter;
import ch.qos.logback.core.pattern.ReplacingCompositeConverter;
import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.ScanException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class Parser<E> extends ContextAwareBase {

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap f13680f;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f13681d;

    /* renamed from: e, reason: collision with root package name */
    public int f13682e;

    static {
        HashMap map = new HashMap();
        f13680f = map;
        map.put("BARE", IdentityCompositeConverter.class.getName());
        map.put("replace", ReplacingCompositeConverter.class.getName());
    }

    public Parser(String str) throws ScanException {
        RegularEscapeUtil regularEscapeUtil = new RegularEscapeUtil();
        this.f13682e = 0;
        try {
            this.f13681d = new TokenStream(str, regularEscapeUtil).b();
        } catch (IllegalArgumentException e2) {
            ScanException scanException = new ScanException("Failed to initialize Parser");
            scanException.f13743a = e2;
            throw scanException;
        }
    }

    public static void X1(Token token, String str) {
        if (token == null) {
            throw new IllegalStateException("All tokens consumed but was expecting ".concat(str));
        }
    }

    public final SimpleKeywordNode T1() throws ScanException {
        Token tokenY1 = Y1();
        X1(tokenY1, "a LEFT_PARENTHESIS or KEYWORD");
        Token token = null;
        ArrayList arrayList = this.f13681d;
        int i2 = tokenY1.f13687a;
        if (i2 == 1004) {
            if (this.f13682e < arrayList.size()) {
                int i3 = this.f13682e;
                this.f13682e = i3 + 1;
                token = (Token) arrayList.get(i3);
            }
            SimpleKeywordNode simpleKeywordNode = new SimpleKeywordNode(1, token.f13688b);
            Token tokenY12 = Y1();
            if (tokenY12 != null && tokenY12.f13687a == 1006) {
                simpleKeywordNode.f13683e = (List) tokenY12.f13688b;
                V1();
            }
            return simpleKeywordNode;
        }
        if (i2 != 1005) {
            throw new IllegalStateException("Unexpected token " + tokenY1);
        }
        V1();
        CompositeNode compositeNode = new CompositeNode(2, tokenY1.f13688b.toString());
        compositeNode.f13669f = U1();
        if (this.f13682e < arrayList.size()) {
            int i4 = this.f13682e;
            this.f13682e = i4 + 1;
            token = (Token) arrayList.get(i4);
        }
        if (token == null || token.f13687a != 41) {
            String str = "Expecting RIGHT_PARENTHESIS token but got " + token;
            l1(str);
            l1("See also http://logback.qos.ch/codes.html#missingRightParenthesis");
            throw new ScanException(str);
        }
        Token tokenY13 = Y1();
        if (tokenY13 != null && tokenY13.f13687a == 1006) {
            compositeNode.f13683e = (List) tokenY13.f13688b;
            V1();
        }
        return compositeNode;
    }

    public final Node U1() throws ScanException, NumberFormatException {
        Node nodeT1;
        String strSubstring;
        Token tokenY1 = Y1();
        X1(tokenY1, "a LITERAL or '%'");
        int i2 = tokenY1.f13687a;
        if (i2 == 37) {
            V1();
            Token tokenY12 = Y1();
            X1(tokenY12, "a FORMAT_MODIFIER, SIMPLE_KEYWORD or COMPOUND_KEYWORD");
            if (tokenY12.f13687a == 1002) {
                String str = (String) tokenY12.f13688b;
                if (str == null) {
                    throw new NullPointerException("Argument cannot be null");
                }
                FormatInfo formatInfo = new FormatInfo();
                int iIndexOf = str.indexOf(46);
                if (iIndexOf != -1) {
                    String strSubstring2 = str.substring(0, iIndexOf);
                    int i3 = iIndexOf + 1;
                    if (i3 == str.length()) {
                        throw new IllegalArgumentException(b.D("Formatting string [", str, "] should not end with '.'"));
                    }
                    strSubstring = str.substring(i3);
                    str = strSubstring2;
                } else {
                    strSubstring = null;
                }
                if (str != null && str.length() > 0) {
                    int i4 = Integer.parseInt(str);
                    if (i4 >= 0) {
                        formatInfo.f13652a = i4;
                    } else {
                        formatInfo.f13652a = -i4;
                        formatInfo.f13654c = false;
                    }
                }
                if (strSubstring != null && strSubstring.length() > 0) {
                    int i5 = Integer.parseInt(strSubstring);
                    if (i5 >= 0) {
                        formatInfo.f13653b = i5;
                    } else {
                        formatInfo.f13653b = -i5;
                        formatInfo.f13655d = false;
                    }
                }
                V1();
                SimpleKeywordNode simpleKeywordNodeT1 = T1();
                simpleKeywordNodeT1.f13670d = formatInfo;
                nodeT1 = simpleKeywordNodeT1;
            } else {
                nodeT1 = T1();
            }
        } else if (i2 != 1000) {
            nodeT1 = null;
        } else {
            V1();
            nodeT1 = new Node(0, tokenY1.f13688b);
        }
        if (nodeT1 == null) {
            return null;
        }
        Node nodeU1 = Y1() != null ? U1() : null;
        if (nodeU1 != null) {
            nodeT1.f13673c = nodeU1;
        }
        return nodeT1;
    }

    public final void V1() {
        this.f13682e++;
    }

    public final Converter W1(Node node, HashMap map) {
        Compiler compiler = new Compiler(node, map);
        compiler.V(this.f13733b);
        return compiler.U1();
    }

    public final Token Y1() {
        int i2 = this.f13682e;
        ArrayList arrayList = this.f13681d;
        if (i2 < arrayList.size()) {
            return (Token) arrayList.get(this.f13682e);
        }
        return null;
    }
}

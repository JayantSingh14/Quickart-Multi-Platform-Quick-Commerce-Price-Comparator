package ch.qos.logback.core.html;

import android.support.v4.media.a;
import android.support.v4.media.b;
import ch.qos.logback.classic.html.DefaultCssBuilder;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;
import ch.qos.logback.core.pattern.Converter;
import ch.qos.logback.core.pattern.ConverterUtil;
import ch.qos.logback.core.pattern.parser.Node;
import ch.qos.logback.core.pattern.parser.Parser;
import ch.qos.logback.core.spi.ScanException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class HTMLLayoutBase<E> extends LayoutBase<E> {

    /* renamed from: e, reason: collision with root package name */
    public String f13488e;

    /* renamed from: f, reason: collision with root package name */
    public Converter f13489f;

    /* renamed from: h, reason: collision with root package name */
    public DefaultCssBuilder f13491h;

    /* renamed from: g, reason: collision with root package name */
    public final String f13490g = "Logback Log Messages";

    /* renamed from: i, reason: collision with root package name */
    public long f13492i = 0;

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.Layout
    public final String D0() {
        StringBuilder sb = new StringBuilder("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
        String str = CoreConstants.f13442a;
        b.B(sb, str, "<html>", str, "  <head>");
        sb.append(str);
        sb.append("    <title>");
        a.u(sb, this.f13490g, "</title>", str);
        this.f13491h.getClass();
        sb.append("<style  type=\"text/css\">");
        sb.append(str);
        sb.append("table { margin-left: 2em; margin-right: 2em; border-left: 2px solid #AAA; }");
        b.B(sb, str, "TR.even { background: #FFFFFF; }", str, "TR.odd { background: #EAEAEA; }");
        b.B(sb, str, "TR.warn TD.Level, TR.error TD.Level, TR.fatal TD.Level {font-weight: bold; color: #FF4040 }", str, "TD { padding-right: 1ex; padding-left: 1ex; border-right: 2px solid #AAA; }");
        b.B(sb, str, "TD.Time, TD.Date { text-align: right; font-family: courier, monospace; font-size: smaller; }", str, "TD.Thread { text-align: left; }");
        b.B(sb, str, "TD.Level { text-align: right; }", str, "TD.Logger { text-align: left; }");
        b.B(sb, str, "TR.header { background: #596ED5; color: #FFF; font-weight: bold; font-size: larger; }", str, "TD.Exception { background: #A2AEE8; font-family: courier, monospace;}");
        b.B(sb, str, "</style>", str, str);
        return a.n(sb, "  </head>", str, "<body>", str);
    }

    public final void T1(StringBuilder sb) {
        Converter converter = this.f13489f;
        sb.append("<tr class=\"header\">");
        sb.append(CoreConstants.f13442a);
        while (converter != null) {
            if (U1(converter) == null) {
                converter = converter.f13648a;
            } else {
                sb.append("<td class=\"");
                sb.append(U1(converter));
                sb.append("\">");
                sb.append(U1(converter));
                sb.append("</td>");
                sb.append(CoreConstants.f13442a);
                converter = converter.f13648a;
            }
        }
        sb.append("</tr>");
        sb.append(CoreConstants.f13442a);
    }

    public String U1(Converter converter) {
        String simpleName = converter.getClass().getSimpleName();
        int iIndexOf = simpleName.indexOf("Converter");
        return iIndexOf == -1 ? simpleName : simpleName.substring(0, iIndexOf);
    }

    public abstract HashMap V1();

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.Layout
    public final String Z() {
        StringBuilder sbW = b.w("<hr/>");
        String str = CoreConstants.f13442a;
        sbW.append(str);
        sbW.append("<p>Log session start time ");
        sbW.append(new Date());
        sbW.append("</p><p></p>");
        sbW.append(str);
        a.u(sbW, str, "<table cellspacing=\"0\">", str);
        T1(sbW);
        return sbW.toString();
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.Layout
    public final String j0() {
        return b.r(new StringBuilder(), CoreConstants.f13442a, "</body></html>");
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.Layout
    public final String j1() {
        return "</table>";
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.spi.LifeCycle
    public void start() throws NumberFormatException {
        Map map;
        try {
            Parser parser = new Parser(this.f13488e);
            parser.V(this.f13733b);
            Node nodeU1 = parser.U1();
            HashMap map2 = new HashMap();
            HashMap mapV1 = V1();
            if (mapV1 != null) {
                map2.putAll(mapV1);
            }
            Context context = this.f13733b;
            if (context != null && (map = (Map) context.n0("PATTERN_RULE_REGISTRY")) != null) {
                map2.putAll(map);
            }
            Converter converterW1 = parser.W1(nodeU1, map2);
            this.f13489f = converterW1;
            ConverterUtil.a(converterW1);
            this.f13445d = true;
        } catch (ScanException e2) {
            o1("Incorrect pattern found", e2);
        }
    }
}

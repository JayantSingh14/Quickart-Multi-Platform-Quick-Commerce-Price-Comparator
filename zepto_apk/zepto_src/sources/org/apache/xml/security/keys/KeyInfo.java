package org.apache.xml.security.keys;

import com.google.android.gms.internal.pal.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.utils.SignatureElementProxy;
import org.w3c.dom.Element;

/* loaded from: classes5.dex */
public class KeyInfo extends SignatureElementProxy {

    /* renamed from: a, reason: collision with root package name */
    static Log f57184a;

    /* renamed from: d, reason: collision with root package name */
    static final List f57185d;

    /* renamed from: g, reason: collision with root package name */
    static boolean f57186g;

    /* renamed from: h, reason: collision with root package name */
    static Class f57187h;

    /* renamed from: b, reason: collision with root package name */
    List f57188b;

    /* renamed from: c, reason: collision with root package name */
    List f57189c;

    /* renamed from: e, reason: collision with root package name */
    List f57190e;

    /* renamed from: f, reason: collision with root package name */
    List f57191f;

    static {
        Class clsA = f57187h;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.keys.KeyInfo");
            f57187h = clsA;
        }
        f57184a = LogFactory.getLog(clsA.getName());
        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        f57185d = Collections.unmodifiableList(arrayList);
        f57186g = false;
    }

    public KeyInfo(Element element, String str) {
        super(element, str);
        this.f57188b = null;
        this.f57189c = null;
        this.f57190e = null;
        this.f57191f = f57185d;
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    @Override // org.apache.xml.security.utils.ElementProxy
    public String e() {
        return "KeyInfo";
    }

    public static void a() throws Throwable {
        if (f57186g) {
            return;
        }
        if (f57184a == null) {
            Class clsA = f57187h;
            if (clsA == null) {
                clsA = a("org.apache.xml.security.keys.KeyInfo");
                f57187h = clsA;
            }
            Log log = LogFactory.getLog(clsA.getName());
            f57184a = log;
            log.error("Had to assign log in the init() function");
        }
        f57186g = true;
    }
}

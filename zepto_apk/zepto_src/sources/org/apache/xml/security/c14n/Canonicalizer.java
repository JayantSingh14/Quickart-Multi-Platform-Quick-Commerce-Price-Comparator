package org.apache.xml.security.c14n;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.xml.security.exceptions.AlgorithmAlreadyRegisteredException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public class Canonicalizer {

    /* renamed from: a, reason: collision with root package name */
    static boolean f57122a = false;

    /* renamed from: b, reason: collision with root package name */
    static Map f57123b;

    /* renamed from: c, reason: collision with root package name */
    protected CanonicalizerSpi f57124c;

    private Canonicalizer(String str) throws InvalidCanonicalizerException {
        this.f57124c = null;
        try {
            CanonicalizerSpi canonicalizerSpi = (CanonicalizerSpi) b(str).newInstance();
            this.f57124c = canonicalizerSpi;
            canonicalizerSpi.f57125a = true;
        } catch (Exception unused) {
            throw new InvalidCanonicalizerException("signature.Canonicalizer.UnknownCanonicalizer", new Object[]{str});
        }
    }

    public static final Canonicalizer a(String str) {
        return new Canonicalizer(str);
    }

    private static Class b(String str) {
        return (Class) f57123b.get(str);
    }

    public static void a() {
        if (f57122a) {
            return;
        }
        f57123b = new HashMap(10);
        f57122a = true;
    }

    public void a(OutputStream outputStream) {
        this.f57124c.a(outputStream);
    }

    public static void a(String str, String str2) throws AlgorithmAlreadyRegisteredException {
        Class clsB = b(str);
        if (clsB != null) {
            throw new AlgorithmAlreadyRegisteredException("algorithm.alreadyRegistered", new Object[]{str, clsB});
        }
        try {
            f57123b.put(str, Class.forName(str2));
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("c14n class not found");
        }
    }

    public byte[] a(Node node) {
        return this.f57124c.a(node);
    }

    public byte[] a(Node node, String str) {
        return this.f57124c.a(node, str);
    }
}

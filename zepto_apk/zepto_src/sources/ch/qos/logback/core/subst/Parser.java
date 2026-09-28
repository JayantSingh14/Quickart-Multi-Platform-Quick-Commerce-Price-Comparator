package ch.qos.logback.core.subst;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.spi.ScanException;
import ch.qos.logback.core.subst.Node;
import ch.qos.logback.core.subst.Token;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class Parser {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f13766a;

    /* renamed from: b, reason: collision with root package name */
    public int f13767b = 0;

    /* renamed from: ch.qos.logback.core.subst.Parser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13768a;

        static {
            int[] iArr = new int[Token.Type.values().length];
            f13768a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13768a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13768a[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public Parser(ArrayList arrayList) {
        this.f13766a = arrayList;
    }

    public final Node a() throws ScanException {
        Node node;
        Token tokenC = c();
        int iOrdinal = tokenC.f13773a.ordinal();
        Node.Type type = Node.Type.f13760a;
        if (iOrdinal != 0) {
            Token.Type type2 = Token.Type.f13778d;
            Token.Type type3 = Token.Type.f13779e;
            if (iOrdinal == 1) {
                b();
                Node node2 = new Node(Node.Type.f13761b, a());
                Token tokenC2 = c();
                if (tokenC2 != null && tokenC2.f13773a == type3) {
                    b();
                    node2.f13757c = a();
                }
                Token tokenC3 = c();
                if (tokenC3 == null) {
                    throw new IllegalArgumentException("All tokens consumed but was expecting \"}\"");
                }
                if (tokenC3.f13773a != type2) {
                    throw new ScanException("Expecting }");
                }
                b();
                node = node2;
            } else if (iOrdinal != 2) {
                node = null;
            } else {
                b();
                Node nodeA = a();
                Token tokenC4 = c();
                if (tokenC4 != null && tokenC4.f13773a == type3) {
                    b();
                    Node node3 = new Node(type, ":-");
                    nodeA.getClass();
                    Node node4 = nodeA;
                    while (true) {
                        Node node5 = node4.f13758d;
                        if (node5 == null) {
                            break;
                        }
                        node4 = node5;
                    }
                    node4.f13758d = node3;
                    Node nodeA2 = a();
                    if (nodeA2 != null) {
                        Node node6 = nodeA;
                        while (true) {
                            Node node7 = node6.f13758d;
                            if (node7 == null) {
                                break;
                            }
                            node6 = node7;
                        }
                        node6.f13758d = nodeA2;
                    }
                }
                Token tokenC5 = c();
                if (tokenC5 == null) {
                    throw new IllegalArgumentException("All tokens consumed but was expecting \"}\"");
                }
                if (tokenC5.f13773a != type2) {
                    throw new ScanException("Expecting }");
                }
                b();
                node = new Node(type, CoreConstants.f13443b);
                if (nodeA != null) {
                    Node node8 = node;
                    while (true) {
                        Node node9 = node8.f13758d;
                        if (node9 == null) {
                            break;
                        }
                        node8 = node9;
                    }
                    node8.f13758d = nodeA;
                }
                Node node10 = new Node(type, CoreConstants.f13444c);
                Node node11 = node;
                while (true) {
                    Node node12 = node11.f13758d;
                    if (node12 == null) {
                        break;
                    }
                    node11 = node12;
                }
                node11.f13758d = node10;
            }
        } else {
            b();
            node = new Node(type, tokenC.f13774b);
        }
        if (node == null) {
            return null;
        }
        Node nodeA3 = c() != null ? a() : null;
        if (nodeA3 == null) {
            return node;
        }
        Node node13 = node;
        while (true) {
            Node node14 = node13.f13758d;
            if (node14 == null) {
                node13.f13758d = nodeA3;
                return node;
            }
            node13 = node14;
        }
    }

    public final void b() {
        this.f13767b++;
    }

    public final Token c() {
        int i2 = this.f13767b;
        ArrayList arrayList = this.f13766a;
        if (i2 < arrayList.size()) {
            return (Token) arrayList.get(this.f13767b);
        }
        return null;
    }
}

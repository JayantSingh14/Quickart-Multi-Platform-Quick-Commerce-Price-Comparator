package ch.qos.logback.core.subst;

import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.spi.PropertyContainer;
import ch.qos.logback.core.subst.Node;
import ch.qos.logback.core.subst.Tokenizer;
import java.util.ArrayList;
import java.util.Stack;

/* loaded from: classes3.dex */
public class NodeToStringTransformer {

    /* renamed from: a, reason: collision with root package name */
    public final InterpretationContext f13763a;

    /* renamed from: b, reason: collision with root package name */
    public final PropertyContainer f13764b;

    /* renamed from: ch.qos.logback.core.subst.NodeToStringTransformer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13765a;

        static {
            int[] iArr = new int[Node.Type.values().length];
            f13765a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13765a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public NodeToStringTransformer(Node node, InterpretationContext interpretationContext, PropertyContainer propertyContainer) {
        this.f13763a = interpretationContext;
        this.f13764b = propertyContainer;
    }

    public static String b(String str, InterpretationContext interpretationContext, PropertyContainer propertyContainer) {
        Node nodeC = c(str);
        NodeToStringTransformer nodeToStringTransformer = new NodeToStringTransformer(nodeC, interpretationContext, propertyContainer);
        StringBuilder sb = new StringBuilder();
        nodeToStringTransformer.a(nodeC, sb, new Stack());
        return sb.toString();
    }

    public static Node c(String str) {
        Tokenizer tokenizer = new Tokenizer(str);
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i2 = tokenizer.f13784d;
            if (i2 >= tokenizer.f13782b) {
                break;
            }
            char cCharAt = tokenizer.f13781a.charAt(i2);
            tokenizer.f13784d++;
            int iOrdinal = tokenizer.f13783c.ordinal();
            Tokenizer.TokenizerState tokenizerState = Tokenizer.TokenizerState.f13787b;
            if (iOrdinal != 0) {
                Tokenizer.TokenizerState tokenizerState2 = Tokenizer.TokenizerState.f13786a;
                if (iOrdinal == 1) {
                    if (cCharAt == '{') {
                        arrayList.add(Token.f13769c);
                    } else {
                        sb.append('$');
                        sb.append(cCharAt);
                    }
                    tokenizer.f13783c = tokenizerState2;
                } else if (iOrdinal == 2) {
                    if (cCharAt == '$') {
                        sb.append(':');
                        Tokenizer.a(arrayList, sb);
                        sb.setLength(0);
                        tokenizer.f13783c = tokenizerState;
                    } else if (cCharAt != '-') {
                        sb.append(':');
                        sb.append(cCharAt);
                        tokenizer.f13783c = tokenizerState2;
                    } else {
                        arrayList.add(Token.f13772f);
                        tokenizer.f13783c = tokenizerState2;
                    }
                }
            } else if (cCharAt == '$') {
                Tokenizer.a(arrayList, sb);
                sb.setLength(0);
                tokenizer.f13783c = tokenizerState;
            } else if (cCharAt == ':') {
                Tokenizer.a(arrayList, sb);
                sb.setLength(0);
                tokenizer.f13783c = Tokenizer.TokenizerState.f13788c;
            } else if (cCharAt == '{') {
                Tokenizer.a(arrayList, sb);
                arrayList.add(Token.f13770d);
                sb.setLength(0);
            } else if (cCharAt == '}') {
                Tokenizer.a(arrayList, sb);
                arrayList.add(Token.f13771e);
                sb.setLength(0);
            } else {
                sb.append(cCharAt);
            }
        }
        int iOrdinal2 = tokenizer.f13783c.ordinal();
        if (iOrdinal2 == 0) {
            Tokenizer.a(arrayList, sb);
        } else if (iOrdinal2 == 1) {
            sb.append('$');
            Tokenizer.a(arrayList, sb);
        } else if (iOrdinal2 == 2) {
            sb.append(':');
            Tokenizer.a(arrayList, sb);
        }
        Parser parser = new Parser(arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        return parser.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ba A[PHI: r2
      0x00ba: PHI (r2v8 java.lang.String) = (r2v4 java.lang.String), (r2v6 java.lang.String) binds: [B:43:0x00b8, B:48:0x00c2] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(ch.qos.logback.core.subst.Node r6, java.lang.StringBuilder r7, java.util.Stack r8) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.core.subst.NodeToStringTransformer.a(ch.qos.logback.core.subst.Node, java.lang.StringBuilder, java.util.Stack):void");
    }
}

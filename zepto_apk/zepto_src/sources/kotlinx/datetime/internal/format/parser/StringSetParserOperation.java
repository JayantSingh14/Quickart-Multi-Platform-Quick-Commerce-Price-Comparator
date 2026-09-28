package kotlinx.datetime.internal.format.parser;

import android.support.v4.media.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class StringSetParserOperation<Output> implements ParserOperation<Output> {

    /* renamed from: a, reason: collision with root package name */
    public final AssignableField f55625a;

    /* renamed from: b, reason: collision with root package name */
    public final String f55626b;

    /* renamed from: c, reason: collision with root package name */
    public final TrieNode f55627c;

    @Metadata
    public static final class TrieNode {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f55629a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f55630b;

        public TrieNode() {
            this(0);
        }

        public TrieNode(int i2) {
            ArrayList children = new ArrayList();
            Intrinsics.checkNotNullParameter(children, "children");
            this.f55629a = children;
            this.f55630b = false;
        }
    }

    public StringSetParserOperation(Collection strings, AssignableField setter, String whatThisExpects) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(whatThisExpects, "whatThisExpects");
        this.f55625a = setter;
        this.f55626b = whatThisExpects;
        this.f55627c = new TrieNode(0);
        Iterator it = strings.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.length() <= 0) {
                throw new IllegalArgumentException(("Found an empty string in " + this.f55626b).toString());
            }
            TrieNode trieNode = this.f55627c;
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = str.charAt(i2);
                ArrayList arrayList = trieNode.f55629a;
                int iP = CollectionsKt.p(arrayList, arrayList.size(), new StringSetParserOperation$special$$inlined$binarySearchBy$default$1(String.valueOf(cCharAt)));
                ArrayList arrayList2 = trieNode.f55629a;
                if (iP < 0) {
                    TrieNode trieNode2 = new TrieNode(0);
                    arrayList2.add((-iP) - 1, new Pair(String.valueOf(cCharAt), trieNode2));
                    trieNode = trieNode2;
                } else {
                    trieNode = (TrieNode) ((Pair) arrayList2.get(iP)).f53534b;
                }
            }
            if (trieNode.f55630b) {
                throw new IllegalArgumentException(b.D("The string '", str, "' was passed several times").toString());
            }
            trieNode.f55630b = true;
        }
        b(this.f55627c);
    }

    public static final void b(TrieNode trieNode) {
        Iterator it = trieNode.f55629a.iterator();
        while (it.hasNext()) {
            b((TrieNode) ((Pair) it.next()).f53534b);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = trieNode.f55629a;
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            Pair pair = (Pair) it2.next();
            String str = (String) pair.f53533a;
            TrieNode trieNode2 = (TrieNode) pair.f53534b;
            if (!trieNode2.f55630b) {
                ArrayList arrayList3 = trieNode2.f55629a;
                if (arrayList3.size() == 1) {
                    Pair pair2 = (Pair) CollectionsKt.T(arrayList3);
                    String str2 = (String) pair2.f53533a;
                    arrayList.add(new Pair(b.k(str, str2), (TrieNode) pair2.f53534b));
                }
            }
            arrayList.add(new Pair(str, trieNode2));
        }
        arrayList2.clear();
        arrayList2.addAll(CollectionsKt.Y(new Comparator() { // from class: kotlinx.datetime.internal.format.parser.StringSetParserOperation$_init_$reduceTrie$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.a((String) ((Pair) obj).f53533a, (String) ((Pair) obj2).f53533a);
            }
        }, arrayList));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
    
        r0.f53799a = r4.length() + r0.f53799a;
        r1 = r3;
     */
    @Override // kotlinx.datetime.internal.format.parser.ParserOperation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(kotlinx.datetime.internal.format.parser.Copyable r7, final java.lang.String r8, final int r9) {
        /*
            r6 = this;
            java.lang.String r0 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlin.jvm.internal.Ref$IntRef r0 = new kotlin.jvm.internal.Ref$IntRef
            r0.<init>()
            r0.f53799a = r9
            kotlinx.datetime.internal.format.parser.StringSetParserOperation$TrieNode r1 = r6.f55627c
            r2 = 0
        Lf:
            int r3 = r0.f53799a
            int r4 = r8.length()
            if (r3 > r4) goto L4e
            boolean r3 = r1.f55630b
            if (r3 == 0) goto L21
            int r2 = r0.f53799a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L21:
            java.util.ArrayList r1 = r1.f55629a
            java.util.Iterator r1 = r1.iterator()
        L27:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L4e
            java.lang.Object r3 = r1.next()
            kotlin.Pair r3 = (kotlin.Pair) r3
            java.lang.Object r4 = r3.f53533a
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.f53534b
            kotlinx.datetime.internal.format.parser.StringSetParserOperation$TrieNode r3 = (kotlinx.datetime.internal.format.parser.StringSetParserOperation.TrieNode) r3
            int r5 = r0.f53799a
            boolean r5 = kotlin.text.StringsKt.P(r5, r8, r4)
            if (r5 == 0) goto L27
            int r1 = r0.f53799a
            int r4 = r4.length()
            int r4 = r4 + r1
            r0.f53799a = r4
            r1 = r3
            goto Lf
        L4e:
            if (r2 == 0) goto L6f
            int r0 = r2.intValue()
            java.lang.CharSequence r8 = r8.subSequence(r9, r0)
            java.lang.String r8 = r8.toString()
            kotlinx.datetime.internal.format.parser.AssignableField r0 = r6.f55625a
            java.lang.Object r7 = r0.c(r7, r8)
            if (r7 != 0) goto L65
            return r2
        L65:
            kotlinx.datetime.internal.format.parser.ParserOperationKt$setWithoutReassigning$1 r1 = new kotlinx.datetime.internal.format.parser.ParserOperationKt$setWithoutReassigning$1
            r1.<init>()
            kotlinx.datetime.internal.format.parser.ParseError r7 = kotlinx.datetime.internal.format.parser.ParseResult.Companion.a(r9, r1)
            return r7
        L6f:
            kotlinx.datetime.internal.format.parser.StringSetParserOperation$consume$1 r7 = new kotlinx.datetime.internal.format.parser.StringSetParserOperation$consume$1
            r7.<init>()
            kotlinx.datetime.internal.format.parser.ParseError r7 = kotlinx.datetime.internal.format.parser.ParseResult.Companion.a(r9, r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.datetime.internal.format.parser.StringSetParserOperation.a(kotlinx.datetime.internal.format.parser.Copyable, java.lang.String, int):java.lang.Object");
    }
}

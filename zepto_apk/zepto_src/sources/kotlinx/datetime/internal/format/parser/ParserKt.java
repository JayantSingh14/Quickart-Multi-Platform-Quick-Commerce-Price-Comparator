package kotlinx.datetime.internal.format.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ParserKt {
    public static final ParserStructure a(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        EmptyList emptyList = EmptyList.f53609a;
        ParserStructure parserStructure = new ParserStructure(emptyList, emptyList);
        if (!list.isEmpty()) {
            ListIterator listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                parserStructure = b((ParserStructure) listIterator.previous(), parserStructure);
            }
        }
        return c(parserStructure, EmptyList.f53609a);
    }

    public static final ParserStructure b(ParserStructure parserStructure, ParserStructure parserStructure2) {
        boolean zIsEmpty = parserStructure.f55614b.isEmpty();
        List list = parserStructure.f55613a;
        if (zIsEmpty) {
            return new ParserStructure(CollectionsKt.L(list, parserStructure2.f55613a), parserStructure2.f55614b);
        }
        List list2 = parserStructure.f55614b;
        ArrayList arrayList = new ArrayList(CollectionsKt.r(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(b((ParserStructure) it.next(), parserStructure2));
        }
        return new ParserStructure(list, arrayList);
    }

    public static final ParserStructure c(ParserStructure parserStructure, List list) {
        List listH;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayListF0 = CollectionsKt.f0(list);
        ArrayList arrayListF02 = null;
        for (ParserOperation parserOperation : parserStructure.f55613a) {
            if (parserOperation instanceof NumberSpanParserOperation) {
                if (arrayListF02 != null) {
                    arrayListF02.addAll(((NumberSpanParserOperation) parserOperation).f55593a);
                } else {
                    arrayListF02 = CollectionsKt.f0(((NumberSpanParserOperation) parserOperation).f55593a);
                }
            } else if (parserOperation instanceof UnconditionalModification) {
                arrayListF0.add(parserOperation);
            } else {
                if (arrayListF02 != null) {
                    arrayList.add(new NumberSpanParserOperation(arrayListF02));
                    arrayListF02 = null;
                }
                arrayList.add(parserOperation);
            }
        }
        List list2 = parserStructure.f55614b;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            ParserStructure parserStructureC = c((ParserStructure) it.next(), arrayListF0);
            if (parserStructureC.f55613a.isEmpty()) {
                List listH2 = parserStructureC.f55614b;
                if (listH2.isEmpty()) {
                    listH2 = CollectionsKt.H(parserStructureC);
                }
                listH = listH2;
            } else {
                listH = CollectionsKt.H(parserStructureC);
            }
            CollectionsKt.i(arrayList2, listH);
        }
        boolean zIsEmpty = arrayList2.isEmpty();
        Collection collectionH = arrayList2;
        if (zIsEmpty) {
            collectionH = CollectionsKt.H(new ParserStructure(arrayListF0, EmptyList.f53609a));
        }
        ArrayList arrayList3 = (List) collectionH;
        if (arrayListF02 == null) {
            return new ParserStructure(arrayList, arrayList3);
        }
        ArrayList<ParserStructure> arrayList4 = arrayList3;
        if (!(arrayList4 instanceof Collection) || !arrayList4.isEmpty()) {
            Iterator it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                ParserOperation parserOperation2 = (ParserOperation) CollectionsKt.firstOrNull(((ParserStructure) it2.next()).f55613a);
                if (parserOperation2 != null && (parserOperation2 instanceof NumberSpanParserOperation)) {
                    ArrayList arrayList5 = new ArrayList(CollectionsKt.r(arrayList4, 10));
                    for (ParserStructure parserStructure2 : arrayList4) {
                        ParserOperation parserOperation3 = (ParserOperation) CollectionsKt.firstOrNull(parserStructure2.f55613a);
                        boolean z = parserOperation3 instanceof NumberSpanParserOperation;
                        List list3 = parserStructure2.f55613a;
                        List list4 = parserStructure2.f55614b;
                        arrayList5.add(z ? new ParserStructure(CollectionsKt.L(CollectionsKt.H(new NumberSpanParserOperation(CollectionsKt.L(arrayListF02, ((NumberSpanParserOperation) parserOperation3).f55593a))), CollectionsKt.v(list3)), list4) : parserOperation3 == null ? new ParserStructure(CollectionsKt.H(new NumberSpanParserOperation(arrayListF02)), list4) : new ParserStructure(CollectionsKt.L(CollectionsKt.H(new NumberSpanParserOperation(arrayListF02)), list3), list4));
                    }
                    return new ParserStructure(arrayList, arrayList5);
                }
            }
        }
        arrayList.add(new NumberSpanParserOperation(arrayListF02));
        return new ParserStructure(arrayList, arrayList3);
    }
}

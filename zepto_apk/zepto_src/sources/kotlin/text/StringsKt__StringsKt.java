package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static boolean b(String str, String suffix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return str != null ? StringsKt.r(str, suffix, false) : g(str, str.length() - suffix.length(), suffix, 0, suffix.length(), false);
    }

    public static final Pair c(CharSequence charSequence, Collection collection, int i2, boolean z) {
        CharSequence charSequence2;
        Object next;
        boolean z2;
        Object next2;
        Object objT;
        if (z || collection.size() != 1) {
            if (i2 < 0) {
                i2 = 0;
            }
            IntRange intRange = new IntRange(i2, charSequence.length(), 1);
            boolean z3 = charSequence instanceof String;
            int i3 = intRange.f53840c;
            int i4 = intRange.f53839b;
            if (!z3) {
                boolean z4 = z;
                if ((i3 > 0 && i2 <= i4) || (i3 < 0 && i4 <= i2)) {
                    while (true) {
                        Iterator it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                charSequence2 = charSequence;
                                next = null;
                                break;
                            }
                            next = it.next();
                            String str = (String) next;
                            charSequence2 = charSequence;
                            boolean z5 = z4;
                            z4 = z5;
                            if (g(str, 0, charSequence2, i2, str.length(), z5)) {
                                break;
                            }
                            charSequence = charSequence2;
                        }
                        String str2 = (String) next;
                        if (str2 == null) {
                            if (i2 == i4) {
                                break;
                            }
                            i2 += i3;
                            charSequence = charSequence2;
                        } else {
                            return new Pair(Integer.valueOf(i2), str2);
                        }
                    }
                }
            } else if ((i3 > 0 && i2 <= i4) || (i3 < 0 && i4 <= i2)) {
                int i5 = i2;
                while (true) {
                    Iterator it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z2 = z;
                            next2 = null;
                            break;
                        }
                        next2 = it2.next();
                        String str3 = (String) next2;
                        z2 = z;
                        if (StringsKt.E(0, i5, str3.length(), str3, (String) charSequence, z2)) {
                            break;
                        }
                        z = z2;
                    }
                    String str4 = (String) next2;
                    if (str4 == null) {
                        if (i5 == i4) {
                            break;
                        }
                        i5 += i3;
                        z = z2;
                    } else {
                        return new Pair(Integer.valueOf(i5), str4);
                    }
                }
            }
        } else {
            Collection collection2 = collection;
            Intrinsics.checkNotNullParameter(collection2, "<this>");
            if (collection2 instanceof List) {
                objT = CollectionsKt.T((List) collection2);
            } else {
                Iterator it3 = collection2.iterator();
                if (!it3.hasNext()) {
                    throw new NoSuchElementException("Collection is empty.");
                }
                Object next3 = it3.next();
                if (it3.hasNext()) {
                    throw new IllegalArgumentException("Collection has more than one element.");
                }
                objT = next3;
            }
            String str5 = (String) objT;
            int iX = StringsKt.x(charSequence, str5, i2, false, 4);
            if (iX >= 0) {
                return new Pair(Integer.valueOf(iX), str5);
            }
        }
        return null;
    }

    public static final int d(int i2, CharSequence charSequence, String string, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        return (z || !(charSequence instanceof String)) ? e(charSequence, string, i2, charSequence.length(), z, false) : ((String) charSequence).indexOf(string, i2);
    }

    public static final int e(CharSequence charSequence, String str, int i2, int i3, boolean z, boolean z2) {
        IntProgression intProgression;
        if (z2) {
            int iV = StringsKt.v(charSequence);
            if (i2 > iV) {
                i2 = iV;
            }
            if (i3 < 0) {
                i3 = 0;
            }
            IntProgression.f53837d.getClass();
            intProgression = new IntProgression(i2, i3, -1);
        } else {
            if (i2 < 0) {
                i2 = 0;
            }
            int length = charSequence.length();
            if (i3 > length) {
                i3 = length;
            }
            intProgression = new IntRange(i2, i3, 1);
        }
        boolean z3 = charSequence instanceof String;
        int i4 = intProgression.f53840c;
        int i5 = intProgression.f53839b;
        int i6 = intProgression.f53838a;
        if (!z3 || str == null) {
            boolean z4 = z;
            if ((i4 > 0 && i6 <= i5) || (i4 < 0 && i5 <= i6)) {
                while (true) {
                    CharSequence charSequence2 = charSequence;
                    boolean z5 = z4;
                    z4 = z5;
                    if (!g(str, 0, charSequence2, i6, str.length(), z5)) {
                        if (i6 == i5) {
                            break;
                        }
                        i6 += i4;
                        charSequence = charSequence2;
                    } else {
                        return i6;
                    }
                }
            }
        } else if ((i4 > 0 && i6 <= i5) || (i4 < 0 && i5 <= i6)) {
            int i7 = i6;
            while (true) {
                String str2 = str;
                boolean z6 = z;
                if (!StringsKt.E(0, i7, str.length(), str2, (String) charSequence, z6)) {
                    if (i7 == i5) {
                        break;
                    }
                    i7 += i4;
                    str = str2;
                    z = z6;
                } else {
                    return i7;
                }
            }
        }
        return -1;
    }

    public static final int f(CharSequence charSequence, char[] chars, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (!z && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(ArraysKt.D(chars), i2);
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int iV = StringsKt.v(charSequence);
        if (i2 > iV) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i2);
            for (char c2 : chars) {
                if (CharsKt.a(c2, cCharAt, z)) {
                    return i2;
                }
            }
            if (i2 == iV) {
                return -1;
            }
            i2++;
        }
    }

    public static final boolean g(String str, int i2, CharSequence other, int i3, int i4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i3 >= 0 && i2 >= 0 && i2 <= str.length() - i4 && i3 <= other.length() - i4) {
            for (int i5 = 0; i5 < i4; i5++) {
                if (CharsKt.a(str.charAt(i2 + i5), other.charAt(i3 + i5), z)) {
                }
            }
            return true;
        }
        return false;
    }

    public static final void h(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "Limit must be non-negative, but was ").toString());
        }
    }

    public static final List i(int i2, CharSequence charSequence, String str, boolean z) {
        h(i2);
        int length = 0;
        int iD = d(0, charSequence, str, z);
        if (iD == -1 || i2 == 1) {
            return CollectionsKt.H(charSequence.toString());
        }
        boolean z2 = i2 > 0;
        int i3 = 10;
        if (z2 && i2 <= 10) {
            i3 = i2;
        }
        ArrayList arrayList = new ArrayList(i3);
        do {
            arrayList.add(charSequence.subSequence(length, iD).toString());
            length = str.length() + iD;
            if (z2 && arrayList.size() == i2 - 1) {
                break;
            }
            iD = d(length, charSequence, str, z);
        } while (iD != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static boolean j(String str, String prefix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return str != null ? StringsKt.O(str, prefix, false) : g(str, 0, prefix, 0, prefix.length(), false);
    }

    public static List split$default(CharSequence charSequence, String[] delimiters, final boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() != 0) {
                return i(i2, charSequence, str, z);
            }
        }
        h(i2);
        final List listC = ArraysKt.c(delimiters);
        DelimitedRangesSequence delimitedRangesSequence = new DelimitedRangesSequence(charSequence, i2, new Function2() { // from class: kotlin.text.c
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj2, Object obj3) {
                CharSequence DelimitedRangesSequence = (CharSequence) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                Intrinsics.checkNotNullParameter(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
                Pair pairC = StringsKt__StringsKt.c(DelimitedRangesSequence, listC, iIntValue, z);
                if (pairC == null) {
                    return null;
                }
                return new Pair(pairC.f53533a, Integer.valueOf(((String) pairC.f53534b).length()));
            }
        });
        Intrinsics.checkNotNullParameter(delimitedRangesSequence, "<this>");
        SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 = new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(delimitedRangesSequence);
        ArrayList arrayList = new ArrayList(CollectionsKt.r(sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1, 10));
        Iterator<Object> it = sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1.iterator();
        while (it.hasNext()) {
            IntRange range = (IntRange) it.next();
            Intrinsics.checkNotNullParameter(charSequence, "<this>");
            Intrinsics.checkNotNullParameter(range, "range");
            arrayList.add(charSequence.subSequence(range.f53838a, range.f53839b + 1).toString());
        }
        return arrayList;
    }
}

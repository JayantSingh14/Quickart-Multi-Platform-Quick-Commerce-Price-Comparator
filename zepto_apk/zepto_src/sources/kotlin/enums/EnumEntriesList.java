package kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;

@SinceKotlin
@Metadata
/* loaded from: classes.dex */
final class EnumEntriesList<T extends Enum<T>> extends AbstractList<T> implements EnumEntries<T>, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public final Enum[] f53712b;

    public EnumEntriesList(Enum[] entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.f53712b = entries;
    }

    @Override // kotlin.collections.AbstractCollection
    public final int b() {
        return this.f53712b.length;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum element = (Enum) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        int iOrdinal = element.ordinal();
        Enum[] enumArr = this.f53712b;
        Intrinsics.checkNotNullParameter(enumArr, "<this>");
        return ((iOrdinal < 0 || iOrdinal >= enumArr.length) ? null : enumArr[iOrdinal]) == element;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final Object get(int i2) {
        AbstractList.Companion companion = AbstractList.f53584a;
        Enum[] enumArr = this.f53712b;
        int length = enumArr.length;
        companion.getClass();
        AbstractList.Companion.b(i2, length);
        return enumArr[i2];
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum element = (Enum) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        int iOrdinal = element.ordinal();
        Enum[] enumArr = this.f53712b;
        Intrinsics.checkNotNullParameter(enumArr, "<this>");
        if (((iOrdinal < 0 || iOrdinal >= enumArr.length) ? null : enumArr[iOrdinal]) == element) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum element = (Enum) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        return indexOf(element);
    }
}

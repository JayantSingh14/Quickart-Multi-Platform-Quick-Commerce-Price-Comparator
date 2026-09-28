package androidx.room.util;

import android.support.v4.media.b;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.e;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
@RestrictTo
/* loaded from: classes3.dex */
public final class TableInfo {

    /* renamed from: a, reason: collision with root package name */
    public final String f11859a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11860b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractSet f11861c;

    /* renamed from: d, reason: collision with root package name */
    public final AbstractSet f11862d;

    @Metadata
    public static final class Column {

        /* renamed from: a, reason: collision with root package name */
        public final String f11863a;

        /* renamed from: b, reason: collision with root package name */
        public final String f11864b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f11865c;

        /* renamed from: d, reason: collision with root package name */
        public final int f11866d;

        /* renamed from: e, reason: collision with root package name */
        public final String f11867e;

        /* renamed from: f, reason: collision with root package name */
        public final int f11868f;

        /* renamed from: g, reason: collision with root package name */
        public final int f11869g;

        @Metadata
        @SourceDebugExtension
        public static final class Companion {
            public static boolean a(String current, String str) {
                Intrinsics.checkNotNullParameter(current, "current");
                if (Intrinsics.b(current, str)) {
                    return true;
                }
                if (current.length() != 0) {
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        if (i2 < current.length()) {
                            char cCharAt = current.charAt(i2);
                            int i5 = i4 + 1;
                            if (i4 == 0 && cCharAt != '(') {
                                break;
                            }
                            if (cCharAt != '(') {
                                if (cCharAt == ')' && i3 - 1 == 0 && i4 != current.length() - 1) {
                                    break;
                                }
                            } else {
                                i3++;
                            }
                            i2++;
                            i4 = i5;
                        } else if (i3 == 0) {
                            String strSubstring = current.substring(1, current.length() - 1);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                            return Intrinsics.b(StringsKt.b0(strSubstring).toString(), str);
                        }
                    }
                }
                return false;
            }
        }

        public Column(int i2, int i3, String name, String type, String str, boolean z) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            this.f11863a = name;
            this.f11864b = type;
            this.f11865c = z;
            this.f11866d = i2;
            this.f11867e = str;
            this.f11868f = i3;
            int i4 = 5;
            if (type != null) {
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String upperCase = type.toUpperCase(US);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                if (StringsKt.n(upperCase, "INT", false)) {
                    i4 = 3;
                } else if (StringsKt.n(upperCase, "CHAR", false) || StringsKt.n(upperCase, "CLOB", false) || StringsKt.n(upperCase, "TEXT", false)) {
                    i4 = 2;
                } else if (!StringsKt.n(upperCase, "BLOB", false)) {
                    i4 = (StringsKt.n(upperCase, "REAL", false) || StringsKt.n(upperCase, "FLOA", false) || StringsKt.n(upperCase, "DOUB", false)) ? 4 : 1;
                }
            }
            this.f11869g = i4;
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof Column)) {
                    return false;
                }
                Column column = (Column) obj;
                if (this.f11866d != column.f11866d) {
                    return false;
                }
                if (!Intrinsics.b(this.f11863a, column.f11863a) || this.f11865c != column.f11865c) {
                    return false;
                }
                int i2 = column.f11868f;
                String str = column.f11867e;
                String str2 = this.f11867e;
                int i3 = this.f11868f;
                if (i3 == 1 && i2 == 2 && str2 != null && !Companion.a(str2, str)) {
                    return false;
                }
                if (i3 == 2 && i2 == 1 && str != null && !Companion.a(str, str2)) {
                    return false;
                }
                if (i3 != 0 && i3 == i2) {
                    if (str2 != null) {
                        if (!Companion.a(str2, str)) {
                            return false;
                        }
                    } else if (str != null) {
                        return false;
                    }
                }
                if (this.f11869g != column.f11869g) {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode() {
            return (((((this.f11863a.hashCode() * 31) + this.f11869g) * 31) + (this.f11865c ? 1231 : 1237)) * 31) + this.f11866d;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Column{name='");
            sb.append(this.f11863a);
            sb.append("', type='");
            sb.append(this.f11864b);
            sb.append("', affinity='");
            sb.append(this.f11869g);
            sb.append("', notNull=");
            sb.append(this.f11865c);
            sb.append(", primaryKeyPosition=");
            sb.append(this.f11866d);
            sb.append(", defaultValue='");
            String str = this.f11867e;
            if (str == null) {
                str = "undefined";
            }
            return b.r(sb, str, "'}");
        }
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface CreatedFrom {
    }

    @Metadata
    @RestrictTo
    public static final class ForeignKey {

        /* renamed from: a, reason: collision with root package name */
        public final String f11870a;

        /* renamed from: b, reason: collision with root package name */
        public final String f11871b;

        /* renamed from: c, reason: collision with root package name */
        public final String f11872c;

        /* renamed from: d, reason: collision with root package name */
        public final List f11873d;

        /* renamed from: e, reason: collision with root package name */
        public final List f11874e;

        public ForeignKey(String referenceTable, String onDelete, String onUpdate, List columnNames, List referenceColumnNames) {
            Intrinsics.checkNotNullParameter(referenceTable, "referenceTable");
            Intrinsics.checkNotNullParameter(onDelete, "onDelete");
            Intrinsics.checkNotNullParameter(onUpdate, "onUpdate");
            Intrinsics.checkNotNullParameter(columnNames, "columnNames");
            Intrinsics.checkNotNullParameter(referenceColumnNames, "referenceColumnNames");
            this.f11870a = referenceTable;
            this.f11871b = onDelete;
            this.f11872c = onUpdate;
            this.f11873d = columnNames;
            this.f11874e = referenceColumnNames;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForeignKey)) {
                return false;
            }
            ForeignKey foreignKey = (ForeignKey) obj;
            if (Intrinsics.b(this.f11870a, foreignKey.f11870a) && Intrinsics.b(this.f11871b, foreignKey.f11871b) && Intrinsics.b(this.f11872c, foreignKey.f11872c) && Intrinsics.b(this.f11873d, foreignKey.f11873d)) {
                return Intrinsics.b(this.f11874e, foreignKey.f11874e);
            }
            return false;
        }

        public final int hashCode() {
            return this.f11874e.hashCode() + e.f(e.e(e.e(this.f11870a.hashCode() * 31, 31, this.f11871b), 31, this.f11872c), 31, this.f11873d);
        }

        public final String toString() {
            return "ForeignKey{referenceTable='" + this.f11870a + "', onDelete='" + this.f11871b + " +', onUpdate='" + this.f11872c + "', columnNames=" + this.f11873d + ", referenceColumnNames=" + this.f11874e + '}';
        }
    }

    @Metadata
    public static final class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {

        /* renamed from: a, reason: collision with root package name */
        public final int f11875a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11876b;

        /* renamed from: c, reason: collision with root package name */
        public final String f11877c;

        /* renamed from: d, reason: collision with root package name */
        public final String f11878d;

        public ForeignKeyWithSequence(int i2, int i3, String from, String to) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(to, "to");
            this.f11875a = i2;
            this.f11876b = i3;
            this.f11877c = from;
            this.f11878d = to;
        }

        @Override // java.lang.Comparable
        public final int compareTo(ForeignKeyWithSequence foreignKeyWithSequence) {
            ForeignKeyWithSequence other = foreignKeyWithSequence;
            Intrinsics.checkNotNullParameter(other, "other");
            int i2 = this.f11875a - other.f11875a;
            return i2 == 0 ? this.f11876b - other.f11876b : i2;
        }
    }

    @Metadata
    @RestrictTo
    @SourceDebugExtension
    public static final class Index {

        /* renamed from: a, reason: collision with root package name */
        public final String f11879a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f11880b;

        /* renamed from: c, reason: collision with root package name */
        public final List f11881c;

        /* renamed from: d, reason: collision with root package name */
        public final List f11882d;

        @Metadata
        public static final class Companion {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
        public Index(String name, boolean z, List columns, List orders) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(columns, "columns");
            Intrinsics.checkNotNullParameter(orders, "orders");
            this.f11879a = name;
            this.f11880b = z;
            this.f11881c = columns;
            this.f11882d = orders;
            List arrayList = orders;
            if (arrayList.isEmpty()) {
                int size = columns.size();
                arrayList = new ArrayList(size);
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add("ASC");
                }
            }
            this.f11882d = (List) arrayList;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Index) {
                Index index = (Index) obj;
                if (this.f11880b == index.f11880b && Intrinsics.b(this.f11881c, index.f11881c) && Intrinsics.b(this.f11882d, index.f11882d)) {
                    String str = this.f11879a;
                    boolean zO = StringsKt.O(str, "index_", false);
                    String str2 = index.f11879a;
                    return zO ? StringsKt.O(str2, "index_", false) : str.equals(str2);
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.f11879a;
            return this.f11882d.hashCode() + e.f((((StringsKt.O(str, "index_", false) ? -1184239155 : str.hashCode()) * 31) + (this.f11880b ? 1 : 0)) * 31, 31, this.f11881c);
        }

        public final String toString() {
            return "Index{name='" + this.f11879a + "', unique=" + this.f11880b + ", columns=" + this.f11881c + ", orders=" + this.f11882d + "'}";
        }
    }

    public TableInfo(String name, Map columns, AbstractSet foreignKeys, AbstractSet abstractSet) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(columns, "columns");
        Intrinsics.checkNotNullParameter(foreignKeys, "foreignKeys");
        this.f11859a = name;
        this.f11860b = columns;
        this.f11861c = foreignKeys;
        this.f11862d = abstractSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x020f, code lost:
    
        r0 = kotlin.collections.SetsKt.a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0213, code lost:
    
        kotlin.io.CloseableKt.a(r3, null);
        r10 = r0;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.room.util.TableInfo a(androidx.sqlite.db.framework.FrameworkSQLiteDatabase r28, java.lang.String r29) {
        /*
            Method dump skipped, instructions count: 567
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.TableInfo.a(androidx.sqlite.db.framework.FrameworkSQLiteDatabase, java.lang.String):androidx.room.util.TableInfo");
    }

    public final boolean equals(Object obj) {
        AbstractSet abstractSet;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo)) {
            return false;
        }
        TableInfo tableInfo = (TableInfo) obj;
        if (!this.f11859a.equals(tableInfo.f11859a) || !this.f11860b.equals(tableInfo.f11860b) || !Intrinsics.b(this.f11861c, tableInfo.f11861c)) {
            return false;
        }
        AbstractSet abstractSet2 = this.f11862d;
        if (abstractSet2 == null || (abstractSet = tableInfo.f11862d) == null) {
            return true;
        }
        return abstractSet2.equals(abstractSet);
    }

    public final int hashCode() {
        return this.f11861c.hashCode() + ((this.f11860b.hashCode() + (this.f11859a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "TableInfo{name='" + this.f11859a + "', columns=" + this.f11860b + ", foreignKeys=" + this.f11861c + ", indices=" + this.f11862d + '}';
    }
}

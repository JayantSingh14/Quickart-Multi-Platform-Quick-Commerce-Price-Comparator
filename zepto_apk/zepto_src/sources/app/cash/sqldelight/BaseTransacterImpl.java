package app.cash.sqldelight;

import app.cash.sqldelight.Transacter;
import app.cash.sqldelight.db.SqlDriver;
import java.util.Arrays;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class BaseTransacterImpl {

    /* renamed from: a, reason: collision with root package name */
    public final SqlDriver f13074a;

    public BaseTransacterImpl(SqlDriver driver) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        this.f13074a = driver;
    }

    public static String b(int i2) {
        if (i2 == 0) {
            return "()";
        }
        StringBuilder sb = new StringBuilder(i2 + 2);
        sb.append("(?");
        int i3 = i2 - 1;
        for (int i4 = 0; i4 < i3; i4++) {
            sb.append(",?");
        }
        sb.append(')');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final void c(int i2, Function1 tableProvider) {
        Intrinsics.checkNotNullParameter(tableProvider, "tableProvider");
        SqlDriver sqlDriver = this.f13074a;
        final Transacter.Transaction transactionV0 = sqlDriver.V0();
        if (transactionV0 != null) {
            if (transactionV0.f13081a.add(Integer.valueOf(i2))) {
                tableProvider.invoke(new Function1<String, Unit>() { // from class: app.cash.sqldelight.BaseTransacterImpl$notifyQueries$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        String it = (String) obj;
                        Intrinsics.checkNotNullParameter(it, "it");
                        transactionV0.f13082b.add(it);
                        return Unit.f53572a;
                    }
                });
            }
        } else {
            final LinkedHashSet linkedHashSet = new LinkedHashSet();
            tableProvider.invoke(new Function1<String, Unit>() { // from class: app.cash.sqldelight.BaseTransacterImpl$notifyQueries$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    String it = (String) obj;
                    Intrinsics.checkNotNullParameter(it, "it");
                    linkedHashSet.add(it);
                    return Unit.f53572a;
                }
            });
            String[] strArr = (String[]) linkedHashSet.toArray(new String[0]);
            sqlDriver.g1((String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }
}

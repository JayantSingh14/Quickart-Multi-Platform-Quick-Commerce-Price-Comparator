package app.cash.sqldelight;

import app.cash.sqldelight.internal.CurrentThreadIdKt;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface Transacter extends TransacterBase {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    @Metadata
    public static abstract class Transaction implements TransactionCallbacks {

        /* renamed from: a, reason: collision with root package name */
        public final LinkedHashSet f13081a;

        /* renamed from: b, reason: collision with root package name */
        public final LinkedHashSet f13082b;

        public Transaction() {
            CurrentThreadIdKt.a();
            new ArrayList();
            new ArrayList();
            this.f13081a = new LinkedHashSet();
            this.f13082b = new LinkedHashSet();
        }
    }
}

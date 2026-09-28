package androidx.datastore.core;

import androidx.datastore.core.DataMigrationInitializer;
import java.io.Serializable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion", f = "DataMigrationInitializer.kt", l = {42, Type.RKEY}, m = "runMigrations")
/* loaded from: classes.dex */
final class DataMigrationInitializer$Companion$runMigrations$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Serializable f3383a;

    /* renamed from: b, reason: collision with root package name */
    public Iterator f3384b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3385c;

    /* renamed from: d, reason: collision with root package name */
    public int f3386d;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3385c = obj;
        this.f3386d |= Integer.MIN_VALUE;
        return DataMigrationInitializer.Companion.a(null, null, this);
    }
}

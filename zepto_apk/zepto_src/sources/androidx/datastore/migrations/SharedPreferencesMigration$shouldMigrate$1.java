package androidx.datastore.migrations;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "androidx.datastore.migrations.SharedPreferencesMigration", f = "SharedPreferencesMigration.android.kt", l = {151}, m = "shouldMigrate")
/* loaded from: classes3.dex */
final class SharedPreferencesMigration$shouldMigrate$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferencesMigration f3690a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f3691b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SharedPreferencesMigration f3692c;

    /* renamed from: d, reason: collision with root package name */
    public int f3693d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration$shouldMigrate$1(SharedPreferencesMigration sharedPreferencesMigration, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3692c = sharedPreferencesMigration;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3691b = obj;
        this.f3693d |= Integer.MIN_VALUE;
        this.f3692c.h(this);
        return Boolean.FALSE;
    }
}

package okio.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.sequences.SequenceScope;
import okio.FileSystem;
import okio.Path;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "okio.internal.-FileSystem", f = "FileSystem.kt", l = {116, WKSRecord.Service.LOC_SRV, 145}, m = "collectRecursively")
/* renamed from: okio.internal.-FileSystem$collectRecursively$1, reason: invalid class name */
/* loaded from: classes3.dex */
final class FileSystem$collectRecursively$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public SequenceScope f57011a;

    /* renamed from: b, reason: collision with root package name */
    public FileSystem f57012b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayDeque f57013c;

    /* renamed from: d, reason: collision with root package name */
    public Path f57014d;

    /* renamed from: e, reason: collision with root package name */
    public Iterator f57015e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f57016f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f57017g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f57018h;

    /* renamed from: i, reason: collision with root package name */
    public int f57019i;

    public FileSystem$collectRecursively$1(BaseContinuationImpl baseContinuationImpl) {
        super(baseContinuationImpl);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f57018h = obj;
        this.f57019i |= Integer.MIN_VALUE;
        return FileSystem.a(null, null, null, null, false, false, this);
    }
}

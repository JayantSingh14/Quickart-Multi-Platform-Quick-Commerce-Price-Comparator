package okio.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import okio.FileSystem;
import okio.Path;

@Metadata
@DebugMetadata(c = "okio.internal.-FileSystem$commonListRecursively$1", f = "FileSystem.kt", l = {96}, m = "invokeSuspend")
/* renamed from: okio.internal.-FileSystem$commonListRecursively$1, reason: invalid class name */
/* loaded from: classes3.dex */
final class FileSystem$commonListRecursively$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public ArrayDeque f57024b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f57025c;

    /* renamed from: d, reason: collision with root package name */
    public int f57026d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f57027e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Path f57028f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ FileSystem f57029g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f57030h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystem$commonListRecursively$1(Path path, FileSystem fileSystem, boolean z, Continuation continuation) {
        super(2, continuation);
        this.f57028f = path;
        this.f57029g = fileSystem;
        this.f57030h = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FileSystem$commonListRecursively$1 fileSystem$commonListRecursively$1 = new FileSystem$commonListRecursively$1(this.f57028f, this.f57029g, this.f57030h, continuation);
        fileSystem$commonListRecursively$1.f57027e = obj;
        return fileSystem$commonListRecursively$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((FileSystem$commonListRecursively$1) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        ArrayDeque arrayDeque;
        Iterator it;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f57026d;
        if (i2 == 0) {
            ResultKt.b(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.f57027e;
            ArrayDeque arrayDeque2 = new ArrayDeque();
            Path path = this.f57028f;
            arrayDeque2.addLast(path);
            sequenceScope = sequenceScope2;
            arrayDeque = arrayDeque2;
            it = this.f57029g.list(path).iterator();
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = this.f57025c;
            ArrayDeque arrayDeque3 = this.f57024b;
            sequenceScope = (SequenceScope) this.f57027e;
            ResultKt.b(obj);
            arrayDeque = arrayDeque3;
        }
        while (it.hasNext()) {
            Path path2 = (Path) it.next();
            this.f57027e = sequenceScope;
            this.f57024b = arrayDeque;
            this.f57025c = it;
            this.f57026d = 1;
            if (FileSystem.a(sequenceScope, this.f57029g, arrayDeque, path2, this.f57030h, false, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.f53572a;
    }
}

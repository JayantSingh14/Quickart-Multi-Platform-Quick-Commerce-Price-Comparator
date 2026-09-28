package com.google.firebase.sessions;

import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "com.google.firebase.sessions.SessionLifecycleClient$sendLifecycleEvents$1", f = "SessionLifecycleClient.kt", l = {151}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes4.dex */
final class SessionLifecycleClient$sendLifecycleEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f45108a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SessionLifecycleClient f45109b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f45110c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionLifecycleClient$sendLifecycleEvents$1(SessionLifecycleClient sessionLifecycleClient, ArrayList arrayList, Continuation continuation) {
        super(2, continuation);
        this.f45109b = sessionLifecycleClient;
        this.f45110c = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SessionLifecycleClient$sendLifecycleEvents$1(this.f45109b, this.f45110c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((SessionLifecycleClient$sendLifecycleEvents$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws RemoteException {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f45108a;
        if (i2 == 0) {
            ResultKt.b(obj);
            FirebaseSessionsDependencies firebaseSessionsDependencies = FirebaseSessionsDependencies.f45125a;
            this.f45108a = 1;
            obj = firebaseSessionsDependencies.c(this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        Map map = (Map) obj;
        if (map.isEmpty()) {
            Log.d("SessionLifecycleClient", "Sessions SDK did not have any dependent SDKs register as dependencies. Events will not be sent.");
        } else {
            Collection collectionValues = map.values();
            if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
                Log.d("SessionLifecycleClient", "Data Collection is disabled for all subscribers. Skipping this Event");
            } else {
                Iterator it = collectionValues.iterator();
                while (it.hasNext()) {
                    if (((SessionSubscriber) it.next()).a()) {
                        ArrayList arrayList = this.f45110c;
                        SessionLifecycleClient sessionLifecycleClient = this.f45109b;
                        for (Message message : CollectionsKt.Y(new Comparator() { // from class: com.google.firebase.sessions.SessionLifecycleClient$sendLifecycleEvents$1$invokeSuspend$$inlined$sortedBy$1
                            @Override // java.util.Comparator
                            public final int compare(Object obj2, Object obj3) {
                                return ComparisonsKt.a(Long.valueOf(((Message) obj2).getWhen()), Long.valueOf(((Message) obj3).getWhen()));
                            }
                        }, CollectionsKt.x(CollectionsKt.J(SessionLifecycleClient.a(sessionLifecycleClient, arrayList, 2), SessionLifecycleClient.a(sessionLifecycleClient, arrayList, 1))))) {
                            if (sessionLifecycleClient.f45102b != null) {
                                try {
                                    Log.d("SessionLifecycleClient", "Sending lifecycle " + message.what + " to service");
                                    Messenger messenger = sessionLifecycleClient.f45102b;
                                    if (messenger != null) {
                                        messenger.send(message);
                                    }
                                } catch (RemoteException e2) {
                                    Log.w("SessionLifecycleClient", "Unable to deliver message: " + message.what, e2);
                                    sessionLifecycleClient.e(message);
                                }
                            } else {
                                sessionLifecycleClient.e(message);
                            }
                        }
                    }
                }
                Log.d("SessionLifecycleClient", "Data Collection is disabled for all subscribers. Skipping this Event");
            }
        }
        return Unit.f53572a;
    }
}

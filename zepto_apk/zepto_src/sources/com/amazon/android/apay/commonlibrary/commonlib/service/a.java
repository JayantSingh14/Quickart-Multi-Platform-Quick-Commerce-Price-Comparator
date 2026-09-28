package com.amazon.android.apay.commonlibrary.commonlib.service;

import PrefetchAgreementWallet.PrefetchAgreementWalletInterface;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import androidx.media3.datasource.b;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

@Metadata
/* loaded from: classes3.dex */
public final class a implements ServiceConnection {

    /* renamed from: c, reason: collision with root package name */
    public static PrefetchAgreementWalletInterface f14871c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f14872d = false;

    /* renamed from: e, reason: collision with root package name */
    public static Future f14873e;

    /* renamed from: a, reason: collision with root package name */
    public final Context f14874a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f14875b;

    @Metadata
    /* renamed from: com.amazon.android.apay.commonlibrary.commonlib.service.a$a, reason: collision with other inner class name */
    public static final class C0011a {
    }

    static {
        new C0011a();
    }

    public a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f14874a = context;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
        this.f14875b = executorServiceNewSingleThreadExecutor;
        Runtime.getRuntime().addShutdownHook(new Thread(new androidx.constraintlayout.helper.widget.a(this, 7)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [PrefetchAgreementWallet.PrefetchAgreementWalletInterface] */
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        PrefetchAgreementWalletInterface.Stub.a aVar;
        f14872d = true;
        int i2 = PrefetchAgreementWalletInterface.Stub.f2a;
        if (iBinder == null) {
            aVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("PrefetchAgreementWallet.PrefetchAgreementWalletInterface");
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof PrefetchAgreementWalletInterface)) {
                PrefetchAgreementWalletInterface.Stub.a aVar2 = new PrefetchAgreementWalletInterface.Stub.a();
                aVar2.f3a = iBinder;
                aVar = aVar2;
            } else {
                aVar = (PrefetchAgreementWalletInterface) iInterfaceQueryLocalInterface;
            }
        }
        f14871c = aVar;
        f14873e = this.f14875b.submit(new b(3, com.amazon.android.apay.commonlibrary.commonlib.utils.b.a(this.f14874a), this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) throws JSONException {
        InstrumentUtil.addMetricEvent$default("boundOnServiceDisConnected", "BoundService", this.f14874a, (String) null, (String) null, 24, (Object) null);
        f14871c = null;
        f14872d = false;
    }
}

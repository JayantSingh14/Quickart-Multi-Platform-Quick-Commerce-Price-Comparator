package in.juspay.hypersdk.core;

import in.juspay.hyperupi.CLUtils;
import org.json.JSONException;
import org.npci.upi.security.services.CLRemoteResultReceiver;

/* loaded from: classes4.dex */
public final /* synthetic */ class r0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48658a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f48659b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48660c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f48661d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f48662e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f48663f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f48664g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f48665h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f48666i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f48667j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f48668k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f48669l;

    public /* synthetic */ r0(SdkTracker sdkTracker, String str, String str2, String str3, Integer num, String str4, Long l2, Long l3, Object obj, Object obj2, String str5) {
        this.f48664g = sdkTracker;
        this.f48659b = str;
        this.f48660c = str2;
        this.f48661d = str3;
        this.f48665h = num;
        this.f48662e = str4;
        this.f48666i = l2;
        this.f48667j = l3;
        this.f48668k = obj;
        this.f48669l = obj2;
        this.f48663f = str5;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        switch (this.f48658a) {
            case 0:
                ((SdkTracker) this.f48664g).lambda$trackApiCalls$9(this.f48659b, this.f48660c, this.f48661d, (Integer) this.f48665h, this.f48662e, (Long) this.f48666i, (Long) this.f48667j, this.f48668k, this.f48669l, this.f48663f);
                break;
            default:
                CLRemoteResultReceiver cLRemoteResultReceiver = (CLRemoteResultReceiver) this.f48669l;
                CLUtils.getCredentials$lambda$15((CLUtils) this.f48664g, this.f48659b, this.f48660c, this.f48661d, this.f48662e, this.f48663f, (String) this.f48665h, (String) this.f48666i, (String) this.f48667j, (String) this.f48668k, cLRemoteResultReceiver);
                break;
        }
    }

    public /* synthetic */ r0(CLUtils cLUtils, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, CLRemoteResultReceiver cLRemoteResultReceiver) {
        this.f48664g = cLUtils;
        this.f48659b = str;
        this.f48660c = str2;
        this.f48661d = str3;
        this.f48662e = str4;
        this.f48663f = str5;
        this.f48665h = str6;
        this.f48666i = str7;
        this.f48667j = str8;
        this.f48668k = str9;
        this.f48669l = cLRemoteResultReceiver;
    }
}

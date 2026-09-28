package in.juspay.hyperupi;

/* loaded from: classes4.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48777a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CLUtils f48778b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48779c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f48780d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f48781e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f48782f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f48783g;

    public /* synthetic */ d(CLUtils cLUtils, String str, String str2, String str3, String str4, String str5, int i2) {
        this.f48777a = i2;
        this.f48778b = cLUtils;
        this.f48779c = str;
        this.f48780d = str2;
        this.f48781e = str3;
        this.f48782f = str4;
        this.f48783g = str5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48777a) {
            case 0:
                CLUtils.registerUPILiteOnboarding$lambda$11(this.f48778b, this.f48779c, this.f48780d, this.f48781e, this.f48782f, this.f48783g);
                break;
            case 1:
                CLUtils.registerUPILiteState$lambda$12(this.f48778b, this.f48779c, this.f48780d, this.f48781e, this.f48782f, this.f48783g);
                break;
            default:
                CLUtils.registerApp$lambda$7(this.f48778b, this.f48779c, this.f48780d, this.f48781e, this.f48782f, this.f48783g);
                break;
        }
    }
}

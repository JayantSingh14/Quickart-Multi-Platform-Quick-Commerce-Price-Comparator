package in.juspay.hyperupi;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48765a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CLUtils f48766b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48767c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f48768d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f48769e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f48770f;

    public /* synthetic */ a(CLUtils cLUtils, String str, String str2, String str3, String str4, int i2) {
        this.f48765a = i2;
        this.f48766b = cLUtils;
        this.f48767c = str;
        this.f48768d = str2;
        this.f48769e = str3;
        this.f48770f = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48765a) {
            case 0:
                CLUtils.unBindDevice$lambda$10(this.f48766b, this.f48767c, this.f48768d, this.f48769e, this.f48770f);
                break;
            case 1:
                CLUtils.getUPILiteBalance$lambda$13(this.f48766b, this.f48767c, this.f48768d, this.f48769e, this.f48770f);
                break;
            default:
                CLUtils.isUpiLiteBound$lambda$9(this.f48766b, this.f48767c, this.f48768d, this.f48769e, this.f48770f);
                break;
        }
    }
}

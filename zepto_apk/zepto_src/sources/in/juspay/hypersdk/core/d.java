package in.juspay.hypersdk.core;

/* loaded from: classes4.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48551a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AndroidInterface f48552b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48553c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f48554d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f48555e;

    public /* synthetic */ d(AndroidInterface androidInterface, String str, int i2, String str2, int i3) {
        this.f48551a = i3;
        this.f48552b = androidInterface;
        this.f48553c = str;
        this.f48554d = i2;
        this.f48555e = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48551a) {
            case 0:
                this.f48552b.lambda$toggleKeyboard$13(this.f48553c, this.f48554d, this.f48555e);
                break;
            default:
                this.f48552b.lambda$setImage$12(this.f48553c, this.f48554d, this.f48555e);
                break;
        }
    }
}

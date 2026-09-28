package in.org.npci.commonlibrary;

/* loaded from: classes4.dex */
public class c extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private int f49189a;

    /* renamed from: b, reason: collision with root package name */
    private String f49190b;

    public c() {
    }

    public int a() {
        return this.f49189a;
    }

    public String b() {
        return this.f49190b;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "Error " + this.f49189a + " : " + this.f49190b;
    }

    public c(d dVar) {
        super(dVar.a());
        this.f49189a = dVar.b();
        this.f49190b = dVar.a();
    }
}

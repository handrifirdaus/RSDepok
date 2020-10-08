package pi.rs.handrifirdaus.rsdepok;

/**
 * Created by HANDRI FIRDAUS on 6/14/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseRS extends SQLiteOpenHelper {

    // Versi Database
    public static final int DATABASE_VERSION = 29;

    // Nama Database
    public static final String DATABASE_NAME = "rs";

    // Nama tabel
    public static final String TABLE_RS= "rss";

    // Tabel RS
    public static final String KEY_ID = "_id";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_ALAMAT = "alamat";
    public static final String KEY_TELEPON = "telepon";
    public static final String KEY_JAM = "jam";
    public static final String KEY_BPJS = "bpjs";
    public static final String KEY_GAMBAR = "gambar";


    public Resources res;

    public DatabaseRS(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        res = context.getResources();
    }

    // Method untuk membuat database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_RS = "CREATE TABLE " + TABLE_RS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAMA  + " TEXT," + KEY_ALAMAT + " TEXT," + KEY_TELEPON + " TEXT,"+ KEY_JAM + " TEXT,"+ KEY_BPJS + " TEXT,"
                + KEY_GAMBAR + " INTEGER);";

        db.execSQL(CREATE_TABLE_RS);

        ContentValues values = new ContentValues();
        //database Daftar RS
        //1
        values.put(KEY_NAMA, "RSUD KOTA DEPOK");
        values.put(KEY_ALAMAT, "JL. RAYA MUCHTAR NO.99 SAWANGAN, DEPOK.");
        values.put(KEY_TELEPON, "02518602514");
        values.put(KEY_JAM, "Pagi 10.00-11.00\n"+"Sore 16.30-18.00");
        values.put(KEY_BPJS, "MENERIMA");
        values.put(KEY_GAMBAR, R.drawable.rsud);
        db.insert(TABLE_RS, null, values);

        //2
        values.put(KEY_NAMA, "RSU BHAKTI YUDHA");
        values.put(KEY_ALAMAT, "JL. RAYA SAWANGAN, PANCORAN MAS, KOTA DEPOK, JAWA BARAT 16436.");
        values.put(KEY_TELEPON, "02177205046");
        values.put(KEY_JAM, "Pagi 10.00-11.00\n"+"Sore 16.30-18.00");
        values.put(KEY_BPJS, "MENERIMA");
        values.put(KEY_GAMBAR, R.drawable.bhakti);
        db.insert(TABLE_RS, null, values);

        //3
        values.put(KEY_NAMA, "RS CITRA MEDIKA DEPOK");
        values.put(KEY_ALAMAT, "JL. RAYA KALIMULYA NO. 68 KOTA KEMBANG CILODONG – DEPOK.");
        values.put(KEY_TELEPON, "0218841147");
        values.put(KEY_JAM, "Pagi 10.00-11.00\n"+"Sore 16.30-18.00");
        values.put(KEY_BPJS, "MENERIMA");
        values.put(KEY_GAMBAR, R.drawable.citra);
        db.insert(TABLE_RS, null, values);

        //4
        values.put(KEY_NAMA, "RS Puri Cinere");
        values.put(KEY_ALAMAT, "JL. MARIBAYA, NO.1, PURI CINERE, DEPOK 16514.");
        values.put(KEY_TELEPON, "0217545488");
        values.put(KEY_JAM, "Pagi 10.00-11.00\n"+"Sore 16.30-18.00");
        values.put(KEY_BPJS, "TIDAK MENERIMA");
        values.put(KEY_GAMBAR, R.drawable.puri);
        db.insert(TABLE_RS, null, values);

        //5
        values.put(KEY_NAMA, "RS KHUSUS JANTUNG DIAGRAM");
        values.put(KEY_ALAMAT, "JL. MARIBAYA NO. 1 CINERE, DEPOK 16514.");
        values.put(KEY_TELEPON, "0217545499");
        values.put(KEY_JAM, "Pagi 10.00-11.00\n"+"Sore 16.30-18.00");
        values.put(KEY_BPJS, "TIDAK MENERIMA");
        values.put(KEY_GAMBAR, R.drawable.khusus);
        db.insert(TABLE_RS, null, values);

        //6
        values.put(KEY_NAMA, "RS SENTRA MEDIKA)");
        values.put(KEY_ALAMAT, "JALAN RAYA BOGOR NO.33, CIMANGGIS, KOTA DEPOK, JAWA BARAT 16416.");
        values.put(KEY_TELEPON, "0218743790");
        values.put(KEY_JAM, "Pagi 10.00-11.00\n"+"Sore 16.30-18.00");
        values.put(KEY_BPJS, "MENERIMA");
        values.put(KEY_GAMBAR, R.drawable.sentra);
        db.insert(TABLE_RS, null, values);

        //7
        values.put(KEY_NAMA, "RS HERMINA DEPOK");
        values.put(KEY_ALAMAT, "JL. SILIWANGI NO.50, PANCORAN MAS, KOTA DEPOK, JAWA BARAT 16431.");
        values.put(KEY_TELEPON, "02177202525");
        values.put(KEY_JAM, "Pagi 10.00-11.00\n"+"Sore 16.30-18.00");;
        values.put(KEY_BPJS, "MENERIMA");
        values.put(KEY_GAMBAR, R.drawable.hermina);
        db.insert(TABLE_RS, null, values);

        //8
        values.put(KEY_NAMA, "RS BHAYANGKARA BRIMOB");
        values.put(KEY_ALAMAT, "JL. AKSES UI CIMANGGIS, DEPOK.");
        values.put(KEY_TELEPON, "02187704691");
        values.put(KEY_JAM, "Pagi 10.00-11.00\n"+"Sore 16.30-18.00");
        values.put(KEY_BPJS, "MENERIMA");
        values.put(KEY_GAMBAR, R.drawable.bhayangkara);
        db.insert(TABLE_RS, null, values);

        //9
        values.put(KEY_NAMA, "RS SIMPANGAN DEPOK");
        values.put(KEY_ALAMAT, "JALAN RAYA BOGOR KM.36, SUKAMAJU, JAWA BARAT.");
        values.put(KEY_TELEPON, "0218741549");
        values.put(KEY_JAM, "Pagi 10.00-11.00\n"+"Sore 16.30-18.00");
        values.put(KEY_BPJS, "MENERIMA");
        values.put(KEY_GAMBAR, R.drawable.simpangan);
        db.insert(TABLE_RS, null, values);

        //10
        values.put(KEY_NAMA, "RS HARAPAN DEPOK");
        values.put(KEY_ALAMAT, "JL. PEMUDA NO.10 PANCORAN MAS DEPOK.");
        values.put(KEY_TELEPON, "0217520009");
        values.put(KEY_JAM, "Pagi 10.00-11.00\n"+"Sore 16.30-18.00");
        values.put(KEY_BPJS, "MENERIMA");
        values.put(KEY_GAMBAR, R.drawable.harapan);
        db.insert(TABLE_RS, null, values);

        //11
        values.put(KEY_NAMA, "RS TUGU IBU");
        values.put(KEY_ALAMAT, "JL. RAYA BOGOR KM. 29 CIMANGGIS, DEPOK.");
        values.put(KEY_TELEPON, "0218710870");
        values.put(KEY_JAM, "Pagi 10.00-11.00\n"+"Sore 16.30-18.00");
        values.put(KEY_BPJS, "MENERIMA");
        values.put(KEY_GAMBAR, R.drawable.tugu);
        db.insert(TABLE_RS, null, values);

        //12
        values.put(KEY_NAMA, "RS MITRA KELUARGA DEPOK");
        values.put(KEY_ALAMAT, "JALAN MARGONDA RAYA, PANCORAN MAS, KOTA DEPOK, JAWA BARAT.");
        values.put(KEY_TELEPON, "02177210700");
        values.put(KEY_JAM, "Pagi 10.00-11.00\n"+"Sore 16.30-18.00");
        values.put(KEY_BPJS, "TIDAK MENERIMA");
        values.put(KEY_GAMBAR, R.drawable.mitra);
        db.insert(TABLE_RS, null, values);

        //13
        values.put(KEY_NAMA, "RS BUNDA MARGONDA");
        values.put(KEY_ALAMAT, "JL.MARGONDA RAYA NO.28,PONDOK CINA, BEJI, DEPOK, JAWA BARAT.");
        values.put(KEY_TELEPON, "02178890551");
        values.put(KEY_JAM, "Pagi 10.00-11.00\n"+"Sore 16.30-18.00");
        values.put(KEY_BPJS, "TIDAK MENERIMA");
        values.put(KEY_GAMBAR, R.drawable.bunda);
        db.insert(TABLE_RS, null, values);

        //14
        values.put(KEY_NAMA, "RS MEILIA CIBUBUR");
        values.put(KEY_ALAMAT, "JALAN ALTERNATIVE CIBUBUR KM. 1, HARJAMUKTI, CIMANGGIS, JAWA BARAT.");
        values.put(KEY_TELEPON, "0218444444");
        values.put(KEY_JAM, "Pagi 10.00-11.00\n"+"Sore 16.30-18.00");
        values.put(KEY_BPJS, "TIDAK MENERIMA");
        values.put(KEY_GAMBAR, R.drawable.meilia);
        db.insert(TABLE_RS, null, values);

        //15
        values.put(KEY_NAMA, "RS PERMATA DEPOK ");
        values.put(KEY_ALAMAT, "JALAN RAYA MUCHTAR NO. 22, SAWANGAN, KOTA DEPOK, JAWA BARAT.");
        values.put(KEY_TELEPON, "02129660");
        values.put(KEY_JAM, "Pagi 10.00-11.00\n"+"Sore 16.30-18.00");
        values.put(KEY_BPJS, "TIDAK MENERIMA");
        values.put(KEY_GAMBAR, R.drawable.permata);
        db.insert(TABLE_RS, null, values);
    }


    // Method untuk memperbaharui database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RS);

        // Create tables again
        onCreate(db);

    }


}


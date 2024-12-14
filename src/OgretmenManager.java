
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class OgretmenManager extends Veritabani {

    static Scanner scan = new Scanner(System.in);
    public static void ogretmenMenu() throws InterruptedException {

        // TODO ogretmenMenu() methodundaki eksiklikleri tamamlayiniz
        String secim="";
        do {
            System.out.println(
                    "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                            "================= OGRETMEN MENU =================\n" +
                            "\n" +
                            "\t   1- Ogretmenler Listesi Yazdir\t\n" +
                            "\t   2- Soyisimden Ogretmen Bulma\n" +
                            "\t   3- Branstan Ogretmen Bulma\n" +
                            "\t   4- Bilgilerini Girerek Ogretmen Ekleme\n" +
                            "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                            "\t   A- ANAMENU\n" +
                            "\t   Q- CIKIS\n" +
                            "\t   Seçiminiz = ");

            secim=scan.nextLine().toUpperCase().trim();
            //do while döngüde kalmayı sağlar, switch veya if menülere yönlenmeyi sağlar...
            switch (secim){
                // ÇIKIŞ YAPILMADIĞI SÜRECE ANA MENÜ VEYA ALT MENÜLER ARASINDA DOLAŞILABİLMELİ.
                // AŞAĞIDAKİ METODLARIN BULUNDUĞU YERE GİDEREK, İLGİLİ METODU TANIMLAYINIZ...
                // CTRL + SOL tık LA METODLAR ARASINDA DOLAŞABİLİRSİNİZ.

                case "1": // Ogretmenler Listesi Yazdir.
                ogretmenListesiYazdir(); break;

                case "2": // Soyisimden Ogretmen Bulma
                soyisimdenOgretmenBulma(); break;

                case "3": // Branstan Ogretmen Bulma
                branstanOgretmenBulma(); break;

                case  "4": // Bilgilerini Girerek Ogretmen Ekleme
                ogretmenEkleme(); break;

                case  "5": // Kimlik No Ile Kayit Silme
                tcNoIleOgretmenSil(); break;

                case  "A": // Ana Menü Metodu Çağrılabilmeli
                Helper.anaMenu(); break;

                case  "Q": break;// Çıkış yapılabilmeli

                //   HATALI TERCİH DURUMUNDA TEKRAR SEÇİM İSTENMELİ
                default: System.out.println("Lutfen gecerli tercih yapiniz:");
            }
        }while (!secim.equalsIgnoreCase("Q"));
        // ÇIKIŞ YAPILIRSA
        Helper.projeDurdur();
    }


    public static void tcNoIleOgretmenSil() throws InterruptedException {
        System.out.println("Silinecek ogretmen kimlik no giriniz");
        String silinecekOgretmen = scan.nextLine();

        String silinecekValue = ogretmenlerMap.get(silinecekOgretmen);
        String sonucValue = ogretmenlerMap.remove(silinecekOgretmen);

        System.out.print(silinecekOgretmen + " Siliniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        //////////////////////////////////////////////////////////////////////////////
        // BU BLOĞU DEĞİŞTİRMEYİN, DİKKATE ALMAYIN...                               //
        // SİLİNECEK KİMLİK NO YOKSA VEYA BAŞKA BEKLENMEDİK                         //
        // ŞEYLER OLURSA KODUN DEVAMINI SAĞLAYACAK...
        try {                                                                       //
            boolean sonuc = sonucValue.equals(silinecekValue);                      //
        } catch (Exception e) {                                                     //
            System.out.println("Istediginiz Tc numarasi ile ogretmen bulunamadi");  //
        }                                                                           //
        //////////////////////////////////////////////////////////////////////////////
    }

    ///////////////////////////////////////////////////////////////

    // TODO ogretmenEkleme() methodunu doldurunuz
    public static void ogretmenEkleme() {

        System.out.print("Öğrenci Tc = ");
        String yeniOgrTc=scan.nextLine().trim();
        System.out.print("İsim = ");
        String yeniOgrIsim=scan.nextLine().trim();
        System.out.print("Soyisim = ");
        String yeniOgrSoyisim=scan.nextLine().trim();
        System.out.print("Doğum Yılı = ");
        String yeniOgrDogumYili=scan.nextLine().trim();
        System.out.print("Öğrenci branş = ");
        String yeniOgrBrans=scan.nextLine().trim();

        if (yeniOgrTc.length()==11 && !yeniOgrIsim.isEmpty()) {
            String bilgi = yeniOgrIsim + ", " + yeniOgrSoyisim + ", " + yeniOgrDogumYili + ", " + yeniOgrBrans;
            ogretmenlerMap.put(yeniOgrTc, bilgi);
            System.out.println("Öğretmen eklendi");
        }else System.out.println("Tc Kimlik Hatalıdır");

    }

    // TODO Bu methodu degistirmeyiniz.
    public static void branstanOgretmenBulma() throws InterruptedException {
        System.out.println("Aradiginiz Ogretmenin Bransini Giriniz:");
        String istenenBrans = scan.nextLine();

        System.out.print(istenenBrans + " Ogretmenleri Listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        Set<Map.Entry<String, String>> ogretmenEntrySet = ogretmenlerMap.entrySet();
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "============BRANS ILE OGRETMEN ARAMA ============\n" +
                        "TcNo : Isim , Soyisim , D.Yili , Brans");

        // Daha düzgün bi görünüm için printf veya String.format kullanılabilir... İsteğe bağlı
        for (Map.Entry<String, String> each : ogretmenEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValuarr = eachValue.split(", ");
            if (istenenBrans.equalsIgnoreCase(eachValuarr[3])) {
                System.out.println(eachKey + " : " + eachValue + " | ");
            }
        }
    }

    ///////////////////////////////////////////////////////////////

    // TODO soyisimdenOgretmenBulma() methodunu doldurunuz
    public static void soyisimdenOgretmenBulma() throws InterruptedException {

        System.out.print("Aramak istediğinin soyisim = ");
        String soyIsim=scan.nextLine();
        System.out.print("Öğrenci veritabanında aranıyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        boolean varMi=true;
        for (Map.Entry<String,String>ogretmenMap:ogretmenlerMap.entrySet()){
            if (ogretmenMap.getValue().contains(soyIsim)){
                System.out.println(ogretmenMap.getKey() + " " +ogretmenMap.getValue());
                varMi=false;
            }
        }
        if (varMi){
            System.out.println("Öğrenci bulunamdı :(");
        }

    }

    ///////////////////////////////////////////////////////////////

    // TODO ogretmenListesiYazdir() methodunu doldurunuz
    public static void ogretmenListesiYazdir() throws InterruptedException {

        System.out.print("Öğrtmen Listesi Yazdırılıyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        for (Map.Entry<String,String>ogretmenMap:ogretmenlerMap.entrySet()){
            System.out.println(ogretmenMap.getKey() + " " + ogretmenMap.getValue());
        }

    }
}

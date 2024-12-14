

import java.util.Map;
import java.util.Scanner;

public class OgrenciManager extends Veritabani {

    static Scanner scan = new Scanner(System.in);

    public static void ogrenciMenu() throws InterruptedException {

        // TODO  Bu menunun calismasi icin gerekli duzenlemeleri yapiniz

        //do while döngüde kalmayı sağlar, switch veya if menülere yönlenmeyi sağlar...

            String secim="";
            do {
                System.out.print(
                        "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                                "================== OGRENCI MENU =================\n" +
                                "\t   1- Ogrenci Listesi Yazdir\n" +
                                "\t   2- Soyisimden Ogrenci Bulma\n" +
                                "\t   3- Sinif ve Sube Ile Ogrenci Bulma\n" +
                                "\t   4- Bilgilerini Girerek Ogrenci Ekleme\n" +
                                "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                                "\t   A- ANAMENU\n" +
                                "\t   Q- CIKIS" +
                                "\t   Seçiminiz = ");
                secim=scan.nextLine().toUpperCase().trim();

                switch (secim) {
                    case "1": ogrenciListeYazdir(); break;
                    case "2": soyisimdenOgrenciBulma(); break;
                    case "3": sinifVeSubeIleOgrenciBulma(); break;
                    case "4": ogrenciEkle(); break;
                    case "5": tcNoIleOgrenciSilme(); break;
                    case "A": Helper.anaMenu(); break;
                    case "Q": Helper.projeDurdur(); break;
                    default: System.out.println("Lutfen gecerli tercih yapiniz:");
                }
            }while (!secim.equals("Q"));

        // ÇIKIŞ YAPILIRSA
        Helper.projeDurdur();

    }

    private static void tcNoIleOgrenciSilme() throws InterruptedException {
        System.out.println("Silinecek ogrenci kimlik no giriniz");
        String silinecekOgrenci = scan.nextLine();

        String silinecekValue = ogrenciMap.get(silinecekOgrenci);
        String sonucValue = ogrenciMap.remove(silinecekOgrenci);

        System.out.print(silinecekOgrenci + "Siliniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        //  Programın çalışmaya devam etmesi için gerekli
        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
        } catch (Exception e) {
            System.out.println("Istediginiz TC numarasi ile ogrenci bulunamadi");
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////

    // TODO ogrenciEkle() methodunu doldurunuz
    private static void ogrenciEkle() {
        System.out.print("Öğrenci Tc = ");
        String yeniOgrTc=scan.nextLine().trim();
        System.out.print("İsim = ");
        String yeniOgrIsim=scan.nextLine().trim();
        System.out.print("Soyisim = ");
        String yeniOgrSoyisim=scan.nextLine().trim();
        System.out.print("Doğum Yılı = ");
        String yeniOgrDogumYili=scan.nextLine().trim();
        System.out.print("Öğrenci Numarası = ");
        String yeniOgrNumarasi=scan.nextLine().trim();
        System.out.print("Öğrenci sınıfı = ");
        String yeniOgrSinifi=scan.nextLine().trim();
        System.out.print("Öğrenci Şubesi = ");
        String yeniOgrSubesi=scan.nextLine().trim();
        if (yeniOgrTc.length()==11 && !yeniOgrIsim.isEmpty()) {
            String bilgi = yeniOgrIsim + ", " + yeniOgrSoyisim + ", " + yeniOgrDogumYili + ", " + yeniOgrNumarasi + ", " + yeniOgrSinifi + ", " + yeniOgrSubesi;
            ogrenciMap.put(yeniOgrTc, bilgi);
            System.out.println("Öğrenci eklendi");
        }else System.out.println("Tc Kimlik Hatalıdır");
    }

    ///////////////////////////////////////////////////////////////////////////////////

    // TODO sinifVeSubeIleOgrenciBulma() methodunu doldurunuz
    // OgretmenManager classindaki branstanOgretmenBulma() methodundan faydalanabilirsiniz
    private static void sinifVeSubeIleOgrenciBulma() throws InterruptedException {

        System.out.println("Aradiginiz Ogrencinin Sınıfını Giriniz:");
        String sinif = scan.nextLine();

        System.out.println("Aradiginiz Ogrencinin Şube Giriniz:");
        String sube = scan.nextLine();

        System.out.print(sinif + " " + sube + " Ögrencileri Listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "============BRANS ILE OGRETMEN ARAMA ============\n" +
                        "TcNo : Isim , Soyisim , D.Yili , Brans");

        // Daha düzgün bi görünüm için printf veya String.format kullanılabilir... İsteğe bağlı
        for (Map.Entry<String, String> each : ogrenciMap.entrySet()) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValuarr = eachValue.split(", ");
            if (sinif.equalsIgnoreCase(eachValuarr[4]) && sube.equalsIgnoreCase(eachValuarr[5])) {
                System.out.println(eachKey + " : " + eachValue + " | ");
            }
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////

    // TODO soyisimdenOgrenciBulma() methodunu doldurunuz

    private static void soyisimdenOgrenciBulma() throws InterruptedException {

        System.out.print("Aramak istediğinin soyisim = ");
        String soyIsim=scan.nextLine();
        System.out.print("Öğrenci veritabanında aranıyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        boolean varMi=true;
        for (Map.Entry<String,String>ogrenciMap:ogrenciMap.entrySet()){
            if (ogrenciMap.getValue().contains(soyIsim)){
                System.out.println(ogrenciMap.getKey() + " " +ogrenciMap.getValue());
                varMi=false;
            }
        }
        if (varMi){
            System.out.println("Öğrenci bulunamdı :(");
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////

    // TODO ogrenciListeYazdir() methodunu doldurunuz
    private static void ogrenciListeYazdir() throws InterruptedException {

        System.out.print("Öğrenci Listesi Yazdırılıyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        for (Map.Entry<String,String>ogrenciMap:ogrenciMap.entrySet()){
            System.out.println(ogrenciMap.getKey() + " " + ogrenciMap.getValue());
        }

    }
}


import java.util.Map;
import java.util.Scanner;

public class Helper {
    static Scanner scan = new Scanner(System.in);

    // TODO Bu class'da BİR DEĞİŞİKLİK YAPMAYINIZ!
    public static void anaMenu() throws InterruptedException {

        String tercih="";
        do{
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "=================== ANA MENU ====================\n" +
                        "\n" +
                        "\t   1- Okul Bilgileri Goruntule\n" +
                        "\t   2- Ogretmen Menu\n" +
                        "\t   3- Ogrenci Menu\t\t \n" +
                        "\t   Q- CIKIS\n");
        System.out.print("Lutfen Menuden tercihinizi yapiniz:");

        tercih=scan.nextLine().toLowerCase();

        switch (tercih){
            case "1" :  // Okul bilgileri
                Helper.okulBilgileriniYazdir();
                break;
            case "2" :  // Ogretmen menu
                OgretmenManager.ogretmenMenu();
               break;
            case "3" :  // ogrenci menu
                OgrenciManager.ogrenciMenu();
               break;
            case "q" :
                break;
            default  :
                System.out.print("Lutfen gecerli bir tercih giriniz:");
        }


        }while(!tercih.equalsIgnoreCase("q"));


        Helper.projeDurdur();
    }

    public static void okulBilgileriniYazdir() throws InterruptedException {

        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println("Öğretmenler Listesi : ");
        for (Map.Entry<String,String>ogrMap:Veritabani.ogretmenlerMap.entrySet()){
            System.out.println(ogrMap.getKey() + " " + ogrMap.getValue());
        }

        System.out.println("Öğrenciler Listesi : ");
        for (Map.Entry<String,String>ogrMap:Veritabani.ogrenciMap.entrySet()){
            System.out.println(ogrMap.getKey() + " " + ogrMap.getValue());
        }
    }

    public static void projeDurdur() {
        System.out.println("Okul projesinden ciktiniz");
        System.exit(0);
    }
}

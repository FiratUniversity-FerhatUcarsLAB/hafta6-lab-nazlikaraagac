Ad Soyad: Nazli Karaagac
Ogrenci No: 250541105
Proje Adi: Restoran Siparis
Tarih: 27.11.2025

import java.util.Scanner;

public class RestoranSiparisi {

    public static double getMainDishPrice(int secim) {
        switch (secim) {
            case 1: return 85;
            case 2: return 120;
            case 3: return 110;
            case 4: return 65;
            default: return 0;
        }
    }

    public static double getAppetizerPrice(int secim) {
        switch (secim) {
            case 1: return 25;
            case 2: return 45;
            case 3: return 55;
            default: return 0;
        }
    }

    public static double getDrinkPrice(int secim) {
        switch (secim) {
            case 1: return 15;
            case 2: return 12;
            case 3: return 35;
            case 4: return 25;
            default: return 0;
        }
    }

    public static double getDessertPrice(int secim) {
        switch (secim) {
            case 1: return 65;
            case 2: return 55;
            case 3: return 35;
            default: return 0;
        }
    }

    public static boolean isComboOrder(int ana, int icecek, int tatli) {
        return (ana != 0 && icecek != 0 && tatli != 0);
    }

    public static boolean isHappyHour(int saat) {
        return (saat >= 14 && saat <= 17);
    }

    public static double calculateDiscount(double tutar, boolean combo, boolean ogrenci, int saat) {

        double indirim = 0;

        if (combo) {
            indirim += tutar * 0.15;
        }

        if (isHappyHour(saat)) {
        }

        if (tutar > 200) {
            indirim += tutar * 0.10;
        }

        if (ogrenci) {
            indirim += tutar * 0.10;
        }
         return indirim;
    }

    public static double calculateServiceTip(double tutar) {
        return tutar * 0.10;
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Ana Yemek (1-4) : ");
        int ana = input.nextInt();

        System.out.print("Baslangic (0-3) : ");
        int bas = input.nextInt();

        System.out.print("Icecek (0-4) : ");
        int icecek = input.nextInt();

        System.out.print("Tatli (0-4) : ");
        int tatli = input.nextInt();

        System.out.print("Saat (8-23) : ");
        int saat = input.nextInt();

        System.out.print("Ogrenci misiniz? (E/H): ");
        boolean ogrenci = input.nextBoolean();

        System.out.print("Gun (1-7): ");
        int gun = input.nextInt();

        boolean haftaIci = gun >= 1 && gun <= 5;

        double fAna = getMainDishPrice(ana);
        double fBas = getAppetizerPrice(bas);
        double fIcecek = getDrinkPrice(icecek);
        double fTatli = getDessertPrice(tatli);

        double araToplam = fAna + fBas + fIcecek + fTatli;

        boolean combo = isComboOrder(ana, icecek, tatli);

        double happyIndirim = 0;
        if (isHappyHour(saat) && icecek != 0) {
            happyIndirim = fIcecek * 0.20;
        }

        boolean ogrenciIndirimUygula = ogrenci && haftaIci;

        double genelIndirim = 0;
        if (combo) genelIndirim += araToplam * 0.15;
        if (araToplam > 200) genelIndirim += araToplam * 0.10;
        if (ogrenciIndirimUygula) genelIndirim += araToplam * 0.10;

        double toplamIndirim = genelIndirim + happyIndirim;
        double toplam = araToplam - toplamIndirim;
        double bahsis = calculateServiceTip(toplam);

        System.out.printf("\nAra Toplam : %.2f TL\n", araToplam);
        System.out.printf("Combo Indirimi : %.2f TL\n", combo ? araToplam * 0.15 : 0);
        System.out.printf("Happy Hour Indirimi : %.2f TL\n", happyIndirim);
        System.out.printf("Ogrenci Indirimi : %.2f TL\n", ogrenciIndirimUygula ? araToplam * 0.10 : 0);
        System.out.printf("Genel Indirimler : %.2f TL\n", toplamIndirim);
        System.out.printf("Toplam : %.2f TL\n", toplam);
        System.out.printf("Bahsis Onerisi (%%10) : %.2f TL\n", bahsis);
    }
}

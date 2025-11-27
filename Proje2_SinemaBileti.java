Ad Soyad: Nazli Karaagac
Ogrenci No: 250541105
Proje Adi: Sinema Bileti
Tarih: 27.11.2025

import java.util.Scanner;

public class SinemaBileti {

    public static boolean isWeekend(int gun) {
        return gun == 6 || gun == 7;
    }

    public static boolean isMatinee(int saat) {
        return saat < 12;
    }

    public static double calculateBasePrice(int gun, int saat) {
        boolean weekend = isWeekend(gun);
        boolean matinee = isMatinee(saat);

        if (!weekend && matinee) return 45;
        if (!weekend && !matinee) return 65;
        if (weekend && matinee) return 55; 
        return 85;
    }

    public static double calculateDiscount(int yas, int meslek, int gun, double basePrice) {

        if (yas < 12) return basePrice * 0.25;
        if (yas >= 65) return basePrice * 0.30;

        switch (meslek) {
            case 1: 
                if (gun >= 1 && gun <= 4) return basePrice * 0.20;
                else return basePrice * 0.15;

            case 2: 
                if (gun == 3) return basePrice * 0.35;
                break;
        }

        return 0; 
    }

    public static int getFormatExtra(int filmTuru) {
        switch (filmTuru) {
            case 1: return 0;
            case 2: return 25;
            case 3: return 35;
            case 4: return 50;
            default: return 0;
        }
    }

    public static double calculateFinalPrice(int gun, int saat, int yas, int meslek, int filmTuru) {
        double base = calculateBasePrice(gun, saat);
        double discount = calculateDiscount(yas, meslek, gun, base);
        double formatExtra = getFormatExtra(filmTuru);

        return (base - discount) + formatExtra;
    }

    public static void generateTicketInfo(int gun, int saat, int yas, int meslek, int filmTuru) {
        double base = calculateBasePrice(gun, saat);
        double discount = calculateDiscount(yas, meslek, gun, base);
        double formatExtra = getFormatExtra(filmTuru);
        double finalPrice = calculateFinalPrice(gun, saat, yas, meslek, filmTuru);

        System.out.printf("\n=== Bilet Bilgisi ===\n");
        System.out.printf("Temel Fiyat    : %.2f TL\n", base);
        System.out.printf("İndirim        : -%.2f TL\n", discount);
        System.out.printf("Ekstra Ucret   : +%.2f TL\n", formatExtra);
        System.out.printf("Toplam Fiyat   : %.2f TL\n", finalPrice);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Gun (1-7): ");
        int gun = input.nextInt();

        System.out.printf("Saat (8-23): ");
        int saat = input.nextInt();

        System.out.printf("Yas: ");
        int yas = input.nextInt();

        System.out.printf("Meslek (1-3): ");
        int meslek = input.nextInt();

        System.out.printf("Film Turu (1-4): ");
        int filmTuru = input.nextInt();

        generateTicketInfo(gun, saat, yas, meslek, filmTuru);
    }
}


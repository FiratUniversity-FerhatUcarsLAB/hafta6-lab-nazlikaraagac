Ad Soyad: Nazli Karaagac
Ogrenci No: 250541105
Proje Adi: Not Sistemi
Tarih: 27.11.2025


import java.util.Scanner;

public class OgrenciNotRaporu {
    public static double calculateAverage(double vize, double fin, double odev) {
        return vize * 0.3 + fin * 0.4 + odev * 0.3;
    }

    public static boolean isPassingGrade (double ortalama) {
        return ortalama >= 50.0;
    } 
    
    public static char getLetterGrade(double ortalama) {
        if (ortalama >= 90.0) {
            return 'A';
        } else if (ortalama >= 80.0) {
            return 'B';
        } else if (ortalama >= 70.0) {
            return 'C';
        }else if (ortalama >= 60.0) {
            return 'D';
        } else {
            return 'F'; }
    }

    public static boolean isHonorList(double ortalama, double vize, double fin, double odev) {
        return ortalama >= 85.0 && vize >= 70.0 && fin >= 70.0 && odev >= 70.0;
    }
    
    public static boolean hasRetakeRight(double ortalama) {
        return ortalama >= 40.0 && ortalama < 50.0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        System.out.print("Vize: ");
        double vize = input.nextDouble();

        System.out.print("Final: ");
        double fin = input.nextDouble();

        System.out.print("Ödev: ");
        double odev = input.nextDouble();

        if (vize < 0 || vize > 100 || fin < 0 || fin > 100 || odev < 0 || odev > 100) {
            System.out.println("Hata: Notlar 0 ile 100 arasında olmalıdır.");
            input.close();
            return;
        }
    
        double ortalama = calculateAverage(vize, fin, odev);
        char harf = getLetterGrade(ortalama);
        boolean gecti = isPassingGrade(ortalama);
        boolean onur = isHonorList(ortalama, vize, fin, odev);
        boolean butunleme = hasRetakeRight(ortalama);


        System.out.println();
        System.out.println("=== OGRENCİ NOT RAPORU ===");
        System.out.printf("Vize Notu      : %.1f%n", vize);
        System.out.printf("Final Notu     : %.1f%n", fin);
        System.out.printf("Odev Notu      : %.1f%n", odev);
        System.out.println("--------------------------------");
        System.out.printf("Ortalama       : %.1f%n", ortalama);
        System.out.println("Harf Notu      : " + harf);
        System.out.println("Durum          : " + (gecti ? "GECTI" : "KALDI"));
        System.out.println("Onur Listesi   : " + (onur ? "EVET" : "HAYIR"));
        System.out.println("Butunleme      : " + (butunleme ? "VAR" : "YOK"));

        input.close();
    }
}


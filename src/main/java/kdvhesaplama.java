import java.util.Scanner;
public class kdvhesaplama {
    private static String username = "admin";
    private static String password = "1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== KDV HESAPLAMA UYGULAMASI =====");
        if (login(scanner)) {
            menu(scanner);
        } else {
            System.out.println("Geçersiz giriş! Program sonlandırılıyor.");
        }
        scanner.close();
    }

    private static boolean login(Scanner scanner) {
        System.out.print("Kullanıcı Adı: ");
        String inputUser = scanner.nextLine();

        System.out.print("Şifre: ");
        String inputPass = scanner.nextLine();

        return username.equals(inputUser) && password.equals(inputPass);
    }

    private static void menu(Scanner scanner) {
        while (true) {
            System.out.println("\n===== MENÜ =====");
            System.out.println("1 - KDV Hesapla");
            System.out.println("2 - Kullanıcı Değiştir");
            System.out.println("3 - Çıkış");
            System.out.print("Seçiminizi yapın: ");

            int secim = scanner.nextInt();
            scanner.nextLine(); // Boş satırı tüket

            switch (secim) {
                case 1:
                    startKdvCalculator(scanner);
                    break;
                case 2:
                    System.out.println("\nÇıkış yapılıyor... Yeniden giriş yapın.");
                    if (!login(scanner)) {
                        System.out.println("Yanlış giriş! Program sonlandırılıyor.");
                        return;
                    }
                    break;
                case 3:
                    System.out.println("Programdan çıkılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
            }
        }
    }

    private static void startKdvCalculator(Scanner scanner) {
        System.out.print("Tutarı giriniz: ");
        double tutar = scanner.nextDouble();

        System.out.print("KDV Oranı (%): ");
        double kdvOrani = scanner.nextDouble();

        double kdvTutar = (tutar * kdvOrani) / 100;
        double toplamTutar = tutar + kdvTutar;

        System.out.printf("KDV: %.2f TL, Toplam: %.2f TL\n", kdvTutar, toplamTutar);
    }
}
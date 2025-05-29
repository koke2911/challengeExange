import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Principal {
    public static void main(String[] args) {

        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║         🌍 Códigos de Monedas Disponibles      ║");
        System.out.println("╠════════════╦═══════════════════════════════════╣");
        System.out.println("║ Código     ║ Moneda                            ║");
        System.out.println("╠════════════╬═══════════════════════════════════╣");
        System.out.println("║ USD        ║ Dólar estadounidense              ║");
        System.out.println("║ EUR        ║ Euro                              ║");
        System.out.println("║ CLP        ║ Peso chileno                      ║");
        System.out.println("║ ARS        ║ Peso argentino                    ║");
        System.out.println("║ BRL        ║ Real brasileño                    ║");
        System.out.println("║ MXN        ║ Peso mexicano                     ║");
        System.out.println("║ COP        ║ Peso colombiano                   ║");
        System.out.println("║ GBP        ║ Libra esterlina                   ║");
        System.out.println("║ JPY        ║ Yen japonés                       ║");
        System.out.println("║ CNY        ║ Yuan chino                        ║");
        System.out.println("║ PEN        ║ Sol peruano                       ║");
        System.out.println("║ CAD        ║ Dólar canadiense                  ║");
        System.out.println("║ AUD        ║ Dólar australiano                 ║");
        System.out.println("║ UYU        ║ Peso uruguayo                     ║");
        System.out.println("║ KRW        ║ Won surcoreano                    ║");
        System.out.println("╚════════════╩═══════════════════════════════════╝");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        ConversorDeMoneda conversor = new ConversorDeMoneda();

        System.out.println("Conversor de monedas");
        System.out.print("Moneda base : ");
        String base = scanner.nextLine().toUpperCase();

        System.out.print("Moneda destino :");
        String destino = scanner.nextLine().toUpperCase();

        System.out.print("Monto a convertir: ");
        double monto = Double.parseDouble(scanner.nextLine());

        try {
            double tasa = conversor.obtenerTasaCambio(base, destino);
            double resultado = monto * tasa;
            BigDecimal resultadoRedondeado = BigDecimal.valueOf(resultado).setScale(2, RoundingMode.HALF_UP);
            System.out.println(monto + " " + base + " equivale a " + resultadoRedondeado + " " + destino);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

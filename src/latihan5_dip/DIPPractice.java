package latihan5_dip;

// import latihan5_dip.good.*; // Uncomment setelah refactoring selesai

public class DIPPractice {
    public static void main(String[] args) {
        /*
         * LATIHAN 5: DEPENDENCY INVERSION PRINCIPLE (DIP)
         *
         * Definisi:
         * "High-level modules should not depend on low-level modules.
         *  Both should depend on abstractions."
         *
         * Konteks:
         * Payment Processing System - memproses pembayaran online
         */

        // ===== PART 1: BAD PRACTICE - Melanggar DIP =====
        System.out.println("=== BAD PRACTICE: Melanggar DIP ===\n");

        // PaymentService tightly coupled ke concrete class
        latihan5_dip.bad.PaymentService badService = new latihan5_dip.bad.PaymentService();
        badService.processPayment("4532-1234-5678-9010", 150000.0, "user@example.com");

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("PaymentService TIGHTLY COUPLED dengan concrete classes:");
        System.out.println("✗ Tidak bisa ganti implementasi tanpa ubah PaymentService");
        System.out.println("✗ Susah testing / mocking");

        System.out.println("\n" + "=".repeat(70));

        // ===== PART 2: GOOD PRACTICE - Mengikuti DIP =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti DIP ===\n");

        /*
         * Setelah refactoring:
         * - PaymentService depend on interfaces, bukan concrete classes
         * - Dependencies di-inject via constructor
         * - Mudah ganti gateway, mock untuk testing, loose coupling
         */
    }
}

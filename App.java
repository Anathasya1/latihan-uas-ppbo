import controllers.HospitalController;
import exceptions.InvalidDataException;
import view.HospitalView;

public class App {
    public static void main(String[] args) {
        HospitalController controller = new HospitalController();
        System.out.println(">> Sedang memuat data awal...");
        try {
            // Menambahkan beberapa Dokter
            controller.addTenagaMedis("D001", "Dr. Budi Santoso", 15000000, 200000, 10, 5);
            controller.addTenagaMedis("D002", "Dr. Siti Aminah", 18000000, 250000, 15, 2);

            // Menambahkan beberapa Perawat
            controller.addTenagaMedis("P001", "Ns. Rina Wati", 5000000, 5, 10);
            controller.addTenagaMedis("P002", "Ns. Joko Anwar", 5500000, 10, 15);

            // Menambahkan Staff Admin
            controller.addTenagaMedis("A001", "Andi Administrasi", 4000000, 1000000);

            System.out.println(">> Berhasil memuat " + controller.getAllObjects().size() + " data dummy.");
            System.out.println("-------------------------------------------------");
            
        } catch (InvalidDataException e) {
            System.out.println("Gagal load dummy data: " + e.getMessage());
        }
        HospitalView hospitalView = new HospitalView(controller);
        hospitalView.menuUtama();
    }
}

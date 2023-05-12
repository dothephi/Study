import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Queue;

class Bia {
    private final String id;
    private final String tenBia;
    private final String noiSanXuat;
    private double donGia;

    public Bia(String id, String tenBia, String noiSanXuat, double donGia) {
        this.id = id;
        this.tenBia = tenBia;
        this.noiSanXuat = noiSanXuat;
        this.donGia = donGia;
    }

    public String getId() {
        return id;
    }

    public String getTenBia() {
        return tenBia;
    }

    public String getNoiSanXuat() {
        return noiSanXuat;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
}

public class QuanLyLonBia {
    private static final Queue<Bia> danhSachLonBia = new LinkedList<>();

    public static void main(String[] args) {
        themBiaVaoQueue(new Bia("B01", "Bia 1", "Tay Ninh", 15000));
        themBiaVaoQueue(new Bia("B02", "Bia 2", "Tay Du Ky", 18000));
        themBiaVaoQueue(new Bia("B03", "Bia 3", "Tay Du Ky", 20000));

        capNhatDonGiaTaiTayTang(200);

        luuFileBeerTxt();

        inToanBoLonBiaDaNhap();
    }

    public static void themBiaVaoQueue(Bia bia) {
        if (!kiemTraTrungLapId(bia.getId()) && bia.getDonGia() <= 25000) {
            danhSachLonBia.add(bia);
        } else {
            System.out.println("Khong the them lon bia vao queue!");
        }
    }

    public static boolean kiemTraTrungLapId(String id) {
        for (Bia bia : danhSachLonBia) {
            if (bia.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static void capNhatDonGiaTaiTayTang(double soTienThem) {
        for (Bia bia : danhSachLonBia) {
            if (bia.getNoiSanXuat().equals("Tay Tạng")) {
                bia.setDonGia(bia.getDonGia() + soTienThem);
            }
        }
    }

    public static void luuFileBeerTxt() {
        try {
            File file = new File("Beer.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Bia bia : danhSachLonBia) {
                bufferedWriter.write("ID: " + bia.getId() + ", Ten bia: " + bia.getTenBia() +
                        ", Noi san xuat: " +


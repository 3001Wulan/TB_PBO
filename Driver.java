import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import com.mysql.cj.protocol.Resultset;
import java.text.SimpleDateFormat;
import java.text.*;
import java.util.Date;
//Database CRUD dan Collection Framework

public class Driver {
    static Connection conn;
    public static void main(String[] args) throws Exception {
        Integer angka;
        int i=0;
        Integer no=1;
        boolean bool = true;
        String pilihan2;
        boolean lanjut2 = true;

        Queue<String> queue= new LinkedList<String>();
        Scanner pilih = new Scanner(System.in);
        Scanner input2 = new Scanner (System.in);
        String url = "jdbc:mysql://localhost:3306/dbpbodaftarulang_2211523001_wulandari yulianis";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,"root","");
            System.out.println("\nClass Driver sudah ditemukan"); 

            //Perulangan
            do{ 
            System.out.print("\n---------------------------------------------------------" + "\n");
            System.out.println("                 ANTRIAN DAFTAR ULANG                           "); 
            System.out.print("---------------------------------------------------------"+ "\n"   );
            System.out.println("1. Tambah antrian");
            System.out.println("2. Panggil antrian");
            System.out.println("3. Cek status antrian");
            System.out.println("4. Kosongkan antrian");
            System.out.println("5. Tampilkan antrian ");
            System.out.println("6. Data Daftar Ulang ");
            System.out.println("7. Keluar");
            System.out.print("Masukkan pilihan Anda (1/2/3/4/5/6/7): ");
            int day=pilih.nextInt();
            switch (day) {
            case 1:
                System.out.print("\n" + "Antrian bertambah 1 " + "\n");
                queue.add("Antrian " + no);
                no=no+1;
                break;
            case 2:
                if (queue.size()==0){
                    System.out.print("\n" +"Antrian kosong" + "\n");
                }
                else {
                    System.out.println("\n" + "Peserta sudah dipanggil : " + queue.remove());
                    tambahData();
                }
                break;
            case 3:
                System.out.println("\n" + "Status Antrian");
                System.out.println("Jumlah antrian : " + queue.size());
                if (queue.size()==0){
                    System.out.print("Antrian berikutnya kosong" + "\n");
                }
                else {
                    System.out.println("Antrian berikutnya : " + queue.peek());
                }
                break;
            case 4:
                queue.clear();
                System.out.print("\n" + "Antrian sudah dikosongkan" + "\n");
                break;
            case 5:
                if (queue.size()==0){
                    System.out.print("\n" +"Antrian kosong" + "\n");
                }
                else {
                    System.out.println("\n" +"Antrian : " + queue + "\n");
                }
                break;
            case 6:
                do{
                    System.out.print("\n---------------------------------------------------------");
                    System.out.print("\n          PROGRAM DATABASE DAFTAR ULANG MAHASISWA        ");
                    System.out.print("\n---------------------------------------------------------\n");
                    System.out.println("1. Lihat Data           ");
                    System.out.println("2. Ubah Data            ");
                    System.out.println("3. Hapus Data           ");
                    System.out.println("4. Cari Data            ");
                    System.out.println("5. Kembali           ");
                    System.out.print("Inputkan pilihan anda (1/2/3/4/5) : ");
                    pilihan2 = input2.next();
                        
                    switch (pilihan2) {
                    case "1":
                        lihatData();
                        break;
                    case "2":
                        ubahData();
                        break;
                    case "3":
                        hapusData();
                        break;
                    case "4":
                        cariData();
                        break;
                    case "5":
                        main(args);
                        break;
                    default:
                        System.err.println("\nMaaf pilihan Anda tidak tersedia\nSilakan pilih kembali (1-4)");
                    }
                }
                while(lanjut2);
                break;
            case 7:
                System.out.println("\n Terimakasi Telah Melakukan pendaftaran Ulang,Program selesai");
                System.exit(0);
                break;
            default :
                System.out.println("Warning! Pilihan Anda tidak tersedia!");
            }
            }
            while(bool);
        }
        catch(ClassNotFoundException ex) {
            System.err.println("Warning! driver error");
            System.exit(0);
        }
        catch(SQLException e){
            System.err.println("Warning! Tidak berhasil melakukan koneksi");
        }
    }

    private static void tambahData() throws SQLException{
        try {
        System.out.print("\n---------------------------------------------------------");
        System.out.print("\n           TAMBAH DATA DAFTAR ULANG MAHASISWA            ");
        System.out.print("\n---------------------------------------------------------\n");
        
        Scanner input = new Scanner (System.in);
        String pilihan;
        boolean lanjut = true;
    
        //Perulangan
        while (lanjut){
        System.out.print("\n---------------------------------------------------------"+"\n");
        String teks1="Program Daftar Ulang D3 dan D4";
        System.out.print("\t" + teks1.toUpperCase() +    "\n");
        System.out.print("---------------------------------------------------------"+"\n");
        System.out.println("JEnis Studi                   ");
        System.out.println("1. Diploma 3 (D3)               ");
        System.out.println("2. Diploma 4 (D4)               ");
        System.out.print("\nMasukkan pilihan Anda (1/2) : ");
        pilihan = input.next();
        
        switch (pilihan){
        case "1":
            System.out.print("\n---------------------------------------------------------"+"\n");
            String teks2="Program Daftar Ulang Mahasiswa D3";
            System.out.print("\t" + teks2.toUpperCase() +    "\n");
            System.out.print("---------------------------------------------------------"+"\n");
            
            DaftarUlangD3 mahasiswaA=new DaftarUlangD3(); 
            
            mahasiswaA.Tanggal();
            mahasiswaA.Waktu();
            mahasiswaA.NoPeserta();
            mahasiswaA.Nama();
            mahasiswaA.Alamat();
            mahasiswaA.NoHP();
            System.out.println(mahasiswaA.JenisFakultas());
            mahasiswaA.Fakultas();
            mahasiswaA.Jurusan();
            mahasiswaA.Rincian();
            System.out.println(mahasiswaA.JenisBeasiswa());
            mahasiswaA.Beasiswa();
            mahasiswaA.Potongan();
            mahasiswaA.TotalBiaya();

            String tanggal=mahasiswaA.tanggal;
            String waktu=mahasiswaA.waktu;
            int noPeserta=mahasiswaA.noPeserta;
            String nama=mahasiswaA.nama;
            String alamat=mahasiswaA.alamat;
            String noHP=mahasiswaA.noHP;
            String fakultas=mahasiswaA.fakultas;
            String jurusan=mahasiswaA.jurusan;
            int biaya=mahasiswaA.biaya;
            String beasiswa=mahasiswaA.beasiswa;
            int potongan=mahasiswaA.potongan;
            int totalBiaya=mahasiswaA.totalBiaya;
    
            String sql = "INSERT INTO daftarulang (tanggal, waktu, noPeserta, nama, alamat, noHP, fakultas, jurusan, biaya, beasiswa, potongan, totalBiaya) VALUES ('%s','%s','%d','%s','%s','%s','%s','%s','%d','%s','%d','%d')";
            sql = String.format(sql, tanggal, waktu, noPeserta, nama, alamat, noHP, fakultas, jurusan, biaya, beasiswa, potongan, totalBiaya);
    
            Statement statement = conn.createStatement();
            statement.execute(sql);
            System.out.println("Berhasil menambahkan data");
            lanjut = false;
            break;
        case "2":
            System.out.print("\n---------------------------------------------------------"+"\n");
            String teks3="Program Daftar Ulang Mahasiswa D4";
            System.out.print("\t" + teks3.toUpperCase() +    "\n");
            System.out.print("---------------------------------------------------------"+"\n");
            
            DaftarUlangD4 mahasiswaB=new DaftarUlangD4();

            mahasiswaB.Tanggal();
            mahasiswaB.Waktu();
            mahasiswaB.NoPeserta();
            mahasiswaB.Nama();
            mahasiswaB.Alamat();
            mahasiswaB.NoHP();
            System.out.println(mahasiswaB.JenisFakultas());
            mahasiswaB.Fakultas();
            mahasiswaB.Jurusan();
            mahasiswaB.Rincian();
            System.out.println(mahasiswaB.JenisBeasiswa());
            mahasiswaB.Beasiswa();
            mahasiswaB.Potongan();
            mahasiswaB.TotalBiaya();

            tanggal=mahasiswaB.tanggal;
            waktu=mahasiswaB.waktu;
            noPeserta=mahasiswaB.noPeserta;
            nama=mahasiswaB.nama;
            alamat=mahasiswaB.alamat;
            noHP=mahasiswaB.noHP;
            fakultas=mahasiswaB.fakultas;
            jurusan=mahasiswaB.jurusan;
            biaya=mahasiswaB.biaya;
            beasiswa=mahasiswaB.beasiswa;
            potongan=mahasiswaB.potongan;
            totalBiaya=mahasiswaB.totalBiaya;
    
            sql = "INSERT INTO daftarulang (tanggal, waktu, noPeserta, nama, alamat, noHP, fakultas, jurusan, biaya, beasiswa, potongan, totalBiaya) VALUES ('%s','%s','%d','%s','%s','%s','%s','%s','%d','%s','%d','%d')";
            sql = String.format(sql,tanggal,waktu, noPeserta, nama, alamat, noHP, fakultas, jurusan, biaya, beasiswa, potongan, totalBiaya);
    
            Statement statement2 = conn.createStatement();
            statement2.execute(sql);
            System.out.println("Berhasil menambahkan data");
            lanjut = false;
            break;
        default:
            System.err.println("\nMaaf pilihan Anda tidak tersedia\nSilakan pilih kembali (1-2)");
            lanjut = true;
        }
        }
        }
		catch (SQLException e) {
            System.err.println("Warning! Terjadi kesalahan input data");
        }
		catch (InputMismatchException e) {
            System.err.println("Warning! Inputan hanya angka");
        }
    }

    private static void lihatData() throws SQLException {
        System.out.print("\n---------------------------------------------------------");
        System.out.print("\n            RINCIAN DATA DAFTAR ULANG MAHASISWA          ");
        System.out.print("\n---------------------------------------------------------");
        
        String sql ="SELECT * FROM daftarulang";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        int no=1;
        
        //Perulangan
        while(result.next()){
            System.out.print("\n---------------------------------------------------------");
            System.out.print("\n             DATA DAFTAR ULANG MAHASISWA " + no);
            System.out.print("\n---------------------------------------------------------");
            System.out.print("\nTanggal            : ");
            System.out.print(result.getString("tanggal"));
            System.out.print("\nWaktu              : ");
            System.out.print(result.getString("waktu"));
			System.out.print("\nNo Peserta         : ");
            System.out.print(result.getInt("noPeserta"));
            System.out.print("\nNama               : ");
            System.out.print(result.getString("nama"));
            System.out.print("\nAlamat             : ");
            System.out.print(result.getString("alamat"));
            System.out.print("\nNomor HP           : ");
            System.out.print(result.getString("noHP"));
			System.out.print("\nFakultas           : ");
            System.out.print(result.getString("fakultas"));
			System.out.print("\nJurusan            : ");
            System.out.print(result.getString("jurusan"));
			System.out.print("\nBiaya              : Rp.");
            System.out.print(result.getInt("biaya"));
            System.out.print("\nBeasiswa           : ");
            System.out.print(result.getString("beasiswa"));
            System.out.print("\nPotongan           : Rp.");
            System.out.print(result.getInt("potongan"));
            System.out.print("\nTotal Biaya        : Rp.");
            System.out.print(result.getInt("totalBiaya"));
            System.out.print("\n---------------------------------------------------------");
            no++;
        }
    }

    private static void hapusData() {
        System.out.print("\n---------------------------------------------------------");
        System.out.print("\n                HAPUS DATA PENDAFTARAN ULANG                 ");
        System.out.print("\n---------------------------------------------------------\n");
        
        Scanner terimaInput = new Scanner (System.in);
        
        try{
            lihatData();
            System.out.print("\n\nInputkan nomor peserta : ");
            Integer noPeserta= Integer.parseInt(terimaInput.nextLine());
            
            String sql = "DELETE FROM daftarulang WHERE noPeserta = "+ noPeserta;
            Statement statement = conn.createStatement();
            
            if(statement.executeUpdate(sql) > 0){
                System.out.println("Berhasil menghapus data  dengan nomor peserta "+noPeserta+"");
            }
       	}
		catch(SQLException e){
            System.out.println("Warning! Terjadi kesalahan dalam menghapus data");
        }
    }

    private static void cariData () throws SQLException {
        System.out.print("\n---------------------------------------------------------");
        System.out.print("\n           CARI DATA DAFTAR ULANG MAHASISWA              ");
        System.out.print("\n---------------------------------------------------------\n");
        
        Scanner terimaInput = new Scanner (System.in); 
        System.out.print("\nInputkan nama : ");
        String keyword = terimaInput.nextLine();
        
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM daftarulang WHERE nama LIKE '%"+keyword+"%'";
        ResultSet result = statement.executeQuery(sql);  
        
        while(result.next()){
            System.out.print("\n---------------------------------------------------------");
            System.out.print("\n               DATA DAFTAR ULANG MAHASISWA               ");
            System.out.print("\n---------------------------------------------------------");
            System.out.print("\nTanggal            : ");
            System.out.print(result.getString("tanggal"));
            System.out.print("\nWaktu              : ");
            System.out.print(result.getString("waktu"));
			System.out.print("\nNo Peserta         : ");
            System.out.print(result.getInt("noPeserta"));
            System.out.print("\nNama               : ");
            System.out.print(result.getString("nama"));
            System.out.print("\nAlamat             : ");
            System.out.print(result.getString("alamat"));
            System.out.print("\nNomor HP           : ");
            System.out.print(result.getString("noHP"));
			System.out.print("\nFakultas           : ");
            System.out.print(result.getString("fakultas"));
			System.out.print("\nJurusan            : ");
            System.out.print(result.getString("jurusan"));
			System.out.print("\nBiaya              : Rp.");
            System.out.print(result.getInt("biaya"));
            System.out.print("\nBeasiswa           : ");
            System.out.print(result.getString("beasiswa"));
            System.out.print("\nPotongan           : Rp.");
            System.out.print(result.getInt("potongan"));
            System.out.print("\nTotal Biaya        : Rp.");
            System.out.print(result.getInt("totalBiaya"));
            System.out.print("\n---------------------------------------------------------");
            System.out.print("\n");
        }
    }

    private static void ubahData() throws SQLException{
        try {
        System.out.print("\n---------------------------------------------------------");
        System.out.print("\n           UPDATE DATA DAFTAR ULANG MAHASISWA            ");
        System.out.print("\n---------------------------------------------------------\n");
        
        Scanner input = new Scanner (System.in);
        String pilihan;
        boolean lanjut = true;
        
        //Perulangan
        while (lanjut){
        System.out.print("\n---------------------------------------------------------"+"\n");
        String teks1="Program Daftar Ulang Mahasiswa D3 dan D4";
        System.out.print("\t" + teks1.toUpperCase() +    "\n");
        System.out.print("---------------------------------------------------------"+"\n");
        System.out.println("Jenis Studi                    ");
        System.out.println("1. Diploma (D3)               ");
        System.out.println("2. Diploma (D4)               ");
        System.out.print("\nMasukkan pilihan Anda (1/2) : ");
        pilihan = input.next();
        
        switch (pilihan){
            case "1":
                System.out.print("\n---------------------------------------------------------"+"\n");
                String teks2="Program Daftar Ulang Mahasiswa D3";
                System.out.print("\t" + teks2.toUpperCase() +    "\n");
                System.out.print("---------------------------------------------------------"+"\n");
            
                lihatData();
                Scanner terimaInput = new Scanner (System.in);  
                System.out.print("\nMasukkan nomor peserta yang akan di update: ");
                Integer noPeserta=Integer.parseInt(terimaInput.nextLine());
                
                String sql= "SELECT * FROM daftarulang WHERE noPeserta = " +noPeserta;
                
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                
                if(result.next()){
                DaftarUlangD3 mahasiswaA=new DaftarUlangD3(); 
                
                mahasiswaA.Tanggal();
                mahasiswaA.Waktu();
                mahasiswaA.Nama();
                mahasiswaA.Alamat();
                mahasiswaA.NoHP();
                System.out.println(mahasiswaA.JenisFakultas());
                mahasiswaA.Fakultas();
                mahasiswaA.Jurusan();
                mahasiswaA.Rincian();
                System.out.println(mahasiswaA.JenisBeasiswa());
                mahasiswaA.Beasiswa();
                mahasiswaA.Potongan();
                mahasiswaA.TotalBiaya();

                String tanggal=mahasiswaA.tanggal;
                String waktu=mahasiswaA.waktu;
                String nama=mahasiswaA.nama;
                String alamat=mahasiswaA.alamat;
                String noHP=mahasiswaA.noHP;
                String fakultas=mahasiswaA.fakultas;
                String jurusan=mahasiswaA.jurusan;
                int biaya=mahasiswaA.biaya;
                String beasiswa=mahasiswaA.beasiswa;
                int potongan=mahasiswaA.potongan;
                int totalBiaya=mahasiswaA.totalBiaya;
                
                sql = "UPDATE daftarulang SET tanggal='"+tanggal+"',waktu='"+waktu+"',nama='"+nama+"',alamat='"+alamat+"', noHP='"+noHP+"', fakultas='"+fakultas+"',jurusan='"+jurusan+"',biaya='"+biaya+"',beasiswa='"+beasiswa+"',potongan='"+potongan+"',totalBiaya='"+totalBiaya+"' WHERE noPeserta ='"+noPeserta+"'";
                    
                if(statement.executeUpdate(sql) > 0){
                    System.out.println("Berhasil memperbaharui data dengan nomor peserta "+noPeserta+"");
                }
                }
                statement.close(); 
                lanjut = false;
                break;
        case "2":
                System.out.print("\n---------------------------------------------------------"+"\n");
                String teks3="Program Daftar Ulang Mahasiswa D4";
                System.out.print("\t" + teks3.toUpperCase() +    "\n");
                System.out.print("---------------------------------------------------------"+"\n");
                lihatData();
                Scanner terimaInput2 = new Scanner (System.in);  
                System.out.print("\nMasukkan nomor peserta yang akan di update: ");
                noPeserta=Integer.parseInt(terimaInput2.nextLine());
                
                sql= "SELECT * FROM daftarulang WHERE noPeserta = " +noPeserta;
                
                Statement statement2 = conn.createStatement();
                ResultSet result2 = statement2.executeQuery(sql);
                
                if(result2.next()){
                    DaftarUlangD4 mahasiswaB=new DaftarUlangD4();

                    mahasiswaB.Tanggal();
                    mahasiswaB.Waktu();
                    mahasiswaB.NoPeserta();
                    mahasiswaB.Nama();
                    mahasiswaB.Alamat();
                    mahasiswaB.NoHP();
                    System.out.println(mahasiswaB.JenisFakultas());
                    mahasiswaB.Fakultas();
                    mahasiswaB.Jurusan();
                    mahasiswaB.Rincian();
                    System.out.println(mahasiswaB.JenisBeasiswa());
                    mahasiswaB.Beasiswa();
                    mahasiswaB.Potongan();
                    mahasiswaB.TotalBiaya();
            
                    String tanggal=mahasiswaB.tanggal;
                    String waktu=mahasiswaB.waktu;
                    String nama=mahasiswaB.nama;
                    String alamat=mahasiswaB.alamat;
                    String noHP=mahasiswaB.noHP;
                    String fakultas=mahasiswaB.fakultas;
                    String jurusan=mahasiswaB.jurusan;
                    int biaya=mahasiswaB.biaya;
                    String beasiswa=mahasiswaB.beasiswa;
                    int potongan=mahasiswaB.potongan;
                    int totalBiaya=mahasiswaB.totalBiaya;
            
                
                sql = "UPDATE daftarulang SET tanggal='"+tanggal+"',waktu='"+waktu+"',nama='"+nama+"',alamat='"+alamat+"', noHP='"+noHP+"', fakultas='"+fakultas+"',jurusan='"+jurusan+"',biaya='"+biaya+"',beasiswa='"+beasiswa+"',potongan='"+potongan+"',totalBiaya='"+totalBiaya+"' WHERE noPeserta ='"+noPeserta+"'";
                    
                if(statement2.executeUpdate(sql) > 0){
                    System.out.println("Berhasil memperbaharui data dengan nomor peserta "+noPeserta+"");
                }
                }
                statement2.close(); 
                lanjut = false;
                break;
            default:
                System.err.println("\nMaaf pilihan Anda tidak tersedia\nSilakan pilih kembali (1-2)");
                lanjut = true;
            }
            }
        }
        catch (SQLException e) {
            System.err.println("Warning! Terjadi kesalahan dalam mengupdate data");
            System.err.println(e.getMessage());
        }
    }
}



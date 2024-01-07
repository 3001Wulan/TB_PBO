import java.util.Scanner;
import java.time.*;
import java.time.format.*;

//Super Class 
public class DaftarUlang implements DataMahasiswa{
	public Integer noPeserta;
    public String nama;
    public String alamat;
    public String noHP;
    public String fakultas;
    public Integer kodeFakultas;
    public String jurusan;
    public String beasiswa;
    public Integer kodeBeasiswa;
    public Integer biaya;
    public Integer potongan;
    public Integer totalBiaya;
	public String tanggal;
	public String waktu;

    //Constructor
    public DaftarUlang(){
        this.noPeserta=0;
        this.nama="";
        this.alamat="";
        this.noHP="";
        this.fakultas="";
        this.jurusan="";
        this.beasiswa="";
        this.biaya=0;
        this.potongan=0;
        this.totalBiaya=0;
    }

	Scanner keyboard= new Scanner(System.in);
	Scanner you=new Scanner(System.in);

    //Date
    public String Tanggal(){
		LocalDate date = LocalDate.now();
		DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		this.tanggal = date.format(frmt);
		return this.tanggal;
	}

	public String Waktu(){
		LocalTime date = LocalTime.now();
	    DateTimeFormatter frmt1 = DateTimeFormatter.ofPattern("HH:mm:ss");
		this.waktu = date.format(frmt1);
		return this.waktu;
	}

    public void NoPeserta(){
		System.out.print("Masukkan nomor peserta : ");
		noPeserta=keyboard.nextInt();
	}

    public void Nama(){
		System.out.print("\n" + "Masukkan nama          : ");
		nama=you.nextLine();
	}

    public void Alamat(){
		System.out.print("\n" + "Masukkan alamat        : ");
		alamat=you.nextLine();
	}

    public void NoHP(){
        System.out.print("\n" + "Masukkan noHp          : ");
		noHP=keyboard.nextLine();
	}

    public String JenisFakultas(){
        return "\n" + "Fakultas di Universitas 123" + "\n"+
        "1. Fakultas Ekonomi dan Bisnis" + "\n"+
        "2. Fakultas Kedokteran" + "\n"+
        "3. Fakultas Pertenakan" + "\n" +
        "4. Fakultas Teknik" + "\n" +
        "5. Fakultas FMIPA" ;
    }

    public void Fakultas(){
		System.out.print("\n" +"Masukkan fakultas          : ");
		kodeFakultas=keyboard.nextInt();
	}

    public void Rincian() {
        
    }

    public void Jurusan(){
		System.out.print("\n" +"Masukkan jurusan        : ");
		jurusan=keyboard.nextLine();
	}

    public String JenisBeasiswa(){
        return "\n" + "Beasiswa di Universitas 123" + "\n"+
        "1. Bidik Misi" + "\n"+
        "2. Beasiswa Pemerintah Provinsi" + "\n"+
        "3. Beasiswa Bank Rajawali" + "\n" +
        "Note : Jika Anda tidak ada beasiswa maka masukkan pilihan 4" ;
    }

    public void Beasiswa(){
		System.out.print("\n" +"Masukkan jenis beasiswa (1/2/3/4): ");
		kodeBeasiswa=keyboard.nextInt();
	}

    public void Potongan() {
        
    }

    //Proses Matematika
    public void TotalBiaya(){
        totalBiaya=biaya-potongan; 
    } 
}

import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.*;
import java.time.format.*;

//Child Class
//Inheritance
public class DaftarUlangD4 extends DaftarUlang {

    //Constructor
    public DaftarUlangD4(){
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

    @Override
    public void NoPeserta(){
        boolean kondisi=true;
		do{	
		try{
		System.out.print("\n" + "Masukkan nomor peserta : ");
		noPeserta=keyboard.nextInt();
        kondisi=false;
		}
		catch(InputMismatchException ex){
			System.out.println("Inputan anda salah! Nomor peserta hanya bisa diisi angka");
			keyboard.nextLine();
		}
		}while(kondisi);
	}

    @Override
    public void Nama(){
        boolean kondisi=true;
		do{	
		try{
		System.out.print("\n" + "Masukkan nama          : ");
		nama=you.nextLine();
        if(!nama.matches("^[a-zA-Z ]*$")) throw new Exception();
		kondisi=false;
		}
		catch(Exception e){
			System.out.println("Inputan anda salah! Nama hanya bisa diisi huruf");
			keyboard.nextLine();
		}
		}while(kondisi);
	}

    @Override
    public void Alamat(){
        boolean kondisi=true;
		do{	
		try{
		System.out.print("\n" + "Masukkan alamat        : ");
		alamat=you.nextLine();
        if(!alamat.matches("^[a-zA-Z0-9 ]*$")) throw new Exception();
		kondisi=false;
		}
		catch(Exception e){
			System.out.print("Inputan anda salah! Alamat hanya bisa diisi huruf dan angka");
			keyboard.nextLine();
		}
		}while(kondisi);
	}

    @Override
    public void NoHP(){
        boolean kondisi=true;
		do{	
		try{
        System.out.print("\n" + "Masukkan noHp          : ");
		noHP=you.nextLine();
        if(!noHP.matches("^[0-9 ]*$")) throw new Exception();
		kondisi=false;
		}
		catch(Exception e){
			System.out.print("Inputan anda salah! Nomor HP bisa diisi angka");
			keyboard.nextLine();
		}
		}while(kondisi);
	}

    @Override
    public void Fakultas(){
        boolean kondisi=true;
		do{	
            try{
            System.out.print("\n" +"Masukkan fakultas       : ");
            kodeFakultas=keyboard.nextInt();
            if (kodeFakultas<=0|| kodeFakultas>5) throw new Exception();
            kondisi=false;
            }
            catch(InputMismatchException e){
                System.out.print("Inputan anda salah! Fakultas hanya bisa diisi angka" + "\n");
                keyboard.nextLine();
            }
            catch(Exception e){
                System.out.print("Inputan anda salah! Fakultas hanya bisa diisi angka 1-5" + "\n");
                keyboard.nextLine();
            }
		}while(kondisi);
	}

    //Percabangan
    @Override
    public void Rincian(){
        if(kodeFakultas==1){
			fakultas="Fakultas Ekonomi dan Bisnis";
            biaya=1000000;
		}
		else if(kodeFakultas==2){
			fakultas="Fakultas Kedokteran";
            biaya=25000000;
		}
		else if(kodeFakultas==3){
			fakultas="Fakultas Pertenakan";
            biaya=8000000;
		}
		else if(kodeFakultas==4){
			fakultas="Fakultas Teknik";
            biaya=15000000;
		}
		else if(kodeFakultas==5){
			fakultas="Fakultas FMIPA";
            biaya=20000000;
		}
    }

    @Override
    public void Jurusan(){
        boolean kondisi=true;
		do{	
		    try{
                System.out.print("\n" +"Masukkan jurusan        : ");
                jurusan=you.nextLine();
                if(!jurusan.matches("^[a-zA-Z ]*$")) throw new Exception();
		        kondisi=false;
		    }
		    catch(Exception e){
			System.out.println("Inputan anda salah! jurusan hanya bisa diisi huruf");
			keyboard.nextLine();
		    }
		}while(kondisi);
	}

    @Override
    public void Beasiswa(){
		boolean kondisi=true;
		do{	
            try{
            System.out.print("\n" +"Masukkan jenis beasiswa (1/2/3/4): ");
            kodeBeasiswa=keyboard.nextInt();
            if (kodeBeasiswa<=0|| kodeBeasiswa>4) throw new Exception();
            kondisi=false;
            }
            catch(InputMismatchException e){
                System.out.print("Inputan anda salah! Beasiswa hanya bisa diisi angka" + "\n");
                keyboard.nextLine();
            }
            catch(Exception e){
                System.out.print("Inputan anda salah! Beasiswa hanya bisa diisi angka 1-4" + "\n");
                keyboard.nextLine();
            }
		}while(kondisi);
	}

    //Percabangan
    @Override
    public void Potongan(){
        if(kodeBeasiswa==1){
            potongan=potongan+biaya;
            beasiswa="Bidik Misi";
        }
        else if(kodeBeasiswa==2){
            Double pengali=0.5;
            potongan=(int)(biaya*pengali); //Proses Matematika
            beasiswa="Beasiswa Pemerintah Provinsi";
        }
        else if(kodeBeasiswa==3){
            potongan=5000000;
            beasiswa="Beasiswa Rajawali";
        }
        else if(kodeBeasiswa==4){
            potongan=0;
            beasiswa="Tidak Ada";
        }
    }

    public void TotalBiaya(){
        totalBiaya=biaya-potongan; 
    } 

    public String Tampil(){
        String teks2="Daftar Ulang Mahasiswa D4";
        String teks3="Bukti daftar Ulang Telah Dicetak";
        return "\n" +
        "--------------------------------------------------------" + "\n" +
        "\t\t" +teks2.toUpperCase() + "\n" +
        "--------------------------------------------------------" + "\n" +
		"Tanggal           : " + Tanggal() + "\n" +
		"Waktu             : " + Waktu() + "\n" +
        "Nomor Peserta     : " + this.noPeserta + "\n" +
        "Nama              : " + this.nama + "\n" +
        "Alamat            : " + this.alamat + "\n" +
        "No HP             : " + this.noHP + "\n" +
        "Fakultas          : " + this.fakultas + "\n" +
        "Jurusan           : " + this.jurusan + "\n" +
        "Biaya             : Rp." + this.biaya + "\n"+
        "Beasiswa          : " + this.beasiswa + "\n"+
        "Potongan          : Rp." + this.potongan + "\n"+
        "Total Biaya       : Rp." + this.totalBiaya + "\n"+
        "--------------------------------------------------------" + "\n" +
        teks3.toLowerCase() + "\n" +
        "--------------------------------------------------------";
    }
}

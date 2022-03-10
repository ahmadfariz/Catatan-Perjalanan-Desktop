/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author crYptONE
 */
public class javasession {
    private static String nik;
    private static String nama;
    private static String alamat;
    private static String jenkel;
    private static String image;
    
    public static String get_Nik(){
        return nik;
    }
    public static void set_Nik(String nik){
        javasession.nik = nik;
    }
    
    public static String get_Nama(){
        return nama;
    }
    public static void set_Nama(String nama){
        javasession.nama = nama;
    }
    
    public static String get_Alamat(){
        return alamat;
    }
    public static void set_Alamat(String Alamat){
        javasession.alamat = alamat;
    }
    
    public static String get_Jenkel(){
        return alamat;
    }
    public static void set_Jenkel(String Jenkel){
        javasession.jenkel= jenkel;
    }
    
    public static String get_Image() {
        return image;
    }
    public void set_Image(String Image) {
        javasession.image = image;
    }
}

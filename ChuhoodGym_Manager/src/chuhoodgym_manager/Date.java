/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuhoodgym_manager;

import java.util.Scanner;

/**
 *
 * @author Tran Nhan Nghia
 */
public class Date {
    //thuoc tinh
	private int ngay;
	private int thang;
	private int nam;
	
	//phuong thuc
	public Date() {
		ngay=0;
		thang=0;
		nam=0;
	}
	public Date(int ngay, int thang, int nam) {
		this.ngay=ngay;
		this.thang=thang;
		this.nam=nam;
	}
	public void hienThi() {
		System.out.println(ngay+"/"+thang+"/"+nam);
	}
	public void nhap() {
		Scanner sc= new Scanner(System.in);
		do {
			System.out.print("Nhap ngay: "); ngay= sc.nextInt();
			System.out.print("Nhap thang: "); thang= sc.nextInt();
			System.out.print("Nhap nam: "); nam= sc.nextInt();
		}while(!hopLe());
	}
	public boolean hopLe() {
		boolean h= false;
		int month[]= {31,28,31,30,31,30,31,31,30,31,30,31};
		if(nam%4==0) month[1]=29;
		if(ngay>0 && ngay<=month[thang-1] && thang>0 && thang<13 && nam>0) h=true;
		return h;
	}
	public Date ngayHomSau() {
            int month[]= {31,28,31,30,31,30,31,31,30,31,30,31};
            Date d= new Date(ngay, thang, nam);
            if(ngay== month[thang-1]){
                if(thang==12){
                    d.ngay=1;
                    d.thang=1;
                    d.nam=nam++;
                }
                else{
                    d.ngay=1;
                    d.thang=thang++;
                }
            }
            else{
                d.ngay=ngay++;
            }
            return d;
	}
        
	public Date congNgay(int n) {
		Date d= new Date(ngay, thang, nam);
		for(int i=0;i<n;i++) {
			d=d.ngayHomSau();
		}
		return d;
	}
	public int layNgay() {
		return ngay;
	}
	public int layThang() {
		return thang;
	}
	public int layNam() {
		return nam;
	}
        
        
        public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Date a= new Date();
		Date b= new Date(24,1,2000);
		a.hienThi();
		b.hienThi();
		a.nhap();
		a.hienThi();
		System.out.print("\nNgay Hom Sau: ");
		a.ngayHomSau();
		a.hienThi();
		System.out.print("\nCong ngay: ");
		System.out.print("\nNhap so ngay cong vao: "); int congNgay= sc.nextInt();
		a.congNgay(congNgay).hienThi();
		
	}
        
}

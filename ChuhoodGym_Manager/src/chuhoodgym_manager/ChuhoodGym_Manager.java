/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuhoodgym_manager;

import java.util.Scanner;
import chuhoodgym_manager.Date;

/**
 *
 * @author Tran Nhan Nghia
 */
public class ChuhoodGym_Manager {

    /**
     * @param args the command line arguments
     */
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

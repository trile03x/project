/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package billmanage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class BillList {

    ArrayList<Bill> arr = new ArrayList<>();
    int n;

    BillList() {

    }

    public BillList(int n) {
        this.n = n;
    }

    public ArrayList<Bill> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Bill> arr) {
        this.arr = arr;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void SaveBill(ArrayList<Bill> trr) {
        try {
            FileWriter fw = new FileWriter("DataBill.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Bill o : trr) {

                bw.write(o.toString());
                bw.newLine();

            }
            bw.close();
            fw.close();

        } catch (Exception e) {

        }
    }

    public ArrayList<Bill> ReadBill() {
        try {
            FileReader fr = new FileReader("DataBill.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;

                }
                String txt[] = line.split(";");
                String code = txt[0];
                String type = txt[1];
                double oldindex = Double.parseDouble(txt[2]);
                double newindex = Double.parseDouble(txt[3]);
                Bill f1 = new Bill(code, type, oldindex, newindex);
                arr.add(f1);

            }
        } catch (Exception e) {

        }
        return arr;
    }

    // check file đã lưu
    public void doc() {
        for (Bill o : arr) {
            System.out.println(o.toString());
        }
    }

    public void AddNewBill() {
        ReadBill();
        Scanner sc = new Scanner(System.in);
        System.out.println("* Enter number bill want to add in list bill :");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("@ Bill " + (i + 1) + " :");
            Bill f = new Bill();
            System.out.println("- Enter customer code : ");
            sc.nextLine();
            f.setCode(sc.nextLine());
            for (int j = 0; j < arr.size(); j++) {
                if (f.getCode().equals(arr.get(j).getCode())) {
                    System.out.println(" Code used, please re - enter :");
                    f.setCode(sc.nextLine());
                }
            }
            System.out.println("- Enter customer type : ");
            f.setType(sc.nextLine());
            System.out.println("- Enter old index of electricity meter : ");
            f.setOldindex(sc.nextDouble());
            System.out.println("- Enter new index of electricity meter : ");
            f.setNewindex(sc.nextDouble());
            arr.add(f);
        }

    }

    public void AddBill(Bill b) {
        arr.add(b);
    }

    public void FindBill() {
        Scanner sc = new Scanner(System.in);
        System.out.println("* Enter code customer to find :");
        String str = sc.nextLine();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getCode().equals(str)) {
                System.out.println("@ Bill " + (i + 1) + " :");
                arr.get(i).display();

            }
        }
    }

    public double SumBill() {
        Scanner sc = new Scanner(System.in);
        System.out.println("* Enter type customer to compute total :");
        String str = sc.nextLine();
        double sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getType().equals(str)) {
                sum += arr.get(i).Payment();
            }
        }
        return sum;

    }

    public void ClearBill() {
        File file = new File("Bill.txt");
        file.delete();
    }

    public void RemoveBill() {
        Scanner sc = new Scanner(System.in);
        System.out.println("* Enter code customer to delete :");
        String str = sc.nextLine();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getCode().equals(str)) {
                arr.remove(i);
                break;
            }
        }
        System.out.println("* List bill then delete :");
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).display();
        }
        SaveBill(arr);
    }

    public ArrayList<Bill> MaxPayment(ArrayList<Bill> arr) {
        double max = 0;
        Bill p = new Bill();
        ArrayList<Bill> trr = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).Payment() >= max) {
                max = arr.get(i).Payment();
                p = arr.get(i);
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).Payment() == max) {
                trr.add(arr.get(i));
            }
        }
        return trr;

    }
        public ArrayList<Bill> MinPayment(ArrayList<Bill> arr) {
        double min = arr.get(0).Payment();
        Bill p = new Bill();
        ArrayList<Bill> trr = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).Payment() <= min) {
                min = arr.get(i).Payment();
                p = arr.get(i);
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).Payment() == min) {
                trr.add(arr.get(i));
            }
        }
        return trr;

    }
}

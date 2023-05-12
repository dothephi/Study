package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tools.MyTool;
import mng.LogIn;

/**
 *
 * @author PhiDT
 */
public class DealerList extends ArrayList<Dealer> {

    LogIn loginObj = null;
    public static final String ID_FORMENT = "D\\d{3}";
    private static final String PHONEPATTERN = "\\d{9}|\\d{11}";
    private String dataFile ="";
    boolean changed = false;

    public DealerList() {
    }

    public DealerList(LogIn loginObj) {
        this.loginObj = loginObj;
    }

    private void loadDealerFromFile() {
        List<String> lines = MyTool.readLinesFromFile(dataFile);
        for (String line : lines){
             String[] parts = line.split(",");
             if(parts.length == 5 ){
             Dealer dealer = new Dealer(line);
             this.add(dealer);
             }
        }
    }

    public void initWithFile() {
        Config cR = new Config();
        dataFile = cR.getDealerFile();
        loadDealerFromFile();
    }

    private int searchDealer(String ID) {
        if (this.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getID().equalsIgnoreCase(ID)) {
                return i;
            }
        }
        return -1;
    }

    public void searchDealer() {
        String id = MyTool.readNonBlank("Enter ID: ");
        int index = searchDealer(id);
        if (index < 0) {
            System.out.println("NOT FOUND!");
        } else {
            System.out.println("Here is information: ");
            System.out.println(this.get(index));
        }
    }

    public void addDealer() {
        String ID;
        String name;
        String addr;
        String phone;
        boolean continuing;
        int pos;
        do {
            ID = MyTool.readPattern("ID of Name Dealer", ID_FORMENT);
            ID = ID.toUpperCase();
            pos = searchDealer(ID);
            if (pos >= 0) {
                System.out.println("ID is duplicated");
            }
        } while (pos >= 0);
        name = MyTool.readNonBlank("Name of new dealer").toUpperCase();
        addr = MyTool.readNonBlank("Address of new dealer");
        phone = MyTool.readPattern("Phone number", PHONEPATTERN);
        continuing = true;
        Dealer d = new Dealer(ID, name, addr, phone, continuing);
        this.add(d);
        System.out.println("New dealer has been added.");
        changed = true;
    }

    public void removeDealer() {
        String ID = MyTool.readNonBlank("Dealer's ID needs removing");
        int index = searchDealer(ID);
        if (index < 0) {
            System.out.println("NOT FOUND!");
        } else {
            this.get(index).setContinuing(false);
            System.out.println("Removed!");
            changed = true;
        }
    }

    public void updateDealer() {
        System.out.print("Dealer's ID needs updating: ");
        String ID = MyTool.SC.nextLine();
        int pos = searchDealer(ID);
        if (pos < 0) {
            System.out.println("Dealer " + ID + " not found!");
        } else {
            Dealer d = this.get(pos);
            String newName = "";
            System.out.print("new name, ENTER for omitting: ");
            newName = MyTool.SC.nextLine().trim();
            if (!newName.isEmpty()) {
                d.setName(newName);
                changed = true;
            }
            String newAddress = "";
            System.out.print("new address, ENTER for omitting: ");
            newAddress = MyTool.SC.nextLine().trim();
            if (!newAddress.isEmpty()) {
                d.setAddr(newAddress);
                changed = true;
            }
            String newPhone = "";
            System.out.print("new phone, ENTER for omitting: ");
            newPhone = MyTool.SC.nextLine().trim().toUpperCase();
            if (!newPhone.isEmpty()) {
                boolean check = MyTool.validStr(newPhone, PHONEPATTERN);
                if (check == true) {
                    d.setPhone(newPhone);
                    changed = true;
                } else {
                    boolean checkAgain = true;
                    do {
                        newPhone = MyTool.readNonBlank("Enter Number Phone");
                        checkAgain = MyTool.validStr(newPhone, PHONEPATTERN);
                    } while (checkAgain == false);
                    d.setPhone(newPhone);
                    changed = true;
                }
            }
            System.out.println("Update " + ID + " Completed!");
        }
    }

    public void printAllDealers() {
        if (this.isEmpty()) {
            System.out.println("Empty List!");
        } else {
            Collections.sort(this);
            for (int i = 0; i < this.size(); i++) {
                System.out.println(this.get(i));
            }
        }
    }

    public void printContinuingDealers() {
        if (this.isEmpty()) {
            System.out.println("Empty List!Nothing to print.");
        } else {
            for (int i =0; i < this.size(); i++){
                if (this.get(i).isContinuing() == true) {
                    System.out.println(this.get(i));
                }
            }
        }
    }

    public void printUnContinuingDealers() {
        if (this.isEmpty()) {
            System.out.println("Empty List!Nothing to print.");
        } else {
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).isContinuing() == false) {
                    System.out.println(this.get(i));
                }
            }
        }
    }

    public void writeDealerToFile() {
        if (changed) {
            MyTool.writeFile(dataFile, this);
            changed = false;
        }
    }

    public String getDataFile() {
        return dataFile;
    }

    public void setDataFile(String dataFile) {
        this.dataFile = dataFile;
    }

    public boolean isChanged() {
        return false;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }
}

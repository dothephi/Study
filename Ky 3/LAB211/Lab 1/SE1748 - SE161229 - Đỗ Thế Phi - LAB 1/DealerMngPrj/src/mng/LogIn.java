package mng;

import data.Account;
import data.AccountChecker;
import data.DealerList;
import tools.MyTool;

/**
 *
 * @author PhiDT
 */
public class LogIn {
    private Account acc = null;
    public LogIn(Account acc) {
        this.acc = acc;
    }
    public static Account inputAccount() {
        System.out.println("Pleas Login to System.");
        String userName = MyTool.readNonBlank("Your account name");
        String password = MyTool.readNonBlank("Your password");
        String role = MyTool.readNonBlank("Your role");
        Account acc = new Account(userName, password, role);
        return acc;
    }

    public Account getAcc() {
        return acc;
    }

    public static void main(String[] args) {
        Account acc = null;
        boolean cont;
        boolean valid;
        do {
            cont = false;
            valid = false;
            AccountChecker accChk = new AccountChecker();
            acc = inputAccount();
            valid = accChk.check(acc);
            if (!valid) {
                cont = MyTool.readBool("Invalid account- Try again");
            }
            if (!valid && !cont) {
                System.exit(0);
            }
        } while (cont);
        LogIn loginObj = new LogIn(acc);
        if (acc.getRole().equalsIgnoreCase("ACC-1")) {
            String[] options = {"Managing dealers","     1-Add new dealer","     2-Search a dealer",
                "     3-Remove a dealer","     4-Update a dealer",
                "     5-Print all dealers","     6-Print continuing deadlers",
                "     7-Print UN-continuing deadlers","     8-Write to file",
                "     Other for quit.","     Choose [1.. 8]:"
            };
            Menu mnu = new Menu(options);
            DealerList dList = new DealerList(loginObj);
            dList.initWithFile();
            int choice = 0;
            do {
                mnu.showMenu();
                choice = mnu.getChoice("Managing dealers");
                switch (choice) {
                    case 1:
                        dList.addDealer();
                        break;
                    case 2:
                        dList.searchDealer();
                        break;
                    case 3:
                        dList.removeDealer();
                        break;
                    case 4:
                        dList.updateDealer();
                        break;
                    case 5:
                        dList.printAllDealers();
                        break;
                    case 6:
                        dList.printContinuingDealers();
                        break;
                    case 7:
                        dList.printUnContinuingDealers();
                        break;
                    case 8:
                        dList.writeDealerToFile();
                        break;
                    default:
                        if (dList.isChanged()) {
                            boolean res = MyTool.readBool("Data changed. Write to file?");
                            if (res == true) {
                                dList.writeDealerToFile();
                            }
                        }
                }
            } while (choice > 0 && choice < mnu.size());
            System.out.println("Bye,bye.See you next time.");

        }
    }
}

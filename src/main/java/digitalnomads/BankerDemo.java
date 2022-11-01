package digitalnomads;

public class BankerDemo {
    public static void main(String[] args) throws Exception {

        DemirBank atayDemirAccount = new DemirBank(123456789123l, 123456789l);
        atayDemirAccount.deposit(1000);
        System.out.println(atayDemirAccount.getBalance());

        DemirBank nurazizDB = new DemirBank(159126147236l, 123951687l);
        nurazizDB.deposit(2000);
        System.out.println(nurazizDB.getBalance());

        Bank.transferFounds(nurazizDB,atayDemirAccount,500);
        System.out.println(atayDemirAccount.getBalance());
        System.out.println(nurazizDB.getBalance());

        KyrgyzstanBank baku = new KyrgyzstanBank(123457896423l, 593156795l);

        Bank.transferFounds(nurazizDB,baku,550);
        System.out.println(nurazizDB.getBalance());
        System.out.println(baku.getBalance());
    }
}

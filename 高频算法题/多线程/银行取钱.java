// 两个人A、B，A在柜台取钱，B在ATM取钱
public class Solution {
    public static void main(String[] args) {
        Bank bank = new Bank();
        // 实例化两个人，传入同一个银行的对象
        Thread a = new PersonA(bank, "Counter");
        Thread b = new PersonB(bank, "ATM");

        a.start();
        b.start();
    }
}

class Bank {
    // 账户初始有1000元钱
    static double money = 1000;

    // 从柜台取钱
    private void Counter(double money) {
        Bank.money -= money;
        System.out.println("柜台取钱" + money + "元，还剩" + Bank.money + "元！");
    }

    // 从ATM取钱
    private void ATM(double money) {
        Bank.money -= money;
        System.out.println("ATM取钱" + money + "元，还剩" + Bank.money + "元！");
    }

    public synchronized void outMoney(double money, String mode) throws Exception {
        if (money > Bank.money) {
            // 校验余额是否充足
            throw new Exception("取款金额" + money + ",余额只剩" + Bank.money + "，取款失败");
        }
        if (Objects.equals(mode, "ATM")) {
            ATM(money);
        } else {
            Counter(money);
        }
    }
}

class PersonA extends Thread {
    Bank bank;
    String mode;

    public PersonA(Bank bank, String mode) {
        this.mode = mode;
        this.bank = bank;
    }

    @Override
    public void run() {
        while (Bank.money >= 100) {
            try {
                bank.outMoney(100, mode);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class PersonB extends Thread {
    Bank bank;
    String mode;

    public PersonB(Bank bank, String mode) {
        this.mode = mode;
        this.bank = bank;
    }

    @Override
    public void run() {
        while (Bank.money >= 200) {
            try {
                bank.outMoney(200, mode);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
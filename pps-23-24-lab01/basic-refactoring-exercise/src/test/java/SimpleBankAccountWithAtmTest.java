import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;

public class SimpleBankAccountWithAtmTest {

    private static final int FEE = 1;
    private AccountHolder accountHolder;
    private BankAccount bankAccountWithAtm;

    @BeforeEach
    void init(){
        accountHolder = new AccountHolder("Michele", "Nardini", 0);
        bankAccountWithAtm = new SimpleBankAccountWithAtm(accountHolder, 0);        
    }

    @Test
    void testInitialBalance(){
        assertEquals(0, bankAccountWithAtm.getBalance());
    }

    @Test
    void testBankAccountHolder(){
        assertEquals(accountHolder, bankAccountWithAtm.getHolder());
    }

    @Test
    void testDepositWithAtm(){
        int amount = 100;
        bankAccountWithAtm.deposit(0, amount);
        assertEquals(amount-FEE, bankAccountWithAtm.getBalance());
    }

    @Test
    void testDepositWithAtmWrongId(){
        int amount = 100;
        bankAccountWithAtm.deposit(1, amount);
        assertEquals(0, bankAccountWithAtm.getBalance());
    }

    @Test
    void testDepositWithAtmNegativeAmount(){
        int amount = -100;
        bankAccountWithAtm.deposit(0, amount);
        assertEquals(0, bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdrawWithAtm(){
        int depositAmount = 100;
        int withdrawAmount = 30;
        bankAccountWithAtm.deposit(0, depositAmount);
        bankAccountWithAtm.withdraw(0, withdrawAmount);
        assertEquals(depositAmount-withdrawAmount-2*FEE, bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdrawWithAtmWrongId(){
        int depositAmount = 100;
        int withdrawAmount = 30;
        bankAccountWithAtm.deposit(0, depositAmount);
        bankAccountWithAtm.withdraw(1, withdrawAmount);
        assertEquals(depositAmount-FEE, bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdrawWithAtmAmountHigherThanBalance(){
        int depositAmount = 100;
        int withdrawAmount = 150;
        bankAccountWithAtm.deposit(0, depositAmount);
        bankAccountWithAtm.withdraw(0, withdrawAmount);
        assertEquals(depositAmount-FEE, bankAccountWithAtm.getBalance());
    }

}
